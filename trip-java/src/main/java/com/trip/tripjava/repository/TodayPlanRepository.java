package com.trip.tripjava.repository;

import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodayPlanRepository extends JpaRepository<TodayPlanEntity, Integer> {
    @Query(value = "SELECT * FROM today_plan WHERE planner_no = :planner_no", nativeQuery = true)
    List<TodayPlanEntity> findByPlannerNo(@Param("planner_no") Long plannerNo);

    @Query(value = "SELECT * FROM today_plan WHERE today_type = :days AND planner_no = :plannerNo ORDER BY today_no ASC LIMIT 1", nativeQuery = true)
    TodayPlanEntity findByTodayTypeAndPlannerNo(@Param("days") Integer days, @Param("plannerNo") Long plannerNo);
}

