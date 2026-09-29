/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$Reserve
implements BAPEntity {
    private static final int RESERVED_BIT_0__3_BITSIZE;
    private static final int RESERVE_BITSIZE;

    public Phonebook_Data$Reserve() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$Reserve(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return true;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Reserve:");
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
    }
}

