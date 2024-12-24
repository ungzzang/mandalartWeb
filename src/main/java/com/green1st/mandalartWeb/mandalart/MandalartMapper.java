package com.green1st.mandalartWeb.mandalart;


import com.green1st.mandalartWeb.mandalart.model.MandalartGetReq;
import com.green1st.mandalartWeb.mandalart.model.MandalartGetRes;
import com.green1st.mandalartWeb.mandalart.model.MandalartPostDto;
import com.green1st.mandalartWeb.mandalart.model.MandalartPostReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MandalartMapper {
    List<MandalartGetRes> getMandalart (MandalartGetReq p);
    List<MandalartPostDto>  patchMand (MandalartPostReq p);

}
