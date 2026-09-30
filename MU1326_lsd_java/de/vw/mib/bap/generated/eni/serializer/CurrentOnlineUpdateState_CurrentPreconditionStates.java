/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentOnlineUpdateState_CurrentPreconditionStates
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE = 7;
    public boolean standstill;

    public CurrentOnlineUpdateState_CurrentPreconditionStates() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentOnlineUpdateState_CurrentPreconditionStates(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.standstill = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentOnlineUpdateState_CurrentPreconditionStates currentOnlineUpdateState_CurrentPreconditionStates = (CurrentOnlineUpdateState_CurrentPreconditionStates)bAPEntity;
        return this.standstill == currentOnlineUpdateState_CurrentPreconditionStates.standstill;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentOnlineUpdateState_CurrentPreconditionStates");
        stringBuffer.append("\n - standstill:" + this.standstill);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.standstill);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.standstill = bitStream.popFrontBoolean();
    }
}

