/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.utils;

public class Integers {
    public static final int MAX_CACHE_VALUE = 127;
    public static final int MIN_CACHE_VALUE = -7;
    private static final Integer[] cache = new Integer[135];

    public static Integer valueOf(int n) {
        if (n < -7 || n > 127) {
            return new Integer(n);
        }
        return cache[n - -7];
    }

    static {
        for (int i2 = -7; i2 <= 127; ++i2) {
            Integers.cache[i2 - -7] = new Integer(i2);
        }
    }
}

