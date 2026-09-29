/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.store;

import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class ConnectionMap {
    private static final int KEY_OFFSET;
    private final SimpleIntIntMap map = new SimpleIntIntMap(100);
    private final int defaultStatus;

    ConnectionMap(int n) {
        this.defaultStatus = n;
    }

    void addStatus(int n, int n2, int n3) {
        int n4 = this.createKey(n, n2);
        if (n3 == this.defaultStatus) {
            this.map.remove(n4);
        } else {
            this.map.add(n4, n3);
        }
    }

    int getStatus(int n, int n2) {
        int n3 = this.createKey(n, n2);
        int n4 = this.map.get(n3);
        if (n4 == -1) {
            n4 = this.defaultStatus;
        }
        return n4;
    }

    void clear() {
        this.map.clear();
    }

    int[] getConnections(int n) {
        int[] nArray = this.map.getKeys();
        IntList intList = new IntList(nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = this.getTerminal(nArray[i2]);
            if (n2 != n) continue;
            intList.add(this.getConnection(nArray[i2]));
        }
        return intList.toArray();
    }

    private int createKey(int n, int n2) {
        return n * 100 + n2;
    }

    private int getTerminal(int n) {
        return n % 100;
    }

    private int getConnection(int n) {
        return n / 100;
    }
}

