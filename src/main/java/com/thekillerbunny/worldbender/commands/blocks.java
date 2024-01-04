package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.thekillerbunny.worldbender.getItem;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class blocks {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("blocks")
            .executes(context -> {
                context.getSource().getPlayer().getInventory().offer(ItemStack.fromNbt(getItem.createShulkerBoxNbt()), true);
                context.getSource().getPlayer().sendMessage(Text.of("§e[WB] Insertted!"));
                return 1;
            }
        ));
    }
}
