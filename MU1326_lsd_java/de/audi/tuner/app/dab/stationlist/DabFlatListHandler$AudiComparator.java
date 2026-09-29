/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$1;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$DabComparator;

class DabFlatListHandler$AudiComparator
implements DabFlatListHandler$DabComparator {
    private DabFlatListHandler$AudiComparator() {
    }

    @Override
    public boolean equals(DabStation dabStation, DabStation dabStation2) {
        if (dabStation == null || dabStation2 == null) {
            return false;
        }
        if (dabStation.isService() && dabStation2.isService()) {
            return dabStation.service.sID == dabStation2.service.sID;
        }
        return RadioComparators.equals(dabStation, dabStation2);
    }

    /* synthetic */ DabFlatListHandler$AudiComparator(DabFlatListHandler$1 dabFlatListHandler$1) {
        this();
    }
}

