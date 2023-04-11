package net.b34tzepz.betterbuilding.block;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class JsonGenerator {
    public static void main(String[] args) throws Exception {
//        generateJsons("oak", "spruce", "chair");
//        generateJsons("oak", "birch", "chair");
//        generateJsons("oak", "jungle", "chair");
//        generateJsons("oak", "acacia", "chair");
//        generateJsons("oak", "dark_oak", "chair");
//        generateJsons("oak", "crimson", "chair");
//        generateJsons("oak", "warped", "chair");
        copyCraftingRecipesForFabricator();
    }

    private static void generateJsons(String oldMaterial, String newMaterial, String type) throws Exception {
        generateBlockstateJson(oldMaterial, newMaterial, type);
        generateBlockModelJson(oldMaterial, newMaterial, type);
        generateItemModelJson(oldMaterial, newMaterial, type);
        generateLootTableJson(oldMaterial, newMaterial, type);
        generateRecipeJson(oldMaterial, newMaterial, type);
    }

    private static void generateBlockstateJson(String oldMaterial, String newMaterial, String type) throws Exception {
        String location = "src/main/resources/assets/betterbuilding/blockstates/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateBlockModelJson(String oldMaterial, String newMaterial, String type) throws Exception {
        String location = "src/main/resources/assets/betterbuilding/models/block/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateItemModelJson(String oldMaterial, String newMaterial, String type) throws Exception {
        String location = "src/main/resources/assets/betterbuilding/models/item/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateLootTableJson(String oldMaterial, String newMaterial, String type) throws Exception {
        String location = "src/main/resources/data/betterbuilding/loot_tables/blocks/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateRecipeJson(String oldMaterial, String newMaterial, String type) throws Exception {
        String location = "src/main/resources/data/betterbuilding/recipes/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void createJson(String location, String oldMaterial, String newMaterial, String type) throws Exception {
        String path = location + oldMaterial + "_" + type + ".json";
        String oldString = readFileAsString(path);
        String newString = oldString.replace(oldMaterial, newMaterial);

        try {
            File file = new File(location + newMaterial + "_" + type + ".json");
            FileWriter writer = new FileWriter(file);
            writer.write(newString);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


    /**
     * Copies recipe json files and changes their type from minecraft:crafting_shaped/shapeless to
     * betterbuilding:fabricator_shaped/shapeless, so that the fabricator is able to craft these items. Use after every
     * Minecraft update to keep the fabricator current. Before usage, make sure to copy all recipe json files from the
     * base game files into a "minecraft_recipes_copy" directory (see the minecraftRecipesCopyPath variable).
     * */
    private static void copyCraftingRecipesForFabricator() throws IOException {
        String modRecipesPath = "src/main/resources/data/betterbuilding/recipes";
        String minecraftRecipesCopyPath = "src/main/resources/minecraft_recipes_copy";
        File[] modRecipeFiles = new File(modRecipesPath).listFiles();
        File[] minecraftRecipeFiles = new File(minecraftRecipesCopyPath).listFiles();

        if (modRecipeFiles == null || minecraftRecipeFiles == null) {
            System.out.println("Something went wrong while reading the files!");
            return;
        }

        File[] allFiles = concatTwoFileArrays(modRecipeFiles, minecraftRecipeFiles);
        for (File file : allFiles) {
            String fileString = new String(Files.readAllBytes(Paths.get(file.getPath())));
            if (fileString.contains("minecraft:crafting_shaped")) {
                fileString = fileString.replaceFirst("minecraft:crafting_shaped", "betterbuilding:fabricator_shaped");
            } else if (fileString.contains("minecraft:crafting_shapeless")) {
                fileString = fileString.replaceFirst("minecraft:crafting_shapeless", "betterbuilding:fabricator_shapeless");
            } else {
                continue;
            }

            String targetPath = "src/main/resources/generatedResources";
            String newFileName = targetPath + "/" + file.getName().replace(".json", "_from_fabricator.json");

            try {
                File newFile = new File(newFileName);
                FileWriter writer = new FileWriter(newFile);
                writer.write(fileString);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static File[] concatTwoFileArrays(File[] a1, File[] a2) {
        int arrayLength = a1.length + a2.length;
        File[] result = new File[arrayLength];
        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i];
        }
        for (int i = a1.length; i < arrayLength; i++) {
            result[i] = a2[i - a1.length];
        }

        return result;
    }
}
