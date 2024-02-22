package com.trip.tripjava.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChecklistDTO {
    private long checklist_no;
    private long planner_no;
    private String ingredient;
    private boolean ingredient_check;
}
