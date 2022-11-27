package me.study.gofdesignpattern.creational_patterns.singleton;

/**
 * synchronized 사용해서 동기화 처리
 * 하지만 lock 때문에 속도 측면에서 좋지 않다.
 */
public class Settings2 {

    private static Settings2 instance;

    private Settings2() {
    }

    public static synchronized Settings2 getInstance() {
        if (instance == null) {
            instance = new Settings2();
        }
        return instance;
    }
}
