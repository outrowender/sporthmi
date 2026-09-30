/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Time_Status
implements StatusProperty {
    public int timeToGreen;
    private static final int TIME_TO_GREEN_BITSIZE = 8;
    public final ValidityInformation validityInformation = new ValidityInformation();
    public static final int EXTENSION1_MIN = 0;
    public int extension1;
    private static final int EXTENSION1_BITSIZE = 8;
    public static final int EXTENSION2_MIN = 0;
    public int extension2;
    private static final int EXTENSION2_BITSIZE = 8;
    public static final int EXTENSION3_MIN = 0;
    public int extension3;
    private static final int EXTENSION3_BITSIZE = 8;

    public TrafficLightOnline_Time_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Time_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeToGreen = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
    }

    public void reset() {
        this.internalReset();
        this.validityInformation.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Time_Status trafficLightOnline_Time_Status = (TrafficLightOnline_Time_Status)bAPEntity;
        return this.timeToGreen == trafficLightOnline_Time_Status.timeToGreen && this.validityInformation.equalTo(trafficLightOnline_Time_Status.validityInformation) && this.extension1 == trafficLightOnline_Time_Status.extension1 && this.extension2 == trafficLightOnline_Time_Status.extension2 && this.extension3 == trafficLightOnline_Time_Status.extension3;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficLightOnline_Time_Status:");
        stringBuffer.append("\n - TimeToGreen - ");
        stringBuffer.append(this.timeToGreen);
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        stringBuffer.append("\n - Extension2 - ");
        stringBuffer.append(this.extension2);
        stringBuffer.append("\n - Extension3 - ");
        stringBuffer.append(this.extension3);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += this.validityInformation.bitSize();
        n += 8;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.timeToGreen);
        this.validityInformation.serialize(bitStream);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
    }

    public void deserialize(BitStream bitStream) {
        this.timeToGreen = bitStream.popFrontByte();
        this.validityInformation.deserialize(bitStream);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return TrafficLightOnline_Time_Status.functionId();
    }

    public static final class ValidityInformation
    implements BAPEntity {
        private static final int RESERVED_BIT_1__7_BITSIZE = 7;
        public boolean timeToGreenIsValid;
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
            this.timeToGreenIsValid = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            ValidityInformation validityInformation = (ValidityInformation)bAPEntity;
            return this.timeToGreenIsValid == validityInformation.timeToGreenIsValid;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(7);
            bitStream.pushBoolean(this.timeToGreenIsValid);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(7);
            this.timeToGreenIsValid = bitStream.popFrontBoolean();
        }
    }
}

