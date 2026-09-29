/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Info_Status$TrafficLightWarnings
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean displayRedLightWarning2;
    public boolean displayRedLightWarning1;
    private static final int TRAFFIC_LIGHT_WARNINGS_BITSIZE;

    public TrafficLightOnline_Info_Status$TrafficLightWarnings() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Info_Status$TrafficLightWarnings(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.displayRedLightWarning2 = false;
        this.displayRedLightWarning1 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Info_Status$TrafficLightWarnings trafficLightOnline_Info_Status$TrafficLightWarnings = (TrafficLightOnline_Info_Status$TrafficLightWarnings)bAPEntity;
        return this.displayRedLightWarning2 == trafficLightOnline_Info_Status$TrafficLightWarnings.displayRedLightWarning2 && this.displayRedLightWarning1 == trafficLightOnline_Info_Status$TrafficLightWarnings.displayRedLightWarning1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficLightWarnings:");
        stringBuffer.append("\n - Bit 1: ");
        if (this.displayRedLightWarning2) {
            stringBuffer.append("true  (display red light warning 2");
        } else {
            stringBuffer.append("false  (do not display red light warning 2");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.displayRedLightWarning1) {
            stringBuffer.append("true  (display red light warning 1");
        } else {
            stringBuffer.append("false  (do not display red light warning 1");
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
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.displayRedLightWarning2);
        bitStream.pushBoolean(this.displayRedLightWarning1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.displayRedLightWarning2 = bitStream.popFrontBoolean();
        this.displayRedLightWarning1 = bitStream.popFrontBoolean();
    }
}

