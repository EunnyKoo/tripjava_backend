package com.trip.tripjava.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@Table(name = "today_plan")
@NoArgsConstructor
@AllArgsConstructor
public class TodayPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "today_no", nullable = false)
    private int today_no;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contentid", referencedColumnName = "contentid")
    private TouristEntity contentid;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "planner_no", referencedColumnName = "planner_no")
    private PlannerEntity planner_no;

    @Column(name = "today_date")
    private String today_date;

    @Column(name = "today_type", nullable = false)
    private int today_type;
}