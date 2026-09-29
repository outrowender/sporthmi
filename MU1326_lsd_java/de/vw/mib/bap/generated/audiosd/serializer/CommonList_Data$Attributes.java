/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CommonList_Data$Attributes
implements BAPEntity {
    public boolean sdarsStationSubscribedOrNotAnSdarsStation;
    public boolean tmcAvailableSupportedByStation;
    public boolean tpAvailableSupportedByStation;
    public boolean dabServiceLinkedToFm;
    public boolean dabPrimaryServiceCorrupted;
    public boolean dabPrimaryServiceContainsSecondaryService;
    public boolean dvbServiceCorrupted;
    public boolean available;
    private static final int RESERVED_BIT_10__15_BITSIZE;
    public boolean fmLinkedToOnlineRadio;
    public boolean dabServiceLinkedToOnlineRadio;
    private static final int ATTRIBUTES_BITSIZE;

    public CommonList_Data$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public CommonList_Data$Attributes(BitStream bitStream) {
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CommonList_Data$Attributes commonList_Data$Attributes = (CommonList_Data$Attributes)bAPEntity;
        return this.sdarsStationSubscribedOrNotAnSdarsStation == commonList_Data$Attributes.sdarsStationSubscribedOrNotAnSdarsStation && this.tmcAvailableSupportedByStation == commonList_Data$Attributes.tmcAvailableSupportedByStation && this.tpAvailableSupportedByStation == commonList_Data$Attributes.tpAvailableSupportedByStation && this.dabServiceLinkedToFm == commonList_Data$Attributes.dabServiceLinkedToFm && this.dabPrimaryServiceCorrupted == commonList_Data$Attributes.dabPrimaryServiceCorrupted && this.dabPrimaryServiceContainsSecondaryService == commonList_Data$Attributes.dabPrimaryServiceContainsSecondaryService && this.dvbServiceCorrupted == commonList_Data$Attributes.dvbServiceCorrupted && this.available == commonList_Data$Attributes.available && this.fmLinkedToOnlineRadio == commonList_Data$Attributes.fmLinkedToOnlineRadio && this.dabServiceLinkedToOnlineRadio == commonList_Data$Attributes.dabServiceLinkedToOnlineRadio;
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
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
        bitStream.pushBoolean(this.dabPrimaryServiceCorrupted);
        bitStream.pushBoolean(this.dabPrimaryServiceContainsSecondaryService);
        bitStream.pushBoolean(this.dvbServiceCorrupted);
        bitStream.pushBoolean(this.available);
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.fmLinkedToOnlineRadio);
        bitStream.pushBoolean(this.dabServiceLinkedToOnlineRadio);
    }

    @Override
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

