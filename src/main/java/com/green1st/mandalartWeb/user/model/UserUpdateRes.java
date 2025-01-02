package com.green1st.mandalartWeb.user.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserUpdateRes {
    private String userId;
    private int result;
    private String upw;
    private String message;
}
