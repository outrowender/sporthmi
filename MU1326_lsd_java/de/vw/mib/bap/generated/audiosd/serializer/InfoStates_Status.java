/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoStates_Status
implements StatusProperty {
    public int states;
    private static final int STATES_BITSIZE;
    public static final int STATES_NO_ERROR;
    public static final int STATES_ERROR_UNSPECIFIED;
    public static final int STATES_NO_CD;
    public static final int STATES_NO_DVD;
    public static final int STATES_NO_SD;
    public static final int STATES_CHECK_MEDIA;
    public static final int STATES_NO_MEDIA;
    public static final int STATES_NO_MEDIA_INSERTED;
    public static final int STATES_MEDIA_NOT_READABLE;
    public static final int STATES_MEDIA_IS_BEING_LOADED;
    public static final int STATES_MEDIA_IS_BEING_EJECTED;
    public static final int STATES_TEMPERATURE_TOO_HIGH;
    public static final int STATES_NO_STORAGE_SPACE_ON_MEDIUM_LEFT_SD_CARD_FULL;
    public static final int STATES_SIRIUS_NOT_SUBSCRIBED_SDARS;
    public static final int STATES_XM_NOT_SUBSCRIBED_SDARS;
    public static final int STATES_GCI_UPDATE_IN_PROGRESS_SDARS;
    public static final int STATES_AUX_IN_AUDIO;
    public static final int STATES_AUX_IN_VIDEO;
    public static final int STATES_ENTER_CODE;
    public static final int STATES_PLEASE_WAIT;
    public static final int STATES_INSERT_DISK;
    public static final int STATES_SELECT_DISK;
    public static final int STATES_SELECT_CD_POSITION;
    public static final int STATES_REMOVE_DISK;
    public static final int STATES_SAVING_DATA;
    public static final int STATES_RETRIEVING_DATA;
    public static final int STATES_SHUTTING_DOWN;
    public static final int STATES_CREATING_AUTO_STORE_LIST;
    public static final int STATES_CREATING_INITIAL_AUTO_STORE_LIST;
    public static final int STATES_NO_SAT_RADIO_AVAILABLE_NO_SAT_TUNER_CONNECTED;
    public static final int STATES_DIAGNOSIS_SESSION_ACTIVE;
    public static final int STATES_SOFTWARE_UPDATE_IN_PROGRESS;
    public static final int STATES_TA_MESSAGE_IS_BEING_RECORDED;
    public static final int STATES_SDS_INITIALISING_SDS_IS_BEING_INITIALISED;
    public static final int STATES_NO_PLAYABLE_FILES;
    public static final int STATES_WRONG_REGION_CODE_SOME_CHANGES_LEFT;
    public static final int STATES_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    public static final int STATES_CONNECTION_ERROR_WIRED_CONNECTION;
    public static final int STATES_CONNECTION_ERROR_WIRELESS_CONNECTION;
    public static final int STATES_NO_DEVICE_CONECTED;
    public static final int STATES_BLUETOOTH_ERROR_UNSPECIFIED;
    public static final int STATES_BLUETOOTH_DEACTIVATED;
    public static final int STATES_BLUETOOTH_OFF_DUE_TO_CLAMP_S_OFF;
    public static final int STATES_NO_BT_AUDIO_PLAYER_CONNECTED;
    public static final int STATES_FILE_CORRUPTED;
    public static final int STATES_FILE_IS_DRM_PROTECTED;
    public static final int STATES_IMPORT_RUNNING;
    public static final int STATES_CHILDLOCK_ERROR;
    public static final int STATES_WLAN_CONNECT_IN_PROGRESS;
    public static final int STATES_NO_WLAN_PLAYER_IN_SYSTEM;
    public static final int STATES_WLAN_S_CONTACT_MISSING;
    public static final int STATES_WLAN_DEACTIVATED;
    public static final int STATES_UNSPECIFIC_WLAN_ERROR;
    public static final int STATES_OVERCURRENT;
    public static final int STATES_CABLE_ERROR;
    public static final int STATES_SUBSCRIPTION_UPDATE_PSV_UPDATE_SDARS;
    public static final int STATES_ANTENNA_ERROR_SDARS;
    public static final int STATES_NO_TP_TIM_MESSAGES_RECORDED;
    public static final int STATES_MEDIUM_WRITE_PROTECTED_SD_CARD_WRITE_PROTECTED;
    public static final int STATES_JUBEBOX_IS_BEEING_DELETED;
    public static final int STATES_JUKEBOX_IS_STILL_EMPTY;
    public static final int STATES_BT_AUDIO_PLAYER_DEACTIVATED;
    public static final int STATES_BT_AUTOMATIC_RECONNECT;
    public static final int STATES_WLAN_PLAYER_DEACTIVATED;
    public static final int STATES_TEMPERATURE_TOO_LOW;
    public static final int STATES_EXTERNAL_DEVICE_NOT_SUPPORTED;
    public static final int STATES_EXTERNAL_DEVICE_FIRMWARE_ERROR;
    public static final int STATES_HANDBOOK_VIDEO_ACTIVE;
    public static final int STATES_MEDIA_DEVICE_IS_BEING_CONNECTED_DF_4_1;
    public static final int STATES_SDARS_TUNER_IS_BEING_INITALISED_DF_4_1;
    public static final int STATES_FILES_BEING_USED_AS_RINGTONE_DF_4_1;
    public static final int STATES_NO_APP_ACTIVATED_DF4_4;
    public static final int STATES_UNKNOWN;

    public InfoStates_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoStates_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.states = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoStates_Status infoStates_Status = (InfoStates_Status)bAPEntity;
        return this.states == infoStates_Status.states;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InfoStates_Status:");
        stringBuffer.append("\n - States: ");
        switch (this.states) {
            case 0: {
                stringBuffer.append("0x00 (no error)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (error (unspecified))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (no CD)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (no DVD)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (no SD)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (check media)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (no media)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (no media inserted)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (media not readable)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (media is being loaded)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (media is being ejected)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (temperature too high)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (no storage space on medium left / SD card full)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (Sirius not subscribed (SDARS))");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (XM not subscribed (SDARS))");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (GCI update in progress (SDARS))");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (Aux-In: Audio)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (Aux-In: Video)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (enter code)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (please wait)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (insert disk)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (select disk)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (select CD position)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (remove disk)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (saving data)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (retrieving data)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (shutting down)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (creating auto store list)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (creating initial auto store list)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (no SAT radio available / no SAT tuner connected)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (diagnosis session active)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (software update in progress)");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (TA message is being recorded)");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (SDS initialising (SDS is being initialised))");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (no playable files)");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (wrong region code - some changes left)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (wrong region code - no changes left)");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (connection error (wired connection))");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (connection error (wireless connection))");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (no device conected)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (bluetooth error - unspecified)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (bluetooth deactivated)");
                break;
            }
            case 42: {
                stringBuffer.append("0x2A (bluetooth off - due to clamp S off)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (no BT audio player connected)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (file corrupted)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (file is DRM protected)");
                break;
            }
            case 46: {
                stringBuffer.append("0x2E (import running)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (childlock error)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (WLAN connect in progress)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (no WLAN Player in system)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (WLAN  - S contact missing)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (WLAN deactivated)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (unspecific WLAN error)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (overcurrent)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (cable error)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (Subscription Update (PSV-Update) (SDARS))");
                break;
            }
            case 56: {
                stringBuffer.append("0x38 (Antenna Error (SDARS))");
                break;
            }
            case 57: {
                stringBuffer.append("0x39 (no TP/TIM message(s) recorded)");
                break;
            }
            case 58: {
                stringBuffer.append("0x3A (medium write protected / SD card write protected)");
                break;
            }
            case 59: {
                stringBuffer.append("0x3B (Jubebox is beeing deleted)");
                break;
            }
            case 60: {
                stringBuffer.append("0x3C (Jukebox is (still) empty)");
                break;
            }
            case 61: {
                stringBuffer.append("0x3D (BT audio player deactivated)");
                break;
            }
            case 62: {
                stringBuffer.append("0x3E (BT: automatic reconnect)");
                break;
            }
            case 63: {
                stringBuffer.append("0x3F (WLAN player deactivated)");
                break;
            }
            case 64: {
                stringBuffer.append("0x40 (temperature too low)");
                break;
            }
            case 65: {
                stringBuffer.append("0x41 (external device not supported)");
                break;
            }
            case 66: {
                stringBuffer.append("0x42 (external device: firmware error)");
                break;
            }
            case 67: {
                stringBuffer.append("0x43 (handbook video active)");
                break;
            }
            case 68: {
                stringBuffer.append("0x44 (media device is being connected (DF 4.1))");
                break;
            }
            case 69: {
                stringBuffer.append("0x45 (SDARS tuner is being initalised (DF 4.1))");
                break;
            }
            case 70: {
                stringBuffer.append("0x46 (files being used as ringtone (DF 4.1))");
                break;
            }
            case 71: {
                stringBuffer.append("0x47 (no App activated (DF4.4))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.states);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.states = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 30;
    }

    @Override
    public int getFunctionId() {
        return InfoStates_Status.functionId();
    }
}

