package com.green1st.mandalartWeb.mandalart.model;

import lombok.Getter;

@Getter
public class ColorCodes {
    String[] titleColor = {
            "#001A00", // 1단계: 가장 어두운 초록색
            "#003300", // 2단계
            "#004C00", // 3단계
            "#006600", // 4단계: 기본 색상
            "#007F00", // 5단계
            "#339933", // 6단계
            "#66CC66", // 7단계
            "#99FF99"  // 8단계: 가장 연한 초록색
    };

    // 투명도 배열 정의
    String[] subTitleColor = {
            "#99FF99FF", // 1단계: 가장 진한 초록색 (불투명)
            "#99FF99E6", // 2단계: 약간 투명
            "#99FF99CC", // 3단계
            "#99FF99B3", // 4단계
            "#99FF9999", // 5단계
            "#99FF997F", // 6단계
            "#99FF9966", // 7단계
            "#99FF994C"  // 8단계: 가장 연한 초록색 (아주 투명)
    };
}
