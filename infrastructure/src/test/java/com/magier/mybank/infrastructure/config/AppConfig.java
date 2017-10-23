package com.magier.mybank.infrastructure.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan(basePackages = "com.magier.mybank")
@SpringBootTest(classes = AppConfig.class)
public class AppConfig {
}