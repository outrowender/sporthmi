/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.HandsFreeOnOff_HandsFreeOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class HandsFreeOnOff_Status
implements StatusProperty {
    public final HandsFreeOnOff_HandsFreeOnOff handsFreeOnOff = new HandsFreeOnOff_HandsFreeOnOff();

    public HandsFreeOnOff_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public HandsFreeOnOff_Status(BitStream bitStream) {
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
        HandsFreeOnOff_Status handsFreeOnOff_Status = (HandsFreeOnOff_Status)bAPEntity;
        return this.handsFreeOnOff.equalTo(handsFreeOnOff_Status.handsFreeOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HandsFreeOnOff_Status:");
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
        return HandsFreeOnOff_Status.functionId();
    }
}

