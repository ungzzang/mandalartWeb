package com.green1st.mandalartWeb.shared_project_comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectCommentPatchReq {
    @Schema(title = "댓글 PK", example = "1"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private long commentId;
    @Schema(title = "유저아이디", example = "2"
            , requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;

    @Schema(title = "댓글 내용", example = "댓글입니다."
            , requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "댓글 내용은 필수입니다.")
    private String content;
}
