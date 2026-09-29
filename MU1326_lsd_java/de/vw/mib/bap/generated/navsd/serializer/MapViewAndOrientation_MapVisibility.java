/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_MapVisibility
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean supplementaryMapViewIsVisible;
    public boolean lvdsMapIsVisible;
    private static final int MAP_VIEW_AND_ORIENTATION_MAP_VISIBILITY_BITSIZE;

    public MapViewAndOrientation_MapVisibility() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_MapVisibility(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.supplementaryMapViewIsVisible = false;
        this.lvdsMapIsVisible = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_MapVisibility mapViewAndOrientation_MapVisibility = (MapViewAndOrientation_MapVisibility)bAPEntity;
        return this.supplementaryMapViewIsVisible == mapViewAndOrientation_MapVisibility.supplementaryMapViewIsVisible && this.lvdsMapIsVisible == mapViewAndOrientation_MapVisibility.lvdsMapIsVisible;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapViewAndOrientation_MapVisibility:");
        stringBuffer.append("\n - Bit 1: ");
        if (this.supplementaryMapViewIsVisible) {
            stringBuffer.append("true  (supplementary map view is visible");
        } else {
            stringBuffer.append("false  (supplementary map view is not visible");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.lvdsMapIsVisible) {
            stringBuffer.append("true  (LVDS map is visible");
        } else {
            stringBuffer.append("false  (LVDS map is not visible");
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
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.supplementaryMapViewIsVisible);
        bitStream.pushBoolean(this.lvdsMapIsVisible);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.supplementaryMapViewIsVisible = bitStream.popFrontBoolean();
        this.lvdsMapIsVisible = bitStream.popFrontBoolean();
    }
}

