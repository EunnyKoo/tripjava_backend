package com.trip.tripjava.dto;


import com.trip.tripjava.entity.TodayPlanEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodayPlanDTO {
    private int today_no;
    private long contentid;
    private long planner_no;
    private String today_date;
    private int today_seq;

    public TodayPlanDTO (int today_no, String today_date, int today_seq) {
        this.today_no = today_no;
        this.today_date = today_date;
        this.today_seq = today_seq;
    }

    public static TodayPlanDTO fromEntity(TodayPlanEntity entity) {
        return new TodayPlanDTO(entity.getToday_no(), entity.getToday_date(), entity.getToday_seq());
    }

}
