package com.trip.tripjava.service;

import com.trip.tripjava.dto.PlanDTO;
import com.trip.tripjava.dto.TripRouteDTO;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.PlannerRepository;
import com.trip.tripjava.repository.TodayPlanRepository;
import com.trip.tripjava.repository.TouristRepository;
import com.trip.tripjava.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TripRouteService {
    @Autowired
    PlannerRepository plannerRepository;

    @Autowired
    TodayPlanRepository todayPlanRepository;

    @Autowired
    TouristRepository touristRepository;

    @Autowired
    UserRepository userRepository;

    // 여행 경로 저장
    public String createTripRoute(TripRouteDTO tripRouteDTO) {
        PlannerEntity createPlanner = PlannerEntity.builder()
                .planner_startday(tripRouteDTO.getStart_day())
                .planner_endday(tripRouteDTO.getEnd_day())
                .planner_title(tripRouteDTO.getPlanner_title())
                .user(userRepository.findById(tripRouteDTO.getUserid()).get())
                .build();
        PlannerEntity planner = plannerRepository.save(createPlanner);

        for (PlanDTO plan : tripRouteDTO.getPlans()) {
            TodayPlanEntity todayPlan = TodayPlanEntity.builder()
                    .contentid(touristRepository.findById(plan.getContentid()).get())
                    .planner_no(planner)
                    .today_type(plan.getType())
                    .build();

            // 확인 로그
            TodayPlanEntity savedTodayPlan = todayPlanRepository.save(todayPlan);
            log.warn("저장됨 {}", savedTodayPlan.getToday_no());
        }

        return "여행경로가 저장되었습니다.";
    }
}
