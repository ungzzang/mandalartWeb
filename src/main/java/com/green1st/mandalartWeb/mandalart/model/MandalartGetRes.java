package com.green1st.mandalartWeb.mandalart.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Schema(title = "만다라트 조회 정보")
@Setter
public class MandalartGetRes {
    @Schema(title = "project_id")
    private long projectId;
    @Schema(description = "만다라트 id 리스트")
    private List<MandalartGetDto> mandalartIdGetList;
    private int completedCount;
    private List<ColorCodes> colorCodes;

    public List<MandalartGetDto> getMandalartIdGetList() {
        return mandalartIdGetList;
    }

    public int getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(int completedCount) {
        this.completedCount = completedCount;
    }

    public void setColorCodes(List<ColorCodes> colorCodes) {
        this.colorCodes = colorCodes;
    }
}
