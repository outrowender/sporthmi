/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.dab.DabStation;
import java.util.Comparator;

public class ComparatorFlatList
implements Comparator {
    private final LanguageManager langMngr;

    public ComparatorFlatList(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        DabStation dabStation = (DabStation)object;
        DabStation dabStation2 = (DabStation)object2;
        String string = "";
        String string2 = "";
        if (dabStation.getType() == 2) {
            string = dabStation.service.getFullName();
        } else if (dabStation.getType() == 3) {
            string = dabStation.component.getFullName();
        }
        if (dabStation2.getType() == 2) {
            string2 = dabStation2.service.getFullName();
        } else if (dabStation2.getType() == 3) {
            string2 = dabStation2.component.getFullName();
        }
        return this.langMngr.getCollator().compare(string, string2);
    }
}

