package me.study.gofdesignpattern.creational_patterns.abstract_factory._03_java;

import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.Ship;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.WhiteShip;
import org.springframework.beans.factory.FactoryBean;

// 스프링에서 빈을 생성하고 등록하는 과정은 꽤 복잡하다.
// 그 과정을 편하게 추상화 해주는 인터페이스가 FactoryBean 이다.
// FactoryBean 인터페이스를 구현할 때 아래처럼 메서드 2개를 구현해주면 편하게 빈 등록이 가능하다.
public class ShipFactory implements FactoryBean<Ship> {

    @Override
    public Ship getObject() throws Exception {
        final Ship ship = new WhiteShip();
        ship.setName("whiteship");
        return ship;
    }

    @Override
    public Class<?> getObjectType() {
        return Ship.class;
    }
}
