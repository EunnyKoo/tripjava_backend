package com.trip.tripjava.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "itinerary")
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryEntity {

    @Id
    @Column(name = "itinerary_no", nullable = false)
    private long itinerary_no;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "today_no", referencedColumnName = "today_no")
    private TodayPlanEntity today_no;

    @Column(name = "start_time", nullable = false)
    private String start_time;

    @Column(name = "end_time", nullable = false)
    private String end_time;

    @Column(name = "memo", nullable = false)
    private String memo;

    @Column(name = "planner_title", nullable = false)
    private String planner_title;

    @Column(name = "price", nullable = false)
    private String price;

}
