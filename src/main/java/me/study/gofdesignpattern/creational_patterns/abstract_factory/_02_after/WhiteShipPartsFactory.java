package me.study.gofdesignpattern.creational_patterns.abstract_factory._02_after;

import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Anchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Wheel;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.WhiteAnchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.WhiteWheel;

public class WhiteShipPartsFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
