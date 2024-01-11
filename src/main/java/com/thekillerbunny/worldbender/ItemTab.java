package com.thekillerbunny.worldbender;

import com.google.common.base.Supplier;

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
    static Supplier<NbtList> bees = () -> {
        NbtList beeList = new NbtList();
        NbtCompound beeCompound = new NbtCompound();
        NbtCompound beeEntity = new NbtCompound();
        beeEntity.putString("id", "minecraft:bee");
        beeCompound.put("EntityData", beeEntity);
        for (int i = 1; i <= 3; i++) {
            beeList.add(beeCompound.copy());
        }
        return beeList;
    };

        //new NbtCompound().put("EntityData", beeEntityData);
    private static NbtCompound[] Items = {
        wands.treeWandNbt,

        // Selection Wand
        createItemNbt("minecraft:debug_stick",
                createNbt(new String[][] { { "Name", "{\"text\":\"Selection Wand\",\"italic\":false,\"color\":\"gold\"}" } }),
                null),
        
        // Unlit Campfire
        createItemNbt("minecraft:campfire",
                createNbt(new String[][] { { "Name", "{\"text\":\"Unlit Campfire\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "lit", "false" } })),

        // Sculk Shrieker (Warden)
        createItemNbt("minecraft:sculk_shrieker",
                createNbt(new String[][] { { "Name", "{\"text\":\"Sculk Shrieker (Warden)\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "can_summon", "true" } })),

        // Powered Repeater
        createItemNbt("minecraft:repeater",
                createNbt(new String[][] { { "Name", "{\"text\":\"Powered Repeater\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "powered", "true" }, { "locked", "true" } })),

        // Nether Portal
        createItemNbt("minecraft:command_block",
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"Nether Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ nether_portal" } }, true)),

        // End Portal
        createItemNbt("minecraft:command_block", 
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Portal\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_portal" } }, true)),

        // End Gateway
        createItemNbt("minecraft:command_block", 
                createNbt(new String[][] {
                        { "Name", "{\"text\":\"End Gateway\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", "setblock ~ ~ ~ end_gateway" } }, true)),

        // End Portal Frame
        createItemNbt("minecraft:command_block", 
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"End Portal Frame (power with lever)\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", endPortalFrame } })),

        // Exploding Arrows
        createItemNbt("minecraft:command_block", 
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"Exploding Arrows (power with lever)\",\"italic\":false,\"color\":\"light_purple\"}" } }),
                createNbt("BlockEntityTag", new String[][] { { "Command", explodingArrows } })),

        // Open Barrel
        createItemNbt("minecraft:barrel", 
                createNbt(new String[][] { { "Name", "{\"text\":\"Open Barrel\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "open", "true" } })),

        // Full Chisled Bookshelf
        bookshelfNbt(),

        // All inside mushroom
        createItemNbt("minecraft:mushroom_stem", 
                createNbt(new String[][] { { "Name", "{\"text\":\"All Inside Mushroom Block\",\"italic\":false}" } }),
                createNbt("BlockStateTag", new String[][] { { "up", "false" }, { "down", "false" }, { "north", "false" }, { "south", "false" }, { "east", "false" }, { "west", "false" } })),
    
        // Full Beehive
        createItemNbt("minecraft:beehive", 
                createNbt(new String[][] { { "Name",
                        "{\"text\":\"Full Bee Hive\",\"italic\":false}" } }),
                createNbt("BlockEntityTag", "Bees", bees.get())),
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
        return createItemNbt("minecraft:chiseled_bookshelf", 
                createNbt(new String[][] { { "Name", "{\"text\":\"Full Chisled Bookshelf\",\"italic\":false}" } }),
                BookshelfNbtTag);
    };

    static NbtCompound createNbt(String parent, String[][] tags, boolean auto) {
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

    static NbtCompound createNbt(String[][] tags) {
        NbtCompound FinalNbt = new NbtCompound();
        for (String[] tag : tags) {
            FinalNbt.putString(tag[0], tag[1]);
        }
        return FinalNbt;
    }

    static NbtCompound createNbt(String parent, String listParent, NbtList list) {
        NbtCompound FinalNbt = new NbtCompound();
        NbtCompound parentNbt = new NbtCompound();

        parentNbt.put(listParent, list);        
        FinalNbt.put(parent, parentNbt);

        return FinalNbt;
    }

    static NbtCompound createNbt(String parent, String[][] tags) {
        NbtCompound FinalNbt = new NbtCompound();
        NbtCompound parentNbt = new NbtCompound();
        for (String[] tag : tags) {
            parentNbt.putString(tag[0], tag[1]);
        }
        FinalNbt.put(parent, parentNbt);
        return FinalNbt;
    }

    // Helper method to create item NBT with individual data
    static NbtCompound createItemNbt(String itemId, NbtCompound display, NbtCompound tag) {
        NbtCompound itemNbt = new NbtCompound();
        itemNbt.putString("id", itemId);
        itemNbt.putByte("Count", (byte) 1);
        if (tag != null) {
            NbtCompound newTag = tag.copy();
            if (display != null) {
                newTag.put("display", display.copy()); // Avoid modifying original tag
            }
            itemNbt.put("tag", newTag); // Avoid modifying original tag
        }else {
            NbtCompound newTag = new NbtCompound();
            if (display != null) {
                newTag.put("display", display.copy()); // Avoid modifying original tag
            }
            itemNbt.put("tag", newTag); // Avoid modifying original tag
        }
        return itemNbt;
    }

    // ... (Add code to create item NBT for each item in the shulker box)
}
