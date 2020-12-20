package com.codegym.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account_role", uniqueConstraints = {
        @UniqueConstraint(name = "ACCOUNT_ROLE_UK", columnNames = "role_name")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Long id;
    @Column(name = "role_name", nullable = false)
    private String roleName;

}
