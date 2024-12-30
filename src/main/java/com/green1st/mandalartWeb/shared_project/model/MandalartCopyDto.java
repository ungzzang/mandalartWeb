package com.green1st.mandalartWeb.shared_project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MandalartCopyDto {
    private long mandalartId;
    private long projectId;
    private Long parentId;
    private String title;
    private String contents;
    private int depth;
    private int orderId;
}
