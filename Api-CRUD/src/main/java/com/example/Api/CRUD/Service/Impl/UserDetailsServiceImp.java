package com.example.Api.CRUD.Service.Impl;

import com.example.Api.CRUD.Modal.Account;
import com.example.Api.CRUD.Repository.AccountRepository;
import com.example.Api.CRUD.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {


    private final AccountService accountService;
@Autowired
    public UserDetailsServiceImp(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("user" + username + "not found");

        }
        if (account.getRoles() == null & account.getRoles().isEmpty()){
           throw  new  RuntimeException("user has no roles") ;
        }

        Collection<GrantedAuthority>authorities = account.getRoles().stream().map(roles -> new  SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());


    return new User(account.getUserName(),account.getPassword(),account.isEnabled(),account.isExpired(),account.isCredentialexpired(),account.isLocked(),authorities);
    }
}
