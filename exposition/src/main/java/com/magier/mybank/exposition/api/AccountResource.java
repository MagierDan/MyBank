package com.magier.mybank.exposition.api;

import com.magier.mybank.domain.account.Account;
import com.magier.mybank.domain.account.AccountRepository;
import com.magier.mybank.domain.error.BusinessErrors;
import com.magier.mybank.domain.error.BusinessException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class AccountResource {
    private static final Logger logger = LogManager.getLogger(AccountResource.class);

    private final AccountRepository accountRepository;

    public AccountResource(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @ApiOperation(value = "Find account by UUID", notes = "Returns an account if any matches the UUID")
    @RequestMapping(value = {"/account/{accountNumber}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAccount(
            @ApiParam(name = "accountNumber", value = "Account UUID")
            @PathVariable(value = "accountNumber") UUID accountNumber) {
        if (accountNumber != null && !accountNumber.toString().isEmpty()) {
            logger.info("The accountNumber is : " + accountNumber.toString());
            return new ResponseEntity<>(accountRepository.findAccount(accountNumber), HttpStatus.OK);
        }

        throw new BusinessException(BusinessErrors.MISSING_ACCOUNT_NUMBER);
    }
}