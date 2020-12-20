package com.codegym.entity.employee;

import com.codegym.common.BirthOfDay;
import com.codegym.entity.account.AccountUser;
import com.codegym.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "employee")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 255,message = "Please input name 1-255 character")
    private String nameEmployee;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @NotBlank(message = "Please input not empty")
    @BirthOfDay
    private String birthday;

    @Column(name = "employee_id_card")
    @NotBlank(message = "Please input not empty")
    @Size(max = 10,message = "Please input id card 1-10 character")
    @Pattern(regexp = "^\\d{10}$", message = "Please input the tag id as a number has 10 characters")
    private String idCard;

    @Column(name = "employee_salary")
    @NotNull(message = "Please input not empty")
//    @Pattern(regexp = "^\\d*\\.\\d*$", message = "Please input the tag id as a number characters") // ko
    @Min(value = 100, message = "Employee salary at least 100 USD")
    private Double salary;

    @Column(name = "employee_phone")
    @NotBlank(message = "Please input not empty")
//    ^(090|091|\(\+84\)90|\(\+84\)91)\d{7}$
    @Pattern(regexp = "^(090|091)\\d{7}$", message = "Please input phone number start 090 or 091")
    private String phone;

    @Column(name = "employee_email")
    @NotBlank(message = "Please input not empty")
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Please input the following example: abc@abc.abc")
    private String email;

    @Column(name = "employee_address")
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 255,message = "Please input firstName 1-255 character")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divition_id", referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "username_id", referencedColumnName = "user_id")
    private AccountUser accountUser;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contractsEmployee;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public List<Contract> getContractsEmployee() {
        return contractsEmployee;
    }

    public void setContractsEmployee(List<Contract> contractsEmployee) {
        this.contractsEmployee = contractsEmployee;
    }
//    @Override
//    public String toString() {
//        return nameEmployee + birthday + idCard + salary + phone + email + address + position + division + educationDegree + accountUser;
//    }

    public String getEmployeeCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "NV-" + numberFormat.format(this.id);
    }
}
