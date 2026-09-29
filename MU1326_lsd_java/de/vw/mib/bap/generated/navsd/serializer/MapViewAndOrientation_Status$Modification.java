/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$Modification
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean googleMapCanNotBeModified;
    private static final int MODIFICATION_BITSIZE;

    public MapViewAndOrientation_Status$Modification() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$Modification(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.googleMapCanNotBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$Modification mapViewAndOrientation_Status$Modification = (MapViewAndOrientation_Status$Modification)bAPEntity;
        return this.googleMapCanNotBeModified == mapViewAndOrientation_Status$Modification.googleMapCanNotBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Modification:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.googleMapCanNotBeModified) {
            stringBuffer.append("true  (google map can not be modified");
        } else {
            stringBuffer.append("false  (google map can be modified");
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
        bitStream.pushBoolean(this.googleMapCanNotBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.googleMapCanNotBeModified = bitStream.popFrontBoolean();
    }
}

