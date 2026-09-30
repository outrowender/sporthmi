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
    private static final long serialVersionUID = 5047972729998582106L;

    RowSortAlgoFrequency() {
    }

    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

