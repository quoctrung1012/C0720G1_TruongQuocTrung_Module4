package com.codegym.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" })})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AccountRole accountRole;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AccountUser accountUser;
}
