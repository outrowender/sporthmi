/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.esolutions.fw.util.commons.Converter;
import java.util.Arrays;

class TopologyArray {
    private final int[] array;

    public TopologyArray(int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException("TopologyArray: array is null");
        }
        this.array = nArray;
    }

    int[] getArray() {
        return this.array;
    }

    public boolean equals(Object object) {
        return object instanceof TopologyArray && Arrays.equals(((TopologyArray)object).getArray(), this.array);
    }

    public int hashCode() {
        int n = 17;
        for (int i2 = 0; i2 < this.array.length; ++i2) {
            n = 31 * n + new Integer(this.array[i2]).hashCode();
        }
        return n;
    }

    public String toString() {
        return Converter.array2String(this.array);
    }
}

