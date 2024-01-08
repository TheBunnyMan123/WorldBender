package com.thekillerbunny.worldbender.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class gateway {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {///give @p command_block{BlockEntityTag:{auto:1b,Command:"/setblock ~ ~ ~ end_gateway{ExactTeleport:1b,ExitPortal:{X:__,Y:__,Z:__}} replace"}} 1
        dispatcher.register(ClientCommandManager.literal("gateway")
            .then(ClientCommandManager.argument("destination X", DoubleArgumentType.doubleArg())
            .then(ClientCommandManager.argument("destination Y", DoubleArgumentType.doubleArg())
            .then(ClientCommandManager.argument("destination Z", DoubleArgumentType.doubleArg())
            .executes(context -> {
                Vec3d pos = new Vec3d(context.getArgument("destination X", double.class), context.getArgument("destination Y", double.class), context.getArgument("destination Z", double.class));
                String command = "give @p command_block{BlockEntityTag:{auto:1b,Command:\"/setblock ~ ~ ~ end_gateway{ExactTeleport:1b,ExitPortal:{X:" + pos.x + ",Y:" + pos.y + ",Z:" + pos.z + "}} replace\"}}";
                context.getSource().getClient().getNetworkHandler().sendChatCommand(command);
                context.getSource().getPlayer().sendMessage(Text.translatable("worldbender.generated"));
                return 1;
            }
        )))));
    }
}
