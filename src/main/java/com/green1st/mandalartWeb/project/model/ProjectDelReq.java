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
    @NotNull(message = "프로젝트 PK는 빈 값일 수 없습니다.")
    @Positive(message = "프로젝트 PK는 0이상의 값이어야 합니다.")
    @Schema(description = "삭제할 프로젝트 PK")
    private long projectId;
    @NotNull(message = "로그인한 사용자 아이디는 빈 값일 수 없습니다.")
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 PK")
    private String userId;
}
