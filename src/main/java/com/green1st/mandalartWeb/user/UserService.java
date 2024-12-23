package com.green1st.mandalartWeb.user;

import com.green1st.mandalartWeb.common.MyFileUtils;
import com.green1st.mandalartWeb.user.duplicate.DuplicateService;
import com.green1st.mandalartWeb.user.duplicate.model.DuplicateReq;
import com.green1st.mandalartWeb.user.duplicate.model.DuplicateRes;
import com.green1st.mandalartWeb.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final MyFileUtils myFileUtils;
    private final DuplicateService duplicateService;
    private final UserMessage userMessage;

    //회원가입
    public int postSignUp(MultipartFile pic, UserSignUpReq p){
        if(duplicateService.checkEmail(p.getUserId()).getCheck() == 0){
            userMessage.setMessage("이메일중복체크를 해주세요.");
            return 0;
        } else if(duplicateService.checkNickName(p.getNickName()).getCheck() == 0){
            userMessage.setMessage("닉네임중복체크를 해주세요.");
            return 0;
        }

        String savedPicName = (pic != null ? myFileUtils.makeRandomFileName(pic) : null);
        String hashedPassWord = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setPic(savedPicName);
        p.setUpw(hashedPassWord);

        int result = userMapper.insUser(p);
        if(pic == null){
            return result;
        }

        String userId = p.getUserId();
        String middlePath = String.format("user/%s", userId); //userId = 이메일
        myFileUtils.makeFolders(middlePath);
        String filePath = String.format("%s/%s", middlePath, savedPicName);

        try{
            myFileUtils.transferTo(pic, filePath);
        }catch (IOException e){
            e.printStackTrace();
        }
        userMessage.setMessage("회원가입이 완료되었습니다.");
        return result;

    }

    //로그인
    public UserSignInRes postSignIn(UserSignInReq p){
        UserSignInRes res = userMapper.selUser(p);

        if(res == null || !BCrypt.checkpw(p.getUpw(), res.getUpw())){
            res = new UserSignInRes();
            res.setMessage("아이디 혹은 비밀번호를 확인해 주십시오.");
            return res;
        }

        res.setMessage("로그인성공");
        return res;
    }

    //회원정보조회
    public UserInfoGetRes getUserInfo(UserInfoGetReq p){
        return userMapper.selUserInfo(p);
    }

    //회원정보수정
    public int patchUser(UserUpdateReq p){
        // 이메일, 비밀번호 일치 여부 확인

        if(duplicateService.checkEmail(p.getUserId()).getCheck() == 0){
            userMessage.setMessage("이메일이 일치하지않습니다.");
            return 0;
        }

        //*여기한번 검토*
        if(!BCrypt.checkpw(p.getUpw(), duplicateService.checkPassword(p.getUserId()).getEncUpw())){
            userMessage.setMessage("비밀번호가 일치하지않습니다.");
            return 0;
        }

        // 비밀번호 바꿀시
        if(p.getNewUpw() != null) {
            if (p.getNewUpw() != p.getCheckUpw()) {
                userMessage.setMessage("비밀번호를 다시 입력해주십시오.");
                return 0;
            }
            String hashedPassWord = BCrypt.hashpw(p.getNewUpw(), BCrypt.gensalt());
            p.setNewUpw(hashedPassWord);
        }

        // 닉네임 바꿀시
        if(p.getNickName() != null) { //*여기검토*
            DuplicateRes duplicateRes = duplicateService.checkNickName(p.getNickName());
            if(duplicateRes != null){
                userMessage.setMessage("중복된 닉네임입니다.");
                return 0;
            }
        }

        //저장할 파일명(랜덤명 파일명) 생성
        String savedPicName = (p.getPic() != null ? myFileUtils.makeRandomFileName(p.getPic()) : null);
        p.setPicName(savedPicName);

        if(p.getPic() != null) {
            //폴더 생성
            String folderPath = String.format("user/%s", p.getUserId());
            myFileUtils.makeFolders(folderPath);

            //기존 파일 삭제
            String deletePath = String.format("%s/user/%s", myFileUtils.getUploadPath(), p.getUserId());
            myFileUtils.deleteFolder(deletePath, false);

            //원하는 위치에 저장할 파일명으로 파일을 이동(transferTo)
            String userId = p.getUserId();
            String filePath = String.format("user/%s/%s", userId, savedPicName);

            try {
                myFileUtils.transferTo(p.getPic(), filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // DB에 튜플을 수정(Update)
        int result = userMapper.updUser(p);

        userMessage.setMessage("회원수정이 완료되었습니다.");
        return result;
    }

    //회원삭제
    public int deleteUser(UserDeleteReq p){
        UserSignInReq req = new UserSignInReq();
        UserSignInRes res = userMapper.selUser(req);
        UserDeleteRes userDeleteRes = new UserDeleteRes();
        if(res == null || !BCrypt.checkpw(p.getUpw(), res.getUpw())){
            userDeleteRes.setMessage("아이디 혹은 비밀번호를 확인해 주십시오.");
            return 0;
        }

        //구성요소들 삭제
        int deleteLikeComment = userMapper.delProjectLikeAndProjectComment(p);
        log.info("deleteLikeComment: {}", deleteLikeComment);
        int deleteSharedProject = userMapper.delSharedProject(p);
        log.info("deleteSharedProject: {}", deleteSharedProject);
        int deleteMandalart = userMapper.delMandalart(p);
        log.info("deleteMandalart: {}", deleteMandalart);
        int deleteProject = userMapper.delProject(p);
        log.info("deleteProject: {}", deleteProject);
        int deleteUser = userMapper.delUser(p);
        log.info("deleteUser: {}", deleteUser);

        //사진 삭제 (폴더 삭제)
        String deletePath = String.format("%s/user/%s", myFileUtils.getUploadPath(), p.getUserId());
        myFileUtils.deleteFolder(deletePath, true);

        userDeleteRes.setMessage("회원삭제가 완료되었습니다.");
        return 1;
    }
    //데이터 내 정보로 할때 객체 선언하면 새로운거라서 다시 수정필요.
}
