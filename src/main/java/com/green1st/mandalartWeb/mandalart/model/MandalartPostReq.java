package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostReq {
//    private long projectId;
    @PositiveOrZero(message = "만다라트 ID는 0 이상이어야 합니다.")
    private long mandalartId;
    @NotEmpty(message = "목표를 입력해주세요")
    private String title;
    private String contents;
    private Boolean completedFg;
    private LocalDate startDate;
    private LocalDate finishDate;
}
