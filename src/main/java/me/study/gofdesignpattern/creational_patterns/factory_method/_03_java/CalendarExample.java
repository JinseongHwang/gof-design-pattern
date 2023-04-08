package me.study.gofdesignpattern.creational_patterns.factory_method._03_java;

import java.util.Calendar;
import java.util.Locale;

// 파라미터 값에 따라서 서로 다른 타입의 인스턴스를 반환하는 팩토리 메서드의 예시이다.
public class CalendarExample {

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getClass()); // class java.util.GregorianCalendar
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).getClass()); // class sun.util.BuddhistCalendar
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).getClass()); // class java.util.JapaneseImperialCalendar
    }
}
