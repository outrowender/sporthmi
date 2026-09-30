/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_Precondition0
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE = 7;
    public boolean standstillRequired;

    public OnlineUpdateState_Deprecated_Precondition0() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_Precondition0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.standstillRequired = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_Precondition0 onlineUpdateState_Deprecated_Precondition0 = (OnlineUpdateState_Deprecated_Precondition0)bAPEntity;
        return this.standstillRequired == onlineUpdateState_Deprecated_Precondition0.standstillRequired;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateState_Deprecated_Precondition0");
        stringBuffer.append("\n - standstillRequired:" + this.standstillRequired);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.standstillRequired);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.standstillRequired = bitStream.popFrontBoolean();
    }
}

