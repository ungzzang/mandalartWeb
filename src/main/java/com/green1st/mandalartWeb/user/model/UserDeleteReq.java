package com.green1st.mandalartWeb.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
@Schema(title = "유저 삭제")
public class UserDeleteReq {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,20}$", message = "유효하지 않은 형식의 이메일입니다.")
    @Schema(description = "유저 이메일", example = "test@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;


    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()-_=+\\\\\\\\|\\\\[{\\\\]};:'\\\",<.>/?]).{8,20}$"
            , message = "비밀번호는 특수문자와 숫자를 포함한 8자 이상이어야 합니다.")
    @Schema(description = "비밀번호", example = "123abc!@#", requiredMode = Schema.RequiredMode.REQUIRED)
    private String upw;


    /*@JsonIgnore
    @Schema(description = "삭제할 댓글 PK")
    private long commentId;

    @JsonIgnore
    @Schema(description = "공유할 프로젝트 아이디(등록된 프로젝트여야함)", example = "1")
    private long projectId;*/

//    public UserDeleteReq(String userId, String upw, long commentId, long projectId) {
//        this.userId = userId;
//        this.upw = upw;
//        this.commentId = commentId;
//        this.projectId = projectId;
//    }


/*@Schema(description = "프로젝트 pk", requiredMode = Schema.RequiredMode.REQUIRED)
    private long projectId;*/

    /*@ConstructorProperties("project_id")
    public UserDeleteReq(long projectId) {
        this.projectId = projectId;
    }*/
}
