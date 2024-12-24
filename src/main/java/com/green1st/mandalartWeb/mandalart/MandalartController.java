package com.green1st.mandalartWeb.mandalart;


import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.mandalart.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("mand")
@Tag(name = "만다라트", description = "만다라트")
public class MandalartController {
    private final MandalartService service;
        /*
        만다라트 조회 -> 프로젝트id "?" , mandalart : [
        {
        만다라트 id : ?
        , title : 만다라트 명칭
        , contents : 만다라트 내용
        , completed_fd : 완료 여부 0 or 1
        , depth : 단계(레벨) 0,1,2
        , order_id : 순서 0~7칸
        , start_date : 계획 시작일
        , finish_date : 계획 종료일
        }
        ]
        만다라트 마다 출력
         */
//    @GetMapping
//    @Operation(summary = "만다르트 조회" , description = "프로젝트 id는 만다르트가 현재 속해있는 프로젝트")
//    public ResultResponse<List<MandalartGetRes>> getMandalart(@ParameterObject @ModelAttribute MandalartGetReq p) {
//        // 프로젝트 ID 유효성 검사
//        if (p.getProjectId() <= 0) {
//            log.warn("유효하지 않은 프로젝트 ID: {}", p.getProjectId());
//            return ResultResponse.builder()
//                    .resultMsg("유효하지 않은 프로젝트 ID입니다.")
//                    .resultData()
//                    .build();
//        }
//
//        // 서비스 호출
//        try {
//            List<MandalartGetRes> result = service.getMandalart(p);
//            if (result == null || result.isEmpty()) {
//                log.info("만다라트 데이터가 없습니다. 프로젝트 ID: {}", p.getProjectId());
//                return ResultResponse.error(400, "만다라트 데이터가 없습니다.");
//            }
//            return ResultResponse.success(200, "만다라트 조회 성공", result);
//        } catch (Exception e) {
//            log.error("만다라트 조회 중 예외 발생: {}", e.getMessage(), e);
//            return ResultResponse.error(500, "만다라트 조회 중 문제가 발생했습니다.");
//        }
//    }

    @PostMapping
    @Operation(summary = "만다르트 업데이트")
    public ResultResponse<List<MandalartPostRes>> patchMand (@ParameterObject @ModelAttribute MandalartPostReq p){
        List<MandalartPostRes> res = service.patchMand(p);

        return ResultResponse.<List<MandalartPostRes>>builder()
                .resultMsg("업데이트 완료")
                .resultData(res)
                .build();
    }
}










