/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import java.util.Comparator;

public class WidgetPersistenceComparator
implements Comparator {
    public int compare(Object object, Object object2) {
        if (object == null && object2 == null) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        int[] nArray = (int[])object;
        int[] nArray2 = (int[])object2;
        int n = nArray.length < nArray2.length ? nArray.length : nArray2.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (nArray[i2] < nArray2[i2]) {
                return -1;
            }
            if (nArray[i2] <= nArray2[i2]) continue;
            return 1;
        }
        if (nArray.length < nArray2.length) {
            return -1;
        }
        if (nArray.length > nArray2.length) {
            return 1;
        }
        return 0;
    }
}

