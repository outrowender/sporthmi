/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$1;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$DabComparator;

class DabFlatListHandler$PorscheComparator
implements DabFlatListHandler$DabComparator {
    private DabFlatListHandler$PorscheComparator() {
    }

    @Override
    public boolean equals(DabStation dabStation, DabStation dabStation2) {
        return RadioComparators.equals(dabStation, dabStation2);
    }

    /* synthetic */ DabFlatListHandler$PorscheComparator(DabFlatListHandler$1 dabFlatListHandler$1) {
        this();
    }
}

