package com.thekillerbunny.worldbender.events;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class wand {
    private static int alreadyRanUse = 0;
    private static int alreadyRanAtk = 0;

    public static void Init() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (alreadyRanUse == 1) {
                alreadyRanUse -= 1;
                return ActionResult.PASS;
            }
            alreadyRanUse++;
            BlockPos blockPos = hitResult.getBlockPos();
            if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[1])) {
                    return ActionResult.PASS;
                }
                com.thekillerbunny.worldbender.worldBender.positions[1] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[1] = true;
                player.sendMessage(Text.translatable("worldbender.pos2")
                        .append("§e" + com.thekillerbunny.worldbender.worldBender.positions[1]));
            }
            return ActionResult.PASS;
        });
        AttackBlockCallback.EVENT.register((player, world, hand, blockPos, direction) -> {
            if (alreadyRanAtk == 1) {
                alreadyRanAtk -= 1;
                return ActionResult.PASS;
            }
            alreadyRanAtk++;
            if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[0])) {
                    return ActionResult.PASS;
                }
                com.thekillerbunny.worldbender.worldBender.positions[0] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[0] = true;
                player.sendMessage(Text.translatable("worldbender.pos1")
                        .append("§e" + com.thekillerbunny.worldbender.worldBender.positions[0]));
            }
            return ActionResult.PASS;

        });
    }
}
