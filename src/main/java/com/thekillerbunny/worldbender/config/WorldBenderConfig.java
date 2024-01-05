package com.thekillerbunny.worldbender.config;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class WorldBenderConfig extends ConfigWrapper<com.thekillerbunny.worldbender.config.config> {

    public final Keys keys = new Keys();



    private WorldBenderConfig() {
        super(com.thekillerbunny.worldbender.config.config.class);
    }

    private WorldBenderConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(com.thekillerbunny.worldbender.config.config.class, janksonBuilder);
    }

    public static WorldBenderConfig createAndLoad() {
        var wrapper = new WorldBenderConfig();
        wrapper.load();
        return wrapper;
    }

    public static WorldBenderConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new WorldBenderConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }



    public static class Keys {

    }
}

