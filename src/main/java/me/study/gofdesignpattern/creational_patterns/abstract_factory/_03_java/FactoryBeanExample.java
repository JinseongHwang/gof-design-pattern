package me.study.gofdesignpattern.creational_patterns.abstract_factory._03_java;

import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.Ship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 등록된 빈을 조회하는 방법 2가지를 알아보자면,
// xml 파일을 읽어서 빈 정보를 가져오는 방법이 있고,
// 어노테이션 기반으로 등록된 빈을 컴포넌트 스캔을 통해 가져오는 방법이 있다.
public class FactoryBeanExample {

    public static void main(String[] args) {
        final ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("config.xml");
        final Ship whiteship = applicationContext1.getBean("whiteship", Ship.class);
        System.out.println(whiteship.getName());

        final ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        final Ship bean = applicationContext2.getBean(Ship.class);
        System.out.println(bean);
    }
}
