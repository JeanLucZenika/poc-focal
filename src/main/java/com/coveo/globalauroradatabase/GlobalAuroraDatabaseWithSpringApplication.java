package com.coveo.globalauroradatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GlobalAuroraDatabaseWithSpringApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GlobalAuroraDatabaseWithSpringApplication.class, args);
    }
}
