package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum CornerShape implements StringIdentifiable {

    STRAIGHT("straight"),
    INNER_BOTTOM("inner_bottom"),
    INNER_TOP("inner_top"),
    OUTER_NEXT_BOTTOM("outer_next_bottom"),
    OUTER_NEXT_TOP("outer_next_top"),
    OUTER_PREV_BOTTOM("outer_prev_bottom"),
    OUTER_PREV_TOP("outer_prev_top"),
    OUTER_DOUBLE_BOTTOM("outer_double_bottom"),
    OUTER_DOUBLE_TOP("outer_double_top");

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

