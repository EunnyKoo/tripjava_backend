package com.trip.tripjava.controller;

import com.trip.tripjava.dto.ItineraryDTO;
import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.service.ItineraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerary")
@Slf4j
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

    // 사용하지 않는 메소드
    @GetMapping("/")
    public ResponseEntity<List<ItineraryEntity>> getAllItineraries() {
        List<ItineraryEntity> itineraries = itineraryService.getAllItineraries();
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryEntity> getItineraryById(@PathVariable Long id) {
        ItineraryEntity itinerary = itineraryService.getItineraryById(id);
        return new ResponseEntity<>(itinerary, HttpStatus.OK);
    }


}
