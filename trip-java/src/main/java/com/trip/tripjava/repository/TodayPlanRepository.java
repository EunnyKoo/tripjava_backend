package com.trip.tripjava.repository;

import com.trip.tripjava.entity.TodayPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayPlanRepository extends JpaRepository<TodayPlanEntity, Integer> {
        TodayPlanEntity saveTouristAndNo (long contentid, String planner_no, String today_date, int today_seq);
}
