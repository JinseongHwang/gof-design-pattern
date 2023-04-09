package me.study.gofdesignpattern.creational_patterns.prototype._03_java;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionExample {

    public static void main(String[] args) {
        Student keesun = new Student("keesun");
        Student whiteship = new Student("whiteship");
        List<Student> students = new ArrayList<>();
        students.add(keesun);
        students.add(whiteship);

        // ArrayList 생성자를 사용해서 복제하는 방법을 주로 사용한다.
        // ShallowCopy 이다.
        List<Student> clone = new ArrayList<>(students);
        System.out.println(clone);
    }
}
