/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RadioTV_PresetList_Data$Attributes
implements BAPEntity {
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean onlineRadioPrimaryServiceContainsSecondaryService;
    public boolean onlineRadioSecondaryService;
    public boolean dabPrimaryServiceContainsSecondaryService;
    public boolean dabSecondaryService;
    public boolean ibocService;
    private static final int RESERVED_BIT_8__15_BITSIZE;
    private static final int ATTRIBUTES_BITSIZE;

    public RadioTV_PresetList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public RadioTV_PresetList_Data$Attributes(BitStream bitStream) {
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RadioTV_PresetList_Data$Attributes radioTV_PresetList_Data$Attributes = (RadioTV_PresetList_Data$Attributes)bAPEntity;
        return this.sdarsStationSubscribedOrNotAnSdarsStation == radioTV_PresetList_Data$Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == radioTV_PresetList_Data$Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == radioTV_PresetList_Data$Attributes.tpAvailableSupportedByStation && this.onlineRadioPrimaryServiceContainsSecondaryService == radioTV_PresetList_Data$Attributes.onlineRadioPrimaryServiceContainsSecondaryService && this.onlineRadioSecondaryService == radioTV_PresetList_Data$Attributes.onlineRadioSecondaryService && this.dabPrimaryServiceContainsSecondaryService == radioTV_PresetList_Data$Attributes.dabPrimaryServiceContainsSecondaryService && this.dabSecondaryService == radioTV_PresetList_Data$Attributes.dabSecondaryService && this.ibocService == radioTV_PresetList_Data$Attributes.ibocService;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 16;
    }

    @Override
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

    @Override
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

