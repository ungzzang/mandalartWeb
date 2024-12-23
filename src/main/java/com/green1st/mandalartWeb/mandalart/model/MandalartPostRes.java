package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(title = "")
public class MandalartPostRes {
    @Schema(title = "project_id")
    private long projectId;
    private List<MandalartPostDto> mandalartIdPostList;
}
