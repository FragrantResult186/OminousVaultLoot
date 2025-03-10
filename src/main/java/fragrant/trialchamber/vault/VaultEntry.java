package fragrant.trialchamber.vault;

public class VaultEntry {
    public String name;
    public int minAmount;
    public int maxAmount;
    public int weight;
    boolean unique;

    public VaultEntry(String name, int min, int max, int weight, boolean unique) {
        this.name = name;
        this.minAmount = min;
        this.maxAmount = max;
        this.weight = weight;
        this.unique = unique;
    }
}