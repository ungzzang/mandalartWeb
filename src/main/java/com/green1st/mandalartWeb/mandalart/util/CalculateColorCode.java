package com.green1st.mandalartWeb.mandalart.util;

import com.green1st.mandalartWeb.mandalart.model.ColorCodes;
import org.springframework.stereotype.Component;

import java.util.List;

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

        int index = (int) Math.round(completionRate * (colorRange.size() - 1));
        return colorRange.get(index);
    }
}
