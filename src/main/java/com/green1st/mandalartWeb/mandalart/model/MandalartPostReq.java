package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostReq {
    @Schema(description = "프로젝트 id")
    private long projectId;


    public void setProjectId(long projectId) {

        this.projectId = projectId;
    }
/*
    ex) lv2의 7번 칸 - lv2 7칸 - lv 8칸
    -> depth , order_id 로 따로 작성 xxx
    프론트에서 데이터를 해당 칸에 직접 입력함
    만다라트 시작 날짜 > 프로젝트 시작일 - 상위 부모의 시작일보다 더 빨리 시작 x
    만다라트 종료 날짜 > 프로젝트 종료일 - 상위 부모의 종료일보다 더 늦게 종료 x

     */
}
