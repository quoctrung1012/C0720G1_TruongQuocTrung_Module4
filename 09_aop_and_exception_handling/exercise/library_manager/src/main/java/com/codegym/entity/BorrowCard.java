package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "borrow_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_borrow")
    private String nameBorrow;
    @Column(name = "date_of_borrow", columnDefinition = "DATE")
    private String dateOfBorrow;
    @Column(name = "date_of_pay", columnDefinition = "DATE")
    private String dateOfPay;
    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "borrow_card_book", referencedColumnName = "id")
    private Book book;

}
