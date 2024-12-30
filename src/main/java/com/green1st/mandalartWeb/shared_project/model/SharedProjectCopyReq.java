package com.green1st.mandalartWeb.shared_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class SharedProjectCopyReq {
    @JsonIgnore
    @NotNull
    @Positive
    private long projectId;
    @NotNull
    @Positive
    private long copyProjectId;
    @NotNull
    @Length(min = 10, max = 100)
    private String userId;
}
