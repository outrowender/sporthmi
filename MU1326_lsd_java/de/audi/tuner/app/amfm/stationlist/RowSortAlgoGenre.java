/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.SortAlgoAlphabetically;
import java.io.Serializable;
import java.util.Comparator;

class RowSortAlgoGenre
extends SortAlgoAlphabetically
implements Comparator,
Serializable {
    private static final long serialVersionUID = 4463002463855733570L;

    RowSortAlgoGenre(LanguageManager languageManager) {
        super(languageManager);
    }

    public int compare(Object object, Object object2) {
        int n = ((AbstractAmFmRow)object).getStation().ptyCode;
        int n2 = ((AbstractAmFmRow)object2).getStation().ptyCode;
        n = n == 0 ? 32 : n;
        int n3 = n2 = n2 == 0 ? 32 : n2;
        if (n == n2) {
            return super.compare(((AbstractAmFmRow)object).getStation(), ((AbstractAmFmRow)object2).getStation());
        }
        return n - n2;
    }
}

