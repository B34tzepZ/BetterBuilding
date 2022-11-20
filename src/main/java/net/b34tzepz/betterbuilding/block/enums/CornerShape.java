package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum CornerShape implements StringIdentifiable {

    STRAIGHT("straight"),
    INNER_BOTTOM("inner_bottom"),
    INNER_TOP("inner_top"),
    OUTER_BOTTOM("outer_bottom"),
    OUTER_TOP("outer_top");

    private final String name;

    CornerShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}

