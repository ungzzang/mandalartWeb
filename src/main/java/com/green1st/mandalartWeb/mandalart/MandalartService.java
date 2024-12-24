package com.green1st.mandalartWeb.mandalart;

import com.green1st.mandalartWeb.mandalart.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MandalartService {
    private final MandalartMapper mapper;

    public List<MandalartGetRes> getMandalart (MandalartGetReq p , List<MandalartGetDto> list){
        // 프로젝트 id 체크 -> 만다라트 id 부여 -> 하위 테이블 데이터 전부 출력
        if (p.getProjectId() == 0){
            return null;
        }
        if (list == null){
            return mapper.getMandalart(p);
        }
        List<MandalartGetRes> res = mapper.getMandalart(p);

        // depth = 0 일 경우 depth0 의 order_id 카운트 - colorCodes 클래스의 titleColor
        // depth = 1 일 경우 depth1의 order_id 카운트(레벨2) - colorCodes 클래스의 subTitleColor
        // depth(레벨) - order_id(하위 목표) 의 completedFg 계산해서 colorCodes 클래스 호출해서 색상 입력
        ColorCodes colorCodes = new ColorCodes();

        for (MandalartGetRes item : res){
            int completedCount = 0;
            for (MandalartGetDto dto : item.getMandalartIdGetList()){
                if (dto.getCompletedFg()==1){
                    completedCount++;
                }
            }
            item.setCompletedCount(completedCount);
            String colorCode = calculateColorCode(item, colorCodes);
//            item.setColorCodes(colorCode);
        }

        MandalartGetRes getRes = new MandalartGetRes();
        getRes.setProjectId(p.getProjectId());
        getRes.setMandalartIdGetList(list);

        List<MandalartGetRes> resList = new ArrayList<>();
        resList.add(getRes);

        // completed_fg 완료 처리 했는거 카운트 체크


        return null;
    }

    @Transactional
    public List<MandalartPostRes> patchMand (MandalartPostReq p){
        List<MandalartPostDto>  list = mapper.patchMand(p);
        if (list.size() == 0){
            return new ArrayList<>();
        }

        MandalartPostRes res = new MandalartPostRes();
        res.setProjectId(p.getProjectId());
        res.setMandalartIdPostList(list);

        List<MandalartPostRes> result = new ArrayList<>();
        result.add(res);

        return result;
    }
    private String calculateColorCode(MandalartGetRes item, ColorCodes colorCodes) {
        int completedCount = item.getCompletedCount();
        // completedCount에 따라 색상을 결정 (예시: 0 ~ 8까지의 단계)
//        if (item.getDepth() == 0) {
            // depth 0인 경우: colorCodes.titleColor 사용
            return getColorForLevel(completedCount, colorCodes.getTitleColor());
//        } else if (item.getDepth() == 1) {
            // depth 1인 경우: colorCodes.subTitleColor 사용
//            return getColorForLevel(completedCount, colorCodes.getSubTitleColor());
//        }
//        return colorCodes.getDefaultColor();  // 기본 색상
    }
    private String getColorForLevel(int completedCount, List<String> colorRange) {
        // completedCount에 따라 색상 결정 (0~8)
        if (completedCount == 0) {
            return colorRange.get(0);  // 가장 어두운 색상
        } else if (completedCount == 1) {
            return colorRange.get(1);
        } else if (completedCount == 2) {
            return colorRange.get(2);
        } else if (completedCount == 3) {
            return colorRange.get(3);
        } else if (completedCount == 4) {
            return colorRange.get(4);
        } else if (completedCount == 5) {
            return colorRange.get(5);
        } else if (completedCount == 6) {
            return colorRange.get(6);
        } else if (completedCount == 7) {
            return colorRange.get(7);
        } else {
            return colorRange.get(8);  // 가장 연한 색상
        }
    }

}
