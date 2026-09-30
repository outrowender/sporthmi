/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.sds.UpdateListenerHandler;

public abstract class AbstractDABListHandler
extends UpdateListenerHandler {
    public static final int SORTMODE_ALPHABETICALLY = 0;
    public static final int SORTMODE_ENSEMBLE = 1;
    static final int SORTMODE_GENRE = 2;
    protected static final int REASON_NONE = 0;
    protected static final int REASON_ENSEMBLECHANGE = 1;
    protected static final int REASON_SERVICECHANGE = 2;
    protected static final int REASON_COMPONENTCHANGE = 3;
    protected static final int REASON_PROGRAM_CHANGED = 4;

    public abstract DabStation getCurrentStation();

    protected abstract void highlightItem(DabStation var1, DabReceptionStatus var2);

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

