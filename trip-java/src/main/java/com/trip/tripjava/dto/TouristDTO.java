package com.trip.tripjava.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TouristDTO {
    private String contentid;
    private String contenttypeid;
    private String title;
    private String addr1;
    private String areacode;
    private String sigungucode;
    private String firstimage;
    private String mapx;
    private String mapy;
    //private double distance;
}
