package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MandalartSharedGetResVer2 {
    private long projectId;
    private String nickName;
    private String title;
    private String content;
    private LocalDate createdAt;
    private int likeFg;
    List<MandalartGetRes> mandalart;
}
