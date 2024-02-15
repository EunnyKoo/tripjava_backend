package com.trip.tripjava.controller;


import com.trip.tripjava.entity.TouristEntity;
import com.trip.tripjava.service.TouristService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TouristController {
    @Autowired
    TouristService touristService;
    @PostMapping("/test")
    // dto 바꾸기
    public String postData(@RequestBody List<TouristEntity> touristEntities) {
        log.info(touristEntities.toString());
        touristService.creatData(touristEntities);
        return "";
    }
}
