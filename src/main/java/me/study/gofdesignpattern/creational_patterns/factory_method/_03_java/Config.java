package me.study.gofdesignpattern.creational_patterns.factory_method._03_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public String hello() {
        return "Hello";
    }
}
