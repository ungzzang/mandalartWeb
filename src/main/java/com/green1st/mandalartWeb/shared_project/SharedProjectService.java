package com.green1st.mandalartWeb.shared_project;

import com.green1st.mandalartWeb.common.MyFileUtils;
import com.green1st.mandalartWeb.common.model.ResultResponse;
import com.green1st.mandalartWeb.project.ProjectMapper;
import com.green1st.mandalartWeb.project.model.*;
import com.green1st.mandalartWeb.shared_project.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharedProjectService {
    private final SharedProjectMapper sharedProjectMapper;
    private final ProjectMapper projectMapper;
    private final MyFileUtils myFileUtils;

    @Transactional
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

    @Transactional
    public ResultResponse<?> patchSharedProject(SharedProjectPatchReq p) {
        ProjectSelDto projectSelDto = new ProjectSelDto();
        projectSelDto.setProjectId(p.getProjectId());
        projectSelDto.setUserId(p.getUserId());

        ProjectResultDto projectResultDto = projectMapper.selProjectByUserIdAndProjectId(projectSelDto);

        if(projectResultDto != null) {
            int result = sharedProjectMapper.updSharedProject(p);

            if(result == 1) {
                return ResultResponse.<Integer>builder()
                        .statusCode("200")
                        .resultData(1)
                        .resultMsg("공유 프로젝트 수정 성공")
                        .build();
            }
        }

        return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultData(0)
                .resultMsg("공유 프로젝트 수정 실패")
                .build();

    }

    @Transactional
    public ResultResponse<?> delSharedProject(SharedProjectDelReq p) {
        ProjectSelDto projectSelDto = new ProjectSelDto();
        projectSelDto.setProjectId(p.getProjectId());
        projectSelDto.setUserId(p.getUserId());

        ProjectResultDto projectResultDto = projectMapper.selProjectByUserIdAndProjectId(projectSelDto);

        if(projectResultDto != null) {
            // 공유 프로젝트 삭제
            int result = sharedProjectMapper.delSharedProject(p);

            if(result == 1) {
                return ResultResponse.<Integer>builder()
                        .statusCode("200")
                        .resultData(1)
                        .resultMsg("공유 프로젝트 삭제완료")
                        .build();
            }
        }

        return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultData(0)
                .resultMsg("공유 프로젝트 삭제실패")
                .build();
    }


    @Transactional
    public ResultResponse<?> copySharedProject(SharedProjectCopyReq p) {
        int result = sharedProjectMapper.insCopySharedProject(p);

        if(result == 1) {
            List<MandalartCopyDto> mandalartCopyDtos = projectMapper.selMandalartByProjectId(p.getCopyProjectId());

            // 만다라트 생성(9 x 9 = 81 개)
            long projectId = p.getProjectId();

            MandalartCopyDto firstMandalart = mandalartCopyDtos.get(0);

            firstMandalart.setProjectId(projectId);
            firstMandalart.setParentId(null);

            result = projectMapper.insCopyMandalart(firstMandalart);

            if(result != 0) {
                List<Long> parentIds = new ArrayList<>(8);

                for (int i = 0; i < 8; i++) {
                    MandalartCopyDto secondMandalart = mandalartCopyDtos.get(i + 1);
                    secondMandalart.setProjectId(projectId);
                    secondMandalart.setParentId(firstMandalart.getMandalartId());

                    result = projectMapper.insCopyMandalart(secondMandalart);

                    parentIds.add(secondMandalart.getMandalartId());
                }

                int depth3Cnt = 9;

                for (long item : parentIds) {
                    for (int i = 0; i < 8; i++) {
                        MandalartCopyDto lastMandalart = mandalartCopyDtos.get(depth3Cnt);
                        lastMandalart.setProjectId(projectId);
                        lastMandalart.setParentId(item);

                        result = projectMapper.insCopyMandalart(lastMandalart);

                        depth3Cnt++;
                    }
                }
            }

            return ResultResponse.<Integer>builder()
                    .statusCode("200")
                    .resultData(1)
                    .resultMsg("공유 프로젝트 복사 성공")
                    .build();
        }

        return ResultResponse.<Integer>builder()
                .statusCode("400")
                .resultData(0)
                .resultMsg("공유 프로젝트 복사 실패")
                .build();

    }
}
