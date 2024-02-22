package com.trip.tripjava.controller;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itinerary")
public class ItineraryController {
    private final ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @PostMapping("/add")
    public ResponseEntity<ItineraryEntity> addItinerary(@RequestBody ItineraryEntity itinerary) {
        ItineraryEntity savedItinerary = itineraryService.saveItinerary(itinerary);
        return new ResponseEntity<>(savedItinerary, HttpStatus.CREATED);
    }
}
