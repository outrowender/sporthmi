/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoAlphabetically;
import java.io.Serializable;

class RowSortAlgoAlphabetically
extends SortAlgoAlphabetically
implements Serializable {
    private static final long serialVersionUID = -4161228150083987695L;

    RowSortAlgoAlphabetically(LanguageManager languageManager) {
        super(languageManager);
    }

    public int compare(Object object, Object object2) {
        return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
    }
}

