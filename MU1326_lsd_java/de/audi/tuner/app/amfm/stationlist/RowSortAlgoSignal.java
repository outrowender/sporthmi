/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoSignal;
import java.io.Serializable;

class RowSortAlgoSignal
extends SortAlgoSignal
implements Serializable {
    private static final long serialVersionUID = 2403559729305228309L;

    RowSortAlgoSignal(LanguageManager languageManager) {
        super(languageManager);
    }

    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

