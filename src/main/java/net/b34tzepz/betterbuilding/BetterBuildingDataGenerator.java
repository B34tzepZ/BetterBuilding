package net.b34tzepz.betterbuilding;

import net.b34tzepz.betterbuilding.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BetterBuildingDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack dataGenerator = fabricDataGenerator.createPack();

        dataGenerator.addProvider(ModBlockTagProvider::new);
        dataGenerator.addProvider(ModItemTagProvider::new);
        dataGenerator.addProvider(ModLootTableProvider::new);
        dataGenerator.addProvider(ModModelProvider::new);
        dataGenerator.addProvider(ModRecipeProvider::new);
    }
}
