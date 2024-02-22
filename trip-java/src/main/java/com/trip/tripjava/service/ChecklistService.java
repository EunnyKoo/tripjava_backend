package com.trip.tripjava.service;

import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    ChecklistRepository checklistRepository;

    // 체크리스트 추가
    public ChecklistEntity addChecklist(ChecklistEntity checklist) {
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
    public List<ChecklistEntity> getAllChecklists() {
        return checklistRepository.findAll();
    }
}
