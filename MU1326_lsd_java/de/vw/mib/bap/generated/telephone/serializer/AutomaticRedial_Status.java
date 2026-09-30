/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_AutomaticRedialState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedial_Status
implements StatusProperty {
    public final AutomaticRedial_AutomaticRedialState automaticRedialState = new AutomaticRedial_AutomaticRedialState();

    public AutomaticRedial_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedial_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.automaticRedialState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedial_Status automaticRedial_Status = (AutomaticRedial_Status)bAPEntity;
        return this.automaticRedialState.equalTo(automaticRedial_Status.automaticRedialState);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AutomaticRedial_Status:");
        stringBuffer.append("\n - AutomaticRedialState - ");
        stringBuffer.append(this.automaticRedialState.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.automaticRedialState.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.automaticRedialState.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.automaticRedialState.deserialize(bitStream);
    }

    public static int functionId() {
        return 57;
    }

    public int getFunctionId() {
        return AutomaticRedial_Status.functionId();
    }
}

