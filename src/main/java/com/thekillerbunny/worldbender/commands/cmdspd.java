package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class cmdspd {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("pos1")
            .then(ClientCommandManager.argument("speed", IntegerArgumentType.integer())
            .executes(context -> {
				com.thekillerbunny.worldbender.commandQueue.commandSpeed = context.getArgument("speed", int.class);
				context.getSource().sendFeedback(Text.literal("[WB] Command speed set to: " + com.thekillerbunny.worldbender.commandQueue.commandSpeed));
            	return 1;
            }
        )));
    }
}
