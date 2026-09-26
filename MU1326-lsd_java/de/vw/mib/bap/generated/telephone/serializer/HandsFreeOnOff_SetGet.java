/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_HandsFreeOnOff;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class HandsFreeOnOff_SetGet
implements SetGetProperty {
    public final HandsFreeOnOff_HandsFreeOnOff handsFreeOnOff = new HandsFreeOnOff_HandsFreeOnOff();

    public HandsFreeOnOff_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public HandsFreeOnOff_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.handsFreeOnOff.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HandsFreeOnOff_SetGet handsFreeOnOff_SetGet = (HandsFreeOnOff_SetGet)bAPEntity;
        return this.handsFreeOnOff.equalTo(handsFreeOnOff_SetGet.handsFreeOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HandsFreeOnOff_SetGet:");
        stringBuffer.append("\n - HandsFreeOnOff - ");
        stringBuffer.append(this.handsFreeOnOff.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.handsFreeOnOff.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.handsFreeOnOff.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.handsFreeOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return HandsFreeOnOff_SetGet.functionId();
    }
}

