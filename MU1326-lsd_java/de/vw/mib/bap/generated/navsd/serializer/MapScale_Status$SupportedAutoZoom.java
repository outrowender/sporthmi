/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_Status$SupportedAutoZoom
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean autozoomOnForIntersectionSupported;
    private static final int SUPPORTED_AUTO_ZOOM_BITSIZE;

    public MapScale_Status$SupportedAutoZoom() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_Status$SupportedAutoZoom(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.autozoomOnForIntersectionSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_Status$SupportedAutoZoom mapScale_Status$SupportedAutoZoom = (MapScale_Status$SupportedAutoZoom)bAPEntity;
        return this.autozoomOnForIntersectionSupported == mapScale_Status$SupportedAutoZoom.autozoomOnForIntersectionSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedAutoZoom:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.autozoomOnForIntersectionSupported) {
            stringBuffer.append("true  (autozoom on for intersection supported");
        } else {
            stringBuffer.append("false  (autozoom on for intersection not supported");
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.autozoomOnForIntersectionSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.autozoomOnForIntersectionSupported = bitStream.popFrontBoolean();
    }
}

