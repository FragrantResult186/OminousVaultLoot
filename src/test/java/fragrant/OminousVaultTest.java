package fragrant;

import fragrant.trialchamber.loot.VaultLoot;
import fragrant.trialchamber.loot.LootGenerator;
import fragrant.trialchamber.loot.LootItem;

public class OminousVaultTest {
    public static void main(String[] args) {
        long worldSeed = 89397922071L;
        Xoroshiro xr = RandomSequence.initRNG(worldSeed);
        VaultLoot loot = LootGenerator.generateOminousVaultLoot(xr);

        for (LootItem item : loot.getItems()) {
            System.out.printf("%s *%d%n", item.name, item.amount);
        }
    }
}