package net.b34tzepz.betterbuilding.recipe;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.Codec;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FabricatorShapedRecipe implements FabricatorCraftingRecipe {

    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems; //Rezept Items
    private final int width;
    private final int height;

    public FabricatorShapedRecipe(ItemStack output, DefaultedList<Ingredient> recipeItems, int width, int height){
        this.output = output;
        this.recipeItems = recipeItems;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean matches(
            SimpleInventory inventory, //tatsächlich gegebene Items
            World world) {

        for (int i = 0; i <= 3 - this.width; ++i) {
            for (int j = 0; j <= 3 - this.height; ++j) {
                if (this.matchesPattern(inventory, i, j, true)) {
                    return true;
                }
                if (!this.matchesPattern(inventory, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    private boolean matchesPattern(SimpleInventory inv, int offsetX, int offsetY, boolean flipped) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int k = j - offsetX;
                int l = i - offsetY;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    ingredient = flipped ? this.recipeItems.get(this.width - k - 1 + l * this.width) : this.recipeItems.get(k + l * this.width);
                }
                if (ingredient.test(inv.getStack(i * 3 + j))) continue;
                return false;
            }
        }
        return true;
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

    static Map<String, Ingredient> mapSymbolsToIngredients(JsonObject json){
        HashMap<String, Ingredient> map = Maps.newHashMap();
        for (Map.Entry<String, JsonElement> entry : json.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }
            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }
            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
        }
        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    static String[] removePadding(String ... pattern) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int m = 0; m < pattern.length; ++m) {
            String string = pattern[m];
            i = Math.min(i, FabricatorShapedRecipe.findFirstSymbol(string));
            int n = FabricatorShapedRecipe.findLastSymbol(string);
            j = Math.max(j, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }
                ++l;
                continue;
            }
            l = 0;
        }
        if (pattern.length == l) {
            return new String[0];
        }
        String[] m = new String[pattern.length - l - k];
        for (int string = 0; string < m.length; ++string) {
            m[string] = pattern[string + k].substring(i, j + 1);
        }
        return m;
    }

    private static int findFirstSymbol(String line) {
        int i;
        for (i = 0; i < line.length() && line.charAt(i) == ' '; ++i) {
        }
        return i;
    }

    private static int findLastSymbol(String pattern) {
        int i;
        for (i = pattern.length() - 1; i >= 0 && pattern.charAt(i) == ' '; --i) {
        }
        return i;
    }

    static String[] getPattern(JsonArray json) {
        String[] strings = new String[json.size()];
        if (strings.length > 3) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
        }
        if (strings.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        }
        for (int i = 0; i < strings.length; ++i) {
            String string = JsonHelper.asString(json.get(i), "pattern[" + i + "]");
            if (string.length() > 3) {
                throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
            }
            if (i > 0 && strings[0].length() != string.length()) {
                throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
            }
            strings[i] = string;
        }
        return strings;
    }

    static DefaultedList<Ingredient> createPatternMatrix(String[] pattern, Map<String, Ingredient> symbols, int width, int height) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(width * height, Ingredient.EMPTY);
        HashSet<String> set = Sets.newHashSet(symbols.keySet());
        set.remove(" ");
        for (int i = 0; i < pattern.length; ++i) {
            for (int j = 0; j < pattern[i].length(); ++j) {
                String string = pattern[i].substring(j, j + 1);
                Ingredient ingredient = symbols.get(string);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + string + "' but it's not defined in the key");
                }
                set.remove(string);
                defaultedList.set(j + width * i, ingredient);
            }
        }
        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        }
        return defaultedList;
    }

    public static class Serializer implements RecipeSerializer<FabricatorShapedRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "fabricator_shaped";
        // this is the name given in the json file

        @Override
        public FabricatorShapedRecipe read(JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
            Map<String, Ingredient> map = FabricatorShapedRecipe.mapSymbolsToIngredients(JsonHelper.getObject(json, "key"));

            String[] strings = FabricatorShapedRecipe.removePadding(FabricatorShapedRecipe.getPattern(JsonHelper.getArray(json, "pattern")));
            int width = strings[0].length();
            int height = strings.length;
            DefaultedList<Ingredient> inputs = FabricatorShapedRecipe.createPatternMatrix(strings, map, width, height);

            return new FabricatorShapedRecipe(output, inputs, width, height);
        }

        @Override
        public Codec<FabricatorShapedRecipe> codec() {
            return null;
        }

        @Override
        public FabricatorShapedRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            int width = buf.readVarInt();
            int height = buf.readVarInt();

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new FabricatorShapedRecipe(output, inputs, width, height);
        }

        @Override
        public void write(PacketByteBuf buf, FabricatorShapedRecipe recipe) {
            buf.writeVarInt(recipe.width);
            buf.writeVarInt(recipe.height);
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getResult());
        }
    }

    @Override
    public String toString() {
        String ingrs = "";
        for(Ingredient ingr : recipeItems){
            ingrs += ingrToStr(ingr) + ", ";
        }

        return "FabricatorShapedRecipe{" +
                ", output=" + output +
                ", recipeItems=" + ingrs +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    private static String ingrToStr(Ingredient ingr){
        return Arrays.toString(ingr.getMatchingStacks());
    }
}
