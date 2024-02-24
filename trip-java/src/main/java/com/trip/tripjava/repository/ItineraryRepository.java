package com.trip.tripjava.repository;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

}
