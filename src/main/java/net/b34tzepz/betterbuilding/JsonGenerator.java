package net.b34tzepz.betterbuilding;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class JsonGenerator {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table.json");
        Path file1 = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table_1bowl.json");
        Path file2 = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table_2bowls1.json");
        Path file22 = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table_2bowls2.json");
        Path file3 = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table_3bowls.json");
        Path file4 = Paths.get("src/main/resources/assets/betterbuilding/models/block/oak_table_4bowls.json");

        copyAndReplace(file, "oak", "bamboo_mosaic");
        copyAndReplace(file1, "oak", "bamboo_mosaic");
        copyAndReplace(file2, "oak", "bamboo_mosaic");
        copyAndReplace(file22, "oak", "bamboo_mosaic");
        copyAndReplace(file3, "oak", "bamboo_mosaic");
        copyAndReplace(file4, "oak", "bamboo_mosaic");

        /*generateJsons("ice", "blue_ice", "pillar");
        generateJsons("granite", "redstone", "pillar");
        generateJsons("granite", "tnt", "pillar");
        generateJsons("granite", "crying_obsidian", "pillar");
        generateJsons("granite", "ochre_froglight", "pillar");
        generateJsons("granite", "verdant_froglight", "pillar");
        generateJsons("granite", "pearlescent_froglight", "pillar");*/

    }

    public static Path copyAndReplace(
            Path sourceFile,
            String search,
            String replace
    ) throws IOException {

        // Verzeichnis der Quelldatei
        Path directory = sourceFile.getParent();

        // Neuer Dateiname mit ersetztem String
        String newFileName = sourceFile.getFileName()
                .toString()
                .replace(search, replace);

        Path targetFile = directory.resolve(newFileName);

        // Dateiinhalt lesen
        String content = Files.readString(sourceFile, StandardCharsets.UTF_8);

        // String im Inhalt ersetzen
        content = content.replace(search, replace);

        // Neue Datei schreiben
        Files.writeString(targetFile, content, StandardCharsets.UTF_8);

        return targetFile;
    }

    /**
     * Generates Blockstate, BlockModel, ItemModel, LootTable and Recipe Json based on a reference
     *
     * @param oldMaterial Reference as String
     * @param newMaterial Replacement of oldMaterial
     * @param type        Type of the Block, e.g. stairs or slabs
     */
    private static void generateJsons(String oldMaterial, String newMaterial, String type) {
        generateBlockstateJson(oldMaterial, newMaterial, type);
        generateBlockModelJson(oldMaterial, newMaterial, type);
        generateItemModelJson(oldMaterial, newMaterial, type);
        generateLootTableJson(oldMaterial, newMaterial, type);
        //generateRecipeJson(oldMaterial, newMaterial, type);
    }

    private static void generateBlockstateJson(String oldMaterial, String newMaterial, String type) {
        String location = "src/main/resources/assets/betterbuilding/blockstates/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateBlockModelJson(String oldMaterial, String newMaterial, String type) {
        String location = "src/main/resources/assets/betterbuilding/models/block/";
        String pathname = location + oldMaterial + "_" + type;
        File fileOuter = new File(pathname + "_outer.json");
        File fileOuterMirrored = new File(pathname + "_outer_mirrored.json");

        if (fileOuter.exists() && !fileOuter.isDirectory()) {
            createJson(location, oldMaterial, newMaterial, type + "_outer");
            createJson(location, oldMaterial, newMaterial, type + "_inner");

            if (fileOuterMirrored.exists() && !fileOuterMirrored.isDirectory()) {
                createJson(location, oldMaterial, newMaterial, type + "_outer_mirrored");
            }
        }
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateItemModelJson(String oldMaterial, String newMaterial, String type) {
        String location = "src/main/resources/assets/betterbuilding/models/item/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateLootTableJson(String oldMaterial, String newMaterial, String type) {
        String location = "src/main/resources/data/betterbuilding/loot_tables/blocks/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void generateRecipeJson(String oldMaterial, String newMaterial, String type) {
        String location = "src/main/resources/data/betterbuilding/recipes/";
        createJson(location, oldMaterial, newMaterial, type);
    }

    private static void createJson(String location, String oldMaterial, String newMaterial, String type) {
        try {
            String path = location + oldMaterial + "_" + type + ".json";
            String oldString = readFileAsString(path);
            String newString = oldString.replace(oldMaterial, newMaterial);


            File file = new File(location + newMaterial + "_" + type + ".json");
            FileWriter writer = new FileWriter(file);
            writer.write(newString);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


    /**
     * Copies recipe json files and changes their type from minecraft:crafting_shaped/shapeless to
     * betterbuilding:fabricator_shaped/shapeless, so that the fabricator is able to craft these items. Use after every
     * Minecraft update to keep the fabricator current. Before usage, make sure to copy all recipe json files from the
     * base game files into a "minecraft_recipes_copy" directory (see the minecraftRecipesCopyPath variable).
     */
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

    /**
     * Ab hier ist Absturz
     **/
    private static ArrayList<String> findNewBlock() throws IOException {
        String file = "src/main/java/net/b34tzepz/betterbuilding/block/files/Blocks.txt";
        Scanner scanner = new Scanner(new File(file));
        ArrayList<String> blocks = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("new Block")) {
                String[] words = line.split(" ");
                blocks.add(words[8]);
            }
        }
        System.out.println(blocks);
        return blocks;
    }

    private static void createRegisterstxt(ArrayList<String> blocks) {
        try {
            File file = new File("src/main/java/net/b34tzepz/betterbuilding/block/files/Registers.txt");
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

    private static void createHashMaptxt(ArrayList<String> blocks) {
        try {
            File file = new File("src/main/java/net/b34tzepz/betterbuilding/block/files/HashMap.txt");
            FileWriter writer = new FileWriter(file);
            for (String block : blocks) {
                writer.write(".put(Blocks." + block + ", ModBlocks.Pillars." + block + "_PILLAR.getDefaultState())\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPillarBlockstateJson(ArrayList<String> blocks) {
        try {
            for (String block : blocks) {
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

    private static void createPillarBlockModelJson(ArrayList<String> blocks) {
        String oldString;
        try {
            for (String block : blocks) {
                if (block.startsWith("WAXED")) {
                    oldString = readFileAsString("src/main/java/net/b34tzepz/betterbuilding/block/files/block/" + block.substring(6).toLowerCase() + ".json");
                } else {
                    oldString = readFileAsString("src/main/java/net/b34tzepz/betterbuilding/block/files/models/block/" + block.toLowerCase() + ".json");
                }
                String newString = oldString.replace("\"parent\": \"minecraft", "\"parent\": \"betterbuilding").replace("cube", "pillar");
                File file = new File("src/main/resources/assets/betterbuilding/models/block/" + block.toLowerCase() + "_pillar.json");
                FileWriter writer = new FileWriter(file);
                writer.write(newString);
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPillarItemModelJson(ArrayList<String> blocks) {
        try {
            for (String block : blocks) {
                File file = new File("src/main/resources/assets/betterbuilding/models/item/" + block.toLowerCase() + "_pillar.json");
                FileWriter writer = new FileWriter(file);
                writer.write("{\n" +
                        "  \"parent\": \"betterbuilding:block/" + block.toLowerCase() + "_pillar\"\n" +
                        "}");
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTranslationtxt(ArrayList<String> blocks) {
        try {
            File file = new File("src/main/java/net/b34tzepz/betterbuilding/block/files/Translation.txt");
            FileWriter writer = new FileWriter(file);
            for (String block : blocks) {
                StringBuilder translation = new StringBuilder();
                String[] words = block.toLowerCase().split("_");
                for (String word : words) {
                    translation.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
                }
                translation.append("Pillar");
                writer.write("\"block.betterbuilding." + block.toLowerCase() + "_pillar\": \"" + translation + "\",\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyLootTable(ArrayList<String> blocks) {
        try {
            for (String block : blocks) {
                if (block.equals("BEDROCK")) continue;
                File file = new File("src/main/resources/data/betterbuilding/loot_tables/blocks/" + block.toLowerCase() + "_pillar.json");
                FileWriter writer = new FileWriter(file);
                writer.write(readFileAsString("src/main/java/net/b34tzepz/betterbuilding/block/files/loot_tables/blocks/" + block.toLowerCase() + ".json"));
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
