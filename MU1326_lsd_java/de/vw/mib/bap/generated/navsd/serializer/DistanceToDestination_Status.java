/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status
implements StatusProperty {
    public final DistanceToDestination distanceToDestination = new DistanceToDestination();
    public final DistanceToDestinationType distanceToDestinationType = new DistanceToDestinationType();
    public final ValidityInformation validityInformation = new ValidityInformation();

    public DistanceToDestination_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.distanceToDestination.reset();
        this.distanceToDestinationType.reset();
        this.validityInformation.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToDestination_Status distanceToDestination_Status = (DistanceToDestination_Status)bAPEntity;
        return this.distanceToDestination.equalTo(distanceToDestination_Status.distanceToDestination) && this.distanceToDestinationType.equalTo(distanceToDestination_Status.distanceToDestinationType) && this.validityInformation.equalTo(distanceToDestination_Status.validityInformation);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistanceToDestination_Status:");
        stringBuffer.append("\n - DistanceToDestination - ");
        stringBuffer.append(this.distanceToDestination.toString());
        stringBuffer.append("\n - DistanceToDestinationType - ");
        stringBuffer.append(this.distanceToDestinationType.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.distanceToDestination.bitSize();
        n += this.distanceToDestinationType.bitSize();
        return n += this.validityInformation.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.distanceToDestination.serialize(bitStream);
        this.distanceToDestinationType.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.distanceToDestination.deserialize(bitStream);
        this.distanceToDestinationType.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return DistanceToDestination_Status.functionId();
    }

    public static final class ValidityInformation
    implements BAPEntity {
        private static final int RESERVED_BIT_1__3_BITSIZE = 3;
        public boolean distanceToDestinationValid;
        private static final int VALIDITY_INFORMATION_BITSIZE = 4;

        public ValidityInformation() {
            this.internalReset();
            this.customInitialization();
        }

        public ValidityInformation(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.distanceToDestinationValid = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ValidityInformation validityInformation = (ValidityInformation)bAPEntity;
            return this.distanceToDestinationValid == validityInformation.distanceToDestinationValid;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ValidityInformation:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.distanceToDestinationValid) {
                stringBuffer.append("true  (DistanceToDestination valid");
            } else {
                stringBuffer.append("false  (DistanceToDestination invalid");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(3);
            bitStream.pushBoolean(this.distanceToDestinationValid);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(3);
            this.distanceToDestinationValid = bitStream.popFrontBoolean();
        }
    }

    public static final class DistanceToDestination
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
        public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_ABOUT_UNIT_AVAILABLE = 255;

        public DistanceToDestination() {
            this.internalReset();
            this.customInitialization();
        }

        public DistanceToDestination(BitStream bitStream) {
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
            DistanceToDestination distanceToDestination = (DistanceToDestination)bAPEntity;
            return this.distance == distanceToDestination.distance && this.unit == distanceToDestination.unit;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DistanceToDestination:");
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

    public static final class DistanceToDestinationType
    implements BAPEntity {
        private static final int RESERVED_BIT_1__3_BITSIZE = 3;
        public boolean distanceToStopover;
        private static final int DISTANCE_TO_DESTINATION_TYPE_BITSIZE = 4;

        public DistanceToDestinationType() {
            this.internalReset();
            this.customInitialization();
        }

        public DistanceToDestinationType(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.distanceToStopover = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            DistanceToDestinationType distanceToDestinationType = (DistanceToDestinationType)bAPEntity;
            return this.distanceToStopover == distanceToDestinationType.distanceToStopover;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DistanceToDestinationType:");
            stringBuffer.append("\n - Bit 0: ");
            if (this.distanceToStopover) {
                stringBuffer.append("true  (Distance to Stopover");
            } else {
                stringBuffer.append("false  (Distance to Destination");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 4;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(3);
            bitStream.pushBoolean(this.distanceToStopover);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(3);
            this.distanceToStopover = bitStream.popFrontBoolean();
        }
    }
}

