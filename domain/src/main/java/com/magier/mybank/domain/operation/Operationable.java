package com.magier.mybank.domain.operation;

public interface Operationable {
    void executeOperation(String accountNumber, Operation operation);
}
