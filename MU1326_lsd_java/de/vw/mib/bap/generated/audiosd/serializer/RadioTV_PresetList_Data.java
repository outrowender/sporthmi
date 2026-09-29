/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.RadioTV_PresetList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class RadioTV_PresetList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_ATTRIBUTES_NAME;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_NAME;
    public static final int RECORD_ADDRESS_PRESET_INDEX_NAME;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int presetIndex;
    private static final int PRESET_INDEX_BITSIZE;
    public int waveband;
    private static final int WAVEBAND_BITSIZE;
    public static final int WAVEBAND_UNKNOWN_INVALID;
    public static final int WAVEBAND_FM;
    public static final int WAVEBAND_AM_MW_MITTELWELLE;
    public static final int WAVEBAND_AM_SW_KURZWELLE;
    public static final int WAVEBAND_AM_LW_LANGWELLE;
    public static final int WAVEBAND_SDARS_XM;
    public static final int WAVEBAND_SDARS_SIRIUS;
    public static final int WAVEBAND_DAB;
    public static final int WAVEBAND_DVB;
    public static final int WAVEBAND_TV;
    public static final int WAVEBAND_ONLINE_RADIO_DF4_1;
    public static final int WAVEBAND_COMMON_LIST_DF4_4;
    public final RadioTV_PresetList_Data$Attributes attributes;
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

    public RadioTV_PresetList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new RadioTV_PresetList_Data$Attributes();
        this.name = new BAPString(49);
        this.internalReset();
        this.customInitialization();
    }

    public RadioTV_PresetList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.presetIndex = 0;
        this.waveband = 0;
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
        RadioTV_PresetList_Data radioTV_PresetList_Data = (RadioTV_PresetList_Data)bAPEntity;
        return this.arrayHeader.equalTo(radioTV_PresetList_Data.arrayHeader) && this.pos == radioTV_PresetList_Data.pos && this.presetIndex == radioTV_PresetList_Data.presetIndex && this.waveband == radioTV_PresetList_Data.waveband && this.attributes.equalTo(radioTV_PresetList_Data.attributes) && this.name.equalTo(radioTV_PresetList_Data.name);
    }

    private void customInitialization() {
        this.name.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RadioTV_PresetList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - PresetIndex - ");
        stringBuffer.append(this.presetIndex);
        stringBuffer.append("\n - Waveband: ");
        switch (this.waveband) {
            case 0: {
                stringBuffer.append("0x00 (unknown / invalid)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (FM)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (AM (MW:.. \\\"Mittelwelle\\\"))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (AM (SW:.. \\\"Kurzwelle\\\"))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (AM (LW:.. \\\"Langwelle\\\"))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (SDARS - XM)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (SDARS - Sirius)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (DAB)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (DVB)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (TV)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (online radio (DF4.1))");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (CommonList (DF4.4))");
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
                n += this.attributes.bitSize();
                n += this.name.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += this.name.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.name.bitSize();
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
                bitStream.pushByte((byte)this.presetIndex);
                bitStream.pushByte((byte)this.waveband);
                this.attributes.serialize(bitStream);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetIndex);
                bitStream.pushByte((byte)this.waveband);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetIndex);
                this.name.serialize(bitStream);
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
                this.presetIndex = bitStream.popFrontByte();
                this.waveband = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.name.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetIndex = bitStream.popFrontByte();
                this.waveband = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetIndex = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

