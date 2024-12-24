package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateColorCode {
    public static String calculateColorCode(int depth, double completionRate, ColorCodes colorCodes) {
        List<String> colors;

        // depth에 따른 색상 리스트 선택
        if (depth == 0) {
            colors = colorCodes.getTitleColor(); // 0레벨 색상
        } else if (depth == 1) {
            colors = colorCodes.getSubTitleColor(); // 1레벨 색상
        } else {
            return colorCodes.getDefaultColor(); // 기타 레벨은 기본 색상
        }

        // 완료율을 색상 리스트 인덱스에 매핑
        int index = (int) Math.min(completionRate * colors.size(), colors.size() - 1);
        return colors.get(index);
    }
}
