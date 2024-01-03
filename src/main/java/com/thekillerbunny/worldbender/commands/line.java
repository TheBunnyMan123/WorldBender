package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import com.thekillerbunny.worldbender.utils;
import com.thekillerbunny.worldbender.worldBender;

import com.mojang.brigadier.CommandDispatcher;

public class line {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(ClientCommandManager.literal("line")
			.then(ClientCommandManager.argument("block", BlockStateArgumentType.blockState(registryAccess))
            .executes(context -> {
					BlockState blockstate = context.getArgument("block", BlockStateArgument.class).getBlockState();
					String blockStateString = utils.getStringFromState(false, blockstate);

                    utils.line(worldBender.positions[0], worldBender.positions[1], blockStateString);
                    return 1;
            }
        )));
    }
}
