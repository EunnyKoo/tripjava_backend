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
}
