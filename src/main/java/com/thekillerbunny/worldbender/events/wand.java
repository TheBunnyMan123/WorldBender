package com.thekillerbunny.worldbender.events;

import com.thekillerbunny.worldbender.wands;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.MinecraftClient;
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
            if (player.getStackInHand(hand).getName().getString().equals(wands.treeWand.getName().getString())) {
                return ActionResult.PASS;
            }else if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[1])) {return ActionResult.PASS;}
                com.thekillerbunny.worldbender.worldBender.positions[1] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[1] = true;
                player.sendMessage(Text.translatable("worldbender.pos2").append("§e" + com.thekillerbunny.worldbender.worldBender.positions[1]));
            }
            return ActionResult.PASS;
        });
        AttackBlockCallback.EVENT.register((player, world, hand, blockPos, direction) -> {
            if (alreadyRanAtk == 1) {
                alreadyRanAtk -= 1;
                return ActionResult.PASS;
            }
            alreadyRanAtk++;
            if (player.getStackInHand(hand).getName().getString().equals(wands.treeWand.getName().getString())) {
                Vec3d pos = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                String sapling = player.getOffHandStack().getItem().getName().getString();
                // Sapling being held determines tree spawned. Amount of sapling determines tree mode. eg: jungle vs mega jungle
                if (sapling.equalsIgnoreCase(Items.OAK_SAPLING.getName().getString())) {
                    if (player.getOffHandStack().getCount() == 2) {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:fancy_oak " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }else if (player.getOffHandStack().getCount() == 3) {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:swamp_oak " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }else {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:oak " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }
                }else if (sapling.equalsIgnoreCase(Items.SPRUCE_SAPLING.getName().getString())) {
                    if (player.getOffHandStack().getCount() == 2) {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:mega_spruce " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }else {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:spruce " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }
                }else if (sapling.equalsIgnoreCase(Items.BIRCH_SAPLING.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:birch " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.JUNGLE_SAPLING.getName().getString())) {
                    if (player.getOffHandStack().getCount() == 2) {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:mega_jungle_tree " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }else {
                        MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:jungle_tree_no_vine " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                    }
                }else if (sapling.equalsIgnoreCase(Items.ACACIA_SAPLING.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:acacia " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.DARK_OAK_SAPLING.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:dark_oak " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.CHERRY_SAPLING.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:cherry " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.CRIMSON_FUNGUS.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:crimson_fungus " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.WARPED_FUNGUS.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:warped_fungus " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.AZALEA.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:azalea_tree " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.FLOWERING_AZALEA.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:azalea_tree " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.RED_MUSHROOM.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:huge_red_mushroom " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else if (sapling.equalsIgnoreCase(Items.BROWN_MUSHROOM.getName().getString())) {
                    MinecraftClient.getInstance().getNetworkHandler().sendChatCommand("place feature minecraft:huge_brown_mushroom " + (int) pos.x + " " + (int) (pos.y + 1) + " " + (int) pos.z);
                }else {
                    player.sendMessage(Text.translatable("worldbender.saplingneeded"));
                }
            }else if (player.getStackInHand(hand).getItem() == Items.DEBUG_STICK) {
                Vec3d vec = new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                if (vec.equals(com.thekillerbunny.worldbender.worldBender.positions[0])) {return ActionResult.PASS;}
                com.thekillerbunny.worldbender.worldBender.positions[0] = vec;
                com.thekillerbunny.worldbender.worldBender.positionsSet[0] = true;
                player.sendMessage(Text.translatable("worldbender.pos1").append("§e" + com.thekillerbunny.worldbender.worldBender.positions[0]));
            }
            return ActionResult.PASS;
        });
    }
}
