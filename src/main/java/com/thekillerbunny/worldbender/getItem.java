package com.thekillerbunny.worldbender;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.*;

public class getItem {
    private static String endPortalFrame = "/summon falling_block ~ ~1 ~ {BlockState:{Name:\"minecraft:activator_rail\",Properties:{powered:\"false\"}},Time:1,Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~-1 end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~ end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-2 ~ ~1 end_portal_frame[facing=east]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~-1 end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~ end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~2 ~ ~1 end_portal_frame[facing=west]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-1 ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~ ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~1 ~ ~2 end_portal_frame[facing=north]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~-1 ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~ ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"setblock ~1 ~ ~-2 end_portal_frame[facing=south]\",Passengers:[{id:\"minecraft:command_block_minecart\",Command:\"kill @e[type=command_block_minecart,distance=..1]\"}]}]}]}]}]}]}]}]}]}]}]}],DisplayState:{Name:\"minecraft:activator_rail\",Properties:{powered:\"false\"}}}]}";

    public ItemStack CustomBlocksShulker() throws CommandSyntaxException {
        //
        /*
         * NbtCompound NBT = StringNbtReader.parse("""
         * {
         * display: {
         * Name: '{"text":"Custom Blocks","italic":false}'
         * },
         * HideFlags: 32,
         * BlockEntityTag: {
         * Items: [
         * {
         * Slot: 0b,
         * id: "minecraft:campfire",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Unlit Campfire","italic":false}'
         * },
         * BlockStateTag: {
         * lit: "false"
         * }
         * }
         * },
         * {
         * Slot: 1b,
         * id: "minecraft:sculk_shrieker",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Sculk Shrieker (Warden)","italic":false}'
         * },
         * BlockStateTag: {
         * can_summon: "true"
         * }
         * }
         * },
         * {
         * Slot: 2b,
         * id: "minecraft:repeater",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Active Repeater","italic":false}'
         * },
         * BlockStateTag: {
         * locked: "true",
         * powered: "true"
         * }
         * }
         * },
         * {
         * Slot: 3b,
         * id: "minecraft:command_block",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Nether Portal","color":"light_purple","italic":false}'
         * },
         * HideFlags: 1,
         * Enchantments: [
         * {
         * id: "minecraft:power",
         * lvl: 1s
         * }
         * ],
         * BlockEntityTag: {
         * auto: 1b,
         * Command: "setblock ~ ~ ~ nether_portal"
         * }
         * }
         * },
         * {
         * Slot: 4b,
         * id: "minecraft:command_block",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"End Portal","color":"light_purple","italic":false}'
         * },
         * HideFlags: 1,
         * Enchantments: [
         * {
         * id: "minecraft:power",
         * lvl: 1s
         * }
         * ],
         * BlockEntityTag: {
         * auto: 1b,
         * Command: "setblock ~ ~ ~ end_portal"
         * }
         * }
         * },
         * {
         * Slot: 5b,
         * id: "minecraft:command_block",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"End Gateway","color":"light_purple","italic":false}'
         * },
         * HideFlags: 1,
         * Enchantments: [
         * {
         * id: "minecraft:power",
         * lvl: 1s
         * }
         * ],
         * BlockEntityTag: {
         * auto: 1b,
         * Command: "setblock ~ ~ ~ end_gateway"
         * }
         * }
         * },
         * {
         * Slot: 6b,
         * id: "minecraft:command_block",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"End Portal Frame","italic":false}'
         * },
         * Enchantments: [
         * {}
         * ],
         * BlockEntityTag: {
         * Command: '/summon falling_block ~ ~1 ~
         * {BlockState:{Name:"minecraft:activator_rail",Properties:{powered:"false"}},
         * Time:1,Passengers:[{id:"minecraft:command_block_minecart",
         * Command:"setblock ~-2 ~ ~-1 end_portal_frame[facing=east]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~-2 ~ ~ end_portal_frame[facing=east]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~-2 ~ ~1 end_portal_frame[facing=east]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~2 ~ ~-1 end_portal_frame[facing=west]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~2 ~ ~ end_portal_frame[facing=west]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~2 ~ ~1 end_portal_frame[facing=west]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~-1 ~ ~2 end_portal_frame[facing=north]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~ ~ ~2 end_portal_frame[facing=north]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~1 ~ ~2 end_portal_frame[facing=north]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~-1 ~ ~-2 end_portal_frame[facing=south]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~ ~ ~-2 end_portal_frame[facing=south]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"setblock ~1 ~ ~-2 end_portal_frame[facing=south]",Passengers:[{id:
         * "minecraft:command_block_minecart",
         * Command:"kill @e[type=command_block_minecart,distance=..1]"}]}]}]}]}]}]}]}]}]
         * }]}]}],DisplayState:{Name:"minecraft:activator_rail",Properties:{powered:
         * "false"}}}]}'
         * }
         * }
         * },
         * {
         * Slot: 7b,
         * id: "minecraft:totem_of_undying",
         * Count: 64b
         * },
         * {
         * Slot: 8b,
         * id: "minecraft:firework_rocket",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Smoke Bomb","italic":false}'
         * },
         * Fireworks: {
         * Flight: -1b,
         * Explosions: [
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * },
         * {
         * Type: 0,
         * Colors: [I; 16711680]
         * }
         * ]
         * }
         * }
         * },
         * {
         * Slot: 9b,
         * id: "minecraft:barrel",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Open Barrel","italic":false}'
         * },
         * BlockStateTag: {
         * open: "true"
         * }
         * }
         * },
         * {
         * Slot: 10b,
         * id: "minecraft:chiseled_bookshelf",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Filled Chisled Bookshelf","italic":false}'
         * },
         * BlockEntityTag: {
         * Items: [
         * {
         * Slot: 0b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * },
         * {
         * Slot: 1b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * },
         * {
         * Slot: 2b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * },
         * {
         * Slot: 3b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * },
         * {
         * Slot: 4b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * },
         * {
         * Slot: 5b,
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: [""]
         * }
         * }
         * ]
         * },
         * BlockStateTag: {
         * slot_0_occupied: "true",
         * slot_1_occupied: "true",
         * slot_2_occupied: "true",
         * slot_3_occupied: "true",
         * slot_4_occupied: "true",
         * slot_5_occupied: "true"
         * }
         * }
         * },
         * {
         * Slot: 11b,
         * id: "minecraft:lectern",
         * Count: 1b,
         * tag: {
         * display: {
         * Name: '{"text":"Redstone Levels","italic":false}'
         * },
         * BlockEntityTag: {
         * Book: {
         * id: "minecraft:writable_book",
         * Count: 1b,
         * tag: {
         * pages: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
         * "14", "15"]
         * }
         * }
         * },
         * BlockStateTag: {
         * has_book: "true"
         * }
         * }
         * }
         * ]
         * }
         * }
         * """);
         */

        NbtCompound NBT = createShulkerBoxNbt();

        ItemStack item = new ItemStack(Items.SHULKER_BOX, 1);
        item.setNbt(NBT);
        return item;
    }

