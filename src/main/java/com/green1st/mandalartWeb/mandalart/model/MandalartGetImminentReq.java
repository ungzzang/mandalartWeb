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
    @Schema(description = "유저 id")
    @NotNull(message = "user_id 입력해주세요.")
    private String userId;

}
