/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

public final class AudioConnection {
    public static final int SDIS_RADIO_AM = 301;
    public static final int SDIS_RADIO_FM = 300;
    public static final int SDIS_RADIO_DAB = 302;
    public static final int SDIS_RADIO_SDARS = 304;
    public static final int SDIS_RADIO_TI = 303;
    public static final int SDIS_DVD = 305;
    public static final int SDIS_DVD_CDA = 306;
    public static final int SDIS_TV = 307;
    public static final int SDIS_A2LS = 308;
    public static final int CD_DRIVE = 18;
    public static final int FILE_PLAYER = 20;
    public static final int MEDIA_CLOUD = 45;
    public static final int FILE_PLAYER_BORDBOOK = 201;
    public static final int DVD_DRIVE = 19;
    public static final int DVD_CHANGER_CDA = 24;
    public static final int DVD_CHANGER_DVDV = 23;
    public static final int TV = 27;
    public static final int AV_IN = 27;
    public static final int AUX_IN = 16;
    public static final int REMOTE_PLAYER = 17;
    public static final int USB = 20;
    public static final int SD_CARD1 = 20;
    public static final int WLAN_AUDIO = 20;
    public static final int BT_AUDIO = 21;
    public static final int IOS_MEDIA = 162;
    public static final int IOS_PHONE = 151;
    public static final int IOS_PHONE_INPUT = 163;
    public static final int IOS_SIRI = 152;
    public static final int IOS_SIRI_SPEECH_INPUT = 153;
    public static final int IOS_ANNOUNCEMENT = 154;
    public static final int IOS_LOWERING = 155;
    public static final int GAL_MEDIA = 156;
    public static final int GAL_PHONE = 157;
    public static final int GAL_PHONE_INPUT = 164;
    public static final int GAL_SPEECH = 158;
    public static final int GAL_SPEECH_INPUT = 159;
    public static final int GAL_ANNOUNCEMENT = 160;
    public static final int GAL_LOWERING = 161;
    private static final int BCL_MEDIA = 167;
    private static final int BCL_SPEECH = 168;
    private static final int BCL_SPEECH_INPUT = 169;
    private static final int BCL_ANNOUNCEMENT = 170;
    private static final int BCL_LOWERING = 171;
    public static final int RSE_CD_DRIVE = 0;
    public static final int RSE_FILE_PLAYER = 0;
    public static final int RSE_CD_CHANGER = 0;
    public static final int RSE_DVD_DRIVE = 0;
    public static final int RSE_DVD_CHANGER_DVD = 0;
    public static final int RSE_DVD_CHANGER_DATA = 0;
    public static final int RSE_AUX_IN = 0;
    public static final int RSE_REMOTE_PLAYER = 0;
    public static final int RSE_BT_AUDIO = 0;
    public static final int RSE_WLAN_AUDIO = 0;
    public static final int AM_TUNER = 13;
    public static final int FM_TUNER = 12;
    public static final int AMFM_TA = 31;
    public static final int AMFM_PTY31 = 33;
    public static final int DAB_TUNER = 26;
    public static final int DAB_TA = 32;
    public static final int DAB_PTY31 = 34;
    public static final int DAB_ANN = 35;
    public static final int SDARS_TUNER = 28;
    public static final int TI_TUNER = 15;
    public static final int CAR = 124;
    public static final int PHONE_GSM_UPLINK = 100;
    public static final int PHONE_GSM_DOWNLINK = 99;
    public static final int PHONE_GSM_UPLINK_MUTE = 102;
    public static final int PHONE_BT_DOWNLINK = 104;
    public static final int PHONE_BT_DOWNLINK_MUTE = 106;
    public static final int PHONE_HANDSET_1 = 110;
    public static final int PHONE_HANDSET_2 = 111;
    public static final int PHONE_RINGTONE_PLAYER = 98;
    public static final int PHONE_INBAND_RINGING = 103;
    public static final int PHONE_MP3_RINGING = 95;
    public static final int SMS_BEEP = 123;
    public static final int PHONE_MUTEPIN = 96;
    public static final int PHONE_EXTERNAL_VDA = 97;
    public static final int MESSAGING_TTS = 126;
    public static final int MOBILE_SPEECH_RECOGNITION_UPLINK = 137;
    public static final int MOBILE_SPEECH_RECOGNITION_DOWNLINK = 136;
    public static final int PHONE_ECALL = 226;
    public static final int PHONE_ECALL_HIGH = 227;
    public static final int PHONE_VOICE_HIGH = 228;
    public static final int PHONE_VOICE_LOW = 225;
    public static final int ECALL_MUTE = 210;
    public static final int MUTEPIN_EC = 213;
    public static final int SDS_DOWNLINK = 112;
    public static final int SDS_UPLINK = 113;
    public static final int SDS_ANNOUNCEMENT_SUP = 150;
    public static final int NAVI_HI_PRIO = 116;
    public static final int NAVI_LOW_PRIO = 117;
    public static final int NAVI_TONE_POI_WARN = 235;
    public static final int TMC_NO_TEL = 115;
    public static final int TMC = 114;
    public static final int TMC_ROAD_ROUTE_URGENT_NO_TEL = 119;
    public static final int TMC_ROAD_ROUTE_URGENT = 118;
    public static final int ETC_HI_PRIO = 138;
    public static final int ETC_LOW_PRIO = 140;
    public static final int APS = 4;
    public static final int SYSTEM_TONE = 120;
    public static final int SYSTEM_TONE_WARN = 121;
    public static final int MUTE_STANDBY = 3;
    public static final int RSE_MUTE_STANDBY = 3;
    public static final int MUTE_ENT = 8;
    public static final int RSE_MUTE_ENT = 8;
    public static final int MUTE_SWDL = 7;
    public static final int BT_AUDIO_MUTE = 200;
    public static final int MUTE_THEFTPROTECTION = 6;
    public static final int VOLUME_MENU_HEARTBEAT = 82;
    public static final int VOLUME_MENU_TA_FM = 84;
    public static final int VOLUME_MENU_TA_DAB = 85;
    public static final int VOLUME_MENU_RINGTONE_HFP_INBAND = 88;
    public static final int VOLUME_MENU_RINGTONE_MP3 = 91;
    public static final int VOLUME_MENU_RINGTONE_HFP_OUTBAND = 87;
    public static final int VOLUME_MENU_RINGTONE_GSM_SIMAP = 87;
    public static final int VOLUME_MENU_PHONE_CALL_HFP_INBAND = 90;
    public static final int VOLUME_MENU_PHONE_CALL_HFP_OUTBAND = 90;
    public static final int VOLUME_MENU_PHONE_CALL_GSM_SIMAP = 89;
    public static final int VOLUME_MENU_SDS = 86;
    public static final int VOLUME_MENU_TOUCHPAD = 132;
    public static final int VOLUME_MENU_NAVI = 83;
    public static final int VOLUME_MENU_APS = 94;
    public static final int VOLUME_MENU_SMS_BEEP = 92;
    public static final int VOLUME_MENU_ETC = 139;
    public static final int VOLUME_MENU_WIRELESS_CHARGING = 143;
    public static final int VOLUME_WILDCARD = 2;
    public static final int RSE_VOLUME_WILDCARD = 2;
    public static final int HEARTBEAT = 48;
    public static final int TOUCHPAD_TTS = 129;
    public static final int SYSTEM_TONE_TOUCHSCREEN = 122;
    public static final int WIRELESS_CHARGING = 142;
    public static final int ADDRESSBOOK_TTS = 125;
    public static final int ONLINE_TTS = 127;
    public static final int UNDEFINED = 0;
    public static final int ENT_SUPPRESSION = 9;
    public static final int ERRORCODE_RR_REQUEST_NOT_POSSIBLE = 2;
    public static final int[] GREY_OUT_ALL = new int[]{31, 33, 32, 34, 35, 4, 117, 116, 114, 115, 118, 119, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
    public static final int[] GREY_OUT_PHONE_MIC_GAIN = new int[]{31, 33, 32, 34, 35, 4, 117, 116, 114, 115, 118, 119, 113, 112, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
    public static final int[] GREY_OUT_PHONE = GREY_OUT_ALL;
    public static final int[] GREY_OUT_NAVI = new int[]{31, 33, 32, 34, 35, 4, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
    public static final int[] GREY_OUT_TA = new int[]{117, 116, 114, 115, 118, 119, 4, 113, 112, 103, 95, 98, 104, 106, 99, 100, 102, 110, 111, 226, 227, 225, 228, 151, 163, 152, 153, 155, 157, 164, 158, 159, 161, 168, 169, 171};
    public static final int[] VOLUME_MENU_CONNECTIONS = new int[]{82, 84, 85, 88, 91, 87, 87, 90, 90, 89, 86, 132, 83, 94, 92, 143, 139};
    public static final int[] PHONE_CALL = new int[]{104, 106, 99, 100, 102, 110, 111, 210};
    public static final int[] PHONE_CALL_HANDSFREE = new int[]{99, 100, 102, 104, 106};
    public static final int[] PHONE_RINGING = new int[]{98, 103, 95};
    public static final int[] TA_PTY31 = new int[]{31, 33, 32, 34, 35};
    public static final int[] SDS = new int[]{112, 113, 136, 137};
    public static final int[] NAVI = new int[]{116, 117};
    public static final int[] TMC_CONNS = new int[]{118, 119};
    public static final int[] TMC_ALL = new int[]{115, 114, 119, 118};
    public static final int[] READOUT_CONTACT_CONNS = new int[]{125, 114, 115};
    public static final int[] READOUT_MESSAGE_CONNS = new int[]{126, 127, 138, 140};
    public static final int[] ENT_MEDIA_CONNS = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 27};
    public static final int[] ENT_RADIO_CONNS = new int[]{13, 12, 26, 28};
    public static final int[] SDIS_ENT_RADIO_CONNS = new int[]{301, 300, 302, 304};
    public static final int[] SDIS_ENT_CONNECTIONS = new int[]{300, 301, 302, 303, 304, 305, 306, 307};
    public static final int[] CONNECTED_GATEWAY_CONNS = new int[]{226, 227, 225, 228};
    public static final int[] ETC = new int[]{138, 140, 115};
    public static final int[] TOUCHPAD_CONNECTIONS = new int[]{129, 122};
    public static final int[] MUTE_CONNECTIONS = new int[]{3, 3, 8, 8, 7, 200, 6};
    public static final int[] MUTE_SDIS_CONNECTIONS = new int[]{3, 7, 6, 213};
    public static final int[] MUTE_RELEASE_CONNECTIONS = new int[]{8, 3, 7, 6, 106, 102, 200, 210};
    public static final int[] EXLAP_SOUND_SOURCE_ENTERTAINMENT = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 27, 13, 12, 26, 28, 162, 156, 167, 308};
    public static final int[] EXLAP_SOUND_SOURCE_TA = new int[]{31, 33, 32, 34, 35, 84, 85};
    public static final int[] EXLAP_SOUND_SOURCE_SDS = new int[]{112, 113, 136, 137, 152, 153, 158, 159, 168, 169, 138, 140, 115, 139, 86, 143};
    public static final int[] EXLAP_SOUND_SOURCE_NAVI = new int[]{116, 117, 155, 161, 171, 118, 119, 83};
    public static final int[] EXLAP_SOUND_SOURCE_PHONE = new int[]{104, 106, 99, 100, 102, 110, 111, 210, 98, 103, 95, 151, 163, 157, 164, 89, 90, 90, 87, 88, 87, 91};
    public static final int[] EXLAP_CONTEXT_TV = new int[]{27};
    public static final int[] EXLAP_CONTEXT_MEDIA = new int[]{45, 18, 24, 20, 19, 23, 16, 17, 20, 20, 20, 21, 9, 308};
    public static final int[] EXLAP_CONTEXT_RADIO = new int[]{13, 12, 26, 28};
    public static final int[] EXLAP_CONTEXT_APP_CONNECT = new int[]{162, 156, 167};
    public static final int[] TERMINAL_MODE_MEDIA = new int[]{162, 156, 167};
    public static final int[] TERMINAL_MODE_PHONE = new int[]{151, 163, 157, 164};
    public static final int[] TERMINAL_MODE_SPEECH = new int[]{152, 153, 158, 159, 168, 169};
    public static final int[] TERMINAL_MODE_NAVI_LOWERING = new int[]{155, 161, 171};
    public static final int[] TERMINAL_MODE_BACKGROUND = new int[]{154, 160, 170};

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
}

