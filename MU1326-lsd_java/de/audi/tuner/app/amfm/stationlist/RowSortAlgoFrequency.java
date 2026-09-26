/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoFrequency;
import java.io.Serializable;

class RowSortAlgoFrequency
extends SortAlgoFrequency
implements Serializable {
    private static final long serialVersionUID;

    RowSortAlgoFrequency() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

