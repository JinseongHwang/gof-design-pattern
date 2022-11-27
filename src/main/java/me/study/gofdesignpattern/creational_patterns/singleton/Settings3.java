package me.study.gofdesignpattern.creational_patterns.singleton;

/**
 * eager initialization (이른 초기화)
 * 객체 생성이 비싸지 않고, 자주 사용된다면 미리 만든다.
 */
public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3() {
    }

    public static Settings3 getInstance() {
        return INSTANCE;
    }
}
