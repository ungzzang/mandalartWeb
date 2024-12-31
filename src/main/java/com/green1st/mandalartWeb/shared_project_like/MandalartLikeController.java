package com.green1st.mandalartWeb.shared_project_like;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.shared_project_like.model.ProjectLikeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shared_project")
@Tag(name = "프로젝트 좋아요", description = "프로젝트 좋아요 관리")
public class MandalartLikeController {
    private final MandalartLikeService mandalartLikeService;

    @PostMapping("/like")
    @Operation(summary = "프로젝트 좋아요 등록")
    public ResultResponse<Integer> sharedProjectLike(@Valid @RequestBody ProjectLikeDto dto) {
        log.info("MandalartLikeController > sharedProjectLike > dto: {}", dto);
            int result = mandalartLikeService.insMandalratLike(dto);
            if(result == 1) {
                return ResultResponse.<Integer>builder()
                        .statusCode("200")
                        .resultMsg("프로젝트 좋아요 완료")
                        .resultData(result)
                        .build();
            }
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 좋아요 실패")
                    .resultData(0)
                    .build();
    }

    @DeleteMapping("/like")
    @Operation(summary = "프로젝트 좋아요 취소")
    public ResultResponse<Integer> sharedProjectLikeDelete(@Valid @RequestBody ProjectLikeDto dto) {
        log.info("MandalartLikeController > sharedProjectLikeDelete > dto: {}", dto);
        int result = mandalartLikeService.delMandalratLike(dto);
        if (result == 1) {
            return ResultResponse.<Integer>builder()
                    .statusCode("200")
                    .resultMsg("프로젝트 좋아요 취소 완료")
                    .resultData(result)
                    .build();
        } return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultMsg("공유 프로젝트 좋아요 취소 실패")
                .resultData(0)
                .build();
    }

    @GetMapping("/checkLike")
    @Operation(summary = "프로젝트 좋아요 조회", description = "좋아요 했을 시에 resultData: 1, 좋아요 하지 않았을 시(취소 했을 시)에 resultData: 0")
    public ResultResponse<Integer> getMandalratLike(@Valid @ParameterObject @ModelAttribute ProjectLikeDto dto) {
        log.info("MandalartLikeController > getMandalratLike > dto: {}", dto);
        int result = mandalartLikeService.selMandalratLike(dto);
        if (result == 1) {
            return ResultResponse.<Integer>builder()
                    .statusCode("200")
                    .resultMsg("프로젝트 좋아요 조회 성공")
                    .resultData(result)
                    .build();
        } return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultMsg("프로젝트 좋아요 조회 실패")
                .resultData(0)
                .build();
    }
}
