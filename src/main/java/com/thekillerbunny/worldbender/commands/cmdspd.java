package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.thekillerbunny.worldbender.config;
import com.thekillerbunny.worldbender.events.commandQueue;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class cmdspd {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("cmdspd")
            .then(ClientCommandManager.argument("speed", IntegerArgumentType.integer())
            .executes(context -> {
				commandQueue.commandSpeed = context.getArgument("speed", int.class);
                config.set("command_speed", commandQueue.commandSpeed);
				context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Command speed set to: " + commandQueue.commandSpeed));
            	return 1;
            }
        )));

        dispatcher.register(ClientCommandManager.literal("cmdspd")
            .executes(context -> {
				context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Command speed is currently set to: " + commandQueue.commandSpeed));
            	return 1;
            }
        ));
    }
}
