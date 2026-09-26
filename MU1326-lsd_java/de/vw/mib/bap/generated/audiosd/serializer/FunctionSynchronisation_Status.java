/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status$FctList_1;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status$FctList_2;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status$FctList_3;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status
implements StatusProperty {
    public final FunctionSynchronisation_Status$FctList_1 fctList_1 = new FunctionSynchronisation_Status$FctList_1();
    public final FunctionSynchronisation_Status$FctList_2 fctList_2 = new FunctionSynchronisation_Status$FctList_2();
    public final FunctionSynchronisation_Status$FctList_3 fctList_3 = new FunctionSynchronisation_Status$FctList_3();

    public FunctionSynchronisation_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.fctList_1.reset();
        this.fctList_2.reset();
        this.fctList_3.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status functionSynchronisation_Status = (FunctionSynchronisation_Status)bAPEntity;
        return this.fctList_1.equalTo(functionSynchronisation_Status.fctList_1) && this.fctList_2.equalTo(functionSynchronisation_Status.fctList_2) && this.fctList_3.equalTo(functionSynchronisation_Status.fctList_3);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionSynchronisation_Status:");
        stringBuffer.append("\n - FctList_1 - ");
        stringBuffer.append(this.fctList_1.toString());
        stringBuffer.append("\n - FctList_2 - ");
        stringBuffer.append(this.fctList_2.toString());
        stringBuffer.append("\n - FctList_3 - ");
        stringBuffer.append(this.fctList_3.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.fctList_1.bitSize();
        n += this.fctList_2.bitSize();
        return n += this.fctList_3.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.fctList_1.serialize(bitStream);
        this.fctList_2.serialize(bitStream);
        this.fctList_3.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fctList_1.deserialize(bitStream);
        this.fctList_2.deserialize(bitStream);
        this.fctList_3.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return FunctionSynchronisation_Status.functionId();
    }
}

