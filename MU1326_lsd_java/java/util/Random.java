/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;

public class Random
implements Serializable {
    private static final long serialVersionUID = 3905348978240129619L;
    static final long multiplier = 25214903917L;
    boolean haveNextNextGaussian = false;
    long seed;
    double nextNextGaussian = 0.0;

    public Random() {
        this.setSeed(System.currentTimeMillis());
    }

    public Random(long l) {
        this.setSeed(l);
    }

    protected synchronized int next(int n) {
        this.seed = this.seed * 25214903917L + 11L & 0xFFFFFFFFFFFFL;
        return (int)(this.seed >>> 48 - n);
    }

    public boolean nextBoolean() {
        return this.next(1) != 0;
    }

    public void nextBytes(byte[] byArray) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (n2 < byArray.length) {
            if (n3 == 0) {
                n = this.nextInt();
                n3 = 3;
            } else {
                --n3;
            }
            byArray[n2++] = (byte)n;
            n >>= 8;
        }
    }

    public double nextDouble() {
        return (double)(((long)this.next(26) << 27) + (long)this.next(27)) / 9.007199254740992E15;
    }

    public float nextFloat() {
        return (float)this.next(24) / 1.6777216E7f;
    }

    public synchronized double nextGaussian() {
        double d2;
        double d3;
        double d4;
        if (this.haveNextNextGaussian) {
            this.haveNextNextGaussian = false;
            return this.nextNextGaussian;
        }
        while ((d4 = (d3 = 2.0 * this.nextDouble() - 1.0) * d3 + (d2 = 2.0 * this.nextDouble() - 1.0) * d2) >= 1.0) {
        }
        double d5 = Math.sqrt(-2.0 * Math.log(d4) / d4);
        this.nextNextGaussian = d2 * d5;
        this.haveNextNextGaussian = true;
        return d3 * d5;
    }

    public int nextInt() {
        return this.next(32);
    }

    public int nextInt(int n) {
        if (n > 0) {
            int n2;
            int n3;
            if ((n & -n) == n) {
                return (int)((long)n * (long)this.next(31) >> 31);
            }
            while ((n3 = this.next(31)) - (n2 = n3 % n) + (n - 1) < 0) {
            }
            return n2;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong() {
        return ((long)this.next(32) << 32) + (long)this.next(32);
    }

    public synchronized void setSeed(long l) {
        this.seed = (l ^ 0x5DEECE66DL) & 0xFFFFFFFFFFFFL;
        this.haveNextNextGaussian = false;
    }
}

