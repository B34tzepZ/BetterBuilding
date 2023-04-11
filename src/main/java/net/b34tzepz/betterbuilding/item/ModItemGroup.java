package net.b34tzepz.betterbuilding.item;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup Building = FabricItemGroupBuilder.build(
            new Identifier(BetterBuilding.MOD_ID, "building"), () -> new ItemStack(ModItems.SCREW));

    public static final ItemGroup Pillars = FabricItemGroupBuilder.build(
            new Identifier(BetterBuilding.MOD_ID, "pillars"), () -> new ItemStack(ModBlocks.Pillars.STONE_PILLAR));
}
