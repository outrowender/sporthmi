/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapColorAndType_Status
implements StatusProperty {
    public int colour;
    private static final int COLOUR_BITSIZE = 8;
    public static final int COLOUR_DAY = 0;
    public static final int COLOUR_NIGHT = 1;
    public static final int COLOUR_AUTO = 2;
    public int activeMapType;
    private static final int ACTIVE_MAP_TYPE_BITSIZE = 8;
    public static final int ACTIVE_MAP_TYPE_DESTINATION = 0;
    public static final int ACTIVE_MAP_TYPE_POSITION_2D = 1;
    public static final int ACTIVE_MAP_TYPE_POSITION_3D = 2;
    public static final int ACTIVE_MAP_TYPE_OVERVIEW = 3;
    public static final int ACTIVE_MAP_TYPE_RANGE_MAP = 4;
    public int mainMapSetup;
    private static final int MAIN_MAP_SETUP_BITSIZE = 8;
    public static final int MAIN_MAP_SETUP_INIT_NO_MAP_IN_ASG = 0;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_ASG = 1;
    public static final int MAIN_MAP_SETUP_MAIN_MAP_IN_FSG = 2;
    public static final int MAIN_MAP_SETUP_NOT_SUPPORTED = 255;
    public final SupportedMapTypes supportedMapTypes = new SupportedMapTypes();

    public MapColorAndType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapColorAndType_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.colour = 0;
        this.activeMapType = 0;
        this.mainMapSetup = 0;
    }

    public void reset() {
        this.internalReset();
        this.supportedMapTypes.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MapColorAndType_Status mapColorAndType_Status = (MapColorAndType_Status)bAPEntity;
        return this.colour == mapColorAndType_Status.colour && this.activeMapType == mapColorAndType_Status.activeMapType && this.mainMapSetup == mapColorAndType_Status.mainMapSetup && this.supportedMapTypes.equalTo(mapColorAndType_Status.supportedMapTypes);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapColorAndType_Status:");
        stringBuffer.append("\n - Colour: ");
        switch (this.colour) {
            case 0: {
                stringBuffer.append("0x00 (day)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (night)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (auto)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - ActiveMapType: ");
        switch (this.activeMapType) {
            case 0: {
                stringBuffer.append("0x00 (destination)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (position 2D)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (position 3D)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (overview)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (range map)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - MainMapSetup: ");
        switch (this.mainMapSetup) {
            case 0: {
                stringBuffer.append("0x00 (init (no map in ASG))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (main map in ASG (primary map in ASG / instrument cluster))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (main map in FSG (secondary map in ASG / instrument cluster))");
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
        stringBuffer.append("\n - SupportedMapTypes - ");
        stringBuffer.append(this.supportedMapTypes.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        return n += this.supportedMapTypes.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.colour);
        bitStream.pushByte((byte)this.activeMapType);
        bitStream.pushByte((byte)this.mainMapSetup);
        this.supportedMapTypes.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.colour = bitStream.popFrontByte();
        this.activeMapType = bitStream.popFrontByte();
        this.mainMapSetup = bitStream.popFrontByte();
        this.supportedMapTypes.deserialize(bitStream);
    }

    public static int functionId() {
        return 43;
    }

    public int getFunctionId() {
        return MapColorAndType_Status.functionId();
    }

    public static final class SupportedMapTypes
    implements BAPEntity {
        private static final int RESERVED_BIT_6__7_BITSIZE = 2;
        public boolean rangeMapIsSupported;
        public boolean overviewMapIsSupported;
        public boolean position3DMapIsSupported;
        public boolean position2DMapIsSupported;
        public boolean destinationMapIsSupported;
        public boolean mainMapSetupIsSupported;
        private static final int SUPPORTED_MAP_TYPES_BITSIZE = 8;

        public SupportedMapTypes() {
            this.internalReset();
            this.customInitialization();
        }

        public SupportedMapTypes(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.rangeMapIsSupported = false;
            this.overviewMapIsSupported = false;
            this.position3DMapIsSupported = false;
            this.position2DMapIsSupported = false;
            this.destinationMapIsSupported = false;
            this.mainMapSetupIsSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            SupportedMapTypes supportedMapTypes = (SupportedMapTypes)bAPEntity;
            return this.rangeMapIsSupported == supportedMapTypes.rangeMapIsSupported && this.overviewMapIsSupported == supportedMapTypes.overviewMapIsSupported && this.position3DMapIsSupported == supportedMapTypes.position3DMapIsSupported && this.position2DMapIsSupported == supportedMapTypes.position2DMapIsSupported && this.destinationMapIsSupported == supportedMapTypes.destinationMapIsSupported && this.mainMapSetupIsSupported == supportedMapTypes.mainMapSetupIsSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SupportedMapTypes:");
            stringBuffer.append("\n - Bit 5: ");
            if (this.rangeMapIsSupported) {
                stringBuffer.append("true  (range map is supported");
            } else {
                stringBuffer.append("false  (range map is not supported");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.overviewMapIsSupported) {
                stringBuffer.append("true  (overview map is supported");
            } else {
                stringBuffer.append("false  (overview map is not supported");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.position3DMapIsSupported) {
                stringBuffer.append("true  (position 3D map is supported");
            } else {
                stringBuffer.append("false  (position 3D map is not supported");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.position2DMapIsSupported) {
                stringBuffer.append("true  (position 2D map is supported");
            } else {
                stringBuffer.append("false  (position 2D map is not supported");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.destinationMapIsSupported) {
                stringBuffer.append("true  (destination map is supported");
            } else {
                stringBuffer.append("false  (destination map is not supported");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.mainMapSetupIsSupported) {
                stringBuffer.append("true  (MainMapSetup is supported");
            } else {
                stringBuffer.append("false  (MainMapSetup is not supported");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(2);
            bitStream.pushBoolean(this.rangeMapIsSupported);
            bitStream.pushBoolean(this.overviewMapIsSupported);
            bitStream.pushBoolean(this.position3DMapIsSupported);
            bitStream.pushBoolean(this.position2DMapIsSupported);
            bitStream.pushBoolean(this.destinationMapIsSupported);
            bitStream.pushBoolean(this.mainMapSetupIsSupported);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(2);
            this.rangeMapIsSupported = bitStream.popFrontBoolean();
            this.overviewMapIsSupported = bitStream.popFrontBoolean();
            this.position3DMapIsSupported = bitStream.popFrontBoolean();
            this.position2DMapIsSupported = bitStream.popFrontBoolean();
            this.destinationMapIsSupported = bitStream.popFrontBoolean();
            this.mainMapSetupIsSupported = bitStream.popFrontBoolean();
        }
    }
}

