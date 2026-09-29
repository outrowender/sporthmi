/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status$StationProperties
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean stationLinkedToOnlineRadio;
    public boolean dabServiceDoesNotContainAnyAudioSignal;
    public boolean ibocLiveTransmissionActive;
    public boolean dabServiceLinkedToFm;
    private static final int STATION_PROPERTIES_BITSIZE;

    public CurrentStationInfo_Status$StationProperties() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status$StationProperties(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stationLinkedToOnlineRadio = false;
        this.dabServiceDoesNotContainAnyAudioSignal = false;
        this.ibocLiveTransmissionActive = false;
        this.dabServiceLinkedToFm = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status$StationProperties currentStationInfo_Status$StationProperties = (CurrentStationInfo_Status$StationProperties)bAPEntity;
        return this.stationLinkedToOnlineRadio == currentStationInfo_Status$StationProperties.stationLinkedToOnlineRadio && this.dabServiceDoesNotContainAnyAudioSignal == currentStationInfo_Status$StationProperties.dabServiceDoesNotContainAnyAudioSignal && this.ibocLiveTransmissionActive == currentStationInfo_Status$StationProperties.ibocLiveTransmissionActive && this.dabServiceLinkedToFm == currentStationInfo_Status$StationProperties.dabServiceLinkedToFm;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StationProperties:");
        stringBuffer.append("\n - Bit 3: ");
        if (this.stationLinkedToOnlineRadio) {
            stringBuffer.append("true  (station linked to online radio (DF 4.1)");
        } else {
            stringBuffer.append("false  (station not linked to online radio (DF 4.1)");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.dabServiceDoesNotContainAnyAudioSignal) {
            stringBuffer.append("true  (DAB service does not contain any audio signal (DF 4.1)");
        } else {
            stringBuffer.append("false  (no DAB service or DAB service contains audio signal (DF 4.1)");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.ibocLiveTransmissionActive) {
            stringBuffer.append("true  (IBOC live transmission active (HD live mode)");
        } else {
            stringBuffer.append("false  (no IBOC live transmission or not applicable");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.dabServiceLinkedToFm) {
            stringBuffer.append("true  (DAB service linked to FM");
        } else {
            stringBuffer.append("false  (DAB service not linked to FM or not applicable");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.stationLinkedToOnlineRadio);
        bitStream.pushBoolean(this.dabServiceDoesNotContainAnyAudioSignal);
        bitStream.pushBoolean(this.ibocLiveTransmissionActive);
        bitStream.pushBoolean(this.dabServiceLinkedToFm);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.stationLinkedToOnlineRadio = bitStream.popFrontBoolean();
        this.dabServiceDoesNotContainAnyAudioSignal = bitStream.popFrontBoolean();
        this.ibocLiveTransmissionActive = bitStream.popFrontBoolean();
        this.dabServiceLinkedToFm = bitStream.popFrontBoolean();
    }
}

