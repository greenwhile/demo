package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@Configuration
//@ComponentScan("com.example.entity")
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
//@SpringBootApplication(scanBasePackages = {"com.example.repository", "com.example.repository", "com.example.entity"})
//@EnableJpaRepositories(basePackages = { "com.example.repository" })
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
