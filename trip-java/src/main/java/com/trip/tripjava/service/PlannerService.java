package com.trip.tripjava.service;

import com.trip.tripjava.dto.PlannerDTO;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.repository.PlannerRepository;
import com.trip.tripjava.repository.UserRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Builder
@Service
public class PlannerService {
    @Autowired
    PlannerRepository plannerRepository;

//    Planner 페이지에서 여행 시작일, 종료일 저장
    public void selectDate(PlannerDTO plannerDTO) {
        PlannerEntity plannerEntity = PlannerEntity.builder()
                .planner_startday(plannerDTO.getPlanner_startday())
                .planner_endday(plannerDTO.getPlanner_endday())
                .build();
        plannerRepository.save(plannerEntity);
    }

//    여행 시작일, 종료일 수정 후 저장
    public String updateDate(long planner_no, String planner_startday, String planner_endday){
    PlannerEntity planner = plannerRepository.findById(planner_no)
            .orElseThrow(()->new NoSuchElementException("저장된 정보가 없습니다."));

    PlannerEntity updatePlanner = PlannerEntity.builder()
            .planner_no(planner_no)
            .planner_startday(planner_startday)
            .planner_endday(planner_endday)
            .build();

    plannerRepository.save(updatePlanner);
        return "Update success";
    }

//    저장된 여행 날짜 조회
    public List<Object[]> searchDate(long planner_no) {
        List<Object[]> result = plannerRepository.searchByPlanner_no(planner_no);
        return result;
    }

//    저장된 여행 날짜 삭제
    public void deleteDate(long planner_no) {
        PlannerEntity plannerEntity = plannerRepository.findById(planner_no)
                .orElseThrow(()->new NoSuchElementException("삭제되지 않았습니다."));
        plannerRepository.delete(plannerEntity);
        }
}
