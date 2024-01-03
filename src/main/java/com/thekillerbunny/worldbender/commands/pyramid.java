package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.*;
import net.minecraft.util.math.Vec3d;

import com.thekillerbunny.worldbender.commandQueue;
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
                                    String blockStateString = utils.getStringFromState(blockstate);
                                    long size = context.getArgument("height", Integer.class);
                                    Vec3d pos = context.getSource().getPlayer().getPos().subtract(new Vec3d(0, 1, 0));

                                    size *= 2;

                                    long i2 = 0;
                                    for (long i = size; i >= 1; i -= 2) {
                                        i2++;
                                        Vec3d pos1 = new Vec3d(pos.x - (i / 2), pos.y + i2, pos.z - (i / 2));
                                        Vec3d pos2 = new Vec3d(pos.x + (i / 2), pos.y + i2, pos.z + (i / 2));

                                        Vec3d[][] prisms = utils.dividePrism(pos1, pos2);

                                        for (Vec3d[] element : prisms) {
                                                commandQueue.queue("fill " + (long) element[0].x + " "
                                                    + (long) element[0].y + " " + (long) element[0].z + " "
                                                    + (long) element[1].x + " " + (long) element[1].y + " "
                                                    + (long) element[1].z + " " + blockStateString);
                                        }
                                    }
                                    return 1;
                                }))));
    }
}