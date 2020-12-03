package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_customer")
    private String nameCustomer;
    @Column(name = "date_of_purchase", columnDefinition = "DATE")
    private String dateOfPurchase;
}
