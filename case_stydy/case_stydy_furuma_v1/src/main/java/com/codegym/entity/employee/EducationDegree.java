package com.codegym.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "education_degree_name")
    private String nameEducationDegree;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeEducationDegree;
}
