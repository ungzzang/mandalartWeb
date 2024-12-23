package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@Schema(title = "회원가입")
public class UserSignUpReq {
    @Schema(title = "유저이메일", example = "test@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(title = "유저비밀번호", example = "PassWord", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "유저닉네임", example = "hide on bush", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nickName;
    @Schema(title = "프로필사진")
    private String pic;

}
