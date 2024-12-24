package com.green1st.mandalartWeb.shared_project;

import com.green1st.mandalartWeb.shared_project.model.SharedProjectPostReq;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SharedProjectMapper {
    int insSharedProject(SharedProjectPostReq p);
}
