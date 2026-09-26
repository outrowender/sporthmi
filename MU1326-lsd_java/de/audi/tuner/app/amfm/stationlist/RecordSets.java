/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSet;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSetEuRdw;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSetNar;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSetPiIgnore;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSetPorscheEuRdw;
import de.audi.tuner.app.amfm.stationlist.RecordSets$RecordSetPorscheNar;

public class RecordSets {
    private static final int RS_FM_RDS;
    private static final int RS_FM_PIIGNORE;
    private static final int RS_FM_FRQ;
    private static final int RS_MPS;
    private static final int RS_RDS_NAR;
    private static final int RS_AM;
    private static final int RS_AM_NAR;
    private static final int RS_AM_WITHOUT_NAME;
    private final RecordSets$RecordSet amfmRs;

    public RecordSets(TunerBasics tunerBasics) {
        this.amfmRs = Utilities.isPGen1OrBentley() ? (Utilities.isNARBuild() ? new RecordSets$RecordSetPorscheNar(tunerBasics.getStatus()) : new RecordSets$RecordSetPorscheEuRdw(tunerBasics.getStatus())) : (Utilities.isSinglePiMode() ? new RecordSets$RecordSetEuRdw(null) : (Utilities.isNARBuild() ? new RecordSets$RecordSetNar(null) : new RecordSets$RecordSetPiIgnore(null)));
    }

    int getFMRecordSet(AMFMStation aMFMStation) {
        return this.amfmRs.getFmRecordSet(aMFMStation);
    }

    public int getAMRecordSet(AMFMStation aMFMStation) {
        return this.amfmRs.getAmRecordSet(aMFMStation);
    }

    public void setNamesOnOff(boolean bl) {
        this.amfmRs.setNamesOnOff(bl);
    }
}

