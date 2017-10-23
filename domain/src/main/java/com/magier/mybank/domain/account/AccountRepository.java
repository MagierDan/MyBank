package com.magier.mybank.domain.account;

public interface AccountRepository {
    Account createAccount();
    Account findAccount(String accountNumber);
}
