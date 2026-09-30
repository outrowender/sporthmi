/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.audio;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsAudio
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_ACTIVE_SOURCE = "0x10 (ACTIVE_SOURCE)";
    private static final String DESCRIPTION_ACTIVE_SOURCE_NAME = "0x11 (ACTIVE_SOURCE_NAME)";
    private static final String DESCRIPTION_CURRENT_VOLUME = "0x12 (CURRENT_VOLUME)";
    private static final String DESCRIPTION_MUTE = "0x13 (MUTE)";
    private static final String DESCRIPTION_SOURCE_STATE = "0x14 (SOURCE_STATE)";
    private static final String DESCRIPTION_CURRENT_STATION_INFO = "0x15 (CURRENT_STATION_INFO)";
    private static final String DESCRIPTION_CURRENT_STATION_HANDLE = "0x16 (CURRENT_STATION_HANDLE)";
    private static final String DESCRIPTION_RECEPTION_LIST = "0x17 (RECEPTION_LIST)";
    private static final String DESCRIPTION_DEDICATED_AUDIO_CONTROL = "0x18 (DEDICATED_AUDIO_CONTROL)";
    private static final String DESCRIPTION_GENERAL_INFO_SWITCHES = "0x19 (GENERAL_INFO_SWITCHES)";
    private static final String DESCRIPTION_TP_MEMO_INFO = "0x1a (TP_MEMO_INFO)";
    private static final String DESCRIPTION_TP_MEMO_LIST = "0x1b (TP_MEMO_LIST)";
    private static final String DESCRIPTION_ANNOUNCEMENT_INFO = "0x1c (ANNOUNCEMENT_INFO)";
    private static final String DESCRIPTION_ANNOUNCEMENT_ESCAPE = "0x1d (ANNOUNCEMENT_ESCAPE)";
    private static final String DESCRIPTION_INFO_STATES = "0x1e (INFO_STATES)";
    private static final String DESCRIPTION_RECEPTION_LIST_TYPE = "0x1f (RECEPTION_LIST_TYPE)";
    private static final String DESCRIPTION_SOURCE_LIST = "0x20 (SOURCE_LIST)";
    private static final String DESCRIPTION_RADIO_TV_PRESET_LIST = "0x21 (RADIO_TV_PRESET_LIST)";
    private static final String DESCRIPTION_SWITCH_SOURCE = "0x22 (SWITCH_SOURCE)";
    private static final String DESCRIPTION_MEDIA_BROWSER_FOLDER_LEVEL = "0x23 (MEDIA_BROWSER_FOLDER_LEVEL)";
    private static final String DESCRIPTION_MEDIA_BROWSER = "0x24 (MEDIA_BROWSER)";
    private static final String DESCRIPTION_MEDIA_PATH = "0x25 (MEDIA_PATH)";
    private static final String DESCRIPTION_MEDIA_BROWSER_CONTROL = "0x26 (MEDIA_BROWSER_CONTROL)";
    private static final String DESCRIPTION_MEDIA_FILE_INFO = "0x27 (MEDIA_FILE_INFO)";
    private static final String DESCRIPTION_PREFERRED_LIST = "0x28 (PREFERRED_LIST)";
    private static final String DESCRIPTION_SDS_STATE = "0x29 (SDS_STATE)";
    private static final String DESCRIPTION_FUNCTION_SYNCHRONISATION = "0x2a (FUNCTION_SYNCHRONISATION)";
    private static final String DESCRIPTION_ASG_CAPABILITIES = "0x2b (ASG_CAPABILITIES)";
    private static final String DESCRIPTION_GET_NEXT_LIST_POS = "0x2c (GET_NEXT_LIST_POS)";
    private static final String DESCRIPTION_SWITCH_RADIO_MEDIA = "0x2d (SWITCH_RADIO_MEDIA)";
    private static final String DESCRIPTION_MEDIA_IMPORT_STATE = "0x2e (MEDIA_IMPORT_STATE)";
    private static final String DESCRIPTION_CURRENT_VOLUME_EXTENDED = "0x2f (CURRENT_VOLUME_EXTENDED)";
    private static final String DESCRIPTION_CUSTOMER_DOWNLOAD_STATE = "0x30 (CUSTOMER_DOWNLOAD_STATE)";
    private static final String DESCRIPTION_ONLINE_MUSIC_STATE = "0x31 (ONLINE_MUSIC_STATE)";
    private static final String DESCRIPTION_COMMON_LIST = "0x32 (COMMON_LIST)";
    private static final String DESCRIPTION_CURRENT_STATION_HANDLE2 = "0x33 (CURRENT_STATION_HANDLE2)";
    private static final String DESCRIPTION_PLAY_POSITION = "0x34 (PLAY_POSITION)";
    private static final String FCT_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 2: {
                return DESCRIPTION_BAP_CONFIG;
            }
            case 3: {
                return DESCRIPTION_FUNCTION_LIST;
            }
            case 14: {
                return DESCRIPTION_FSG_SETUP;
            }
            case 15: {
                return DESCRIPTION_FSG_OPERATION_STATE;
            }
            case 16: {
                return DESCRIPTION_ACTIVE_SOURCE;
            }
            case 17: {
                return DESCRIPTION_ACTIVE_SOURCE_NAME;
            }
            case 18: {
                return DESCRIPTION_CURRENT_VOLUME;
            }
            case 19: {
                return DESCRIPTION_MUTE;
            }
            case 20: {
                return DESCRIPTION_SOURCE_STATE;
            }
            case 21: {
                return DESCRIPTION_CURRENT_STATION_INFO;
            }
            case 22: {
                return DESCRIPTION_CURRENT_STATION_HANDLE;
            }
            case 23: {
                return DESCRIPTION_RECEPTION_LIST;
            }
            case 24: {
                return DESCRIPTION_DEDICATED_AUDIO_CONTROL;
            }
            case 25: {
                return DESCRIPTION_GENERAL_INFO_SWITCHES;
            }
            case 26: {
                return DESCRIPTION_TP_MEMO_INFO;
            }
            case 27: {
                return DESCRIPTION_TP_MEMO_LIST;
            }
            case 28: {
                return DESCRIPTION_ANNOUNCEMENT_INFO;
            }
            case 29: {
                return DESCRIPTION_ANNOUNCEMENT_ESCAPE;
            }
            case 30: {
                return DESCRIPTION_INFO_STATES;
            }
            case 31: {
                return DESCRIPTION_RECEPTION_LIST_TYPE;
            }
            case 32: {
                return DESCRIPTION_SOURCE_LIST;
            }
            case 33: {
                return DESCRIPTION_RADIO_TV_PRESET_LIST;
            }
            case 34: {
                return DESCRIPTION_SWITCH_SOURCE;
            }
            case 35: {
                return DESCRIPTION_MEDIA_BROWSER_FOLDER_LEVEL;
            }
            case 36: {
                return DESCRIPTION_MEDIA_BROWSER;
            }
            case 37: {
                return DESCRIPTION_MEDIA_PATH;
            }
            case 38: {
                return DESCRIPTION_MEDIA_BROWSER_CONTROL;
            }
            case 39: {
                return DESCRIPTION_MEDIA_FILE_INFO;
            }
            case 40: {
                return DESCRIPTION_PREFERRED_LIST;
            }
            case 41: {
                return DESCRIPTION_SDS_STATE;
            }
            case 42: {
                return DESCRIPTION_FUNCTION_SYNCHRONISATION;
            }
            case 43: {
                return DESCRIPTION_ASG_CAPABILITIES;
            }
            case 44: {
                return DESCRIPTION_GET_NEXT_LIST_POS;
            }
            case 45: {
                return DESCRIPTION_SWITCH_RADIO_MEDIA;
            }
            case 46: {
                return DESCRIPTION_MEDIA_IMPORT_STATE;
            }
            case 47: {
                return DESCRIPTION_CURRENT_VOLUME_EXTENDED;
            }
            case 48: {
                return DESCRIPTION_CUSTOMER_DOWNLOAD_STATE;
            }
            case 49: {
                return DESCRIPTION_ONLINE_MUSIC_STATE;
            }
            case 50: {
                return DESCRIPTION_COMMON_LIST;
            }
            case 51: {
                return DESCRIPTION_CURRENT_STATION_HANDLE2;
            }
            case 52: {
                return DESCRIPTION_PLAY_POSITION;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

