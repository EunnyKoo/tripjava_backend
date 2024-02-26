package com.trip.tripjava.repository;

import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.entity.PlannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long> {
    @Query("select c from ChecklistEntity c where c.planner.planner_no = :planner_no")
    List<ChecklistEntity> findByPlanner_Planner_no(long planner_no);

    List<ChecklistEntity> findAllByPlanner(PlannerEntity planner);
}
