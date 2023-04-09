package me.study.gofdesignpattern.creational_patterns.prototype._03_java;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }
}
