/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_Data$Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_PRESET_ID_FM_REG_CODE_CATEGORY_NAME_FREQUENCY;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_PRESET_ID_FM_REG_CODE_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES;
    public static final int RECORD_ADDRESS_PRESET_ID_FM_REG_CODE_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_FREQUENCY;
    public static final int RECORD_ADDRESS_TYPE_ATTRIBUTES_CATEGORY_NAME;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int type;
    private static final int TYPE_BITSIZE;
    public static final int TYPE_ANY_STRING_UNKNOWN;
    public static final int TYPE_STATION_NAME;
    public static final int TYPE_DAB_ENSEMBLE_NAME;
    public static final int TYPE_DAB_PRIMARY_SERVICE_NAME;
    public static final int TYPE_DAB_SECONDARY_SERVICE_NAME;
    public static final int TYPE_IBOC_PRIMARY_SERVICE_NAME_IBOC_CHANNEL_CAN_BE_DECODED;
    public static final int TYPE_IBOC_SECONDARY_SERVICE_NAME;
    public static final int TYPE_DVB_SERVICE_NAME;
    public static final int TYPE_SDARS_STATION_NAME;
    public static final int TYPE_ONLINE_RADIO_PRIMARY_SERVICE_NAME_DF4_1;
    public static final int TYPE_ONLINE_RADIO_SECONDARY_SERVICE_NAME_DF4_1;
    public final ReceptionList_Data$Attributes attributes;
    public int presetId;
    private static final int PRESET_ID_BITSIZE;
    public int fmReg_Code;
    private static final int FM_REG_CODE_BITSIZE;
    public int category;
    private static final int CATEGORY_BITSIZE;
    public static final int CATEGORY_UNKNOWN_NONE_CATEGORY;
    public static final int CATEGORY_NEWS;
    public static final int CATEGORY_CURRENT_AFFAIRS;
    public static final int CATEGORY_INFORMATION;
    public static final int CATEGORY_SPORTS;
    public static final int CATEGORY_EDUCATION;
    public static final int CATEGORY_DRAMA;
    public static final int CATEGORY_CULTURE;
    public static final int CATEGORY_SCIENCE;
    public static final int CATEGORY_VARIED;
    public static final int CATEGORY_POP_MUSIC;
    public static final int CATEGORY_ROCK_MUSIC;
    public static final int CATEGORY_EASY_LISTENING_MUSIC;
    public static final int CATEGORY_SERIOUS_CLASSICAL;
    public static final int CATEGORY_LIGHT_CLASSICAL;
    public static final int CATEGORY_OTHER_MUSIC;
    public static final int CATEGORY_WEATHER;
    public static final int CATEGORY_FINANCE;
    public static final int CATEGORY_CHILDRENSS_PROGRAMMES;
    public static final int CATEGORY_SOCIAL_AFFAIRS;
    public static final int CATEGORY_RELIGION;
    public static final int CATEGORY_PHONE_IN;
    public static final int CATEGORY_TRAVEL;
    public static final int CATEGORY_LEISURE;
    public static final int CATEGORY_JAZZ_MUSIC;
    public static final int CATEGORY_COUNTRY_MUSIC;
    public static final int CATEGORY_NATIONAL_MUSIC;
    public static final int CATEGORY_OLDIES_MUSIC;
    public static final int CATEGORY_FOLK_MUSIC;
    public static final int CATEGORY_DOCUMENTARY;
    public static final int CATEGORY_ALARM_TEST;
    public static final int CATEGORY_ALARM;
    public static final int CATEGORY_TALK;
    public static final int CATEGORY_CLASSIC_ROCK;
    public static final int CATEGORY_ADULT_HITS;
    public static final int CATEGORY_SOFT_ROCK;
    public static final int CATEGORY_TOP_40;
    public static final int CATEGORY_OLDIES;
    public static final int CATEGORY_SOFT;
    public static final int CATEGORY_NOSTALGIA;
    public static final int CATEGORY_CLASSICAL;
    public static final int CATEGORY_RHYTHM_AND_BLUES;
    public static final int CATEGORY_SOFT_RHYTHM_AND_BLUES;
    public static final int CATEGORY_FOREIGN_LANGUAGE;
    public static final int CATEGORY_RELIGIOUS_MUSIC;
    public static final int CATEGORY_RELEGIOUS_TALK;
    public static final int CATEGORY_PERSONALITY;
    public static final int CATEGORY_PUBLIC;
    public static final int CATEGORY_COLLEGE;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH;
    public final BAPString frequency;
    private static final int MAX_FREQUENCY_LENGTH;

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

    public ReceptionList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new ReceptionList_Data$Attributes();
        this.name = new BAPString(49);
        this.frequency = new BAPString(31);
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.type = 0;
        this.presetId = 0;
        this.fmReg_Code = 0;
        this.category = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
        this.frequency.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_Data receptionList_Data = (ReceptionList_Data)bAPEntity;
        return this.arrayHeader.equalTo(receptionList_Data.arrayHeader) && this.pos == receptionList_Data.pos && this.type == receptionList_Data.type && this.attributes.equalTo(receptionList_Data.attributes) && this.presetId == receptionList_Data.presetId && this.fmReg_Code == receptionList_Data.fmReg_Code && this.category == receptionList_Data.category && this.name.equalTo(receptionList_Data.name) && this.frequency.equalTo(receptionList_Data.frequency);
    }

    private void customInitialization() {
        this.frequency.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - Type: ");
        switch (this.type) {
            case 0: {
                stringBuffer.append("0x00 (any string / unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (station name)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (DAB ensemble name)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (DAB primary service name)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (DAB secondary service name)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (IBOC primary service name (IBOC channel can be decoded))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (IBOC secondary service name)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (DVB service name)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (SDARS station name)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (Online radio primary service name (DF4.1))");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (Online radio secondary service name (DF4.1))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Attributes - ");
        stringBuffer.append(this.attributes.toString());
        stringBuffer.append("\n - PresetID - ");
        stringBuffer.append(this.presetId);
        stringBuffer.append("\n - FmREG_Code - ");
        stringBuffer.append(this.fmReg_Code);
        stringBuffer.append("\n - Category: ");
        switch (this.category) {
            case 0: {
                stringBuffer.append("0x00 (unknown / none category)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (news)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (current affairs)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (information)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (sports)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (education)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (drama)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (culture)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (science)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (varied)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (pop music)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (rock music)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (easy listening music)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (serious classical)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (light classical)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (other music)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (weather)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (finance)");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (childrens's programmes)");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (social affairs)");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (religion)");
                break;
            }
            case 21: {
                stringBuffer.append("0x15 (phone in)");
                break;
            }
            case 22: {
                stringBuffer.append("0x16 (travel)");
                break;
            }
            case 23: {
                stringBuffer.append("0x17 (leisure)");
                break;
            }
            case 24: {
                stringBuffer.append("0x18 (jazz music)");
                break;
            }
            case 25: {
                stringBuffer.append("0x19 (country music)");
                break;
            }
            case 26: {
                stringBuffer.append("0x1A (national music)");
                break;
            }
            case 27: {
                stringBuffer.append("0x1B (oldies music)");
                break;
            }
            case 28: {
                stringBuffer.append("0x1C (folk music)");
                break;
            }
            case 29: {
                stringBuffer.append("0x1D (documentary)");
                break;
            }
            case 30: {
                stringBuffer.append("0x1E (alarm test)");
                break;
            }
            case 31: {
                stringBuffer.append("0x1F (alarm)");
                break;
            }
            case 36: {
                stringBuffer.append("0x24 (talk)");
                break;
            }
            case 38: {
                stringBuffer.append("0x26 (classic rock)");
                break;
            }
            case 39: {
                stringBuffer.append("0x27 (adult hits)");
                break;
            }
            case 40: {
                stringBuffer.append("0x28 (soft rock)");
                break;
            }
            case 41: {
                stringBuffer.append("0x29 (top 40)");
                break;
            }
            case 43: {
                stringBuffer.append("0x2B (oldies)");
                break;
            }
            case 44: {
                stringBuffer.append("0x2C (soft)");
                break;
            }
            case 45: {
                stringBuffer.append("0x2D (nostalgia)");
                break;
            }
            case 47: {
                stringBuffer.append("0x2F (classical)");
                break;
            }
            case 48: {
                stringBuffer.append("0x30 (rhythm and blues)");
                break;
            }
            case 49: {
                stringBuffer.append("0x31 (soft rhythm and blues)");
                break;
            }
            case 50: {
                stringBuffer.append("0x32 (foreign language)");
                break;
            }
            case 51: {
                stringBuffer.append("0x33 (religious music)");
                break;
            }
            case 52: {
                stringBuffer.append("0x34 (relegious talk)");
                break;
            }
            case 53: {
                stringBuffer.append("0x35 (personality)");
                break;
            }
            case 54: {
                stringBuffer.append("0x36 (public)");
                break;
            }
            case 55: {
                stringBuffer.append("0x37 (college)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Name - ");
        stringBuffer.append(this.name.toString());
        stringBuffer.append("\n - Frequency - ");
        stringBuffer.append(this.frequency.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.attributes.bitSize();
                n += 8;
                n += 8;
                n += 8;
                n += this.name.bitSize();
                n += this.frequency.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.attributes.bitSize();
                n += 8;
                n += 8;
                n += 8;
                n += this.name.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.attributes.bitSize();
                break;
            }
            case 3: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += 8;
                n += 8;
                n += this.name.bitSize();
                break;
            }
            case 4: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.name.bitSize();
                break;
            }
            case 5: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.frequency.bitSize();
                break;
            }
            case 6: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.attributes.bitSize();
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
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                this.frequency.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.fmReg_Code);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.frequency.serialize(bitStream);
                break;
            }
            case 6: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.type);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.category);
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
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                this.frequency.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.presetId = bitStream.popFrontByte();
                this.fmReg_Code = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 5: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.frequency.deserialize(bitStream);
                break;
            }
            case 6: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.type = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.category = bitStream.popFrontByte();
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

