/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$SourceAudioState;

public interface AudioDrawerContext {
    public static final int PRIO_IDX_APS;
    public static final int PRIO_IDX_TERMINAL_MODE_PHONE;
    public static final int PRIO_IDX_PHONE;
    public static final int PRIO_IDX_SDS_MAIN;
    public static final int PRIO_IDX_SDS_ADB;
    public static final int PRIO_IDX_SDS_MEDIA;
    public static final int PRIO_IDX_SDS_MESSAGING;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_CNTW;
    public static final int PRIO_IDX_SDS_NAVI;
    public static final int PRIO_IDX_SDS_NAVI_POI_ONLINE;
    public static final int PRIO_IDX_SDS_PHONE;
    public static final int PRIO_IDX_SDS_RHMI;
    public static final int PRIO_IDX_SDS_TUNER;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_JP;
    public static final int PRIO_IDX_SDS_NAVI_ASIA_KR;
    public static final int PRIO_IDX_NAVI;
    public static final int PRIO_IDX_TA;
    public static final int PRIO_IDX_SDIS;
    public static final int PRIO_IDX_MEDIA;
    public static final int PRIO_IDX_RADIO;
    public static final int PRIO_IDX_TV;
    public static final int PRIO_IDX_TERMINAL_MODE;
    public static final int NO_PRIO_IDX;
    public static final int MAX_ROWS;
    public static final int MAX_COLUMNS;
    public static final int CELL_TYPE_INACTIVE;
    public static final int CELL_TYPE_ACTIVE;
    public static final int CELL_TYPE_APS_ACTIVE_HIGH_PRIO;
    public static final int CELL_TYPE_PHONE_IDLE;
    public static final int CELL_TYPE_PHONE_ACTIVE_CALL;
    public static final int CELL_TYPE_PHONE_INCOMING_CALL;
    public static final IntegerListCell LIST_CELL_INACTIVE;
    public static final IntegerListCell LIST_CELL_ACTIVE;
    public static final IntegerListCell LIST_CELL_APS_ACTIVE_HIGH_PRIO;
    public static final IntegerListCell LIST_CELL_PHONE_IDLE;
    public static final IntegerListCell LIST_CELL_PHONE_ACTIVE_CALL;
    public static final IntegerListCell LIST_CELL_PHONE_INCOMING_CALL;
    public static final AudioDrawerContext$Source SOURCE_RADIO;
    public static final AudioDrawerContext$Source SOURCE_TV;
    public static final AudioDrawerContext$Source SOURCE_SDIS;
    public static final AudioDrawerContext$Source SOURCE_TERMINAL_MODE;
    public static final AudioDrawerContext$Source SOURCE_TERMINAL_MODE_PHONE;
    public static final AudioDrawerContext$Source SOURCE_MEDIA;
    public static final AudioDrawerContext$Source SOURCE_TA;
    public static final AudioDrawerContext$Source SOURCE_SDS_MAIN;
    public static final AudioDrawerContext$Source SOURCE_SDS_ADB;
    public static final AudioDrawerContext$Source SOURCE_SDS_MEDIA;
    public static final AudioDrawerContext$Source SOURCE_SDS_MESSAGING;
    public static final AudioDrawerContext$Source SOURCE_SDS_NAVI_ASIA_CNTW;
    public static final AudioDrawerContext$Source SOURCE_SDS_NAVI;
    public static final AudioDrawerContext$Source SOURCE_SDS_NAVI_POI_ONLINE;
    public static final AudioDrawerContext$Source SOURCE_SDS_PHONE;
    public static final AudioDrawerContext$Source SOURCE_SDS_RHMI;
    public static final AudioDrawerContext$Source SOURCE_SDS_TUNER;
    public static final AudioDrawerContext$Source SOURCE_SDS_NAVI_ASIA_JP;
    public static final AudioDrawerContext$Source SOURCE_SDS_NAVI_ASIA_KR;
    public static final AudioDrawerContext$Source SOURCE_NAVI;
    public static final AudioDrawerContext$Source SOURCE_PHONE;
    public static final AudioDrawerContext$Source SOURCE_APS;
    public static final AudioDrawerContext$Source SOURCE_NONE;
    public static final AudioDrawerContext$SourceAudioState SOURCE_AUDIO_STATE_ACTIVE;
    public static final AudioDrawerContext$SourceAudioState SOURCE_AUDIO_STATE_INACTIVE;
    public static final AudioDrawerContext$SourceAudioState SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO;
    public static final AudioDrawerContext$SourceAudioState SOURCE_PHONE_STATE_IDLE;
    public static final AudioDrawerContext$SourceAudioState SOURCE_PHONE_STATE_ACTIVE_CALL;
    public static final AudioDrawerContext$SourceAudioState SOURCE_PHONE_STATE_INCOMING_CALL;
    public static final int DRAWER_OPEN;
    public static final int DRAWER_CLOSED;
    public static final int DRAWER_MINIMIZED;

