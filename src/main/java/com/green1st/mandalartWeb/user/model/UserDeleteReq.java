package com.green1st.mandalartWeb.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
@Schema(title = "유저 삭제")
public class UserDeleteReq {
    @Schema(description = "유저 이메일(PK)", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(description = "비밀번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;
    /*@Schema(description = "프로젝트 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long projectId;*/

    /*@ConstructorProperties("project_id")
    public UserDeleteReq(long projectId) {
        this.projectId = projectId;
    }*/
}
