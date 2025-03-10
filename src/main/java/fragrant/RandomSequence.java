package fragrant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RandomSequence {

    static byte[] md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return md.digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    static long bytesToLong(byte[] bytes, int offset) {
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value = (value << 8) | (bytes[offset + i] & 0xFF);
        }
        return value;
    }

    static long mixStafford13(long seed) {
        seed = (seed ^ (seed >>> 30)) * 0xBF58476D1CE4E5B9L;
        seed = (seed ^ (seed >>> 27)) * 0x94D049BB133111EBL;
        return seed ^ (seed >>> 31);
    }

    public static Xoroshiro initRNG(long worldSeed) {
        Xoroshiro xr = new Xoroshiro();
        long unmixedLow = worldSeed ^ 0x6A09E667F3BCC909L;
        long unmixedHi = unmixedLow - 7046029254386353131L;

        byte[] hash = md5("minecraft:chests/trial_chambers/reward_ominous");
        long identifierLow = bytesToLong(hash, 0);
        long identifierHi = bytesToLong(hash, 8);

        long splitLow = unmixedLow ^ identifierLow;
        long splitHi = unmixedHi ^ identifierHi;

        xr.lo = mixStafford13(splitLow);
        xr.hi = mixStafford13(splitHi);
        return xr;
    }
}