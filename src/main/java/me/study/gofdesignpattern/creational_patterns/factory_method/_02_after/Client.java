package me.study.gofdesignpattern.creational_patterns.factory_method._02_after;

// 새로운 구현체가 생길 때, 기존 코드는 변경되지 않아도 된다는 장점이 있다.
// WhiteShip 만 사용하다가 BlackShip을 추가했을 경우에는 추가만 하면 된다.
// OCP 원칙이 잘 지켜진 경우이다. -> 확장에는 열려있으며 변경에는 닫혀있다.
//
// 단, Client 측에서는 구체적인 클래스에 의존하기 때문에 코드 변경이 생길 수도 있다.
// 이를 최소화하기 위해서는 인터페이스 기반의 DI를 사용하면 어느 정도 해결이 가능하다.
public class Client {

    public static void main(String[] args) {
        final Client client = new Client();
        client.print(new WhiteShipFactory(), "Whiteship", "jinseong@gmail.com");
        client.print(new BlackShipFactory(), "Blackship", "jinseong@gmail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
