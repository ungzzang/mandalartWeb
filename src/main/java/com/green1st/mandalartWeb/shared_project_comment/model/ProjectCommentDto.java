package com.green1st.mandalartWeb.shared_project_comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProjectCommentDto {
    @Schema(title = "댓글 PK")
    private long commentId;
    @Schema(title = "유저아이디")
    private String userId;
    @Schema(title = "댓글 내용")
    private String content;
    @Schema(title = "닉네임")
    private String nickName;
    @JsonIgnore
    private long projectId;
}
