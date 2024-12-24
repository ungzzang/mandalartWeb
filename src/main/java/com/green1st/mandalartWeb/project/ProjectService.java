package com.green1st.mandalartWeb.project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.model.MandalartInsDto;
import com.green1st.mandalartWeb.project.model.ProjectPostReq;
import com.green1st.mandalartWeb.project.model.ProjectPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

            List<MandalartInsDto> mandalarts = new ArrayList<>(81);

            MandalartInsDto firstMandalart = new MandalartInsDto();

            firstMandalart.setProjectId(projectId);
            firstMandalart.setDepth(0);
            firstMandalart.setOrderId(0);

            mandalarts.add(firstMandalart);


            for(int i = 0; i < 8; i++) {
                MandalartInsDto mandalart = new MandalartInsDto();
                mandalart.setProjectId(projectId);
                mandalart.setDepth(1);
                mandalart.setOrderId(i);

                mandalarts.add(mandalart);
            }

            // depth == 2인 객체만 필터링
            List<MandalartInsDto> depth2Objects = mandalarts.stream()
                    .filter(obj -> obj.getDepth() == 1)
                    .collect(Collectors.toList());

            /*for(MandalartInsDto item : depth2Objects) {
                for(int i = 0; i < 8; i++) {

                    item.setProjectId(projectId);
                    item.set
                    item.setDepth(2);
                    item.setOrderId(i);

                    mandalarts.add(mandalart);
                }
            }*/



            result = projectMapper.insMandalart(mandalarts);

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
}
