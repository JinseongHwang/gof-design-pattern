package me.study.gofdesignpattern.creational_patterns.factory_method._02_after;

// 구현체 별로 공통적인 기능의 메서드는 인터페이스의 디폴트 메서드로 구현해준다.
// 구현체 별로 다르게 동작해야 하는 메서드를 선언만 해준 후 구현체에서 동작을 결정하도록 한다.
// ShipFactory를 구현한 XXXFactory 클래스들은 구체적으로 어떤 인스턴스가 만들어질지 결정할 수 있다.
public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        final Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    }

    private void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

    private void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
