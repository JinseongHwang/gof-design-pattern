package me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before;

import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.DefaultShipFactory;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.Ship;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.WhiteShip;

// 이 코드는 구체 클래스에 의존하는 클라이언트 코드이다.
// WhiteAnchor 와 WhiteWheel 에 의존하고 있다.
public class WhiteShipFactory extends DefaultShipFactory {

    @Override
    public Ship createShip() {
        final Ship ship = new WhiteShip();
        ship.setAnchor(new WhiteAnchor());
        ship.setWheel(new WhiteWheel());
        return ship;
    }
}
