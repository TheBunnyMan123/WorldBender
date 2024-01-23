package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.thekillerbunny.worldbender.utils;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class calc {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("calc")
			.then(ClientCommandManager.argument("expression", StringArgumentType.greedyString())
            .executes(context -> {
                    Double result = utils.mathEval(context.getArgument("expression", String.class));
                    if (result == null) {
                        context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Invalid math expression!"));
                        return 0;
                    }
                    context.getSource().getPlayer().sendMessage(Text.translatable("worldbender.result").append(Double.toString(result)));
                    return 1;
            }
        )));
    }
}
