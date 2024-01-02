package com.thekillerbunny.worldbender;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.util.math.Vec3d;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thekillerbunny.worldbender.commands.*;

public class WorldBender implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("worldbender");
	public static Vec3d positions[] = {new Vec3d(0, 0, 0), new Vec3d(0, 0, 0)};
	public static boolean positionsSet[] = {false, false};

	@Override
	public void onInitialize() {
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			pos1.register(dispatcher);
			pos2.register(dispatcher);
			set.register(dispatcher, registryAccess);
			replace.register(dispatcher, registryAccess);
		});

		Wand.Init();

		LOGGER.info("WorldBender Initialized!");
			

	}
}