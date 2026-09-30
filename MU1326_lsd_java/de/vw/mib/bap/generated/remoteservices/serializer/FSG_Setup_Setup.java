/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE = 8;

    public FSG_Setup_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Setup fSG_Setup_Setup = (FSG_Setup_Setup)bAPEntity;
        return this.equals(fSG_Setup_Setup);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Setup");
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

