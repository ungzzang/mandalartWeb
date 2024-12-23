package com.green1st.mandalartWeb.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UserUpdateReq {
    @Schema(title = "유저이메일", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(title = "기존비밀번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    @Schema(title = "신규비밀번호")
    private String newUpw;
    @Schema(title = "비밀번호확인")
    private String checkUpw;
    @Schema(title = "바꿀닉네임")
    private String nickName;
    @Schema(title = "프로필등록")
    private MultipartFile pic;

    @JsonIgnore
    private String picName;
}
