package com.green1st.mandalartWeb.mandalart.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter

public class GraphReq {
    @Positive(message = "프로젝트 ID는 양수만 가능합니다.")
    @NotEmpty(message = "조회할 프로젝트 id 를 입력해주세요")
    private long projectId;
}
