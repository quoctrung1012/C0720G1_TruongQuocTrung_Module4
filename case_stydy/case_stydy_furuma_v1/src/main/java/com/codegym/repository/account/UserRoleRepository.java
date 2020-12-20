package com.codegym.repository.account;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAccountUser(AccountUser accountUser);
}
