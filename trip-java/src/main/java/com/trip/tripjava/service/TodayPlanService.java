package com.trip.tripjava.service;

import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.TodayPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodayPlanService {

    private final TodayPlanRepository todayPlanRepository;

    @Autowired
    public TodayPlanService(TodayPlanRepository todayPlanRepository) {
        this.todayPlanRepository = todayPlanRepository;
    }

    public TodayPlanEntity createTodayPlan(String today_date, long planner_no, List<String> contentid) {
        TodayPlanEntity todayPlan = new TodayPlanEntity();
        todayPlan.setToday_date(today_date);

        Map<String, Integer> contentSeqMap = new HashMap<>();

        for (int i = 0; i < contentid.size(); i++) {
            String id = contentid.get(i);
            int seq = i + 1;
            contentSeqMap.put(id, seq);
        }

//        todayPlan.setToday_seq(contentSeqMap.);


        return todayPlanRepository.save(todayPlan);
    }
}


