package com.magier.mybank.domain.operation;

import java.util.UUID;

public interface Operationable {
    void executeOperation(UUID accountNumber, Operation operation);
}
