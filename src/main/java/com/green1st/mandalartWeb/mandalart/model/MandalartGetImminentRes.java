package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class MandalartGetImminentRes {
    private long projectId;
    private int cnt;
    private String title;
    private LocalDate startDate;
    private LocalDate finishDate;
}
