package com.green1st.mandalartWeb.project.model;

import com.green1st.mandalartWeb.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@ToString
@Schema(description = "프로젝트 리스트 조회 모델")
public class ProjectGetReq  extends Paging {
    @NotNull(message = "검색필터가 빈값입니다.")
    @Schema(description = "검색 필터(1:제목 2:내용 3: 제목 + 내용)", example = "1")
    private int searchFilter;
    @Nullable
    @Schema(description = "검색 단어", example = "찾는 단어")
    private String searchText;
    @NotNull(message = "사용자 아이디는 빈값일 수 없습니다.")
    @Length(min = 10, max = 100)
    @Schema(description = "로그인한 사용자 아이디", example = "test@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;

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
