package com.trip.tripjava.service;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.ItineraryRepository;
import com.trip.tripjava.repository.TodayPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    private TodayPlanRepository todayPlanRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public ItineraryEntity saveItinerary(ItineraryEntity itinerary) {
        return itineraryRepository.save(itinerary);
    }

    // 사용하지 않음
    public List<ItineraryEntity> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    public ItineraryEntity getItineraryById(Long id) {
        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
        if (optionalItinerary.isPresent()) {
            return optionalItinerary.get();
        } else {
            throw new RuntimeException("Itinerary not found for id :: " + id);
        }
    }


}
