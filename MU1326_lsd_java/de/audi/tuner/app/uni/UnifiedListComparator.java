/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UnifiedStationExt;
import java.util.Comparator;

class UnifiedListComparator
implements Comparator {
    private final LanguageManager langMngr;
    private final UniStationList.CompServiceLookup compServiceLookup;

    UnifiedListComparator(LanguageManager languageManager, UniStationList.CompServiceLookup compServiceLookup) {
        this.langMngr = languageManager;
        this.compServiceLookup = compServiceLookup;
    }

    public int compare(Object object, Object object2) {
        String string;
        UnifiedStationExt unifiedStationExt = ((UniListRow)object).getStation();
        UnifiedStationExt unifiedStationExt2 = ((UniListRow)object2).getStation();
        String string2 = Utilities.isEmpty(unifiedStationExt.longName) ? unifiedStationExt.shortName : unifiedStationExt.longName;
        String string3 = string = Utilities.isEmpty(unifiedStationExt2.longName) ? unifiedStationExt2.shortName : unifiedStationExt2.longName;
        if (!Utilities.isEmpty(string2) && !Utilities.isEmpty(string)) {
            return this.compareByRDS(unifiedStationExt, unifiedStationExt2);
        }
        if (!Utilities.isEmpty(string2) && Utilities.isEmpty(string)) {
            return -1;
        }
        if (!Utilities.isEmpty(string) && Utilities.isEmpty(string2)) {
            return 1;
        }
        return (int)(unifiedStationExt.frequency - unifiedStationExt2.frequency);
    }

    private int compareByRDS(UnifiedStationExt unifiedStationExt, UnifiedStationExt unifiedStationExt2) {
        if (unifiedStationExt.isScroller() && unifiedStationExt2.isScroller()) {
            int n = Utilities.convertPi(unifiedStationExt.piSId);
            int n2 = Utilities.convertPi(unifiedStationExt2.piSId);
            return n - n2;
        }
        if (unifiedStationExt.isScroller() && !unifiedStationExt2.isScroller()) {
            return 1;
        }
        if (unifiedStationExt2.isScroller() && !unifiedStationExt.isScroller()) {
            return -1;
        }
        String string = unifiedStationExt.getName(true);
        String string2 = unifiedStationExt2.getName(true);
        int n = this.langMngr.getCollator().compare(string, string2);
        if (unifiedStationExt.piSId == unifiedStationExt2.piSId) {
            if (unifiedStationExt.isComponent() && unifiedStationExt2.isComponent()) {
                if (n != 0) {
                    return n;
                }
                return unifiedStationExt.sCIDI - unifiedStationExt2.sCIDI;
            }
            if (unifiedStationExt.isComponent()) {
                return 1;
            }
            if (unifiedStationExt2.isComponent()) {
                return -1;
            }
        }
        if (unifiedStationExt.isComponent() || unifiedStationExt2.isComponent()) {
            if (unifiedStationExt.isComponent()) {
                string = this.compServiceLookup.getServiceName(unifiedStationExt.piSId);
            }
            if (unifiedStationExt2.isComponent()) {
                string2 = this.compServiceLookup.getServiceName(unifiedStationExt2.piSId);
            }
            n = this.langMngr.getCollator().compare(string, string2);
        }
        if (n != 0) {
            return n;
        }
        int n3 = unifiedStationExt.piSId - unifiedStationExt2.piSId;
        if (n3 != 0) {
            return n3;
        }
        return (int)(unifiedStationExt.frequency - unifiedStationExt2.frequency);
    }
}

