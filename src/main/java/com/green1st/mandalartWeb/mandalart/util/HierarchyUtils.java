package com.green1st.mandalartWeb.mandalart.util;

import com.green1st.mandalartWeb.mandalart.model.MandalartGetDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 계층 유틸
public class HierarchyUtils {
    // 만다라트 id - dto ( 키 - 벨류 매핑 )
    Map<Long, MandalartGetDto> idToNodeMap = new HashMap<>();

    List<MandalartGetDto> rootNodes = new ArrayList<>();




    /*
    // ID 기반 매핑 생성
        for(MandalartGetDto dto : flatList) {
        idToNodeMap.put(dto.getMandalartId(), dto);
    }

    // 계층화
        for (MandalartGetDto dto : flatList) {
        if (dto.getParentId() == 0) {
            rootNodes.add(dto); // 최상위 부모
        } else {
            MandalartGetDto parent = idToNodeMap.get(dto.getParentId());
            if (parent != null) {
                // 부모-자식 관계 설정
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(dto);
            }
        }
    }

        return rootNodes; // 최상위 부모 리스트 반환

     */
}

