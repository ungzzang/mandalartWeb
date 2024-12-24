package com.green1st.mandalartWeb.shared_project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.ProjectMapper;
import com.green1st.mandalartWeb.project.model.ProjectResultDto;
import com.green1st.mandalartWeb.shared_project.model.ProjectSelDto;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
