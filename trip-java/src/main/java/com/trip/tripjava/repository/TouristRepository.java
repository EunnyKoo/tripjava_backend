package com.trip.tripjava.repository;

import com.trip.tripjava.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, Integer> {

}
