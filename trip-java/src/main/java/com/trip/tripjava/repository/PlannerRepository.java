package com.trip.tripjava.repository;

import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannerRepository extends JpaRepository<PlannerEntity,Long> {

//    지정날짜 search
    @Query("select b.planner_startday, b.planner_endday from PlannerEntity b where b.planner_no = :planner_no")
    List<Object[]> searchByPlanner_no(@Param("planner_no") Long planner_no);

    List<PlannerEntity> findByUser_Id(String id);
}
