package com.green1st.mandalartWeb.shared_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SharedProjectCopyReq {
    @JsonIgnore
    private long projectId;
    @NotNull
    @Positive
    @Schema(description = "복사할 프로젝트 아이디(공유된 프로젝트여야함)", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long copyProjectId;
    @NotNull
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 아이디", example = "test@gmail.com")
    private String userId;
}
