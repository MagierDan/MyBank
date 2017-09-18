package com.magier.mybank.domain.account;

public interface AccountRepository {
    Account findAccount(String accountNumber);
}
