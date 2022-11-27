package me.study.gofdesignpattern.creational_patterns.singleton;

/**
 * static inner 클래스 홀더
 */
public class Settings5 {

    private Settings5() {
    }

    private static class SettingsHolder {
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
