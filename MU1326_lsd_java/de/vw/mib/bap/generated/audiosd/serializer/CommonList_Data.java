/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_ATTRIBUTES_PRESET_ID_CATEGORY_NAME_FREQUENCY = 0;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_ATTRIBUTES_PRESET_ID_CATEGORY_NAME = 1;
    public static final int RECORD_ADDRESS_NAME = 2;
    public static final int RECORD_ADDRESS_ATTRIBUTES_FREQUENCY = 3;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public int sourceType;
    private static final int SOURCE_TYPE_BITSIZE = 8;
    public static final int SOURCE_TYPE_NO_SOURCE_INVALID = 0;
    public static final int SOURCE_TYPE_FM = 1;
    public static final int SOURCE_TYPE_AM_MW_MITTELWELLE = 2;
    public static final int SOURCE_TYPE_DAB = 3;
    public static final int SOURCE_TYPE_SDARS_XM = 4;
    public static final int SOURCE_TYPE_SDARS_SIRIUS = 5;
    public static final int SOURCE_TYPE_TV = 9;
    public static final int SOURCE_TYPE_AM_TI_JAPAN = 17;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE = 25;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE = 26;
    public static final int SOURCE_TYPE_ONLINE_RADIO = 35;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE = 255;
    public final Attributes attributes;
    public int presetId;
    private static final int PRESET_ID_BITSIZE = 8;
    public int category;
    private static final int CATEGORY_BITSIZE = 8;
    public static final int CATEGORY_UNKNOWN_NONE_CATEGORY = 0;
    public static final int CATEGORY_NEWS = 1;
    public static final int CATEGORY_CURRENT_AFFAIRS = 2;
    public static final int CATEGORY_INFORMATION = 3;
    public static final int CATEGORY_SPORTS = 4;
    public static final int CATEGORY_EDUCATION = 5;
    public static final int CATEGORY_DRAMA = 6;
    public static final int CATEGORY_CULTURE = 7;
    public static final int CATEGORY_SCIENCE = 8;
    public static final int CATEGORY_VARIED = 9;
    public static final int CATEGORY_POP_MUSIC = 10;
    public static final int CATEGORY_ROCK_MUSIC = 11;
    public static final int CATEGORY_EASY_LISTENING_MUSIC = 12;
    public static final int CATEGORY_LIGHT_CLASSICAL = 14;
    public static final int CATEGORY_SERIOUS_CLASSICAL = 13;
    public static final int CATEGORY_OTHER_MUSIC = 15;
    public static final int CATEGORY_WEATHER = 16;
    public static final int CATEGORY_FINANCE = 17;
    public static final int CATEGORY_CHILDRENSS_PROGRAMMES = 18;
    public static final int CATEGORY_SOCIAL_AFFAIRS = 19;
    public static final int CATEGORY_RELIGION = 20;
    public static final int CATEGORY_PHONE_IN = 21;
    public static final int CATEGORY_TRAVEL = 22;
    public static final int CATEGORY_LEISURE = 23;
    public static final int CATEGORY_JAZZ_MUSIC = 24;
    public static final int CATEGORY_COUNTRY_MUSIC = 25;
    public static final int CATEGORY_NATIONAL_MUSIC = 26;
    public static final int CATEGORY_OLDIES_MUSIC = 27;
    public static final int CATEGORY_FOLK_MUSIC = 28;
    public static final int CATEGORY_DOCUMENTARY = 29;
    public static final int CATEGORY_ALARM_TEST = 30;
    public static final int CATEGORY_ALARM = 31;
    public static final int CATEGORY_TALK = 36;
    public static final int CATEGORY_CLASSIC_ROCK = 38;
    public static final int CATEGORY_ADULT_HITS = 39;
    public static final int CATEGORY_SOFT_ROCK = 40;
    public static final int CATEGORY_TOP_40 = 41;
    public static final int CATEGORY_OLDIES = 43;
    public static final int CATEGORY_SOFT = 44;
    public static final int CATEGORY_NOSTALGIA = 45;
    public static final int CATEGORY_CLASSICAL = 47;
    public static final int CATEGORY_RHYTHM_AND_BLUES = 48;
    public static final int CATEGORY_SOFT_RHYTHM_AND_BLUES = 49;
    public static final int CATEGORY_FOREIGN_LANGUAGE = 50;
    public static final int CATEGORY_RELIGIOUS_MUSIC = 51;
    public static final int CATEGORY_RELEGIOUS_TALK = 52;
    public static final int CATEGORY_PERSONALITY = 53;
    public static final int CATEGORY_PUBLIC = 54;
    public static final int CATEGORY_COLLEGE = 55;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH = 49;
    public final BAPString frequency;
    private static final int MAX_FREQUENCY_LENGTH = 31;

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

    public CommonList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new Attributes();
        this.name = new BAPString(49);
        this.frequency = new BAPString(31);
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.sourceType = 0;
        this.presetId = 0;
        this.category = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
        this.frequency.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CommonList_Data commonList_Data = (CommonList_Data)bAPEntity;
        return this.arrayHeader.equalTo(commonList_Data.arrayHeader) && this.pos == commonList_Data.pos && this.sourceType == commonList_Data.sourceType && this.attributes.equalTo(commonList_Data.attributes) && this.presetId == commonList_Data.presetId && this.category == commonList_Data.category && this.name.equalTo(commonList_Data.name) && this.frequency.equalTo(commonList_Data.frequency);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CommonList_Data:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Pos - ");
        stringBuffer.append(this.pos);
        stringBuffer.append("\n - SourceType: ");
        switch (this.sourceType) {
            case 0: {
                stringBuffer.append("0x00 (no source / invalid)");
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
            case 9: {
                stringBuffer.append("0x09 (TV)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (AM-TI (Japan))");
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
            case 35: {
                stringBuffer.append("0x23 (online radio)");
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
        stringBuffer.append("\n - Attributes - ");
        stringBuffer.append(this.attributes.toString());
        stringBuffer.append("\n - PresetID - ");
        stringBuffer.append(this.presetId);
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
            case 14: {
                stringBuffer.append("0x0E (light classical)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (serious classical)");
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

    public int bitSize() {
        int n = 0;
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                n += this.arrayHeader.bitSizeOfPosArrayElement();
                n += 8;
                n += this.attributes.bitSize();
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
                n += this.name.bitSize();
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
                n += this.frequency.bitSize();
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
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
                this.frequency.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                this.attributes.serialize(bitStream);
                bitStream.pushByte((byte)this.presetId);
                bitStream.pushByte((byte)this.category);
                this.name.serialize(bitStream);
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
                this.frequency.serialize(bitStream);
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
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
                this.frequency.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.sourceType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.presetId = bitStream.popFrontByte();
                this.category = bitStream.popFrontByte();
                this.name.deserialize(bitStream);
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
                this.frequency.deserialize(bitStream);
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
        public boolean sdarsStationSubscribedOrNotAnSdarsStation;
        public boolean tmcAvailableSupportedByStation;
        public boolean tpAvailableSupportedByStation;
        public boolean dabServiceLinkedToFm;
        public boolean dabPrimaryServiceCorrupted;
        public boolean dabPrimaryServiceContainsSecondaryService;
        public boolean dvbServiceCorrupted;
        public boolean available;
        private static final int RESERVED_BIT_10__15_BITSIZE = 6;
        public boolean fmLinkedToOnlineRadio;
        public boolean dabServiceLinkedToOnlineRadio;
        private static final int ATTRIBUTES_BITSIZE = 16;

        public Attributes() {
            this.internalReset();
            this.customInitialization();
        }

        public Attributes(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.sdarsStationSubscribedOrNotAnSdarsStation = false;
            this.tmcAvailableSupportedByStation = false;
            this.tpAvailableSupportedByStation = false;
            this.dabServiceLinkedToFm = false;
            this.dabPrimaryServiceCorrupted = false;
            this.dabPrimaryServiceContainsSecondaryService = false;
            this.dvbServiceCorrupted = false;
            this.available = false;
            this.fmLinkedToOnlineRadio = false;
            this.dabServiceLinkedToOnlineRadio = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Attributes attributes = (Attributes)bAPEntity;
            return this.sdarsStationSubscribedOrNotAnSdarsStation == attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == attributes.tpAvailableSupportedByStation && this.dabServiceLinkedToFm == attributes.dabServiceLinkedToFm && this.dabPrimaryServiceCorrupted == attributes.dabPrimaryServiceCorrupted && this.dabPrimaryServiceContainsSecondaryService == attributes.dabPrimaryServiceContainsSecondaryService && this.dvbServiceCorrupted == attributes.dvbServiceCorrupted && this.available == attributes.available && this.fmLinkedToOnlineRadio == attributes.fmLinkedToOnlineRadio && this.dabServiceLinkedToOnlineRadio == attributes.dabServiceLinkedToOnlineRadio;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Attributes:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.sdarsStationSubscribedOrNotAnSdarsStation) {
                stringBuffer.append("true  (SDARS station subscribed or not an SDARS station");
            } else {
                stringBuffer.append("false  (SDARS station not subscribed");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.tmcAvailableSupportedByStation) {
                stringBuffer.append("true  (TMC available/supported by station");
            } else {
                stringBuffer.append("false  (TMC not supported/not available by station");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.tpAvailableSupportedByStation) {
                stringBuffer.append("true  (TP available/supported by station");
            } else {
                stringBuffer.append("false  (TP not available/not supported by station");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.dabServiceLinkedToFm) {
                stringBuffer.append("true  (DAB service linked to FM");
            } else {
                stringBuffer.append("false  (DAB service not linked to FM or not a DAB service");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.dabPrimaryServiceCorrupted) {
                stringBuffer.append("true  (DAB primary service corrupted");
            } else {
                stringBuffer.append("false  (service OK or not a DAB primary service");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.dabPrimaryServiceContainsSecondaryService) {
                stringBuffer.append("true  (DAB primary service contains secondary service(s)");
            } else {
                stringBuffer.append("false  (DAB primary service contains no secondary service(s) or not a DAB primary service");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.dvbServiceCorrupted) {
                stringBuffer.append("true  (DVB service corrupted");
            } else {
                stringBuffer.append("false  (service OK or not a DVB service");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.available) {
                stringBuffer.append("true  (available");
            } else {
                stringBuffer.append("false  (not available (reception level too low / DAB ensemble muted / DVB service muted/ IBOC muted/Online radio muted)");
            }
            stringBuffer.append("\n - Bit 9: ");
            if (this.fmLinkedToOnlineRadio) {
                stringBuffer.append("true  (FM linked to online radio");
            } else {
                stringBuffer.append("false  (FM not linked to online radio or no FM station");
            }
            stringBuffer.append("\n - Bit 8: ");
            if (this.dabServiceLinkedToOnlineRadio) {
                stringBuffer.append("true  (DAB service linked to online radio (DF4.1)");
            } else {
                stringBuffer.append("false  (DAB service not linked to online radio or not a DAB service");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 16;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.sdarsStationSubscribedOrNotAnSdarsStation);
            bitStream.pushBoolean(this.tmcAvailableSupportedByStation);
            bitStream.pushBoolean(this.tpAvailableSupportedByStation);
            bitStream.pushBoolean(this.dabServiceLinkedToFm);
            bitStream.pushBoolean(this.dabPrimaryServiceCorrupted);
            bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryService);
            bitStream.pushBoolean(this.dvbServiceCorrupted);
            bitStream.pushBoolean(this.available);
            bitStream.resetBits(6);
            bitStream.pushBoolean(this.fmLinkedToOnlineRadio);
            bitStream.pushBoolean(this.dabServiceLinkedToOnlineRadio);
        }

        public void deserialize(BitStream bitStream) {
            this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
            this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
            this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
            this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
            this.dabPrimaryServiceCorrupted = bitStream.popFrontBoolean();
            this.dabPrimaryServiceContainsSecondaryService = bitStream.popFrontBoolean();
            this.dvbServiceCorrupted = bitStream.popFrontBoolean();
            this.available = bitStream.popFrontBoolean();
            bitStream.discardBits(6);
            this.fmLinkedToOnlineRadio = bitStream.popFrontBoolean();
            this.dabServiceLinkedToOnlineRadio = bitStream.popFrontBoolean();
        }
    }
}

