package com.trip.tripjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripRouteDTO {
    private String start_day;
    private String end_day;
    private int days;
    private String userid;
    private String planner_title;
    private List<PlanDTO> plans;
}
