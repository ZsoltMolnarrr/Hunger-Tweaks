package net.hunger_tweaks;

import net.hunger_tweaks.config.Config;
import net.tinyconfig.ConfigManager;

public final class HungerTweaksMod {
    public static final String ID = "hunger_tweaks";

    private static ConfigManager<Config> config = new ConfigManager<>
            ("hunger_tweaks", new Config())
            .builder()
            // .setDirectory(ID)
            .sanitize(true)
            .build();

    private static boolean initialized = false;
    public static Config getConfig() {
        if (!initialized) {
            config.refresh();
            initialized = true;
        }
        return config.value;
    }

    public static void init() {
    }
}
