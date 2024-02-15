package com.trip.tripjava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@Table(name = "today_plan")
@NoArgsConstructor
@AllArgsConstructor
public class TodayPlanEntity {

    @Id
    @Column(name = "today_no", nullable = false)
    private int today_no;

    @ManyToOne
    @JoinColumn(name = "attraction_no", referencedColumnName = "attraction_no")
    private AttractionEntity attraction_no;

    @ManyToOne
    @JoinColumn(name = "planner_no", referencedColumnName = "planner_no")
    private TripEntity planner_no;

    @Column(name = "today_date", nullable = false)
    private String today_date;

    @Column(name = "today_seq", nullable = false)
    private int today_seq;
}