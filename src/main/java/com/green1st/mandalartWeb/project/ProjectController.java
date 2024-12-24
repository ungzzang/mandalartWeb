package com.green1st.mandalartWeb.project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.model.ProjectPostReq;
import com.green1st.mandalartWeb.project.model.ProjectPostRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    @Operation(summary = "프로젝트 등록", description = "프로젝트를 등록하는 API")
    public ResultResponse<?> postProject(@ModelAttribute ProjectPostReq p) {
        ResultResponse<ProjectPostRes> res = projectService.postProject(p);

        if(res == null) {
            return ResultResponse.<Integer>builder()
                    .resultMsg("")
                    .resultData(0)
                    .build();
        }

        return res;
    }
}
