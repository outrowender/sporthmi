/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.sds.UpdateListenerHandler;

public abstract class AbstractDABListHandler
extends UpdateListenerHandler {
    public static final int SORTMODE_ALPHABETICALLY;
    public static final int SORTMODE_ENSEMBLE;
    static final int SORTMODE_GENRE;
    protected static final int REASON_NONE;
    protected static final int REASON_ENSEMBLECHANGE;
    protected static final int REASON_SERVICECHANGE;
    protected static final int REASON_COMPONENTCHANGE;
    protected static final int REASON_PROGRAM_CHANGED;

    public abstract DabStation getCurrentStation() {
    }

    protected abstract void highlightItem(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
    }

    protected int getNextListIndex(boolean bl, int n, int n2) {
        int n3 = n2;
        if (bl) {
            if (n2 >= n - 1) {
                n3 = -1;
            }
            ++n3;
        } else {
            if (n2 == 0) {
                n3 = n;
            }
            --n3;
        }
        return n3;
    }
}

