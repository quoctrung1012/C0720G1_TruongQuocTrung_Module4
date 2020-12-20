package com.codegym.entity.contract;

import com.codegym.entity.contract_detail.ContractDetail;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceResort;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_start_day", columnDefinition = "DATE")
    private String startDate;

    @Column(name = "contract_end_day", columnDefinition = "DATE")
    private String endDate;

    @Column(name = "contract_deposit")
    @NotNull(message = "Please input not empty")
    @PositiveOrZero(message = "Imported data must be greater than or equal to zero")
    private Double deposit = 0.0;

    @Column(name = "contract_total")
    @NotNull(message = "Please input not empty")
    @Positive(message = "Imported data must be greater than or equal to zero")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ServiceResort serviceResort;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @JsonBackReference
    List<ContractDetail> contractDetailsContract;

    public String getContractCode() {
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "HD-" + numberFormat.format(this.id);
    }

    public Double getTotalCost() {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        Long days = DAYS.between(start, end);
        Double attachServiceCost = 0.0;
        Double serviceCost = 0.0;
        if (contractDetailsContract.size() == 0) {
            attachServiceCost = 0.0;
        } else {
            for (ContractDetail contractDetail : contractDetailsContract) {
                attachServiceCost += (contractDetail.getAttachService().getAttachCost()) * contractDetail.getQuantity();
            }
        }
        if (this.serviceResort == null) {
            serviceCost = 0.0;
        } else {
            serviceCost = this.serviceResort.getCost() * this.serviceResort.getRentType().getRenTypeCost() * days;
        }
        return serviceCost + attachServiceCost;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        LocalDate startDate;
        LocalDate endDate;
        try {
            startDate = LocalDate.parse(contract.getStartDate());
            endDate = LocalDate.parse(contract.getEndDate());
            if (endDate.compareTo(startDate) <= 0) {
                errors.rejectValue("endDate", "date.compare");
                errors.rejectValue("startDate", "date.compare");
            }
        } catch (Exception e) {
            errors.rejectValue("endDate", "date.empty");
            errors.rejectValue("startDate", "date.empty");
        }
    }
}

