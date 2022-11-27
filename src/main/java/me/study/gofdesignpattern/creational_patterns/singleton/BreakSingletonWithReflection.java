package me.study.gofdesignpattern.creational_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonWithReflection {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Settings5 settings1 = Settings5.getInstance();

        final Constructor<Settings5> constructor = Settings5.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        final Settings5 settings2 = constructor.newInstance();

        System.out.println(settings1 != settings2); // true : 싱글턴이 깨졌다
    }
}
