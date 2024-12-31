package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@Slf4j
public class MandalartGetReq {
    @Schema(description = "프로젝트 id")
    @NotNull
    @Positive(message = "프로젝트 ID는 양수만 가능합니다.")
    private long projectId;

    public void setProjectId(long projectId) {

        this.projectId = projectId;
    }
}
