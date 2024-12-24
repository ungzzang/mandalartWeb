package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "닉네임 중복체크")
public class DuplicateNickNameReq {
    private String nickName;
}
