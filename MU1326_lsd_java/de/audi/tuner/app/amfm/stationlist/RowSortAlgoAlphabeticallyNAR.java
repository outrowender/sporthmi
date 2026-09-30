/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoAlphabeticallyNAR;
import java.io.Serializable;

class RowSortAlgoAlphabeticallyNAR
extends SortAlgoAlphabeticallyNAR
implements Serializable {
    private static final long serialVersionUID = -4161228150083987695L;

    RowSortAlgoAlphabeticallyNAR(LanguageManager languageManager) {
        super(languageManager);
    }

    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

