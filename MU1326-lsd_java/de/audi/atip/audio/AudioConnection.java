/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public final class AudioConnection {
    public static final int SDIS_RADIO_AM;
    public static final int SDIS_RADIO_FM;
    public static final int SDIS_RADIO_DAB;
    public static final int SDIS_RADIO_SDARS;
    public static final int SDIS_RADIO_TI;
    public static final int SDIS_DVD;
    public static final int SDIS_DVD_CDA;
    public static final int SDIS_TV;
    public static final int SDIS_A2LS;
    public static final int CD_DRIVE;
    public static final int FILE_PLAYER;
    public static final int MEDIA_CLOUD;
    public static final int FILE_PLAYER_BORDBOOK;
    public static final int DVD_DRIVE;
    public static final int DVD_CHANGER_CDA;
    public static final int DVD_CHANGER_DVDV;
    public static final int TV;
    public static final int AV_IN;
    public static final int AUX_IN;
    public static final int REMOTE_PLAYER;
    public static final int USB;
    public static final int SD_CARD1;
    public static final int WLAN_AUDIO;
    public static final int BT_AUDIO;
    public static final int IOS_MEDIA;
    public static final int IOS_PHONE;
    public static final int IOS_PHONE_INPUT;
    public static final int IOS_SIRI;
    public static final int IOS_SIRI_SPEECH_INPUT;
    public static final int IOS_ANNOUNCEMENT;
    public static final int IOS_LOWERING;
    public static final int GAL_MEDIA;
    public static final int GAL_PHONE;
    public static final int GAL_PHONE_INPUT;
    public static final int GAL_SPEECH;
    public static final int GAL_SPEECH_INPUT;
    public static final int GAL_ANNOUNCEMENT;
    public static final int GAL_LOWERING;
    private static final int BCL_MEDIA;
    private static final int BCL_SPEECH;
    private static final int BCL_SPEECH_INPUT;
    private static final int BCL_ANNOUNCEMENT;
    private static final int BCL_LOWERING;
    public static final int RSE_CD_DRIVE;
    public static final int RSE_FILE_PLAYER;
    public static final int RSE_CD_CHANGER;
    public static final int RSE_DVD_DRIVE;
    public static final int RSE_DVD_CHANGER_DVD;
    public static final int RSE_DVD_CHANGER_DATA;
    public static final int RSE_AUX_IN;
    public static final int RSE_REMOTE_PLAYER;
    public static final int RSE_BT_AUDIO;
    public static final int RSE_WLAN_AUDIO;
    public static final int AM_TUNER;
    public static final int FM_TUNER;
    public static final int AMFM_TA;
    public static final int AMFM_PTY31;
    public static final int DAB_TUNER;
    public static final int DAB_TA;
    public static final int DAB_PTY31;
    public static final int DAB_ANN;
    public static final int SDARS_TUNER;
    public static final int TI_TUNER;
    public static final int CAR;
    public static final int PHONE_GSM_UPLINK;
    public static final int PHONE_GSM_DOWNLINK;
    public static final int PHONE_GSM_UPLINK_MUTE;
    public static final int PHONE_BT_DOWNLINK;
    public static final int PHONE_BT_DOWNLINK_MUTE;
    public static final int PHONE_HANDSET_1;
    public static final int PHONE_HANDSET_2;
    public static final int PHONE_RINGTONE_PLAYER;
    public static final int PHONE_INBAND_RINGING;
    public static final int PHONE_MP3_RINGING;
    public static final int SMS_BEEP;
    public static final int PHONE_MUTEPIN;
    public static final int PHONE_EXTERNAL_VDA;
    public static final int MESSAGING_TTS;
    public static final int MOBILE_SPEECH_RECOGNITION_UPLINK;
    public static final int MOBILE_SPEECH_RECOGNITION_DOWNLINK;
    public static final int PHONE_ECALL;
    public static final int PHONE_ECALL_HIGH;
    public static final int PHONE_VOICE_HIGH;
    public static final int PHONE_VOICE_LOW;
    public static final int ECALL_MUTE;
    public static final int MUTEPIN_EC;
    public static final int SDS_DOWNLINK;
    public static final int SDS_UPLINK;
    public static final int SDS_ANNOUNCEMENT_SUP;
    public static final int NAVI_HI_PRIO;
    public static final int NAVI_LOW_PRIO;
    public static final int NAVI_TONE_POI_WARN;
    public static final int TMC_NO_TEL;
    public static final int TMC;
    public static final int TMC_ROAD_ROUTE_URGENT_NO_TEL;
    public static final int TMC_ROAD_ROUTE_URGENT;
    public static final int ETC_HI_PRIO;
    public static final int ETC_LOW_PRIO;
    public static final int APS;
    public static final int SYSTEM_TONE;
    public static final int SYSTEM_TONE_WARN;
    public static final int MUTE_STANDBY;
    public static final int RSE_MUTE_STANDBY;
    public static final int MUTE_ENT;
    public static final int RSE_MUTE_ENT;
    public static final int MUTE_SWDL;
    public static final int BT_AUDIO_MUTE;
    public static final int MUTE_THEFTPROTECTION;
    public static final int VOLUME_MENU_HEARTBEAT;
    public static final int VOLUME_MENU_TA_FM;
    public static final int VOLUME_MENU_TA_DAB;
    public static final int VOLUME_MENU_RINGTONE_HFP_INBAND;
    public static final int VOLUME_MENU_RINGTONE_MP3;
    public static final int VOLUME_MENU_RINGTONE_HFP_OUTBAND;
    public static final int VOLUME_MENU_RINGTONE_GSM_SIMAP;
    public static final int VOLUME_MENU_PHONE_CALL_HFP_INBAND;
    public static final int VOLUME_MENU_PHONE_CALL_HFP_OUTBAND;
    public static final int VOLUME_MENU_PHONE_CALL_GSM_SIMAP;
    public static final int VOLUME_MENU_SDS;
    public static final int VOLUME_MENU_TOUCHPAD;
    public static final int VOLUME_MENU_NAVI;
    public static final int VOLUME_MENU_APS;
    public static final int VOLUME_MENU_SMS_BEEP;
    public static final int VOLUME_MENU_ETC;
    public static final int VOLUME_MENU_WIRELESS_CHARGING;
    public static final int VOLUME_WILDCARD;
    public static final int RSE_VOLUME_WILDCARD;
    public static final int HEARTBEAT;
    public static final int TOUCHPAD_TTS;
    public static final int SYSTEM_TONE_TOUCHSCREEN;
    public static final int WIRELESS_CHARGING;
    public static final int ADDRESSBOOK_TTS;
    public static final int ONLINE_TTS;
    public static final int UNDEFINED;
    public static final int ENT_SUPPRESSION;
    public static final int ERRORCODE_RR_REQUEST_NOT_POSSIBLE;
    public static final int[] GREY_OUT_ALL;
    public static final int[] GREY_OUT_PHONE_MIC_GAIN;
    public static final int[] GREY_OUT_PHONE;
    public static final int[] GREY_OUT_NAVI;
    public static final int[] GREY_OUT_TA;
    public static final int[] VOLUME_MENU_CONNECTIONS;
    public static final int[] PHONE_CALL;
    public static final int[] PHONE_CALL_HANDSFREE;
    public static final int[] PHONE_RINGING;
    public static final int[] TA_PTY31;
    public static final int[] SDS;
    public static final int[] NAVI;
    public static final int[] TMC_CONNS;
    public static final int[] TMC_ALL;
    public static final int[] READOUT_CONTACT_CONNS;
    public static final int[] READOUT_MESSAGE_CONNS;
    public static final int[] ENT_MEDIA_CONNS;
    public static final int[] ENT_RADIO_CONNS;
    public static final int[] SDIS_ENT_RADIO_CONNS;
    public static final int[] SDIS_ENT_CONNECTIONS;
    public static final int[] CONNECTED_GATEWAY_CONNS;
    public static final int[] ETC;
    public static final int[] TOUCHPAD_CONNECTIONS;
    public static final int[] MUTE_CONNECTIONS;
    public static final int[] MUTE_SDIS_CONNECTIONS;
    public static final int[] MUTE_RELEASE_CONNECTIONS;
    public static final int[] EXLAP_SOUND_SOURCE_ENTERTAINMENT;
    public static final int[] EXLAP_SOUND_SOURCE_TA;
    public static final int[] EXLAP_SOUND_SOURCE_SDS;
    public static final int[] EXLAP_SOUND_SOURCE_NAVI;
    public static final int[] EXLAP_SOUND_SOURCE_PHONE;
    public static final int[] EXLAP_CONTEXT_TV;
    public static final int[] EXLAP_CONTEXT_MEDIA;
    public static final int[] EXLAP_CONTEXT_RADIO;
    public static final int[] EXLAP_CONTEXT_APP_CONNECT;
    public static final int[] TERMINAL_MODE_MEDIA;
    public static final int[] TERMINAL_MODE_PHONE;
    public static final int[] TERMINAL_MODE_SPEECH;
    public static final int[] TERMINAL_MODE_NAVI_LOWERING;
    public static final int[] TERMINAL_MODE_BACKGROUND;

    public static boolean isSdisSoundSourceEntertainment(int n) {
        return AudioConnection.contains(ENT_RADIO_CONNS, n) || AudioConnection.contains(ENT_MEDIA_CONNS, n) || AudioConnection.contains(TERMINAL_MODE_MEDIA, n) || AudioConnection.contains(SDIS_ENT_CONNECTIONS, n) || n == 308 || n == 8;
    }

    public static boolean isSdisSoundSourcePhone(int n) {
        return AudioConnection.contains(CONNECTED_GATEWAY_CONNS, n) || AudioConnection.contains(PHONE_CALL, n) || AudioConnection.contains(PHONE_RINGING, n) || AudioConnection.contains(TERMINAL_MODE_PHONE, n);
    }

    public static boolean isSdisSoundSourceNavigation(int n) {
        return AudioConnection.contains(NAVI, n) || AudioConnection.contains(TMC_CONNS, n) || 138 == n || 140 == n || AudioConnection.contains(TERMINAL_MODE_NAVI_LOWERING, n);
    }

    public static boolean isSdisSoundSourceSds(int n) {
        return AudioConnection.contains(SDS, n) || n == 150 || AudioConnection.contains(TERMINAL_MODE_SPEECH, n);
    }

    public static boolean contains(int[] nArray, int n) {
        if (nArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return true;
        }
        return false;
    }

    private AudioConnection() {
        throw new IllegalAccessError("AudioConnection contains only static methods!");
    }

    static {
        GREY_OUT_ALL = new int[]{31, 33, 32, 34, 35, 4, 117, 116, 114, 115, 118, 119, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
        GREY_OUT_PHONE_MIC_GAIN = new int[]{31, 33, 32, 34, 35, 4, 117, 116, 114, 115, 118, 119, 113, 112, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
        GREY_OUT_PHONE = GREY_OUT_ALL;
        GREY_OUT_NAVI = new int[]{31, 33, 32, 34, 35, 4, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
        GREY_OUT_TA = new int[]{117, 116, 114, 115, 118, 119, 4, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
        VOLUME_MENU_CONNECTIONS = new int[]{82, 84, 85, 88, 91, 87, 87, 90, 90, 89, 86, 132, 83, 94, 92, 143, 139};
        PHONE_CALL = new int[]{104, 106, 99, 100, 102, 110, 111, 210};
        PHONE_CALL_HANDSFREE = new int[]{99, 100, 102, 104, 106};
        PHONE_RINGING = new int[]{98, 103, 95};
        TA_PTY31 = new int[]{31, 33, 32, 34, 35};
        SDS = new int[]{112, 113, 136, 137};
        NAVI = new int[]{116, 117};
        TMC_CONNS = new int[]{118, 119};
        TMC_ALL = new int[]{115, 114, 119, 118};
        READOUT_CONTACT_CONNS = new int[]{125, 114, 115};
        READOUT_MESSAGE_CONNS = new int[]{126, 127, 138, 140};
        ENT_MEDIA_CONNS = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 27};
        ENT_RADIO_CONNS = new int[]{13, 12, 26, 28};
        SDIS_ENT_RADIO_CONNS = new int[]{301, 300, 302, 304};
        SDIS_ENT_CONNECTIONS = new int[]{300, 301, 302, 303, 304, 305, 306, 307};
        CONNECTED_GATEWAY_CONNS = new int[]{226, 227, 225, 228};
        ETC = new int[]{138, 140, 115};
        TOUCHPAD_CONNECTIONS = new int[]{129, 122};
        MUTE_CONNECTIONS = new int[]{3, 3, 8, 8, 7, 200, 6};
        MUTE_SDIS_CONNECTIONS = new int[]{3, 7, 6, 213};
        MUTE_RELEASE_CONNECTIONS = new int[]{8, 3, 7, 6, 106, 102, 200, 210};
        EXLAP_SOUND_SOURCE_ENTERTAINMENT = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 27, 13, 12, 26, 28, 162, 156, 167, 308};
        EXLAP_SOUND_SOURCE_TA = new int[]{31, 33, 32, 34, 35, 84, 85};
        EXLAP_SOUND_SOURCE_SDS = new int[]{112, 113, 136, 137, 152, 153, 158, 159, 168, 169, 138, 140, 115, 139, 86, 143};
        EXLAP_SOUND_SOURCE_NAVI = new int[]{116, 117, 155, 161, 171, 118, 119, 83};
        EXLAP_SOUND_SOURCE_PHONE = new int[]{104, 106, 99, 100, 102, 110, 111, 210, 98, 103, 95, 151, 163, 157, 164, 89, 90, 90, 87, 88, 87, 91};
        EXLAP_CONTEXT_TV = new int[]{27};
        EXLAP_CONTEXT_MEDIA = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 308};
        EXLAP_CONTEXT_RADIO = new int[]{13, 12, 26, 28};
        EXLAP_CONTEXT_APP_CONNECT = new int[]{162, 156, 167};
        TERMINAL_MODE_MEDIA = new int[]{162, 156, 167};
        TERMINAL_MODE_PHONE = new int[]{151, 163, 157, 164};
        TERMINAL_MODE_SPEECH = new int[]{152, 153, 158, 159, 168, 169};
        TERMINAL_MODE_NAVI_LOWERING = new int[]{155, 161, 171};
        TERMINAL_MODE_BACKGROUND = new int[]{154, 160, 170};
    }
}

