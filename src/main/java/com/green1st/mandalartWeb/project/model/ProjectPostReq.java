package com.green1st.mandalartWeb.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPostReq {
    @JsonIgnore
    private Long projectId;
    private String userId;
    private String title;
    private String content;
    private String pic;
}
