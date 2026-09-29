/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$DistanceToNextManeuver
implements BAPEntity {
    public int distance;
    private static final int DISTANCE_BITSIZE;
    public int unit;
    private static final int UNIT_BITSIZE;
    public static final int UNIT_METER;
    public static final int UNIT_KILOMETER;
    public static final int UNIT_YARD;
    public static final int UNIT_FEET;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE;
    public static final int UNIT_NOT_SUPPORTED;

    public DistanceToNextManeuver_Status$DistanceToNextManeuver() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$DistanceToNextManeuver(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distance = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$DistanceToNextManeuver distanceToNextManeuver_Status$DistanceToNextManeuver = (DistanceToNextManeuver_Status$DistanceToNextManeuver)bAPEntity;
        return this.distance == distanceToNextManeuver_Status$DistanceToNextManeuver.distance && this.unit == distanceToNextManeuver_Status$DistanceToNextManeuver.unit;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistanceToNextManeuver:");
        stringBuffer.append("\n - Distance - ");
        stringBuffer.append(this.distance);
        stringBuffer.append("\n - Unit: ");
        switch (this.unit) {
            case 0: {
                stringBuffer.append("0x00 (meter)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (kilometer)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (yard)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (feet)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (mile (UK and US (statute mile)))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (quarter mile(s) (n* 1/4mile))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 32;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.distance);
        bitStream.pushByte((byte)this.unit);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.distance = bitStream.popFrontInt();
        this.unit = bitStream.popFrontByte();
    }
}

