package com.magier.mybank.domain.operation;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationExecutor implements Operationable {

    private final AccountRepository accountRepository;

    public OperationExecutor(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void executeOperation(UUID accountNumber, Operation operation) {
        Account account = accountRepository.findAccount(accountNumber);
        account.executeOperation(operation);
    }
}
