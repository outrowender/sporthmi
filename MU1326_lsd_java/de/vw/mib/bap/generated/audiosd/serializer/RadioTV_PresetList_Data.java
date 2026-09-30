/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class RadioTV_PresetList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_ATTRIBUTES_NAME = 0;
    public static final int RECORD_ADDRESS_PRESET_INDEX_WAVEBAND_NAME = 1;
    public static final int RECORD_ADDRESS_PRESET_INDEX_NAME = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    private int pos;
    public int presetIndex;
    private static final int PRESET_INDEX_BITSIZE = 8;
    public int waveband;
    private static final int WAVEBAND_BITSIZE = 8;
    public static final int WAVEBAND_UNKNOWN_INVALID = 0;
    public static final int WAVEBAND_FM = 1;
    public static final int WAVEBAND_AM_MW_MITTELWELLE = 2;
    public static final int WAVEBAND_AM_SW_KURZWELLE = 3;
    public static final int WAVEBAND_AM_LW_LANGWELLE = 4;
    public static final int WAVEBAND_SDARS_XM = 5;
    public static final int WAVEBAND_SDARS_SIRIUS = 6;
    public static final int WAVEBAND_DAB = 7;
    public static final int WAVEBAND_DVB = 8;
    public static final int WAVEBAND_TV = 9;
    public static final int WAVEBAND_ONLINE_RADIO_DF4_1 = 10;
    public static final int WAVEBAND_COMMON_LIST_DF4_4 = 11;
    public final Attributes attributes;
    public final BAPString name;
    private static final int MAX_NAME_LENGTH = 49;

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

    public RadioTV_PresetList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new Attributes();
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

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RadioTV_PresetList_Data radioTV_PresetList_Data = (RadioTV_PresetList_Data)bAPEntity;
        return this.arrayHeader.equalTo(radioTV_PresetList_Data.arrayHeader) && this.pos == radioTV_PresetList_Data.pos && this.presetIndex == radioTV_PresetList_Data.presetIndex && this.waveband == radioTV_PresetList_Data.waveband && this.attributes.equalTo(radioTV_PresetList_Data.attributes) && this.name.equalTo(radioTV_PresetList_Data.name);
    }

    private void customInitialization() {
        this.name.setLimitingLengthByCharacters();
    }

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

    public static final class Attributes
    implements BAPEntity {
        public boolean sdarsStationSubscribedOrNotAnSdarsStation;
        public boolean tmcAvailableSupportedByStation;
        public boolean tpAvailableSupportedByStation;
        public boolean onlineRadioPrimaryServiceContainsSecondaryService;
        public boolean onlineRadioSecondaryService;
        public boolean dabPrimaryServiceContainsSecondaryService;
        public boolean dabSecondaryService;
        public boolean ibocService;
        private static final int RESERVED_BIT_8__15_BITSIZE = 8;
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
            this.onlineRadioPrimaryServiceContainsSecondaryService = false;
            this.onlineRadioSecondaryService = false;
            this.dabPrimaryServiceContainsSecondaryService = false;
            this.dabSecondaryService = false;
            this.ibocService = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            Attributes attributes = (Attributes)bAPEntity;
            return this.sdarsStationSubscribedOrNotAnSdarsStation == attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == attributes.tpAvailableSupportedByStation && this.onlineRadioPrimaryServiceContainsSecondaryService == attributes.onlineRadioPrimaryServiceContainsSecondaryService && this.onlineRadioSecondaryService == attributes.onlineRadioSecondaryService && this.dabPrimaryServiceContainsSecondaryService == attributes.dabPrimaryServiceContainsSecondaryService && this.dabSecondaryService == attributes.dabSecondaryService && this.ibocService == attributes.ibocService;
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
            if (this.onlineRadioPrimaryServiceContainsSecondaryService) {
                stringBuffer.append("true  (Online radio primary service contains secondary service(s) (DF4.1)");
            } else {
                stringBuffer.append("false  (Online radio primary service contains no secondary service(s) / no online radio primary service (DF4.1)");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.onlineRadioSecondaryService) {
                stringBuffer.append("true  (Online radio secondary service (DF4.1)");
            } else {
                stringBuffer.append("false  (not an online radio secondary service (DF4.1)");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.dabPrimaryServiceContainsSecondaryService) {
                stringBuffer.append("true  (DAB primary service contains secondary service(s)");
            } else {
                stringBuffer.append("false  (DAB primary service contains no secondary service(s) / no DAB primary service");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.dabSecondaryService) {
                stringBuffer.append("true  (DAB secondary service");
            } else {
                stringBuffer.append("false  (not a DAB secondary service");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.ibocService) {
                stringBuffer.append("true  (IBOC service");
            } else {
                stringBuffer.append("false  (not an IBOC service");
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
            bitStream.pushBoolean(this.onlineRadioPrimaryServiceContainsSecondaryService);
            bitStream.pushBoolean(this.onlineRadioSecondaryService);
            bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryService);
            bitStream.pushBoolean(this.dabSecondaryService);
            bitStream.pushBoolean(this.ibocService);
            bitStream.resetBits(8);
        }

        public void deserialize(BitStream bitStream) {
            this.sdarsStationSubscribedOrNotAnSdarsStation = bitStream.popFrontBoolean();
            this.tmcAvailableSupportedByStation = bitStream.popFrontBoolean();
            this.tpAvailableSupportedByStation = bitStream.popFrontBoolean();
            this.onlineRadioPrimaryServiceContainsSecondaryService = bitStream.popFrontBoolean();
            this.onlineRadioSecondaryService = bitStream.popFrontBoolean();
            this.dabPrimaryServiceContainsSecondaryService = bitStream.popFrontBoolean();
            this.dabSecondaryService = bitStream.popFrontBoolean();
            this.ibocService = bitStream.popFrontBoolean();
            bitStream.discardBits(8);
        }
    }
}

