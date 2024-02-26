package com.trip.tripjava.service;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.ItineraryRepository;
import com.trip.tripjava.repository.TodayPlanRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

    // 전체 itinerary 불러오기
    public List<ItineraryEntity> getAllItinerariesWithNativeQuery() {
        return itineraryRepository.findAllWithNativeQuery();
    }

    public ItineraryEntity getItineraryById(Long id) {
        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
        if (optionalItinerary.isPresent()) {
            return optionalItinerary.get();
        } else {
            throw new RuntimeException("Itinerary not found for id :: " + id);
        }
    }


//    public void deleteItineraryById(Long id) {
//        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
//        if (optionalItinerary.isPresent()) {
//            ItineraryEntity itinerary = optionalItinerary.get();
//
//            // itinerary에 연결된 today_plan 레코드를 모두 삭제
//            TodayPlanEntity todayPlan = itinerary.getToday_no();
//            if (todayPlan != null) {
//                todayPlanRepository.delete(todayPlan);
//            }
//
//            // itinerary 레코드 삭제
//            itineraryRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("Itinerary not found for id :: " + id);
//        }
//    }

//    public void deleteItineraryById(Long id) {
//        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
//        if (optionalItinerary.isPresent()) {
//            ItineraryEntity itinerary = optionalItinerary.get();
//
//            // ItineraryEntity에 연결된 TodayPlanEntity 삭제
//            if (itinerary.getToday_no() != null) {
//                TodayPlanEntity todayPlan = itinerary.getToday_no();
//                deleteTodayPlan(todayPlan);
//            }
//
//            // ItineraryEntity 삭제
//            itineraryRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("Itinerary not found for id :: " + id);
//        }
//    }
//
//    private void deleteTodayPlan(TodayPlanEntity todayPlan) {
//        try {
//            // todayPlanRepository를 사용하여 주어진 TodayPlanEntity를 삭제합니다.
//            todayPlanRepository.delete(todayPlan);
//            // 삭제 작업이 성공적으로 수행되면 로그를 출력합니다.
//            log.info("TodayPlanEntity 삭제 성공: {}", todayPlan);
//        } catch (Exception e) {
//            // 삭제 작업 중 예외가 발생하면 오류 메시지를 출력합니다.
//            log.error("TodayPlanEntity 삭제 중 오류 발생: {}", e.getMessage());
//            // 필요한 경우 예외를 다시 throw하여 상위 호출자에게 전파합니다.
//            throw new RuntimeException("TodayPlanEntity 삭제 중 오류 발생", e);
//        }
//    }

    @Transactional
    public void deleteItineraryById(Long id) {
        itineraryRepository.deleteItineraryByIdWithNativeQuery(id);
    }

}
