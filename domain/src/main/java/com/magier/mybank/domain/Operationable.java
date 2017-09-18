package com.magier.mybank.domain;

public interface Operationable {
    void executeOperation(String accountNumber, Operation operation);
}
