package com.thekillerbunny.worldbender;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.math.Vec3d;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thekillerbunny.worldbender.commands.*;

public class worldBender implements ModInitializer {
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
			sphere.register(dispatcher, registryAccess);
			pyramid.register(dispatcher, registryAccess);
			cmdspd.register(dispatcher);
			line.register(dispatcher, registryAccess);
			blocks.register(dispatcher);
			gateway.register(dispatcher);
		});

		wand.Init();
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> new commandQueue().onEndTick(client));
		ClientTickEvents.END_CLIENT_TICK.register(client -> new onTick().onEndTick(client));

		LOGGER.info("WorldBender Initialized!");
	}
}