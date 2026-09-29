/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.SourceList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES_NAME;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES;
    public static final int RECORD_ADDRESS_MEDIA_TYPE;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE;
    public static final int SOURCE_TYPE_NO_SOURCE;
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
    public int instance_Id;
    private static final int INSTANCE_ID_BITSIZE;
    public int mediaType;
    private static final int MEDIA_TYPE_BITSIZE;
    public static final int MEDIA_TYPE_MEDIA_TYPE_NOT_AVAIALBLE_NOT_APPLICABLE;
    public static final int MEDIA_TYPE_CD_AUDIO;
    public static final int MEDIA_TYPE_DVD_AUDIO;
    public static final int MEDIA_TYPE_DVD_VIDEO;
    public static final int MEDIA_TYPE_CD_VIDEO;
    public static final int MEDIA_TYPE_CD_ROM;
    public static final int MEDIA_TYPE_DVD_ROM;
    public static final int MEDIA_TYPE_FILE_SYSTEM;
    public static final int MEDIA_TYPE_RAW;
    public static final int MEDIA_TYPE_RCP_REMOTE_CONTROL_PROTOCOL;
    public static final int MEDIA_TYPE_AUDIO_BROADCASTING_RADIO;
    public static final int MEDIA_TYPE_VIDEO_BROADCASTING_TV_DVB;
    public static final int MEDIA_TYPE_I_POD;
    public static final int MEDIA_TYPE_BLUE_RAY;
    public static final int MEDIA_TYPE_UNKNOWN_MEDIA_TYPE;
    public final SourceList_Data$Attributes attributes;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public SourceList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new SourceList_Data$Attributes();
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

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Data sourceList_Data = (SourceList_Data)bAPEntity;
        return this.arrayHeader.equalTo(sourceList_Data.arrayHeader) && this.pos == sourceList_Data.pos && this.sourceType == sourceList_Data.sourceType && this.instance_Id == sourceList_Data.instance_Id && this.mediaType == sourceList_Data.mediaType && this.attributes.equalTo(sourceList_Data.attributes) && this.name.equalTo(sourceList_Data.name);
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
}

