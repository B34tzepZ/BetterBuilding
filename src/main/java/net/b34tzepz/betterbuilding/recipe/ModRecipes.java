package net.b34tzepz.betterbuilding.recipe;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {

    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(BetterBuilding.MOD_ID, FabricatorShapedRecipe.Serializer.ID),
                FabricatorShapedRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(BetterBuilding.MOD_ID, FabricatorShapedRecipe.Type.ID),
                FabricatorShapedRecipe.Type.INSTANCE);
    }

}
