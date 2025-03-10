package fragrant;

public class Xoroshiro {
    long lo, hi;

    long nextLong() {
        long l = lo;
        long h = hi;
        long n = Long.rotateLeft(l + h, 17) + l;
        h ^= l;
        lo = Long.rotateLeft(l, 49) ^ h ^ (h << 21);
        hi = Long.rotateLeft(h, 28);
        return n;
    }

    public int nextInt(int n) {
        long r = (nextLong() & 0xFFFFFFFFL) * n;
        long unsignedR = r & 0xFFFFFFFFL;

        if (unsignedR < (long) n) {
            long threshold = (0x100000000L - n) % n;
            while (unsignedR < threshold) {
                r = (nextLong() & 0xFFFFFFFFL) * n;
                unsignedR = r & 0xFFFFFFFFL;
            }
        }
        return (int) (r >>> 32);
    }

    public float nextFloat() {
        return (nextLong() >>> (64 - 24)) * 5.9604645E-8F;
    }
}