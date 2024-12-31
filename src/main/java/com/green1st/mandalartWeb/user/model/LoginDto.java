package com.green1st.mandalartWeb.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
public class LoginDto {
    private long projectId;
    private String title;
    private LocalDate startDate;
    private LocalDate finishDate;
}
