package com.green1st.mandalartWeb.user.duplicate;

import com.green1st.mandalartWeb.user.duplicate.model.DuplicateRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DuplicateMapper {
    DuplicateRes checkEmail(String userId);
    DuplicateRes checkNickName(String nickName);
}
