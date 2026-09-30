/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Altitude_Status
implements StatusProperty {
    public int altitude;
    private static final int ALTITUDE_BITSIZE = 16;
    public int unit;
    private static final int UNIT_BITSIZE = 8;
    public static final int UNIT_METER = 0;
    public static final int UNIT_FEET = 1;

    public Altitude_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Altitude_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.altitude = 0;
        this.unit = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Altitude_Status altitude_Status = (Altitude_Status)bAPEntity;
        return this.altitude == altitude_Status.altitude && this.unit == altitude_Status.unit;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Altitude_Status:");
        stringBuffer.append("\n - Altitude - ");
        stringBuffer.append(this.altitude);
        stringBuffer.append("\n - Unit: ");
        switch (this.unit) {
            case 0: {
                stringBuffer.append("0x00 (meter)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (feet)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 16;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.altitude);
        bitStream.pushByte((byte)this.unit);
    }

    public void deserialize(BitStream bitStream) {
        this.altitude = (short)bitStream.popFrontShort();
        this.unit = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 47;
    }

    public int getFunctionId() {
        return Altitude_Status.functionId();
    }
}

