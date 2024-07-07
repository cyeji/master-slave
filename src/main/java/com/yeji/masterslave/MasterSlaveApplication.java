package com.yeji.masterslave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MasterSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterSlaveApplication.class, args);
    }

}
