package net.b34tzepz.betterbuilding.recipe;

import net.minecraft.inventory.SimpleInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

public interface FabricatorCraftingRecipe extends Recipe<SimpleInventory> {

    @Override
    default public RecipeType<?> getType() {
        return ModRecipes.FABRICATOR_CRAFTING;
    }

}
