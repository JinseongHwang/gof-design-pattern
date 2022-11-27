package me.study.gofdesignpattern.creational_patterns.singleton;

public class RuntimeExample {

    public static void main(String[] args) {
        final Runtime runtime = Runtime.getRuntime(); // 싱글턴으로 구현되어 있음
        System.out.println("runtime.maxMemory() = " + runtime.maxMemory());
        System.out.println("runtime.freeMemory() = " + runtime.freeMemory());
    }
}
