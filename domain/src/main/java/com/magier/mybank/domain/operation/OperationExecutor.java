package com.magier.mybank.domain.operation;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;

public class OperationExecutor implements Operationable {

    AccountRepository accountRepository;

    @Override
    public void executeOperation(String accountNumber, Operation operation) {
        Account account = accountRepository.findAccount(accountNumber);
        account.executeOperation(operation);
    }
}
