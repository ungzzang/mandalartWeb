package com.green1st.mandalartWeb.shared_project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.ProjectMapper;
import com.green1st.mandalartWeb.project.model.ProjectGetReq;
import com.green1st.mandalartWeb.project.model.ProjectGetRes;
import com.green1st.mandalartWeb.project.model.ProjectResultDto;
import com.green1st.mandalartWeb.shared_project.model.ProjectSelDto;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectGetReq;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectGetRes;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectPostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharedProjectService {
    private final SharedProjectMapper sharedProjectMapper;
    private final ProjectMapper projectMapper;

    public ResultResponse<?> postSharedProject(SharedProjectPostReq p) {
        ProjectSelDto projectSelDto = new ProjectSelDto();
        projectSelDto.setProjectId(p.getProjectId());
        projectSelDto.setUserId(p.getUserId());

        ProjectResultDto projectResultDto = projectMapper.selProjectByUserIdAndProjectId(projectSelDto);

        if(projectResultDto != null) {
            int result = sharedProjectMapper.insSharedProject(p);

            if(result == 1) {
                return ResultResponse.<Integer>builder()
                        .statusCode("200")
                        .resultData(1)
                        .resultMsg("공유 프로젝트 등록 성공")
                        .build();
            }
        }

        return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultData(0)
                .resultMsg("공유 프로젝트 등록 실패")
                .build();

    }

    public ResultResponse<?> getSaherdProject(SharedProjectGetReq p) {
        log.info("asdsadadasd {}", p);
        List<SharedProjectGetRes> sharedProjectList = sharedProjectMapper.selSharedProjectList(p);

        return ResultResponse.<List<SharedProjectGetRes>>builder()
                .statusCode("200")
                .resultData(sharedProjectList)
                .resultMsg("공유 프로젝트 조회 완료")
                .build();
    }
}
