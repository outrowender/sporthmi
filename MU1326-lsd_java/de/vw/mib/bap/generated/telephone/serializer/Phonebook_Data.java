/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data$AdressIndication;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data$AnyVoiceTag;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data$Reserve;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data$VoiceTag;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE_ADRESS_INDICATION;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_ADRESS_INDICATION;
    public static final int RECORD_ADDRESS_TEL_NUMBERN_VOICE_TAGN_RESERVEN_NUMBER_TYPEN;
    public static final int RECORD_ADDRESS_PB_NAME_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_VOICE_TAG_RESERVE_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH;
    public int storage;
    private static final int STORAGE_BITSIZE;
    public static final int STORAGE_UNDEFINED;
    public static final int STORAGE_SIM;
    public static final int STORAGE_MOBILE_EQUIPMENT;
    public static final int STORAGE_LOCAL_PUBLIC;
    public static final int STORAGE_LOCAL_PRIVATE;
    public final Phonebook_Data$AnyVoiceTag anyVoiceTag;
    public int telNumberQuantity;
    private static final int TEL_NUMBER_QUANTITY_BITSIZE;
    public final BAPString[] telNumberN;
    private static final int MAX_TEL_NUMBERN_LENGTH;
    private static final int MAX_TEL_NUMBERN_PER_ELEMENT;
    public final Phonebook_Data$VoiceTag[] voiceTagN;
    public final Phonebook_Data$Reserve[] reserveN;
    public final int[] numberTypeN;
    private static final int NUMBER_TYPEN_BITSIZE;
    public static final int NUMBER_TYPEN_UNKNOWN_NUMBER_TYPE;
    public static final int NUMBER_TYPEN_GENERAL;
    public static final int NUMBER_TYPEN_MOBILE;
    public static final int NUMBER_TYPEN_OFFICE;
    public static final int NUMBER_TYPEN_HOME;
    public static final int NUMBER_TYPEN_FAX;
    public static final int NUMBER_TYPEN_PAGER;
    public static final int NUMBER_TYPEN_CAR;
    public static final int NUMBER_TYPEN_SIM;
    public static final int NUMBER_TYPEN_MAIN_OFFICE;
    public static final int NUMBER_TYPEN_MAIN_HOME;
    public static final int NUMBER_TYPEN_CELL_OFFICE;
    public static final int NUMBER_TYPEN_CELL_HOME;
    public static final int NUMBER_TYPEN_FAX_OFFICE;
    public static final int NUMBER_TYPEN_FAX_HOME;
    public final Phonebook_Data$AdressIndication adressIndication;

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

    public Phonebook_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.anyVoiceTag = new Phonebook_Data$AnyVoiceTag();
        this.telNumberQuantity = 0;
        this.telNumberN = new BAPString[this.telNumberQuantity];
        this.voiceTagN = new Phonebook_Data$VoiceTag[this.telNumberQuantity];
        this.reserveN = new Phonebook_Data$Reserve[this.telNumberQuantity];
        this.numberTypeN = new int[this.telNumberQuantity];
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2] = new BAPString(41);
            this.voiceTagN[i2] = new Phonebook_Data$VoiceTag();
            this.reserveN[i2] = new Phonebook_Data$Reserve();
            this.numberTypeN[i2] = 0;
        }
        this.adressIndication = new Phonebook_Data$AdressIndication();
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data(ArrayHeader arrayHeader, int n) {
        this.internalReset();
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.anyVoiceTag = new Phonebook_Data$AnyVoiceTag();
        this.telNumberQuantity = n;
        this.telNumberN = new BAPString[this.telNumberQuantity];
        this.voiceTagN = new Phonebook_Data$VoiceTag[this.telNumberQuantity];
        this.reserveN = new Phonebook_Data$Reserve[this.telNumberQuantity];
        this.numberTypeN = new int[this.telNumberQuantity];
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2] = new BAPString(41);
            this.voiceTagN[i2] = new Phonebook_Data$VoiceTag();
            this.reserveN[i2] = new Phonebook_Data$Reserve();
            this.numberTypeN[i2] = 0;
        }
        this.adressIndication = new Phonebook_Data$AdressIndication();
        this.customInitialization();
    }

    public Phonebook_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader, 0);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.storage = 0;
        this.telNumberQuantity = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.pbName.reset();
        this.anyVoiceTag.reset();
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2].reset();
            this.voiceTagN[i2].reset();
            this.reserveN[i2].reset();
            this.numberTypeN[i2] = 0;
        }
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        boolean bl;
        Phonebook_Data phonebook_Data = (Phonebook_Data)bAPEntity;
        boolean bl2 = bl = this.arrayHeader.equalTo(phonebook_Data.arrayHeader) && this.pos == phonebook_Data.pos && this.pbName.equalTo(phonebook_Data.pbName) && this.storage == phonebook_Data.storage && this.anyVoiceTag.equalTo(phonebook_Data.anyVoiceTag) && this.telNumberQuantity == phonebook_Data.telNumberQuantity && this.adressIndication.equalTo(phonebook_Data.adressIndication);
        if (bl) {
            for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                if (this.telNumberN[i2].equalTo(phonebook_Data.telNumberN[i2]) && this.voiceTagN[i2].equals(phonebook_Data.voiceTagN[i2]) && this.reserveN[i2].equals(phonebook_Data.reserveN[i2]) && this.numberTypeN[i2] == phonebook_Data.numberTypeN[i2]) continue;
                bl = false;
                break;
            }
        }
        return bl;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Phonebook_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - PbName - ");
        stringBuffer.append(this.pbName.toString());
        stringBuffer.append("\n - Storage: ");
        switch (this.storage) {
            case 0: {
                stringBuffer.append("0x00 (undefined)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (SIM)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Mobile Equipment)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Local public)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Local private)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - AnyVoiceTag - ");
        stringBuffer.append(this.anyVoiceTag.toString());
        stringBuffer.append("\n - TelNumberQuantity - ");
        stringBuffer.append(this.telNumberQuantity);
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            stringBuffer.append("\n - number[").append(i2).append("] {");
            stringBuffer.append("\n - TelNumber(n) - ");
            stringBuffer.append(this.telNumberN[i2].toString());
            stringBuffer.append("\n - VoiceTag(n) - ");
            stringBuffer.append(this.voiceTagN[i2].toString());
            stringBuffer.append("\n - Reserve(n) - ");
            stringBuffer.append(this.reserveN[i2].toString());
            stringBuffer.append("\n - NumberType(n): ");
            switch (this.numberTypeN[i2]) {
                case 0: {
                    stringBuffer.append("0x00 (unknown NumberType)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (General)");
                    break;
                }
                case 2: {
                    stringBuffer.append("0x02 (Mobile)");
                    break;
                }
                case 3: {
                    stringBuffer.append("0x03 (Office)");
                    break;
                }
                case 4: {
                    stringBuffer.append("0x04 (Home)");
                    break;
                }
                case 5: {
                    stringBuffer.append("0x05 (Fax)");
                    break;
                }
                case 6: {
                    stringBuffer.append("0x06 (Pager)");
                    break;
                }
                case 7: {
                    stringBuffer.append("0x07 (Car)");
                    break;
                }
                case 8: {
                    stringBuffer.append("0x08 (SIM)");
                    break;
                }
                case 9: {
                    stringBuffer.append("0x09 (Main office)");
                    break;
                }
                case 10: {
                    stringBuffer.append("0x0A (Main home)");
                    break;
                }
                case 11: {
                    stringBuffer.append("0x0B (Cell office)");
                    break;
                }
                case 12: {
                    stringBuffer.append("0x0C (Cell home)");
                    break;
                }
                case 13: {
                    stringBuffer.append("0x0D (Fax office)");
                    break;
                }
                case 14: {
                    stringBuffer.append("0x0E (Fax home)");
                    break;
                }
                default: {
                    stringBuffer.append("UNKNOWN ENUM");
                }
            }
            stringBuffer.append("}");
        }
        stringBuffer.append("\n - AdressIndication - ");
        stringBuffer.append(this.adressIndication.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += 8;
                n += this.anyVoiceTag.bitSize();
                n += 4;
                for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                    n += this.telNumberN[i2].bitSize();
                    n += this.voiceTagN[i2].bitSize();
                    n += this.reserveN[i2].bitSize();
                    n += 8;
                }
                n += this.adressIndication.bitSize();
                break;
            }
            case 1: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += 8;
                n += this.anyVoiceTag.bitSize();
                n += 4;
                n += this.adressIndication.bitSize();
                break;
            }
            case 2: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                for (int i3 = 0; i3 < this.telNumberQuantity; ++i3) {
                    n += this.telNumberN[i3].bitSize();
                    n += this.voiceTagN[i3].bitSize();
                    n += this.reserveN[i3].bitSize();
                    n += 8;
                }
                break;
            }
            case 3: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.pbName.bitSize();
                n += this.anyVoiceTag.bitSize();
                n += 4;
                for (int i4 = 0; i4 < this.telNumberQuantity; ++i4) {
                    n += this.voiceTagN[i4].bitSize();
                    n += this.reserveN[i4].bitSize();
                    n += 8;
                }
                break;
            }
            case 4: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += this.anyVoiceTag.bitSize();
                n += 4;
                for (int i5 = 0; i5 < this.telNumberQuantity; ++i5) {
                    n += this.telNumberN[i5].bitSize();
                    n += this.voiceTagN[i5].bitSize();
                    n += this.reserveN[i5].bitSize();
                    n += 8;
                }
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
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.storage);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                    this.telNumberN[i2].serialize(bitStream);
                    this.voiceTagN[i2].serialize(bitStream);
                    this.reserveN[i2].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i2]);
                }
                this.adressIndication.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                bitStream.pushByte((byte)this.storage);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                this.adressIndication.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                for (int i3 = 0; i3 < this.telNumberQuantity; ++i3) {
                    this.telNumberN[i3].serialize(bitStream);
                    this.voiceTagN[i3].serialize(bitStream);
                    this.reserveN[i3].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i3]);
                }
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.pbName.serialize(bitStream);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i4 = 0; i4 < this.telNumberQuantity; ++i4) {
                    this.voiceTagN[i4].serialize(bitStream);
                    this.reserveN[i4].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i4]);
                }
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.anyVoiceTag.serialize(bitStream);
                bitStream.pushBits(4, this.telNumberQuantity);
                for (int i5 = 0; i5 < this.telNumberQuantity; ++i5) {
                    this.telNumberN[i5].serialize(bitStream);
                    this.voiceTagN[i5].serialize(bitStream);
                    this.reserveN[i5].serialize(bitStream);
                    bitStream.pushByte((byte)this.numberTypeN[i5]);
                }
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
                this.pbName.deserialize(bitStream);
                this.storage = bitStream.popFrontByte();
                this.anyVoiceTag.deserialize(bitStream);
                this.telNumberQuantity = bitStream.popFrontBits(4);
                for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
                    this.telNumberN[i2].deserialize(bitStream);
                    this.voiceTagN[i2].deserialize(bitStream);
                    this.reserveN[i2].deserialize(bitStream);
                    this.numberTypeN[i2] = bitStream.popFrontByte();
                }
                this.adressIndication.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.pbName.deserialize(bitStream);
                this.storage = bitStream.popFrontByte();
                this.anyVoiceTag.deserialize(bitStream);
                this.telNumberQuantity = bitStream.popFrontBits(4);
                this.adressIndication.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                for (int i3 = 0; i3 < this.telNumberQuantity; ++i3) {
                    this.telNumberN[i3].deserialize(bitStream);
                    this.voiceTagN[i3].deserialize(bitStream);
                    this.reserveN[i3].deserialize(bitStream);
                    this.numberTypeN[i3] = bitStream.popFrontByte();
                }
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.pbName.deserialize(bitStream);
                this.anyVoiceTag.deserialize(bitStream);
                this.telNumberQuantity = bitStream.popFrontBits(4);
                for (int i4 = 0; i4 < this.telNumberQuantity; ++i4) {
                    this.voiceTagN[i4].deserialize(bitStream);
                    this.reserveN[i4].deserialize(bitStream);
                    this.numberTypeN[i4] = bitStream.popFrontByte();
                }
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.anyVoiceTag.deserialize(bitStream);
                this.telNumberQuantity = bitStream.popFrontBits(4);
                for (int i5 = 0; i5 < this.telNumberQuantity; ++i5) {
                    this.telNumberN[i5].deserialize(bitStream);
                    this.voiceTagN[i5].deserialize(bitStream);
                    this.reserveN[i5].deserialize(bitStream);
                    this.numberTypeN[i5] = bitStream.popFrontByte();
                }
                break;
            }
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }
}

