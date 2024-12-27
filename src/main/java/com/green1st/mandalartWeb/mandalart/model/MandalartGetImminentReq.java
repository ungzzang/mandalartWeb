package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MandalartGetImminentReq {
    @Schema(description = "프로젝트 id")
    @Positive(message = "user_id 는 양수만 가능합니다.")
    @NotNull(message = "user_id 입력해주세요.")
    private long userId;

}
