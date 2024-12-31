package com.green1st.mandalartWeb.user.delete.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SharedProjectDeleteReq {
    private long projectId;
    private String userId;
}
