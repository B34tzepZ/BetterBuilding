package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.block.ModBlocks;
import net.b34tzepz.betterbuilding.block.entity.ModBlockEntities;
import net.b34tzepz.betterbuilding.item.ModItems;
import net.b34tzepz.betterbuilding.util.ModRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class BetterBuilding implements ModInitializer {
	public static final String MOD_ID = "betterbuilding";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllEntities();
		ModRegistries.registerModStuffs();

		GeckoLib.initialize();
	}
}
