package com.trip.tripjava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="planner")
public class PlannerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planner_no", nullable = false)
    private Long planner_no;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "planner_startday", nullable = false, length = 50)
    private String planner_startday;

    @Column(name = "planner_endday", nullable = false, length = 50)
    private String planner_endday;

    @Column(name = "planner_region", nullable = true, length = 50)
    private String planner_region;

}