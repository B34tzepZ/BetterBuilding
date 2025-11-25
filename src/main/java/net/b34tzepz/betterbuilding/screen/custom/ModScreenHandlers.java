package net.b34tzepz.betterbuilding.screen.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static ScreenHandlerType<TeleporterBlockScreenHandler> TELEPORTER_BLOCK_SCREEN_HANDLER;

    //public static ScreenHandlerType<FabricatorScreenHandler> FABRICATOR_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        TELEPORTER_BLOCK_SCREEN_HANDLER =
                Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BetterBuilding.MOD_ID, "teleporter_block"),
                        new ExtendedScreenHandlerType<>(TeleporterBlockScreenHandler::new, BlockPos.PACKET_CODEC));

        /*FABRICATOR_SCREEN_HANDLER =
                Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BetterBuilding.MOD_ID, "fabricator_block"),
                        new ExtendedScreenHandlerType<>(FabricatorScreenHandler::new, BlockPos.PACKET_CODEC));*/
    }
}