    public static NbtCompound createShulkerBoxNbt() {
        NbtCompound nbt = new NbtCompound();

        // Basic Shulker Box tags
        nbt.putString("id", "minecraft:shulker_box");
        nbt.putByte("Count", (byte) 1);
        NbtCompound display = new NbtCompound();
        display.putString("Name", "{\"text\":\"Custom Blocks\",\"italic\":false}");

        // BlockEntityTag with Items list
        NbtCompound blockEntityTag = new NbtCompound();
        NbtList itemsList = new NbtList();

        // Add items with their respective NBT
        // Slot 0: Unlit Campfire
        itemsList.add(createItemNbt("minecraft:campfire", 0, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Unlit Campfire\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "lit", "false" } })));

        // Slot 1: Sculk Shrieker (Warden)
        itemsList.add(createItemNbt("minecraft:sculk_shrieker", 1, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Sculk Shrieker (Warden)\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "can_summon", "true" } })));

        // Slot 2: Powered Repeater
        itemsList.add(createItemNbt("minecraft:repeater", 2, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Powered Repeater\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "powered", "true" }, { "locked", "true" } })));
        // Slot 3: Nether Portal
        itemsList.add(createItemNbt("minecraft:command_block", 3, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"Nether Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ nether_portal" } }, true)));
        // Slot 4: End Portal
        itemsList.add(createItemNbt("minecraft:command_block", 4, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_portal" } }, true)));
        // Slot 5: End Gateway
        itemsList.add(createItemNbt("minecraft:command_block", 5, 1,
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Gateway\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_gateway" } }, true)));
        // Slot 6: End Portal Frame
        itemsList.add(createItemNbt("minecraft:command_block", 6, 1,
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"End Portal Frame (power with lever)\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", endPortalFrame } })));
        // Slot 7: Stack of totems
        itemsList.add(createItemNbt("minecraft:totem_of_undying", 7, 64,
                null, null));
        // Slot 8: Open Barrel
        itemsList.add(createItemNbt("minecraft:barrel", 8, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Open Barrel\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "open", "true" } })));
        // Slot 9: Full Chisled Bookshelf
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
        itemsList.add(createItemNbt("minecraft:chiseled_bookshelf", 9, 1,
                createNbt(new String[][] { { "Name", "{\"text\":\"Full Chisled Bookshelf\",\"italic\":false}" } }),
                BookshelfNbtTag));

        blockEntityTag.put("Items", itemsList);
        NbtCompound tag = new NbtCompound();
        tag.put("BlockEntityTag", blockEntityTag);
        tag.put("display", display);
        nbt.put("tag", tag);

        return nbt;
    }

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
