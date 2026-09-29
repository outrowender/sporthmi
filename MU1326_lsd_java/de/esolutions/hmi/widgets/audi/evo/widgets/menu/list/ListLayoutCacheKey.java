/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import java.util.Arrays;

public class ListLayoutCacheKey {
    private final int[] values;

    public ListLayoutCacheKey(int[] nArray) {
        this.values = nArray;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ListLayoutCacheKey)) {
            return false;
        }
        ListLayoutCacheKey listLayoutCacheKey = (ListLayoutCacheKey)object;
        return Arrays.equals(this.values, listLayoutCacheKey.values);
    }

    public int hashCode() {
        if (this.values == null) {
            return 0;
        }
        int n = 17;
        for (int i2 = 0; i2 < this.values.length; ++i2) {
            n = 31 * n + this.values[i2];
        }
        return n;
    }
}

