/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController$1;
import java.util.Comparator;

final class MultilineTextFieldController$IntArrCompare
implements Comparator {
    private MultilineTextFieldController$IntArrCompare() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int compare(Object object, Object object2) {
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return 1;
        }
        if (object2 == null) {
            return -1;
        }
        if (object instanceof int[] && object2 instanceof int[]) {
            int[] nArray = (int[])object;
            int[] nArray2 = (int[])object2;
            if (nArray.length == nArray2.length) {
                int n = 0;
                while (n < nArray.length) {
                    if (nArray[n] != nArray2[n]) {
                        if (nArray[n] >= nArray2[n]) return 1;
                        return -1;
                    }
                    ++n;
                }
                return 0;
            }
            if (nArray.length >= nArray2.length) return 1;
            return -1;
        }
        if (!object.equals(object2)) return -1;
        return 0;
    }

    /* synthetic */ MultilineTextFieldController$IntArrCompare(MultilineTextFieldController$1 multilineTextFieldController$1) {
        this();
    }
}

