/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_Extension1
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE = 8;

    public ActiveMonitorings_Extension1() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_Extension1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_Extension1 activeMonitorings_Extension1 = (ActiveMonitorings_Extension1)bAPEntity;
        return this.equals(activeMonitorings_Extension1);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActiveMonitorings_Extension1");
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

