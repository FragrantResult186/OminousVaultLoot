package fragrant.trialchamber.loot;

import fragrant.trialchamber.vault.VaultEntry;

public class OminousLootTables {
    static final VaultEntry[] OMINOUS_COMMON = {
            new VaultEntry("minecraft:emerald",        4, 10, 5, false),
            new VaultEntry("minecraft:wind_charge",    8, 12, 4, false),
            new VaultEntry("minecraft:tipped_arrow",   4, 12, 3, false),
            new VaultEntry("minecraft:diamond",        2,  3, 2, false),
            new VaultEntry("minecraft:ominous_bottle", 1,  1, 1, false)
    };

    static final VaultEntry[] OMINOUS_RARE = {
            new VaultEntry("minecraft:emerald_block",      1, 1, 5, false),
            new VaultEntry("minecraft:iron_block",         1, 1, 4, false),
            new VaultEntry("minecraft:crossbow",           1, 1, 4, false),
            new VaultEntry("minecraft:golden_apple",       1, 1, 3, false),
            new VaultEntry("minecraft:diamond_axe",        1, 1, 3, false),
            new VaultEntry("minecraft:diamond_chestplate", 1, 1, 3, false),
            new VaultEntry("minecraft:book",               1, 1, 2, false),
            new VaultEntry("minecraft:book",               1, 1, 2, false),
            new VaultEntry("minecraft:book",               1, 1, 2, false),
            new VaultEntry("minecraft:diamond_block",      1, 1, 1, false)
    };

    static final VaultEntry[] OMINOUS_UNIQUE = {
            new VaultEntry("minecraft:enchanted_golden_apple",            1, 1, 3, true),
            new VaultEntry("minecraft:flow_armor_trim_smithing_template", 1, 1, 3, true),
            new VaultEntry("minecraft:flow_banner_pattern",               1, 1, 2, true),
            new VaultEntry("minecraft:music_disc_creator",                1, 1, 1, true),
            new VaultEntry("minecraft:heavy_core",                        1, 1, 1, true)
    };

    static final int TOTAL_COMMON_WEIGHT = 15;
    static final int TOTAL_RARE_WEIGHT   = 29;
    static final int TOTAL_UNIQUE_WEIGHT = 10;
}