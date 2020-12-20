package com.codegym.entity.service;

import com.codegym.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "service")
//@Data
//@NoArgsConstructor
@AllArgsConstructor
public class ServiceResort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_name")
    @NotBlank(message = "Please input not empty")
    private String nameService;

    @Column(name = "service_area")
    @NotNull(message = "Please input not empty")
    @Min(value = 30, message = "Area min 30m2")
    private Double area;

    @Column(name = "service_cost")
    @NotNull(message = "Please input not empty")
    @Min(value = 200, message = "Cost service min 200 USD")
    private Double cost;

    @Column(name = "service_max_people")
    @NotNull(message = "Please input not empty")
    @Min(value = 5, message = "Max people min 0")
    private Integer maxPeople;

    @Column(name = "standard_room")
    //@NotBlank(message = "Please input not empty")
    private String standard;

    @Column(name = "number_of_floors")
    //@NotNull(message = "Please input not empty")
    @Min(value = 1, message = "Number of floors min 0")
    private Integer numOfFloors;

    @Column(name = "pool_area")
    //@NotNull(message = "Please input not empty")
    @Min(value = 30, message = "Pool Area min 30m2")
    private Double poolArea;

    @Column(name ="description_other_convenience")
    // @NotBlank(message = "Please input not empty")
    private String description;

    @ManyToOne
    @JoinColumn(name = "rent_type", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type", referencedColumnName = "id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "serviceResort", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contractsService;

    public String getCustomerCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "SV-" + numberFormat.format(this.id);
    }

    public ServiceResort() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Integer getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(Integer numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContractsService() {
        return contractsService;
    }

    public void setContractsService(List<Contract> contractsService) {
        this.contractsService = contractsService;
    }
}
