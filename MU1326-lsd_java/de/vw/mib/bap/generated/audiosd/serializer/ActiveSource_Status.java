/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.ActiveSource_Status$ListAvailable;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status
implements StatusProperty {
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE;
    public static final int SOURCE_TYPE_NO_SOURCE_ACTIVE;
    public static final int SOURCE_TYPE_FM;
    public static final int SOURCE_TYPE_AM;
    public static final int SOURCE_TYPE_DAB;
    public static final int SOURCE_TYPE_SDARS_XM;
    public static final int SOURCE_TYPE_SDARS_SIRIUS;
    public static final int SOURCE_TYPE_CD;
    public static final int SOURCE_TYPE_CD_CHANGER;
    public static final int SOURCE_TYPE_DVD;
    public static final int SOURCE_TYPE_TV;
    public static final int SOURCE_TYPE_HDD;
    public static final int SOURCE_TYPE_SD;
    public static final int SOURCE_TYPE_TP_MEMO_TIM;
    public static final int SOURCE_TYPE_AUX_IN_AUDIO;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI;
    public static final int SOURCE_TYPE_GENERIC_PLAYER;
    public static final int SOURCE_TYPE_AM_TI_JAPAN;
    public static final int SOURCE_TYPE_DVD_CHANGER;
    public static final int SOURCE_TYPE_USB;
    public static final int SOURCE_TYPE_JUKEBOX;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL;
    public static final int SOURCE_TYPE_DVB_VIDEO_SERVICE;
    public static final int SOURCE_TYPE_DVB_AUDIO_SERVICE;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER;
    public static final int SOURCE_TYPE_BLUE_RAY;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO_TV;
    public static final int SOURCE_TYPE_HDMI_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1;
    public static final int SOURCE_TYPE_COMMON_LIST_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_APPLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_MIRROR_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_GOOGLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_BAIDU_LINK_DF4_4;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public int sourceList_Reference;
    private static final int SOURCE_LIST_REFERENCE_BITSIZE;
    public int typeOfNumber;
    private static final int TYPE_OF_NUMBER_BITSIZE;
    public static final int TYPE_OF_NUMBER_ANY_MEANING;
    public static final int TYPE_OF_NUMBER_PRESET_BANK_ID;
    public static final int TYPE_OF_NUMBER_PRESET_ID;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_BANK_ID;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_ID;
    public static final int TYPE_OF_NUMBER_CD_DVD_BLUE_RAY_ID;
    public static final int TYPE_OF_NUMBER_INVALID_NUMBER;
    public final ActiveSource_Status$ListAvailable listAvailable = new ActiveSource_Status$ListAvailable();
    public int list_State;
    private static final int LIST_STATE_BITSIZE;
    public static final int LIST_STATE_UNKNOWN_LIST_STATE;
    public static final int LIST_STATE_LIST_IS_BEING_LOADED;
    public static final int LIST_STATE_LIST_IS_INCOMPLETELY_LOADED;
    public static final int LIST_STATE_LIST_COMPLETELY_LOADED;
    public static final int LIST_STATE_LIST_IS_BEING_UPDATED;
    public static final int EXTENSION1_MIN;
    public int extension1;
    private static final int EXTENSION1_BITSIZE;
    public int number;
    private static final int NUMBER_BITSIZE;

    public ActiveSource_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceType = 0;
        this.sourceList_Reference = 0;
        this.typeOfNumber = 0;
        this.list_State = 0;
        this.extension1 = 0;
        this.number = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.listAvailable.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPEntity;
        return this.sourceType == activeSource_Status.sourceType && this.sourceList_Reference == activeSource_Status.sourceList_Reference && this.typeOfNumber == activeSource_Status.typeOfNumber && this.listAvailable.equalTo(activeSource_Status.listAvailable) && this.list_State == activeSource_Status.list_State && this.extension1 == activeSource_Status.extension1 && this.number == activeSource_Status.number;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveSource_Status:");
        stringBuffer.append("\n - SourceType: ");
        switch (this.sourceType) {
            case 0: {
                stringBuffer.append("0x00 (no source active)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (FM)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (AM)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (DAB)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (SDARS-XM)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (SDARS-SIRIUS)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (CD)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (CD changer)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (DVD)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (TV)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (HDD)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (SD)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (TP-Memo / TIM)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (Aux-In Audio)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (Aux-In Video)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (portable device (MDI, AMI))");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (generic player)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (AM-TI (Japan))");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (DVD changer)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (USB)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (Jukebox)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (Bluetooth connection - BT stream)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (Bluetooth connection - remote control protocol)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (DVB - video service)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (DVB - audio service)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (AM-SW (\\\"Kurzwelle\\\" / short wave))");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (AM-LW (\\\"Langwelle\\\" / long wave))");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (WLAN connection - mass storage)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (WLAN connection - RCP (Remote Control Player))");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (BlueRay)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (BlueRay changer)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (Flash (flash memory))");
                break;
            }
            case 32: {
                stringBuffer.append("0x20 (Aux-in Video (TV))");
                break;
            }
            case 33: {
                stringBuffer.append("0x21 (HDMI (DF4.1))");
                break;
            }
            case 34: {
                stringBuffer.append("0x22 (online mass storage (DF4.1))");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (online radio (DF4.1))");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (CommonList (DF4.2))");
                break;
            }
            case 37: {
                stringBuffer.append("0x25 (MobileDevice (AppleLink) (DF4.2))");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (MobileDevice (MirrorLink) (DF4.2))");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (MobileDevice (GoogleLink) (DF4.2))");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (MobileDevice (BaiduLink) (DF4.4))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown source)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - SourceList_Reference - ");
        stringBuffer.append(this.sourceList_Reference);
        stringBuffer.append("\n - TypeOfNumber: ");
        switch (this.typeOfNumber) {
            case 0: {
                stringBuffer.append("0x0 (any meaning)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (preset bank ID)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (preset ID)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (auto store bank ID)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (auto store ID)");
                break;
            }
            case 5: {
                stringBuffer.append("0x5 (CD/DVD/BlueRay-ID (CD-No from CD changer / DVD-No from DVD changer / BlueRay-No from BlueRay changer))");
                break;
            }
            case 15: {
                stringBuffer.append("0xF (invalid \\\"number\\\")");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ListAvailable - ");
        stringBuffer.append(this.listAvailable.toString());
        stringBuffer.append("\n - List_State: ");
        switch (this.list_State) {
            case 0: {
                stringBuffer.append("0x0 (unknown list state)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (list is being loaded)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (list is incompletely loaded)");
                break;
            }
            case 3: {
                stringBuffer.append("0x3 (list completely loaded)");
                break;
            }
            case 4: {
                stringBuffer.append("0x4 (list is being updated)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        stringBuffer.append("\n - Number - ");
        stringBuffer.append(this.number);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        n += 4;
        n += this.listAvailable.bitSize();
        n += 4;
        n += 4;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sourceType);
        bitStream.pushShort((short)this.sourceList_Reference);
        bitStream.pushBits(4, this.typeOfNumber);
        this.listAvailable.serialize(bitStream);
        bitStream.pushBits(4, this.list_State);
        bitStream.pushBits(4, this.extension1);
        bitStream.pushByte((byte)this.number);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceType = bitStream.popFrontByte();
        this.sourceList_Reference = bitStream.popFrontShort();
        this.typeOfNumber = bitStream.popFrontBits(4);
        this.listAvailable.deserialize(bitStream);
        this.list_State = bitStream.popFrontBits(4);
        this.extension1 = bitStream.popFrontBits(4);
        this.number = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return ActiveSource_Status.functionId();
    }
}

