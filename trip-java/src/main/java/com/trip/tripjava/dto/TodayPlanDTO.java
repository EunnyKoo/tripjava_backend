package com.trip.tripjava.dto;


import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.entity.TouristEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodayPlanDTO {
    private int today_no;
    private String contentid;
    private long planner_no;
    private String today_date;
    private int today_seq;
}
