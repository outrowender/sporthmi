/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone2.serializer.AutomaticCallForwarding_Status$DivertState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticCallForwarding_Status
implements StatusProperty {
    public final AutomaticCallForwarding_Status$DivertState divertState = new AutomaticCallForwarding_Status$DivertState();

    public AutomaticCallForwarding_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticCallForwarding_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.divertState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticCallForwarding_Status automaticCallForwarding_Status = (AutomaticCallForwarding_Status)bAPEntity;
        return this.divertState.equalTo(automaticCallForwarding_Status.divertState);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AutomaticCallForwarding_Status:");
        stringBuffer.append("\n - DivertState - ");
        stringBuffer.append(this.divertState.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.divertState.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.divertState.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.divertState.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return AutomaticCallForwarding_Status.functionId();
    }
}

