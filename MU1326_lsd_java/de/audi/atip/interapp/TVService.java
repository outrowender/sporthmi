/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TVService$TVSettingResult;

public interface TVService
extends AbstractSDSApplicationService {
    public static final int SOURCE_NONE;
    public static final int SOURCE_TV_STATION;
    public static final int SOURCE_TV_FAVORITES;
    public static final int SOURCE_AV;
    public static final byte ROW_TYPE_TVSTATION;
    public static final byte ROW_TYPE_TVSTATION_DISABLED;
    public static final byte RESULT_ERROR;
    public static final byte RESULT_OK;
    public static final byte RESULT_INVALID;
    public static final byte SOURCE_SET_ERROR;
    public static final byte SOURCE_SET_OK;
    public static final byte SOURCE_SET_DISABLED;
    public static final byte SET_ERROR;
    public static final byte SET_SWITCH_NONE;
    public static final byte SET_SWITCH_TV_STATION;
    public static final byte SET_SWITCH_TV_FAVORITES;
    public static final int MAX_COLS_TUNER_PICKLIST;
    public static final int INDEX_PICKLIST_ID;
    public static final int INDEX_PICKLIST_NAME;

    default public TVSettingResult tuneStationByID(long l) {
    }

    default public byte getTypeOfListRow(int n) {
    }

    default public byte selectSource(int n) {
    }

    default public byte fillTvPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public SDSListEntry getTvPicklistEntry(int n) {
    }
}

