package com.green1st.mandalartWeb.user;

import com.green1st.mandalartWeb.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //중복체크
    DuplicateEmailRes checkEmailPw(String userId);
    DuplicateNickNameRes checkNickName(String nickName);
    UserUpdateRes checkPassWord(String userId);

    //회원가입
    int insUser(UserSignUpReq p);

    //이메일 코드 저장용 insert
    int insAuth(AuthKeyDto p);

    //이메일 코드 검증용 select
    EmailVerification selAuth(AuthKeyDto p);

    //이메일 코드 제거용 delete
    int delAuth(AuthKeyDto p);

    //코드 오류시 유저정보 삭제
    int delUserFirst(AuthKeyDto p);

    //로그인 전 인증했는지 체크
    int checkCode(String userId);

    //로그인
    UserSignInRes selUser(UserSignInReq p);
    List<LoginDto> selUserList(UserSignInReq p);

    //정보조회
    UserInfoGetRes selUserInfo(UserInfoGetReq p);

    //정보수정
    int updUser(UserUpdateReq p);


    //삭제를 위한 비밀번호 selet
    UserDeleteRes checkPassWord2(UserDeleteReq p);

    //내가 좋아요 한거, 댓글단거 삭제
    int delMyLikeAndComment(UserDeleteReq p);
    //공유 프로젝트 좋아요, 댓글 삭제
    int delSharedProjectLikeAndComment(UserDeleteReq p);
    //공유 프로젝트 삭제
    int delSharedProject(UserDeleteReq p);
    //만다라트 삭제
    int delMandalart(UserDeleteReq p);
    //프로젝트 삭제
    int delProject(UserDeleteReq p);
    //임시비밀번호 데이터 삭제
    int delFindPw(UserDeleteReq p);
    //유저 삭제
    int delUser(UserDeleteReq p);


// ////////
// 임시 비밀번호 발급
    String checkPasswordId(String userId);

    int updTmpPassword(TempPasswordDto tempPasswordDto);

    int insPassword2(TempPasswordDto tempPasswordDto);

    int updTmpPwFg(TempPasswordDto tempPasswordDto);

    int selTmpPwFg(String userId);

    int updTmpPasswordReissue(TempPasswordDto tempPasswordDto);



}
