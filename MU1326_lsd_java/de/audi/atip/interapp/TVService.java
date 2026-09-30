/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;

public interface TVService
extends AbstractSDSApplicationService {
    public static final int SOURCE_NONE = 0;
    public static final int SOURCE_TV_STATION = 1;
    public static final int SOURCE_TV_FAVORITES = 2;
    public static final int SOURCE_AV = 3;
    public static final byte ROW_TYPE_TVSTATION = 0;
    public static final byte ROW_TYPE_TVSTATION_DISABLED = 1;
    public static final byte RESULT_ERROR = 0;
    public static final byte RESULT_OK = 1;
    public static final byte RESULT_INVALID = 2;
    public static final byte SOURCE_SET_ERROR = 0;
    public static final byte SOURCE_SET_OK = 1;
    public static final byte SOURCE_SET_DISABLED = 2;
    public static final byte SET_ERROR = 0;
    public static final byte SET_SWITCH_NONE = 1;
    public static final byte SET_SWITCH_TV_STATION = 2;
    public static final byte SET_SWITCH_TV_FAVORITES = 3;
    public static final int MAX_COLS_TUNER_PICKLIST = 2;
    public static final int INDEX_PICKLIST_ID = 0;
    public static final int INDEX_PICKLIST_NAME = 1;

    public TVSettingResult tuneStationByID(long var1);

    public byte getTypeOfListRow(int var1);

    public byte selectSource(int var1);

    public byte fillTvPickList(SDSListEntry[] var1);

    public SDSListEntry getTvPicklistEntry(int var1);

    public static class TVSettingResult {
        private final byte resultCode;
        private final long objectID;

        public TVSettingResult(byte by, long l) {
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

