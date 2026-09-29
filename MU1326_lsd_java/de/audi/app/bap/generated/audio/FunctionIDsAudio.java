/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.audio;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsAudio
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_ACTIVE_SOURCE;
    private static final String DESCRIPTION_ACTIVE_SOURCE_NAME;
    private static final String DESCRIPTION_CURRENT_VOLUME;
    private static final String DESCRIPTION_MUTE;
    private static final String DESCRIPTION_SOURCE_STATE;
    private static final String DESCRIPTION_CURRENT_STATION_INFO;
    private static final String DESCRIPTION_CURRENT_STATION_HANDLE;
    private static final String DESCRIPTION_RECEPTION_LIST;
    private static final String DESCRIPTION_DEDICATED_AUDIO_CONTROL;
    private static final String DESCRIPTION_GENERAL_INFO_SWITCHES;
    private static final String DESCRIPTION_TP_MEMO_INFO;
    private static final String DESCRIPTION_TP_MEMO_LIST;
    private static final String DESCRIPTION_ANNOUNCEMENT_INFO;
    private static final String DESCRIPTION_ANNOUNCEMENT_ESCAPE;
    private static final String DESCRIPTION_INFO_STATES;
    private static final String DESCRIPTION_RECEPTION_LIST_TYPE;
    private static final String DESCRIPTION_SOURCE_LIST;
    private static final String DESCRIPTION_RADIO_TV_PRESET_LIST;
    private static final String DESCRIPTION_SWITCH_SOURCE;
    private static final String DESCRIPTION_MEDIA_BROWSER_FOLDER_LEVEL;
    private static final String DESCRIPTION_MEDIA_BROWSER;
    private static final String DESCRIPTION_MEDIA_PATH;
    private static final String DESCRIPTION_MEDIA_BROWSER_CONTROL;
    private static final String DESCRIPTION_MEDIA_FILE_INFO;
    private static final String DESCRIPTION_PREFERRED_LIST;
    private static final String DESCRIPTION_SDS_STATE;
    private static final String DESCRIPTION_FUNCTION_SYNCHRONISATION;
    private static final String DESCRIPTION_ASG_CAPABILITIES;
    private static final String DESCRIPTION_GET_NEXT_LIST_POS;
    private static final String DESCRIPTION_SWITCH_RADIO_MEDIA;
    private static final String DESCRIPTION_MEDIA_IMPORT_STATE;
    private static final String DESCRIPTION_CURRENT_VOLUME_EXTENDED;
    private static final String DESCRIPTION_CUSTOMER_DOWNLOAD_STATE;
    private static final String DESCRIPTION_ONLINE_MUSIC_STATE;
    private static final String DESCRIPTION_COMMON_LIST;
    private static final String DESCRIPTION_CURRENT_STATION_HANDLE2;
    private static final String DESCRIPTION_PLAY_POSITION;
    private static final String FCT_ID_UNKNOWN;

    @Override
    public String getDescription(int n) {
        switch (n) {
            case 2: {
                return "0x2 (BAP_CONFIG)";
            }
            case 3: {
                return "0x3 (FUNCTION_LIST)";
            }
            case 14: {
                return "0xe (FSG_SETUP)";
            }
            case 15: {
                return "0xf (FSG_OPERATION_STATE)";
            }
            case 16: {
                return "0x10 (ACTIVE_SOURCE)";
            }
            case 17: {
                return "0x11 (ACTIVE_SOURCE_NAME)";
            }
            case 18: {
                return "0x12 (CURRENT_VOLUME)";
            }
            case 19: {
                return "0x13 (MUTE)";
            }
            case 20: {
                return "0x14 (SOURCE_STATE)";
            }
            case 21: {
                return "0x15 (CURRENT_STATION_INFO)";
            }
            case 22: {
                return "0x16 (CURRENT_STATION_HANDLE)";
            }
            case 23: {
                return "0x17 (RECEPTION_LIST)";
            }
            case 24: {
                return "0x18 (DEDICATED_AUDIO_CONTROL)";
            }
            case 25: {
                return "0x19 (GENERAL_INFO_SWITCHES)";
            }
            case 26: {
                return "0x1a (TP_MEMO_INFO)";
            }
            case 27: {
                return "0x1b (TP_MEMO_LIST)";
            }
            case 28: {
                return "0x1c (ANNOUNCEMENT_INFO)";
            }
            case 29: {
                return "0x1d (ANNOUNCEMENT_ESCAPE)";
            }
            case 30: {
                return "0x1e (INFO_STATES)";
            }
            case 31: {
                return "0x1f (RECEPTION_LIST_TYPE)";
            }
            case 32: {
                return "0x20 (SOURCE_LIST)";
            }
            case 33: {
                return "0x21 (RADIO_TV_PRESET_LIST)";
            }
            case 34: {
                return "0x22 (SWITCH_SOURCE)";
            }
            case 35: {
                return "0x23 (MEDIA_BROWSER_FOLDER_LEVEL)";
            }
            case 36: {
                return "0x24 (MEDIA_BROWSER)";
            }
            case 37: {
                return "0x25 (MEDIA_PATH)";
            }
            case 38: {
                return "0x26 (MEDIA_BROWSER_CONTROL)";
            }
            case 39: {
                return "0x27 (MEDIA_FILE_INFO)";
            }
            case 40: {
                return "0x28 (PREFERRED_LIST)";
            }
            case 41: {
                return "0x29 (SDS_STATE)";
            }
            case 42: {
                return "0x2a (FUNCTION_SYNCHRONISATION)";
            }
            case 43: {
                return "0x2b (ASG_CAPABILITIES)";
            }
            case 44: {
                return "0x2c (GET_NEXT_LIST_POS)";
            }
            case 45: {
                return "0x2d (SWITCH_RADIO_MEDIA)";
            }
            case 46: {
                return "0x2e (MEDIA_IMPORT_STATE)";
            }
            case 47: {
                return "0x2f (CURRENT_VOLUME_EXTENDED)";
            }
            case 48: {
                return "0x30 (CUSTOMER_DOWNLOAD_STATE)";
            }
            case 49: {
                return "0x31 (ONLINE_MUSIC_STATE)";
            }
            case 50: {
                return "0x32 (COMMON_LIST)";
            }
            case 51: {
                return "0x33 (CURRENT_STATION_HANDLE2)";
            }
            case 52: {
                return "0x34 (PLAY_POSITION)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

