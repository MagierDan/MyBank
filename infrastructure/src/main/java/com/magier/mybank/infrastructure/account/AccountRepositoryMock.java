package com.magier.mybank.infrastructure.account;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import com.magier.mybank.domain.error.BusinessErrors;
import com.magier.mybank.domain.error.BusinessException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepositoryMock implements AccountRepository {


    @Override
    public Account createAccount() {
        return new Account();
    }

    public Account findAccount(UUID accountNumber) {
        Optional<UUID> accountNumberOpt = Optional.ofNullable(accountNumber);

        if (accountNumberOpt.isPresent()) {
            return new Account();
        }

        throw new BusinessException(BusinessErrors.MISSING_ACCOUNT_NUMBER);
    }
}
