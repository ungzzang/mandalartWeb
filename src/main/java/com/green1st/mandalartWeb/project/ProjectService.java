package com.green1st.mandalartWeb.project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper projectMapper;

    @Transactional
    public ResultResponse<?> postProject(ProjectPostReq p) {
        // 프로젝트 생성
        int result = projectMapper.insProject(p);

        if(result == 1) {
            // 만다라트 생성(9 x 9 = 81 개)
            long projectId = p.getProjectId();

            MandalartInsDto firstMandalart = new MandalartInsDto();

            firstMandalart.setProjectId(projectId);
            firstMandalart.setParentId(null);
            firstMandalart.setDepth(0);
            firstMandalart.setOrderId(0);

            result = projectMapper.insMandalart(firstMandalart);

            if(result != 0) {
                List<Long> parentIds = new ArrayList<>(8);

                for (int i = 0; i < 8; i++) {
                    MandalartInsDto secondMandalart = new MandalartInsDto();
                    secondMandalart.setProjectId(projectId);
                    secondMandalart.setParentId(firstMandalart.getMandalartId());
                    secondMandalart.setDepth(1);
                    secondMandalart.setOrderId(i);

                    result = projectMapper.insMandalart(secondMandalart);

                    parentIds.add(secondMandalart.getMandalartId());
                }

                for (long item : parentIds) {
                    for (int i = 0; i < 8; i++) {
                        MandalartInsDto lastMandalart = new MandalartInsDto();
                        lastMandalart.setProjectId(projectId);
                        lastMandalart.setParentId(item);
                        lastMandalart.setDepth(2);
                        lastMandalart.setOrderId(i);

                        result = projectMapper.insMandalart(lastMandalart);

                    }
                }
            }

            if(result > 0) {
                ProjectPostRes projectPostRes = new ProjectPostRes();
                projectPostRes.setProjectId(projectId);

                return ResultResponse.<ProjectPostRes>builder()
                        .statusCode("200")
                        .resultData(projectPostRes)
                        .resultMsg("프로젝트 생성완료")
                        .build();
            }
        }

        return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultData(0)
                .resultMsg("프로젝트 생성실패")
                .build();
    }

    public ResultResponse<?> getProject(ProjectGetReq p) {
        log.info("asdsadadasd {}", p);
        List<ProjectGetRes> projectList = projectMapper.selProjectList(p);

        return ResultResponse.<List<ProjectGetRes>>builder()
                .statusCode("200")
                .resultData(projectList)
                .resultMsg("프로젝트 조회 완료")
                .build();
    }

}
