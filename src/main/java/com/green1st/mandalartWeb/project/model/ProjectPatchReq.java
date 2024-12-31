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
public class ProjectPatchReq {
    @Positive(message = "프로젝트 아이디는 0이상이어야 합니다.")
    @NotNull(message = "프로젝트 아이디는 빈값일 수 없습니다.")
    @Schema(description = "수정할 프로젝트 아이디", example = "test@gamil.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long projectId;
    @NotNull(message = "로그인한 사용자 아이디는 빈값일 수 없습니다.")
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 아이디", example = "test@gamil.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
    @Schema(description = "프로젝트 제목", example = "프로젝트 제목 입니다.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Length(max = 50)
    private String title;
    @Schema(description = "프로젝트 내용", example = "프로젝트 내용 입니다.")
    @Length(max = 500)
    private String content;
    @JsonIgnore
    private String pic;
}
