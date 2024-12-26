package com.green1st.mandalartWeb.mandalart;

import com.green1st.mandalartWeb.mandalart.model.*;
import com.green1st.mandalartWeb.mandalart.util.CalculateColorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MandalartService {
    private final MandalartMapper mapper;
    private final CalculateColorCode calculateColorCode;

    public List<MandalartGetRes> getMandalart(MandalartGetReq p) {
        if (p.getProjectId() <= 0) {
            throw new IllegalArgumentException("유효하지 않은 프로젝트 ID입니다.");
        }
//        List<MandalartGetRes> res;
//        try {
//            res = mapper.getMandalart(p);
//        } catch (Exception e) {
//            log.error("만다라트 데이터 조회 중 예외 발생: {}", e.getMessage(), e);
//            throw new RuntimeException("만다라트 데이터 조회 실패", e);
//        }
//        if (res == null || res.isEmpty()) {
//            log.info("만다라트 데이터가 없습니다. 프로젝트 ID: {}", p.getProjectId());
//            return Collections.emptyList();
//        }
//        for (MandalartGetRes item : res) {
//            // 완료율 계산
//            int completedCount = 0;
//            int totalCount = 0;
//
//            // 자식 항목이 존재하지 않는 경우를 확인
//            if (item.getChildren() != null) {
//                for (int i = 0; i < item.getChildren().size(); i++) {
//                    if (item.getChildren().get(i).getCompletedFg() == 1) {
//                        completedCount++;
//                    }
//                    totalCount++;
//                }
//            }
//            double completionRate = totalCount == 0 ? 0 : (double) completedCount / totalCount;
//
//            // 색상 설정
//            ColorCodes colorCodes = new ColorCodes();
//            String color = calculateColorCode.calculateColorCode(item.getDepth(), completionRate, colorCodes);
//            item.setColor(color);
        //}

        List<MandalartGetRes> resList = mapper.getMandalart(p);

        ColorCodes colorCodes = new ColorCodes();

        for(MandalartGetRes item : resList) {
            int index = getCompleted(item, resList);
            switch (item.getDepth()) {
                case 0:
                    if(index > 0) {
                        item.setBgColor(colorCodes.getTitleColor().get(index - 1));
                    }
                    break;
                case 1:
                    if(index > 0) {
                        item.setBgColor(colorCodes.getSubTitleColor().get(index - 1));
                    }
                    break;
                case 2:
                    if(item.getCompletedFg() == 1) {
                        item.setBgColor(colorCodes.getDefaultColor().get(0));
                    }
                    break;

            }
        }

        log.info("sadsadsad: {}", resList);

        return resList;
    }

    public int getCompleted(MandalartGetRes res,  List<MandalartGetRes> list) {
        int completedCnt = 0;


        for(MandalartGetRes item : list) {
            if(res.getMandalartId() == item.getParentId() && item.getCompletedFg() == 1) {
                completedCnt++;
            }
        }

        return completedCnt;
    }

//    @Transactional
//    public List<MandalartPostRes> patchMand (MandalartPostReq p){
//        // 부모의 시작일 , 종료일 < 현재 만다라트의 시작일 종료일 값 비교 우선
//        // p.시작일 > c.시작일 / p.종료일 > c.종료일 / p.종료일 > c.시작일
//        // 부모의 date 가 크다면 update 실행 , 아니라면 update 취소
//        //
//        List<MandalartPostRes> res = mapper.patchMand(p);
//        if (res.size() == 0){
//            return new ArrayList<>();
//        }
//
//
//
//        List<MandalartPostRes> postRes = new ArrayList<>();
//        postRes.set(res);
//
//        return res;
//    }


//    private String getColorForLevel(int completedCount, List<String> colorRange) {
//        // completedCount에 따라 색상 결정 (0~8)
//        if (completedCount == 0) {
//            return colorRange.get(0);  // 가장 어두운 색상
//        } else if (completedCount == 1) {
//            return colorRange.get(1);
//        } else if (completedCount == 2) {
//            return colorRange.get(2);
//        } else if (completedCount == 3) {
//            return colorRange.get(3);
//        } else if (completedCount == 4) {
//            return colorRange.get(4);
//        } else if (completedCount == 5) {
//            return colorRange.get(5);
//        } else if (completedCount == 6) {
//            return colorRange.get(6);
//        } else if (completedCount == 7) {
//            return colorRange.get(7);
//        } else {
//            return colorRange.get(8);  // 가장 연한 색상
//        }
//    }

}
