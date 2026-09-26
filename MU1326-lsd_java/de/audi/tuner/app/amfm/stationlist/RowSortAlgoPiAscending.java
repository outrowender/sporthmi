/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoPiAscending;
import java.io.Serializable;

class RowSortAlgoPiAscending
extends SortAlgoPiAscending
implements Serializable {
    private static final long serialVersionUID;

    RowSortAlgoPiAscending() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

