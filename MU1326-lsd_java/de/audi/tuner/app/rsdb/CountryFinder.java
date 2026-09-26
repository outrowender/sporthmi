/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class CountryFinder {
    private SimpleIntIntMap map = new SimpleIntIntMap(10);

    public void add(int n) {
        int n2 = this.map.get(n);
        this.map.add(n, n2 == -1 ? 1 : n2 + 1);
    }

    public int getCountry() {
        int[] nArray = this.map.getKeys();
        int[] nArray2 = this.map.getValues();
        int n = -1;
        int n2 = 0;
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            if (nArray2[i2] <= n2) continue;
            n2 = nArray2[i2];
            n = i2;
        }
        if (n2 > 1) {
            return nArray[n];
        }
        return 1;
    }

    public String dump() {
        Buffer buffer = new Buffer(200);
        int[] nArray = this.map.getKeys();
        int[] nArray2 = this.map.getValues();
        for (int i2 = 0; i2 < nArray2.length; ++i2) {
            buffer.append(nArray[i2]).append(" #").append(nArray2[i2]).append('\n');
        }
        buffer.append("result ").append(this.getCountry());
        return buffer.toString();
    }

    public String toString() {
        return this.dump();
    }
}

