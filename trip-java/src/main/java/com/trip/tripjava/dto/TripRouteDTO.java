package com.trip.tripjava.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
