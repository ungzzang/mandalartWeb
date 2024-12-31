package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostRes {
    private long mandalartId;
    private long parentId;
    private String title;
    private String contents;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int completedFg;
    private int depth;
    private int orderId;
    private String bgColor;


    public MandalartPostRes(MandalartPostReq request) {
        this.mandalartId = request.getMandalartId();
        this.title = request.getTitle();
        this.contents = request.getContents();
        this.startDate = request.getStartDate();
        this.finishDate = request.getFinishDate();
        this.completedFg = request.getCompletedFg() == 0 ?  0 : 1;

    }
}