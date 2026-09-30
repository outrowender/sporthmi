/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_Extension2
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE = 8;

    public ActiveMonitorings_Extension2() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_Extension2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_Extension2 activeMonitorings_Extension2 = (ActiveMonitorings_Extension2)bAPEntity;
        return this.equals(activeMonitorings_Extension2);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveMonitorings_Extension2");
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(8);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(8);
    }
}

