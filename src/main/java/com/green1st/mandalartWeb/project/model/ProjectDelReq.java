package com.green1st.mandalartWeb.project.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Schema(description = "프로젝트 삭제 모델")
public class ProjectDelReq {
    @NotNull
    @Positive
    @Schema(description = "삭제할 프로젝트 PK")
    private long projectId;
    @NotNull
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 PK")
    private String userId;
}
