package com.trip.tripjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripRouteDTO {
    private String start_day;
    private String end_day;
    private int days;
    private String planner_title;
    private AccommodationDTO accommodation;
    private List<PlanDTO> plan1;
    private List<PlanDTO> plan2;
    private List<PlanDTO> plan3;
    private List<PlanDTO> plan4;
    private List<PlanDTO> plan5;
}
