package com.trip.tripjava.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanDTO {
    private String contentid;
    private int type;
    private String today_date;
    private TouristDTO tourist;
}
