package com.magier.mybank.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magier.mybank.domain.operation.Operation;
import com.magier.mybank.domain.operation.OperationRepository;
import com.magier.mybank.domain.operation.OperationType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class Account {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int balance;
    private List<Operation> operations = new LinkedList<>();
    private LocalDate lastOperationDate;
    private final String accountNumber;

    @JsonIgnore
    private OperationRepository operationRepository;


    public Account() {
        this.accountNumber = UUID.randomUUID().toString();
    }

    public void executeOperation(Operation operation) {
        checkOperation(operation);

        determineBalance(operation);
        lastOperationDate = operation.getDate();

        operationRepository.saveOperation(operation);

        operations.add(0, operation);
    }

    private void checkOperation(Operation operation) {
        Optional<Operation> operationOpt = Optional.ofNullable(operation);
        operationOpt.orElseThrow(IllegalArgumentException::new);
    }

    private void determineBalance(Operation operation) {
        int amount = operation.getAmount();
        if (OperationType.WITHDRAWAL == operation.getType()) {
            amount = -operation.getAmount();
        }
        balance += amount;

        operation.setBalanceAfterOperation(balance);
    }

    public String getStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation || Date || Amount || Balance");
        operations.forEach(operation -> {
            sb.append(System.lineSeparator())
                    .append(operation.getType().getLabel())
                    .append(" || ")
                    .append(operation.getDate().format(DATE_TIME_FORMATTER))
                    .append(" || ")
                    .append(operation.getAmount()).append(" || ")
                    .append(operation.getBalanceAfterOperation());
        });

        return sb.toString();
    }

    public void setOperationRepository(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public int getBalance() {
        return balance;
    }
}
