package com.trip.tripjava.controller;

import com.trip.tripjava.dto.TodayPlanDTO;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.service.TodayPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class TodayPlanController {

    private final TodayPlanService todayPlanService;

    @Autowired
    public TodayPlanController(TodayPlanService todayPlanService) {
        this.todayPlanService = todayPlanService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTodayPlanData(@RequestParam int today_no, @RequestParam String contentid, @RequestParam long planner_no, @RequestParam String today_date) {
        todayPlanService.createPlanData(today_no, contentid, planner_no, today_date);
        return ResponseEntity.ok("데이터 생성 완료");
    }

    @GetMapping("/{today_no}")
    public ResponseEntity<TodayPlanDTO> getTodayPlanData(@PathVariable int today_no) {
        TodayPlanDTO todayPlanDTO = todayPlanService.getTodayPlanData(today_no);
        return ResponseEntity.ok(todayPlanDTO);
    }

    @PutMapping("/{today_no}")
    public ResponseEntity<String> updateTodayPlanData(@PathVariable int today_no, @RequestBody TodayPlanDTO todayPlanDTO) {
        todayPlanService.updatePlanData(today_no, todayPlanDTO);
        return ResponseEntity.ok("데이터 업데이트 완료");
    }

    @DeleteMapping("/{today_no}")
    public ResponseEntity<String> deleteTodayPlanData(@PathVariable int today_no) {
        todayPlanService.deletePlanData(today_no);
        return ResponseEntity.ok("데이터 삭제 완료");
    }
}


