/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedial_AutomaticRedialState
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE = 7;
    public boolean automaticRedialActive;
    private static final int AUTOMATIC_REDIAL_AUTOMATIC_REDIAL_STATE_BITSIZE = 8;

    public AutomaticRedial_AutomaticRedialState() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedial_AutomaticRedialState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.automaticRedialActive = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedial_AutomaticRedialState automaticRedial_AutomaticRedialState = (AutomaticRedial_AutomaticRedialState)bAPEntity;
        return this.automaticRedialActive == automaticRedial_AutomaticRedialState.automaticRedialActive;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AutomaticRedial_AutomaticRedialState:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.automaticRedialActive) {
            stringBuffer.append("true  (automatic redial active");
        } else {
            stringBuffer.append("false  (no automatic redial");
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.automaticRedialActive);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.automaticRedialActive = bitStream.popFrontBoolean();
    }
}

