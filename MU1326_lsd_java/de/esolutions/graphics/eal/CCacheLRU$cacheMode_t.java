/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.CCacheLRU;

public final class CCacheLRU$cacheMode_t {
    public static final CCacheLRU$cacheMode_t CACHE_MODE_DURATION = new CCacheLRU$cacheMode_t("CACHE_MODE_DURATION");
    public static final CCacheLRU$cacheMode_t CACHE_MODE_AMOUNT = new CCacheLRU$cacheMode_t("CACHE_MODE_AMOUNT");
    public static final CCacheLRU$cacheMode_t CACHE_MODE_SIZE = new CCacheLRU$cacheMode_t("CACHE_MODE_SIZE");
    private static CCacheLRU$cacheMode_t[] swigValues = new CCacheLRU$cacheMode_t[]{CACHE_MODE_DURATION, CACHE_MODE_AMOUNT, CACHE_MODE_SIZE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static CCacheLRU$cacheMode_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && CCacheLRU$cacheMode_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (CCacheLRU$cacheMode_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(CCacheLRU.class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t == null ? (CCacheLRU.class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t = CCacheLRU.class$("de.esolutions.graphics.eal.CCacheLRU$cacheMode_t")) : CCacheLRU.class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t).append(" with value ").append(n).toString());
    }

    private CCacheLRU$cacheMode_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private CCacheLRU$cacheMode_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private CCacheLRU$cacheMode_t(String string, CCacheLRU$cacheMode_t cCacheLRU$cacheMode_t) {
        this.swigName = string;
        this.swigValue = cCacheLRU$cacheMode_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

