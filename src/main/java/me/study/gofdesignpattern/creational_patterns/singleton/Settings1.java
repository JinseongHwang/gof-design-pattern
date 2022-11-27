package me.study.gofdesignpattern.creational_patterns.singleton;

/**
 * private 생성자와 public static 메소드를 사용하는 방법
 * 하지만 멀티 쓰레드 환경에서는 인스턴스가 1개임을 보장할 수 없다.
 */
public class Settings1 {

    private static Settings1 instance;

    private Settings1() {
    }

    public static Settings1 getInstance() {
        if (instance == null) {
            instance = new Settings1();
        }
        return instance;
    }
}
