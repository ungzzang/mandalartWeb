package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Getter
@Schema(title = "유저 정보 GET 요청")
@ToString
public class UserInfoGetReq {
    @Schema(title = "로그인한 유저 이메일", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;

    public UserInfoGetReq(String userId) {
        this.userId = userId;
    }
}
