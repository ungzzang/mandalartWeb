package com.green1st.mandalartWeb.project;

import com.green1st.mandalartWeb.project.model.MandalartInsDto;
import com.green1st.mandalartWeb.project.model.ProjectPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    int insProject(ProjectPostReq p);
    int insMandalart(List<MandalartInsDto> p);
}
