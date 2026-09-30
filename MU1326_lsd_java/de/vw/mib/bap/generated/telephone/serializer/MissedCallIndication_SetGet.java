/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MissedCallIndication_SetGet
implements SetGetProperty {
    public int missedCalls;
    private static final int MISSED_CALLS_BITSIZE = 16;
    public int missedNumbers;
    private static final int MISSED_NUMBERS_BITSIZE = 16;

    public MissedCallIndication_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MissedCallIndication_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.missedCalls = 0;
        this.missedNumbers = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MissedCallIndication_SetGet missedCallIndication_SetGet = (MissedCallIndication_SetGet)bAPEntity;
        return this.missedCalls == missedCallIndication_SetGet.missedCalls && this.missedNumbers == missedCallIndication_SetGet.missedNumbers;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MissedCallIndication_SetGet:");
        stringBuffer.append("\n - MissedCalls - ");
        stringBuffer.append(this.missedCalls);
        stringBuffer.append("\n - MissedNumbers - ");
        stringBuffer.append(this.missedNumbers);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 16;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.missedCalls);
        bitStream.pushShort((short)this.missedNumbers);
    }

    public void deserialize(BitStream bitStream) {
        this.missedCalls = bitStream.popFrontShort();
        this.missedNumbers = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 45;
    }

    public int getFunctionId() {
        return MissedCallIndication_SetGet.functionId();
    }
}

