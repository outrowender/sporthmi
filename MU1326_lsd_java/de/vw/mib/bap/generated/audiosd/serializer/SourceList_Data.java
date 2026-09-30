/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES_NAME = 0;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES = 1;
    public static final int RECORD_ADDRESS_NAME = 2;
    public static final int RECORD_ADDRESS_ATTRIBUTES = 3;
    public static final int RECORD_ADDRESS_MEDIA_TYPE = 4;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE = 8;
    public static final int SOURCE_TYPE_NO_SOURCE = 0;
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
    public int instance_Id;
    private static final int INSTANCE_ID_BITSIZE = 8;
    public int mediaType;
    private static final int MEDIA_TYPE_BITSIZE = 8;
    public static final int MEDIA_TYPE_MEDIA_TYPE_NOT_AVAIALBLE_NOT_APPLICABLE = 0;
    public static final int MEDIA_TYPE_CD_AUDIO = 1;
    public static final int MEDIA_TYPE_DVD_AUDIO = 2;
    public static final int MEDIA_TYPE_DVD_VIDEO = 3;
    public static final int MEDIA_TYPE_CD_VIDEO = 4;
    public static final int MEDIA_TYPE_CD_ROM = 5;
    public static final int MEDIA_TYPE_DVD_ROM = 6;
    public static final int MEDIA_TYPE_FILE_SYSTEM = 7;
    public static final int MEDIA_TYPE_RAW = 8;
    public static final int MEDIA_TYPE_RCP_REMOTE_CONTROL_PROTOCOL = 9;
    public static final int MEDIA_TYPE_AUDIO_BROADCASTING_RADIO = 10;
    public static final int MEDIA_TYPE_VIDEO_BROADCASTING_TV_DVB = 11;
    public static final int MEDIA_TYPE_I_POD = 12;
    public static final int MEDIA_TYPE_BLUE_RAY = 13;
    public static final int MEDIA_TYPE_UNKNOWN_MEDIA_TYPE = 255;
    public final Attributes attributes;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH = 61;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }

    public SourceList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new Attributes();
        this.name = new BAPString(61);
        this.internalReset();
        this.customInitialization();
    }

    public SourceList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.sourceType = 0;
        this.instance_Id = 0;
        this.mediaType = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Data sourceList_Data = (SourceList_Data)bAPEntity;
        return this.arrayHeader.equalTo(sourceList_Data.arrayHeader) && this.pos == sourceList_Data.pos && this.sourceType == sourceList_Data.sourceType && this.instance_Id == sourceList_Data.instance_Id && this.mediaType == sourceList_Data.mediaType && this.attributes.equalTo(sourceList_Data.attributes) && this.name.equalTo(sourceList_Data.name);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SourceList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - SourceType: ");
        switch (this.sourceType) {
            case 0: {
                stringBuffer.append("0x00 (no source)");
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
                stringBuffer.append("0x22 (Online mass storage (DF4.1))");
                break;
            }
            case 35: {
                stringBuffer.append("0x23 (Online radio (DF4.1))");
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
        stringBuffer.append("\n - Instance_ID - ");
        stringBuffer.append(this.instance_Id);
        stringBuffer.append("\n - MediaType: ");
        switch (this.mediaType) {
            case 0: {
                stringBuffer.append("0x00 (media type not avaialble / not applicable)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (CD Audio)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (DVD Audio)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (DVD Video)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (CD Video)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (CD ROM)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (DVD ROM)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (file system)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (raw)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (RCP (Remote Control Protocol))");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (audio broadcasting (radio))");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (video broadcasting (TV, DVB))");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (iPOD)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (BlueRay)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unknown media type)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Attributes - ");
        stringBuffer.append(this.attributes.toString());
        stringBuffer.append("\n - Name - ");
        stringBuffer.append(this.name.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += 8;
                n += this.attributes.bitSize();
                n += this.name.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += 8;
                n += this.attributes.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.name.bitSize();
                break;
            }
            case 3: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.attributes.bitSize();
                break;
            }
            case 4: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                break;
            }
            case 15: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                break;
            }
        }
        return n;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                bitStream.pushByte((byte)this.instance_Id);
                bitStream.pushByte((byte)this.mediaType);
                this.attributes.serialize(bitStream);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                bitStream.pushByte((byte)this.instance_Id);
                bitStream.pushByte((byte)this.mediaType);
                this.attributes.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.mediaType);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.sourceType = bitStream.popFrontByte();
                this.instance_Id = bitStream.popFrontByte();
                this.mediaType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.name.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.sourceType = bitStream.popFrontByte();
                this.instance_Id = bitStream.popFrontByte();
                this.mediaType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.mediaType = bitStream.popFrontByte();
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    public static final class Attributes
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean mediumSupportBrowserList;
        public boolean noImportRunning;
        public boolean mediumIsNotBeingLoaded;
        public boolean mediumIsReadable;
        public boolean mediaIsPlayable;
        public boolean mediumAudioNoError;
        public boolean builtInAndReady;
        private static final int ATTRIBUTES_BITSIZE = 8;

        public Attributes() {
            this.internalReset();
            this.customInitialization();
        }

        public Attributes(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_7 = false;
            this.mediumSupportBrowserList = false;
            this.noImportRunning = false;
            this.mediumIsNotBeingLoaded = false;
            this.mediumIsReadable = false;
            this.mediaIsPlayable = false;
            this.mediumAudioNoError = false;
            this.builtInAndReady = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Attributes attributes = (Attributes)bAPEntity;
            return this.reserved_bit_7 == attributes.reserved_bit_7 && this.mediumSupportBrowserList == attributes.mediumSupportBrowserList && this.noImportRunning == attributes.noImportRunning && this.mediumIsNotBeingLoaded == attributes.mediumIsNotBeingLoaded && this.mediumIsReadable == attributes.mediumIsReadable && this.mediaIsPlayable == attributes.mediaIsPlayable && this.mediumAudioNoError == attributes.mediumAudioNoError && this.builtInAndReady == attributes.builtInAndReady;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attributes:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.reserved_bit_7) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.mediumSupportBrowserList) {
                stringBuffer.append("true  (medium support browser/list (DF4.2)");
            } else {
                stringBuffer.append("false  (medium not support browser/list (DF4.2)");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.noImportRunning) {
                stringBuffer.append("true  (no import running");
            } else {
                stringBuffer.append("false  (import running");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.mediumIsNotBeingLoaded) {
                stringBuffer.append("true  (medium is not being loaded");
            } else {
                stringBuffer.append("false  (medium is being loaded");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.mediumIsReadable) {
                stringBuffer.append("true  (medium is readable");
            } else {
                stringBuffer.append("false  (medium is not readable");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.mediaIsPlayable) {
                stringBuffer.append("true  (media is playable");
            } else {
                stringBuffer.append("false  (medium is not playable (no playable files)");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mediumAudioNoError) {
                stringBuffer.append("true  (medium/audio no error");
            } else {
                stringBuffer.append("false  (medium/audio source error");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.builtInAndReady) {
                stringBuffer.append("true  (built-in and ready (medium inserted)");
            } else {
                stringBuffer.append("false  (built-in but not ready (medium not inserted)");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_7);
            bitStream.pushBoolean(this.mediumSupportBrowserList);
            bitStream.pushBoolean(this.noImportRunning);
            bitStream.pushBoolean(this.mediumIsNotBeingLoaded);
            bitStream.pushBoolean(this.mediumIsReadable);
            bitStream.pushBoolean(this.mediaIsPlayable);
            bitStream.pushBoolean(this.mediumAudioNoError);
            bitStream.pushBoolean(this.builtInAndReady);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_7 = bitStream.popFrontBoolean();
            this.mediumSupportBrowserList = bitStream.popFrontBoolean();
            this.noImportRunning = bitStream.popFrontBoolean();
            this.mediumIsNotBeingLoaded = bitStream.popFrontBoolean();
            this.mediumIsReadable = bitStream.popFrontBoolean();
            this.mediaIsPlayable = bitStream.popFrontBoolean();
            this.mediumAudioNoError = bitStream.popFrontBoolean();
            this.builtInAndReady = bitStream.popFrontBoolean();
        }
    }
}

