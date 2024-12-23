package com.green1st.mandalartWeb.user.duplicate.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateReq {
    @Schema(title = "이메일", description = "중복체크할 이메일")
    private String userId;
    @Schema(title = "닉네임", description = "중복체크할 닉네임")
    private String nickName;
    @Schema(title = "비밀번호", description = "본인확인용 비밀번호")
    private String upw;
}
