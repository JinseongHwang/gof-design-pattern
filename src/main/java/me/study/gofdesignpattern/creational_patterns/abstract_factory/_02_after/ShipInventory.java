package me.study.gofdesignpattern.creational_patterns.abstract_factory._02_after;

import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.Ship;
import me.study.gofdesignpattern.creational_patterns.factory_method._02_after.ShipFactory;

public class ShipInventory {

    public static void main(String[] args) {
        // WhiteShipPartsFactory 를 사용해서 Normal Ship 생산
        final ShipFactory shipFactory1 = new WhiteShipFactory(new WhiteShipPartsFactory());
        final Ship ship1 = shipFactory1.createShip();
        System.out.println(ship1.getAnchor().getClass());
        System.out.println(ship1.getWheel().getClass());

        // WhiteShipPartsProFactory 를 사용해서 Pro Ship 생산
        final ShipFactory shipFactory2 = new WhiteShipFactory(new WhiteShipPartsProFactory());
        final Ship ship2 = shipFactory2.createShip();
        System.out.println(ship2.getAnchor().getClass());
        System.out.println(ship2.getWheel().getClass());
    }
}
