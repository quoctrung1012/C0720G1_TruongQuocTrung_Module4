package com.codegym.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "accompanied_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccompaniedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "accompanied_service_name")
    private String accompaniedService;
    @OneToMany(mappedBy = "accompaniedService", cascade = CascadeType.ALL)
    private List<ServiceResort> resortListAccompanied;
}
