package com.green1st.mandalartWeb.common;

import org.springframework.web.bind.annotation.RequestMapping;

public class SpaController {
    @RequestMapping("/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}
