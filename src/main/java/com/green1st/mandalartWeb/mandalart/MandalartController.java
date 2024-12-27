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
@Tag(name = "만다라트", description = "만다라트")
public class MandalartController {
    private final MandalartService service;



    @GetMapping
    @Operation(summary = "만다르트 조회", description = "프로젝트 id는 만다르트가 현재 속해있는 프로젝트")
    public ResultResponse<?> getMandalart(@Valid @ParameterObject @ModelAttribute MandalartGetReq p) {
        List<MandalartGetRes> res = service.getMandalart(p);

        if (res == null || res.isEmpty()) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<List<MandalartGetRes>>builder()
                .statusCode("200")
                .resultMsg("만다라트 조회완료")
                .resultData(res)
                .build();
    }
    @PatchMapping("/update")

    public ResultResponse<Integer> updateMandalart(@Valid @RequestBody MandalartPostReq p) {
        int upd = service.patchMandalart(p);

        return ResultResponse.<Integer>builder()
                .statusCode("200")
                .resultMsg("만다라트 업데이트 완료")
                .resultData(upd)
                .build();
    }
}
