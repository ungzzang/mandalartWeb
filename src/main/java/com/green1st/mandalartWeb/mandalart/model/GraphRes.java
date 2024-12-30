package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphRes {
    private String title;
    private long parentid;
    private int completedFg;
    private long mandalartId;
    private int depth;
    private int orderid;
}
