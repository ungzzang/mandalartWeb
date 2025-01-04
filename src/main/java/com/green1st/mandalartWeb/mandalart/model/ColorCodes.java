package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Getter
@Component
public class ColorCodes {
    // 0레벨 색상
    private  List<String> titleColor = Arrays.asList(
            "#55ad9a4a", "#55ad9a73", "#55ad9a8a", "#55ad9a9c", "#55ad9ab3", "#55ad9ac9", "#55ad9ae0", "#55ad9a"
    );
    // 1레벨 색상
    private  List<String> subTitleColor = Arrays.asList(
            "#68a99b24", "#68a99b3b", "#68a99b54", "#68a99b6b", "#68a99b87", "#68a99bb0", "#68a99bdb", "#68a99b"
    );

    private  List<String> defaultColor = Arrays.asList("#88aba3");  // 리스트로 변경

    public List<String> getTitleColor() {
        return titleColor;
    }

    public List<String> getSubTitleColor() {
        return subTitleColor;
    }

    public List<String> getDefaultColor() {
        return defaultColor;
    }

}
