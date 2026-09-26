/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$1;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;

class RecordSets$RecordSetPiIgnore
implements RecordSets$RecordSet {
    int fmRs = 1;
    int amRs = 0;

    private RecordSets$RecordSetPiIgnore() {
    }

    @Override
    public int getFmRecordSet(AMFMStation aMFMStation) {
        return this.fmRs;
    }

    @Override
    public int getAmRecordSet(AMFMStation aMFMStation) {
        return this.amRs;
    }

    @Override
    public void setNamesOnOff(boolean bl) {
        if (bl) {
            this.fmRs = 1;
            this.amRs = 0;
        } else {
            this.fmRs = 3;
            this.amRs = 2;
        }
    }

    /* synthetic */ RecordSets$RecordSetPiIgnore(RecordSets$1 recordSets$1) {
        this();
    }
}

