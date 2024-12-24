package com.green1st.mandalartWeb.project.model;

import com.green1st.mandalartWeb.common.model.Paging;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@ToString
public class ProjectGetReq  extends Paging {
    private int searchFilter;
    private String searchText;
    private String userId;

    @ConstructorProperties({"page", "size", "searchFilter", "searchText", "userId"})
    public ProjectGetReq(Integer page, Integer size
            , int searchFilter
            , String searchText
            , String userId) {
        super(page, size);
        this.searchFilter = searchFilter;
        this.searchText = searchText;
        this.userId = userId;
    }
}
