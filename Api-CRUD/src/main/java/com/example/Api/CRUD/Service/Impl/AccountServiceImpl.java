package com.example.Api.CRUD.Service.Impl;

import com.example.Api.CRUD.Modal.Account;
import com.example.Api.CRUD.Modal.Roles;
import com.example.Api.CRUD.Repository.AccountRepository;
import com.example.Api.CRUD.Repository.RolesRepository;
import com.example.Api.CRUD.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service

public class AccountServiceImpl implements AccountService {

        private final AccountRepository accountRepository;

        private final RolesRepository rolesRepository;


        private final PasswordEncoder encoder;
     @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RolesRepository rolesRepository, PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.rolesRepository = rolesRepository;
        this.encoder = encoder;


    }

    @Override
    public Account createAccount(Account account) {
         account.setPassword(encoder.encode(account.getPassword()));

         Roles roles = rolesRepository.findByName("ROLE_USER");
        Set<Roles> role  =new HashSet<>();
        role.add(roles);

        account.setRoles(role);

        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String userName) {
        return accountRepository.findByUserName(userName);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
}
