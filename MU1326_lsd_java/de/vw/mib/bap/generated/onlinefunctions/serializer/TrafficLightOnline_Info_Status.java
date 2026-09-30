/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TrafficLightOnline_Info_Status
implements StatusProperty {
    public int trafficLight;
    private static final int TRAFFIC_LIGHT_BITSIZE = 8;
    public static final int TRAFFIC_LIGHT_NO_TRAFFIC_LIGHT = 0;
    public static final int TRAFFIC_LIGHT_GREEN_TRAFFIC_LIGHT = 1;
    public static final int TRAFFIC_LIGHT_YELLOW_TRAFFIC_LIGHT = 2;
    public static final int TRAFFIC_LIGHT_RED_TRAFFIC_LIGHT = 3;
    public static final int TRAFFIC_LIGHT_GREY_TRAFFIC_LIGHT = 4;
    public static final int TRAFFIC_LIGHT_SYNCHRONISED_TRAFFIC_LIGHTS = 5;
    public int mainDirection;
    private static final int MAIN_DIRECTION_BITSIZE = 8;
    public final BAPString sidestreets = new BAPString(4);
    private static final int MAX_SIDESTREETS_LENGTH = 4;
    public final TrafficLightWarnings trafficLightWarnings = new TrafficLightWarnings();
    public int trafficLightLayout;
    private static final int TRAFFIC_LIGHT_LAYOUT_BITSIZE = 8;
    public static final int TRAFFIC_LIGHT_LAYOUT_VERTICAL_LAYOUT_RED_TOP = 0;
    public static final int TRAFFIC_LIGHT_LAYOUT_HORIZONTAL_LAYOUT_RED_LEFT = 1;
    public static final int TRAFFIC_LIGHT_LAYOUT_HORIZONTAL_LAYOUT_RED_RIGHT = 2;

    public TrafficLightOnline_Info_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TrafficLightOnline_Info_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.trafficLight = 0;
        this.mainDirection = 0;
        this.trafficLightLayout = 0;
    }

    public void reset() {
        this.internalReset();
        this.sidestreets.reset();
        this.trafficLightWarnings.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TrafficLightOnline_Info_Status trafficLightOnline_Info_Status = (TrafficLightOnline_Info_Status)bAPEntity;
        return this.trafficLight == trafficLightOnline_Info_Status.trafficLight && this.mainDirection == trafficLightOnline_Info_Status.mainDirection && this.sidestreets.equalTo(trafficLightOnline_Info_Status.sidestreets) && this.trafficLightWarnings.equalTo(trafficLightOnline_Info_Status.trafficLightWarnings) && this.trafficLightLayout == trafficLightOnline_Info_Status.trafficLightLayout;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TrafficLightOnline_Info_Status:");
        stringBuffer.append("\n - TrafficLight: ");
        switch (this.trafficLight) {
            case 0: {
                stringBuffer.append("0x00 (no traffic light)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (green traffic light)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (yellow traffic light)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (red traffic light)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (grey traffic light)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (synchronised traffic lights)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MainDirection - ");
        stringBuffer.append(this.mainDirection);
        stringBuffer.append("\n - Sidestreets - ");
        stringBuffer.append(this.sidestreets.toString());
        stringBuffer.append("\n - TrafficLightWarnings - ");
        stringBuffer.append(this.trafficLightWarnings.toString());
        stringBuffer.append("\n - TrafficLightLayout: ");
        switch (this.trafficLightLayout) {
            case 0: {
                stringBuffer.append("0x00 (vertical layout, red top)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (horizontal layout, red left)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (horizontal layout, red right)");
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
        n += 8;
        n += 8;
        n += this.sidestreets.bitSize();
        n += this.trafficLightWarnings.bitSize();
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.trafficLight);
        bitStream.pushByte((byte)this.mainDirection);
        this.sidestreets.serialize(bitStream);
        this.trafficLightWarnings.serialize(bitStream);
        bitStream.pushByte((byte)this.trafficLightLayout);
    }

    public void deserialize(BitStream bitStream) {
        this.trafficLight = bitStream.popFrontByte();
        this.mainDirection = bitStream.popFrontByte();
        this.sidestreets.deserialize(bitStream);
        this.trafficLightWarnings.deserialize(bitStream);
        this.trafficLightLayout = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    public int getFunctionId() {
        return TrafficLightOnline_Info_Status.functionId();
    }

    public static final class TrafficLightWarnings
    implements BAPEntity {
        private static final int RESERVED_BIT_2__7_BITSIZE = 6;
        public boolean displayRedLightWarning2;
        public boolean displayRedLightWarning1;
        private static final int TRAFFIC_LIGHT_WARNINGS_BITSIZE = 8;

        public TrafficLightWarnings() {
            this.internalReset();
            this.customInitialization();
        }

        public TrafficLightWarnings(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.displayRedLightWarning2 = false;
            this.displayRedLightWarning1 = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            TrafficLightWarnings trafficLightWarnings = (TrafficLightWarnings)bAPEntity;
            return this.displayRedLightWarning2 == trafficLightWarnings.displayRedLightWarning2 && this.displayRedLightWarning1 == trafficLightWarnings.displayRedLightWarning1;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(6);
            bitStream.pushBoolean(this.displayRedLightWarning2);
            bitStream.pushBoolean(this.displayRedLightWarning1);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(6);
            this.displayRedLightWarning2 = bitStream.popFrontBoolean();
            this.displayRedLightWarning1 = bitStream.popFrontBoolean();
        }
    }
}

