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

//    @Autowired
//    UserRepository userRepository;
//    Planner 페이지에서 시작일, 종료일 저장
public void selectDate(PlannerDTO plannerDTO) {
//    public void selectDate(PlannerDTO plannerDTO, Long id) {
//        UserEntity userEntity = userRepository.findById(id);

        PlannerEntity plannerEntity = PlannerEntity.builder()
                .planner_startday(plannerDTO.getPlanner_startday())
                .planner_endday(plannerDTO.getPlanner_endday())
//                .planner_region(plannerDTO.getPlanner_region())
//                .user(userEntity.getId())
                .build();

        plannerRepository.save(plannerEntity);
    }
    public void deleteDate(long planner_no) {
        PlannerEntity plannerEntity = plannerRepository.findById(String.valueOf(planner_no))
                .orElseThrow(()->new NoSuchElementException("plannerdate patch : planner_no is wrong"));
        plannerRepository.delete(plannerEntity);
        }
}
