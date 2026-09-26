/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_AutoZoomState;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_SetGet
implements SetGetProperty {
    public int steps;
    private static final int STEPS_BITSIZE;
    public int autoZoom;
    private static final int AUTO_ZOOM_BITSIZE;
    public static final int AUTO_ZOOM_AUTO_ZOOM_OFF;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON;
    public static final int AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION;
    public static final int AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED;
    public final MapScale_AutoZoomState autoZoomState = new MapScale_AutoZoomState();
    public int reserve2;
    private static final int RESERVE2_BITSIZE;
    public int reserve3;
    private static final int RESERVE3_BITSIZE;
    public int reserve4;
    private static final int RESERVE4_BITSIZE;

    public MapScale_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.steps = 0;
        this.autoZoom = 0;
        this.reserve2 = 0;
        this.reserve3 = 0;
        this.reserve4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.autoZoomState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_SetGet mapScale_SetGet = (MapScale_SetGet)bAPEntity;
        return this.steps == mapScale_SetGet.steps && this.autoZoom == mapScale_SetGet.autoZoom && this.autoZoomState.equalTo(mapScale_SetGet.autoZoomState) && this.reserve2 == mapScale_SetGet.reserve2 && this.reserve3 == mapScale_SetGet.reserve3 && this.reserve4 == mapScale_SetGet.reserve4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapScale_SetGet:");
        stringBuffer.append("\n - Steps - ");
        stringBuffer.append(this.steps);
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
        stringBuffer.append("\n - Reserve2 - ");
        stringBuffer.append(this.reserve2);
        stringBuffer.append("\n - Reserve3 - ");
        stringBuffer.append(this.reserve3);
        stringBuffer.append("\n - Reserve4 - ");
        stringBuffer.append(this.reserve4);
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
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.steps);
        bitStream.pushBits(4, this.autoZoom);
        this.autoZoomState.serialize(bitStream);
        bitStream.pushShort((short)this.reserve2);
        bitStream.pushByte((byte)this.reserve3);
        bitStream.pushByte((byte)this.reserve4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.steps = (byte)bitStream.popFrontByte();
        this.autoZoom = bitStream.popFrontBits(4);
        this.autoZoomState.deserialize(bitStream);
        this.reserve2 = bitStream.popFrontShort();
        this.reserve3 = bitStream.popFrontByte();
        this.reserve4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MapScale_SetGet.functionId();
    }
}

