package me.study.gofdesignpattern.creational_patterns.abstract_factory._02_after;

import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.WhiteAnchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.WhiteWheel;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.DefaultShipFactory;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.Ship;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.WhiteShip;

// 이 코드는 클라이언트 코드이다.
public class WhiteShipFactory extends DefaultShipFactory {

    private final ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        final Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
