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

//    1. 시작날짜 종료날짜 create
    @PostMapping("")
    public void selectDate(@RequestBody PlannerDTO plannerDTO) {
        plannerService.selectDate(plannerDTO);
    }

//    2. 지정 날짜 update
    @PatchMapping("")
    public String updateDate(@RequestBody PlannerDTO plannerDTO){
        return plannerService.updateDate(plannerDTO);
    }


//    3. 저장된 날짜 search
    @GetMapping("/search")
    public List<Object[]> searchPlanner(@RequestParam("planner_no") long planner_no) {
        return plannerService.searchDate(planner_no);
    }


//    4. 저장된 날짜 delete
    @DeleteMapping("")
    public void deleteDate(@RequestParam("planner_no") long planner_no) {
        plannerService.deleteDate(planner_no);
    }
}
