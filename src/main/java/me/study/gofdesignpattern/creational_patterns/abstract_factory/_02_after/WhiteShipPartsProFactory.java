package me.study.gofdesignpattern.creational_patterns.abstract_factory._02_after;

import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Anchor;
import me.study.gofdesignpattern.creational_patterns.abstract_factory._01_before.Wheel;

public class WhiteShipPartsProFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchorPro();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheelPro();
    }
}
