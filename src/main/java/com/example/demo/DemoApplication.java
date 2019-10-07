package com.example.demo;

import com.example.cofig.DataSource;
import com.example.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@Configuration
//@ComponentScan("com.example.entity")
//@EnableAutoConfiguration
//@SpringBootApplication(scanBasePackages = {"com.example.repository", "com.example.repository", "com.example.entity"})
//@EnableJpaRepositories(basePackages = { "com.example.repository" })
//@EntityScan(basePackages = {"com.example.model"})
@Import(DataSource.class)
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
