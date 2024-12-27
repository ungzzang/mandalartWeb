package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostReq {
    @Schema(description = "프로젝트 id")
    @Positive(message = "프로젝트 ID는 양수만 가능합니다.")
    private long projectId;
    @PositiveOrZero(message = "만다라트 ID는 0 이상이어야 합니다.")
    private long mandalartId;  // 만다라트 ID
    @NotEmpty(message = "목표를 입력해주세요")
    private String title;  // 제목
    private String contents;  // 내용
    @NotNull(message = "깊이는 반드시 입력해야 합니다.")
    @PositiveOrZero(message = "깊이는 0 이상이어야 합니다.")
    private Integer depth;  // 깊이
    @NotNull(message = "순서는 반드시 입력해야 합니다.")
    @PositiveOrZero(message = "순서는 0 이상이어야 합니다.")
    private Integer orderId;  // 순서
    private Boolean completedFg;  // 완료 여부
    private LocalDate startDate;  // 시작일
    private LocalDate finishDate;  // 종료일
    @PositiveOrZero(message = "부모 ID는 0 이상이어야 합니다.")
    private Long parentId;  // 부모 ID
    private String colorCode;  // 색상 코드 추가


/*
    ex) lv2의 7번 칸 - lv2 7칸 - lv 8칸
    -> depth , order_id 로 따로 작성 xxx
    프론트에서 데이터를 해당 칸에 직접 입력함
    만다라트 시작 날짜 > 프로젝트 시작일 - 상위 부모의 시작일보다 더 빨리 시작 x
    만다라트 종료 날짜 > 프로젝트 종료일 - 상위 부모의 종료일보다 더 늦게 종료 x

     */
}
