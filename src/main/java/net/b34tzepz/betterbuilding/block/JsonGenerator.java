package net.b34tzepz.betterbuilding.block;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonGenerator {
    public static void main(String[] args) throws Exception {
        //createPillarBlockstateJson(findNewBlock());
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

    private static ArrayList<String> findNewBlock() throws IOException {
        String file = "src/main/java/net/b34tzepz/betterbuilding/block/Blocks.txt";
        Scanner scanner = new Scanner(new File(file));
        ArrayList<String> output = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("new Block")) {
                String[] words = line.split(" ");
                output.add(words[8]);
            }
        }
        System.out.println(output);
        return output;
    }

    private static void createRegisterstxt(ArrayList<String> blocks) {
        try {
            File file = new File("src/main/java/net/b34tzepz/betterbuilding/block/Registers.txt");
            FileWriter writer = new FileWriter(file);
            for (String block : blocks) {
                writer.write("public static final Block " + block + "_PILLAR = registerBlock(\"" + block.toLowerCase() + "_pillar\",\n" +
                        "                new PillarBlock(FabricBlockSettings.copyOf(Blocks." + block + ")), ModItemGroup.Pillars);\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createHashMaptxt(ArrayList<String> blocks){
        try {
            File file = new File("src/main/java/net/b34tzepz/betterbuilding/block/HashMap.txt");
            FileWriter writer = new FileWriter(file);
            for (String block : blocks){
                writer.write(".put(Blocks." + block + ", ModBlocks.Pillars." + block + "_PILLAR.getDefaultState())\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPillarBlockstateJson(ArrayList<String> blocks){
        try {
           for (String block : blocks){
               File file = new File("src/main/resources/assets/betterbuilding/blockstates/" + block.toLowerCase() + "_pillar.json");
               FileWriter writer = new FileWriter(file);
               writer.write("{\n" +
                       "  \"variants\": {\n" +
                       "    \"axis=x\": {\n" +
                       "      \"model\": \"betterbuilding:block/" + block.toLowerCase() + "_pillar\",\n" +
                       "      \"x\": 90,\n" +
                       "      \"y\": 90\n" +
                       "    },\n" +
                       "    \"axis=y\": {\n" +
                       "      \"model\": \"betterbuilding:block/" + block.toLowerCase() + "_pillar\"\n" +
                       "    },\n" +
                       "    \"axis=z\": {\n" +
                       "      \"model\": \"betterbuilding:block/" + block.toLowerCase() + "_pillar\",\n" +
                       "      \"x\": 90\n" +
                       "    }\n" +
                       "  }\n" +
                       "}");
               writer.close();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPillarBlockModelJson(ArrayList<String> blocks){
        try {
            for (String block : blocks){
                File file = new File("src/main/resources/assets/betterbuilding/models/block/" + block.toLowerCase() + "_pillar.json");
                FileWriter writer = new FileWriter(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
