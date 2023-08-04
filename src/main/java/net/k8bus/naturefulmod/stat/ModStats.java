package net.k8bus.naturefulmod.stat;

import net.k8bus.naturefulmod.NaturefulMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class ModStats {

    public static Identifier INTERACT_WITH_SAWMILL;
    public static Identifier INTERACT_WITH_KILN;

    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = new Identifier(NaturefulMod.MOD_ID, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }


    static {
        INTERACT_WITH_SAWMILL = register("interact_with_sawmill", StatFormatter.DEFAULT);
        INTERACT_WITH_KILN = register("interact_with_kiln", StatFormatter.DEFAULT);
    }

}