package com.green1st.mandalartWeb.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Schema(description = "프로젝트 등록 모델")
public class ProjectPostReq {
    @Positive
    @Schema(description = "프로젝트 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonIgnore
    private Long projectId;
    @NotNull
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 아이디", example = "test@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @NotNull
    @Length(max = 50)
    @Schema(description = "프로젝트 제목", example = "프로젝트 제목 수정 입니다.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;
    @Length(max = 500)
    @Schema(description = "프로젝트 내용", example = "프로젝트 내용 수정 입니다.")
    private String content;
}
