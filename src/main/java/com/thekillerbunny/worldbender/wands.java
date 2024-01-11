package com.thekillerbunny.worldbender;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class wands {
    public final static NbtCompound treeWandNbt = ItemTab.createItemNbt("debug_stick",
            ItemTab.createNbt(
                    new String[][] { { "Name", "{\"text\":\"Tree Wand\",\"italic\":false,\"color\":\"gold\"}" } }),
            null);
    public final static ItemStack treeWand = ItemStack.fromNbt(treeWandNbt);
}
