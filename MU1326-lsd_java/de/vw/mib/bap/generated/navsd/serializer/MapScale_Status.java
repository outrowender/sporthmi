/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_AutoZoomState;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_Status$SupportedAutoZoom;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_Status
implements StatusProperty {
    public int reserve1;
    private static final int RESERVE1_BITSIZE;
    public int autoZoom;
    private static final int AUTO_ZOOM_BITSIZE;
    public static final int AUTO_ZOOM_AUTO_ZOOM_OFF;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION;
    public static final int AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED;
    public final MapScale_AutoZoomState autoZoomState = new MapScale_AutoZoomState();
    public int scale;
    private static final int SCALE_BITSIZE;
    public int unit;
    private static final int UNIT_BITSIZE;
    public static final int UNIT_METER;
    public static final int UNIT_KILOMETER;
    public static final int UNIT_YARD;
    public static final int UNIT_FEET;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE;
    public static final int UNIT_QUARTER_MILES_N_1_4MILE;
    public static final int UNIT_KILOMETER_STEP_0_1;
    public static final int UNIT_MILE_UK_AND_US_STATUTE_MILE_STEP_0_1;
    public static final int UNIT_NOT_SUPPORTED_NO_INFORMATION_AVAILABLE;
    public final MapScale_Status$SupportedAutoZoom supportedAutoZoom = new MapScale_Status$SupportedAutoZoom();

    public MapScale_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.autoZoom = 0;
        this.scale = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.autoZoomState.reset();
        this.supportedAutoZoom.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_Status mapScale_Status = (MapScale_Status)bAPEntity;
        return this.reserve1 == mapScale_Status.reserve1 && this.autoZoom == mapScale_Status.autoZoom && this.autoZoomState.equalTo(mapScale_Status.autoZoomState) && this.scale == mapScale_Status.scale && this.unit == mapScale_Status.unit && this.supportedAutoZoom.equalTo(mapScale_Status.supportedAutoZoom);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapScale_Status:");
        stringBuffer.append("\n - Reserve1 - ");
        stringBuffer.append(this.reserve1);
        stringBuffer.append("\n - AutoZoom: ");
        switch (this.autoZoom) {
            case 0: {
                stringBuffer.append("0x0 (AutoZoom OFF)");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (AutoZoom ON)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (AutoZoom ON for Intersection)");
                break;
            }
            case 15: {
                stringBuffer.append("0xF (AutoZoom setting not supported)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - AutoZoomState - ");
        stringBuffer.append(this.autoZoomState.toString());
        stringBuffer.append("\n - Scale - ");
        stringBuffer.append(this.scale);
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
            case 6: {
                stringBuffer.append("0x06 (kilometer (step 0.1))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (mile (UK and US (statute mile), (step 0.1)))");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (not supported / no information available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - SupportedAutoZoom - ");
        stringBuffer.append(this.supportedAutoZoom.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 4;
        n += this.autoZoomState.bitSize();
        n += 16;
        n += 8;
        return n += this.supportedAutoZoom.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.reserve1);
        bitStream.pushBits(4, this.autoZoom);
        this.autoZoomState.serialize(bitStream);
        bitStream.pushShort((short)this.scale);
        bitStream.pushByte((byte)this.unit);
        this.supportedAutoZoom.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserve1 = bitStream.popFrontByte();
        this.autoZoom = bitStream.popFrontBits(4);
        this.autoZoomState.deserialize(bitStream);
        this.scale = bitStream.popFrontShort();
        this.unit = bitStream.popFrontByte();
        this.supportedAutoZoom.deserialize(bitStream);
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MapScale_Status.functionId();
    }
}

