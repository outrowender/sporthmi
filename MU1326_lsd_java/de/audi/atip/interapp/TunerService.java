/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.esolutions.fw.util.commons.Buffer;

public interface TunerService
extends AbstractSDSApplicationService {
    public static final int WAVEBAND_NONE = 0;
    public static final int WAVEBAND_FM = 1;
    public static final int WAVEBAND_MW = 2;
    public static final int WAVEBAND_LW = 3;
    public static final int WAVEBAND_AM = 4;
    public static final int WAVEBAND_DAB = 5;
    public static final int WAVEBAND_DRM = 6;
    public static final int WAVEBAND_SDARS = 7;
    public static final int WAVEBAND_TI = 8;
    public static final int WAVEBAND_COMMON = 9;
    public static final int WAVEBAND_FAVORITES = 10;
    public static final int WAVEBAND_HISTORY = 11;
    public static final int WAVEBAND_ONLINE = 12;
    public static final int WAVEBAND_TV = 13;
    public static final int WAVEBAND_SIRIUS_SEEK = 14;
    public static final byte SET_ERROR = 0;
    public static final byte SET_SWITCH_NONE = 1;
    public static final byte SET_SWITCH_FM = 2;
    public static final byte SET_SWITCH_AM = 3;
    public static final byte SET_SWITCH_DAB = 4;
    public static final byte SET_SWITCH_SDARS = 5;
    public static final byte SET_SWITCH_UNI = 6;
    public static final byte SET_SDARS_GREYED_OUT = 7;
    public static final byte SET_ENSEMBLE_SELECTED = 8;
    public static final byte ROW_TYPE_RADIOSTATION = 0;
    public static final byte ROW_TYPE_RADIOSTATION_DISABLED = 1;
    public static final byte ROW_TYPE_DAB_ENSEMBLE = 2;
    public static final byte WAVEBAND_SET_ERROR = 0;
    public static final byte WAVEBAND_SET_OK = 1;
    public static final byte WAVEBAND_SET_DISABLED = 2;
    public static final byte RESULT_ERROR = 0;
    public static final byte RESULT_OK = 1;
    public static final byte RESULT_INVALID = 2;
    public static final int MAX_COLS_TUNER_PICKLIST = 2;
    public static final int INDEX_PICKLIST_ID = 0;
    public static final int INDEX_PICKLIST_NAME = 1;
    public static final byte HD_0 = 0;
    public static final byte HD_1 = 1;
    public static final byte HD_2 = 2;
    public static final byte HD_3 = 3;
    public static final byte HD_4 = 4;
    public static final byte HD_5 = 5;
    public static final byte HD_6 = 6;
    public static final byte HD_7 = 7;
    public static final byte HD_8 = 8;

    public byte tuneFrequency(long var1, byte var3);

    public TunerSettingResult tuneStationByID(long[] var1);

    public byte getTypeOfListRow(int var1);

    public byte tuneEnsembleByID(long var1);

    public byte selectWaveBand(int var1);

    public byte selectGenre(long var1);

    public void forceStationListUpdate();

    public byte switchTrafficAnnouncements(boolean var1);

    public void abortActiveTA();

    public byte fillTunerPickList(TunerListEntry[] var1);

    public byte fillTunerPickList(SDSListEntry[] var1);

    public int getWavebandForID(long[] var1);

    public SDSListEntry getTunerPicklistEntry(int var1);

    public static class TunerStation {
        public final long stationID;
        public final String stationName;

        public TunerStation(long l, String string) {
            this.stationID = l;
            this.stationName = string;
        }

        public final String toString() {
            return this.stationName + " (" + this.stationID + ")";
        }

        public long getStationId() {
            return this.stationID;
        }
    }

    public static class TunerListEntry {
        public final SDSListEntry[] entryVariants;

        public TunerListEntry(SDSListEntry[] sDSListEntryArray) {
            this.entryVariants = sDSListEntryArray;
        }

        public String toString() {
            if (this.entryVariants == null) {
                return "entryVariants=[ ]";
            }
            int n = this.entryVariants.length;
            Buffer buffer = new Buffer("entryVariants=[ ");
            for (int i2 = 0; i2 < n - 1; ++i2) {
                buffer.append(this.entryVariants[i2]).append(", ");
            }
            buffer.append(this.entryVariants[n - 1]).append(" ]");
            return buffer.toString();
        }

        public long[] getEntryVariantIds() {
            int n = this.entryVariants.length;
            long[] lArray = new long[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = this.entryVariants[i2].getId();
            }
            return lArray;
        }

        public String getNameOfEntryVariant(int n) {
            int n2 = this.entryVariants.length;
            if (n >= n2) {
                return "";
            }
            return this.entryVariants[n].getName();
        }

        public String getName() {
            return this.entryVariants[0].getName();
        }
    }

    public static class TunerSettingResult {
        private final byte resultCode;
        private final long objectID;

        public TunerSettingResult(byte by, long l) {
            this.resultCode = by;
            this.objectID = l;
        }

        public byte getResultCode() {
            return this.resultCode;
        }

        public long getObjectID() {
            return this.objectID;
        }

        public String toString() {
            return "resultCode=" + this.resultCode + ", objectID=" + this.objectID;
        }
    }
}

