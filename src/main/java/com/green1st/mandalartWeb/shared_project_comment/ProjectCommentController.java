package com.green1st.mandalartWeb.shared_project_comment;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.shared_project_comment.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("shared_project/comments")
@Tag(name = "프로젝트 댓글", description = "프로젝트 댓글 관리")
public class ProjectCommentController {
    private final ProjectCommentService service;

    @PostMapping
    @Operation(summary = "프로젝트 댓글 등록")
    public ResultResponse<Long> postProjectComment(@Valid @RequestBody ProjectCommentPostReq p
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors() || p.getContent().trim().length() == 0) {
            return ResultResponse.<Long>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 추가 실패")
                    .resultData(0L)
                    .build();
        }

        service.postProjectComment(p);
        return ResultResponse.<Long>builder()
                .statusCode("200")
                .resultMsg("공유 프로젝트 댓글 추가 완료")
                .resultData(1L)
                .build();
    }

    @GetMapping
    @Operation(summary = "프로젝트 댓글 리스트")
    public ResultResponse<?> getProjectCommentList(@ParameterObject @ModelAttribute ProjectCommentGetReq p) {
        ProjectCommentGetRes res = service.getProjectCommentList(p);

        if(res == null || res.getContentList().isEmpty()) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 조회 실패")
                    .resultData(0)
                    .build();
        }
        return ResultResponse.<ProjectCommentGetRes>builder()
                .statusCode("200")
                .resultMsg("프로젝트 댓글 조회 완료")
                .resultData(res)
                .build();
    }

    @PatchMapping
    @Operation(summary = "프로젝트 댓글 수정")
    public ResultResponse<Integer> updateSharedProjectComment(@Valid @RequestBody ProjectCommentPatchReq p
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 수정 실패")
                    .resultData(0)
                    .build();

        }

        int updatedRows = service.updateProjectComment(p);
        if (updatedRows == 0) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 수정 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<Integer>builder()
                .statusCode("200")
                .resultMsg("공유 프로젝트 댓글 수정 완료")
                .resultData(1)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "프로젝트 댓글 삭제")
    public ResultResponse<Integer> deleteProjectComment(@ParameterObject @ModelAttribute ProjectCommentDelReq p) {
        int deletedRows = service.deleteProjectComment(p);

        if(deletedRows == 0) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 삭제 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<Integer>builder()
                .statusCode("200")
                .resultMsg("공유 프로젝트 댓글 삭제 완료")
                .resultData(1)
                .build();

    }
}
