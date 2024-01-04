package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.*;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import com.thekillerbunny.worldbender.utils;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.*;

public class pyramid {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher,
            CommandRegistryAccess registryAccess) {
        dispatcher.register(ClientCommandManager.literal("pyramid")
            .then(ClientCommandManager.argument("block", BlockStateArgumentType.blockState(registryAccess))
            .then(ClientCommandManager.argument("height", IntegerArgumentType.integer())
            .executes(context -> {
                BlockState blockstate = context.getArgument("block", BlockStateArgument.class)
                        .getBlockState();
                String blockStateString = utils.getStringFromState(false, blockstate);
                long size = (context.getArgument("height", Integer.class));
                Vec3d pos = context.getSource().getPlayer().getPos();

                context.getSource().getPlayer().sendMessage(Text.of("§e§e[WB] Printing pyramid!"));
                
                long i2 = 0;
                for (long i = size; i >= 0; i--) {
                    i2++;
                    Vec3d pos1 = new Vec3d(pos.x - i, (pos.y - 1) + i2, pos.z - i);
                    Vec3d pos2 = new Vec3d(pos.x + i, (pos.y - 1) + i2, pos.z + i);

					utils.fill(new Vec3d[]{pos1, pos2}, blockStateString);
                }
                return 1;
            }))));
    }
}