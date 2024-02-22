package com.trip.tripjava.controller;

import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import statement added

@RestController
public class ChecklistController {
    @Autowired
    ChecklistService checklistService;

    // 체크리스트 확인
    @GetMapping("planner/checklist/select")
    public List<ChecklistEntity> getAllChecklists() {
        return checklistService.getAllChecklists();
    }

    // 체크리스트 저장
    @PostMapping("planner/checklist/add")
    public ChecklistEntity createChecklistData(@RequestBody ChecklistEntity checklist) {
        return checklistService.addChecklist(checklist);
    }

    // 체크리스트 수정
    @PutMapping("planner/checklist/{checklistId}")
    public ChecklistEntity updateChecklistData(@PathVariable("checklistId") long checklistId, @RequestBody ChecklistEntity checklist) {
        checklist.setChecklist_no(checklistId);
        return checklistService.updateChecklist(checklist);
    }

    // 체크리스트 삭제
    @DeleteMapping("/planner/checklist/{checklistId}")
    public void deleteChecklistData(@PathVariable("checklistId") long checklistId) {
        checklistService.deleteChecklist(checklistId);
    }
}
