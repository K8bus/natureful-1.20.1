package net.k8bus.naturefulmod;

import net.fabricmc.api.ModInitializer;

import net.k8bus.naturefulmod.block.ModBlocks;
import net.k8bus.naturefulmod.item.ModItemGroup;
import net.k8bus.naturefulmod.item.ModItems;
import net.k8bus.naturefulmod.recipe.ModRecipes;
import net.k8bus.naturefulmod.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NaturefulMod implements ModInitializer {
	public static final String MOD_ID = "naturefulmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();


	}
}