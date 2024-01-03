package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import com.thekillerbunny.worldbender.utils;
import com.thekillerbunny.worldbender.worldBender;
import com.mojang.brigadier.CommandDispatcher;

public class replace {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        dispatcher.register(ClientCommandManager.literal("replace")
			.then(ClientCommandManager.argument("replace", BlockStateArgumentType.blockState(registryAccess))
            .then(ClientCommandManager.argument("with", BlockStateArgumentType.blockState(registryAccess))
            .executes(context -> {
				if (com.thekillerbunny.worldbender.worldBender.positionsSet[0] && com.thekillerbunny.worldbender.worldBender.positionsSet[1]) {
					BlockState blockstate = context.getArgument("replace", BlockStateArgument.class).getBlockState();
					String blockStateReplace = utils.getStringFromState(true, blockstate);
					BlockState blockstate2 = context.getArgument("with", BlockStateArgument.class).getBlockState();
					String blockStateWith = utils.getStringFromState(false, blockstate2);
					
					context.getSource().getPlayer().sendMessage(Text.of("§e§e[WB] Replacing in selection!"));

					Vec3d[] cube = {worldBender.positions[0], worldBender.positions[1]};
					utils.fill(cube, blockStateWith + " replace " + blockStateReplace);
					return 1;
				}else {
					context.getSource().getPlayer().sendMessage(Text.of("§c[WB] No positions set!"));
					return 0;
				}
            }
        ))));
    }
}
