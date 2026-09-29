/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$SupportedSupplementaryMapViews
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean _1BoxSupported;
    public boolean compassSupported;
    public boolean intersectionZoomSupported;
    private static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEWS_BITSIZE;

    public MapViewAndOrientation_Status$SupportedSupplementaryMapViews() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$SupportedSupplementaryMapViews(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this._1BoxSupported = false;
        this.compassSupported = false;
        this.intersectionZoomSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$SupportedSupplementaryMapViews mapViewAndOrientation_Status$SupportedSupplementaryMapViews = (MapViewAndOrientation_Status$SupportedSupplementaryMapViews)bAPEntity;
        return this._1BoxSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews._1BoxSupported && this.compassSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews.compassSupported && this.intersectionZoomSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews.intersectionZoomSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SupportedSupplementaryMapViews:");
        stringBuffer.append("\n - Bit 2: ");
        if (this._1BoxSupported) {
            stringBuffer.append("true  (3+1 Box supported");
        } else {
            stringBuffer.append("false  (3+1 Box not supported");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.compassSupported) {
            stringBuffer.append("true  (compass supported");
        } else {
            stringBuffer.append("false  (compass not supported");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.intersectionZoomSupported) {
            stringBuffer.append("true  (Intersection zoom supported");
        } else {
            stringBuffer.append("false  (Intersection zoom not supported");
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
        bitStream.pushBoolean(this._1BoxSupported);
        bitStream.pushBoolean(this.compassSupported);
        bitStream.pushBoolean(this.intersectionZoomSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this._1BoxSupported = bitStream.popFrontBoolean();
        this.compassSupported = bitStream.popFrontBoolean();
        this.intersectionZoomSupported = bitStream.popFrontBoolean();
    }
}

