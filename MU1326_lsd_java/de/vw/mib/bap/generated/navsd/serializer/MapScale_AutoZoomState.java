/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_AutoZoomState
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean autoZoomActive;
    private static final int MAP_SCALE_AUTO_ZOOM_STATE_BITSIZE;

    public MapScale_AutoZoomState() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_AutoZoomState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.autoZoomActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_AutoZoomState mapScale_AutoZoomState = (MapScale_AutoZoomState)bAPEntity;
        return this.autoZoomActive == mapScale_AutoZoomState.autoZoomActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapScale_AutoZoomState:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.autoZoomActive) {
            stringBuffer.append("true  (auto zoom active");
        } else {
            stringBuffer.append("false  (auto zoom not active");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.autoZoomActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.autoZoomActive = bitStream.popFrontBoolean();
    }
}

