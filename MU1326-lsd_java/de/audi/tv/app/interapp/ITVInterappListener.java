/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.interapp.ITVInterappListener$ActiveStationInfo;
import de.audi.tv.app.interapp.ITVInterappListener$ServiceInfo;
import de.audi.tv.app.interapp.ITVInterappListener$TvState;
import de.audi.tv.app.interapp.ITVInterappListener$TvTunerConfig;

public interface ITVInterappListener {
    public static final int TV_STATION_FLAG_UNAVAILABLE;
    public static final int TV_STATION_FLAG_LOADING;
    public static final int TV_STATION_FLAG_AVAILABLE;
    public static final int TV_STATE_MUTE_OK;
    public static final int TV_STATE_MUTE_DROP_OUT;
    public static final int TV_STATE_MUTE_NO_RECEPTION;
    public static final int TV_STATE_MUTE_NO_AUDIO_SERVICE;
    public static final byte TV_TM_UNAVAILABLE;
    public static final byte TV_TM_OFF;
    public static final byte TV_TM_TV;
    public static final byte TV_TM_EPG;
    public static final byte TV_TM_TELETEXT;
    public static final byte TV_TM_SEARCH;
    public static final byte TV_TM_DATABROADCAST_DVB;
    public static final byte TV_TM_DATABROADCAST_ISDB;
    public static final byte TV_TM_DATABROADCAST_DTMB_CMMB;
    public static final byte TV_TM_DATABROADCAST_DMB;
    public static final byte TV_TM_DATABROADCAST_ATSC;
    public static final byte TV_TM_DATABROADCAST_1;
    public static final byte TV_TM_DATABROADCAST_2;
    public static final byte TV_TM_BWS;
    public static final byte TV_TM_SLS_DLS;
    public static final byte TV_TM_TXT;
    public static final byte TV_TM_CAS;
    public static final byte TV_TM_VISUAL_AUDIO;
    public static final byte TV_TM_ENGINEERING;
    public static final byte TV_TM_AV;
    public static final byte TV_TM_INITIALIZING_TV;
    public static final byte TV_TM_INITIALIZING_AV;
    public static final byte TV_TM_OTHER;

    default public void updateActiveStation(ITVInterappListener$ActiveStationInfo iTVInterappListener$ActiveStationInfo) {
    }

    default public void updateSeekStatus(boolean bl) {
    }

    default public void updateTVStationList(ITVInterappListener$ServiceInfo[] iTVInterappListener$ServiceInfoArray) {
    }

    default public void enforceTV() {
    }

    default public void updateTerminalMode(byte by) {
    }

    default public void updatePanelKeySet(short[] sArray) {
    }

    default public void updateParentalSettings(boolean bl, int n) {
    }

    default public void updateTvTunerConfig(ITVInterappListener$TvTunerConfig iTVInterappListener$TvTunerConfig) {
    }

    default public void updateTvState(TvState tvState) {
    }
}

