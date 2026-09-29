/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$1;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;

class RecordSets$RecordSetEuRdw
implements RecordSets$RecordSet {
    private RecordSets$RecordSetEuRdw() {
    }

    @Override
    public int getFmRecordSet(AMFMStation aMFMStation) {
        if (Utilities.isEmpty(aMFMStation.name)) {
            return 3;
        }
        return 0;
    }

    @Override
    public int getAmRecordSet(AMFMStation aMFMStation) {
        return 0;
    }

    @Override
    public void setNamesOnOff(boolean bl) {
    }

    /* synthetic */ RecordSets$RecordSetEuRdw(RecordSets$1 recordSets$1) {
        this();
    }
}

