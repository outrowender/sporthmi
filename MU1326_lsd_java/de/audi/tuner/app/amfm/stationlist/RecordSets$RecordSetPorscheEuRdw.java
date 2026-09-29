/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;

class RecordSets$RecordSetPorscheEuRdw
implements RecordSets$RecordSet {
    private final TunerStatus status;

    public RecordSets$RecordSetPorscheEuRdw(TunerStatus tunerStatus) {
        this.status = tunerStatus;
    }

    @Override
    public int getFmRecordSet(AMFMStation aMFMStation) {
        if (!this.status.isPorscheNameMode() || Utilities.isEmpty(aMFMStation.name)) {
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
}

