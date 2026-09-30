/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import java.io.Serializable;
import java.util.Comparator;

class SortAlgoAlphabetically
implements Comparator,
Serializable {
    private static final long serialVersionUID = -8533894628268879084L;
    private final transient LanguageManager langMngr;

    public SortAlgoAlphabetically(LanguageManager languageManager) {
        this.langMngr = languageManager;
    }

    public int compare(Object object, Object object2) {
        AMFMStation aMFMStation = (AMFMStation)object;
        AMFMStation aMFMStation2 = (AMFMStation)object2;
        if (!Utilities.isEmpty(aMFMStation.name) && !Utilities.isEmpty(aMFMStation2.name)) {
            return this.compareByRDS(aMFMStation, aMFMStation2);
        }
        if (!Utilities.isEmpty(aMFMStation.name)) {
            return -1;
        }
        if (!Utilities.isEmpty(aMFMStation2.name)) {
            return 1;
        }
        return (int)(aMFMStation.frequency - aMFMStation2.frequency);
    }

    private int compareByRDS(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation.isScroller() && aMFMStation2.isScroller()) {
            int n = Utilities.convertPi(aMFMStation.pi);
            int n2 = Utilities.convertPi(aMFMStation2.pi);
            return n - n2;
        }
        if (aMFMStation.isScroller()) {
            return 1;
        }
        if (aMFMStation2.isScroller()) {
            return -1;
        }
        int n = this.langMngr.getCollator().compare(aMFMStation.name, aMFMStation2.name);
        if (n != 0) {
            return n;
        }
        int n3 = aMFMStation.pi - aMFMStation2.pi;
        if (n3 != 0) {
            return n3;
        }
        return (int)(aMFMStation.frequency - aMFMStation2.frequency);
    }
}

