package com.green1st.mandalartWeb.mandalart;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.mandalart.model.*;
import com.green1st.mandalartWeb.project.ProjectMapper;
import com.green1st.mandalartWeb.project.model.ProjectDetailDto;
import com.green1st.mandalartWeb.shared_project.SharedProjectMapper;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MandalartService {
    private final MandalartMapper mapper;
    private final ProjectMapper projectMapper;
    private final SharedProjectMapper sharedProjectMapper;

    // 완료 했다가 다시 취소하면 색상이 변경되도록 설정
    public MandalartGetResVer2 getMandalart(MandalartGetReq p) {
        MandalartGetResVer2 mandalartGetResVer2 = new MandalartGetResVer2();
        ProjectDetailDto projectDetailDto = new ProjectDetailDto();

        // 프로젝트 정보 조회
        projectDetailDto = projectMapper.selProjectDetail(p.getProjectId());

        mandalartGetResVer2.setProjectId(projectDetailDto.getProjectId());
        mandalartGetResVer2.setTitle(projectDetailDto.getTitle());
        mandalartGetResVer2.setContent(projectDetailDto.getContent());
        mandalartGetResVer2.setNickName(projectDetailDto.getNickName());
        mandalartGetResVer2.setSharedFg(projectDetailDto.getSharedFg());
        mandalartGetResVer2.setCreatedAt(projectDetailDto.getCreatedAt());

        List<MandalartGetRes> resList = mapper.getMandalart(p);

        ColorCodes colorCodes = new ColorCodes();

        for(MandalartGetRes item : resList) {
            int index = getCompleted(item, resList);
            int total = 8;
            switch (item.getDepth()) {
                case 0:
                    if(index > 0) {
                        item.setBgColor(colorCodes.getTitleColor().get(index - 1));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
                case 1:
                    if(index > 0) {
                        double percentage = (double) index / total * 100;
                        item.setCompletedPer(percentage);
                        item.setBgColor(colorCodes.getSubTitleColor().get(index - 1));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
                case 2:
                    if(item.getCompletedFg() == 1) {
                        item.setBgColor(colorCodes.getDefaultColor().get(0));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
            }
        }

        mandalartGetResVer2.setMandalart(resList);

        return mandalartGetResVer2;
    }

    // 완료 했다가 다시 취소하면 색상이 변경되도록 설정
    public MandalartSharedGetResVer2 getSharedMandalart(MandalartSharedGetReq p) {
        MandalartSharedGetResVer2 mandalartSharedGetResVer2 = new MandalartSharedGetResVer2();
        SharedProjectDetailDto sharedProjectDetailDto;

        log.info("asdsadsadadsa{}", p.getProjectId());

        // 프로젝트 정보 조회
        sharedProjectDetailDto = sharedProjectMapper.selSharedProjectDetail(p);

        mandalartSharedGetResVer2.setProjectId(sharedProjectDetailDto.getProjectId());
        mandalartSharedGetResVer2.setTitle(sharedProjectDetailDto.getTitle());
        mandalartSharedGetResVer2.setContent(sharedProjectDetailDto.getContent());
        mandalartSharedGetResVer2.setNickName(sharedProjectDetailDto.getNickName());
        mandalartSharedGetResVer2.setLikeFg(sharedProjectDetailDto.getLikeFg());
        mandalartSharedGetResVer2.setCreatedAt(sharedProjectDetailDto.getCreatedAt());

        MandalartGetReq mandalartGetReq = new MandalartGetReq();
        mandalartGetReq.setProjectId(p.getProjectId());

        List<MandalartGetRes> resList = mapper.getMandalart(mandalartGetReq);

        ColorCodes colorCodes = new ColorCodes();

        for(MandalartGetRes item : resList) {
            int index = getCompleted(item, resList);
            int total = 8;
            switch (item.getDepth()) {
                case 0:
                    if(index > 0) {
                        item.setBgColor(colorCodes.getTitleColor().get(index - 1));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
                case 1:
                    if(index > 0) {
                        double percentage = (double) index / total * 100;
                        item.setCompletedPer(percentage);
                        item.setBgColor(colorCodes.getSubTitleColor().get(index - 1));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
                case 2:
                    if(item.getCompletedFg() == 1) {
                        item.setBgColor(colorCodes.getDefaultColor().get(0));
                    } else {
                        item.setBgColor("#FFFFFF");
                    }
                    break;
            }
        }

        mandalartSharedGetResVer2.setMandalart(resList);

        return mandalartSharedGetResVer2;
    }

    List<MandalartGetImminentRes> getImProject (MandalartGetImminentReq p){
        List<MandalartGetImminentRes> imminentResList = mapper.getImProject(p);

        return imminentResList;
    }

    @Transactional
    public ResultResponse<?> patchMandalart(MandalartPostReq p) {
        // 객체 자체에 검사
        // 시작일, 종료일이 모두 입력 되었는지
        if(p.getStartDate() != null || p.getFinishDate() != null) {
            if(p.getStartDate() == null || p.getFinishDate() == null) {
                return ResultResponse.<Integer>builder()
                        .statusCode("400")
                        .resultMsg("시작일, 종료일을 모두 입력해 주십시오.")
                        .resultData(0)
                        .build();
            } else {
                // 시작일이 종료일 보다 크다면
                if(p.getStartDate().isAfter(p.getFinishDate())) {
                    return ResultResponse.<Integer>builder()
                            .statusCode("400")
                            .resultMsg("시작일은 종료일 보다 클 수 없습니다.")
                            .resultData(0)
                            .build();
                }
            }
        }

        // 부모가 있다면 유효한지, 그리고 그 기간안에 일자인지 검사
        MandalartGetRes parentMand = mapper.selMandalartByMandalartId(p.getParentId());

        if(parentMand != null) {
            // 상위 목표의 기간이 null 인데 본 목표가 일자를 가진 경우
            if(p.getStartDate() != null && parentMand.getStartDate() == null) {
                return ResultResponse.<Integer>builder()
                        .statusCode("400")
                        .resultMsg("상위 목표의 기간이 설정 되지 않았습니다.")
                        .resultData(0)
                        .build();
            } else if(p.getStartDate() != null && parentMand.getStartDate() != null){ // 만약 상위 목표의 기간이 설정 되어있고 본 목표가 설정되어있다면
                if(p.getStartDate().isBefore(parentMand.getStartDate())) {
                    return ResultResponse.<Integer>builder()
                            .statusCode("400")
                            .resultMsg("시작일은 상위 목표의 시작일을 보다 전일 수 없습니다.(상위 목표 시작일: " + parentMand.getStartDate() + ")")
                            .resultData(0)
                            .build();
                }

                if(p.getFinishDate().isAfter(parentMand.getFinishDate())) {
                    return ResultResponse.<Integer>builder()
                            .statusCode("400")
                            .resultMsg("종료일은 상위 목표의 종료일을 보다 후일 수 없습니다.(상위 목표 종료일: " + parentMand.getFinishDate() + ")")
                            .resultData(0)
                            .build();
                }
            }
        }

        // 자식 요소가 기간을 가진 경우 상위요소가 그 안의 일자로 들어가지 않도록
        MandalartChildDate mandalartChildDate = mapper.selChildMandalartMinStartDateAndMaxFinishDateByMandalartId(p.getMandalartId());

        // 하위 목표 일자가 존재하는경우
        if(mandalartChildDate != null) {
            if(p.getStartDate() == null) {
                return ResultResponse.<Integer>builder()
                        .statusCode("400")
                        .resultMsg("하위 목표의 일자가 존재하여 일자를 초기화 할 수 없습니다.")
                        .resultData(0)
                        .build();
            } else {
                if(p.getStartDate().isAfter(mandalartChildDate.getMinStartDate())) {
                    return ResultResponse.<Integer>builder()
                            .statusCode("400")
                            .resultMsg("하위 목표의 최소 시작일("+ mandalartChildDate.getMinStartDate() +") 보다 큰 일자는 입력할 수 없습니다.")
                            .resultData(0)
                            .build();
                }

                if(p.getFinishDate().isBefore(mandalartChildDate.getMaxFinishDate())) {
                    return ResultResponse.<Integer>builder()
                            .statusCode("400")
                            .resultMsg("하위 목표의 최대 종료일("+ mandalartChildDate.getMaxFinishDate() +") 보다 작은 일자는 입력할 수 없습니다.")
                            .resultData(0)
                            .build();
                }
            }
        }

        // DB 업데이트 실행
        int updatedRows = mapper.patchMandalart(p);

        // 형재 요소가 전부 완료 되었는지 검사
        List<MandalartGetRes> siblingList = mapper.selSiblingMandalart(p.getMandalartId());

        if(siblingList.size() > 0) {
            int completedCnt = 0;
            long parentId = siblingList.get(0).getParentId();
            int depth = siblingList.get(0).getDepth();

            MandalartPostReq completedUpdateP = new MandalartPostReq();
            completedUpdateP.setMandalartId(parentId);

            for (MandalartGetRes item : siblingList) {
                if (item.getCompletedFg() == 1) {
                    completedCnt++;
                }
            }

            if (completedCnt == 8) {
                completedUpdateP.setCompletedFg(1);
            } else {
                completedUpdateP.setCompletedFg(0);
            }

            mapper.patchMandalartCompletedFg(completedUpdateP);

            // 최하위
            if (depth == 2) {
                // 형재 요소가 전부 완료 되었는지 검사
                siblingList = mapper.selSiblingMandalart(parentId);

                if (siblingList.size() > 0) {
                    completedCnt = 0;
                    parentId = siblingList.get(0).getParentId();

                    completedUpdateP = new MandalartPostReq();
                    completedUpdateP.setMandalartId(parentId);

                    for (MandalartGetRes item : siblingList) {
                        if (item.getCompletedFg() == 1) {
                            completedCnt++;
                        }
                    }

                    if (completedCnt == 8) {
                        completedUpdateP.setCompletedFg(1);
                    } else {
                        completedUpdateP.setCompletedFg(0);
                    }

                    mapper.patchMandalartCompletedFg(completedUpdateP);
                }
            }
        }

        if(updatedRows > 0) {
            return ResultResponse.<Integer>builder()
                    .statusCode("200")
                    .resultMsg("만다라트 수정 성공.")
                    .resultData(0)
                    .build();
        } else {
            return ResultResponse.<Integer>builder()
                    .statusCode("400")
                    .resultMsg("만다라트 수정 실패.")
                    .resultData(0)
                    .build();
        }
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

    public List<MandalartCalendarGetRes> getMandalartCalendar(MandalartCalendarGetReq p) {
        String monthStr = p.getMonth() < 10 ? "0" + p.getMonth() : String.valueOf(p.getMonth());

        p.setStartDate(p.getYear() + "-" + monthStr + "-01");

        YearMonth yearMonth = YearMonth.of(p.getYear(), p.getMonth());

        p.setFinishDate(p.getYear() + "-" + monthStr + yearMonth.atEndOfMonth());

        return mapper.selMandalartCalendar(p);
    }
}
