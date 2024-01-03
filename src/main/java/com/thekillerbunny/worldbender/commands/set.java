package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import com.thekillerbunny.worldbender.commandQueue;
import com.thekillerbunny.worldbender.utils;

import com.mojang.brigadier.CommandDispatcher;

public class set {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(ClientCommandManager.literal("set")
			.then(ClientCommandManager.argument("block", BlockStateArgumentType.blockState(registryAccess))
            .executes(context -> {
				if (com.thekillerbunny.worldbender.WorldBender.positionsSet[0] && com.thekillerbunny.worldbender.WorldBender.positionsSet[1]) {
					BlockState blockstate = context.getArgument("block", BlockStateArgument.class).getBlockState();
					String blockStateString = utils.getStringFromState(blockstate);
					Vec3d[][] prisms = utils.dividePrism(com.thekillerbunny.worldbender.WorldBender.positions[0], com.thekillerbunny.worldbender.WorldBender.positions[1]);
					
					for (Vec3d[]element : prisms) {
						commandQueue.queue("fill " + (long) element[0].x + " " + (long) element[0].y + " " + (long) element[0].z + " " + (long) element[1].x + " " + (long) element[1].y + " " + (long) element[1].z + " " + blockStateString);
					}
					// networkHandler.sendChatCommand("");
					return 1;
				}else {
					context.getSource().sendFeedback(Text.literal("[WB] No positions set!"));
					return 0;
				}
            }
        )));
    }
}
