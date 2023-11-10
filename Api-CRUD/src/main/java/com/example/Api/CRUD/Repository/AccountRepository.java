package com.example.Api.CRUD.Repository;

import com.example.Api.CRUD.Modal.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUserName(String userName);
}
