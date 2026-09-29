/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$1;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;

class RecordSets$RecordSetNar
implements RecordSets$RecordSet {
    private RecordSets$RecordSetNar() {
    }

    @Override
    public int getFmRecordSet(AMFMStation aMFMStation) {
        if (aMFMStation.isHd()) {
            return 4;
        }
        return 5;
    }

    @Override
    public int getAmRecordSet(AMFMStation aMFMStation) {
        return 1;
    }

    @Override
    public void setNamesOnOff(boolean bl) {
    }

    /* synthetic */ RecordSets$RecordSetNar(RecordSets$1 recordSets$1) {
        this();
    }
}

