/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$SupportedMapViews
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean trafficMapIsSupported;
    public boolean googleEarthMapIsSupported;
    public boolean standardMapIsSupported;
    private static final int SUPPORTED_MAP_VIEWS_BITSIZE;

    public MapViewAndOrientation_Status$SupportedMapViews() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$SupportedMapViews(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.trafficMapIsSupported = false;
        this.googleEarthMapIsSupported = false;
        this.standardMapIsSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$SupportedMapViews mapViewAndOrientation_Status$SupportedMapViews = (MapViewAndOrientation_Status$SupportedMapViews)bAPEntity;
        return this.trafficMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.trafficMapIsSupported && this.googleEarthMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.googleEarthMapIsSupported && this.standardMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.standardMapIsSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedMapViews:");
        stringBuffer.append("\n - Bit 2: ");
        if (this.trafficMapIsSupported) {
            stringBuffer.append("true  (traffic map is supported");
        } else {
            stringBuffer.append("false  (traffic map is not supported");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.googleEarthMapIsSupported) {
            stringBuffer.append("true  (GoogleEarth map is supported");
        } else {
            stringBuffer.append("false  (GoogleEarth map is not supported");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.standardMapIsSupported) {
            stringBuffer.append("true  (standard map is supported");
        } else {
            stringBuffer.append("false  (standard map is not supported");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.trafficMapIsSupported);
        bitStream.pushBoolean(this.googleEarthMapIsSupported);
        bitStream.pushBoolean(this.standardMapIsSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.trafficMapIsSupported = bitStream.popFrontBoolean();
        this.googleEarthMapIsSupported = bitStream.popFrontBoolean();
        this.standardMapIsSupported = bitStream.popFrontBoolean();
    }
}

