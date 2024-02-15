package com.trip.tripjava.controller;


import com.trip.tripjava.dto.TouristDTO;
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
    public String postData(@RequestBody TouristDTO touristDTO) {
        log.warn("title: {}", touristDTO.getTitle());
        // touristService.creatData(touristEntities);
        return "";
    }
}
