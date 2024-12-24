package com.green1st.mandalartWeb.shared_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SharedProjectPostReq {
    private Long projectId;
    private String title;
    private String content;
    private String userId;
}
