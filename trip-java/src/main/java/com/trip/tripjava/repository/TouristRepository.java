package com.trip.tripjava.repository;

import com.trip.tripjava.entity.TouristEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepository extends JpaRepository<TouristEntity, String> {
    List<TouristEntity> findByAreacodeAndSigungucodeAndContenttypeid(String areacode, String sigungucode, String contenttypeid);
    List<TouristEntity> findByAddr1Contains(String addr1);

    // 주어진 위경도 주변의 숙소를 가져오는 메서드
    @Query(value = "SELECT * FROM tourist " +
            "WHERE contenttypeid = 32 AND SQRT(POW(ABS(mapx - :mapx), 2) + POW(ABS(mapy - :mapy), 2)) * 111.195 <= 10",
            nativeQuery = true)
    List<TouristEntity> findAccommodationsNearby(@Param("mapx") String mapx, @Param("mapy") String mapy);

}
