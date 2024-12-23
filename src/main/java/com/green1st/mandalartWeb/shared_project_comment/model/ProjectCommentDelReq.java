package com.green1st.mandalartWeb.shared_project_comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Getter
@ToString
public class ProjectCommentDelReq {
    @Schema(name = "comment_id", description = "삭제할 댓글 PK")
    private long commentId;
    @Schema(name = "user_id", description = "유저아이디")
    private String userId;

    @ConstructorProperties({"comment_id", "user_id"})
    public ProjectCommentDelReq(long commentId, String userId) {
        this.commentId = commentId;
        this.userId = userId;
    }
}
