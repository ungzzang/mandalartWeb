package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Schema(title = "만다라트 조회 정보")
@Setter
@ToString
public class MandalartGetRes {
    private long mandalartId;
    private long parentId;
    private String title;
    private String contents;
    private int completedFg;
    private String bgColor;
    private int depth;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int orderId;
    private double completedPer;
}
