/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$NewDistanceToDestination
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
    public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE;
    public int typeOfDistance;
    private static final int TYPE_OF_DISTANCE_BITSIZE;
    public static final int TYPE_OF_DISTANCE_ROAD_DISTANCE;
    public static final int TYPE_OF_DISTANCE_LINEAR_DISTANCE;
    public static final int TYPE_OF_DISTANCE_DISTANCE_INVALID;

    public SemidynamicRouteGuidance_Status$NewDistanceToDestination() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$NewDistanceToDestination(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distance = 0;
        this.unit = 0;
        this.typeOfDistance = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$NewDistanceToDestination semidynamicRouteGuidance_Status$NewDistanceToDestination = (SemidynamicRouteGuidance_Status$NewDistanceToDestination)bAPEntity;
        return this.distance == semidynamicRouteGuidance_Status$NewDistanceToDestination.distance && this.unit == semidynamicRouteGuidance_Status$NewDistanceToDestination.unit && this.typeOfDistance == semidynamicRouteGuidance_Status$NewDistanceToDestination.typeOfDistance;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NewDistanceToDestination:");
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
                stringBuffer.append("0xFF (not supported / no information about unit available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TypeOfDistance: ");
        switch (this.typeOfDistance) {
            case 0: {
                stringBuffer.append("0x00 (road distance)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (linear distance)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (distance invalid)");
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
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.distance);
        bitStream.pushByte((byte)this.unit);
        bitStream.pushByte((byte)this.typeOfDistance);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.distance = bitStream.popFrontInt();
        this.unit = bitStream.popFrontByte();
        this.typeOfDistance = bitStream.popFrontByte();
    }
}

