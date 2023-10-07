package net.k8bus.naturefulmod.screen;

import net.k8bus.naturefulmod.NaturefulMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {

    public static ScreenHandlerType<SawmillScreenHandler> SAWMILL_HANDLER =
            new ScreenHandlerType<>(SawmillScreenHandler::new, FeatureSet.empty());



    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(NaturefulMod.MOD_ID, "sawmill"),
                SAWMILL_HANDLER);
    }
}