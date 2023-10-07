package net.k8bus.naturefulmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.k8bus.naturefulmod.NaturefulMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item AMBER_CHUNK = registerItem("amber_chunk", new Item(new FabricItemSettings()));
    public static final Item MAGNESIUM_CHUNK = registerItem("magnesium_chunk", new Item(new FabricItemSettings()));
    public static final Item MAGNESIUM_INGOT = registerItem("magnesium_ingot", new Item(new FabricItemSettings()));
    public static final Item MAGNESIUM_NUGGET = registerItem("magnesium_nugget", new Item(new FabricItemSettings()));
    public static final Item LUMINESCENT_CRYSTAL_SHARD = registerItem("luminescent_crystal_shard", new Item(new FabricItemSettings().fireproof()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        //entries.add(AMBER_CHUNK);
        //entries.add(LUMINESCENT_CRYSTAL_SHARD);
    }


    private static Item registerItem(String name, Item item) {
           return Registry.register(Registries.ITEM, new Identifier(NaturefulMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        NaturefulMod.LOGGER.info("Registering mod items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
