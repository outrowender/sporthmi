/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStationInfo_Status$StationInfoSwitches
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean ibocHdRadioAvailable;
    public boolean vicsAvailable;
    public boolean tmcAvailable;
    public boolean taTpAvailable;
    private static final int STATION_INFO_SWITCHES_BITSIZE;

    public CurrentStationInfo_Status$StationInfoSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStationInfo_Status$StationInfoSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ibocHdRadioAvailable = false;
        this.vicsAvailable = false;
        this.tmcAvailable = false;
        this.taTpAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStationInfo_Status$StationInfoSwitches currentStationInfo_Status$StationInfoSwitches = (CurrentStationInfo_Status$StationInfoSwitches)bAPEntity;
        return this.ibocHdRadioAvailable == currentStationInfo_Status$StationInfoSwitches.ibocHdRadioAvailable && this.vicsAvailable == currentStationInfo_Status$StationInfoSwitches.vicsAvailable && this.tmcAvailable == currentStationInfo_Status$StationInfoSwitches.tmcAvailable && this.taTpAvailable == currentStationInfo_Status$StationInfoSwitches.taTpAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StationInfoSwitches:");
        stringBuffer.append("\n - Bit 3: ");
        if (this.ibocHdRadioAvailable) {
            stringBuffer.append("true  (IBOC/HD-radio available");
        } else {
            stringBuffer.append("false  (IBOC/HD-radio not available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.vicsAvailable) {
            stringBuffer.append("true  (VICS available (JAPAN market only)");
        } else {
            stringBuffer.append("false  (VICS not available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.tmcAvailable) {
            stringBuffer.append("true  (TMC available");
        } else {
            stringBuffer.append("false  (TMC not available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.taTpAvailable) {
            stringBuffer.append("true  (TA / TP available");
        } else {
            stringBuffer.append("false  (TA / TP not available");
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
        bitStream.pushBoolean(this.ibocHdRadioAvailable);
        bitStream.pushBoolean(this.vicsAvailable);
        bitStream.pushBoolean(this.tmcAvailable);
        bitStream.pushBoolean(this.taTpAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.ibocHdRadioAvailable = bitStream.popFrontBoolean();
        this.vicsAvailable = bitStream.popFrontBoolean();
        this.tmcAvailable = bitStream.popFrontBoolean();
        this.taTpAvailable = bitStream.popFrontBoolean();
    }
}

