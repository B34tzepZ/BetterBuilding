package net.b34tzepz.betterbuilding.recipe;

import com.google.gson.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class FabricatorShapelessRecipe implements FabricatorCraftingRecipe {

    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems; //Rezept Items

    public FabricatorShapelessRecipe(ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        ArrayList<Ingredient> neededItems = new ArrayList<>();
        for (Ingredient ingr : recipeItems) {
            neededItems.add(ingr);
        }
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (itemStack.isEmpty()) continue;
            if(neededItems.isEmpty()){
                return false;
            }
            for(int k = 0; k < neededItems.size(); k++){
                if(neededItems.get(k).test(itemStack)){
                    neededItems.remove(k);
                    break;
                }
            }
        }
        return neededItems.isEmpty();
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<FabricatorShapelessRecipe> {
        public static final FabricatorShapelessRecipe.Serializer INSTANCE = new FabricatorShapelessRecipe.Serializer();
        public static final String ID = "fabricator_shapeless";
        // this is the name given in the json file

        @Override
        public FabricatorShapelessRecipe read(JsonObject json) {
            DefaultedList<Ingredient> ingredients = getIngredients(JsonHelper.getArray(json, "ingredients"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            if (ingredients.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            }
            ItemStack result = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
            return new FabricatorShapelessRecipe(result, ingredients);
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> ingredients = DefaultedList.of();
            for (int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (ingredient.isEmpty()) continue;
                ingredients.add(ingredient);
            }
            return ingredients;
        }

        @Override
        public Codec<FabricatorShapelessRecipe> codec() {
            return new FabricatorShapelessRecipe(result, ingrdients);
        }

        @Override
        public FabricatorShapelessRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new FabricatorShapelessRecipe(output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, FabricatorShapelessRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            //TODO: Irgendwas wie world.getRegistryManager()
            //siehe FabricatorBlockEntity.java
            buf.writeItemStack(recipe.getResult());
        }
    }

}
