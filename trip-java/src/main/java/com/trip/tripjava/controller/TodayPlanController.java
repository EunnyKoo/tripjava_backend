package com.trip.tripjava.controller;

import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.service.TodayPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planner")
public class TodayPlanController {

    private final TodayPlanService todayPlanService;

    @Autowired
    public TodayPlanController(TodayPlanService todayPlanService) {
        this.todayPlanService = todayPlanService;
    }

    @PostMapping
    public ResponseEntity<TodayPlanEntity> createTodayPlan(
            @RequestParam("today_date") String today_date,
            @RequestParam("planner_no") int planner_no,
            @RequestBody List<String> contentid
    ) {
        TodayPlanEntity todayPlan = todayPlanService.createTodayPlan(today_date, planner_no, contentid);
        return ResponseEntity.status(HttpStatus.CREATED).body(todayPlan);
    }

}


