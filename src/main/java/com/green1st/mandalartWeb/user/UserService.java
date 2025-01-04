package com.green1st.mandalartWeb.user;

import com.green1st.mandalartWeb.common.MyFileUtils;

import com.green1st.mandalartWeb.user.model.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final MyFileUtils myFileUtils;
    private final UserMessage userMessage;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private static String FROM_ADDRESS;

    //이메일 중복체크
    public DuplicateEmailRes emailChk(String userId){
        DuplicateEmailRes res = userMapper.checkEmailPw(userId);

        if(res == null){
            res = new DuplicateEmailRes();
            res.setCheck(1);
            res.setMessage("사용가능한 이메일입니다.");
            return res;
        }else {
            res.setCheck(0);
            res.setMessage("중복된 이메일입니다.");
            return res;
        }
    }

    //닉네임 중복체크
    public DuplicateNickNameRes nickNameChk(String nickName){
        DuplicateNickNameRes res = userMapper.checkNickName(nickName);

        if(res == null){
            res = new DuplicateNickNameRes();
            res.setCheck(1);
            res.setMessage("사용가능한 닉네임입니다.");
            return res;
        }else {
            res.setCheck(0);
            res.setMessage("중복된 닉네임입니다.");
            return res;
        }
    }

    //회원가입
    public int postSignUp(MultipartFile pic, UserSignUpReq p){
        System.out.println(pic);
        if(emailChk(p.getUserId()).getCheck() == 0){
            userMessage.setMessage("이메일중복체크를 해주세요.");
            return 0;
        } else if(nickNameChk(p.getNickName()).getCheck() == 0){
            userMessage.setMessage("닉네임중복체크를 해주세요.");
            return 0;
        }

        String savedPicName = (pic != null ? myFileUtils.makeRandomFileName(pic) : null);
        String hashedPassWord = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setPic(savedPicName);
        p.setUpw(hashedPassWord);

        int result = userMapper.insUser(p);
        if(pic == null){
            userMessage.setMessage("회원가입이 완료되었습니다.");
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
        userMessage.setMessage("이메일 인증 링크를 전송했습니다.");
        return result;

    }

    // 인증 코드 저장
    public void insAuthKey(AuthKeyDto p) {

        userMapper.insAuth(p);
    }

    // 인증 코드 검증
    public int selAuth(AuthKeyDto p) {
        // DB에서 인증 코드 조회
        EmailVerification record = userMapper.selAuth(p);

        if (record == null) {
            return 2;  // 해당 이메일로 저장된 인증 코드가 없으면 유효하지 않음
        }

        LocalDateTime now = LocalDateTime.now();
        if (record.getAuthKey().equals(p.getAuthKey()) && record.getExpiryTime().isAfter(now)) {
            return 1;  // 인증 코드와 만료 시간 모두 유효
        }

        return 0;  // 인증 코드가 일치하지 않거나 만료된 경우
    }

    // 인증 코드 삭제
    public void delAuthKey(AuthKeyDto p) {
        userMapper.delAuth(p);
    }

    // 인증 오류시 먼저 저장된 유저정보 삭제
    public void delUserFirst(AuthKeyDto p) {
        userMapper.delUserFirst(p);
    }


    //로그인
    public UserSignInRes postSignIn(UserSignInReq p){
        int emailVerification = userMapper.checkCode(p.getUserId());

        if(emailVerification == 1){
            UserSignInRes res = new UserSignInRes();
            res.setMessage("이메일인증을 해주세요.");
            return res;
        }

        UserSignInRes res = userMapper.selUser(p);
        log.info("조회된 회원정보: {}", res);
        if(res == null || !BCrypt.checkpw(p.getUpw(), res.getUpw())){
            res = new UserSignInRes();
            res.setMessage("아이디 혹은 비밀번호를 확인해 주십시오.");
            return res;
        }

        List<LoginDto> loginList = userMapper.selUserList(p);

        res.setMessage("로그인성공");
        return res;
    }

    //회원정보조회
    public UserInfoGetRes getUserInfo(UserInfoGetReq p){
        return userMapper.selUserInfo(p);
    }

    //회원정보수정
    public UserUpdateRes patchUser(MultipartFile pic, UserUpdateReq p) {
        UserUpdateRes res = new UserUpdateRes();

        try {
            // 이메일, 비밀번호 일치 여부 확인
            UserUpdateRes passwordCheckRes = userMapper.checkPassWord(p.getUserId());
            if (passwordCheckRes == null || !BCrypt.checkpw(p.getUpw(), passwordCheckRes.getUpw())) {
                res.setMessage("이메일 혹은 비밀번호 재확인필요");
                res.setResult(0);
                return res;
            }

            //아무것도 입력안했을 때
            if(pic ==null && p.getNickName()==null && p.getPicName()==null
                    && p.getNewUpw()==null && p.getCheckUpw()==null ){
                res.setMessage("값을 입력해 주십시오");
                res.setResult(0);
                return res;
            }

            // 비밀번호 변경 처리
            if (p.getNewUpw() != null && p.getCheckUpw() != null) {
                if (p.getNewUpw().equals(p.getCheckUpw())) {
                    String hashedPassWord = BCrypt.hashpw(p.getNewUpw(), BCrypt.gensalt());
                    p.setNewUpw(hashedPassWord);
                } else {
                    res.setMessage("비밀번호를 다시 입력해주십시오.");
                    res.setResult(0);
                    return res;
                }
            }

            // 닉네임 중복 체크
            if ( p.getNickName() != null && p.getNickName() != "" ) {
                int check = nickNameChk(p.getNickName()).getCheck();
                if (check == 0) {
                    res.setMessage("중복된 닉네임입니다.");
                    res.setResult(0);
                    return res;
                }
            }

            // 프로필 사진 처리
            if (pic != null && !pic.isEmpty()) {
                String targetDir = "user/" + p.getUserId();
                myFileUtils.makeFolders(targetDir);

                String savedFileName = myFileUtils.makeRandomFileName(pic);
                p.setPicName(savedFileName);

                // 기존 파일 삭제
                String deletePath = String.format("%s/user/%s", myFileUtils.getUploadPath(), p.getUserId());
                myFileUtils.deleteFolder(deletePath, false);

                // 파일 저장
                String filePath = String.format("%s/%s", targetDir, savedFileName);
                myFileUtils.transferTo(pic, filePath);
            }

            // 최종 수정
            int result = userMapper.updUser(p);
            res.setMessage("회원수정이 완료되었습니다.");
            res.setResult(result);
        } catch (IOException e) {
            res.setMessage("파일 업로드 중 오류 발생");
            res.setResult(0);
        }
        return res;
    }

    //유저 정보 삭제
    public UserDeleteRes deleteLikeComment(UserDeleteReq p){
        UserDeleteRes userDeleteRes = userMapper.checkPassWord2(p);

        if(userDeleteRes == null || !BCrypt.checkpw(p.getUpw(), userDeleteRes.getUpw()) ){
            userDeleteRes.setMessage("이메일 혹은 비밀번호를 확인해주세요");
            userDeleteRes.setCheck(0);
            return userDeleteRes;
        }

        userMapper.delMyLikeAndComment(p);
        userDeleteRes.setMessage("좋아요, 댓글 삭제 성공");
        userDeleteRes.setCheck(1);
        return userDeleteRes;
    }

    public void delSharedProjectLikeAndComment(UserDeleteReq p){ userMapper.delSharedProjectLikeAndComment(p); }

    public void delSharedProject(UserDeleteReq p){ userMapper.delSharedProject(p); }

    public void delMandalart(UserDeleteReq p){ userMapper.delMandalart(p); }

    public void delProject(UserDeleteReq p){ userMapper.delProject(p); }

    public void delFindPw(UserDeleteReq p){
        userMapper.delFindPw(p);
    }

    public int delUser(UserDeleteReq p){
        int result = userMapper.delUser(p);
        return result;
    }

    // 임시 비밀번호 발급
    public int tempPassword(TempPasswordDto tempPasswordDto) {
        String userId = userMapper.checkPasswordId(tempPasswordDto.getUserId());
        char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        char[] specialCharacters = "!@#$%^&*".toCharArray();
        char[] allCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*".toCharArray();

        StringBuilder tmpPasswordBuilder = new StringBuilder();
        Random random = new Random();

        // 각 조건을 만족하도록 하나씩 추가
        tmpPasswordBuilder.append(upperCaseLetters[random.nextInt(upperCaseLetters.length)]);
        tmpPasswordBuilder.append(numbers[random.nextInt(numbers.length)]);
        tmpPasswordBuilder.append(specialCharacters[random.nextInt(specialCharacters.length)]);

        // 나머지 5개 문자는 무작위로 추가
        for (int i = 0; i < 5; i++) {
            tmpPasswordBuilder.append(allCharacters[random.nextInt(allCharacters.length)]);
        }

        // 문자 배열로 변환하여 섞음
        char[] passwordArray = tmpPasswordBuilder.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        // 최종 임시 비밀번호 생성
        String tmpPassword = new String(passwordArray);

        tempPasswordDto.setTmpPassword(tmpPassword);
        String tmpPasswordOriginal = tempPasswordDto.getTmpPassword();
        int result = userMapper.insPassword2(tempPasswordDto);

        int reIssue = userMapper.updTmpPasswordReissue(tempPasswordDto);

        String hashedPassWord = BCrypt.hashpw(tempPasswordDto.getTmpPassword(), BCrypt.gensalt());
        tempPasswordDto.setTmpPassword(hashedPassWord);
        int result1 = userMapper.updTmpPassword(tempPasswordDto);

        int result2 = userMapper.updTmpPwFg(tempPasswordDto);
        int tmpPwFg = userMapper.selTmpPwFg(tempPasswordDto.getUserId());


        if(result1 == 1) {
            MimeMessage message = javaMailSender.createMimeMessage();

            try {
                message.setFrom(FROM_ADDRESS);
                message.setRecipients(MimeMessage.RecipientType.TO, userId);
                message.setSubject("임시 비밀번호 안내입니다.");
                String body = "";
                body += "<h3>" + "안녕하세요." + "</h3>";
                body += "<h3>" + "요청하신 임시 비밀번호가 생성되었습니다." + "</h3>";
                body += "<h3>" + "아래의 임시 비밀번호로 로그인하세요." + "</h3>";
                body += "<h1>" + tmpPasswordOriginal + "</h1>";
                body += "<h3>" + "감사합니다." + "</h3>";
                message.setText(body,"UTF-8", "html");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(message);
        }
        return result1;
    }
}
