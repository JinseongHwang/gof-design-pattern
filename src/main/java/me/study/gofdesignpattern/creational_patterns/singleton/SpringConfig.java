package me.study.gofdesignpattern.creational_patterns.singleton;

import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public String hello() {
        return "hello";
    }
}
