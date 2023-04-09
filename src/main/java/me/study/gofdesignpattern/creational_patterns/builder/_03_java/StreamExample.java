package me.study.gofdesignpattern.creational_patterns.builder._03_java;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        // Type 1 : Success
        Stream.Builder<String> stringStreamBuilder = Stream.builder();
        final Stream<String> names1 = stringStreamBuilder.add("keesun")
                                                         .add("whiteship")
                                                         .build();
        names1.forEach(System.out::println);

        // Type 2 : Fail
        // Stream 에서 연산할 재료의 타입을 추론하는 것이 불가능하다.
        // add 과정에서는 추론할 수 있다고 생각하겠지만,
        // 빌더 인스턴스를 생성하는 과정에서 타입을 알 수 있어야 하고, 애초에 Java는 정적 타이핑 언어이기 때문이다.
//        final Stream<String> names2 = Stream.builder()
//                                            .add("keesun")
//                                            .add("whiteship")
//                                            .build();
//        names2.forEach(System.out::println);

        // Type 3 : Success
        final Stream<String> names3 = Stream.<String>builder()
                                            .add("keesun")
                                            .add("whiteship")
                                            .build();
        names3.forEach(System.out::println);
    }
}
