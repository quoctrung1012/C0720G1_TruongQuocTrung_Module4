package com.codegym.repository.account;

import com.codegym.entity.account.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
    AccountUser findByUserName(String username);
}
