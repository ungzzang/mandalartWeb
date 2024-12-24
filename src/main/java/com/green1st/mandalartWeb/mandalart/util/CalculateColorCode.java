package com.green1st.mandalartWeb.mandalart.util;

import com.green1st.mandalartWeb.mandalart.model.ColorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class CalculateColorCode {
    public static String calculateColorCode(int depth, double completionRate, ColorCodes colorCodes) {
        List<String> colorRange;

        if (depth == 0) {
            colorRange = colorCodes.getTitleColor();
        } else if (depth == 1) {
            colorRange = colorCodes.getSubTitleColor();
        } else {
            colorRange = colorCodes.getDefaultColor(); // defaultColor를 리스트로 가져옴
        }

        // defaultColor 리스트 검증
        if (colorRange == null || colorRange.isEmpty()) {
            log.warn("기본 색상 리스트가 비어 있습니다. 안전한 색상 설정을 사용합니다.");
            return "#FFFFFF"; // 기본 색상 (흰색) 반환
        }

        // completionRate에 따른 색상 계산
        int index = (int) Math.round(completionRate * (colorRange.size() - 1));
        return colorRange.get(index);
    }
}
