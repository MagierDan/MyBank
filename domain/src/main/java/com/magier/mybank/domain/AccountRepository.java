package com.magier.mybank.domain;

public interface AccountRepository {

    Account findAccount(String accountNumber);
}
