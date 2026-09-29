/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.diag;

public class HMIDiagScreenNameMapping {
    public static String getScreenName(int n) {
        switch (n) {
            case 2: {
                return "MAIN_REF_TEMPLATE";
            }
            case 3: {
                return "MEDIA_INIT";
            }
            case 4: {
                return "MEDIA_ERROR";
            }
            case 5: {
                return "TUNER_INIT";
            }
            case 6: {
                return "TUNER_ERROR";
            }
            case 7: {
                return "TONE_ERROR";
            }
            case 8: {
                return "TONE_INIT";
            }
            case 9: {
                return "CAR_ERROR";
            }
            case 10: {
                return "CAR_STARTUP_INTIALIZE_INIT";
            }
            case 11: {
                return "INFO_ERROR";
            }
            case 12: {
                return "INFO_INIT";
            }
            case 13: {
                return "TEL_ERROR";
            }
            case 14: {
                return "TEL_INIT";
            }
            case 15: {
                return "ONLINE_INIT";
            }
            case 17: {
                return "SWDL_INIT";
            }
            case 16: {
                return "ONLINE_ERROR";
            }
            case 18: {
                return "NAV_ERROR";
            }
            case 21: {
                return "ADDRESSBOOK_INIT";
            }
            case 20: {
                return "ADDRESSBOOK_ERROR";
            }
            case 23: {
                return "ENGINEERING_ERROR";
            }
            case 22: {
                return "ENGINEERING_INIT";
            }
            case 25: {
                return "EARLY_APPS_ERROR";
            }
            case 24: {
                return "EARLY_APPS_INIT";
            }
            case 27: {
                return "PIC_NAV_ERROR";
            }
            case 26: {
                return "PIC_NAV_INIT";
            }
            case 29: {
                return "MESSAGING_INIT";
            }
            case 28: {
                return "MESSAGING_ERROR";
            }
            case 34: {
                return "KombiActiveContext";
            }
            case 35: {
                return "KombiActivePopup";
            }
            case 32: {
                return "SETTINGS_ERROR";
            }
            case 33: {
                return "SETTINGS_INIT";
            }
            case 39: {
                return "TEST_SUPPORT_INIT";
            }
            case 36: {
                return "GREEN_ENGINEERING_INIT";
            }
            case 42: {
                return "MAIN_POPUP_SYSTEM_BAT_WARNING";
            }
            case 43: {
                return "MAIN_POPUP_SYSTEM_TEMP";
            }
            case 40: {
                return "TEST_SUPPORT_ERROR";
            }
            case 41: {
                return "HMI_STANDBY";
            }
            case 46: {
                return "MAIN_WIZARD";
            }
            case 45: {
                return "EVO_AUDIO";
            }
            case 49: {
                return "SDS_AUDIO";
            }
            case 55: {
                return "SDS_HELP_MENUS";
            }
            case 54: {
                return "CONNECTIVITY_INIT";
            }
            case 53: {
                return "CONNECTIVITY_ERROR";
            }
            case 52: {
                return "POPUP_VOLUME";
            }
            case 59: {
                return "TV_ERROR";
            }
            case 58: {
                return "SDS_DISAMBIGUATION";
            }
            case 57: {
                return "SDS_COM_FURTHER_COMMANDS";
            }
            case 56: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_MAIN_MENU_ELSE";
            }
            case 62: {
                return "PartialPopupStatusbar";
            }
            case 61: {
                return "POPUP_ANNOUNCEMENT";
            }
            case 60: {
                return "TV_INIT";
            }
            case 68: {
                return "sdsDebugPopup";
            }
            case 69: {
                return "SPELLER_OPT";
            }
            case 70: {
                return "DEST_INIT_NAV_INITIALIZE";
            }
            case 71: {
                return "SDS_TEXT_CONSTANT";
            }
            case 64: {
                return "PartialPopupDiagnosis";
            }
            case 65: {
                return "PartialPopupDebugInfo";
            }
            case 66: {
                return "SETTINGS_POPUP_RESET_DRIVER_ERROR";
            }
            case 67: {
                return "SETTINGS_POPUP_PTT_NO_SDS";
            }
            case 76: {
                return "HINT_IA_DELETE_SPACE";
            }
            case 78: {
                return "HINT_IA_SPACE";
            }
            case 72: {
                return "POPUP_STANDBY";
            }
            case 73: {
                return "MAIN_TEXT_CONSTANT_METRICS";
            }
            case 75: {
                return "HINT_IA_DELETE";
            }
            case 85: {
                return "PRESET_POPUP";
            }
            case 87: {
                return "DEST_INIT_NO_NAV_ACTIVATED";
            }
            case 81: {
                return "HINT_IA_ASSUME_AUTOCOMPLETION_SUGGESTION";
            }
            case 80: {
                return "HINT_IA_EMPTY_TEXTFIELD";
            }
            case 93: {
                return "CM_POPUP_ONLINE_LICENSE_EXPIRE_NOTE";
            }
            case 95: {
                return "PartialPopupSportSkin";
            }
            case 94: {
                return "CM_POPUP_ONLINE_TEASER_EXPIRE_NOTE";
            }
            case 89: {
                return "DEST_INIT_NO_NAV_AVAILABLE";
            }
            case 88: {
                return "TEL_NOT_PRESENT";
            }
            case 91: {
                return "MESSAGING_NOT_PRESENT";
            }
            case 90: {
                return "ONLINE_NOT_PRESENT";
            }
            case 102: {
                return "POPUP_COMBI_POPUP_ACTIVE_DUMMY";
            }
            case 103: {
                return "MAP_HINT_INITIAL_UNLOCKED";
            }
            case 100: {
                return "SDS_LOGICAL_POPUP";
            }
            case 101: {
                return "PartialPopupStatusbarG24SCD";
            }
            case 98: {
                return "HINT_IA_ASSUME_AUTOCOMPLETION_TOUCH";
            }
            case 99: {
                return "SDS_COM_FAVORITES_DISAMBIGUATION";
            }
            case 96: {
                return "TEL_HINT_INITIAL";
            }
            case 97: {
                return "DEST_HINT_INITIAL";
            }
            case 110: {
                return "SDS_EXTERNAL_DISCLAIMER_SCREEN";
            }
            case 106: {
                return "BORDCOMPUTER_LASTMODE";
            }
            case 104: {
                return "CAR_STARTUP_INTIALIZE_CLAMP15_OFF";
            }
            case 105: {
                return "MAP_HINT_INITIAL_LOCKED";
            }
            case 119: {
                return "POPUP_CONVERSION_MATRIX_ASIA";
            }
            case 118: {
                return "TPEG_KR_ERROR";
            }
            case 117: {
                return "TPEG_KR_INIT";
            }
            case 116: {
                return "POPUP_ANNOUNCEMENT_G24";
            }
            case 115: {
                return "POPUP_STANDBY_G24";
            }
            case 114: {
                return "MAIN_POPUP_LAYOUT_SPORT_CLASSIC";
            }
            case 113: {
                return "POPUP_NO_NAV_AVAILABLE";
            }
            case 121: {
                return "ECALL_ERROR";
            }
            case 120: {
                return "ECALL_INIT";
            }
            case 155: {
                return "MAIN_POPUP_SDIS_MEDIA";
            }
            case 156: {
                return "MAIN_TEXT_CONSTANT";
            }
            case 157: {
                return "SDS_AUDIO_NAVI_ASIA_CNTW";
            }
            case 158: {
                return "SDS_AUDIO_NAVI_ASIA_KR";
            }
            case 159: {
                return "SDS_AUDIO_NAVI_ASIA_JP";
            }
            case 171: {
                return "SDS_AUDIO_PHONE";
            }
            case 170: {
                return "SDS_AUDIO_MEDIA";
            }
            case 169: {
                return "SDS_COM_FURTHER_COMMANDS_PHONE";
            }
            case 168: {
                return "SDS_COM_FURTHER_COMMANDS_MEDIA";
            }
            case 175: {
                return "SDS_AUDIO_MESSAGING";
            }
            case 174: {
                return "SDS_AUDIO_NAVI_POI_ONLINE";
            }
            case 173: {
                return "SDS_AUDIO_NAVI";
            }
            case 172: {
                return "SDS_AUDIO_ADB";
            }
            case 163: {
                return "SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_KR";
            }
            case 162: {
                return "SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_CNTW";
            }
            case 161: {
                return "SDS_COM_FURTHER_COMMANDS_TUNER";
            }
            case 160: {
                return "SDS_AUDIO_TUNER";
            }
            case 167: {
                return "SDS_COM_FURTHER_COMMANDS_ADB";
            }
            case 166: {
                return "SDS_COM_FURTHER_COMMANDS_NAVI_POI_ONLINE";
            }
            case 165: {
                return "SDS_COM_FURTHER_COMMANDS_NAVI";
            }
            case 164: {
                return "SDS_COM_FURTHER_COMMANDS_NAVI_ASIA_JP";
            }
            case 186: {
                return "MAIN_SPEED_DISCLAIMER";
            }
            case 187: {
                return "TERMINAL_MODE_ERROR";
            }
            case 184: {
                return "SETTINGS_POPUP_PTT_NO_SDS_DRIVE_SELECT";
            }
            case 185: {
                return "DEFAULT_AUDIO";
            }
            case 190: {
                return "APS_AUDIO_REDUCED";
            }
            case 191: {
                return "FUNCTION_NOT_ALLOWED_WHILE_DRIVING";
            }
            case 188: {
                return "TERMINAL_MODE_INIT";
            }
            case 189: {
                return "MAIN_SPEED_DISCLAIMER_NEW";
            }
            case 178: {
                return "SDS_AUDIO_RHMI";
            }
            case 179: {
                return "MAIN_POPUP_SDIS_NAVI";
            }
            case 176: {
                return "SDS_COM_FURTHER_COMMANDS_MESSAGING";
            }
            case 177: {
                return "SDS_COM_FURTHER_COMMANDS_RHMI";
            }
            case 182: {
                return "APS_AUDIO";
            }
            case 183: {
                return "AUDI_CONNECT_POPUP_HINT_MAIN";
            }
            case 180: {
                return "MEDIA_POPUP_A2LS_MAIN";
            }
            case 181: {
                return "SDIS_AUDIO";
            }
            case 207: {
                return "SETTINGS_NOT_AVAILABLE";
            }
            case 199: {
                return "LOCKING_referenceWidgets";
            }
            case 192: {
                return "TOUCHINPUT_ALLOWED_WHILE_DRIVING";
            }
            case 3400002: {
                return "CHARGING_POPUP_REMINDER";
            }
            case 3400000: {
                return "CHARGING_POPUP_OBJECT";
            }
            case 3400001: {
                return "CHARGING_POPUP_FOREIGN_OBJECT_DETECT";
            }
            case 100090: {
                return "SDS_TUNER_PICKLIST";
            }
            case 100088: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_TUNER";
            }
            case 100081: {
                return "TUNER_LIST_SIRIUS_INIT";
            }
            case 100080: {
                return "TUNER_SEL";
            }
            case 100087: {
                return "SDS_HELP_TUNER_TOPIC_SIRIUS";
            }
            case 100086: {
                return "SDS_HELP_TUNER_TOPIC_DAB";
            }
            case 100085: {
                return "SDS_HELP_TUNER_TOPIC_STATION";
            }
            case 100084: {
                return "SDS_HELP_TUNER";
            }
            case 100074: {
                return "TUNER_OPT_SIRIUS_SORTING";
            }
            case 100073: {
                return "TUNER_OPT_CATFILTER_MAIN";
            }
            case 100078: {
                return "TUNER_NAR_SCAN_LIST";
            }
            case 100079: {
                return "TUNER_NAR_SCAN_BAND";
            }
            case 100076: {
                return "TUNER_OPT_MANUAL_TUNE";
            }
            case 100077: {
                return "TUNER_OPT_SEEK_MAIN";
            }
            case 100066: {
                return "TUNER_OPT_GAMEALERT_SELECT_LIST_MAIN";
            }
            case 100065: {
                return "TUNER_OPT_GAMEALERT_SELECT_MAIN";
            }
            case 100068: {
                return "TUNER_OPT_GAMEALERT_SELECT_LEAGUE_MAIN";
            }
            case 100163: {
                return "TUNER_POPUP_RT_SMS";
            }
            case 100162: {
                return "TUNER_POPUP_RT_TEL";
            }
            case 100161: {
                return "TUNER_POPUP_RT_LOCATION";
            }
            case 100059: {
                return "TUNER_OPT_SUBSCRIPTION_MAIN";
            }
            case 100160: {
                return "PP_TUNER_OPT_SEEK_MEMORY";
            }
            case 100167: {
                return "TUNER_POPUP_RT_NOPHONE_02_MAIN";
            }
            case 100166: {
                return "TUNER_OPT_STATIONLOGOS";
            }
            case 100060: {
                return "TUNER_OPT_MANAGE_MAIN";
            }
            case 100165: {
                return "TUNER_POPUP_RT_SERVICE_NA";
            }
            case 100063: {
                return "TUNER_OPT_MUSICSEEK_ENABLE_MAIN";
            }
            case 100164: {
                return "TUNER_POPUP_RT_EMAIL";
            }
            case 100051: {
                return "TUNER_OPT_EPG_SIRIUS_DETAIL";
            }
            case 100053: {
                return "TUNER_OPT_EPG_SIRIUS_LIST_SINGLE";
            }
            case 100054: {
                return "TUNER_OPT_TAGGING";
            }
            case 100041: {
                return "TUNER_AUDIO";
            }
            case 100045: {
                return "TUNER_OPT_SLS_MAIN";
            }
            case 100046: {
                return "TUNER_OPT_SLS_LOAD";
            }
            case 100047: {
                return "TUNER_OPT_SLS_EMPTY";
            }
            case 100032: {
                return "TUNER_POPUP_LIST_MSG_UNSUBSCR_MAIN";
            }
            case 100033: {
                return "TUNER_POPUP_LIST_MSG_UNSUBSCR_NOPHONE";
            }
            case 100034: {
                return "TUNER_LIST_COMMONLIST_MAIN";
            }
            case 100036: {
                return "TUNER_OPT_FREEZE_MAIN";
            }
            case 100038: {
                return "TUNER_OPT_EPG_LIST";
            }
            case 100039: {
                return "TUNER_OPT_EPG_DETAIL";
            }
            case 100031: {
                return "TUNER_LIST_HISTORY_MAIN";
            }
            case 100030: {
                return "TUNER_OPT_LIST_UPDATE_MAIN";
            }
            case 100029: {
                return "TUNER_TOGGLE_MAIN";
            }
            case 100028: {
                return "TUNER_LIST_FAVORITE_MAIN";
            }
            case 100026: {
                return "TUNER_OPT_DISCLAIMER_MAIN";
            }
            case 100025: {
                return "TUNER_OPT_RADIOTEXT_MAIN";
            }
            case 100023: {
                return "TUNER_OPT_RADIOTEXT_EMPTY";
            }
            case 100022: {
                return "TUNER_OPT_RADIOTEXT_LOAD";
            }
            case 100143: {
                return "TUNER_POPUP_LIST_MSG_INVALID_MAIN";
            }
            case 100142: {
                return "TUNER_SELECT_WAVEBAND";
            }
            case 100018: {
                return "TUNER_OPT_SETTINGS_REGSTAT_NOTAVAI";
            }
            case 100017: {
                return "TUNER_OPT_SETTINGS_MAIN";
            }
            case 100148: {
                return "PP_TUNER_OPT_MUSICSEEK_DELETE_ALL_DONE";
            }
            case 100015: {
                return "TUNER_POPUP_LIST_MSG_UPDATE_DONE";
            }
            case 100149: {
                return "PP_TUNER_OPT_ALERT_DELETE_ALL_DONE";
            }
            case 100012: {
                return "TUNER_POPUP_LIST_MSG_ERROR";
            }
            case 100150: {
                return "PP_TUNER_OPT_MUSICSEEK_DELETE_ALL_MAIN";
            }
            case 100013: {
                return "TUNER_POPUP_LIST_MSG_ANTENNA";
            }
            case 100151: {
                return "PP_TUNER_OPT_ALERT_DELETE_ALL_MAIN";
            }
            case 100144: {
                return "TUNER_POPUP_LIST_MSG_UNKNOWN";
            }
            case 100011: {
                return "TUNER_LIST_ERROR";
            }
            case 100145: {
                return "TUNER_POPUP_LIST_MSG_UPDATE_MAIN";
            }
            case 100008: {
                return "TUNER_LIST_SIRIUS_MAIN";
            }
            case 100146: {
                return "TUNER_POPUP_LIST_MSG_SIRIUS_ESN";
            }
            case 100147: {
                return "TUNER_POPUP_OPT";
            }
            case 100009: {
                return "TUNER_LIST_TI";
            }
            case 100156: {
                return "PP_TUNER_OPT_SEEK_SAVE_MAIN";
            }
            case 100007: {
                return "TUNER_LIST_DAB";
            }
            case 100157: {
                return "PP_TUNER_OPT_ALERT_SAVE_MAIN";
            }
            case 100158: {
                return "TUNER_POPUP_SXM_CALL_NAR";
            }
            case 100159: {
                return "TUNER_OPT_EPG_SIRIUS_LIST_ALL";
            }
            case 100005: {
                return "TUNER_OPT";
            }
            case 100002: {
                return "TUNER_LIST_FM";
            }
            case 100152: {
                return "PP_TUNER_POPUP_TAG_TRANSFER_OK";
            }
            case 100153: {
                return "PP_TUNER_POPUP_TAG_TRANSFER_RETRY";
            }
            case 100000: {
                return "TUNER_REF_TEMPLATE";
            }
            case 100154: {
                return "PP_TUNER_OPT_FAVORITE_STORE_OK_NAR";
            }
            case 100001: {
                return "TUNER_LIST_AM";
            }
            case 100155: {
                return "PP_TUNER_POPUP_TAG_TRANSFER_MAIN";
            }
            case 100103: {
                return "TUNER_TEXT_CONSTANT";
            }
            case 100101: {
                return "TUNER_LIST_ONLINE";
            }
            case 100100: {
                return "TUNER_LIST_SIRIUS_FAVORITES_MAIN";
            }
            case 100097: {
                return "TUNER_LIST_SIRIUS_CATEGORY";
            }
            case 100108: {
                return "PP_TUNER_OPT_FAVORITE_DELETE_ALL_DONE";
            }
            case 100107: {
                return "PP_TUNER_OPT_FAVORITE_STORE_OK";
            }
            case 3200000: {
                return "TERMINAL_MODE_IPOD_OUT";
            }
            case 3200001: {
                return "TERMINAL_AUDIO";
            }
            case 3200002: {
                return "TERMINAL_MODE_ACTIVATE_FIRST";
            }
            case 3200003: {
                return "TERMINAL_MODE_DATA_DISCLAIMER";
            }
            case 3200004: {
                return "TERMINAL_MODE_NOT_CONFIRMED";
            }
            case 3200005: {
                return "TERMINAL_MODE_INVALID_COUNTRY";
            }
            case 3200006: {
                return "TERMINAL_MODE_NO_DEVICE";
            }
            case 3200007: {
                return "TERMINAL_MODE_BT_ACTIVATED";
            }
            case 3200008: {
                return "TERMINAL_EMPTY_AUDIO";
            }
            case 3200009: {
                return "TERMINAL_MODE_BLOCKED";
            }
            case 3200010: {
                return "TERMINAL_MODE_NO_CONNECTION";
            }
            case 3200011: {
                return "TERMINAL_MODE_STOPPED";
            }
            case 200145: {
                return "MEDIA_POPUP_ERRORS_UNIVERSAL";
            }
            case 200147: {
                return "MEDIA_BROWSER_BADFAVORITE_MAIN";
            }
            case 200146: {
                return "MEDIA_INVALID_WLAN_DATA";
            }
            case 200132: {
                return "MEDIA_INVALID_EXTERN_NOT_FREED";
            }
            case 200133: {
                return "MEDIA_OPT_COPY_RUNNING_BACKROUND";
            }
            case 200134: {
                return "MEDIA_POPUP_SWITCH_SOURCE_MAIN";
            }
            case 200135: {
                return "MEDIA_POPUP_SECOND_DEVICE_MAIN";
            }
            case 200128: {
                return "MEDIA_OPT_CHILDLOCK_WRONGPWD";
            }
            case 200129: {
                return "MEDIA_OPT_CHILDLOCK_PASSWORD";
            }
            case 200130: {
                return "MEDIA_OPT_INPUTLEVEL";
            }
            case 200131: {
                return "MEDIA_INVALID_EXTERN_CHARGING";
            }
            case 200140: {
                return "MEDIA_INVALID_ONLINE_WLAN_DATA";
            }
            case 200141: {
                return "MEDIA_INVALID_ONLINE_ENCRYPTION_ERROR_WLAN";
            }
            case 200142: {
                return "MEDIA_INVALID_ONLINE_NOAPP";
            }
            case 200143: {
                return "MEDIA_OPT_RINGTONE";
            }
            case 200136: {
                return "MEDIA_OPT_FAVORITE_SAVED";
            }
            case 200137: {
                return "MEDIA_INVALID_ONLINE_IGNITION";
            }
            case 200138: {
                return "MEDIA_INVALID_ONLINE_WLANOFF";
            }
            case 200139: {
                return "MEDIA_INVALID_ONLINE_NOCONN";
            }
            case 200115: {
                return "MEDIA_OPT_CHILDLOCK_SELECT_LEVEL";
            }
            case 200114: {
                return "MEDIA_OPT_CHILDLOCK_SELECT";
            }
            case 200112: {
                return "MEDIA_OPT_SUBTITLE";
            }
            case 200117: {
                return "MEDIA_BROWSER_FAVORITES_MAIN";
            }
            case 200116: {
                return "MEDIA_OPT_FAVORITE_DELETE_ALL";
            }
            case 200123: {
                return "MEDIA_OPT_CHILDLOCK_BLOCKED";
            }
            case 200122: {
                return "MEDIA_OPT_FAVORITE_DELETE_ALL_DONE";
            }
            case 200127: {
                return "MEDIA_OPT_CHILDLOCK_PWDCHANGE_SUCCESSFUL";
            }
            case 200126: {
                return "MEDIA_OPT_CHILDLOCK_PWDCHANGE_FAILED";
            }
            case 200125: {
                return "MEDIA_OPT_CHILDLOCK_PWDCHANGE_SECOND";
            }
            case 200124: {
                return "MEDIA_OPT_CHILDLOCK_PWDCHANGE_FIRST";
            }
            case 200098: {
                return "SDS_HELP_MEDIA_TOPIC_DEVICE_CHANGE";
            }
            case 200099: {
                return "SDS_HELP_MEDIA";
            }
            case 200096: {
                return "MEDIA_OPT_COPY_CDA";
            }
            case 200097: {
                return "MEDIA_OPT_DELETE_RUNNING_MAIN";
            }
            case 200102: {
                return "SDS_HELP_MEDIA_TOPIC_IPOD";
            }
            case 200103: {
                return "MEDIA_PLAYER_EMPTY";
            }
            case 200100: {
                return "SDS_HELP_MEDIA_TOPIC_JUKEBOX_SD_USB";
            }
            case 200101: {
                return "SDS_HELP_MEDIA_TOPIC_TITLE_SELECT";
            }
            case 200106: {
                return "MEDIA_OPT_PLAYPOSITION_AUDIO_MAIN";
            }
            case 200107: {
                return "MEDIA_OPT_PLAYPOSITION_VIDEO_MAIN";
            }
            case 200104: {
                return "SDS_MEDIA_PICKLIST";
            }
            case 200105: {
                return "MEDIA_OPT_HDD_DELETE";
            }
            case 200111: {
                return "MEDIA_OPT_AUDIOCHANNEL";
            }
            case 200108: {
                return "MEDIA_OPT_PLAYPOSITION_DVD_MAIN";
            }
            case 200109: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_MEDIA";
            }
            case 200081: {
                return "MEDIA_POPUP_COPY_SUMMARY_UNIVERSAL";
            }
            case 200082: {
                return "MEDIA_AUDIO";
            }
            case 200085: {
                return "MEDIA_OPT_JUKEBOX_MAIN";
            }
            case 200087: {
                return "MEDIA_SEL";
            }
            case 200089: {
                return "MEDIA_BROWSER_LOADING";
            }
            case 200088: {
                return "MEDIA_SAVER_VIDEO_DISCLAIMER";
            }
            case 200091: {
                return "MEDIA_INVALID_HDD_PARTITION";
            }
            case 200093: {
                return "MEDIA_PLAYER_AVRCP1.3";
            }
            case 200092: {
                return "MEDIA_PLAYER_AVRCP1.0";
            }
            case 200064: {
                return "MEDIA_INVALID_HDD_DELETING";
            }
            case 200067: {
                return "MEDIA_SAVER_DVD_PICTURE_FULL";
            }
            case 200068: {
                return "MEDIA_PLAYER_DVD_MAIN";
            }
            case 200069: {
                return "MEDIA_SAVER_VIDEO_PICTURE_FULL";
            }
            case 200070: {
                return "MEDIA_TOGGLE_MAIN";
            }
            case 200074: {
                return "MEDIA_INVALID_HDD_DISABLED";
            }
            case 200076: {
                return "MEDIA_OPT_COPY_RUNNING";
            }
            case 200062: {
                return "MEDIA_INVALID_BLOCKED";
            }
            case 200060: {
                return "MEDIA_INVALID_NOMEDIUM";
            }
            case 200061: {
                return "MEDIA_INVALID_NOFILES";
            }
            case 200058: {
                return "MEDIA_INVALID_UNREADABLE";
            }
            case 200059: {
                return "MEDIA_INVALID_DEVICE_UNAVAIL";
            }
            case 200056: {
                return "MEDIA_INVALID_DVD_REGION_CHANGE";
            }
            case 200057: {
                return "MEDIA_INVALID_DVD_REGION_NO_CHANGE";
            }
            case 200054: {
                return "MEDIA_INVALID_DVD_CHILDLOCK_LEVEL";
            }
            case 200055: {
                return "MEDIA_INVALID_DVD_CHILDLOCK_NOLEVEL";
            }
            case 200052: {
                return "MEDIA_INVALID_EXTERN_UNSUPPORTED";
            }
            case 200053: {
                return "MEDIA_INVALID_FIRMWARE";
            }
            case 200050: {
                return "MEDIA_INVALID_EXTERN_OVERCURRENT";
            }
            case 200048: {
                return "MEDIA_INVALID_EXTERN_NODEVICE";
            }
            case 200049: {
                return "MEDIA_INVALID_EXTERN_DEFECTIVE_CONN";
            }
            case 200047: {
                return "MEDIA_INVALID_WLAN_DEACTIVATED";
            }
            case 200046: {
                return "MEDIA_INVALID_WLAN_NEW";
            }
            case 200045: {
                return "MEDIA_INVALID_WLAN_IGNITION";
            }
            case 200044: {
                return "MEDIA_INVALID_BT_NEW";
            }
            case 200043: {
                return "MEDIA_INVALID_BT_RECONNECT";
            }
            case 200042: {
                return "MEDIA_INVALID_BT_AUDIO_OFF";
            }
            case 200041: {
                return "MEDIA_INVALID_BT_IGNITION";
            }
            case 200038: {
                return "MEDIA_BROWSER_UNIVERSAL";
            }
            case 200019: {
                return "MEDIA_OPT";
            }
            case 200012: {
                return "MEDIA_PLAYER_BASIC";
            }
            case 200009: {
                return "MEDIA_PLAYER_AUX";
            }
            case 200011: {
                return "MEDIA_PLAYER_FULL";
            }
            case 200004: {
                return "MEDIA_INVALID_HDD_EMPTY";
            }
            case 200007: {
                return "MEDIA_PLAYER_CDA_MAINBASIC";
            }
            case 200001: {
                return "MEDIA_LOADING";
            }
            case 200000: {
                return "MEDIA_REF_TEMPLATE";
            }
            case 200003: {
                return "MEDIA_PLAYER_FILE";
            }
            case 200207: {
                return "MEDIA_TEXT_CONSTANT";
            }
            case 200206: {
                return "MEDIA_INVALID_WLAN_NOAPP";
            }
            case 200205: {
                return "MEDIA_POPUP_PRESET_DISABLED";
            }
            case 200204: {
                return "MEDIA_POPUP_COPY_SUMMARY_OK";
            }
            case 200203: {
                return "MEDIA_OPT_MLT_LOADING";
            }
            case 200202: {
                return "MEDIA_OPT_MLT_NORESULT";
            }
            case 200212: {
                return "MEDIA_PRESET_LOADING";
            }
            case 200210: {
                return "MEDIA_OPT_PLAYPOSITION_VIDEO_DISCLAIMER_NEW";
            }
            case 200211: {
                return "MEDIA_INVALID_SPI_ACTIVE";
            }
            case 200208: {
                return "MEDIA_OPT_PLAYPOSITION_VIDEO_DISCLAIMER";
            }
            case 200209: {
                return "MEDIA_SAVER_VIDEO_DISCLAIMER_NEW";
            }
            case 300071: {
                return "TEL_OPT_SETUP_PHONE_PIN_REQ_EDIT";
            }
            case 300070: {
                return "TEL_OPT_SETUP_PHONE_PIN_MAIN";
            }
            case 300069: {
                return "TEL_OPT_SETUP_NET_MANUAL";
            }
            case 300068: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_PHONE";
            }
            case 300336: {
                return "TEL_ROLE_CHANGE";
            }
            case 300067: {
                return "OFFICE_OPT_SMS_SETUP_EULA_LONG";
            }
            case 300337: {
                return "TEL_UNLOCK_SIM_MODE_ESIM_ACTIVE";
            }
            case 300065: {
                return "TEL_OPT_SETUP_CALL_DIVERT_ACTIVATE_MAIN";
            }
            case 300064: {
                return "TEL_OPT_SETUP_CALL_DIVERT_MAIN";
            }
            case 300079: {
                return "TEL_OPT_CC_MEMBERS_DELETE_MAIN";
            }
            case 300077: {
                return "TEL_SDS_NUM";
            }
            case 300075: {
                return "TEL_OPT_SETUP_CALL_NUM_MAIN";
            }
            case 300074: {
                return "TEL_OPT_SETUP_PHONE_PIN_CHANGE_NEW2";
            }
            case 300073: {
                return "TEL_OPT_SETUP_PHONE_PIN_CHANGE_NEW1";
            }
            case 300072: {
                return "TEL_OPT_SETUP_PHONE_PIN_CHANGE_OLD";
            }
            case 300086: {
                return "TEL_INTELLICALL_UNKNOWN";
            }
            case 300325: {
                return "TEL_UNLOCK_PUK_WRONG_ASSOCIATED";
            }
            case 300087: {
                return "TEL_INTELLICALL_NO_CALL";
            }
            case 300324: {
                return "TEL_UNLOCK_PIN_WRONG_ASSOCIATED";
            }
            case 300084: {
                return "TEL_POPUP_ERR";
            }
            case 300327: {
                return "TEL_INIT_PHONE_NOT_ATTACHED_MAIN_SIM_NOT_ATTACHED";
            }
            case 300085: {
                return "TEL_POPUP_BATTERY_WARNING";
            }
            case 300326: {
                return "TEL_INIT_PHONE_CARPLAY";
            }
            case 300321: {
                return "TEL_UNLOCK_PUK_PIN_WRONG_ASSOCIATED";
            }
            case 300082: {
                return "OFFICE_OPT_SMS_SETUP_SERVICE_EDIT";
            }
            case 300083: {
                return "TEL_OPT_MAILBOX_DELETE_MAIN";
            }
            case 300320: {
                return "TEL_UNLOCK_PUK_PIN_EDIT_1_ASSOCIATED";
            }
            case 300080: {
                return "TEL_AUDIO_INCOMING_CALL";
            }
            case 300323: {
                return "TEL_UNLOCK_PIN_BLOCKED_ASSOCIATED";
            }
            case 300081: {
                return "TEL_AUDIO_ACTIVE_CALL";
            }
            case 300322: {
                return "TEL_UNLOCK_PIN_SAVE_MAIN_ASSOCIATED";
            }
            case 300332: {
                return "TEL_NUMBER_EDIT_SOS_MAIN";
            }
            case 300329: {
                return "TEL_POPUP_AUDIO";
            }
            case 300328: {
                return "TEL_INIT_PHONE_NOT_ATTACHED_MAIN_NOT_CONNECTED";
            }
            case 300331: {
                return "TEL_OPT_NUMBER_EDIT_MAIN";
            }
            case 300036: {
                return "TEL_UNLOCK_PIN_BLOCKED";
            }
            case 300039: {
                return "TEL_AUDIO_INCOMING_CALL_RINGING_MAIN";
            }
            case 300038: {
                return "TEL_OPT_SETUP_CALL_MAIN";
            }
            case 300033: {
                return "TEL_UNLOCK_PUK_WRONG";
            }
            case 300032: {
                return "TEL_UNLOCK_PUK_WAIT";
            }
            case 300045: {
                return "TEL_INTELLICALL_MAIN";
            }
            case 300318: {
                return "TEL_UNLOCK_PUK_EDIT_ASSOCIATED";
            }
            case 300319: {
                return "TEL_UNLOCK_PUK_PIN_EDIT_2_ASSOCIATED";
            }
            case 300316: {
                return "TEL_INIT_PHONE_NOT_FUNCTIONAL_ASSOCIATED";
            }
            case 300047: {
                return "TEL_OPT_SETUP_INFO_MAIN";
            }
            case 300046: {
                return "TEL_AUDIO_NO_CALL";
            }
            case 300317: {
                return "TEL_UNLOCK_PIN_EDIT_ASSOCIATED";
            }
            case 300041: {
                return "TEL_NUMBER_EDIT_MAIN";
            }
            case 300040: {
                return "TEL_OPT_SETUP_NET_MAIN";
            }
            case 300053: {
                return "SDS_HELP_PHONE_TOPIC_NUMBER_SPELLER";
            }
            case 300054: {
                return "SDS_HELP_PHONE_TOPIC_PIN_SPELLER";
            }
            case 300055: {
                return "TEL_OPT_SETUP_CALL_WAIT_MAIN";
            }
            case 300048: {
                return "SDS_HELP_PHONE_TOPIC_ADB";
            }
            case 300049: {
                return "SDS_HELP_PHONE_TOPIC_DIAL_NUMBER";
            }
            case 300050: {
                return "SDS_HELP_PHONE";
            }
            case 300051: {
                return "SDS_HELP_PHONE_TOPIC_SMS";
            }
            case 300060: {
                return "OFFICE_OPT_SMS_SETUP_EULA_SHORT";
            }
            case 300062: {
                return "TEL_OPT_MAILBOX_EDIT_MAIN";
            }
            case 300063: {
                return "TEL_MAILBOX_NA";
            }
            case 300059: {
                return "OFFICE_OPT_SMS_SETUP_LICENCE_MAIN";
            }
            case 300143: {
                return "TEL_OPT_FAVORITE_STORE_NAME";
            }
            case 300147: {
                return "TEL_OPT_FAVORITE_RENAME_MAIN";
            }
            case 300144: {
                return "TEL_OPT_FAVORITE_STORE_NUMBERS";
            }
            case 300148: {
                return "TEL_FAVORITES_MAIN";
            }
            case 300152: {
                return "TEL_OPT_FAVORITE_DELETE_ALL_MAIN";
            }
            case 300156: {
                return "TEL_SERVICE_INFO";
            }
            case 300157: {
                return "TEL_SERVICE_HELP";
            }
            case 300206: {
                return "TEL_UNLOCK_PIN_WRONG";
            }
            case 300207: {
                return "TEL_UNLOCK_PIN_SAVE_MAIN";
            }
            case 300204: {
                return "TEL_UNLOCK_PIN_WAIT";
            }
            case 300197: {
                return "TEL_INIT_PHONE_NOT_ATTACHED_MAIN_RECONNECT";
            }
            case 300219: {
                return "TEL_SERVICE_MAIN";
            }
            case 300217: {
                return "TEL_ADB_SIM_2";
            }
            case 300216: {
                return "TEL_ADB_SIM_1";
            }
            case 300215: {
                return "TEL_OPT_CALL_LIST_DELETE_ALL_MAIN";
            }
            case 300213: {
                return "TEL_POPUP_AUTOGRAP";
            }
            case 300211: {
                return "TEL_MAILBOX_EDIT";
            }
            case 300209: {
                return "TEL_UNLOCK_PIN_SAVE_OK";
            }
            case 300208: {
                return "TEL_UNLOCK_PIN_SAVE_SIM_MODE";
            }
            case 300172: {
                return "TEL_POPUP_SERVICE_CODE_SAP_ERR";
            }
            case 300173: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US";
            }
            case 300020: {
                return "TEL_INIT_PHONE_NAD_NOT_FUNCTIONAL";
            }
            case 300174: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_WAIT_ACTIVE";
            }
            case 300023: {
                return "TEL_UNLOCK_SIM_NOT_FUNCTIONAL";
            }
            case 300175: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_WAIT_NOT_ACTIVE";
            }
            case 300168: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_DIVERT_NOT_ACTIVE";
            }
            case 300017: {
                return "TEL_INIT_PHONE_DIAGNOSE_OFF";
            }
            case 300169: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_DIVERT_ACTIVE";
            }
            case 300016: {
                return "TEL_INIT_PHONE_OFF";
            }
            case 300170: {
                return "TEL_POPUP_SERVICE_CODE_SAP_REQ";
            }
            case 300019: {
                return "TEL_INIT_PHONE_TEMPERATURE_OFF";
            }
            case 300171: {
                return "TEL_POPUP_SERVICE_CODE_SAP_OK";
            }
            case 300018: {
                return "TEL_INIT_PHONE_NOT_FUNCTIONAL";
            }
            case 300164: {
                return "TEL_POPUP_SERVICE_CODE_HFP";
            }
            case 300028: {
                return "TEL_UNLOCK_PUK_PIN_EDIT_2";
            }
            case 300166: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_NUM_NET";
            }
            case 300031: {
                return "TEL_UNLOCK_PUK_PIN_WRONG";
            }
            case 300167: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_NUM_ACTIVE";
            }
            case 300025: {
                return "TEL_UNLOCK_PIN_EDIT";
            }
            case 300024: {
                return "TEL_UNLOCK_PUK_BLOCKED";
            }
            case 300161: {
                return "TEL_POPUP_MFL_PHONE_NA";
            }
            case 300027: {
                return "TEL_UNLOCK_PUK_PIN_EDIT_1";
            }
            case 300162: {
                return "TEL_POPUP_MFL_CALL_LIST";
            }
            case 300026: {
                return "TEL_UNLOCK_PUK_EDIT";
            }
            case 300004: {
                return "TEL_OPT_SETUP_MAIN";
            }
            case 300005: {
                return "TEL_OPT_SETUP_MODUS_MAIN";
            }
            case 300006: {
                return "TEL_INTELLICALL_MAIN_REDUCED";
            }
            case 300007: {
                return "OFFICE_OPT_SMS_SETUP_MAIN";
            }
            case 300185: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_DIVERT_ACTIVATE_OK";
            }
            case 300000: {
                return "TEL_REF_TEMPLATE";
            }
            case 300184: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_NUM_CANCEL_OK";
            }
            case 300001: {
                return "TEL_INIT_PHONE_NA";
            }
            case 300002: {
                return "TEL_SEL";
            }
            case 300186: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_DIVERT_CANCEL_OK";
            }
            case 300003: {
                return "TEL_OPT";
            }
            case 300181: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_WAIT_ACTIVATE_OK";
            }
            case 300183: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_NUM_ACTIVATE_OK";
            }
            case 300182: {
                return "TEL_POPUP_SERVICE_CODE_SAP_RESULT_US_WAIT_CANCEL_OK";
            }
            case 300015: {
                return "TEL_TEXT_CONSTANT";
            }
            case 300176: {
                return "TEL_POPUP_SERVICE_CODE_SAP_CALL_NUM_NOT_ACTIVE";
            }
            case 300009: {
                return "TEL_INIT_PHONE_WAIT";
            }
            case 300178: {
                return "SDS_PHONE_PICKLIST";
            }
            case 3300043: {
                return "SOS_POPUP_MEC_ACCOMPLISHED";
            }
            case 3300042: {
                return "SOS_POPUP_MEC_REDIAL";
            }
            case 3300041: {
                return "SOS_POPUP_MEC_FAILED_1";
            }
            case 3300040: {
                return "SOS_POPUP_MEC_SENDING_DATA";
            }
            case 3300046: {
                return "SOS_POPUP_REDIAL";
            }
            case 3300045: {
                return "SOS_POPUP_MEC_CANCELED";
            }
            case 3300044: {
                return "SOS_POPUP_MEC_FAILED";
            }
            case 3300035: {
                return "SOS_POPUP_CANCELED";
            }
            case 3300032: {
                return "SOS_POPUP_ACCOMPLISHED";
            }
            case 3300039: {
                return "SOS_POPUP_MEC_CONNECTED";
            }
            case 3300038: {
                return "SOS_POPUP_MEC_CONNECTING";
            }
            case 3300037: {
                return "OPR_POPUP_CANCELED";
            }
            case 3300036: {
                return "SOS_POPUP_FAILED";
            }
            case 3300009: {
                return "OPR_POPUP_CONNECTING";
            }
            case 3300008: {
                return "OPR_POPUP_DATA_SEND";
            }
            case 3300011: {
                return "OPR_POPUP_DISCONNECT";
            }
            case 3300010: {
                return "OPR_POPUP_CONNECTED";
            }
            case 3300005: {
                return "OPR_POPUP_DATA_END_ACTIVE_CALL";
            }
            case 3300007: {
                return "OPR_POPUP_DATA_COLLECT";
            }
            case 3300006: {
                return "SOS_POPUP_ONLINE_LICENSE_NOTE_WEBSHOP";
            }
            case 3300001: {
                return "OPR_POPUP_MANUAL_CONSIERGE";
            }
            case 3300000: {
                return "ECALL_REF_TEMPLATE";
            }
            case 3300003: {
                return "OPR_POPUP_AUTOMATIC";
            }
            case 3300002: {
                return "OPR_POPUP_MANUAL_CALLCENTER";
            }
            case 3300028: {
                return "SOS_POPUP_LICENSE_TEASER_NOTE_WEBSHOP";
            }
            case 3300029: {
                return "SOS_POPUP_LICENSE_TEASER_EXPIRE_NOTE";
            }
            case 3300030: {
                return "SOS_POPUP_LICENSE_TEASER_EXPIRE_NOTE_WEBSHOP";
            }
            case 3300031: {
                return "OPR_POPUP_CALL_FAILED";
            }
            case 3300024: {
                return "SOS_POPUP_ONLINE_LICENSE_NOTE_MAIN";
            }
            case 3300025: {
                return "SOS_POPUP_ONLINE_LICENSE_EXPIRE_NOTE";
            }
            case 3300026: {
                return "SOS_POPUP_ONLINE_LICENSE_EXPIRE_NOTE_WEBSHOP";
            }
            case 3300027: {
                return "SOS_POPUP_LICENSE_TEASER_NOTE_MAIN";
            }
            case 3300020: {
                return "SOS_POPUP_CONNECTED";
            }
            case 3300021: {
                return "SOS_POPUP_SENDING_DATA";
            }
            case 3300022: {
                return "SOS_POPUP_CALLBACK_INCOMING";
            }
            case 3300017: {
                return "OPR_DEST_POPUP_MAIN";
            }
            case 3300018: {
                return "SOS_POPUP_MEC_MAIN";
            }
            case 3300019: {
                return "SOS_POPUP_CONNECTING";
            }
            case 400367: {
                return "DEST_POPUP_NAVI_REMOVED_MAIN";
            }
            case 400364: {
                return "DEST_TPEG_POI_KR_OVERVIEW";
            }
            case 400365: {
                return "DEST_TPEG_POI_KR_RESULTLIST";
            }
            case 400362: {
                return "MAP_MAPVIEW_MAIN_G21";
            }
            case 400363: {
                return "DEST_TPEG_POI_KR_NO_INFO";
            }
            case 400361: {
                return "DEST_SDS_OPT_SEARCH_AREA_PROVINCE_CITY_KR";
            }
            case 400358: {
                return "MAP_OPT_MAP_SETTINGS_ONLINE_TRAFFIC_PPU_CN";
            }
            case 400359: {
                return "MAP_MEKKA_MAIN";
            }
            case 400356: {
                return "DEST_OPT_MYAUDI_SAVE_CONTACTS_OK";
            }
            case 400357: {
                return "DEST_OPT_MYAUDI_SAVE_CONTACTS_FULL";
            }
            case 400354: {
                return "MAP_POPUP_HOV_LANE";
            }
            case 400355: {
                return "DEST_SDS_OPT_SEARCH_AREA_PREFECTURE_CITY_JP";
            }
            case 400353: {
                return "MAP_OPT_ENERGY_ASSIST_MAIN";
            }
            case 400383: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA_CLUSTER_2ND_LEVEL";
            }
            case 400382: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA_CLUSTER_3RD_LEVEL";
            }
            case 400381: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA_3RD_LEVEL";
            }
            case 400380: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA_2ND_LEVEL";
            }
            case 400378: {
                return "TelRefTemplate";
            }
            case 400377: {
                return "DEST_OPT_TPEG_DETAIL_KR_MAIN";
            }
            case 400375: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA_CLUSTER";
            }
            case 400374: {
                return "MAP_OPT_MAP_CONTENT_ASIA_MAIN_CLUSTER";
            }
            case 400373: {
                return "MAP_POPUP_MINI_MAP";
            }
            case 400372: {
                return "MAP_POPUP_SELENA_MAIN";
            }
            case 400371: {
                return "MAP_OPT_SELENA_DELETE_ALL_OK";
            }
            case 400370: {
                return "MAP_OPT_SELENA_DELETE_ALL";
            }
            case 400369: {
                return "MAP_OPT_SELENA_DEACTIVATE";
            }
            case 400368: {
                return "MAP_OPT_SELENA_ACTIVATE";
            }
            case 400349: {
                return "DEST_ADDRESS_GENERAL_WARD_KR";
            }
            case 400348: {
                return "DEST_ONLINEDEST_CONTACT_INFO_MAINDummy";
            }
            case 400345: {
                return "DEST_POPUP_NO_HOME_ADDRESS_XXX";
            }
            case 400344: {
                return "DEST_SDS_OPT_SEARCH_AREA_CITY_CNTW";
            }
            case 400347: {
                return "MAP_MAPVIEW_RG_EVENT_NOTICE_MAP_ASIA";
            }
            case 400346: {
                return "MAP_MAPVIEW_RG_EVENT_NOTICE_INACCESSIBLE_ASIA";
            }
            case 400341: {
                return "DEST_OPT_FAVORITES_LIST_MAIN";
            }
            case 400343: {
                return "DEST_OPT_ONLINE_SEARCH_AREA_ASIA_NEWAREA_CN";
            }
            case 400342: {
                return "DEST_POI_BRAND_MAIN_NO_RESULT";
            }
            case 400264: {
                return "DEST_NAR_COUNTRY";
            }
            case 400265: {
                return "DEST_ADDRESS_NAR_NUMBER";
            }
            case 400266: {
                return "DEST_ADDRESS_NAR_STREET";
            }
            case 400267: {
                return "DEST_ADDRESS_NAR_FOLLOW_UP_MAIN";
            }
            case 400268: {
                return "DEST_INTERSECTION_CROSSING";
            }
            case 400269: {
                return "DEST_POPUP_ADDRESS_NAR_INVALID_NUMBER";
            }
            case 400270: {
                return "DEST_ADDRESS_NAR_STREET_DISAMBUGUATION";
            }
            case 400271: {
                return "DEST_TELEPHONE_NVC_NUMBER_SPELLER_ASIA";
            }
            case 400256: {
                return "DEST_ADDRESS_CITY_WARD_COUNTY_KR";
            }
            case 400257: {
                return "DEST_ADDRESS_NUMBER_KR";
            }
            case 400258: {
                return "DEST_ADDRESS_PROVINCE_METRO_KR";
            }
            case 400259: {
                return "DEST_ADDRESS_TOWN_KR";
            }
            case 400260: {
                return "DEST_ADDRESS_VILLAGE_STREET_KR";
            }
            case 400261: {
                return "DEST_ADDRESS_NAR_FORM_MAIN";
            }
            case 400262: {
                return "DEST_ADDRESS_NAR_CITY";
            }
            case 400281: {
                return "MAP_POPUP_MAP_SCROLL_DISAMBIGUATION_TUNNEL_ASIA";
            }
            case 400280: {
                return "MAP_POPUP_MAP_SCROLL_DISAMBIGUATION_FERRY_ASIA";
            }
            case 400273: {
                return "MAP_POP_MAPVIEW_GUIDANCE_ADJUST_POS_NO_ASIA";
            }
            case 400272: {
                return "DEST_MAPCODE_JP_NVC_NUMBER_SPELLER_ASIA";
            }
            case 400275: {
                return "DEST_SEARCHAREA_NEWAREA_JP_MAIN";
            }
            case 400274: {
                return "MAP_POP_MAPVIEW_GUIDANCE_ADJUST_POS_YES_ASIA";
            }
            case 400277: {
                return "MAP_POPUP_MAP_SCROLL_DISAMBIGUATION_MOTORWAY_ASIA";
            }
            case 400276: {
                return "DEST_SEARCHAREA_NEWAREA_KR_MAIN";
            }
            case 400279: {
                return "MAP_POPUP_MAP_SCROLL_DISAMBIGUATION_BRIDGE_ASIA";
            }
            case 400278: {
                return "MAP_POPUP_MAP_SCROLL_DISAMBIGUATION_TOLL_ASIA";
            }
            case 400231: {
                return "MAP_POPUP_GE_LICENCE_EXPIRED";
            }
            case 400230: {
                return "DEST_POPUP_TRY_BEST_MATCH_NO_RESULT_EDIT";
            }
            case 400228: {
                return "MAP_MAPMODE_GOOGLE_RELOAD";
            }
            case 400225: {
                return "MAP_POPUP_MAPVIEW_STREETVIEW_SNAPSHOT_FULL";
            }
            case 400224: {
                return "MAP_POPUP_MAPVIEW_STREETVIEW_SNAPSHOT_ERROR";
            }
            case 400239: {
                return "MAP_OPT_MAP_WARNING_MAIN_ASIA";
            }
            case 400238: {
                return "MAP_OPT_MAP_CONTENT_DISPLAY_POI_ASIA";
            }
            case 400237: {
                return "MAP_OPT_MAP_CONTENT_ASIA_MAIN";
            }
            case 400233: {
                return "DEST_OPT_SHOW_DETAILS_ONLINE_POI_BROWSER_LOAD";
            }
            case 400232: {
                return "MAP_POPUP_ONLINE_TRAFFIC_LICENCE_EXPIRED";
            }
            case 400247: {
                return "DEST_ADDRESS_CITY_JP";
            }
            case 400244: {
                return "DEST_ADDRESS_NUMBER_CN_TW";
            }
            case 400245: {
                return "DEST_ADDRESS_INTERSECTION_CN_TW";
            }
            case 400242: {
                return "DEST_ADDRESS_CITY_CN_TW";
            }
            case 400243: {
                return "DEST_ADDRESS_STREET_CN_TW";
            }
            case 400240: {
                return "DEST_ADDRESS_FORM_MAIN_CN_TW";
            }
            case 400254: {
                return "MAP_POPUP_DB_MERGE_FINISHED_ASIA";
            }
            case 400255: {
                return "DEST_ADDRESS_FORM_MAIN_KR";
            }
            case 400252: {
                return "DEST_ADDRESS_NUMBER_JP";
            }
            case 400253: {
                return "DEST_ADDRESS_CHOME_JP";
            }
            case 400250: {
                return "DEST_ADDRESS_WARD_JP";
            }
            case 400251: {
                return "DEST_ADDRESS_PLACE_JP";
            }
            case 400248: {
                return "DEST_ADDRESS_FORM_MAIN_JP";
            }
            case 400249: {
                return "DEST_ADDRESS_PREFECTURE_JP";
            }
            case 400196: {
                return "DEST_OPT_SHOW_DETAILS_ONLINE_POI_MAIN";
            }
            case 400199: {
                return "DEST_OPT_ADD_TO_CONTACT_LIST";
            }
            case 400193: {
                return "DEST_INTELLIDEST_NVC_NUMBER_INVALID_CORRECTION";
            }
            case 400192: {
                return "DEST_INTELLIDEST_NVC_NUMBER_INCOMPLETE_MAIN";
            }
            case 400195: {
                return "DEST_INTELLIDEST_REFINE_TRUFFLES_MAIN";
            }
            case 400194: {
                return "DEST_POPUP_TRY_BEST_MATCH_NO_RESULT";
            }
            case 400205: {
                return "MAP_POPUP_ROUTECALC_FAIL_MULTI";
            }
            case 400204: {
                return "MAP_POPUP_ROUTECALC_FAIL_SINGLE";
            }
            case 400206: {
                return "MAP_MAPMODE_GOOGLE_STARTUP_SPLASH";
            }
            case 400200: {
                return "DEST_OPT_ADD_TO_CONTACT_SELECT";
            }
            case 400212: {
                return "MAP_SHOW_DETAILS_GENERIC_SDS_MAIN";
            }
            case 400213: {
                return "DEST_SDS_OPT_SEARCH_AREA_COUNTRY_CITY";
            }
            case 400214: {
                return "MAP_POPUP_MAPMODE_GOOGLE_MESSAGES_OFFLINE";
            }
            case 400215: {
                return "MAP_POPUP_MAPMODE_GOOGLE_NO_DATA";
            }
            case 400208: {
                return "DEST_OPT_CONTACTS";
            }
            case 400209: {
                return "NAV_TEXT_CONSTANT";
            }
            case 400210: {
                return "DEST_OPT_INITIAL_SAVE_AS_FAVORITE_OK";
            }
            case 400211: {
                return "NAV_SDS_POPUP_CONTACT";
            }
            case 400220: {
                return "MAP_POPUP_MAPMODE_TRAFFIC_WARNING_TEMP_ERROR";
            }
            case 400221: {
                return "MAP_POPUP_MAPMODE_TRAFFIC_WARNING_NO_COUNTRY";
            }
            case 400222: {
                return "MAP_POPUP_MAPVIEW_STREETVIEW_DRIVING";
            }
            case 400223: {
                return "MAP_POPUP_MAPVIEW_STREETVIEW_SNAPSHOT_OK";
            }
            case 400216: {
                return "MAP_MAPVIEW_MAIN_G24";
            }
            case 400218: {
                return "MAP_POPUP_MAPMODE_TRAFFIC_WARNING_NO_LICENCE";
            }
            case 400219: {
                return "MAP_POPUP_MAPMODE_TRAFFIC_WARNING_NO_CONNECTION";
            }
            case 400163: {
                return "MAP_OPT_MAP_CONTENT_P_POI_CLUSTER";
            }
            case 400162: {
                return "MAP_OPT_MAP_CONTENT_KML";
            }
            case 400160: {
                return "MAP_OPT_MAP_CONTENT_MAIN_CLUSTER";
            }
            case 400166: {
                return "DEST_FAVORITES_LIST_MAIN";
            }
            case 400165: {
                return "DEST_OPT_DEMO_MODE_LOCATION_OK";
            }
            case 400164: {
                return "MAP_OPT_MAP_CONTENT_KML_CLUSTER";
            }
            case 400168: {
                return "DEST_OPT_SAVE_AS_FAVORITE_NAME";
            }
            case 400175: {
                return "DEST_OPT_POI_WARNING_MAIN";
            }
            case 400174: {
                return "DEST_OPT_SAVE_AS_FAVORITE_OK";
            }
            case 400172: {
                return "DEST_OPT_FAVORITE_EDIT_MAIN";
            }
            case 400176: {
                return "DEST_OPT_POI_WARNING_P_POI";
            }
            case 400177: {
                return "DEST_OPT_SHOW_DETAILS_ONLINE_ERROR";
            }
            case 400182: {
                return "DEST_OPT_POI_WARNING_MAX_1";
            }
            case 400183: {
                return "DEST_OPT_POI_WARNING_MAX_2";
            }
            case 400186: {
                return "MAP_POPUP_SHOW_POI_WARNING_MAIN";
            }
            case 400187: {
                return "SDS_NAV_PICKLIST_POI_RESULTS";
            }
            case 400190: {
                return "DEST_POPUP_NVC_NUMBER_INVALID_MAIN";
            }
            case 400189: {
                return "DEST_INTELLIDEST_NUMBER_INVALID_MAIN";
            }
            case 400128: {
                return "DEST_OPT_DELETE_ALL_LAST_DEST_MAIN";
            }
            case 400133: {
                return "MAP_POPUP_SEMIDYN_BLOCK_MAIN";
            }
            case 400135: {
                return "MAP_ROUTELIST_MAIN";
            }
            case 400134: {
                return "MAP_POPUP_SEMIDYN_BETTER";
            }
            case 400136: {
                return "MAP_ROUTELIST_CALC";
            }
            case 400140: {
                return "MAP_OPT_MAP_CONTENT_MAIN";
            }
            case 400143: {
                return "MAP_OPT_MAP_CONTENT_P_POI";
            }
            case 400148: {
                return "DEST_COORDINATES";
            }
            case 400149: {
                return "DEST_POPUP_DATABASE_INCOMPLETE";
            }
            case 400150: {
                return "MAP_OPT_BLOCK_ACTIVE";
            }
            case 400151: {
                return "MAP_OPT_BLOCK_SET_DISTANCE";
            }
            case 400152: {
                return "DEST_OPT_PARKING_NEAR_DEST";
            }
            case 400153: {
                return "DEST_OPT_PARKING_NEAR_DEST_NO_RESULTS";
            }
            case 400155: {
                return "DEST_OPT_ONLINE_SEARCH_AREA_CITY_MAIN";
            }
            case 400156: {
                return "DEST_OPT_ONLINE_SEARCH_AREA_COUNTRY";
            }
            case 400157: {
                return "DEST_OPT_ONLINE_SEARCH_AREA_CITY";
            }
            case 400125: {
                return "DEST_OPT_SAVE_AS_HOME_OK";
            }
            case 400124: {
                return "DEST_POPUP_DEMO_MODE_ACTIVE";
            }
            case 400127: {
                return "DEST_OPT_DELETE_ALL_FAVORITES_MAIN";
            }
            case 400126: {
                return "DEST_OPT_DELETE_ONLINE_HISTORY_MAIN";
            }
            case 400121: {
                return "ADB_OPT_NAV_EDIT_OK";
            }
            case 400120: {
                return "DEST_POPUP_SETDEST_ONE_DEST";
            }
            case 400113: {
                return "MAP_OPT_CURRENT_POSITION_SAVE";
            }
            case 400108: {
                return "DEST_OPT_COUNTRYINFO_COUNTRY";
            }
            case 400109: {
                return "DEST_ONLINEDEST_CONTACT_INFO_MAIN";
            }
            case 400110: {
                return "MAP_MAPVIEW_SCROLL_STACK_MAIN";
            }
            case 400111: {
                return "MAP_SHOW_DETAILS";
            }
            case 400104: {
                return "MAP_POPUP_GAS_STATION_LIST";
            }
            case 400105: {
                return "MAP_OPT_PREFERED_GAS_STATIONS_MAIN";
            }
            case 400107: {
                return "DEST_OPT_COUNTRYINFO_MAIN";
            }
            case 400100: {
                return "DEST_OPT_HOME_DELETE_MAIN";
            }
            case 400102: {
                return "MAP_OPT_NAVI_GENERAL_SETTINGS_MAIN";
            }
            case 400103: {
                return "MAP_POPUP_GAS_WARNING_MAIN";
            }
            case 400099: {
                return "MAP_SHOW_DETAILS_POI_ADDITIONAL";
            }
            case 400093: {
                return "SDS_NAV_PICKLIST_POI";
            }
            case 400092: {
                return "DEST_ONLINEDEST_CONTACT_MAIN";
            }
            case 400090: {
                return "DEST_ONLINEDEST_LIST_MAIN";
            }
            case 400089: {
                return "MAP_BRIEFING";
            }
            case 400088: {
                return "SDS_NAV_PICKLIST_AI1";
            }
            case 400087: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_MAP";
            }
            case 400086: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_NAVI";
            }
            case 400085: {
                return "DEST_OPT_SELECTION";
            }
            case 400084: {
                return "SDS_HELP_NAV_TOPIC_SPECIAL_DESTINATION";
            }
            case 400083: {
                return "MAP_SEL";
            }
            case 400082: {
                return "DEST_SEL";
            }
            case 400081: {
                return "MAP_OPT";
            }
            case 400080: {
                return "DEST_OPT";
            }
            case 400078: {
                return "DEST_OPT_SHOW_DETAILS_ONLINE_POI_BROWSER_MAIN";
            }
            case 400079: {
                return "DEST_POPUP_SETDEST_TWO_DEST";
            }
            case 400076: {
                return "SDS_HELP_NAV_TOPIC_ENTER_DESTINATION";
            }
            case 400077: {
                return "DEST_OPT_ONLINE_SEARCH_AREA_MAIN";
            }
            case 400074: {
                return "SDS_HELP_NAV_TOPIC_MAP";
            }
            case 400075: {
                return "SDS_HELP_NAV_TOPIC_ROUTE_INFORMATION";
            }
            case 400070: {
                return "DEST_OPT_DEMO_MODE_LOCATION";
            }
            case 400071: {
                return "SDS_HELP_NAV";
            }
            case 400068: {
                return "DEST_POI_CHILD_LIST";
            }
            case 400069: {
                return "DEST_OPT_DEMO_MODE_MAIN";
            }
            case 400067: {
                return "DEST_POI_PARENT_CHILD_MAIN";
            }
            case 400049: {
                return "DEST_ONLINE_SEARCH";
            }
            case 400051: {
                return "DEST_OPT_LAST_DEST";
            }
            case 400050: {
                return "DEST_POI_RESULTLIST_BRAND";
            }
            case 400041: {
                return "DEST_OPT_POI_SEARCHAREA_CITY";
            }
            case 400043: {
                return "DEST_OPT_POI_SEARCHAREA_COUNTRY";
            }
            case 400046: {
                return "DEST_OPT_TRUFFLES_RANGE";
            }
            case 400047: {
                return "DEST_POI_BRAND_MAIN";
            }
            case 400032: {
                return "DEST_POI_SEARCH_MAIN";
            }
            case 400033: {
                return "DEST_POI_SEARCH";
            }
            case 400034: {
                return "DEST_POI_RESULTLIST_MAIN";
            }
            case 400035: {
                return "DEST_POI_RESULTLIST_NO_RESULT";
            }
            case 400036: {
                return "DEST_POI_CLASSES_MAIN";
            }
            case 400037: {
                return "DEST_POI_CATEGORIES";
            }
            case 400038: {
                return "DEST_OPT_POI_SEARCHAREA_MAIN";
            }
            case 400039: {
                return "DEST_OPT_POI_SEARCHAREA_CITY_COUNTRY";
            }
            case 400024: {
                return "DEST_ADDRESS_CITY_REFINEMENT_TP";
            }
            case 400031: {
                return "SDS_NAV_PICKLIST";
            }
            case 400019: {
                return "DEST_ADDRESS_NUMBER";
            }
            case 400018: {
                return "DEST_ADDRESS_STREET";
            }
            case 400017: {
                return "DEST_ADDRESS_CITY_PLZ";
            }
            case 400016: {
                return "DEST_ADDRESS_COUNTRY";
            }
            case 400021: {
                return "DEST_ADDRESS_INTERSECTION";
            }
            case 400011: {
                return "DEST_OPT_CRITERIA_MAIN";
            }
            case 400009: {
                return "MAP_OPT_MAP_SETTINGS";
            }
            case 400015: {
                return "DEST_ADDRESS_FORM_MAIN";
            }
            case 400002: {
                return "MAP_MAPVIEW_MAIN_G22";
            }
            case 400000: {
                return "NAV_REF_TEMPLATE";
            }
            case 400001: {
                return "DEST_INTELLIDEST";
            }
            case 400004: {
                return "DEST_INIT_NAV_NOT_CALIBRATED";
            }
            case 400005: {
                return "DEST_INIT_NAV_ERROR";
            }
            case 500008: {
                return "INFO_TEXT_CONSTANT";
            }
            case 500005: {
                return "MAP_TRAFFIC_NO_MESSAGES";
            }
            case 500004: {
                return "MAP_TRAFFIC_DETAILS_OVERVIEW";
            }
            case 500006: {
                return "MAP_POPUP_SHOW_URGENT_WARNING_MAIN";
            }
            case 500003: {
                return "MAP_TRAFFIC_DETAILS";
            }
            case 500002: {
                return "MAP_TRAFFIC_REF_TEMPLATE";
            }
            case 600140: {
                return "CAR_OPT_AUXHEAT_TIMER2_MAIN";
            }
            case 600141: {
                return "CAR_AUXHEAT_HINTS_PAST";
            }
            case 600138: {
                return "CAR_POPUP_DRIVE_SELECT_LIFT_N_A";
            }
            case 600139: {
                return "CAR_POPUP_DRIVE_SELECT_EFFICIENCY_N_A";
            }
            case 600132: {
                return "CAR_FAS_HUD_ROTATE";
            }
            case 600133: {
                return "CAR_OPT_AUXHEAT_TIMER1_MAIN";
            }
            case 600131: {
                return "CAR_FAS_PEA_MAIN";
            }
            case 600128: {
                return "CAR_POPUP_DRIVING_SCHOOL_MAIN";
            }
            case 600129: {
                return "CAR_OPT_SIA_RESET_REQ";
            }
            case 600151: {
                return "CAR_DRIVE_SELECT_PERFORMANCE";
            }
            case 600150: {
                return "CAR_CARSETTINGS_UGDO_LEAN_BUTTON_ROLL_GROUP_UGDO_SYNC";
            }
            case 600148: {
                return "CAR_CARSETTINGS_EXLIGHT_AUTO_HIGHBEAM";
            }
            case 600146: {
                return "CAR_SERVICE_SIA_MAIN";
            }
            case 600145: {
                return "SETTINGS_POPUP_INSTRUCTION_BOOK_WAITING";
            }
            case 600144: {
                return "BOARDBOOK_OPT";
            }
            case 600043: {
                return "CAR_SEL";
            }
            case 600074: {
                return "CAR_AC_SEATAC_DRIVER";
            }
            case 600042: {
                return "CAR_OPT";
            }
            case 600072: {
                return "CAR_CARSETTINGS_SEAT_CODRIVER_MAPP_MOVE_STEERRIGHT";
            }
            case 600040: {
                return "CAR_CARSETTINGS_SEAT_CODRIVER_SYMM";
            }
            case 600073: {
                return "CAR_AC_SEATAC_SELECTSEAT";
            }
            case 600047: {
                return "MAIN_POPUP_SHOWROOM";
            }
            case 600046: {
                return "MAIN_POPUP_SYSTEM_THEFT_PROTECTION";
            }
            case 600045: {
                return "MAIN_POPUP_SYSTEM_TEL_MAX_WARNING";
            }
            case 600076: {
                return "CAR_AC_SEATAC_CODRIVER";
            }
            case 600044: {
                return "CAR_DRIVE_SELECT";
            }
            case 600066: {
                return "CAR_SERVICE_RKA_PROGRESS";
            }
            case 600035: {
                return "CAR_AUXHEAT_HINTS_ACTUAL";
            }
            case 600067: {
                return "CAR_SERVICE_RKA_ERROR";
            }
            case 600034: {
                return "CAR_AUXHEAT_NOW";
            }
            case 600064: {
                return "CAR_SERVICE_RDK_HIGH_TIRE_CHANGED";
            }
            case 600033: {
                return "CAR_AUXHEAT_MAIN";
            }
            case 600065: {
                return "CAR_SERVICE_RKA_CONFIRM";
            }
            case 600032: {
                return "CAR_AC_MAIN";
            }
            case 600039: {
                return "CAR_CARSETTINGS_SEAT_CODRIVER_MAIN";
            }
            case 600071: {
                return "CAR_CARSETTINGS_SEAT_CODRIVER_MAPP_MOVE_STEERLEFT";
            }
            case 600068: {
                return "CAR_SERVICE_CLEANDIESEL";
            }
            case 600069: {
                return "CAR_SEARCH_RESULTS";
            }
            case 600036: {
                return "CAR_SERVICE_OIL";
            }
            case 600091: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ERROR";
            }
            case 600058: {
                return "CAR_AC_SEATHEATING_REAR_DRIVER";
            }
            case 600090: {
                return "CAR_CARSETTINGS_UGDO_DELETE_MAIN";
            }
            case 600059: {
                return "CAR_AC_SEATHEATING_REAR_CODRIVER";
            }
            case 600089: {
                return "CAR_CARSETTINGS_UGDO_LEARN";
            }
            case 600056: {
                return "CAR_AC_SEATHEATING_DRIVER";
            }
            case 600088: {
                return "CAR_CARSETTINGS_UGDO_MAIN";
            }
            case 600057: {
                return "CAR_AC_SEATHEATING_CODRIVER";
            }
            case 600095: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_ERROR";
            }
            case 600062: {
                return "CAR_SERVICE_RKA_SAVE";
            }
            case 600094: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_MAIN_LEFT";
            }
            case 600063: {
                return "CAR_SERVICE_RDK_HIGH_DISPLAY";
            }
            case 600093: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_FIX_SUCCESS";
            }
            case 600060: {
                return "CAR_SERVICE_RKA_MAIN";
            }
            case 600092: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_CANCEL";
            }
            case 600061: {
                return "CAR_SERVICE_RDK_HIGH_MAIN";
            }
            case 600083: {
                return "CAR_AC_SEATAC_REAR_DRIVER";
            }
            case 600051: {
                return "CAR_FAS_VZE_MAIN";
            }
            case 600080: {
                return "CAR_AC_SEATAC_REAR_CODRIVER";
            }
            case 600087: {
                return "CAR_POPUP_UGDO_SYNC_VISIBLE";
            }
            case 600054: {
                return "CAR_AC_FEETTEMP";
            }
            case 600055: {
                return "CAR_SEATHEATING_SELECTSEAT";
            }
            case 600086: {
                return "CAR_POPUP_UGDO_LEARN_VISIBLE";
            }
            case 600052: {
                return "CAR_FAS_VZE_TRAILER_Vmax";
            }
            case 600053: {
                return "CAR_SERVICE_INFO_MAIN";
            }
            case 600104: {
                return "CAR_HINTS_CAR_N_A";
            }
            case 600009: {
                return "CAR_FAS_NV_CONTRAST";
            }
            case 600105: {
                return "CarMainMMIKombi";
            }
            case 600008: {
                return "CAR_FAS_PARKING_MAIN";
            }
            case 600106: {
                return "SETTINGS_POPUP_INSTRUCTION_BOOK_MAIN";
            }
            case 600011: {
                return "CAR_FAS_HUD_BRIGHTNESS";
            }
            case 600107: {
                return "SETTINGS_POPUP_INSTRUCTION_BOOK_MAIN_DISCLAIMER";
            }
            case 600010: {
                return "CAR_FAS_HUD_MAIN";
            }
            case 600108: {
                return "SETTINGS_POPUP_INSTRUCTION_BOOK_MAIN_EMPTY";
            }
            case 600013: {
                return "CAR_FAS_ACC_MAIN";
            }
            case 600109: {
                return "CAR_DRIVE_SELECT_MODE_CHANGE";
            }
            case 600012: {
                return "CAR_FAS_HUD_CONTENT";
            }
            case 600015: {
                return "CAR_FAS_PRE_SENSE_CONFIRM";
            }
            case 600111: {
                return "SDS_HELP_CAR";
            }
            case 600014: {
                return "CAR_FAS_PRE_SENSE_MAIN_ONOFF";
            }
            case 600096: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_CANCEL";
            }
            case 600001: {
                return "CAR_FAS_MAIN";
            }
            case 600097: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_SUCCESS";
            }
            case 600000: {
                return "CAR_REF_TEMPLATE";
            }
            case 600098: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_PRESS_BUTTON";
            }
            case 600003: {
                return "CAR_SERVICE_MAIN";
            }
            case 600099: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_TRYSECOND";
            }
            case 600002: {
                return "CAR_CARSETTINGS_MAIN";
            }
            case 600100: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_TRYFIRST";
            }
            case 600101: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_WRONGBUTTON";
            }
            case 600102: {
                return "CAR_CARSETTINGS_UGDO_LEARN_BUTTON_ROLL_CHECK";
            }
            case 600007: {
                return "CAR_FAS_SPEEDWARNING_SPEED";
            }
            case 600006: {
                return "CAR_FAS_SPEEDWARNING_MAIN";
            }
            case 600121: {
                return "CAR_OPT_INTLIGHT_COLOR_MARKERLIGHT_MAIN";
            }
            case 600024: {
                return "CAR_CARSETTINGS_SEAT_NORMAL";
            }
            case 600120: {
                return "CAR_OPT_INTLIGHT_COLOR_INTLIGHT_MAIN";
            }
            case 600025: {
                return "CAR_CARSETTINGS_SEAT_DRIVER";
            }
            case 600026: {
                return "CAR_CARSETTINGS_EXTLIGHT_MAIN";
            }
            case 600027: {
                return "CAR_CARSETTINGS_EXLIGHT_AUTO";
            }
            case 600122: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_CAR";
            }
            case 600028: {
                return "CAR_CARSETTINGS_INTLIGHT_MAIN";
            }
            case 600029: {
                return "CAR_CARSETTINGS_INTLIGHT_BRIGHTNESS";
            }
            case 600030: {
                return "CAR_CARSETTINGS_INTLIGHT_ONE_BRIGHTNESS";
            }
            case 600031: {
                return "CAR_CARSETTINGS_LOCK_MAIN";
            }
            case 600113: {
                return "CAR_FAS_PRE_SENSE_MAIN_OLD";
            }
            case 600016: {
                return "CAR_FAS_SWA_MAIN_BRIGHTNESS";
            }
            case 600112: {
                return "SETTINGS_POPUP_INSTRUCTION_BOOK_VIDEO";
            }
            case 600017: {
                return "CAR_FAS_SWA_MAIN_SYSTEM";
            }
            case 600115: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_COCKPIT_MAIN";
            }
            case 600018: {
                return "CAR_FAS_ABSTAND_MAIN";
            }
            case 600114: {
                return "CAR_POPUP_VISIBLE";
            }
            case 600019: {
                return "CAR_FAS_ALA_MAIN";
            }
            case 600117: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_FOOTWELL_MAIN";
            }
            case 600116: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_DOOR_MAIN";
            }
            case 600021: {
                return "CAR_CARSETTINGS_JOKER_SELECT";
            }
            case 600119: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_MAKERLIGHT_MAIN";
            }
            case 600022: {
                return "CAR_CARSETTINGS_SEAT_MAIN";
            }
            case 600118: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_ROOF_MAIN";
            }
            case 600023: {
                return "CAR_CARSETTINGS_SEAT_REAR";
            }
            case 600262: {
                return "CAR_STATISTICS_RESET_REQ";
            }
            case 600261: {
                return "CAR_STATISTICS_PHEV";
            }
            case 600260: {
                return "CAR_STATISTICS_HEV";
            }
            case 600259: {
                return "CAR_AUXAC_HINTS_PAST";
            }
            case 600257: {
                return "CAR_FAS_PEA_FEEDBACK";
            }
            case 600270: {
                return "CAR_STATISTICS_PHEV2";
            }
            case 600268: {
                return "CAR_AC_FEETTEMP_SELECTSEAT";
            }
            case 600267: {
                return "CAR_AC_FEETTEMP_CODRIVER";
            }
            case 600266: {
                return "CAR_AC_FEETTEMP_DRIVER";
            }
            case 600276: {
                return "CAR_AUXCOMBINED_MAIN";
            }
            case 600286: {
                return "CAR_CARSETTINGS_FAHRPEDAL_MAIN";
            }
            case 600287: {
                return "CAR_AUXCOMBINED_HINTS_PAST";
            }
            case 600284: {
                return "CAR_CHARGE_HINTS_PAST_ERROR";
            }
            case 600285: {
                return "CAR_CHARGE_HINTS_ACTUAL_ERROR";
            }
            case 600280: {
                return "CAR_CHARGE_MAIN";
            }
            case 600293: {
                return "CAR_AUXCOMBINED_ELEC_STHZ_BOTH";
            }
            case 600295: {
                return "CAR_FAS_PRE_SENSE_CONFIRM_TEST";
            }
            case 600294: {
                return "CAR_OPT_AUXCOMB_HINTS_RUNNING_BATTERY_FUEL";
            }
            case 600289: {
                return "CAR_SPORT_MAIN";
            }
            case 600288: {
                return "CAR_OPT_INTLIGHT_BRIGHTNESS_ZONE_SURFACE_MAIN";
            }
            case 600291: {
                return "CAR_CARSETTINGS_UGDO_VERSION";
            }
            case 600290: {
                return "CAR_FAS_ACC_PREDICTIVE";
            }
            case 600301: {
                return "CAR_AUXAC_MAIN_SETTINGS_INDOOR_ZONES";
            }
            case 600300: {
                return "CAR_AUXAC_MAIN_SETTINGS";
            }
            case 600303: {
                return "CAR_AUXCOMBINED_MAIN_SETTINGS_INDOOR_ZONES";
            }
            case 600302: {
                return "CAR_AUXCOMBINED_MAIN_SETTINGS";
            }
            case 600296: {
                return "CAR_STATISTICS_RANGE_MONITOR";
            }
            case 600298: {
                return "CAR_POPUP_AUXAC";
            }
            case 600249: {
                return "CAR_AUXAC_MAIN";
            }
            case 700027: {
                return "ADB_OPT_SETUP_EXPORT_MAIN";
            }
            case 700055: {
                return "ADB_OPT_DELETE_SINGLE_OK";
            }
            case 700024: {
                return "ADB_OPT_CALL_MAIN";
            }
            case 700025: {
                return "ADB_OPT_NAVIGATE_MAIN";
            }
            case 700030: {
                return "ADB_OPT_SETUP_EXPORT_PROCESS_END";
            }
            case 700031: {
                return "ADB_OPT_SETUP_IMPORT_LIST_MAIN";
            }
            case 700029: {
                return "ADB_OPT_SETUP_EXPORT_PROCESS_WAIT";
            }
            case 700018: {
                return "TEL_SDS_CONTACT";
            }
            case 700017: {
                return "ADB_POPUP_DOWNLOAD_ERROR";
            }
            case 700023: {
                return "SDS_ADB_PICKLIST_NAVIGATE_NAME";
            }
            case 700056: {
                return "ADB_OPT_NAV_CREATE_FROM_POSTAL";
            }
            case 700059: {
                return "ADB_DESKTOP_WAIT";
            }
            case 700020: {
                return "ADB_OPT";
            }
            case 700011: {
                return "ADB_OPT_SETUP_IMPORT_MAIN";
            }
            case 700010: {
                return "ADB_OPT_SETUP_DOWNLOAD_MAIN";
            }
            case 700015: {
                return "SDS_ADB_PICKLIST_NAME";
            }
            case 700032: {
                return "ADB_OPT_SETUP_IMPORT_PROCESS_END";
            }
            case 700033: {
                return "ADB_OPT_SETUP_IMPORT_PROCESS_WAIT";
            }
            case 700013: {
                return "ADB_OPT_SETUP_EXPORT_LIST_MAIN";
            }
            case 700012: {
                return "ADB_MAIN";
            }
            case 700045: {
                return "ADB_SDS_POPUP_CONTACT";
            }
            case 700000: {
                return "ADB_MODUL_REF_TEMPLATE";
            }
            case 700007: {
                return "ADB_OPT_SETUP_MEMORY_MAIN";
            }
            case 700006: {
                return "ADB_OPT_SETUP_MAIN";
            }
            case 700005: {
                return "ADB_OPT_DETAILVIEW_MAIN";
            }
            case 800020: {
                return "TPEG_KR_INFO_OPI_DETAIL";
            }
            case 800023: {
                return "PP_TPEG_SIMPLE_MAP_BOOKMARK_FULL_OK";
            }
            case 800022: {
                return "TPEG_KR_WEATHER_OTHERLOCATION_SELECTION";
            }
            case 800017: {
                return "TPEG_KR_INFO_NEWS_DETAILS";
            }
            case 800016: {
                return "TPEG_KR_INFO_NEWS_NORESULT";
            }
            case 800018: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_KR_MAP_EACH";
            }
            case 800025: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_SDS";
            }
            case 800004: {
                return "TPEG_KR_INFO_NEWS_CATEGORY";
            }
            case 800005: {
                return "TPEG_KR_INFO_WEATHER_LOC85";
            }
            case 800006: {
                return "TPEG_KR_INFO_OPT";
            }
            case 800007: {
                return "TPEG_KR_INFO_SEL";
            }
            case 800003: {
                return "TPEG_KR_INFO_OPI_NORESULT";
            }
            case 800012: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_KR_FREE_SELECTION";
            }
            case 800013: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_KR_SELECT_1";
            }
            case 800014: {
                return "TPEG_KR_INFO_NEWS_HEADLINES";
            }
            case 800015: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_KR_SELECT_2";
            }
            case 800008: {
                return "TPEG_KR_INFO_REF_TEMPLATE";
            }
            case 800009: {
                return "TPEG_KR_SM_REF_TEMPLATE";
            }
            case 800010: {
                return "TPEG_KR_SM_MAP_TPEG_SIMPLE_MAP_KR_MAIN";
            }
            case 800011: {
                return "TPEG_KR_INFO_OPI_LIST";
            }
            case 900018: {
                return "MAP_VICS_TEXT_CONSTANT";
            }
            case 900017: {
                return "MAP_VICS_TRAFFIC_DETAILS_JP";
            }
            case 900016: {
                return "MAP_POPUP_VICS_DSRC_FIGURE_JP";
            }
            case 900023: {
                return "MAP_SHOW_DETAILS_VICS_GEN2_MAIN";
            }
            case 900022: {
                return "MAP_POPUP_VICS_GEN2_EMERGENCY_JP_MAIN";
            }
            case 900010: {
                return "MAP_VICS_MAIN_JP_FM_TEXT_MAIN";
            }
            case 900009: {
                return "MAP_VICS_MAIN_JP_FM_FIGURE_MAIN";
            }
            case 900014: {
                return "MAP_OPT_VICS_SETUP_JP_POPUP_MSG";
            }
            case 900015: {
                return "MAP_OPT_VICS_SETUP_JP_STATION_FREQ";
            }
            case 900012: {
                return "MAP_VICS_MAIN_JP_EMERGENCY_HISTORY";
            }
            case 900013: {
                return "MAP_OPT_VICS_SETUP_JP_MAIN";
            }
            case 900002: {
                return "MAP_VICS_MAIN_JP_BEACON_FIGURE_HISTORY";
            }
            case 900003: {
                return "MAP_VICS_MAIN_JP_NO_DATA";
            }
            case 900000: {
                return "MAP_VICS_REF_TEMPLATE";
            }
            case 900001: {
                return "MAP_VICS_MAIN_JP_MENU";
            }
            case 900005: {
                return "MAP_POPUP_DSRC_TTS_PPU_JP";
            }
            case 1000027: {
                return "TONE_TEL_RINGTONE_MAIN";
            }
            case 1000026: {
                return "TONE_TEL_MIC_INPUT_MAIN";
            }
            case 1000025: {
                return "TONE_TEL_VOL_MESSAGE";
            }
            case 1000024: {
                return "TONE_TEL_VOL_RINGTONE_MAIN";
            }
            case 1000028: {
                return "TONE_PARK_MAIN";
            }
            case 1000019: {
                return "TONE_TA_SLIDER";
            }
            case 1000018: {
                return "TONE_TA_MAIN";
            }
            case 1000017: {
                return "TONE_SDS_MAIN";
            }
            case 1000016: {
                return "TONE_SDS_SLIDER";
            }
            case 1000023: {
                return "TONE_TEL_MAIN";
            }
            case 1000020: {
                return "TONE_NAVI_MAIN";
            }
            case 1000071: {
                return "TONE_TEXT_CONST_SDS";
            }
            case 1000010: {
                return "TONE_SOUND_SUBWOOFER";
            }
            case 1000070: {
                return "TONE_INFO_VOLUME_MAIN";
            }
            case 1000011: {
                return "TONE_SOUND_GALA";
            }
            case 1000069: {
                return "TONE_WC_SLIDER";
            }
            case 1000008: {
                return "TONE_SOUND_BASS";
            }
            case 1000068: {
                return "TONE_WC_MAIN";
            }
            case 1000009: {
                return "TONE_SOUND_TREBLE";
            }
            case 1000067: {
                return "TONE_TOUCH_SLIDER_INIT";
            }
            case 1000014: {
                return "TONE_SOUND_EFFECT_LEVEL";
            }
            case 1000015: {
                return "TONE_TOUCH_SLIDER";
            }
            case 1000012: {
                return "TONE_SOUND_BAL_FAD";
            }
            case 1000002: {
                return "TONE_SEL";
            }
            case 1000000: {
                return "TONE_REF_TEMPLATE";
            }
            case 1000006: {
                return "TONE_SOUND_EFFECT_MAIN";
            }
            case 1000073: {
                return "TONE_VEHICLEREADY_MAIN";
            }
            case 1000072: {
                return "TONE_INFO_VOLUME_INIT";
            }
            case 1000005: {
                return "TONE_SOUND_MAIN";
            }
            case 1000041: {
                return "TONE_TEXT_CONST";
            }
            case 1000045: {
                return "TONE_NAVI_VOLUME_MAIN";
            }
            case 1000046: {
                return "TONE_SOUND_BAL_ONLY";
            }
            case 1000034: {
                return "TONE_HEARTBEAT_MAIN";
            }
            case 1100056: {
                return "MAIN_POPUP_SOMMER_TIME";
            }
            case 1100057: {
                return "SETTINGS_VERSION_SOFTWARE_INFO";
            }
            case 1100059: {
                return "SETTINGS_SDS_TRAINING_START";
            }
            case 1100053: {
                return "ETC_POPUP_ERROR_JP";
            }
            case 1100054: {
                return "ETC_POPUP_PASS_GATE_JP";
            }
            case 1100055: {
                return "MAIN_POPUP_TIMEZONE";
            }
            case 1100048: {
                return "ETC_POPUP_NO_CARD_INSERTED_JP_MAIN";
            }
            case 1100049: {
                return "ETC_POPUP_CARD_STILL_INSERT_JP_MAIN";
            }
            case 1100044: {
                return "ETC_SETTINGS_MAIN";
            }
            case 1100047: {
                return "ETC_HARDWARE_MAIN";
            }
            case 1100046: {
                return "ETC_HISTORY_DETAIL";
            }
            case 1100041: {
                return "SETTINGS_SYSTEM_MAIN";
            }
            case 1100040: {
                return "SETTINGS_MMI_MAIN";
            }
            case 1100039: {
                return "SETTINGS_RSE_MAIN";
            }
            case 1100035: {
                return "SETTINGS_SDS_TRAINING_STOP";
            }
            case 1100034: {
                return "SETTINGS_VERSION_SOFTWARE_INFO_HIGH";
            }
            case 1100000: {
                return "SETTINGS_SEL";
            }
            case 1100002: {
                return "SETTINGS_REF_TEMPLATE";
            }
            case 1100004: {
                return "SETTINGS_LANGUAGE_MAIN";
            }
            case 1100005: {
                return "SETTINGS_UNITS_MAIN";
            }
            case 1100006: {
                return "SETTINGS_SDS_MAIN";
            }
            case 1100007: {
                return "SETTINGS_FACTORY_MAIN";
            }
            case 1100008: {
                return "SETTINGS_FACTORY_RESET";
            }
            case 1100009: {
                return "SETTINGS_TIME_MAIN";
            }
            case 1100010: {
                return "SETTINGS_SDS_TRAINING_MAIN";
            }
            case 1100011: {
                return "SETTINGS_SDS_TRAINING_RESET";
            }
            case 1100082: {
                return "ETC_DESKTOP_WITH_HISTORY_MAIN";
            }
            case 1100012: {
                return "SETTINGS_SDS_TRAINING_ERROR";
            }
            case 1100013: {
                return "SETTINGS_SDS_TRAINING_END";
            }
            case 1100081: {
                return "SETTINGS_OPT";
            }
            case 1100079: {
                return "SETTINGS_FACTORY_RESET_REBOOT";
            }
            case 1100017: {
                return "SETTINGS_VERSION_NAV_DB_COUNTRIES";
            }
            case 1100016: {
                return "SETTINGS_VERSION_MAIN";
            }
            case 1100019: {
                return "SETTINGS_SCREENBRIGHTNESS_MAIN";
            }
            case 1100076: {
                return "SETTINGS_WIRELESS_CHARGING_MAIN";
            }
            case 1100075: {
                return "SETTINGS_TEXT_CONSTANT";
            }
            case 1100020: {
                return "SETTINGS_SDS_VOLUME";
            }
            case 1100023: {
                return "SETTINGS_USER_HINTS_MAIN";
            }
            case 1100025: {
                return "SETTINGS_RESET_DRIVER_MENU";
            }
            case 1100024: {
                return "SETTINGS_USER_HINTS_SET";
            }
            case 1100026: {
                return "SETTINGS_RESET_DRIVER_REQUEST";
            }
            case 1100028: {
                return "SETTINGS_TIME_TIMEZONE";
            }
            case 1300003: {
                return "engModeSystemMain";
            }
            case 1300002: {
                return "engModeMain";
            }
            case 1300001: {
                return "engErrMeta";
            }
            case 1300000: {
                return "EngRefTemplate";
            }
            case 1300007: {
                return "engFSCInfosLogging";
            }
            case 1300006: {
                return "engSettingsMain";
            }
            case 1300005: {
                return "engFSCMenu";
            }
            case 1300004: {
                return "engFSCImportExportKeys";
            }
            case 1300011: {
                return "engFSCDetailsInstalledSupported";
            }
            case 1300010: {
                return "engFSCImExSummary";
            }
            case 1300009: {
                return "engFSCImExError";
            }
            case 1300008: {
                return "engFSCImExProgress";
            }
            case 1300015: {
                return "ENG_SEL";
            }
            case 1300014: {
                return "engModeApplConfigBundles";
            }
            case 1300013: {
                return "engModeApplConfigSWConfig";
            }
            case 1300012: {
                return "engModeApplConfig";
            }
            case 1300018: {
                return "engSettingsChooseMedia";
            }
            case 1300019: {
                return "engSettingsProgressIndication";
            }
            case 1300022: {
                return "engEbmenuLogging";
            }
            case 1300023: {
                return "engEbmenuLoggingCategory";
            }
            case 1300020: {
                return "engSettingsImportResults";
            }
            case 1300021: {
                return "engEbmenuMain";
            }
            case 1300026: {
                return "engFSCLoggingMain";
            }
            case 1300027: {
                return "engModeInformation";
            }
            case 1300024: {
                return "engEbmenuLoggingName";
            }
            case 1300025: {
                return "engEbmenuMngJxe";
            }
            case 1300028: {
                return "ENG_TEXT_CONST";
            }
            case 1300029: {
                return "engFSCLoggingMainError";
            }
            case 1700074: {
                return "swdlDowngradeDetection";
            }
            case 1700073: {
                return "swdlStartAbortDownloadUpdateRunning";
            }
            case 1700072: {
                return "swdlSelectModuleNoRD";
            }
            case 1700079: {
                return "SETTINGS_POPUP_GEN_NEW_DATA_AVAILABLE";
            }
            case 1700078: {
                return "SETTINGS_POPUP_NAVI_LICENCE_GETTTING_INVALID";
            }
            case 1700077: {
                return "SETTINGS_POPUP_NAVI_NEW_DATA_AVAILABLE_LICENCE_NOT_AVAILABLE";
            }
            case 1700076: {
                return "SETTINGS_POPUP_UPDATE_ONLINE_NEW_DATA_AVAILABLE_LICENCE_AVAILABLE";
            }
            case 1700067: {
                return "SETTINGS_UPDATE_SOURCE_DATA_OK_NAV_DB_COUNTRY";
            }
            case 1700066: {
                return "SETTINGS_UPDATE_SOURCE_ACCESS_FAILURE";
            }
            case 1700071: {
                return "swdlSelectAppBlNoRD";
            }
            case 1700070: {
                return "swdlSelectCompNoRD";
            }
            case 1700068: {
                return "SETTINGS_UPDATE_SOURCE_DATA_OK_NAV_DB_ADDITIONAL_COUNTRIES";
            }
            case 1700090: {
                return "SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL_DISCLAIMER";
            }
            case 1700091: {
                return "SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL";
            }
            case 1700088: {
                return "SETTINGS_UPDATE_SOURCE";
            }
            case 1700089: {
                return "SETTINGS_UPDATE_PROGRESS_PROCESS_BAR";
            }
            case 1700082: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_DOWNLOAD_FAILURE_RETRY_POSSIBLE";
            }
            case 1700083: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_DOWNLOAD_FAILURE";
            }
            case 1700081: {
                return "SWDL_TEXT_CONSTANT";
            }
            case 1700086: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_INCOMPATIBLE_DATA";
            }
            case 1700087: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_SERVER_FAILURE";
            }
            case 1700084: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_ACCESS_FAILURE";
            }
            case 1700085: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_NO_DATA";
            }
            case 1700041: {
                return "swdlListIncompDev";
            }
            case 1700040: {
                return "swdlSummaryFileDetails";
            }
            case 1700042: {
                return "swdlInconsistentUpdate";
            }
            case 1700047: {
                return "SETTINGS_POPUP_UPDATE_GENERAL_SUMMARY_SUCCESSFUL";
            }
            case 1700046: {
                return "SETTINGS_POPUP_UPDATE_GENERAL_SUMMARY_FAILURE";
            }
            case 1700033: {
                return "swdlLogPreSelectModule";
            }
            case 1700032: {
                return "swdlLogDeviceSelection";
            }
            case 1700035: {
                return "swdlLogUnusualEvents";
            }
            case 1700034: {
                return "swdlLogPreSelectAppBl";
            }
            case 1700037: {
                return "swdlLogPostSelectModule";
            }
            case 1700036: {
                return "swdlLogUnusualEventsDetails";
            }
            case 1700039: {
                return "swdlLogPostSelectAppBl";
            }
            case 1700038: {
                return "swdlLogDeviceErrors";
            }
            case 1700057: {
                return "swdlProgressDetails";
            }
            case 1700060: {
                return "SETTINGS_UPDATE_ONLINE_SOURCE_DATA_OK_START";
            }
            case 1700061: {
                return "SETTINGS_UPDATE_DOWNLOAD";
            }
            case 1700062: {
                return "SETTINGS_UPDATE_SOURCE_DATA_OK_NAV_DB_COUNTRY_CONF";
            }
            case 1700063: {
                return "SETTINGS_UPDATE_DOWNLOAD_INTERRUPTION";
            }
            case 1700048: {
                return "SETTINGS_POPUP_UPDATE_GENERAL_SUMMARY_INTERRUPT_SD";
            }
            case 1700049: {
                return "SETTINGS_UPDATE_SOURCE_READ";
            }
            case 1700050: {
                return "SETTINGS_UPDATE_SOURCE_DATA_OK_START";
            }
            case 1700051: {
                return "SETTINGS_UPDATE_SOURCE_INCOMPATIBLE_DATA";
            }
            case 1700052: {
                return "SETTINGS_UPDATE_SOURCE_NO_DATA";
            }
            case 1700053: {
                return "SETTINGS_UPDATE_SOURCE_NOT_ACTIVATED";
            }
            case 1700054: {
                return "SETTINGS_POPUP_UPDATE_SOURCE_CONFIRMATION";
            }
            case 1700055: {
                return "swdlInternalInit";
            }
            case 1700015: {
                return "SWDL_OPT";
            }
            case 1700013: {
                return "swdlSummary";
            }
            case 1700012: {
                return "swdlProgress";
            }
            case 1700145: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_UOTASERVER_FAILURE";
            }
            case 1700011: {
                return "swdlReboot";
            }
            case 1700144: {
                return "SETTINGS_POPUP_UPDATE_PERSONALIZE";
            }
            case 1700010: {
                return "swdlStartAbortDownload";
            }
            case 1700009: {
                return "swdlSelectComp";
            }
            case 1700146: {
                return "SETTINGS_POPUP_ONLINE_UPDATE_NO_SERVICE";
            }
            case 1700008: {
                return "swdlSelectUpdate";
            }
            case 1700007: {
                return "swdlErrMeta";
            }
            case 1700006: {
                return "swdlReadMetaInfo";
            }
            case 1700005: {
                return "swdlSelectRelease";
            }
            case 1700004: {
                return "swdlErrRelease";
            }
            case 1700003: {
                return "swdlReadReleaseInfo";
            }
            case 1700001: {
                return "swdlSelectMedium";
            }
            case 1700000: {
                return "SWDL_REF_TEMPLATE";
            }
            case 1700030: {
                return "swdlLogOverview";
            }
            case 1700031: {
                return "swdlLogGeneral";
            }
            case 1700028: {
                return "swdlLogDownloads";
            }
            case 1700029: {
                return "swdlLogSequential";
            }
            case 1700026: {
                return "swdlSummaryModText";
            }
            case 1700027: {
                return "swdlSummaryModDeviceErrors";
            }
            case 1700024: {
                return "swdlSummaryMod";
            }
            case 1700025: {
                return "swdlSummaryModDetail";
            }
            case 1700140: {
                return "SETTINGS_POPUP_UPDATE_ONLINE_PROPOSAL_TRAVEL_NEW_DATA_AVAILABLE_LICENCE";
            }
            case 1700022: {
                return "swdlSelectModule";
            }
            case 1700141: {
                return "SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL_DESTINATION";
            }
            case 1700023: {
                return "swdlSelectAppBl";
            }
            case 1700142: {
                return "SETTINGS_POPUP_UPDATE_NAV_DB_SUMMARY_UOTA_SUCCESSFUL";
            }
            case 1700020: {
                return "swdlSummaryChanged";
            }
            case 1700143: {
                return "SETTINGS_POPUP_UPDATE_PPOI_SUMMARY_UOTA_SUCCESSFUL";
            }
            case 1700021: {
                return "swdlPopup";
            }
            case 1700018: {
                return "swdlVersionUploadResult";
            }
            case 1700019: {
                return "swdlReadMetaProgress";
            }
            case 1700016: {
                return "swdlWaitForLostDevices";
            }
            case 1700017: {
                return "swdlStartVersionUpload";
            }
            case 1600000: {
                return "mainScreen";
            }
            case 1600001: {
                return "gem";
            }
            case 2100036: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_PLA_SELECTION";
            }
            case 2100037: {
                return "CAR_POPUP_PARKING_VISIBLE";
            }
            case 2100038: {
                return "CAR_POPUP_PARKING_PLA_TEXT_OK";
            }
            case 2100035: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_OPS_LEFT";
            }
            case 2100044: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_OPS_CENTER";
            }
            case 2100045: {
                return "CAR_POPUP_SOCCONTROL_MAIN";
            }
            case 2100047: {
                return "EARLY_APPS_REF_TEMPLATE";
            }
            case 2100040: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_OPS_RIGHT";
            }
            case 2100042: {
                return "CAR_POPUP_CHARGE_END_INVISIBLE";
            }
            case 2100043: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_PLA_OUT";
            }
            case 2100061: {
                return "CAR_OPT_CHARGE_TIMER2_MAIN";
            }
            case 2100060: {
                return "CAR_OPT_CHARGE_TIMER1_WEEKDAYS";
            }
            case 2100063: {
                return "CAR_OPT_AUXAC_TIMER1_MAIN";
            }
            case 2100062: {
                return "CAR_OPT_CHARGE_TIMER2_WEEKDAYS";
            }
            case 2100059: {
                return "CAR_OPT_CHARGE_TIMER1_MAIN";
            }
            case 2100070: {
                return "CAR_POPUP_CHARGE_END_INVISIBLE_A3MQB";
            }
            case 0x200B22: {
                return "CAR_POPUP_PARKING_ARA";
            }
            case 2100071: {
                return "CAR_POPUP_PARKING_ARA_TEXTS_CENTER";
            }
            case 2100068: {
                return "CAR_OPT_CHARGE_TIMER_DATE_DISCLAIMER";
            }
            case 0x200B20: {
                return "CAR_POPUP_PARKING_PLA_ACTIVE_PARK";
            }
            case 2100069: {
                return "CAR_OPT_CHARGE_TIMER_SINGLE_DISCLAIMER";
            }
            case 2100001: {
                return "CAR_POPUP_PARKING_APS_OPS_VPS_RVC";
            }
            case 2100066: {
                return "CAR_POPUP_END_AUXAC_MAIN";
            }
            case 2100067: {
                return "CAR_POPUP_CHARGE_END";
            }
            case 2100064: {
                return "CAR_OPT_AUXAC_TIMER2_MAIN";
            }
            case 2100065: {
                return "CAR_POPUP_END_AUXCOMBINED_MAIN";
            }
            case 2100010: {
                return "CAR_POPUP_PARKING_PLA_TEXTS_MAIN";
            }
            case 2100008: {
                return "CAR_POPUP_PARKING_OPS";
            }
            case 2100009: {
                return "CAR_POPUP_PARKING_ARA_TEXTS";
            }
            case 2100018: {
                return "CAR_POPUP_SEATMEMORY_LEFT";
            }
            case 2100017: {
                return "CAR_POPUP_SEAT_LEFT";
            }
            case 2100016: {
                return "CAR_POPUP_SEAT_RIGHT";
            }
            case 2100021: {
                return "CAR_POPUP_SEATMEMORY_RIGHT";
            }
            case 2100024: {
                return "EarlyApps_OPT";
            }
            case 2100031: {
                return "CAR_POPUP_SEAT_KOMBI_RIGHT";
            }
            case 2100030: {
                return "CAR_POPUP_SEAT_KOMBI_LEFT";
            }
            case 2300079: {
                return "AUDI_CONNECT_OPT_USERCHOOSERLIST_DELETE_ERROR";
            }
            case 2300078: {
                return "AUDI_CONNECT_OPT_USERCHOOSERLIST_DELETELOGIN_QUESTION";
            }
            case 2300077: {
                return "AUDI_CONNECT_OPT_USERCHOOSERLIST_DELETELOGIN_MOBIL_QUESTION";
            }
            case 2300076: {
                return "AUDI_CONNECT_PERSONALIZED";
            }
            case 2300075: {
                return "AUDI_CONNECT_OPT_LOGIN_NOCARSLOTS";
            }
            case 2300074: {
                return "AUDI_CONNECT_OPT_LOGIN_403";
            }
            case 2300073: {
                return "AUDI_CONNECT_RHMI_TEXT_DISPLAY_OPTIONS";
            }
            case 2300072: {
                return "AUDI_CONNECT_RHMI_TEXT_DISPLAY";
            }
            case 2300071: {
                return "CM_POPUP_ONLINE_ERROR_LICENSE_CHECK_QUERY";
            }
            case 2300070: {
                return "CM_POPUP_ONLINE_LICENSE_NOTE_MAIN";
            }
            case 2300069: {
                return "CM_POPUP_ONLINE_SERVICELIST_NA";
            }
            case 2300068: {
                return "CM_POPUP_ONLINE_TEASER_NOTE_MAIN";
            }
            case 2300067: {
                return "AUDI_CONNECT_OPT_LICENSEINFO_LOADING";
            }
            case 2300066: {
                return "AUDI_CONNECT_OPT_LICENSEINFO_SERVICELISTERROR";
            }
            case 2300064: {
                return "AUDI_CONNECT_RHMI_NAVI_ERROR";
            }
            case 2300094: {
                return "AUDI_CONNECT_OPT_LOGIN_ENTRYDATA_USERNAME";
            }
            case 2300095: {
                return "AUDI_CONNECT_OPT_LOGIN_ENTRYDATA_USERNAME_PASS";
            }
            case 2300092: {
                return "CM_POPUP_ONLINE_LICENSE_REJECTED";
            }
            case 2300093: {
                return "AUDI_CONNECT_NOLOGIN";
            }
            case 2300090: {
                return "CM_POPUP_ONLINE_NOT_LICENSED";
            }
            case 2300091: {
                return "CM_POPUP_ONLINE_NOT_ACTIVATED";
            }
            case 2300088: {
                return "BREAKDOWNCALL_CN_COMMUNICATION_OLD_DATA_FOUND";
            }
            case 2300089: {
                return "BREAKDOWNCALL_CN_VOICE_CALL";
            }
            case 2300087: {
                return "BREAKDOWNCALL_CN_COMM_END_MSG";
            }
            case 2300084: {
                return "BREAKDOWNCALL_CN_DATA_POLL";
            }
            case 2300085: {
                return "BREAKDOWNCALL_CN_COMM_ERROR";
            }
            case 2300082: {
                return "BREAKDOWNCALL_CN_RESULT";
            }
            case 2300083: {
                return "BREAKDOWNCALL_CN_TELEPHONE_ACTIVE";
            }
            case 2300080: {
                return "AUDI_CONNECT_OPT_LOGIN_USER_DELETED";
            }
            case 2300081: {
                return "AUDI_CONNECT_RHMI_NPS";
            }
            case 2300044: {
                return "AUDI_CONNECT_PREVIOUS_SCREEN";
            }
            case 2300040: {
                return "AUDI_CONNECT_OPT_LOGIN_SAVELOGIN_SIM";
            }
            case 2300043: {
                return "AUDI_CONNECT_OPT_LOGIN_CREATE_NEW_USER_WAITING";
            }
            case 2300036: {
                return "AUDI_CONNECT_OPT_LOGIN_USERS";
            }
            case 2300039: {
                return "AUDI_CONNECT_OPT_LOGIN_SAVELOGIN_ONDEVICES";
            }
            case 2300038: {
                return "AUDI_CONNECT_OPT_LOGIN_SCREENAlternative";
            }
            case 2300033: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_RHMI_CON_SENSITIVE_RANDOM_APP_HOME_GENERIC";
            }
            case 2300035: {
                return "AUDI_CONNECT_OPT_LICENSEINFO_DETAIL";
            }
            case 2300034: {
                return "AUDI_CONNECT_OPT_LICENSEINFO_MAIN";
            }
            case 2300060: {
                return "AUDI_CONNECT_RHMI_POPUP_TIMEOUT";
            }
            case 2300061: {
                return "AUDI_CONNECT_RHMI_POPUP";
            }
            case 2300062: {
                return "AUDI_CONNECT_MINIAPP_WAITING";
            }
            case 2300063: {
                return "AUDI_CONNECT_OPT_HOME_DEFAULT";
            }
            case 2300056: {
                return "AUDI_CONNECT_RHMI_LIST_OPTIONS";
            }
            case 2300057: {
                return "AUDI_CONNECT_POPUP_OPT";
            }
            case 2300058: {
                return "AUDI_CONNECT_RHMI_WAITING";
            }
            case 2300059: {
                return "AUDI_CONNECT_RHMI_POPUP_BUTTON";
            }
            case 2300052: {
                return "SDS_HELP_ONLINE_TOPIC_XY_GENERIC_STATE";
            }
            case 2300053: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_RHMI";
            }
            case 2300054: {
                return "AUDI_CONNECT_WAITING";
            }
            case 2300055: {
                return "ONLINE_TEXT_CONSTANT_SDS";
            }
            case 2300050: {
                return "SDS_HELP_ONLINE_GENERIC";
            }
            case 2300051: {
                return "AUDI_CONNECT_HOME_WAITINGCORESERVICES";
            }
            case 2300139: {
                return "CM_POPUP_ONLINE_NOT_ACTIVATED_G22";
            }
            case 2300138: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_NOLOGIN";
            }
            case 2300137: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_OK";
            }
            case 2300136: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_ERROR";
            }
            case 2300143: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_LOGIN_PIN_WAIT";
            }
            case 2300142: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_PIN_MAX_ERROR";
            }
            case 2300141: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_ERROR";
            }
            case 2300140: {
                return "AUDI_CONNECT_HOME_Q7_NOCONNECTION_MAIN";
            }
            case 2300131: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_NEWMAINUSER_PIN";
            }
            case 2300130: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_NEWMAINUSER_INFO";
            }
            case 2300129: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_MAINUSER";
            }
            case 2300128: {
                return "AUDI_CONNECT_OPT_USER_INFO_MAINUSER";
            }
            case 2300135: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_PIN_RIGHT";
            }
            case 2300134: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_PIN_WRONG";
            }
            case 2300133: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_NEWMAINUSER_USERNAMEENTER";
            }
            case 2300132: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_NEWMAINUSER_PINENTER";
            }
            case 2300154: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_ACCOUNT_NA_OR_NOT_VERIFIED";
            }
            case 2300155: {
                return "CM_POPUP_ONLINE_ERRORS_OUT_OF_RANGE";
            }
            case 2300152: {
                return "AUDI_CONNECT_SMS_NOT_CONNECTED";
            }
            case 2300153: {
                return "AUDI_CONNECT_MAIL_NOT_CONNECTED";
            }
            case 2300159: {
                return "BREAKDOWNCALL_CN_CARPLAY_CALL";
            }
            case 2300156: {
                return "AUDI_CONNECT_TRAFFICLIGHT";
            }
            case 2300146: {
                return "CONCIERGECALL_JP_OPT_DELETE_CONFIRM";
            }
            case 2300147: {
                return "AUDI_CONNECT_DISTRIBUTED_ONLINEMEDIA";
            }
            case 2300145: {
                return "OPCALL_OPT";
            }
            case 2300150: {
                return "AUDI_CONNECT_DISTRIBUTED_CARREMOTE";
            }
            case 2300151: {
                return "AUDI_CONNECT_DISTRIBUTED_ALERT_SERVICES";
            }
            case 2300148: {
                return "DEST_OPERATORCALL_POI_RECEIVED";
            }
            case 2300149: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MANUELL";
            }
            case 2300105: {
                return "DEST_OPERATORCALL_CN_COMM_END_MSG";
            }
            case 2300107: {
                return "DEST_OPERATORCALL_CN_COMMUNICATION_OLD_DATA_FOUND";
            }
            case 2300106: {
                return "DEST_OPERATORCALL_CN_VOICE_CALL";
            }
            case 2300108: {
                return "DEST_OPERATORCALL_CN_SHOW_RESULT_LIST";
            }
            case 2300110: {
                return "DEST_OPT_DELETE_PCALL_HISTORY_CONFIRM";
            }
            case 2300097: {
                return "BREAKDOWNCALL_CN_WELCOME";
            }
            case 2300096: {
                return "BREAKDOWNCALL_CN_WAITING";
            }
            case 2300099: {
                return "DEST_OPERATORCALL_CN_MAIN";
            }
            case 2300098: {
                return "BREAKDOWNCALL_CN_WELCOME_WITH_POI";
            }
            case 2300101: {
                return "DEST_OPERATORCALL_CN_COMM_CONFIRM_POSITION";
            }
            case 2300100: {
                return "DEST_OPERATORCALL_CN_TELEPHONE_ACTIVE";
            }
            case 2300103: {
                return "DEST_OPERATORCALL_CN_COMM_ERROR";
            }
            case 2300102: {
                return "DEST_OPERATORCALL_CN_DATA_POLL";
            }
            case 2300123: {
                return "AUDI_CONNECT_NO_NETWORK";
            }
            case 2300124: {
                return "AUDI_CONNECT_CARFINDER";
            }
            case 2300125: {
                return "AUDI_CONNECT_REMOTE_HEATER";
            }
            case 2300126: {
                return "AUDI_CONNECT_STD_APPLIST";
            }
            case 2300127: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN";
            }
            case 2300209: {
                return "AUDI_CONNECT_OPT_USER_INFO_DELETE_ERROR_MOBILEKEY";
            }
            case 2300208: {
                return "AUDI_CONNECT_KEYCARD_POPUP_DEACTIVATE";
            }
            case 2300210: {
                return "AUDI_CONNECT_SERVICE_ACK_POPUP_MOBILITY_REQUIREMENTS";
            }
            case 2300196: {
                return "AUDI_CONNECT_KEY_SWITCH_ACTIVATE";
            }
            case 2300197: {
                return "AUDI_CONNECT_KEY_SWITCH_DEACTIVATE";
            }
            case 2300198: {
                return "AUDI_CONNECT_KEY_SWITCH_DEACTIVATE_ERROR";
            }
            case 2300199: {
                return "AUDI_CONNECT_KEYCODE_PLEASEWAIT";
            }
            case 2300192: {
                return "AUDI_CONNECT_HINTS_KL15";
            }
            case 2300193: {
                return "AUDI_CONNECT_MOBILE_KEY_MAIN";
            }
            case 2300194: {
                return "AUDI_CONNECT_SERVICE_ACK_DETAIL_VIEW";
            }
            case 2300195: {
                return "AUDI_CONNECT_MOBILE_KEY_SWITCH";
            }
            case 2300204: {
                return "AUDI_CONNECT_KEYCARD_ACTIVATION_ERR_POPUP";
            }
            case 2300205: {
                return "AUDI_CONNECT_KEYCARD_PHONEBOX_HINT_POPUP";
            }
            case 2300207: {
                return "AUDI_CONNECT_KEYCARD_POPUP_ACTIVATE";
            }
            case 2300200: {
                return "AUDI_CONNECT_KEYCODE";
            }
            case 2300201: {
                return "AUDI_CONNECT_KEYCODE_NOT_AVAILABLE";
            }
            case 2300202: {
                return "AUDI_CONNECT_KEYCODE_GENERIC_ERROR";
            }
            case 2300203: {
                return "AUDI_CONNECT_KEYCARD_DETAILS";
            }
            case 2300167: {
                return "AUDI_CONNECT_HOME_PRIVACY_MODE_ON";
            }
            case 2300165: {
                return "AUDI_CONNECT_OPT_PRIVACY_SETTINGS_DATA_MODLE_DEACTIVATE_CONF";
            }
            case 2300162: {
                return "AUDI_CONNECT_POPUP_NEW_DESTINATIONS";
            }
            case 2300163: {
                return "AUDI_CONNECT_OPT_PRIVACY_SETTINGS";
            }
            case 2300160: {
                return "DEST_OPERATORCALL_CN_CARPLAY_CALL";
            }
            case 2300161: {
                return "AUDI_CONNECT_OPT_USER_INFO_SCREEN_MAINUSER_MYAUDI_INFO";
            }
            case 2300002: {
                return "AUDI_CONNECT_OPT";
            }
            case 2300000: {
                return "AUDI_CONNECT_RHMI_REF_TEMPLATE";
            }
            case 2300001: {
                return "AUDI_CONNECT_SEL";
            }
            case 2300006: {
                return "AUDI_CONNECT_RHMI_ELEMENTS";
            }
            case 2300007: {
                return "AUDI_CONNECT_RHMI_ELEMENT_REFERENCES";
            }
            case 2300004: {
                return "AUDI_CONNECT_RHMI_SUPPORTED";
            }
            case 2300010: {
                return "AUDI_CONNECT_RHMI_LIST";
            }
            case 2300008: {
                return "AUDI_CONNECT_RHMI_BROWSER";
            }
            case 2300009: {
                return "AUDI_CONNECT_HOME_PLEASEWAIT";
            }
            case 2300014: {
                return "AUDI_CONNECT_DISTRIBUTED_SERVICES";
            }
            case 2300015: {
                return "ONLINE_TEXT_CONSTANT";
            }
            case 2300012: {
                return "AUDI_CONNECT_MINIAPP_ERROR";
            }
            case 2300019: {
                return "AUDI_CONNECT_OPT_LOGIN_SCREEN";
            }
            case 2300018: {
                return "AUDI_CONNECT_OPT_LOGIN_LOADING";
            }
            case 2300023: {
                return "AUDI_CONNECT_OPT_LOGIN_NO_CONNECTIVITY";
            }
            case 2300022: {
                return "AUDI_CONNECT_OPT_LOADING_LOGIN";
            }
            case 2300021: {
                return "AUDI_CONNECT_OPT_LOGIN_NO_VIN";
            }
            case 2300020: {
                return "AUDI_CONNECT_OPT_LOGIN_WRONG_LOGININFOS";
            }
            case 2300026: {
                return "AUDI_CONNECT_OPT_LOGIN_RANDOMR_ERRORS";
            }
            case 2300025: {
                return "AUDI_CONNECT_OPT_LOGIN_COMPONENT_PORT_ERROR";
            }
            case 2300024: {
                return "AUDI_CONNECT_OPT_LOGIN_BACKEND_PROBLEMS";
            }
            case 2300028: {
                return "AUDI_CONNECT_OPT_LOGOUT_LOADING";
            }
            case 2200104: {
                return "OFFICE_POPUP_MAIL_STORE_VCARD_OK";
            }
            case 2200107: {
                return "OFFICE_SMS_MAIN_WAIT";
            }
            case 2200096: {
                return "OFFICE_OPT_MAIL_NAVIGATE_MAIN";
            }
            case 0x219221: {
                return "SDS_HELP_CONTEXT_OFFICE";
            }
            case 0x219222: {
                return "OFFICE_OPT_SMS_NAVIGATE_MAIN";
            }
            case 2200099: {
                return "OFFICE_POPUP_SMS_STORE_VCARD_ERR_2";
            }
            case 2200100: {
                return "OFFICE_POPUP_SMS_STORE_VCARD_ERR_1";
            }
            case 2200101: {
                return "OFFICE_POPUP_SMS_STORE_VCARD_OK";
            }
            case 2200102: {
                return "OFFICE_POPUP_MAIL_STORE_VCARD_ERR_1";
            }
            case 2200103: {
                return "OFFICE_POPUP_MAIL_STORE_VCARD_ERR_2";
            }
            case 2200091: {
                return "OFFICE_POPUP_MAIL_SPEED_DISCLAIMER";
            }
            case 2200090: {
                return "OFFICE_POPUP_MAIL_STORE_DRAFT_OK";
            }
            case 0x219219: {
                return "OFFICE_POPUP_MAIL_STORE_DRAFT_ERR_1";
            }
            case 2200088: {
                return "OFFICE_POPUP_MAIL_STORE_DRAFT_ERR_2";
            }
            case 2200095: {
                return "OFFICE_OPT_SMS_SEND_MSG_MAIN";
            }
            case 2200094: {
                return "OFFICE_OPT_MAIL_SEND_MSG_MAIN";
            }
            case 2200092: {
                return "OFFICE_POPUP_SMS_SPEED_DISCLAIMER";
            }
            case 2200083: {
                return "OFFICE_POPUP_SMS_STORE_DRAFT_TEXT_ERR";
            }
            case 0x219212: {
                return "OFFICE_OPT_SMS_STORE_TEMP_REPLACE_MAIN";
            }
            case 2200087: {
                return "OFFICE_POPUP_MAIL_STORE_DRAFT_TEXT_ERR";
            }
            case 2200086: {
                return "OFFICE_POPUP_SMS_STORE_DRAFT_OK";
            }
            case 2200085: {
                return "OFFICE_POPUP_SMS_STORE_DRAFT_ERR_1";
            }
            case 2200084: {
                return "OFFICE_POPUP_SMS_STORE_DRAFT_ERR_2";
            }
            case 2200073: {
                return "OFFICE_OPT_MAIL_STORE_TEMP_REPLACE_MAIN";
            }
            case 2200078: {
                return "OFFICE_POPUP_SMS_STORE_TEMP_ERR_1";
            }
            case 2200079: {
                return "OFFICE_POPUP_SMS_STORE_TEMP_OK";
            }
            case 2200076: {
                return "OFFICE_POPUP_SMS_STORE_TEMP_TEXT_ERR";
            }
            case 2200077: {
                return "OFFICE_POPUP_SMS_STORE_TEMP_ERR_2";
            }
            case 2200066: {
                return "OFFICE_OPT_SMS_NEW_EDIT_RECIPIENTS";
            }
            case 2200064: {
                return "OFFICE_OPT_MAIL_EXTRACT_NUM_MAIN";
            }
            case 2200065: {
                return "OFFICE_OPT_MAIL_EXTRACT_MAIL_MAIN";
            }
            case 2200070: {
                return "OFFICE_POPUP_MAIL_STORE_TEMP_ERR_2";
            }
            case 2200071: {
                return "OFFICE_POPUP_MAIL_STORE_TEMP_OK";
            }
            case 2200068: {
                return "OFFICE_POPUP_MAIL_STORE_TEMP_TEXT_ERR";
            }
            case 2200069: {
                return "OFFICE_POPUP_MAIL_STORE_TEMP_ERR_1";
            }
            case 2200158: {
                return "OFFICE_OPT_TMPL_EDIT";
            }
            case 2200157: {
                return "OFFICE_OPT_TMPL_MAIN";
            }
            case 2200156: {
                return "OFFICE_OPT_MAIL_ATTACHMENTS_ERR_2";
            }
            case 2200155: {
                return "OFFICE_POPUP_MAIL_MAX_CHARS";
            }
            case 2200154: {
                return "OFFICE_POPUP_SMS_MAX_CHARS";
            }
            case 2200153: {
                return "OFFICE_POPUP_SDS_CONTACT_MAIL_MORE";
            }
            case 2200152: {
                return "OFFICE_POPUP_SMS_SIM_DELETE_DONE";
            }
            case 2200151: {
                return "OFFICE_POPUP_SMS_SIM_DELETE_ERROR";
            }
            case 2200150: {
                return "OFFICE_POPUP_SMS_SIM_DELETE_MAIN";
            }
            case 2200142: {
                return "OFFICE_OPT_SMS_DICTATION_RUNNING";
            }
            case 2200140: {
                return "OFFICE_MAIL_MAIN_WAIT";
            }
            case 2200141: {
                return "OFFICE_OPT_SMS_DICTATION_PROCESSING";
            }
            case 2200001: {
                return "OFFICE_OPT";
            }
            case 2200003: {
                return "OFFICE_POPUP_SDS_ACCOUNT_NAMES";
            }
            case 2200002: {
                return "OFFICE_REF_TEMPLATE";
            }
            case 2200004: {
                return "OFFICE_OPT_MAIL_SETUP";
            }
            case 2200007: {
                return "OFFICE_SMS_MAIN";
            }
            case 2200006: {
                return "OFFICE_MAIL_MAIN";
            }
            case 2200009: {
                return "OFFICE_OPT_MAIL_DETAIL_MAIN";
            }
            case 2200008: {
                return "OFFICE_OPT_SMS_DETAIL_MAIN";
            }
            case 2200013: {
                return "OFFICE_OPT_SMS_DELETE_OK";
            }
            case 2200012: {
                return "OFFICE_OPT_SMS_DELETE_WAIT";
            }
            case 2200014: {
                return "OFFICE_OPT_SMS_DELETE_ERR";
            }
            case 2200016: {
                return "OFFICE_OPT_SMS_DETAIL_NA_MAIN";
            }
            case 2200017: {
                return "OFFICE_OPT_MAIL_DETAIL_NA_MAIN";
            }
            case 2200021: {
                return "OFFICE_OPT_MAIL_DELETE_WAIT";
            }
            case 2200022: {
                return "OFFICE_OPT_MAIL_DELETE_OK";
            }
            case 2200023: {
                return "OFFICE_OPT_MAIL_DELETE_ERR";
            }
            case 2200024: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_SMS_DICTATION";
            }
            case 2200025: {
                return "OFFICE_OPT_SMS_CALL_MAIN";
            }
            case 2200026: {
                return "OFFICE_OPT_MAIL_CALL_MAIN";
            }
            case 2200027: {
                return "OFFICE_OPT_SMS_NEW_MAIN";
            }
            case 2200028: {
                return "OFFICE_OPT_MAIL_RECIPIENTS_MAIN";
            }
            case 2200029: {
                return "SDS_COM_BIG_COMMAND_DISPLAY_OFFICE";
            }
            case 2200030: {
                return "OFFICE_OPT_MAIL_NEW_MAIN";
            }
            case 2200031: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ONE_WAIT";
            }
            case 2200035: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ONE_OK";
            }
            case 2200034: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ONE_WAIT";
            }
            case 2200033: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ONE_ERR";
            }
            case 2200032: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ONE_OK";
            }
            case 2200039: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ALL_ERR";
            }
            case 2200038: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ALL_OK";
            }
            case 2200037: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ALL_WAIT";
            }
            case 2200036: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ONE_ERR";
            }
            case 2200043: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ALL_OK";
            }
            case 2200042: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ALL_ERR";
            }
            case 2200041: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ALL_MAIN";
            }
            case 2200040: {
                return "OFFICE_OPT_MAIL_DELETE_TEMP_ALL_MAIN";
            }
            case 2200047: {
                return "OFFICE_OPT_MAIL_ATTACHMENTS_ERR";
            }
            case 2200046: {
                return "OFFICE_OPT_MAIL_ATTACHMENTS_WAIT";
            }
            case 2200045: {
                return "OFFICE_TEXT_CONSTANT";
            }
            case 2200044: {
                return "OFFICE_OPT_SMS_DELETE_TEMP_ALL_WAIT";
            }
            case 2200050: {
                return "OFFICE_OPT_MAIL_NEW_EDIT";
            }
            case 2200051: {
                return "OFFICE_OPT_MAIL_NEW_EDIT_RECIPIENTS";
            }
            case 2200049: {
                return "OFFICE_OPT_MAIL_ATTACHMENTS_MAIN";
            }
            case 2200054: {
                return "OFFICE_OPT_SMS_NEW_SEND_TEXT_ERR";
            }
            case 2200055: {
                return "OFFICE_OPT_MAIL_NEW_SEND_TEXT_ERR";
            }
            case 2200053: {
                return "OFFICE_OPT_SMS_NEW_EDIT";
            }
            case 2200058: {
                return "OFFICE_OPT_SMS_NEW_SEND_WAIT";
            }
            case 2200059: {
                return "OFFICE_OPT_SMS_NEW_SEND_OK";
            }
            case 2200056: {
                return "OFFICE_OPT_MAIL_NEW_SEND_WAIT";
            }
            case 2200057: {
                return "OFFICE_OPT_MAIL_NEW_SEND_OK";
            }
            case 2200062: {
                return "OFFICE_OPT_MAIL_NEW_SEND_ERR";
            }
            case 2200063: {
                return "OFFICE_OPT_SMS_EXTRACT_NUM_MAIN";
            }
            case 2200060: {
                return "OFFICE_OPT_SMS_NEW_SEND_TEXT_ERR_1";
            }
            case 2200061: {
                return "OFFICE_OPT_SMS_NEW_SEND_TEXT_ERR_2";
            }
            case 2500052: {
                return "CM_POPUP_ONLINE_ERROR_NO_ROAMING";
            }
            case 2500053: {
                return "CM_POPUP_ONLINE_ERROR_GSM_ACTIVE";
            }
            case 2500054: {
                return "CM_POPUP_ONLINE_ERROR_ROAMING_DISCLAIMER";
            }
            case 2500048: {
                return "CM_POPUP_ONLINE_ERROR_NO_PHONE";
            }
            case 2500049: {
                return "CM_POPUP_ONLINE_ERROR_NO_PIN";
            }
            case 2500050: {
                return "CM_POPUP_ONLINE_ERROR_NO_SIMAP";
            }
            case 2500051: {
                return "CM_POPUP_ONLINE_ERROR_DATA_DEACTIVATE";
            }
            case 2500060: {
                return "CM_POPUP_WLAN_BONDING_ERROR_ELSE";
            }
            case 2500061: {
                return "CM_POPUP_WLAN_BONDING_ERROR_PIN";
            }
            case 2500063: {
                return "CM_OPT_CHANGE_AC_BONDING_DISCLAIMER";
            }
            case 2500058: {
                return "CM_POPUP_ONLINE_ERROR_NO_SIM";
            }
            case 2500059: {
                return "CM_OPT_WLAN_BONDING_CONNECTED_MAIN";
            }
            case 2500037: {
                return "CM_OPT_CONNECT_SETUP_EDIT_PASSWORD";
            }
            case 2500036: {
                return "CM_OPT_CONNECT_SETUP_EDIT_USER";
            }
            case 2500039: {
                return "CM_POPUP_BLUETOOTH_EXTERNAL_CODE_EDIT";
            }
            case 2500033: {
                return "CM_OPT_CONNECT_SETUP_DATA_MAIN";
            }
            case 2500032: {
                return "CM_OPT_WLAN_BONDING_CONNECTED_WAIT";
            }
            case 2500035: {
                return "CM_OPT_CONNECT_SETUP_EDIT_APN";
            }
            case 2500034: {
                return "CM_OPT_CONNECT_SETUP_MAIN";
            }
            case 2500045: {
                return "CM_POPUP_ONLINE_CONNECTION_REQUEST";
            }
            case 2500044: {
                return "CM_POPUP_ONLINE_DISCLAIMER_SHOW";
            }
            case 2500047: {
                return "CM_POPUP_ONLINE_ERROR_NO_CONFIG";
            }
            case 2500040: {
                return "CM_OPT_ONLINE_SETUP_DATA_COUNTER";
            }
            case 2500087: {
                return "CM_OPT_ONLINE_SETUP_SECURITY_MAIN";
            }
            case 2500084: {
                return "CM_OPT_ONLINE_SETUP_MAIN";
            }
            case 2500085: {
                return "CM_OPT_ONLINE_SETUP_DATA_STATUS";
            }
            case 2500083: {
                return "CM_POPUP_BLUETOOTH_EXTERNAL_MAIN";
            }
            case 2500092: {
                return "CM_POPUP_ONLINE_ERROR_SIM_FAILURE";
            }
            case 2500093: {
                return "CM_OPT_WLAN_SCONTACT_ERROR";
            }
            case 2500090: {
                return "CM_POPUP_ONLINE_ERROR_NO_PUK";
            }
            case 2500091: {
                return "CM_OPT_ONLINE_UNLOCK_PUK_BLOCKED";
            }
            case 2500089: {
                return "CM_OPT_BLUETOOTH_SCONTACT_ERROR";
            }
            case 2500065: {
                return "CM_POPUP_ONLINE_ERRORS_SERVER_MULTI_CONFIG_PROFILES_MAIN";
            }
            case 2500072: {
                return "CM_OPT_BLUETOOTH_DEVICES_PROFILES_SHOWN";
            }
            case 0x26262C: {
                return "CM_OPT_ABOUT_CAR_PLAY";
            }
            case 0x26262D: {
                return "CM_OPT_ABOUT_ANDROID_AUTO";
            }
            case 0x26262F: {
                return "CM_OPT_CONNECT_SETUP_MAIN_2";
            }
            case 0x262629: {
                return "CM_POPUP_ONLINE_ERROR_NO_ESIM";
            }
            case 0x26262A: {
                return "CM_POPUP_ONLINE_ERROR_NO_PHONE_ESIM";
            }
            case 0x262625: {
                return "CM_OPT_BLUETOOTH_BONDING_TRUSTED_DEVICES";
            }
            case 2500148: {
                return "CM_OPT_ABOUT_BAIDU_CARLIFE";
            }
            case 0x262636: {
                return "CM_POPUP_ONLINE_GPS";
            }
            case 2500145: {
                return "CM_OPT_CONNECT_SETUP_EDIT_USER_APN_2";
            }
            case 2500144: {
                return "CM_OPT_CONNECT_SETUP_EDIT_APN_2";
            }
            case 0x262632: {
                return "CM_OPT_CONNECT_SETUP_EDIT_PASSWORD_APN_2";
            }
            case 2500110: {
                return "CM_OPT_CHANGE_AC_HOTSPOT";
            }
            case 2500018: {
                return "CM_POPUP_BLUETOOTH_OBEX_CODE_PASSWORD";
            }
            case 2500111: {
                return "CM_POPUP_ONLINE_ERRORS_SERVER_MULTI_CONFIG";
            }
            case 2500019: {
                return "CM_OPT_BLUETOOTH_BONDING_PAIRED_HFP";
            }
            case 2500016: {
                return "CM_POPUP_BLUETOOTH_BONDING_ERROR";
            }
            case 2500109: {
                return "CM_TEXT_CONST";
            }
            case 2500017: {
                return "CM_POPUP_BLUETOOTH_OBEX_CODE_ID";
            }
            case 2500022: {
                return "CM_OPT_BLUETOOTH_BONDING_PAIRED_HFP_TETHERING";
            }
            case 2500023: {
                return "CM_OPT_WLAN_MAIN";
            }
            case 2500020: {
                return "CM_OPT_BLUETOOTH_BONDING_PAIRED_SAP";
            }
            case 2500021: {
                return "CM_OPT_BLUETOOTH_BONDING_PAIRED_SAP_HOTSPOT";
            }
            case 2500026: {
                return "CM_OPT_WLAN_SETUP_EDIT_PASSWORD";
            }
            case 2500027: {
                return "CM_OPT_WLAN_TETHERING_SEARCH";
            }
            case 2500024: {
                return "CM_OPT_WLAN_SETUP";
            }
            case 2500025: {
                return "CM_OPT_WLAN_SETUP_EDIT_SSID";
            }
            case 0x262602: {
                return "CM_POPUP_BLUETOOTH_OBEX_MAIN";
            }
            case 2500030: {
                return "CM_OPT_WLAN_TETHERING_CODE_ERROR";
            }
            case 2500099: {
                return "CM_POPUP_BLUETOOTH_NA";
            }
            case 2500031: {
                return "CM_OPT_WLAN_TETHERING_CODE_EDIT";
            }
            case 2500028: {
                return "CM_OPT_WLAN_TETHERING_DEVICES";
            }
            case 2500003: {
                return "CM_OPT_BLUETOOTH_NAME_EDIT";
            }
            case 2500001: {
                return "CM_OPT";
            }
            case 2500000: {
                return "CM_REF_TEMPLATE";
            }
            case 2500007: {
                return "CM_OPT_BLUETOOTH_BONDING_SEARCH";
            }
            case 2500005: {
                return "CM_MAIN";
            }
            case 2500004: {
                return "CM_OPT_BLUETOOTH_MAIN";
            }
            case 2500011: {
                return "CM_OPT_BLUETOOTH_BONDING_COMPARE";
            }
            case 2500010: {
                return "CM_OPT_BLUETOOTH_BONDING_WAIT";
            }
            case 2500009: {
                return "CM_OPT_BLUETOOTH_BONDING_DEVICE";
            }
            case 2500116: {
                return "CM_OPT_BLUETOOTH_BONDING_WAIT_AUDIO";
            }
            case 2500015: {
                return "CM_OPT_BLUETOOTH_BONDING_CODE_ERROR";
            }
            case 2500014: {
                return "CM_OPT_BLUETOOTH_BONDING_DISP_SELECT";
            }
            case 2500013: {
                return "CM_OPT_BLUETOOTH_BONDING_DISP";
            }
            case 0x262611: {
                return "CM_POPUP_ONLINE_ERROR_DATA_MODULE_DEACTIVATE";
            }
            case 2500112: {
                return "CM_OPT_BLUETOOTH_BONDING_CONNECTED_SAP_ESIM_ACTIVE";
            }
            case 2500012: {
                return "CM_OPT_BLUETOOTH_BONDING_CODE_EDIT";
            }
            case 2400004: {
                return "tsReceiversDetails";
            }
            case 2400001: {
                return "tsProviders";
            }
            case 2400000: {
                return "tsMain";
            }
            case 2400003: {
                return "tsReceivers";
            }
            case 2400002: {
                return "tsProviderDetails";
            }
            case 2600007: {
                return "TV_FULLSCREEN_DISCLAIMER_OBSOLETE";
            }
            case 2600006: {
                return "TV_CHANNEL_MAIN";
            }
            case 2600005: {
                return "TV_FULLSCREEN_MAIN";
            }
            case 2600001: {
                return "TV_AUDIO";
            }
            case 2600000: {
                return "TV_REF_TEMPLATE";
            }
            case 2600015: {
                return "TV_POPUP_EWS_MAIN";
            }
            case 2600013: {
                return "TV_OPT_DATABROADCAST_DISCLAIMER_OBSOLETE";
            }
            case 2600012: {
                return "TV_OPT_DATABROADCAST_MAIN";
            }
            case 2600011: {
                return "TV_OPT_EPG_MAIN";
            }
            case 2600010: {
                return "TV_FULLSCREEN_MOVIE_RATING";
            }
            case 2600009: {
                return "TV_CAS_DISCLAIMER_SECOND";
            }
            case 2600008: {
                return "TV_CAS_DISCLAIMER_FIRST";
            }
            case 2600022: {
                return "TV_OPT_PARENTAL_ENTER_PWD";
            }
            case 2600023: {
                return "TV_OPT_PARENTAL_BLOCKED";
            }
            case 2600020: {
                return "TV_OPT_VISUAL_AUDIO_MAIN";
            }
            case 2600021: {
                return "TV_OPT_SETTINGS";
            }
            case 2600018: {
                return "TV_AV_FULLSCREEN";
            }
            case 2600019: {
                return "TV_AV_FULLSCREEN_DISCLAIMER_OBSOLETE";
            }
            case 2600016: {
                return "TV_POPUP_EWS_PREFECTURES";
            }
            case 2600017: {
                return "TV_AV_MAIN";
            }
            case 2600030: {
                return "TV_OPT_SOUNDCHANNEL_MAIN";
            }
            case 2600031: {
                return "TV_OPT_REGION_VARIANT_MAIN";
            }
            case 2600028: {
                return "TV_OPT_PARENTAL_SELECT_CHANGE_SECOND";
            }
            case 2600029: {
                return "TV_OPT_PARENTAL_SELECT_CHANGE_UNEQUAL";
            }
            case 2600026: {
                return "TV_OPT_PARENTAL_SELECT_LEVEL";
            }
            case 2600027: {
                return "TV_OPT_PARENTAL_SELECT_CHANGE_FIRST";
            }
            case 2600024: {
                return "TV_OPT_PARENTAL_ENTER_PWD_WRONG";
            }
            case 2600025: {
                return "TV_OPT_PARENTAL_SELECT";
            }
            case 2600036: {
                return "TV_OPT";
            }
            case 2600038: {
                return "TV_OPT_SEEK_MAIN";
            }
            case 2600033: {
                return "TV_OPT_ENGINEERING_MAIN";
            }
            case 2600032: {
                return "TV_OPT_CAS_ID_MAIN";
            }
            case 2600035: {
                return "TV_OPT_TELETEXT_DISCLAIMER_OBSOLETE";
            }
            case 2600034: {
                return "TV_OPT_TELETEXT_MAIN";
            }
            case 2600045: {
                return "TV_POPUP_EWS_SMT";
            }
            case 2600047: {
                return "TV_OPT_PICTURE_MAIN";
            }
            case 2600046: {
                return "TV_PP_OPT_FAVORITE_STORE_OK";
            }
            case 2600041: {
                return "TV_PP_OPT_FAVORITE_DELETE_ALL_DONE";
            }
            case 2600040: {
                return "TV_PP_OPT_FAVORITE_DELETE_ALL";
            }
            case 2600043: {
                return "TV_PP_OPT_PARENTAL_SUCCESSFUL_PWD_CHANGE";
            }
            case 2600042: {
                return "TV_FAVORITE_MAIN";
            }
            case 2600052: {
                return "TV_TEXT_CONST";
            }
            case 2600053: {
                return "TV_PP_FULLSCREEN_MAIN_OSD";
            }
            case 2600048: {
                return "TV_OPT_PICTURE_BRIGHTNESS";
            }
            case 2600049: {
                return "TV_OPT_PICTURE_CONTRAST";
            }
            case 2600050: {
                return "TV_OPT_PICTURE_COLOR";
            }
            case 2600083: {
                return "TV_AV_FULLSCREEN_DISCLAIMER";
            }
            case 2600082: {
                return "TV_STANDBY_MAIN";
            }
            case 2600084: {
                return "TV_OPT_OPENSOURCE_MAIN";
            }
        }
        return "noScreenNameForIdAvailable";
    }
}

