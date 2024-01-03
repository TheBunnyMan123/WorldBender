package com.thekillerbunny.worldbender.commands;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;

import com.mojang.brigadier.CommandDispatcher;

import java.util.EnumSet;

public class pos2 {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("pos2")
            .executes(context -> {
				ClientPlayerEntity player = context.getSource().getPlayer();
				com.thekillerbunny.worldbender.worldBender.positions[1] = player.getPos().floorAlongAxes(EnumSet.of(Direction.Axis.X, Direction.Axis.Y, Direction.Axis.Z));
				com.thekillerbunny.worldbender.worldBender.positionsSet[1] = true;
				context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Position 2 set to: " + com.thekillerbunny.worldbender.worldBender.positions[1]));
            	return 1;
            }
        ));
    }
}
