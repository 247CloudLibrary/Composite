package com.cloudlibrary.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@EnableFeignClients
@EnableJpaRepositories
@SpringBootApplication
public class CompositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompositeApplication.class, args);
    }

}
