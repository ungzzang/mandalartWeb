package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostReq {
    //    private long projectId;
    @NotNull
    @PositiveOrZero(message = "만다라트 ID는 0 이상이어야 합니다.")
    private long mandalartId;  // 만다라트 ID
    @Schema(description = "목표")
    private String title;
    @Schema(description = "내용")
    private String contents;
    @NotNull
    @Schema(description = "완료 여부 0(false)은 미완료 1(true)은 완료")
    private int completedFg;
    @Schema(description = "시작일")
    private LocalDate startDate;
    @Schema(description = "종료일")
    private LocalDate finishDate;
    @Schema(description = "부모 id")
    private int parentId;
}
