package com.thekillerbunny.worldbender;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class wand {
    public static void Init() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos blockPos = hitResult.getBlockPos();

            if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[1])) {return ActionResult.PASS;}
                com.thekillerbunny.worldbender.worldBender.positions[1] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[1] = true;
                player.sendMessage(Text.of("[WB] Position 2 set to: " + com.thekillerbunny.worldbender.worldBender.positions[1]));
            }
            return ActionResult.PASS;
        });
        AttackBlockCallback.EVENT.register((player, world, hand, blockPos, direction) -> {
            if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[0])) {return ActionResult.PASS;}
                com.thekillerbunny.worldbender.worldBender.positions[0] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[0] = true;
                player.sendMessage(Text.of("[WB] Position 1 set to: " + com.thekillerbunny.worldbender.worldBender.positions[0]));
            }
            return ActionResult.PASS;
        });
    }
}
