package com.trip.tripjava.repository;

import com.trip.tripjava.entity.ChecklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long> {
}
