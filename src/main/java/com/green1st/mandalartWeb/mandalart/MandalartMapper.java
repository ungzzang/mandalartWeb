package com.green1st.mandalartWeb.mandalart;


import com.green1st.mandalartWeb.mandalart.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MandalartMapper {
    List<MandalartGetRes> getMandalart (MandalartGetReq p);
    int patchMandalart (MandalartPostReq p);
    int patchMandalartCompletedFg (MandalartPostReq p);
    List<MandalartGetImminentRes> getImProject (MandalartGetImminentReq p);
    List<MandalartGetRes> selSiblingMandalart(long mandalartId);
    List<MandalartCalendarGetRes> selMandalartCalendar (MandalartCalendarGetReq p);
    MandalartGetRes selMandalartByMandalartId (long mandalartId);
    MandalartChildDate selChildMandalartMinStartDateAndMaxFinishDateByMandalartId(long mandalartId);
}
