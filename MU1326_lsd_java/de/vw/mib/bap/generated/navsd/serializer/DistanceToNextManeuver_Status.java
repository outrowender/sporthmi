/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status
implements StatusProperty {
    public final DistanceToNextManeuver distanceToNextManeuver = new DistanceToNextManeuver();
    public final BargraphInfo bargraphInfo = new BargraphInfo();
    public final ValidityInformation validityInformation = new ValidityInformation();

    public DistanceToNextManeuver_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.distanceToNextManeuver.reset();
        this.bargraphInfo.reset();
        this.validityInformation.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status distanceToNextManeuver_Status = (DistanceToNextManeuver_Status)bAPEntity;
        return this.distanceToNextManeuver.equalTo(distanceToNextManeuver_Status.distanceToNextManeuver) && this.bargraphInfo.equalTo(distanceToNextManeuver_Status.bargraphInfo) && this.validityInformation.equalTo(distanceToNextManeuver_Status.validityInformation);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistanceToNextManeuver_Status:");
        stringBuffer.append("\n - DistanceToNextManeuver - ");
        stringBuffer.append(this.distanceToNextManeuver.toString());
        stringBuffer.append("\n - BargraphInfo - ");
        stringBuffer.append(this.bargraphInfo.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.distanceToNextManeuver.bitSize();
        n += this.bargraphInfo.bitSize();
        return n += this.validityInformation.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.distanceToNextManeuver.serialize(bitStream);
        this.bargraphInfo.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.distanceToNextManeuver.deserialize(bitStream);
        this.bargraphInfo.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return DistanceToNextManeuver_Status.functionId();
    }

    public static final class BargraphInfo
    implements BAPEntity {
        public int bargraphOnOff;
        private static final int BARGRAPH_ON_OFF_BITSIZE = 8;
        public static final int BARGRAPH_ON_OFF_BARGRAPH_SHALL_NOT_BE_DISPLAYED = 0;
        public static final int BARGRAPH_ON_OFF_DISPLAY_BARGRAPH = 1;
        public static final int BARGRAPH_ON_OFF_NOT_SUPPORTED = 255;
        public int bargraph;
        private static final int BARGRAPH_BITSIZE = 8;

        public BargraphInfo() {
            this.internalReset();
            this.customInitialization();
        }

        public BargraphInfo(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.bargraphOnOff = 0;
            this.bargraph = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            BargraphInfo bargraphInfo = (BargraphInfo)bAPEntity;
            return this.bargraphOnOff == bargraphInfo.bargraphOnOff && this.bargraph == bargraphInfo.bargraph;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("BargraphInfo:");
            stringBuffer.append("\n - BargraphOnOff: ");
            switch (this.bargraphOnOff) {
                case 0: {
                    stringBuffer.append("0x00 (bargraph shall not be displayed)");
                    break;
                }
                case 1: {
                    stringBuffer.append("0x01 (display bargraph)");
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
            stringBuffer.append("\n - Bargraph - ");
            stringBuffer.append(this.bargraph);
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            n += 8;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushByte((byte)this.bargraphOnOff);
            bitStream.pushByte((byte)this.bargraph);
        }

        public void deserialize(BitStream bitStream) {
            this.bargraphOnOff = bitStream.popFrontByte();
            this.bargraph = bitStream.popFrontByte();
        }
    }

    public static final class ValidityInformation
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean distanceToNextManeuverValid;
        private static final int VALIDITY_INFORMATION_BITSIZE = 8;

        public ValidityInformation() {
            this.internalReset();
            this.customInitialization();
        }

        public ValidityInformation(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.distanceToNextManeuverValid = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ValidityInformation validityInformation = (ValidityInformation)bAPEntity;
            return this.distanceToNextManeuverValid == validityInformation.distanceToNextManeuverValid;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ValidityInformation:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.distanceToNextManeuverValid) {
                stringBuffer.append("true  (DistanceToNextManeuver valid");
            } else {
                stringBuffer.append("false  (DistanceToNextManeuver invalid");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.distanceToNextManeuverValid);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.distanceToNextManeuverValid = bitStream.popFrontBoolean();
        }
    }

    public static final class DistanceToNextManeuver
    implements BAPEntity {
        public int distance;
        private static final int DISTANCE_BITSIZE = 32;
        public int unit;
        private static final int UNIT_BITSIZE = 8;
        public static final int UNIT_METER = 0;
        public static final int UNIT_KILOMETER = 1;
        public static final int UNIT_YARD = 2;
        public static final int UNIT_FEET = 3;
        public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE = 4;
        public static final int UNIT_QUARTER_MILES_N_1_4MILE = 5;
        public static final int UNIT_NOT_SUPPORTED = 255;

        public DistanceToNextManeuver() {
            this.internalReset();
            this.customInitialization();
        }

        public DistanceToNextManeuver(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.distance = 0;
            this.unit = 0;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            DistanceToNextManeuver distanceToNextManeuver = (DistanceToNextManeuver)bAPEntity;
            return this.distance == distanceToNextManeuver.distance && this.unit == distanceToNextManeuver.unit;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            n += 32;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushInt(this.distance);
            bitStream.pushByte((byte)this.unit);
        }

        public void deserialize(BitStream bitStream) {
            this.distance = bitStream.popFrontInt();
            this.unit = bitStream.popFrontByte();
        }
    }
}

