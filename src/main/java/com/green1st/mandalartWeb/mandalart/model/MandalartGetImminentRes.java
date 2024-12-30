package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MandalartGetImminentRes {
    private long projectId;
    private String title;
    private long mandalartId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
}
