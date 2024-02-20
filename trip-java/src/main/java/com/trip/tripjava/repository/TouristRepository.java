package com.trip.tripjava.repository;

import com.trip.tripjava.dto.TouristDTO;
import com.trip.tripjava.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, String> {
//    @Query("SELECT new com.trip.tripjava.dto.TouristDTO(t.contentid, t.contenttypeid, t.title, t.addr1, t.areacode, t.sigungucode, t.firstimage, t.mapx, t.mapy) FROM TouristEntity t WHERE t.areacode = :areacode AND t.sigungucode = :sigungucode AND t.contenttypeid = :contenttypeid")
//    List<TouristDTO> findByAreacodeAndSigungucodeAndContenttypeid(@Param("areacode") String areacode, @Param("sigungucode") String sigungucode, @Param("contenttypeid") String contenttypeid);
    List<TouristEntity> findByAreacodeAndSigungucodeAndContenttypeid(String areacode, String sigungucode, String contenttypeid);
}
