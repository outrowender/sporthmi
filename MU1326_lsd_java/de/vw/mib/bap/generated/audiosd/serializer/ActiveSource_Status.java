/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status
implements StatusProperty {
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE = 8;
    public static final int SOURCE_TYPE_NO_SOURCE_ACTIVE = 0;
    public static final int SOURCE_TYPE_FM = 1;
    public static final int SOURCE_TYPE_AM = 2;
    public static final int SOURCE_TYPE_DAB = 3;
    public static final int SOURCE_TYPE_SDARS_XM = 4;
    public static final int SOURCE_TYPE_SDARS_SIRIUS = 5;
    public static final int SOURCE_TYPE_CD = 6;
    public static final int SOURCE_TYPE_CD_CHANGER = 7;
    public static final int SOURCE_TYPE_DVD = 8;
    public static final int SOURCE_TYPE_TV = 9;
    public static final int SOURCE_TYPE_HDD = 10;
    public static final int SOURCE_TYPE_SD = 11;
    public static final int SOURCE_TYPE_TP_MEMO_TIM = 12;
    public static final int SOURCE_TYPE_AUX_IN_AUDIO = 13;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO = 14;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI = 15;
    public static final int SOURCE_TYPE_GENERIC_PLAYER = 16;
    public static final int SOURCE_TYPE_AM_TI_JAPAN = 17;
    public static final int SOURCE_TYPE_DVD_CHANGER = 18;
    public static final int SOURCE_TYPE_USB = 19;
    public static final int SOURCE_TYPE_JUKEBOX = 20;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM = 21;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL = 22;
    public static final int SOURCE_TYPE_DVB_VIDEO_SERVICE = 23;
    public static final int SOURCE_TYPE_DVB_AUDIO_SERVICE = 24;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE = 25;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE = 26;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE = 27;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER = 28;
    public static final int SOURCE_TYPE_BLUE_RAY = 29;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER = 30;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY = 31;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO_TV = 32;
    public static final int SOURCE_TYPE_HDMI_DF4_1 = 33;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1 = 34;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1 = 35;
    public static final int SOURCE_TYPE_COMMON_LIST_DF4_2 = 36;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_APPLE_LINK_DF4_2 = 37;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_MIRROR_LINK_DF4_2 = 38;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_GOOGLE_LINK_DF4_2 = 39;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_BAIDU_LINK_DF4_4 = 40;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE = 255;
    public int sourceList_Reference;
    private static final int SOURCE_LIST_REFERENCE_BITSIZE = 16;
    public int typeOfNumber;
    private static final int TYPE_OF_NUMBER_BITSIZE = 4;
    public static final int TYPE_OF_NUMBER_ANY_MEANING = 0;
    public static final int TYPE_OF_NUMBER_PRESET_BANK_ID = 1;
    public static final int TYPE_OF_NUMBER_PRESET_ID = 2;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_BANK_ID = 3;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_ID = 4;
    public static final int TYPE_OF_NUMBER_CD_DVD_BLUE_RAY_ID = 5;
    public static final int TYPE_OF_NUMBER_INVALID_NUMBER = 15;
    public final ListAvailable listAvailable = new ListAvailable();
    public int list_State;
    private static final int LIST_STATE_BITSIZE = 4;
    public static final int LIST_STATE_UNKNOWN_LIST_STATE = 0;
    public static final int LIST_STATE_LIST_IS_BEING_LOADED = 1;
    public static final int LIST_STATE_LIST_IS_INCOMPLETELY_LOADED = 2;
    public static final int LIST_STATE_LIST_COMPLETELY_LOADED = 3;
    public static final int LIST_STATE_LIST_IS_BEING_UPDATED = 4;
    public static final int EXTENSION1_MIN = 0;
    public int extension1;
    private static final int EXTENSION1_BITSIZE = 4;
    public int number;
    private static final int NUMBER_BITSIZE = 8;

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

    public void reset() {
        this.internalReset();
        this.listAvailable.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPEntity;
        return this.sourceType == activeSource_Status.sourceType && this.sourceList_Reference == activeSource_Status.sourceList_Reference && this.typeOfNumber == activeSource_Status.typeOfNumber && this.listAvailable.equalTo(activeSource_Status.listAvailable) && this.list_State == activeSource_Status.list_State && this.extension1 == activeSource_Status.extension1 && this.number == activeSource_Status.number;
    }

    private void customInitialization() {
    }

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

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sourceType);
        bitStream.pushShort((short)this.sourceList_Reference);
        bitStream.pushBits(4, this.typeOfNumber);
        this.listAvailable.serialize(bitStream);
        bitStream.pushBits(4, this.list_State);
        bitStream.pushBits(4, this.extension1);
        bitStream.pushByte((byte)this.number);
    }

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

    public int getFunctionId() {
        return ActiveSource_Status.functionId();
    }

    public static final class ListAvailable
    implements BAPEntity {
        public boolean reserved_bit_3;
        public boolean mediaBrowserListAvailable;
        public boolean presetListAvailable;
        public boolean receptionListAvailable;
        private static final int LIST_AVAILABLE_BITSIZE = 4;

        public ListAvailable() {
            this.internalReset();
            this.customInitialization();
        }

        public ListAvailable(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_3 = false;
            this.mediaBrowserListAvailable = false;
            this.presetListAvailable = false;
            this.receptionListAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ListAvailable listAvailable = (ListAvailable)bAPEntity;
            return this.reserved_bit_3 == listAvailable.reserved_bit_3 && this.mediaBrowserListAvailable == listAvailable.mediaBrowserListAvailable && this.presetListAvailable == listAvailable.presetListAvailable && this.receptionListAvailable == listAvailable.receptionListAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ListAvailable:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.reserved_bit_3) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mediaBrowserListAvailable) {
                stringBuffer.append("true  (media browser list available");
            } else {
                stringBuffer.append("false  (media browser list not available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.presetListAvailable) {
                stringBuffer.append("true  (preset list available");
            } else {
                stringBuffer.append("false  (preset list not available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.receptionListAvailable) {
                stringBuffer.append("true  (reception list available");
            } else {
                stringBuffer.append("false  (reception list not available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_3);
            bitStream.pushBoolean(this.mediaBrowserListAvailable);
            bitStream.pushBoolean(this.presetListAvailable);
            bitStream.pushBoolean(this.receptionListAvailable);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_3 = bitStream.popFrontBoolean();
            this.mediaBrowserListAvailable = bitStream.popFrontBoolean();
            this.presetListAvailable = bitStream.popFrontBoolean();
            this.receptionListAvailable = bitStream.popFrontBoolean();
        }
    }
}

