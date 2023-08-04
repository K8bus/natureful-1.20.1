package net.k8bus.naturefulmod.recipe;

import com.google.gson.JsonObject;
import net.k8bus.naturefulmod.block.ModBlocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

public class SawingRecipe extends CuttingRecipe {

    public SawingRecipe(Identifier id, String group, Ingredient input, ItemStack output) {
        super(Type.INSTANCE, ModRecipes.SAWING_SR, id, group, input, output);
    }

    public boolean matches(Inventory inventory, World world) {
        return this.input.test(inventory.getStack(0));
    }

    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.SAWMILL);
    }

    public static class Type implements RecipeType<SawingRecipe> {
        public Type() { }
        public static Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<SawingRecipe> {
        final CuttingRecipe.Serializer.RecipeFactory<SawingRecipe> recipeFactory;

        protected Serializer(CuttingRecipe.Serializer.RecipeFactory<SawingRecipe> recipeFactory) {
            this.recipeFactory = recipeFactory;
        }

        public SawingRecipe read(Identifier identifier, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            Ingredient ingredient;
            if (JsonHelper.hasArray(jsonObject, "ingredient")) {
                ingredient = Ingredient.fromJson(JsonHelper.getArray(jsonObject, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(JsonHelper.getObject(jsonObject, "ingredient"));
            }

            String string2 = JsonHelper.getString(jsonObject, "result");
            int i = JsonHelper.getInt(jsonObject, "count");
            ItemStack itemStack = new ItemStack((ItemConvertible) Registries.ITEM.get(new Identifier(string2)), i);
            return this.recipeFactory.create(identifier, string, ingredient, itemStack);
        }

        public SawingRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            String string = packetByteBuf.readString();
            Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
            ItemStack itemStack = packetByteBuf.readItemStack();
            return this.recipeFactory.create(identifier, string, ingredient, itemStack);
        }

        public void write(PacketByteBuf packetByteBuf, SawingRecipe cuttingRecipe) {
            packetByteBuf.writeString(cuttingRecipe.group);
            cuttingRecipe.input.write(packetByteBuf);
            packetByteBuf.writeItemStack(cuttingRecipe.output);
        }

        public interface RecipeFactory<T extends CuttingRecipe> {
            T create(Identifier id, String group, Ingredient input, ItemStack output);
        }
    }
}
