package com.green1st.mandalartWeb.mandalart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MandalartCalendarGetReq {
    private String userId;
    private int year;
    private int month;
    @JsonIgnore
    private String startDate;
    @JsonIgnore
    private String finishDate;
}
