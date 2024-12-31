package com.green1st.mandalartWeb.user.delete.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectCommentAndLikeDeleteReq {
    @Schema(description = "삭제할 댓글 PK")
    private long commentId;

    @Schema(description = "공유할 프로젝트 아이디(등록된 프로젝트여야함)", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long projectId;

    @Schema(description = "유저아이디")
    private String userId;


}
