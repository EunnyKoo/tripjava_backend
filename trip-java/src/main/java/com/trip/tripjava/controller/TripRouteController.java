package com.trip.tripjava.controller;

import com.trip.tripjava.dto.TripRouteDTO;
import com.trip.tripjava.service.TripRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 생성된 경로 확인
    @GetMapping("/{plannerId}")
    public ResponseEntity<TripRouteDTO> viewRoutes(@PathVariable long plannerId) {
        try {
            TripRouteDTO tripRouteDTO = tripRouteService.viewTripRoute(plannerId);
            if (tripRouteDTO == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(tripRouteDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
