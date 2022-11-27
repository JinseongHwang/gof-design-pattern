package me.study.gofdesignpattern.creational_patterns.singleton;

public class App {

    public static void main(String[] args) {
        final Settings5 settings1 = Settings5.getInstance();
        final Settings5 settings2 = Settings5.getInstance();
        System.out.println(settings1 == settings2);
    }
}
