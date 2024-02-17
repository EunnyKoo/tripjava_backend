package com.trip.tripjava.repository;

import com.trip.tripjava.entity.PlannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannerRepository extends JpaRepository<PlannerEntity,Long> {

}
