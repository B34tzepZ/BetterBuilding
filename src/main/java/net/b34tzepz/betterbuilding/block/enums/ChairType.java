package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum ChairType implements StringIdentifiable {
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    private final String name;

    private ChairType(String name) {
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
