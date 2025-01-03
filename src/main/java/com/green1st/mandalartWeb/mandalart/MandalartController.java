package com.green1st.mandalartWeb.mandalart;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.mandalart.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("mand")
@Tag(name = "만다라트", description = "만다라트 관리")
public class MandalartController {
    private final MandalartService service;

    @GetMapping
    @Operation(summary = "만다라트 조회", description = "프로젝트 id는 만다라트가 현재 속해있는 프로젝트")
    public ResultResponse<?> getMandalart(@Valid @ParameterObject @ModelAttribute MandalartGetReq p) {
        MandalartGetResVer2 res = service.getMandalart(p);

        if (res == null) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<MandalartGetResVer2>builder()
                .statusCode("200")
                .resultMsg("만다라트 조회 완료")
                .resultData(res)
                .build();
    }

    @GetMapping("/shared")
    @Operation(summary = "공유 만다라트 조회", description = "프로젝트 id는 만다라트가 현재 속해있는 프로젝트")
    public ResultResponse<?> getSharedMandalart(@Valid @ParameterObject @ModelAttribute MandalartSharedGetReq p) {
        MandalartSharedGetResVer2 res = service.getSharedMandalart(p);

        if (res == null) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<MandalartSharedGetResVer2>builder()
                .statusCode("200")
                .resultMsg("만다라트 조회 완료")
                .resultData(res)
                .build();
    }

    @PatchMapping("/update")
    @Operation(summary = "만다라트 수정")
    public ResultResponse<?> updateMandalart(@Valid @RequestBody MandalartPostReq p) {
        ResultResponse<?> result = service.patchMandalart(p);

        return result;
        /*
        if (updatedRows == 0) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 수정 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<Integer>builder()
                .statusCode("200")
                .resultMsg("만다라트 수정 완료")
                .resultData(updatedRows)
                .build();*/
    }

    @GetMapping("/imminent")
    @Operation(summary = "임박한 만다라트 리스트")
    public ResultResponse<?> getImminentMandalart(@Valid @ParameterObject @ModelAttribute MandalartGetImminentReq p) {
        List<MandalartGetImminentRes> imminentResList = service.getImProject(p);

        if (imminentResList == null || imminentResList.isEmpty()) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("임박한 만다라트 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<List<MandalartGetImminentRes>>builder()
                .statusCode("200")
                .resultMsg("임박한 만다라트 조회 완료")
                .resultData(imminentResList)
                .build();
    }

    @GetMapping("/calendar")
    @Operation(summary = "캘린더 만다라트 조회", description = "월에 맞는 만다라트 조회")
    public ResultResponse<?> getMandalart(@Valid @ParameterObject @ModelAttribute MandalartCalendarGetReq p) {
       List<MandalartCalendarGetRes> res = service.getMandalartCalendar(p);

        if (res == null) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 켈린더 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<List<MandalartCalendarGetRes>>builder()
                .statusCode("200")
                .resultMsg("만다라트 켈린더 조회 완료")
                .resultData(res)
                .build();
    }
}
