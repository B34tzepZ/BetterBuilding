package net.b34tzepz.betterbuilding.recipe;

import net.b34tzepz.betterbuilding.BetterBuilding;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
public class ModRecipes {

    public static final RecipeType<FabricatorCraftingRecipe> FABRICATOR_CRAFTING = RecipeType.register("fabricator_crafting");

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BetterBuilding.MOD_ID, FabricatorShapedRecipe.Serializer.ID),
                FabricatorShapedRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BetterBuilding.MOD_ID, FabricatorShapelessRecipe.Serializer.ID),
                FabricatorShapelessRecipe.Serializer.INSTANCE);
    }

}
