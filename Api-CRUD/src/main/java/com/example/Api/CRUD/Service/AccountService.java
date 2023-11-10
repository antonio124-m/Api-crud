package com.example.Api.CRUD.Service;

import com.example.Api.CRUD.Modal.Account;

import java.util.List;

public interface AccountService {

    Account createAccount( Account account);


     Account findByUsername(String userName);


    List<Account>getAllAccount();
}
