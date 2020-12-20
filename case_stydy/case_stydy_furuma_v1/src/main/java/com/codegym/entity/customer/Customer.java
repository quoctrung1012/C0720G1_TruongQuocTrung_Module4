package com.codegym.entity.customer;

import com.codegym.common.BirthOfDay;
import com.codegym.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "customer")
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name")
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 255,message = "Please input name 1-255 character")
    private String nameCustomer;

    @Column(name = "customer_birthday")
    @NotBlank(message = "Please input not empty")
    @BirthOfDay
    private String birthday;

    @Column(name = "customer_id_card")
    @NotBlank(message = "Please input not empty")
    @Size(max = 10,message = "Please input id card 1-10 character")
    @Pattern(regexp = "^\\d{10}$", message = "Please input the tag id as a number has 10 characters")
    private String idCard;

    @Column(name = "customer_phone")
    @NotBlank(message = "Please input not empty")
//    ^(090|091|\(\+84\)90|\(\+84\)91)\d{7}$
    @Pattern(regexp = "^(090|091)\\d{7}$", message = "Please input phone number start 090 or 091")
    private String phone;

    @Column(name = "customer_email")
    @NotBlank(message = "Please input not empty")
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Please input the following example: abc@abc.abc")
    private String email;

    @Column(name = "customer_address")
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 255,message = "Please input firstName 1-255 character")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @ManyToOne
    @JoinColumn(name = "customer_gender_id", referencedColumnName = "id")
    private GenderPerson genderPerson;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contractsCustomer;

    @Override
    public String toString() {
        return nameCustomer + birthday + idCard +  phone + email + address;
    }
    public String getCustomerCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "KH-" + numberFormat.format(this.id);
    }
}
