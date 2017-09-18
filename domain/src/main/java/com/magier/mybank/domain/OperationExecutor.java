package com.magier.mybank.domain;

public class OperationExecutor implements Operationable {

    AccountRepository accountRepository;

    @Override
    public void executeOperation(String accountNumber, Operation operation) {
        Account account = accountRepository.findAccount(accountNumber);
        account.executeOperation(operation);
    }
}
