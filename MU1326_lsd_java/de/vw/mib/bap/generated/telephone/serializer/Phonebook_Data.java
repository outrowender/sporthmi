/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE_ADRESS_INDICATION = 0;
    public static final int RECORD_ADDRESS_PB_NAME_STORAGE_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_ADRESS_INDICATION = 1;
    public static final int RECORD_ADDRESS_TEL_NUMBERN_VOICE_TAGN_RESERVEN_NUMBER_TYPEN = 2;
    public static final int RECORD_ADDRESS_PB_NAME_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_VOICE_TAG_RESERVE_NUMBER_TYPE = 3;
    public static final int RECORD_ADDRESS_ANY_VOICE_TAG_TEL_NUMBER_QUANTITY_TEL_NUMBER_VOICE_TAG_RESERVE_NUMBER_TYPE = 4;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public final BAPString pbName;
    private static final int MAX_PB_NAME_LENGTH = 100;
    public int storage;
    private static final int STORAGE_BITSIZE = 8;
    public static final int STORAGE_UNDEFINED = 0;
    public static final int STORAGE_SIM = 1;
    public static final int STORAGE_MOBILE_EQUIPMENT = 2;
    public static final int STORAGE_LOCAL_PUBLIC = 3;
    public static final int STORAGE_LOCAL_PRIVATE = 4;
    public final AnyVoiceTag anyVoiceTag;
    public int telNumberQuantity;
    private static final int TEL_NUMBER_QUANTITY_BITSIZE = 4;
    public final BAPString[] telNumberN;
    private static final int MAX_TEL_NUMBERN_LENGTH = 410;
    private static final int MAX_TEL_NUMBERN_PER_ELEMENT = 10;
    public final VoiceTag[] voiceTagN;
    public final Reserve[] reserveN;
    public final int[] numberTypeN;
    private static final int NUMBER_TYPEN_BITSIZE = 8;
    public static final int NUMBER_TYPEN_UNKNOWN_NUMBER_TYPE = 0;
    public static final int NUMBER_TYPEN_GENERAL = 1;
    public static final int NUMBER_TYPEN_MOBILE = 2;
    public static final int NUMBER_TYPEN_OFFICE = 3;
    public static final int NUMBER_TYPEN_HOME = 4;
    public static final int NUMBER_TYPEN_FAX = 5;
    public static final int NUMBER_TYPEN_PAGER = 6;
    public static final int NUMBER_TYPEN_CAR = 7;
    public static final int NUMBER_TYPEN_SIM = 8;
    public static final int NUMBER_TYPEN_MAIN_OFFICE = 9;
    public static final int NUMBER_TYPEN_MAIN_HOME = 10;
    public static final int NUMBER_TYPEN_CELL_OFFICE = 11;
    public static final int NUMBER_TYPEN_CELL_HOME = 12;
    public static final int NUMBER_TYPEN_FAX_OFFICE = 13;
    public static final int NUMBER_TYPEN_FAX_HOME = 14;
    public final AdressIndication adressIndication;

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

    public Phonebook_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.anyVoiceTag = new AnyVoiceTag();
        this.telNumberQuantity = 0;
        this.telNumberN = new BAPString[this.telNumberQuantity];
        this.voiceTagN = new VoiceTag[this.telNumberQuantity];
        this.reserveN = new Reserve[this.telNumberQuantity];
        this.numberTypeN = new int[this.telNumberQuantity];
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2] = new BAPString(41);
            this.voiceTagN[i2] = new VoiceTag();
            this.reserveN[i2] = new Reserve();
            this.numberTypeN[i2] = 0;
        }
        this.adressIndication = new AdressIndication();
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data(ArrayHeader arrayHeader, int n) {
        this.internalReset();
        this.arrayHeader = arrayHeader;
        this.pbName = new BAPString(100);
        this.anyVoiceTag = new AnyVoiceTag();
        this.telNumberQuantity = n;
        this.telNumberN = new BAPString[this.telNumberQuantity];
        this.voiceTagN = new VoiceTag[this.telNumberQuantity];
        this.reserveN = new Reserve[this.telNumberQuantity];
        this.numberTypeN = new int[this.telNumberQuantity];
        for (int i2 = 0; i2 < this.telNumberQuantity; ++i2) {
            this.telNumberN[i2] = new BAPString(41);
            this.voiceTagN[i2] = new VoiceTag();
            this.reserveN[i2] = new Reserve();
            this.numberTypeN[i2] = 0;
        }
        this.adressIndication = new AdressIndication();
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

    public static final class Reserve
    implements BAPEntity {
        private static final int RESERVED_BIT_0__3_BITSIZE = 4;
        private static final int RESERVE_BITSIZE = 4;

        public Reserve() {
            this.internalReset();
            this.customInitialization();
        }

        public Reserve(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            return true;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Reserve:");
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
        }
    }

    public static final class VoiceTag
    implements BAPEntity {
        public boolean voiceTagAvailable;
        private static final int VOICE_TAG_BITSIZE = 4;
        private static final int VOICE_TAG_NOT_DEFINED_BITSIZE = 3;

        public VoiceTag() {
            this.internalReset();
            this.customInitialization();
        }

        public VoiceTag(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.voiceTagAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            VoiceTag voiceTag = (VoiceTag)bAPEntity;
            return this.voiceTagAvailable == voiceTag.voiceTagAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("VoiceTag:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.voiceTagAvailable) {
                stringBuffer.append("true  (voice tag available");
            } else {
                stringBuffer.append("false  (no voice tag available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBits(3, 0);
            bitStream.pushBoolean(this.voiceTagAvailable);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.popFrontBits(3);
            this.voiceTagAvailable = bitStream.popFrontBoolean();
        }
    }

    public static final class AnyVoiceTag
    implements BAPEntity {
        public boolean reserved_bit_3;
        public boolean reserved_bit_2;
        public boolean voiceTagForStandardNumberAvailable;
        public boolean anyVoiceTagAvailable;
        private static final int ANY_VOICE_TAG_BITSIZE = 4;

        public AnyVoiceTag() {
            this.internalReset();
            this.customInitialization();
        }

        public AnyVoiceTag(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_3 = false;
            this.reserved_bit_2 = false;
            this.voiceTagForStandardNumberAvailable = false;
            this.anyVoiceTagAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            AnyVoiceTag anyVoiceTag = (AnyVoiceTag)bAPEntity;
            return this.reserved_bit_3 == anyVoiceTag.reserved_bit_3 && this.reserved_bit_2 == anyVoiceTag.reserved_bit_2 && this.voiceTagForStandardNumberAvailable == anyVoiceTag.voiceTagForStandardNumberAvailable && this.anyVoiceTagAvailable == anyVoiceTag.anyVoiceTagAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("AnyVoiceTag:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.reserved_bit_3) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.reserved_bit_2) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.voiceTagForStandardNumberAvailable) {
                stringBuffer.append("true  (voice tag for standard number available");
            } else {
                stringBuffer.append("false  (no voice tag for standard number available");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.anyVoiceTagAvailable) {
                stringBuffer.append("true  (any voice tag available");
            } else {
                stringBuffer.append("false  (no voice tag available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_3);
            bitStream.pushBoolean(this.reserved_bit_2);
            bitStream.pushBoolean(this.voiceTagForStandardNumberAvailable);
            bitStream.pushBoolean(this.anyVoiceTagAvailable);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_3 = bitStream.popFrontBoolean();
            this.reserved_bit_2 = bitStream.popFrontBoolean();
            this.voiceTagForStandardNumberAvailable = bitStream.popFrontBoolean();
            this.anyVoiceTagAvailable = bitStream.popFrontBoolean();
        }
    }

    public static final class AdressIndication
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean reserved_bit_6;
        public boolean businessAddressIsSuitedAsNavigationDestaination;
        public boolean businessAddressAvailable;
        public boolean privateAddressIsSuitedAsNavigationDestaination;
        public boolean privateAddressAvailable;
        public boolean defaultAddressIsSuitedAsNavigationDestaination;
        public boolean defaultAddressAvailable;
        private static final int ADRESS_INDICATION_BITSIZE = 8;

        public AdressIndication() {
            this.internalReset();
            this.customInitialization();
        }

        public AdressIndication(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_7 = false;
            this.reserved_bit_6 = false;
            this.businessAddressIsSuitedAsNavigationDestaination = false;
            this.businessAddressAvailable = false;
            this.privateAddressIsSuitedAsNavigationDestaination = false;
            this.privateAddressAvailable = false;
            this.defaultAddressIsSuitedAsNavigationDestaination = false;
            this.defaultAddressAvailable = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            AdressIndication adressIndication = (AdressIndication)bAPEntity;
            return this.reserved_bit_7 == adressIndication.reserved_bit_7 && this.reserved_bit_6 == adressIndication.reserved_bit_6 && this.businessAddressIsSuitedAsNavigationDestaination == adressIndication.businessAddressIsSuitedAsNavigationDestaination && this.businessAddressAvailable == adressIndication.businessAddressAvailable && this.privateAddressIsSuitedAsNavigationDestaination == adressIndication.privateAddressIsSuitedAsNavigationDestaination && this.privateAddressAvailable == adressIndication.privateAddressAvailable && this.defaultAddressIsSuitedAsNavigationDestaination == adressIndication.defaultAddressIsSuitedAsNavigationDestaination && this.defaultAddressAvailable == adressIndication.defaultAddressAvailable;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("AdressIndication:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.reserved_bit_7) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.reserved_bit_6) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.businessAddressIsSuitedAsNavigationDestaination) {
                stringBuffer.append("true  (business address is suited as navigation destaination");
            } else {
                stringBuffer.append("false  (business address is NOT suited as navigation destaination");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.businessAddressAvailable) {
                stringBuffer.append("true  (business address available");
            } else {
                stringBuffer.append("false  (business address NOT available");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.privateAddressIsSuitedAsNavigationDestaination) {
                stringBuffer.append("true  (private (home) address is suited as navigation destaination");
            } else {
                stringBuffer.append("false  (private (home) address is NOT suited as navigation destaination");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.privateAddressAvailable) {
                stringBuffer.append("true  (private (home) address available");
            } else {
                stringBuffer.append("false  (private (home) address NOT available");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.defaultAddressIsSuitedAsNavigationDestaination) {
                stringBuffer.append("true  (default address is suited as navigation destaination");
            } else {
                stringBuffer.append("false  (default address is NOT suited as navigation destaination");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.defaultAddressAvailable) {
                stringBuffer.append("true  (default address available");
            } else {
                stringBuffer.append("false  (default address NOT available");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_7);
            bitStream.pushBoolean(this.reserved_bit_6);
            bitStream.pushBoolean(this.businessAddressIsSuitedAsNavigationDestaination);
            bitStream.pushBoolean(this.businessAddressAvailable);
            bitStream.pushBoolean(this.privateAddressIsSuitedAsNavigationDestaination);
            bitStream.pushBoolean(this.privateAddressAvailable);
            bitStream.pushBoolean(this.defaultAddressIsSuitedAsNavigationDestaination);
            bitStream.pushBoolean(this.defaultAddressAvailable);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_7 = bitStream.popFrontBoolean();
            this.reserved_bit_6 = bitStream.popFrontBoolean();
            this.businessAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
            this.businessAddressAvailable = bitStream.popFrontBoolean();
            this.privateAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
            this.privateAddressAvailable = bitStream.popFrontBoolean();
            this.defaultAddressIsSuitedAsNavigationDestaination = bitStream.popFrontBoolean();
            this.defaultAddressAvailable = bitStream.popFrontBoolean();
        }
    }
}

