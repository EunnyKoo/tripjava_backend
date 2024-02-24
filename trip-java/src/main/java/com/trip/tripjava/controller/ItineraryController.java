package com.trip.tripjava.controller;

import com.trip.tripjava.dto.ItineraryDTO;
import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.service.ItineraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 생성된 itinerary 확인
//    @GetMapping("/{itineraryno}")
//    public ResponseEntity<ItineraryDTO> viewItineraries(@PathVariable long itineraryno){
//        try{
//            ItineraryDTO itineraryDTO = itineraryService.viewItineraries(itineraryno);
//                if(itineraryDTO == null){
//                    return ResponseEntity.notFound().build();
//                }
//        } catch (Exception e){
//            log.error(e.getMessage());
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }

}
