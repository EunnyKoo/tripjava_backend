package com.trip.tripjava.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class TouristDTO {
    private int contentid;
    private String contenttypeid;
    private String title;
    private String addr1;
    private String areacode;
    private String sigungucode;
    private String firstimage;
    private String mapx;
    private String mapy;
    private double distance;
}
