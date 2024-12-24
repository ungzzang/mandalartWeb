package com.green1st.mandalartWeb.shared_project_comment;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.shared_project_comment.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("project/comment")
@Tag(name = "프로젝트 댓글", description = "프로젝트 댓글 관리")
public class ProjectCommentController {
    private final ProjectCommentService service;

    @PostMapping
    @Operation(summary = "프로젝트 댓글 등록")
    public ResultResponse<Long> postProjectComment(@RequestBody ProjectCommentPostReq p) {
        long commentId = service.postProjectComment(p);
        return ResultResponse.<Long>builder()
                .resultMsg("공유 프로젝트 댓글 추가 완료")
                .resultData(commentId)
                .build();
    }

    @GetMapping
    @Operation(summary = "프로젝트 댓글 리스트")
    public ResultResponse<Integer> getProjectCommentList(@ParameterObject @ModelAttribute ProjectCommentGetReq p) {
        ProjectCommentGetRes res = service.getProjectCommentList(p);

        if (res == null || res.getContentList() == null || res.getContentList().isEmpty()) {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("공유 프로젝트 댓글 조회 실패")
                    .resultData(0)
                    .build();
        }

        return ResultResponse.<Integer>builder()
                .statusCode("200")
                .resultMsg("프로젝트 댓글 조회 완료")
                .resultData(1)
                .build();
//        return ResultResponse.<ProjectCommentGetRes>builder()
//                .resultMsg(String.format("%d rows", res.getContentList().size()))
//                .resultData(res)
//                .build();
    }

    @PatchMapping
    @Operation(summary = "프로젝트 댓글 수정")
    public ResultResponse<Integer> updateSharedProjectComment(@RequestBody ProjectCommentPatchReq p) {
        int updatedRows = service.updateProjectComment(p);
        if (updatedRows == 0) {
            return ResultResponse.<Integer>builder()
                    .resultMsg("댓글을 찾을 수 없습니다.")
                    .resultData(0)
                    .build();
        }
        return ResultResponse.<Integer>builder()
                .resultMsg("공유 프로젝트 댓글 수정 완료")
                .resultData(1)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "프로젝트 댓글 삭제")
    public ResultResponse<Integer> deleteProjectComment(@ParameterObject @ModelAttribute ProjectCommentDelReq p) {
        int res = service.deleteProjectComment(p);
        return ResultResponse.<Integer>builder()
                .resultMsg("공유 프로젝트 댓글 삭제 완료")
                .resultData(1)
                .build();
    }


}

