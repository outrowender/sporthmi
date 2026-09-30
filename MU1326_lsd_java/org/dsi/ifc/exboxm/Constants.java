/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public interface Constants {
    public static final int RESULTCODE_OK = 0;
    public static final int RESULTCODE_ERROR = 1;
    public static final int DISPLAYCONTEXT_UNKNOWN = -1;
    public static final int DISPLAYCONTEXT_HMI = 0;
    public static final int DISPLAYCONTEXT_DMB = 1;
    public static final int DISPLAYCONTEXT_PHONE = 2;
    public static final int DISPLAYCONTEXT_NAV = 3;
    public static final int DISPLAYCONTEXT_TPEG = 4;
    public static final int DISPLAYCONTEXT_BT = 5;
    public static final int DISPLAYCONTEXT_APP_CONNECT = 6;
    public static final int DISPLAYCONTEXT_EMERGENCY_ANNOUNCEMENT = 7;
    public static final int DISPLAYCONTEXT_SDS = 8;
    public static final int AUXAUDIOSOURCE_NONE = 0;
    public static final int AUXAUDIOSOURCE_PHONE = 1;
    public static final int AUXAUDIOSOURCE_BT = 2;
    public static final int AUXAUDIOSOURCE_SDS = 3;
    public static final int AUXAUDIOSOURCE_RINGTONE = 4;
    public static final int AUXAUDIOSOURCE_TTS = 5;
    public static final int VDAAUDIOSOURCE_NONE = 0;
    public static final int VDAAUDIOSOURCE_NAV = 1;
    public static final int VDAAUDIOSOURCE_EMERGENCY_ANNOUNCEMENT = 2;
    public static final int VOLAUDIOSOURCE_ENTERTAINMENT = 1;
    public static final int VOLAUDIOSOURCE_NAVIGATION = 2;
    public static final int VOLAUDIOSOURCE_PHONE = 3;
    public static final int VOLAUDIOSOURCE_SDS = 4;
    public static final int OPERATIONSTATE_BAPERROR = -1;
    public static final int OPERATIONSTATE_NORMAL = 0;
    public static final int OPERATIONSTATE_INITIALIZING = 3;
    public static final int OPERATIONSTATE_DEFECT = 15;
    public static final int SOURCETYPE_NO_SOURCE_ACTIVE = 0;
    public static final int SOURCETYPE_BLUETOOTH_BT_STREAM = 21;
    public static final int SOURCETYPE_BLUETOOTH_RCP = 22;
    public static final int SOURCETYPE_DMB = 40;
    public static final int SOURCETYPE_UNKNOWN_SOURCE = 255;
    public static final int STATIONINFO_TYPE_ANY_TYPE_UNKNOWN = 0;
    public static final int STATIONINFO_TYPE_FOLDER = 1;
    public static final int STATIONINFO_TYPE_TRACK = 2;
    public static final int STATIONINFO_TYPE_PLAYLIST = 3;
    public static final int STATIONINFO_TYPE_PLAYLIST_FOLDER = 4;
    public static final int STATIONINFO_TYPE_AUDIO_FILE = 6;
    public static final int STATIONINFO_TYPE_AUDIO_FOLDER = 12;
    public static final int STATIONINFO_TYPE_RADIO_STATION = 68;
    public static final int STATIONINFO_TYPE_TITLE = 72;
    public static final int STATIONINFO_TYPE_ARTIST = 73;
    public static final int STATIONINFO_TYPE_ALBUM = 74;
    public static final int LINKTYPE_NOT_CONNECTED = 0;
    public static final int LINKTYPE_APPLE_CAR_PLAY = 1;
    public static final int LINKTYPE_ANDROID_AUTO = 2;
    public static final int LINKTYPE_MIRROR_LINK = 3;
    public static final int LINKTYPE_UNKNOWN = 255;
    public static final int CONNECTIONREQUESTTYPE_ACTIVATE_ANDROID_AUTO = 1;
    public static final int CONNECTIONREQUESTTYPE_ACTIVATE_CARPLAY = 2;
    public static final int CONNECTIONREQUESTTYPE_ACTIVATE_MIRRORLINK = 3;
    public static final int CONNECTIONREQUESTTYPE_START_ANDROID_AUTO = 11;
    public static final int CONNECTIONREQUESTTYPE_START_CARPLAY = 12;
    public static final int CONNECTIONREQUESTTYPE_START_MIRRORLINK = 13;
    public static final int CONNECTIONREQUESTRESULT_ANDROID_AUTO_STARTED = 1;
    public static final int CONNECTIONREQUESTRESULT_CARPLAY_STARTED = 2;
    public static final int CONNECTIONREQUESTRESULT_MIRRORLINK_STARTED = 3;
    public static final int CONNECTIONREQUESTRESULT_ANDROID_AUTO_ACTIVATED = 11;
    public static final int CONNECTIONREQUESTRESULT_CARPLAY_ACTIVATED = 12;
    public static final int CONNECTIONREQUESTRESULT_MIRRORLINK_ACTIVATED = 13;
    public static final int CONNECTIONREQUESTRESULT_SUCCESSFUL = 253;
    public static final int CONNECTIONREQUESTRESULT_NOT_SUCCESSFUL = 254;
}

