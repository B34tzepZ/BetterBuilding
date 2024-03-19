package net.b34tzepz.betterbuilding.recipe;

import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
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
import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FabricatorShapedRecipe implements FabricatorCraftingRecipe {

    private final ItemStack output;
    private final List<Ingredient> recipeItems; //Rezept Items
    private final int width;
    private final int height;

    public FabricatorShapedRecipe(ItemStack output, DefaultedList<Ingredient> recipeItems, int width, int height) {
        this.output = output;
        this.recipeItems = recipeItems;
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if the inventory of the fabricator matches with a recipe.
     */
    @Override
    public boolean matches(
            SimpleInventory inventory, //tatsächlich gegebene Items
            World world) {

        if (world.isClient) {
            return false;
        }

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
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    /**
     * Removes empty rows and columns from the pattern.
     */
    static String[] removePadding(List<String> pattern) {
        int mostLeftIndex = Integer.MAX_VALUE;
        int mostRightIndex = 0;
        int k = 0;
        int l = 0;
        for (int m = 0; m < pattern.size(); ++m) {
            String row = pattern.get(m);
            mostLeftIndex = Math.min(mostLeftIndex, FabricatorShapedRecipe.findFirstSymbol(row));
            int n = FabricatorShapedRecipe.findLastSymbol(row);
            mostRightIndex = Math.max(mostRightIndex, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }
                ++l;
                continue;
            }
            l = 0;
        }
        if (pattern.size() == l) {
            return new String[0];
        }
        String[] m = new String[pattern.size() - l - k];
        for (int string = 0; string < m.length; ++string) {
            m[string] = pattern.get(string + k).substring(mostLeftIndex, mostRightIndex + 1);
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

        static final Codec<List<String>> PATTERN_CODEC = Codec.STRING.listOf().flatXmap(rows -> {
            if (rows.size() > 3) {
                return DataResult.error(() -> "Invalid pattern: too many rows, 3 is maximum");
            }
            if (rows.isEmpty()) {
                return DataResult.error(() -> "Invalid pattern: empty pattern not allowed");
            }
            int i = (rows.get(0)).length();
            for (String string : rows) {
                if (string.length() > 3) {
                    return DataResult.error(() -> "Invalid pattern: too many columns, 3 is maximum");
                }
                if (i == string.length()) continue;
                return DataResult.error(() -> "Invalid pattern: each row must be the same width");
            }
            return DataResult.success(rows);
        }, DataResult::success);

        static final Codec<String> KEY_ENTRY_CODEC = Codec.STRING.flatXmap(keyEntry -> {
            if (keyEntry.length() != 1) {
                return DataResult.error(() -> "Invalid key entry: '" + keyEntry + "' is an invalid symbol (must be 1 character only).");
            }
            if (" ".equals(keyEntry)) {
                return DataResult.error(() -> "Invalid key entry: ' ' is a reserved symbol.");
            }
            return DataResult.success(keyEntry);
        }, DataResult::success);

        /**
         * Translates the raw recipe codec to a {@link FabricatorShapedRecipe}.
         * */
        public static final Codec<FabricatorShapedRecipe> CODEC = RawShapedRecipe.CODEC.flatXmap(recipe -> {
            //recipeItems
            String[] purePattern = FabricatorShapedRecipe.removePadding(recipe.pattern);
            int width = purePattern[0].length();
            int height = purePattern.length;
            DefaultedList<Ingredient> recipeItems = createPatternMatrix(purePattern, recipe.key, width, height);

            FabricatorShapedRecipe shapedRecipe = new FabricatorShapedRecipe(recipe.result, recipeItems, width, height);
            return DataResult.success(shapedRecipe);
            }, recipe -> {
            throw new NotImplementedException("Serializing ShapedRecipe is not implemented yet.");
        });

        @Override
        public Codec<FabricatorShapedRecipe> codec() {
            return CODEC;
        }

        @Override
        public FabricatorShapedRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            int width = buf.readVarInt();
            int height = buf.readVarInt();

            inputs.replaceAll(ignored -> Ingredient.fromPacket(buf));

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
            buf.writeItemStack(recipe.getResult(null));
        }

        record RawShapedRecipe(Map<String, Ingredient> key, List<String> pattern, ItemStack result) {
            /**
             * Collects the individual codecs.
             * */
            public static final Codec<FabricatorShapedRecipe.Serializer.RawShapedRecipe> CODEC =
                    RecordCodecBuilder.create(instance -> instance.group(
                            (Codecs.strictUnboundedMap(KEY_ENTRY_CODEC, Ingredient.DISALLOW_EMPTY_CODEC).fieldOf("key")).forGetter(recipe -> recipe.key),
                            (PATTERN_CODEC.fieldOf("pattern")).forGetter(recipe -> recipe.pattern),
                            (RecipeCodecs.CRAFTING_RESULT.fieldOf("result")).forGetter(recipe -> recipe.result)
                            )
                            .apply(instance, FabricatorShapedRecipe.Serializer.RawShapedRecipe::new));

        }
    }

    @Override
    public String toString() {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : recipeItems) {
            ingredients.append(ingrToStr(ingredient)).append(", ");
        }

        return "FabricatorShapedRecipe{" +
                ", output=" + output +
                ", recipeItems=" + ingredients +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    private static String ingrToStr(Ingredient ingr) {
        return Arrays.toString(ingr.getMatchingStacks());
    }
}

