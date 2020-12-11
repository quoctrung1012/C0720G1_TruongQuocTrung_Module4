package com.codegym.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rent_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ren_type_name")
    private String renTypeName;
    @Column(name = "ren_type_cost")
    private String renTypeCost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<ServiceResort> resortListRentType;
}
