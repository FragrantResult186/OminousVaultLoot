package fragrant.trialchamber.loot;

import fragrant.Xoroshiro;
import fragrant.trialchamber.vault.VaultEntry;

public class LootGenerator {
    static int rollOminousBottleAmplifier(Xoroshiro xr) {
        return 3 + xr.nextInt(3);
    }

    static int rollEnchantLevel(Xoroshiro xr, int min, int max) {
        return min + xr.nextInt(max - min + 1);
    }

    static String getRandomEnchantment1(Xoroshiro xr) {
        String[] enchants = {"knockback", "punch", "smite", "looting", "multishot"};
        return enchants[xr.nextInt(5)];
    }

    static String getRandomEnchantment2(Xoroshiro xr) {
        String[] enchants = {"breach", "density"};
        return enchants[xr.nextInt(2)];
    }

    static LootItem rollEntry(VaultEntry entry, Xoroshiro xr) {
        LootItem item = new LootItem(entry.name, entry.minAmount);

        if (entry.maxAmount > entry.minAmount) {
            item.amount += xr.nextInt(entry.maxAmount - entry.minAmount + 1);
        }

        if (entry.name.equals("minecraft:ominous_bottle")) {
            int amplifier = rollOminousBottleAmplifier(xr);
            item.name = String.format("%s (Amplifier %d)", item.name, amplifier);

        } else if (entry.name.equals("minecraft:crossbow")) {
            int level = rollEnchantLevel(xr, 5, 20);
            item.name = String.format("%s (Enchanted L%d)", item.name, level);

        } else if (entry.name.equals("minecraft:diamond_axe") || entry.name.equals("minecraft:diamond_chestplate")) {
            int level = rollEnchantLevel(xr, 10, 20);
            item.name = String.format("%s (Enchanted L%d)", item.name, level);

        } else if (entry.name.equals("minecraft:book")) {
            if (entry == OminousLootTables.OMINOUS_RARE[6]) {
                item.name = String.format("%s (%s)", item.name, getRandomEnchantment1(xr));
            } else if (entry == OminousLootTables.OMINOUS_RARE[7]) {
                item.name = String.format("%s (%s)", item.name, getRandomEnchantment2(xr));
            } else if (entry == OminousLootTables.OMINOUS_RARE[8]) {
                item.name = String.format("%s (wind_burst 1)", item.name);
            }
        }

        return item;
    }

    static VaultEntry selectEntry(VaultEntry[] entries, int entryCount, int totalWeight, Xoroshiro xr) {
        int weight = xr.nextInt(totalWeight);
        for (int i = 0; i < entryCount; i++) {
            weight -= entries[i].weight;
            if (weight < 0) {
                return entries[i];
            }
        }
        return null;
    }

    public static VaultLoot generateOminousVaultLoot(Xoroshiro xr) {
        VaultLoot loot = new VaultLoot();

        if (xr.nextInt(10) < 8) {
            VaultEntry entry = selectEntry(OminousLootTables.OMINOUS_RARE, OminousLootTables.OMINOUS_RARE.length, OminousLootTables.TOTAL_RARE_WEIGHT, xr);
            loot.getItems().add(rollEntry(entry, xr));
        } else {
            VaultEntry entry = selectEntry(OminousLootTables.OMINOUS_COMMON, OminousLootTables.OMINOUS_COMMON.length, OminousLootTables.TOTAL_COMMON_WEIGHT, xr);
            loot.getItems().add(rollEntry(entry, xr));
        }

        int commonRolls = 1 + xr.nextInt(3);
        for (int i = 0; i < commonRolls; i++) {
            VaultEntry entry = selectEntry(OminousLootTables.OMINOUS_COMMON, OminousLootTables.OMINOUS_COMMON.length, OminousLootTables.TOTAL_COMMON_WEIGHT, xr);
            loot.getItems().add(rollEntry(entry, xr));
        }

        if (xr.nextFloat() < 0.75f) {
            VaultEntry entry = selectEntry(OminousLootTables.OMINOUS_UNIQUE, OminousLootTables.OMINOUS_UNIQUE.length, OminousLootTables.TOTAL_UNIQUE_WEIGHT, xr);
            loot.getItems().add(rollEntry(entry, xr));
        }

        return loot;
    }
}