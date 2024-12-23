package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@Slf4j
public class MandalartGetReq {
    @Schema(name = "project_id")
    private long projectId;

    public void setProjectId(long projectId) {

        this.projectId = projectId;
    }
}
