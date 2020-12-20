package com.codegym.entity.contract_detail;

import com.codegym.entity.contract_detail.ContractDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "attach_service_name")
    private String attachName;
    @Column(name = "attach_service_cost")
    private Double attachCost;
    @Column(name = "attach_service_unit")
    private Integer attachUnit;
    @Column(name = "attach_service_status")
    private String attachStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attachService")
    @JsonBackReference
    List<ContractDetail> contractDetailsAttachService;

}
