package com.thekillerbunny.worldbender;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemTab {
    /**
     * @param icon
     */
    public static void init(Item icon) {
        final ItemGroup itemGroup = FabricItemGroup.builder()
    		.icon(() -> new ItemStack(icon))
    		.displayName(Text.translatable("itemGroup.worldbender.custom_items"))
        	.entries((context, entries) -> {
                new ItemStack(Items.DEBUG_STICK, 1);
                new ItemStack(Items.COMMAND_BLOCK, 1);
                new ItemStack(Items.LIGHT, 1);
                new ItemStack(Items.BARRIER, 1);
    		})
    		.build();

        Registry.register(Registries.ITEM_GROUP, new Identifier("worldbender", "item_group"), itemGroup);
    }
}
