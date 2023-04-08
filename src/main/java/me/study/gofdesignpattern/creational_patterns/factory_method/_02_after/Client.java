package me.study.gofdesignpattern.creational_patterns.factory_method._02_after;

// 새로운 구현체가 생길 때, 기존 코드는 변경되지 않아도 된다는 장점이 있다.
// WhiteShip 만 사용하다가 BlackShip을 추가했을 경우에는 추가만 하면 된다.
// OCP 원칙이 잘 지켜진 경우이다. -> 확장에는 열려있으며 변경에는 닫혀있다.
public class Client {

    public static void main(String[] args) {
        Ship whiteship = new WhiteShipFactory().orderShip("Whiteship", "jinseong@gmail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("Blackship", "jinseong@gmail.com");
        System.out.println(blackship);
    }
}
