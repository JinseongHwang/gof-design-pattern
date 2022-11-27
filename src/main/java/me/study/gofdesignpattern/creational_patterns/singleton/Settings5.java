package me.study.gofdesignpattern.creational_patterns.singleton;

import java.io.Serializable;

/**
 * static inner 클래스 홀더
 */
public class Settings5 implements Serializable {

    private Settings5() {
    }

    private static class SettingsHolder {
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance() {
        return SettingsHolder.INSTANCE;
    }

    // 역직렬화 과정에서 반드시 readResolve() 메서드를 찾아서 실행하게 되는데, 원래는 new XXX()가 실행된다.
    // 하지만 여기서 getInstance() 를 호출하도록 하면 역직렬화 과정에서 싱글턴이 깨지는 문제를 해결할 수 있다.
    protected Object readResolve() {
        return getInstance();
    }
}
