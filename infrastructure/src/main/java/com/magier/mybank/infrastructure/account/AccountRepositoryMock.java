package com.magier.mybank.infrastructure.account;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryMock implements AccountRepository {


    @Override
    public Account createAccount() {
        return new Account();
    }

    public Account findAccount(String accountNumber) {
        //Account account =
        return new Account();
        //return account;
    }
}
