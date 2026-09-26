/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import java.util.Comparator;

class SearchGUI$ListComparator
implements Comparator {
    private static final int[] order = new int[]{12, 13, 11, 5, 7, 1, 4};
    private int activeList;

    public SearchGUI$ListComparator(int n) {
        this.activeList = n;
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = this.getIndex(object);
        int n2 = this.getIndex(object2);
        return n - n2;
    }

    private int getIndex(Object object) {
        int n = (Integer)object;
        if (n == this.activeList) {
            return -10;
        }
        for (int i2 = 0; i2 < order.length; ++i2) {
            if (order[i2] != n) continue;
            return i2;
        }
        return -1;
    }
}

