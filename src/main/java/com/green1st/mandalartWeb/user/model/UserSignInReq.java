package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInReq {
    @Schema(title = "유저이메일")
    private String userId;
    @Schema(title = "유저비밀번호")
    private String upw;
}
