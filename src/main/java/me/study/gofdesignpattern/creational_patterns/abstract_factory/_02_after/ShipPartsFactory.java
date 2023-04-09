package me.study.gofdesignpattern.creational_patterns.abstract_factory._02_after;

import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Anchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Wheel;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();
}
