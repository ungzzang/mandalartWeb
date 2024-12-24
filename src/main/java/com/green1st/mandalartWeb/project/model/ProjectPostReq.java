package com.green1st.mandalartWeb.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPostReq {
    private Long projectId;
    private String userId;
    private String title;
    private String content;
    private String pic;
}
