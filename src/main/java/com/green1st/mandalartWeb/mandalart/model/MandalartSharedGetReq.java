package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class MandalartSharedGetReq {
    @Schema(description = "프로젝트 id")
    @Positive(message = "프로젝트 ID는 양수만 가능합니다.")
    @NotNull
    private long projectId;
    @Schema(description = "유저 id")
    @NotNull
    private String userId;
}
