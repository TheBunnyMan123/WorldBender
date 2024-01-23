package com.thekillerbunny.worldbender;

import net.fabricmc.loader.api.FabricLoader;
import java.nio.file.Path;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class config {
    static Path configDir = FabricLoader.getInstance().getConfigDir();
    static File configFile = new File(configDir.toFile(), "worldbender.json");
    static File exampleScript = new File(configDir.toFile(), "worldbender-scripts/example.js");
    static JsonObject jsonObject = new JsonObject();

    public static void initConfig() throws IOException {
        if (!configFile.exists()) {
            // Create parent directories if needed
            configFile.getParentFile().mkdirs();

            // Write default configuration values
            FileWriter writer = new FileWriter(configFile);
            writer.write("{\"command_speed\": 10}");
            writer.close();
        }

        FileReader reader = new FileReader(configFile);

        char[] buffer = new char[(int) configFile.length()];
        reader.read(buffer);

        String jsonContent = new String(buffer);

        reader.close();

        jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
    }

    public static void set(String key, String value) {
        jsonObject.addProperty(key, value); 

        try {
            FileWriter writer = new FileWriter(configFile);
            writer.write(jsonObject.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void set(String key, int value) {
        jsonObject.addProperty(key, value); 

        try {
            FileWriter writer = new FileWriter(configFile);
            writer.write(jsonObject.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static String get(String key) {
        String value;
        try {
            value = jsonObject.get(key).getAsString();

            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getInt(String key) {
        int value;
        try {
            value = jsonObject.get(key).getAsInt();

            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return 5;
        }
    }
}