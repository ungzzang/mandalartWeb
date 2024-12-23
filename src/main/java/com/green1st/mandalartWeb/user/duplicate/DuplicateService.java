package com.green1st.mandalartWeb.user.duplicate;

import com.green1st.mandalartWeb.user.duplicate.model.DuplicateRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DuplicateService {
    private final DuplicateMapper duplicateMapper;

    //이메일 중복체크
    public DuplicateRes checkEmail(String userId){
        DuplicateRes res = duplicateMapper.checkEmail(userId);

        if(res == null){
            res.setCheck(1); //중복되는 이메일없을때
            res.setMessage("사용가능한 이메일입니다.");
            return res;
        }else {
            res.setCheck(0); //중복되는 이메일있을때
            res.setMessage("중복된 이메일입니다.");
            return res;
        }
    }

    //닉네임 중복체크
    public DuplicateRes checkNickName(String nickName){
        DuplicateRes res = duplicateMapper.checkNickName(nickName);

        if(res == null){
            res.setCheck(1); //중복되는 닉네임없을때
            res.setMessage("사용가능한 닉네임입니다.");
            return res;
        }else {
            res.setCheck(0); //중복되는 닉네임있을때
            res.setMessage("중복된 닉네임입니다.");
            return res;
        }
    }
}
