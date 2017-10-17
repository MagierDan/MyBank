package com.magier.mybank.exposition.api;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import com.magier.mybank.exposition.config.EnvConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/api")
public class AccountResource {
    public static final Logger logger = LogManager.getLogger(AccountResource.class);

   // private Operationable operationable;
    private final AccountRepository accountRepository;

    @Autowired
    private EnvConfig envConfig;

    public AccountResource(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/account/{accountNumber}", method = RequestMethod.GET)
    public ResponseEntity<Account> findAccount(
            @PathParam(value = "accountNumber") String accountNumber) {
        logger.info("The accountNumber is : " + accountNumber);
        return new ResponseEntity<>(accountRepository.findAccount(accountNumber), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/account/env", method = RequestMethod.GET, headers = "Accept: text/plain")
    public ResponseEntity<String> findAccountEnvValue() {
        logger.info("The env is : " + envConfig.getEnvValue());
        return new ResponseEntity<>(envConfig.getEnvValue(), HttpStatus.FOUND);
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
