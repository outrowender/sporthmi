/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;

public class RecordSets {
    private static final int RS_FM_RDS = 0;
    private static final int RS_FM_PIIGNORE = 1;
    private static final int RS_FM_FRQ = 3;
    private static final int RS_MPS = 4;
    private static final int RS_RDS_NAR = 5;
    private static final int RS_AM = 0;
    private static final int RS_AM_NAR = 1;
    private static final int RS_AM_WITHOUT_NAME = 2;
    private final RecordSet amfmRs;

    public RecordSets(TunerBasics tunerBasics) {
        this.amfmRs = Utilities.isPGen1OrBentley() ? (Utilities.isNARBuild() ? new RecordSetPorscheNar(tunerBasics.getStatus()) : new RecordSetPorscheEuRdw(tunerBasics.getStatus())) : (Utilities.isSinglePiMode() ? new RecordSetEuRdw() : (Utilities.isNARBuild() ? new RecordSetNar() : new RecordSetPiIgnore()));
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

    private static interface RecordSet {
        public int getFmRecordSet(AMFMStation var1);

        public int getAmRecordSet(AMFMStation var1);

        public void setNamesOnOff(boolean var1);
    }

    private static class RecordSetNar
    implements RecordSet {
        private RecordSetNar() {
        }

        public int getFmRecordSet(AMFMStation aMFMStation) {
            if (aMFMStation.isHd()) {
                return 4;
            }
            return 5;
        }

        public int getAmRecordSet(AMFMStation aMFMStation) {
            return 1;
        }

        public void setNamesOnOff(boolean bl) {
        }
    }

    private static class RecordSetEuRdw
    implements RecordSet {
        private RecordSetEuRdw() {
        }

        public int getFmRecordSet(AMFMStation aMFMStation) {
            if (Utilities.isEmpty(aMFMStation.name)) {
                return 3;
            }
            return 0;
        }

        public int getAmRecordSet(AMFMStation aMFMStation) {
            return 0;
        }

        public void setNamesOnOff(boolean bl) {
        }
    }

    private static class RecordSetPiIgnore
    implements RecordSet {
        int fmRs = 1;
        int amRs = 0;

        private RecordSetPiIgnore() {
        }

        public int getFmRecordSet(AMFMStation aMFMStation) {
            return this.fmRs;
        }

        public int getAmRecordSet(AMFMStation aMFMStation) {
            return this.amRs;
        }

        public void setNamesOnOff(boolean bl) {
            if (bl) {
                this.fmRs = 1;
                this.amRs = 0;
            } else {
                this.fmRs = 3;
                this.amRs = 2;
            }
        }
    }

    private static class RecordSetPorscheNar
    implements RecordSet {
        public RecordSetPorscheNar(TunerStatus tunerStatus) {
        }

        public int getFmRecordSet(AMFMStation aMFMStation) {
            if (aMFMStation.isHd()) {
                return 4;
            }
            return 3;
        }

        public int getAmRecordSet(AMFMStation aMFMStation) {
            return 1;
        }

        public void setNamesOnOff(boolean bl) {
        }
    }

    private static class RecordSetPorscheEuRdw
    implements RecordSet {
        private final TunerStatus status;

        public RecordSetPorscheEuRdw(TunerStatus tunerStatus) {
            this.status = tunerStatus;
        }

        public int getFmRecordSet(AMFMStation aMFMStation) {
            if (!this.status.isPorscheNameMode() || Utilities.isEmpty(aMFMStation.name)) {
                return 3;
            }
            return 0;
        }

        public int getAmRecordSet(AMFMStation aMFMStation) {
            return 0;
        }

        public void setNamesOnOff(boolean bl) {
        }
    }
}

