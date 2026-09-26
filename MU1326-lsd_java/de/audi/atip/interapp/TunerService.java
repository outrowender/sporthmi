/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.TunerService$TunerListEntry;
import de.audi.atip.interapp.TunerService$TunerSettingResult;

public interface TunerService
extends AbstractSDSApplicationService {
    public static final int WAVEBAND_NONE;
    public static final int WAVEBAND_FM;
    public static final int WAVEBAND_MW;
    public static final int WAVEBAND_LW;
    public static final int WAVEBAND_AM;
    public static final int WAVEBAND_DAB;
    public static final int WAVEBAND_DRM;
    public static final int WAVEBAND_SDARS;
    public static final int WAVEBAND_TI;
    public static final int WAVEBAND_COMMON;
    public static final int WAVEBAND_FAVORITES;
    public static final int WAVEBAND_HISTORY;
    public static final int WAVEBAND_ONLINE;
    public static final int WAVEBAND_TV;
    public static final int WAVEBAND_SIRIUS_SEEK;
    public static final byte SET_ERROR;
    public static final byte SET_SWITCH_NONE;
    public static final byte SET_SWITCH_FM;
    public static final byte SET_SWITCH_AM;
    public static final byte SET_SWITCH_DAB;
    public static final byte SET_SWITCH_SDARS;
    public static final byte SET_SWITCH_UNI;
    public static final byte SET_SDARS_GREYED_OUT;
    public static final byte SET_ENSEMBLE_SELECTED;
    public static final byte ROW_TYPE_RADIOSTATION;
    public static final byte ROW_TYPE_RADIOSTATION_DISABLED;
    public static final byte ROW_TYPE_DAB_ENSEMBLE;
    public static final byte WAVEBAND_SET_ERROR;
    public static final byte WAVEBAND_SET_OK;
    public static final byte WAVEBAND_SET_DISABLED;
    public static final byte RESULT_ERROR;
    public static final byte RESULT_OK;
    public static final byte RESULT_INVALID;
    public static final int MAX_COLS_TUNER_PICKLIST;
    public static final int INDEX_PICKLIST_ID;
    public static final int INDEX_PICKLIST_NAME;
    public static final byte HD_0;
    public static final byte HD_1;
    public static final byte HD_2;
    public static final byte HD_3;
    public static final byte HD_4;
    public static final byte HD_5;
    public static final byte HD_6;
    public static final byte HD_7;
    public static final byte HD_8;

    default public byte tuneFrequency(long l, byte by) {
    }

    default public TunerSettingResult tuneStationByID(long[] lArray) {
    }

    default public byte getTypeOfListRow(int n) {
    }

    default public byte tuneEnsembleByID(long l) {
    }

    default public byte selectWaveBand(int n) {
    }

    default public byte selectGenre(long l) {
    }

    default public void forceStationListUpdate() {
    }

    default public byte switchTrafficAnnouncements(boolean bl) {
    }

    default public void abortActiveTA() {
    }

    default public byte fillTunerPickList(TunerListEntry[] tunerListEntryArray) {
    }

    default public byte fillTunerPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public int getWavebandForID(long[] lArray) {
    }

    default public SDSListEntry getTunerPicklistEntry(int n) {
    }
}

