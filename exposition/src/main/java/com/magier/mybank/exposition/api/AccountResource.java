package com.magier.mybank.exposition.api;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import com.magier.mybank.exposition.config.EnvConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/api")
public class AccountResource {
   // private Operationable operationable;
    private final AccountRepository accountRepository;

    @Autowired
    private EnvConfig envConfig;

    public AccountResource(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account findAccount(
            @PathParam(value = "accountNumber") final String accountNumber) {

        return accountRepository.findAccount(accountNumber);
    }

    @RequestMapping(value = "/account/env", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findAccountEnvValue() {
        return envConfig.getEnvValue();
    }

/*
    @RequestMapping(value = "/account:execute-operation", method = RequestMethod.POST)
    public String executeOperation(
            @RequestParam(value = "accountNumber") final String accountNumber,
            @RequestParam(value = "operationDate") @DateTimeFormat(pattern = "dd/MM/yyyy") final LocalDate operationDate,
            @RequestParam(value = "amount") final Integer amount,
            @RequestParam(value = "operationType") final OperationType operationType) {
        Operation operation = new Operation(operationDate, amount, operationType);
        operationable.executeOperation(accountNumber, operation);
        return operation.toString();
    }
    */
}
