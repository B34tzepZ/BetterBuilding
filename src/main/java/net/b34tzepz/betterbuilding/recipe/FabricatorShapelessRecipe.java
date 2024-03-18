package net.b34tzepz.betterbuilding.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCodecs;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class FabricatorShapelessRecipe implements FabricatorCraftingRecipe {

    private final ItemStack output;
    private final List<Ingredient> recipeItems; //Rezept Items

    public FabricatorShapelessRecipe(ItemStack output, List<Ingredient> recipeItems) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    /**
     * Checks if the inventory of the fabricator matches with a recipe.
     */
    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient) {
            return false;
        }

        ArrayList<Ingredient> neededItems = new ArrayList<>(recipeItems);
        for (int j = 0; j < 9; ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (itemStack.isEmpty()) continue;
            if (neededItems.isEmpty()) {
                return false;
            }
            for (int k = 0; k < neededItems.size(); k++) {
                if (neededItems.get(k).test(itemStack)) {
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
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    public static class Serializer implements RecipeSerializer<FabricatorShapelessRecipe> {
        public static final FabricatorShapelessRecipe.Serializer INSTANCE = new FabricatorShapelessRecipe.Serializer();
        public static final String ID = "fabricator_shapeless";     // this is the name given in the json file

        public static final Codec<FabricatorShapelessRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter(r -> r.output),
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(FabricatorShapelessRecipe::getIngredients)
        ).apply(in, FabricatorShapelessRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Too many ingredients for shapeless recipe") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "No ingredients for shapeless recipe") : DataResult.success(list));
        }

        //TODO: die muss das wie FabricatorShapedRecipe read(JsonObject json)
        @Override
        public Codec<FabricatorShapelessRecipe> codec() {
            return CODEC;
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
            buf.writeItemStack(recipe.getResult(null));
        }
    }

}
