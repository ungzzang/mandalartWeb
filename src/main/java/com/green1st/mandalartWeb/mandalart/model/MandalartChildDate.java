package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MandalartChildDate {
    private LocalDate minStartDate;
    private LocalDate maxFinishDate;
}
