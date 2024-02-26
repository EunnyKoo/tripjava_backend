package com.trip.tripjava.service;

import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.repository.ChecklistRepository;
import com.trip.tripjava.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    PlannerRepository plannerRepository;

    // 체크리스트 추가
    public ChecklistEntity addChecklist(long planner_no, ChecklistEntity checklist) {
        PlannerEntity planner = plannerRepository.findById(planner_no).orElseThrow(()-> new RuntimeException("Planner not found"));
        checklist.setPlanner(planner);
        return checklistRepository.save(checklist);
    }

    // 체크리스트 수정
    public ChecklistEntity updateChecklist(ChecklistEntity checklist) {
        return checklistRepository.save(checklist);
    }

    // 체크리스트 삭제
    public void deleteChecklist(long checklistId) {
        checklistRepository.deleteById(checklistId);
    }

    // 모든 체크리스트 가져오기
    public List<ChecklistEntity> getAllChecklists(long planner_no) {
        return checklistRepository.findByPlanner_Planner_no(planner_no);
    }
}
