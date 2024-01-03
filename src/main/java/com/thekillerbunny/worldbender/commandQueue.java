package com.thekillerbunny.worldbender;

import java.util.Arrays;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndTick;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class commandQueue implements EndTick {
    static String[] commandQueue = {};
    static String[] emptyQueue = {};
    public static int commandSpeed = 10;

    @Override
    public void onEndTick(MinecraftClient client) {
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        try {
            for (int i = 1; i <= 10; i++) {
                if (commandQueue[0] == null) {break;}
                networkHandler.sendChatCommand(commandQueue[0]);
                commandQueue = Arrays.copyOfRange(commandQueue, 1, commandQueue.length);
            }
        }catch(java.lang.NullPointerException e) {
        }catch(java.lang.ArrayIndexOutOfBoundsException e) {}
        // throw new UnsupportedOperationException("Unimplemented method 'onStartTick'");
    }

    public static void queue(String command) {
        commandQueue = Arrays.copyOf(commandQueue, commandQueue.length + 1);
        commandQueue[commandQueue.length - 1] = command;
    }

    public static void clearQueue() {
        commandQueue = emptyQueue;
    }
}