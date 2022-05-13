package net.b34tzepz.betterbuilding.state.property;

import net.b34tzepz.betterbuilding.block.enums.CornerShape;
import net.b34tzepz.betterbuilding.block.enums.SideType;
import net.minecraft.state.property.EnumProperty;

public class Properties extends net.minecraft.state.property.Properties {
    public static final EnumProperty<SideType> SIDE_TYPE = EnumProperty.of("type", SideType.class);
    public static final EnumProperty<CornerShape> CORNER_SHAPE = EnumProperty.of("shape", CornerShape.class);
}
