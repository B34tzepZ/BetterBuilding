package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum RelativeDirection implements StringIdentifiable {
    LEFT("left"),
    RIGHT("right");

    private final String name;

    RelativeDirection(String name) {
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
