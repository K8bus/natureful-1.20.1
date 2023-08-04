package net.k8bus.naturefulmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.k8bus.naturefulmod.NaturefulMod;
import net.k8bus.naturefulmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {

    public static ItemGroup RESOURCES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(NaturefulMod.MOD_ID, "resources"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.naturefulmod.resources"))
                    .icon(() -> new ItemStack(ModItems.LUMINESCENT_CRYSTAL_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.LUMINESCENT_CRYSTAL_SHARD);
                        entries.add(ModItems.AMBER_CHUNK);

                        //entries.add(Items.DIAMOND);

                        entries.add(ModBlocks.POLISHED_LUMINESCENT_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.LUMINESCENT_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.LUMINESCENT_CRYSTAL_BUD);
                        entries.add(ModBlocks.AMBER_BLOCK);
                        entries.add(ModBlocks.RAW_AMBER_BLOCK);



                    }).build());

    public static void registerItemGroups() {
        NaturefulMod.LOGGER.info("Registering Item Groups for " + NaturefulMod.MOD_ID);
    }
}

