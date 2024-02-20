package com.trip.tripjava.repository;

import com.trip.tripjava.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, String> {
    List<TouristEntity> findByAreacodeAndSigungucodeAndContenttypeid(String areacode, String sigungucode, String contenttypeid);
    List<TouristEntity> findByAddr1Contains(String addr1);
}
