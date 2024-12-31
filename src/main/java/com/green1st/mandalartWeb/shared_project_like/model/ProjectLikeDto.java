package com.green1st.mandalartWeb.shared_project_like.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(title="프로젝트 좋아요")
public class ProjectLikeDto {
    @Positive
    @Schema(description = "공유할 프로젝트 아이디(등록된 프로젝트여야함)", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long projectId;

    @Pattern(regexp="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])+[.][a-zA-Z]{2,3}$", message="이메일 주소 양식을 확인해주세요")
    @Schema(description = "유저이메일", example = "test@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;
}
