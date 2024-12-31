package com.green1st.mandalartWeb.project.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectDetailDto {
    private long projectId;
    private String nickName;
    private String title;
    private String content;
    private LocalDate createdAt;
    private int sharedFg;
}
