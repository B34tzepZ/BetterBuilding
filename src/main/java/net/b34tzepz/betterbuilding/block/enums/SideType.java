package net.b34tzepz.betterbuilding.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum SideType implements StringIdentifiable {
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west"),
    DOUBLE("double");

    private final String name;

    private SideType(String name) {
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
