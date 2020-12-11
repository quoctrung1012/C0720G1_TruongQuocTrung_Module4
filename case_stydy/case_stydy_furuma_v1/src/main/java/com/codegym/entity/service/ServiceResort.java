package com.codegym.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String nameService;
    @Column(name = "service_area")
    private Double area;
    @Column(name = "service_cost")
    private Double cost;
    @Column(name = "service_max_people")
    private Integer maxPeople;
    @Column(name = "standard_room")
    private String standard;
    @Column(name ="description_other_convenience")
    private String description;
    @Column(name = "number_of_floors")
    private Integer numOfFloors;
    @ManyToOne
    @JoinColumn(name = "service_accompanied")
    private AccompaniedService accompaniedService;

    @ManyToOne
    @JoinColumn(name = "rent_type")
    private RentType rentType;
}
