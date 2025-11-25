package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum CornerDirection implements StringIdentifiable {
    NORTHWEST("northwest"),
    NORTHEAST("northeast"),
    SOUTHEAST("southeast"),
    SOUTHWEST("southwest");

    private final String name;

    CornerDirection(String name) {
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
