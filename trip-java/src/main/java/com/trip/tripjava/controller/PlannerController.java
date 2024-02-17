package com.trip.tripjava.controller;

import com.trip.tripjava.dto.PlannerDTO;
import com.trip.tripjava.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planner")
public class PlannerController {

    @Autowired
    PlannerService plannerService;

//    1. 플래너 페이지 랜더
    @GetMapping("")
    public String plannerPage(){
        return "planner";
    }

//    2. 시작날짜 종료날짜 지정
    @PostMapping("")
    public void selectDate(@RequestBody PlannerDTO plannerDTO) {
        plannerService.selectDate(plannerDTO);
    }

//    3. 저장된 날짜 삭제
    @DeleteMapping("")
    public void deleteDate(@RequestParam long planner_no) {
        plannerService.deleteDate(planner_no);
    }
}
