package net.k8bus.naturefulmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.k8bus.naturefulmod.NaturefulMod;

import net.k8bus.naturefulmod.block.custom.CrystalBlock;
import net.k8bus.naturefulmod.block.custom.SawmillBlock;
import net.k8bus.naturefulmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block AMBER_BLOCK = registerBlock("amber_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.RESOURCES);

    public static final Block RAW_AMBER_BLOCK = registerBlock("raw_amber_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.CALCITE)),
            ModItemGroup.RESOURCES);

    public static final Block LUMINESCENT_CRYSTAL_BLOCK = registerBlock("luminescent_crystal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .emissiveLighting((state, world, pos) -> true)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(8)),
            ModItemGroup.RESOURCES);

    public static final Block POLISHED_LUMINESCENT_CRYSTAL_BLOCK = registerBlock("polished_luminescent_crystal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .emissiveLighting((state, world, pos) -> true)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(14)),
            ModItemGroup.RESOURCES);

    public static final Block LUMINESCENT_CRYSTAL_BUD = registerBlock("luminescent_crystal_bud",
            new CrystalBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)
                    .emissiveLighting((state, world, pos) -> true)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(8)
                    .nonOpaque()),
            ModItemGroup.RESOURCES);



    public static final Block SAWMILL = registerBlock("sawmill",
            new SawmillBlock(FabricBlockSettings.copyOf(Blocks.STONECUTTER)
                    .nonOpaque()),
            ModItemGroup.RESOURCES);



    public static final Block MAGNESIUM_BLOCK = registerBlock("magnesium_block",
            new CrystalBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)
                    .emissiveLighting((state, world, pos) -> true)
                    .strength(2f, 4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .luminance(8)
                    .nonOpaque()),
            ModItemGroup.RESOURCES);





    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(NaturefulMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(NaturefulMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
       NaturefulMod.LOGGER.info("Registering Mod Blocks for " + NaturefulMod.MOD_ID);
    }
}
