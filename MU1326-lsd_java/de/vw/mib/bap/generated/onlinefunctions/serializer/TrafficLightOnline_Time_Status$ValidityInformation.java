/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Time_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean timeToGreenIsValid;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public TrafficLightOnline_Time_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Time_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeToGreenIsValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Time_Status$ValidityInformation trafficLightOnline_Time_Status$ValidityInformation = (TrafficLightOnline_Time_Status$ValidityInformation)bAPEntity;
        return this.timeToGreenIsValid == trafficLightOnline_Time_Status$ValidityInformation.timeToGreenIsValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.timeToGreenIsValid) {
            stringBuffer.append("true  (TimeToGreen is valid");
        } else {
            stringBuffer.append("false  (TimeToGreen is invalid");
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.timeToGreenIsValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.timeToGreenIsValid = bitStream.popFrontBoolean();
    }
}

