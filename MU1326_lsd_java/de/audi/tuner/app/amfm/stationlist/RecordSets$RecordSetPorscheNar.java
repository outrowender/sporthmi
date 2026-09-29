/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;

class RecordSets$RecordSetPorscheNar
implements RecordSets$RecordSet {
    public RecordSets$RecordSetPorscheNar(TunerStatus tunerStatus) {
    }

    @Override
    public int getFmRecordSet(AMFMStation aMFMStation) {
        if (aMFMStation.isHd()) {
            return 4;
        }
        return 3;
    }

    @Override
    public int getAmRecordSet(AMFMStation aMFMStation) {
        return 1;
    }

    @Override
    public void setNamesOnOff(boolean bl) {
    }
}

