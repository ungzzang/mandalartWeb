package com.green1st.mandalartWeb.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class LoginDto {
    private long projectId;
    private String title;
    private Date startDate;
    private Date finishDate;
}
