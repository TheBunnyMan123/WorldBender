package com.thekillerbunny.worldbender;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemTab {
    private static String endPortalFrame = "/summon falling_block ~ ~1 ~ {BlockState:{Name:\"minecraft:activator_rail\",Properties:{powered:\"false\"}},Time:1,Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~-1 end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~ end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~1 end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~-1 end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~ end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~1 end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-1 ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~ ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~1 ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-1 ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~ ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~1 ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"kill @e[type=command_block_minecart,distance=..1]\"}]}]}]}]}]}]}]}]}]}]}]}],DisplayState:{Name:\"minecraft:activator_rail\",Properties:{powered:\"false\"}}}]}";
    private static String explodingArrows = "/summon falling_block ~ ~1 ~ {BlockState:{Name:\"minecraft:activator_rail\"},Time:1,Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"fill ~-3 ~ ~-1 ~-6 ~ ~1 minecraft:black_concrete\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"fill ~-3 ~2 ~-1 ~-6 ~2 ~1 minecraft:black_concrete\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"fill ~-3 ~1 ~-1 ~-6 ~1 ~1 minecraft:tinted_glass\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-3 ~1 ~ minecraft:black_concrete\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~1 ~ lever[face=wall,facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-4 ~1 ~ minecraft:repeating_command_block[facing=west]{Command:\\\"execute as @e[type=arrow,nbt={inGround:1b}] at @e[type=arrow,nbt={inGround:1b}] run summon tnt ~ ~ ~\\\"}\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-5 ~1 ~ minecraft:chain_command_block[facing=west]{auto:1b,Command:\\\"kill @e[type=arrow,nbt={inGround:1b}]\\\"}\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~2 ~ oak_wall_sign[facing=east]{front_text:{color:\\\"red\\\",has_glowing_text:1b,messages:['{\\\"text\\\":\\\"\\\"}','{\\\"text\\\":\\\"Exploding\\\"}','{\\\"text\\\":\\\"Arrows\\\"}','{\\\"text\\\":\\\"\\\"}']}} replace\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"kill @e[type=minecraft:command_block_minecart,distance=..1]\"}]}]}]}]}]}]}]}]}]}";
    private static NbtCompound[] Items = {
        // Slot 0: Unlit Campfire
        createItemNbt("minecraft:campfire", 0, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Unlit Campfire\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "lit", "false" } })),

        // Slot 1: Sculk Shrieker (Warden)
        createItemNbt("minecraft:sculk_shrieker", 1, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Sculk Shrieker (Warden)\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "can_summon", "true" } })),

        // Slot 2: Powered Repeater
        createItemNbt("minecraft:repeater", 2, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Powered Repeater\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "powered", "true" }, { "locked", "true" } })),
        // Slot 3: Nether Portal
        createItemNbt("minecraft:command_block", 3, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"Nether Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ nether_portal" } }, true)),
        // Slot 4: End Portal
        createItemNbt("minecraft:command_block", 4, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_portal" } }, true)),
        // Slot 5: End Gateway
        createItemNbt("minecraft:command_block", 5, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Gateway\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_gateway" } }, true)),
        // Slot 6: End Portal Frame
        createItemNbt("minecraft:command_block", 6, 1,
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"End Portal Frame (power with lever)\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", endPortalFrame } })),
        // // Slot 7: Stack of totems
        // createItemNbt("minecraft:totem_of_undying", 7, 64,
        //         null, null),
        // Slot 8: Open Barrel
        createItemNbt("minecraft:barrel", 8, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Open Barrel\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "open", "true" } })),
        // Slot 9: Full Chisled Bookshelf
        bookshelfNbt(),

        // Slot 10: Exploding Arrows
        createItemNbt("minecraft:command_block", 10, 1,
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"Exploding Arrows (power with lever)\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", explodingArrows } })),

        // Slot 11: All inside mushroom
        createItemNbt("minecraft:mushroom_stem", 11, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"All Inside Mushroom Block\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "up", "false" }, { "down", "false" }, { "north", "false" }, { "south", "false" }, { "east", "false" }, { "west", "false" } })),
    };

    public static void init(Item icon) {
        ItemGroup itemGroup = FabricItemGroup.builder()
    		.icon(() -> new ItemStack(icon))
    		.displayName(Text.translatable("itemGroup.worldbender.custom_items"))
        	.entries((context, entries) -> {
                        for (NbtCompound NBT : Items) {
    			        entries.add(ItemStack.fromNbt(NBT));
                        }
    		})
    		.build();

        Registry.register(Registries.ITEM_GROUP, new Identifier("worldbender", "item_group"), itemGroup);
    }

    public static NbtCompound bookshelfNbt() {
        NbtCompound BookshelfBlockStateNbt = createNbt(new String[][] { { "slot_0_occupied", "true" },
                { "slot_1_occupied", "true" }, { "slot_2_occupied", "true" }, { "slot_3_occupied", "true" },
                { "slot_4_occupied", "true" }, { "slot_5_occupied", "true" } });
        NbtCompound BookshelfNbt = new NbtCompound();
        NbtList BookshelfItems = new NbtList();

        for (int i = 0; i <= 5; i++) {
            NbtCompound BookNbt = new NbtCompound();
            BookNbt.putByte("Count", (byte) 1);
            BookNbt.putString("id", "minecraft:writable_book");
            BookNbt.putByte("Slot", (byte) i);

            NbtList PageList = new NbtList();
            for (int j = 1; j <= 15; j++) {
                PageList.add(NbtString.of("Redstone level " + j));
            }
            NbtCompound PageListCompound = new NbtCompound();
            PageListCompound.put("pages", PageList);

            BookNbt.put("tag", PageListCompound);

            BookshelfItems.add(BookNbt);
        }

        NbtCompound BookshelfNbtTag = new NbtCompound();
        BookshelfNbtTag.put("BlockStateTag", BookshelfBlockStateNbt);

        BookshelfNbt.put("Items", BookshelfItems);
        BookshelfNbtTag.put("BlockEntityTag", BookshelfNbt);
        NbtCompound BookshelfNbtInTag = new NbtCompound();
        BookshelfNbtInTag.put("tag", BookshelfNbtTag);
        return createItemNbt("minecraft:chiseled_bookshelf", 9, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Full Chisled Bookshelf\",\"italic\":false}" } }),
                BookshelfNbtTag);
    };

