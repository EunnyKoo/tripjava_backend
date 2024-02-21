package com.trip.tripjava.controller;

import com.trip.tripjava.dto.TripRouteDTO;
import com.trip.tripjava.service.TripRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/planner/trip-route")
public class TripRouteController {
    @Autowired
    TripRouteService tripRouteService;

    @PostMapping("")
    public ResponseEntity<String> createRoutes(@RequestBody TripRouteDTO tripRouteDTO) {
        try {
            String result = tripRouteService.createTripRoute(tripRouteDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body("서버 오류입니다.");
        }
    }
}
