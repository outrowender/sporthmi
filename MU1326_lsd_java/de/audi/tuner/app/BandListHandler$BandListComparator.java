/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.BandListHandler$1;
import java.io.Serializable;
import java.util.Comparator;

class BandListHandler$BandListComparator
implements Comparator,
Serializable {
    private static final long serialVersionUID;
    private static final int[] order;

    private BandListHandler$BandListComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = this.getIndex(object);
        int n2 = this.getIndex(object2);
        return n - n2;
    }

    private int getIndex(Object object) {
        for (int i2 = 0; i2 < order.length; ++i2) {
            if (order[i2] != (Integer)object) continue;
            return i2;
        }
        return -1;
    }

    /* synthetic */ BandListHandler$BandListComparator(BandListHandler$1 bandListHandler$1) {
        this();
    }

    static {
        order = new int[]{12, 13, 11, 5, 1, 4, 7};
    }
}