//     public static NbtCompound createShulkerBoxNbt() {
//         NbtCompound nbt = new NbtCompound();

//         // Basic Shulker Box tags
//         nbt.putString("id", "minecraft:shulker_box");
//         nbt.putByte("Count", (byte) 1);
//         NbtCompound display = new NbtCompound();
//         display.putString("Name", "{\"text\":\"Custom Blocks\",\"italic\":false}");

//         // BlockEntityTag with Items list
//         NbtCompound blockEntityTag = new NbtCompound();
//         NbtList itemsList = new NbtList();

//         // Add items with their respective NBT

//         blockEntityTag.put("Items", itemsList);
//         NbtCompound tag = new NbtCompound();
//         tag.put("BlockEntityTag", blockEntityTag);
//         tag.put("display", display);
//         nbt.put("tag", tag);

//         return nbt;
//     }

    private static NbtCompound createNbt(String parent, String[][] tags, boolean auto) {
        NbtCompound FinalNbt = new NbtCompound();
        NbtCompound parentNbt = new NbtCompound();
        for (String[] tag : tags) {
            parentNbt.putString(tag[0], tag[1]);
        }
        if (auto) {
            parentNbt.putByte("auto", (byte) 1);
        }
        FinalNbt.put(parent, parentNbt);
        return FinalNbt;
    }

    private static NbtCompound createNbt(String[][] tags) {
        NbtCompound FinalNbt = new NbtCompound();
        for (String[] tag : tags) {
            FinalNbt.putString(tag[0], tag[1]);
        }
        return FinalNbt;
    }

    private static NbtCompound createNbt(String parent, String[][] tags) {
        NbtCompound FinalNbt = new NbtCompound();
        NbtCompound parentNbt = new NbtCompound();
        for (String[] tag : tags) {
            parentNbt.putString(tag[0], tag[1]);
        }
        FinalNbt.put(parent, parentNbt);
        return FinalNbt;
    }

    // Helper method to create item NBT with individual data
    private static NbtCompound createItemNbt(String itemId, int slot, int count, NbtCompound display, NbtCompound tag) {
        NbtCompound itemNbt = new NbtCompound();
        itemNbt.putString("id", itemId);
        itemNbt.putByte("Count", (byte) count);
        itemNbt.putByte("Slot", (byte) slot);
        if (tag != null) {
            NbtCompound newTag = tag.copy();
            if (display != null) {
                newTag.put("display", display.copy()); // Avoid modifying original tag
            }
            itemNbt.put("tag", newTag); // Avoid modifying original tag
        }
        return itemNbt;
    }

    // ... (Add code to create item NBT for each item in the shulker box)
}
