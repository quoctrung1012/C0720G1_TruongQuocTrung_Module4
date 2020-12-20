package com.codegym.service.account.impl;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.account.UserRole;
import com.codegym.repository.account.AccountRoleRepository;
import com.codegym.repository.account.AccountUserRepository;
import com.codegym.repository.account.UserRoleRepository;
import com.codegym.service.account.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountUserServiceImpl implements AccountUserService, UserDetailsService {
    @Autowired
    private AccountUserRepository accountUserRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<AccountUser> findAll() {
        return accountUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountUser accountUser = this.accountUserRepository.findByUserName(username);
        if (accountUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoleList = this.userRoleRepository.findByAccountUser(accountUser);
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAccountRole().getRoleName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(accountUser.getUserName(), accountUser.getEncrytedPassword(), grantList);
        return userDetails;
    }
}
