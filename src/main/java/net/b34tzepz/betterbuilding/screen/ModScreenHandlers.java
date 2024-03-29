package net.b34tzepz.betterbuilding.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<TeleporterBlockScreenHandler> TELEPORTER_BLOCK_SCREEN_HANDLER;

    public static ScreenHandlerType<FabricatorScreenHandler> FABRICATOR_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        TELEPORTER_BLOCK_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(BetterBuilding.MOD_ID, "teleporter_block"),
                        TeleporterBlockScreenHandler::new);

        FABRICATOR_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(BetterBuilding.MOD_ID, "fabricator_block"),
                        FabricatorScreenHandler::new);
    }
}
