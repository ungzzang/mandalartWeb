package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MandalartCalendarGetRes {
    private long id;
    private String title;
    private LocalDate start;
    private LocalDate end;
    private String description;

}
