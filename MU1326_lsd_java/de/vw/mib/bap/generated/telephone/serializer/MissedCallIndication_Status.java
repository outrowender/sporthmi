/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MissedCallIndication_Status
implements StatusProperty {
    public int missedCalls;
    private static final int MISSED_CALLS_BITSIZE;
    public int missedNumbers;
    private static final int MISSED_NUMBERS_BITSIZE;

    public MissedCallIndication_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MissedCallIndication_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.missedCalls = 0;
        this.missedNumbers = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MissedCallIndication_Status missedCallIndication_Status = (MissedCallIndication_Status)bAPEntity;
        return this.missedCalls == missedCallIndication_Status.missedCalls && this.missedNumbers == missedCallIndication_Status.missedNumbers;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MissedCallIndication_Status:");
        stringBuffer.append("\n - MissedCalls - ");
        stringBuffer.append(this.missedCalls);
        stringBuffer.append("\n - MissedNumbers - ");
        stringBuffer.append(this.missedNumbers);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 16;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.missedCalls);
        bitStream.pushShort((short)this.missedNumbers);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.missedCalls = bitStream.popFrontShort();
        this.missedNumbers = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 45;
    }

    @Override
    public int getFunctionId() {
        return MissedCallIndication_Status.functionId();
    }
}

