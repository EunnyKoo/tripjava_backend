package com.trip.tripjava.controller;

import com.trip.tripjava.dto.TouristDTO;
import com.trip.tripjava.entity.TouristEntity;
import com.trip.tripjava.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private TouristRepository touristRepository;

    @GetMapping("")
    public ResponseEntity<Map<String, List<TouristDTO>>> getDestinationInfoByAddress(@RequestParam String addr1) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 관광지 엔티티 가져오기

            List<TouristEntity> touristEntities = touristRepository.findByAddr1Contains(addr1);

            // 엔티티를 DTO로 변환
            List<TouristDTO> touristSpots = convertToDTO(touristEntities);
            response.put("touristSpots", touristSpots);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{areacode}/{sigungucode}")
    public ResponseEntity<Map<String, List<TouristDTO>>> getDestinationInfo(@PathVariable String areacode, @PathVariable String sigungucode) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 관광지 엔티티 가져오기
            List<TouristEntity> touristEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "12");

            // 엔티티를 DTO로 변환
            List<TouristDTO> touristSpots = convertToDTO(touristEntities);
            response.put("touristSpots", touristSpots);

            // 음식점 엔티티 가져오기
            List<TouristEntity> restaurantEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "39");

            // 엔티티를 DTO로 변환
            List<TouristDTO> restaurants = convertToDTO(restaurantEntities);
            response.put("restaurants", restaurants);

            // 숙소 엔티티 가져오기
            List<TouristEntity> accommodationEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "32");

            // 엔티티를 DTO로 변환
            List<TouristDTO> accommodations = convertToDTO(accommodationEntities);
            response.put("accommodations", accommodations);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    private List<TouristDTO> convertToDTO(List<TouristEntity> entities) {
        List<TouristDTO> dtos = new ArrayList<>();
        for (TouristEntity entity : entities) {
            TouristDTO dto = new TouristDTO();
            dto.setContentid(entity.getContentid());
            dto.setContenttypeid(entity.getContenttypeid());
            dto.setTitle(entity.getTitle());
            dto.setAddr1(entity.getAddr1());
            dto.setAreacode(entity.getAreacode());
            dto.setSigungucode(entity.getSigungucode());
            dto.setFirstimage(entity.getFirstimage());
            dto.setMapx(entity.getMapx());
            dto.setMapy(entity.getMapy());
            dtos.add(dto);
        }
        return dtos;
    }
}
