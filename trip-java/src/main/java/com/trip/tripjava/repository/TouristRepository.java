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

    // 주어진 위경도 주변의 숙소 가져오기
    @Query(value = "SELECT * FROM tourist " +
            "WHERE contenttypeid = 32 AND SQRT(POW(ABS(mapx - :mapx), 2) + POW(ABS(mapy - :mapy), 2)) * 111.195 <= 100 ",
            nativeQuery = true)
    List<TouristEntity> findAccommodationsNearby(@Param("mapx") String mapx, @Param("mapy") String mapy);

    // 숙소를 기준으로 주변의 식당 가져오는 쿼리
    @Query(value = "SELECT * FROM tourist " +
            "WHERE contenttypeid = 39 AND SQRT(POW(ABS(mapx - :mapx), 2) + POW(ABS(mapy - :mapy), 2)) * 111.195 <= 10 ",
            nativeQuery = true)
    List<TouristEntity> findRestaurantsNearby(@Param("mapx") String mapx, @Param("mapy") String mapy);

    // 숙소를 기준으로 주변의 관광지 가져오는 쿼리
    @Query(value = "SELECT * FROM tourist " +
            "WHERE contenttypeid = 12 AND SQRT(POW(ABS(mapx - :mapx), 2) + POW(ABS(mapy - :mapy), 2)) * 111.195 <= 10 ",
            nativeQuery = true)
    List<TouristEntity> findTouristSpotsNearby(@Param("mapx") String mapx, @Param("mapy") String mapy);

}
