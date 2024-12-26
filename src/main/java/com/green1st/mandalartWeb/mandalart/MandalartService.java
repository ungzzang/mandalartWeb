package com.green1st.mandalartWeb.mandalart;

import com.green1st.mandalartWeb.mandalart.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MandalartService {
    private final MandalartMapper mapper;
    private final ColorCodes colorCodes;
    // 완료 했다가 다시 취소하면 색상이 변경되도록 설정
    public List<MandalartGetRes> getMandalart(MandalartGetReq p) {
        if (p.getProjectId() <= 0) {
            throw new IllegalArgumentException("유효하지 않은 프로젝트 ID입니다.");
        }
        List<MandalartGetRes> resList = mapper.getMandalart(p);
//        ColorCodes colorCodes = new ColorCodes();

        // 완료 상태 및 색상 갱신
        for (MandalartGetRes item : resList) {
            if (item.getDepth() == 2) {
                // 최하위 레벨 항목 색상 설정
                if (item.getCompletedFg() == 1) {
                    item.setBgColor(colorCodes.getDefaultColor().get(0)); // 완료된 항목에 기본 색상 적용
                } else {
                    item.setBgColor(null); // 미완료 상태에서는 색상 초기화
                }
            } else {
                // 부모 항목의 상태를 자식 항목에 따라 갱신
                boolean allCompleted = areAllChildrenCompleted(item, resList);
                item.setCompletedFg(allCompleted ? 1 : 0); // 자식 완료 상태에 따라 부모 완료 상태 설정

                // 자식 항목 완료 상태에 맞는 색상 갱신
                int completedCount = countCompletedChildren(item, resList);
                if (item.getDepth() == 1 && completedCount > 0) {
                    item.setBgColor(colorCodes.getSubTitleColor().get(Math.min(completedCount - 1, colorCodes.getSubTitleColor().size() - 1)));
                } else if (item.getDepth() == 0 && completedCount > 0) {
                    item.setBgColor(colorCodes.getTitleColor().get(Math.min(completedCount - 1, colorCodes.getTitleColor().size() - 1)));
                } else {
                    item.setBgColor(null); // 미완료 상태에서는 색상 초기화
                }
            }
        }

        log.info("갱신된 만다라트 상태: {}", resList);
        return resList;
    }
    // 부모 항목의 자식들이 모두 완료되었는지 확인
    private boolean areAllChildrenCompleted(MandalartGetRes parent, List<MandalartGetRes> allItems) {
        for (MandalartGetRes item : allItems) {
            if (item.getParentId() == parent.getMandalartId() && item.getCompletedFg() == 0) {
                return false; // 자식 중 하나라도 미완료라면 false 반환
            }
        }
        return true; // 모든 자식이 완료되었으면 true 반환
    }
    // 부모 항목의 완료된 자식 수를 셈
    private int countCompletedChildren(MandalartGetRes parent, List<MandalartGetRes> allItems) {
        int completedCount = 0;
        for (MandalartGetRes item : allItems) {
            if (item.getParentId() == parent.getMandalartId() && item.getCompletedFg() == 1) {
                completedCount++;
            }
        }
        return completedCount;
    }
//    public int getCompleted(MandalartGetRes res,  List<MandalartGetRes> list) {
//        int completedCnt = 0;
//        for(MandalartGetRes item : list) {
//            if(res.getMandalartId() == item.getParentId() && item.getCompletedFg() == 1) {
//                completedCnt++;
//            }
//        }
//        return completedCnt;
//    }

    // 자식의 완료 completed_fg 체크하고 bgcolor 들어가도록 설정 쿼리문으로 작성
    // 레벨 0 , 1 을 완료할려면 하위 만다라트가 전부 완료 되어야 완료 버튼이 눌리도록 설정

    public List<MandalartPostRes> patchMandalart(MandalartPostReq p) {
        // 유효성 검사
        if (p.getProjectId() <= 0) {
            throw new IllegalArgumentException("유효하지 않은 프로젝트 ID입니다.");
        }
        if (p.getStartDate() != null && p.getFinishDate() != null && !p.getStartDate().isBefore(p.getFinishDate())) {
            throw new IllegalArgumentException("시작일은 종료일보다 이전이어야 합니다.");
        }

        // 색상 코드 처리 (기본 색상으로 설정된 경우 색상 코드 지정)
        ColorCodes colorCodes = new ColorCodes();
        String colorCode = p.getColorCode();

        // 색상 코드가 비어있을 경우, 기본 색상으로 설정
        if (colorCode == null || colorCode.isEmpty()) {
            colorCode = colorCodes.getDefaultColor().get(0);  // 기본 색상 사용
        }

        // DB에서 해당 프로젝트에 속하는 만다라트 정보 조회
        List<MandalartPostRes> postRes = mapper.patchMandalart(p);

        if (postRes.isEmpty()) {
            throw new RuntimeException("해당 프로젝트에 속하는 만다라트 정보가 없습니다.");
        }

        // 업데이트할 정보 처리
        for (MandalartPostRes mandalart : postRes) {
            // 요청받은 값으로 업데이트
            mandalart.setTitle(p.getTitle());
            mandalart.setContents(p.getContents());
            mandalart.setDepth(p.getDepth());
            mandalart.setOrderId(p.getOrderId());
            mandalart.setCompletedFg(p.getCompletedFg() ? 1 : 0);
            mandalart.setStartDate(p.getStartDate());
            mandalart.setFinishDate(p.getFinishDate());
            mandalart.setParentId(p.getParentId());
            mandalart.setBgColor(colorCode);  // colorCode는 이전에 설명한 대로 색상 설정 로직 적용

            // DB 업데이트 쿼리 호출 (여기서 한 번에 처리)
            MandalartPostReq updateReq = new MandalartPostReq();
            // mandalart에서 필요한 값을 updateReq에 세팅
            updateReq.setTitle(mandalart.getTitle());
            updateReq.setContents(mandalart.getContents());
            updateReq.setDepth(mandalart.getDepth());
            updateReq.setOrderId(mandalart.getOrderId());
            updateReq.setCompletedFg(mandalart.getCompletedFg() == 1);
            updateReq.setStartDate(mandalart.getStartDate());
            updateReq.setFinishDate(mandalart.getFinishDate());
            updateReq.setParentId(mandalart.getParentId());
            updateReq.setColorCode(mandalart.getBgColor());

            // 실제 DB 업데이트 쿼리 호출
            mapper.updateMandalart(updateReq);
        }

        return postRes;
    }
}
