/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.onlinefunctions.serializer.TrafficLightOnline_Speed_Status$ValidityInformation;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Speed_Status
implements StatusProperty {
    public int recommendedSpeed;
    private static final int RECOMMENDED_SPEED_BITSIZE;
    public int unit;
    private static final int UNIT_BITSIZE;
    public static final int UNIT_KM_H;
    public static final int UNIT_MPH;
    public static final int UNIT_UNIT_NOT_SUPPORTED;
    public final TrafficLightOnline_Speed_Status$ValidityInformation validityInformation = new TrafficLightOnline_Speed_Status$ValidityInformation();

    public TrafficLightOnline_Speed_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Speed_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.recommendedSpeed = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.validityInformation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Speed_Status trafficLightOnline_Speed_Status = (TrafficLightOnline_Speed_Status)bAPEntity;
        return this.recommendedSpeed == trafficLightOnline_Speed_Status.recommendedSpeed && this.unit == trafficLightOnline_Speed_Status.unit && this.validityInformation.equalTo(trafficLightOnline_Speed_Status.validityInformation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficLightOnline_Speed_Status:");
        stringBuffer.append("\n - RecommendedSpeed - ");
        stringBuffer.append(this.recommendedSpeed);
        stringBuffer.append("\n - Unit: ");
        switch (this.unit) {
            case 0: {
                stringBuffer.append("0x00 (km/h)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (mph)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (unit not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += this.validityInformation.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.recommendedSpeed);
        bitStream.pushByte((byte)this.unit);
        this.validityInformation.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.recommendedSpeed = bitStream.popFrontByte();
        this.unit = bitStream.popFrontByte();
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return TrafficLightOnline_Speed_Status.functionId();
    }
}

