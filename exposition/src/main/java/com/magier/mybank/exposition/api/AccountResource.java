package com.magier.mybank.exposition.api;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AccountResource {
    private static final Logger logger = LogManager.getLogger(AccountResource.class);

    private final AccountRepository accountRepository;

    public AccountResource(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value="/account/{accountNumber}", method = RequestMethod.GET)
    public ResponseEntity<Account> findAccount(
            @PathVariable("accountNumber") String accountNumber) {
        logger.info("The accountNumber is : " + accountNumber);
        return new ResponseEntity<>(accountRepository.findAccount(accountNumber), HttpStatus.FOUND);
    }
}
