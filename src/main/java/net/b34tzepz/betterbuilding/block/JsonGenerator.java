package net.b34tzepz.betterbuilding.block;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonGenerator {
    public static void main(String[] args) throws Exception {
        generateJsons("oak", "spruce", "chair");
        generateJsons("oak", "birch", "chair");
        generateJsons("oak", "jungle", "chair");
        generateJsons("oak", "acacia", "chair");
        generateJsons("oak", "dark_oak", "chair");
        generateJsons("oak", "crimson", "chair");
        generateJsons("oak", "warped", "chair");
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
}
