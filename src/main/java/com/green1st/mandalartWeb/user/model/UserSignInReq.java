package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "로그인 요청")
public class UserSignInReq {
    @NotEmpty(message = "이메일을 입력해주세요.")
    @Schema(title = "유저이메일")
    private String userId;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Schema(title = "유저비밀번호")
    private String upw;
}
