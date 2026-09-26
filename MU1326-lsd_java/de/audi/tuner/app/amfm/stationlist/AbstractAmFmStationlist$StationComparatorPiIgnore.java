/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$1;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$StationComparator;

class AbstractAmFmStationlist$StationComparatorPiIgnore
implements AbstractAmFmStationlist$StationComparator {
    private AbstractAmFmStationlist$StationComparatorPiIgnore() {
    }

    @Override
    public boolean equals(AMFMStation aMFMStation, AMFMStation aMFMStation2) {
        if (aMFMStation == null || aMFMStation2 == null) {
            return false;
        }
        return aMFMStation.frequency == aMFMStation2.frequency;
    }

    /* synthetic */ AbstractAmFmStationlist$StationComparatorPiIgnore(AbstractAmFmStationlist$1 abstractAmFmStationlist$1) {
        this();
    }
}

