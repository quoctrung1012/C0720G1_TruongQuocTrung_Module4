package com.codegym.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "division_name")
    private String nameDivision;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeDivision;
}
