package com.trip.tripjava.service;

import com.trip.tripjava.dto.TodayPlanDTO;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.TodayPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodayPlanService {
    private final TodayPlanRepository todayPlanRepository;

    @Autowired
    public TodayPlanService(TodayPlanRepository todayPlanRepository) {
        this.todayPlanRepository = todayPlanRepository;
    }

    public void createPlanData(TodayPlanDTO todayPlanDTO) {
        TodayPlanEntity todayPlanEntity = convertToEntity(todayPlanDTO);
        todayPlanRepository.save(todayPlanEntity);
    }

    public TodayPlanDTO getTodayPlanData(int today_no) {
        TodayPlanEntity todayPlanEntity = todayPlanRepository.findById(today_no)
                .orElseThrow(() -> new RuntimeException("데이터를 찾을 수 없습니다."));
        return convertToDTO(todayPlanEntity);
    }

    public void updatePlanData(int today_no, TodayPlanDTO todayPlanDTO) {
        TodayPlanEntity todayPlanEntity = todayPlanRepository.findById(today_no)
                .orElseThrow(() -> new RuntimeException("데이터를 찾을 수 없습니다."));
        updateEntity(todayPlanEntity, todayPlanDTO);
        todayPlanRepository.save(todayPlanEntity);
    }

    public void deletePlanData(int today_no) {
        TodayPlanEntity todayPlanEntity = todayPlanRepository.findById(today_no)
                .orElseThrow(() -> new RuntimeException("데이터를 찾을 수 없습니다."));
        todayPlanRepository.delete(todayPlanEntity);
    }

    private TodayPlanEntity convertToEntity(TodayPlanDTO todayPlanDTO) {
        TodayPlanEntity todayPlanEntity = new TodayPlanEntity();
        todayPlanEntity.setToday_no(todayPlanDTO.getToday_no());
        todayPlanEntity.setToday_date(todayPlanDTO.getToday_date());
        todayPlanEntity.setToday_seq(todayPlanDTO.getToday_seq());
        return todayPlanEntity;
    }

    private TodayPlanDTO convertToDTO(TodayPlanEntity todayPlanEntity) {
        TodayPlanDTO todayPlanDTO = new TodayPlanDTO();
        todayPlanDTO.setToday_no(todayPlanEntity.getToday_no());
        todayPlanDTO.setToday_date(todayPlanEntity.getToday_date());
        todayPlanDTO.setToday_seq(todayPlanEntity.getToday_seq());
        return todayPlanDTO;
    }

    private void updateEntity(TodayPlanEntity todayPlanEntity, TodayPlanDTO todayPlanDTO) {
        todayPlanEntity.setToday_date(todayPlanDTO.getToday_date());
        todayPlanEntity.setToday_seq(todayPlanDTO.getToday_seq());
    }
}

