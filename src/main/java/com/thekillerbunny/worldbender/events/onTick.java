package com.thekillerbunny.worldbender.events;

import com.thekillerbunny.worldbender.worldBender;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndTick;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class onTick implements EndTick {
    @Override
    public void onEndTick(MinecraftClient client) {
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        try {
            networkHandler.getServerInfo();
        }catch(java.lang.NullPointerException e) {
            commandQueue.clearQueue();
            com.thekillerbunny.worldbender.worldBender.positionsSet[0] = false;
            com.thekillerbunny.worldbender.worldBender.positionsSet[1] = false;
        }
    }
}