package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.thekillerbunny.worldbender.getItem;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class blocks {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("blocks")
            .executes(context -> {
				ClientPlayerEntity player = context.getSource().getPlayer();
                player.getInventory().insertStack(ItemStack.fromNbt(getItem.createShulkerBoxNbt()));
				context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Added to inventory!"));
            	return 1;
            }
        ));
    }
}
