/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.amfm.stationlist.SortAlgoAlphabetically;
import java.io.Serializable;
import java.util.Comparator;
import org.dsi.ifc.radio.Station;

class SortAlgoSignal
extends SortAlgoAlphabetically
implements Comparator,
Serializable {
    private static final long serialVersionUID = 2964570796209432590L;

    SortAlgoSignal(LanguageManager languageManager) {
        super(languageManager);
    }

    public int compare(Object object, Object object2) {
        int n = ((Station)object).receptionQuality;
        int n2 = ((Station)object2).receptionQuality;
        if (n == n2) {
            return super.compare(object, object2);
        }
        return n2 - n;
    }
}

