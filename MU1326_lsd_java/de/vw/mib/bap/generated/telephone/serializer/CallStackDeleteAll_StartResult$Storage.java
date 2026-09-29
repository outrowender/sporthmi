/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallStackDeleteAll_StartResult$Storage
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean deleteDialedNumbers;
    public boolean deleteReceivedCalls;
    public boolean deleteMissedCalls;
    private static final int STORAGE_BITSIZE;

    public CallStackDeleteAll_StartResult$Storage() {
        this.internalReset();
        this.customInitialization();
    }

    public CallStackDeleteAll_StartResult$Storage(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.deleteDialedNumbers = false;
        this.deleteReceivedCalls = false;
        this.deleteMissedCalls = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallStackDeleteAll_StartResult$Storage callStackDeleteAll_StartResult$Storage = (CallStackDeleteAll_StartResult$Storage)bAPEntity;
        return this.deleteDialedNumbers == callStackDeleteAll_StartResult$Storage.deleteDialedNumbers && this.deleteReceivedCalls == callStackDeleteAll_StartResult$Storage.deleteReceivedCalls && this.deleteMissedCalls == callStackDeleteAll_StartResult$Storage.deleteMissedCalls;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Storage:");
        stringBuffer.append("\n - Bit 2: ");
        if (this.deleteDialedNumbers) {
            stringBuffer.append("true  (Delete dialed numbers");
        } else {
            stringBuffer.append("false  (Don't touch dialed numbers");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.deleteReceivedCalls) {
            stringBuffer.append("true  (Delete received calls");
        } else {
            stringBuffer.append("false  (Don't touch received calls");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.deleteMissedCalls) {
            stringBuffer.append("true  (Delete missed calls");
        } else {
            stringBuffer.append("false  (Don't touch missed calls");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.deleteDialedNumbers);
        bitStream.pushBoolean(this.deleteReceivedCalls);
        bitStream.pushBoolean(this.deleteMissedCalls);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.deleteDialedNumbers = bitStream.popFrontBoolean();
        this.deleteReceivedCalls = bitStream.popFrontBoolean();
        this.deleteMissedCalls = bitStream.popFrontBoolean();
    }
}

