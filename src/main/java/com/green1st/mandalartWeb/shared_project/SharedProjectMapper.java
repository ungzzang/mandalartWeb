package com.green1st.mandalartWeb.shared_project;

import com.green1st.mandalartWeb.shared_project.model.SharedProjectGetReq;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectGetRes;
import com.green1st.mandalartWeb.shared_project.model.SharedProjectPostReq;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SharedProjectMapper {
    int insSharedProject(SharedProjectPostReq p);
    List<SharedProjectGetRes> selSharedProjectList(SharedProjectGetReq p);
}
