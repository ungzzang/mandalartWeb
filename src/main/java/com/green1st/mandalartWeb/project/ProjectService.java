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

@Service
@RequiredArgsConstructor
public class ProjectService {
    private ProjectMapper projectMapper;

    @Transactional
    public ResultResponse<ProjectPostRes> postProject(ProjectPostReq p) {
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

            for(int i=1; i<=2; i++) {
                for (int z = 0; z < 8; z++) {
                    MandalartInsDto mandalart = new MandalartInsDto();
                    mandalart.setProjectId(projectId);
                    mandalart.setDepth(i);
                    mandalart.setOrderId(z);

                    mandalarts.add(mandalart);
                }
            }

            result = projectMapper.insMandalart(mandalarts);

            if(result > 0) {
                ProjectPostRes projectPostRes = new ProjectPostRes();
                projectPostRes.setProjectId(projectId);

                return ResultResponse.<ProjectPostRes>builder()
                        .resultData(projectPostRes)
                        .resultMsg("프로젝트 생성완료")
                        .build();
            }
        }

        return null;
    }
}