    default public void setContext(AudioDrawerContext$Source audioDrawerContext$Source, AudioDrawerContext$SourceAudioState audioDrawerContext$SourceAudioState) {
    }

    static {
        LIST_CELL_INACTIVE = IntegerListCell.create(0);
        LIST_CELL_ACTIVE = IntegerListCell.create(1);
        LIST_CELL_APS_ACTIVE_HIGH_PRIO = IntegerListCell.create(2);
        LIST_CELL_PHONE_IDLE = IntegerListCell.create(0);
        LIST_CELL_PHONE_ACTIVE_CALL = IntegerListCell.create(2);
        LIST_CELL_PHONE_INCOMING_CALL = IntegerListCell.create(3);
        SOURCE_RADIO = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_RADIO", 19, null);
        SOURCE_TV = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_TV", 20, null);
        SOURCE_SDIS = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDIS", 17, null);
        SOURCE_TERMINAL_MODE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_TERMINAL_MODE", 21, null);
        SOURCE_TERMINAL_MODE_PHONE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_TERMINAL_MODE_PHONE", 1, null);
        SOURCE_MEDIA = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_MEDIA", 18, null);
        SOURCE_TA = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_TA", 16, null);
        SOURCE_SDS_MAIN = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_MAIN", 3, null);
        SOURCE_SDS_ADB = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_ADB", 4, null);
        SOURCE_SDS_MEDIA = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_MEDIA", 5, null);
        SOURCE_SDS_MESSAGING = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_MESSAGING", 6, null);
        SOURCE_SDS_NAVI_ASIA_CNTW = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_CNTW", 7, null);
        SOURCE_SDS_NAVI = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_NAVI", 8, null);
        SOURCE_SDS_NAVI_POI_ONLINE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_NAVI_POI_ONLINE", 9, null);
        SOURCE_SDS_PHONE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_PHONE", 10, null);
        SOURCE_SDS_RHMI = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_RHMI", 11, null);
        SOURCE_SDS_TUNER = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_TUNER", 12, null);
        SOURCE_SDS_NAVI_ASIA_JP = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_JP", 13, null);
        SOURCE_SDS_NAVI_ASIA_KR = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_SDS_NAVI_ASIA_KR", 14, null);
        SOURCE_NAVI = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_NAVI", 15, null);
        SOURCE_PHONE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_PHONE", 2, null);
        SOURCE_APS = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_APS", 0, null);
        SOURCE_NONE = new AudioDrawerContext$Source("AUDIO_DRAWER_SRC_NONE", 22, null);
        SOURCE_AUDIO_STATE_ACTIVE = new AudioDrawerContext$SourceAudioState("SOURCE_AUDIO_STATE_ACTIVE", LIST_CELL_ACTIVE, null);
        SOURCE_AUDIO_STATE_INACTIVE = new AudioDrawerContext$SourceAudioState("SOURCE_AUDIO_STATE_INACTIVE", LIST_CELL_INACTIVE, null);
        SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO = new AudioDrawerContext$SourceAudioState("SOURCE_AUDIO_STATE_APS_ACTIVE_HIGH_PRIO", LIST_CELL_APS_ACTIVE_HIGH_PRIO, null);
        SOURCE_PHONE_STATE_IDLE = new AudioDrawerContext$SourceAudioState("SOURCE_PHONE_STATE_IDLE", LIST_CELL_PHONE_IDLE, null);
        SOURCE_PHONE_STATE_ACTIVE_CALL = new AudioDrawerContext$SourceAudioState("SOURCE_PHONE_STATE_ACTIVE_CALL", LIST_CELL_PHONE_ACTIVE_CALL, null);
        SOURCE_PHONE_STATE_INCOMING_CALL = new AudioDrawerContext$SourceAudioState("SOURCE_PHONE_STATE_INCOMING_CALL", LIST_CELL_PHONE_INCOMING_CALL, null);
    }
}

