package me.study.gofdesignpattern.creational_patterns.factory_method._02_after;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = ShipFactory.orderShip("Whiteship", "jinseong@gmail.com");
        System.out.println(whiteship);

        Ship blackship = ShipFactory.orderShip("Blackship", "jinseong@gmail.com");
        System.out.println(blackship);
    }
}
