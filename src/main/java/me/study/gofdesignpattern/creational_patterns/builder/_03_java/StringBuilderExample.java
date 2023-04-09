package me.study.gofdesignpattern.creational_patterns.builder._03_java;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String result = sb.append("whiteship")
                          .append(' ')
                          .append("keesun")
                          .toString();
        System.out.println(result);
    }
}
