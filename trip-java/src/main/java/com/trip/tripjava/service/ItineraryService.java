package com.trip.tripjava.service;

import com.trip.tripjava.dto.ItineraryDTO;
import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public ItineraryEntity saveItinerary(ItineraryEntity itinerary) {
        return itineraryRepository.save(itinerary);
    }

//    public ItineraryDTO viewItineraries(long itineraryno) {
//        // itinerary ID를 기반으로 해당
//    }
}
