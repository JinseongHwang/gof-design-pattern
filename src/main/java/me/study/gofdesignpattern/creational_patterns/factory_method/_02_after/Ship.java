package me.study.gofdesignpattern.creational_patterns.factory_method._02_after;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Anchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Wheel;

@Getter
@Setter
@ToString
public class Ship {

    private String name;
    private String color;
    private String logo;
    private Wheel wheel;
    private Anchor anchor;
}
