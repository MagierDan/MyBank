package com.magier.mybank.domain.account;

import java.util.UUID;

public interface AccountRepository {
    Account createAccount();
    Account findAccount(UUID accountNumber);
}
