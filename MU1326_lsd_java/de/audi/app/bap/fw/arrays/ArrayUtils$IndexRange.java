/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.ArrayUtils$1;

public class ArrayUtils$IndexRange {
    public int startIndex;
    public int endIndex;

    private ArrayUtils$IndexRange(int n, int n2) {
        this.startIndex = n;
        this.endIndex = n2;
    }

    public int getSize() {
        return this.endIndex - this.startIndex + 1;
    }

    /* synthetic */ ArrayUtils$IndexRange(int n, int n2, ArrayUtils$1 arrayUtils$1) {
        this(n, n2);
    }
}

