package com.codegym.entity.account;

import com.codegym.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_user", uniqueConstraints = {
        @UniqueConstraint(name = "ACCOUNT_USER_UK", columnNames = "user_name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "encryted_password", nullable = false)
    private String encrytedPassword;
    @Column(name = "enabled", length = 1, nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "accountUser", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Employee> employeesUser;
}
