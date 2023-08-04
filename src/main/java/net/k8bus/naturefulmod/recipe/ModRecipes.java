package net.k8bus.naturefulmod.recipe;

import net.k8bus.naturefulmod.NaturefulMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static RecipeType SAWING;
    public static RecipeSerializer SAWING_SR;

    public static void registerRecipes() {

        SAWING_SR = Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(NaturefulMod.MOD_ID, "sawing"),
                new SawingRecipe.Serializer(SawingRecipe::new));
        SAWING = Registry.register(Registries.RECIPE_TYPE, new Identifier(NaturefulMod.MOD_ID, "sawing"),
                SawingRecipe.Type.INSTANCE);

    }
}
