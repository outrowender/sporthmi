/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateList_UpdatePrecondition
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean standstillRequired;

    public OnlineUpdateList_UpdatePrecondition() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateList_UpdatePrecondition(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.standstillRequired = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateList_UpdatePrecondition onlineUpdateList_UpdatePrecondition = (OnlineUpdateList_UpdatePrecondition)bAPEntity;
        return this.standstillRequired == onlineUpdateList_UpdatePrecondition.standstillRequired;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateList_UpdatePrecondition");
        stringBuffer.append(new StringBuffer().append("\n - standstillRequired:").append(this.standstillRequired).toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.standstillRequired);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.standstillRequired = bitStream.popFrontBoolean();
    }
}

