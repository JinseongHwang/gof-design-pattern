package me.study.gofdesignpattern.creational_patterns.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        final String hello1 = ac.getBean("hello", String.class);
        final String hello2 = ac.getBean("hello", String.class);
        System.out.println(hello1 == hello2);
    }
}
