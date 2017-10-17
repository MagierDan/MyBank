package com.magier.mybank.exposition.api;

import com.magier.mybank.exposition.config.EnvConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class EnvironmentRessource {

    public static final Logger logger = LogManager.getLogger(EnvironmentRessource.class);

    @Autowired
    private EnvConfig envConfig;

    @RequestMapping(value = "/env", method = RequestMethod.GET)
    public ResponseEntity<String> findAccountEnvValue() {
        logger.info("The env is : " + envConfig.getEnvValue());
        return new ResponseEntity<>(envConfig.getEnvValue(), HttpStatus.FOUND);
    }
}
