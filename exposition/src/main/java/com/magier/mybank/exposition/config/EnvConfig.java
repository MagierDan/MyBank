package com.magier.mybank.exposition.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("file:/opt/apps/conf/MyBack.properties")
@Component
public class EnvConfig {
    @Value("${env.value}")
    public  String env;

    public String getEnvValue() {
        return env;
    }
}
