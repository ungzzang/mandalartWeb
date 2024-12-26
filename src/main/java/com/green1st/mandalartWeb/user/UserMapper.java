package com.green1st.mandalartWeb.user;

import com.green1st.mandalartWeb.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    DuplicateEmailRes checkEmailPw(String userId);
    DuplicateNickNameRes checkNickName(String nickName);

    int insUser(UserSignUpReq p);
    UserSignInRes selUser(UserSignInReq p);

    UserInfoGetRes selUserInfo(UserInfoGetReq p);

    int updUser(UserUpdateReq p);
    UserUpdateRes selUser2(String userId);

    int delProjectLikeAndProjectComment(UserDeleteReq p);
    int delSharedProject(UserDeleteReq p);
    int delMandalart(UserDeleteReq p);
    int delProject(UserDeleteReq p);
    int delUser(UserDeleteReq p);

// 임시 비밀번호 발급
    String checkPasswordId(String userId);
    int insPassword(TempPasswordDto tempPassword);
}
