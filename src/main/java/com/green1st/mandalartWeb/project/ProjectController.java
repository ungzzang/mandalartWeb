package com.green1st.mandalartWeb.project;

import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.model.ProjectGetReq;
import com.green1st.mandalartWeb.project.model.ProjectGetRes;
import com.green1st.mandalartWeb.project.model.ProjectPostReq;
import com.green1st.mandalartWeb.project.model.ProjectPostRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
@Tag(name="프로젝트", description = "프로젝트 관련 API")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    @Operation(summary = "프로젝트 등록", description = "프로젝트를 등록하는 API")
    public ResultResponse<?> postProject(@RequestBody ProjectPostReq p) {
        return projectService.postProject(p);
    }

    @GetMapping
    @Operation(summary = "프로젝트 조회", description = "프로젝트를 조회하는 API")
    public ResultResponse<?> getProject(@ParameterObject @ModelAttribute ProjectGetReq p) {
        return projectService.getProject(p);
    }
}
