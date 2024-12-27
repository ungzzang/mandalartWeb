package com.green1st.mandalartWeb.user;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Tag(name = "회원", description = "sign-in / sign-out")
public class UserController {
    private final UserService userService;
    private final UserMessage userMessage;
    private final UserSignUpReq userSignUpReq;


    //이메일 중복체크
    @GetMapping("email")
    @Operation(summary = "이메일 중복체크")
    public ResultResponse<Integer> emailChk(@ParameterObject @ModelAttribute DuplicateEmailReq p){
        DuplicateEmailRes res = userService.emailChk(p.getUserId());

        return ResultResponse.<Integer>builder()
                .statusCode(res.getCheck() == 1 ? "200" : "400")
                .resultMsg(res.getMessage())
                .resultData(res.getCheck())
                .build();
    }

    //닉네임 중복체크
    @GetMapping("nickName")
    @Operation(summary = "닉네임 중복체크")
    public ResultResponse<Integer> nickNameChk(@ParameterObject @ModelAttribute DuplicateNickNameReq p) {
        DuplicateNickNameRes res = userService.nickNameChk(p.getNickName());

        return ResultResponse.<Integer>builder()
                .statusCode(res.getCheck() == 1 ? "200" : "400")
                .resultMsg(res.getMessage())
                .resultData(res.getCheck())
                .build();
    }


    @PostMapping("signUp")
    @Operation(summary = "회원가입")
    public ResultResponse<Integer> signUpUser(@RequestPart(required = false) MultipartFile pic
                                              , @RequestPart UserSignUpReq p){
        int result = userService.postSignUp(pic, p);

        return ResultResponse.<Integer>builder()
                .statusCode(result == 1 ? "200" : "400")
                .resultMsg(userMessage.getMessage())
                .resultData(result)
                .build();
    }

    @PostMapping("signIn")
    @Operation(summary = "로그인")
    public ResultResponse<UserSignInRes> signInUser(@RequestBody UserSignInReq p) {

        UserSignInRes res = userService.postSignIn(p);

        return ResultResponse.<UserSignInRes>builder()
                .statusCode(res != null ? "200" : "400")
                .resultMsg(res.getMessage())
                .resultData(res)
                .build();
    }

    @GetMapping()
    @Operation(summary = "유저정보조회")
    public ResultResponse<UserInfoGetRes> getUserInfo(@ParameterObject @ModelAttribute UserInfoGetReq p){

        UserInfoGetRes res = userService.getUserInfo(p);

        return ResultResponse.<UserInfoGetRes>builder()
                .statusCode(res != null ? "200" : "400")
                .resultMsg("조회완료")
                .resultData(res)
                .build();
    }

    @PatchMapping
    @Operation(summary = "유저정보수정")
    public ResultResponse<Integer> patchUser(@RequestBody UserUpdateReq p) {
        UserUpdateRes res = userService.patchUser(p);

        return ResultResponse.<Integer>builder()
                .statusCode(res.getResult() == 1 ? "200" : "400")
                .resultMsg(res.getMessage())
                .resultData(res.getResult())
                .build();
    }

    /*@DeleteMapping
    @Operation(summary = "회원탈퇴")
    public ResultResponse<Integer> deleteUser(@ParameterObject @ModelAttribute UserDeleteReq p) {
        int result = userService.deleteUser(p);
        UserDeleteRes res = new UserDeleteRes();
        return ResultResponse.<Integer>builder()
                .statusCode(result == 1 ? "200" : "400")
                .resultMsg(res.getMessage())
                .build();
    }*/

    @DeleteMapping()
    @Operation(summary = "나의 좋아요 댓글 삭제")
    public ResultResponse<Integer> deleteMyLikeComment(@ParameterObject @ModelAttribute UserDeleteReq p){
        int result = userService.deleteLikeComment(p);
        return ResultResponse.<Integer>builder()
                .statusCode(result != 0 ? "200" : "400")
                .resultMsg("좋아요 댓글 삭제 완료")
                .resultData(result != 0 ? 1 : 0)
                .build();
    }


    // 임시 비밀번호 발급
    @PostMapping("password")
    @Operation(summary = "임시 비밀번호 전송")
    public ResultResponse<Integer> findPassword(@Valid @RequestBody TempPasswordDto req) {
        try {
            int result = userService.tempPassword(req);
            return ResultResponse.<Integer>builder()
                    .statusCode("200")
                    .resultMsg("임시비밀번호변경완료")
                    .resultData(result)
                    .build();
        } catch (IllegalArgumentException e) {
            // 이메일이 잘못되었거나 아이디가 없는 경우
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("아이디가 존재하지 않습니다.")
                    .resultData(0)
                    .build();
        }
    }

}
