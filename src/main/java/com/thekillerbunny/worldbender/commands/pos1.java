package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;

import com.mojang.brigadier.CommandDispatcher;

import java.util.EnumSet;

public class pos1 {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("pos1")
            .executes(context -> {
				ClientPlayerEntity player = context.getSource().getPlayer();
				com.thekillerbunny.worldbender.worldBender.positions[0] = player.getPos().floorAlongAxes(EnumSet.of(Direction.Axis.X, Direction.Axis.Y, Direction.Axis.Z));
				com.thekillerbunny.worldbender.worldBender.positionsSet[0] = true;
				context.getSource().getPlayer().sendMessage(Text.translatable("worldbender.pos1").append("§e" + com.thekillerbunny.worldbender.worldBender.positions[0]));
            	return 1;
            }
        ));
    }
}
