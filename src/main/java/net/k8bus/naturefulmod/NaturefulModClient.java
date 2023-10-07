package net.k8bus.naturefulmod;

import net.fabricmc.api.ClientModInitializer;
import net.k8bus.naturefulmod.screen.ModScreenHandlers;
import net.k8bus.naturefulmod.screen.SawmillScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class NaturefulModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.SAWMILL_HANDLER, SawmillScreen::new);


    }
}
