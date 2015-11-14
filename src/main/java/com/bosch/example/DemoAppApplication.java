package com.bosch.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.spring.annotation.EnableVaadin;

@SpringBootApplication
@EnableVaadin
public class DemoAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DemoAppApplication.class, args);
    }
}
