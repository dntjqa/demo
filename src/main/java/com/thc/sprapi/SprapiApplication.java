package com.thc.sprapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SprapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SprapiApplication.class, args);
    }
}
