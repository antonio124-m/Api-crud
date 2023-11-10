package com.example.Api.CRUD.Controller;

import com.example.Api.CRUD.Modal.Account;
import com.example.Api.CRUD.Modal.Employee;
import com.example.Api.CRUD.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/account")
public class AccountResource {
     private final AccountService accountService;
  @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public ResponseEntity<Account> createAccount(@RequestBody Account account ){
        Account CreateAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }



    @GetMapping
    public ResponseEntity<List<Account>>getAllAccount(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }
}
