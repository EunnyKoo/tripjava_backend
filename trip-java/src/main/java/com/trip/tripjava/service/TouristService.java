package com.trip.tripjava.service;

import com.trip.tripjava.entity.TouristEntity;
import com.trip.tripjava.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    @Autowired
    TouristRepository tourListRepository;
    public void creatData(List<TouristEntity> touristEntities) {
        for(TouristEntity entity : touristEntities ) {
            tourListRepository.save(entity);
            System.out.println(entity);
        }
    }

    //  두 지점 간의 거리를 계산하는 함수
    public double calculateDistance(double mapx, double mapy, String unit ) {
        double theta = mapy - 36.5907913004;
        double dist = Math.sin(Math.toRadians(mapx)) * Math.sin(Math.toRadians(126.4575227298)) + Math.cos(Math.toRadians(mapx)) * Math.cos(Math.toRadians(126.4575227298)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        if (unit.equals("meter")) {
            dist = dist * 1609.344;
        }
        return dist;
    }
}
