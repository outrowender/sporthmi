/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Speed_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean recommendedSpeedIsValid;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public TrafficLightOnline_Speed_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Speed_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.recommendedSpeedIsValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Speed_Status$ValidityInformation trafficLightOnline_Speed_Status$ValidityInformation = (TrafficLightOnline_Speed_Status$ValidityInformation)bAPEntity;
        return this.recommendedSpeedIsValid == trafficLightOnline_Speed_Status$ValidityInformation.recommendedSpeedIsValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.recommendedSpeedIsValid) {
            stringBuffer.append("true  (RecommendedSpeed is valid");
        } else {
            stringBuffer.append("false  (RecommendedSpeed is invalid");
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
        bitStream.pushBoolean(this.recommendedSpeedIsValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.recommendedSpeedIsValid = bitStream.popFrontBoolean();
    }
}

