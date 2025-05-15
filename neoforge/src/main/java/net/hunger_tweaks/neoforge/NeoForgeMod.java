package net.hunger_tweaks.neoforge;

import net.neoforged.fml.common.Mod;

import net.hunger_tweaks.HungerTweaksMod;

@Mod(HungerTweaksMod.ID)
public final class NeoForgeMod {
    public NeoForgeMod() {
        // Run our common setup.
        HungerTweaksMod.init();
    }
}
