package com.trip.tripjava.repository;

import com.trip.tripjava.entity.TodayPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodayPlanRepository extends JpaRepository<TodayPlanEntity, Integer> {
}

