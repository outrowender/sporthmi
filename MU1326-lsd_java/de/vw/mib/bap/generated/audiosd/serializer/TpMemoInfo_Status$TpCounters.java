/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_Status$TpCounters
implements BAPEntity {
    public int currentMsgNumber;
    private static final int CURRENT_MSG_NUMBER_BITSIZE;
    public int totalMsgNumber;
    private static final int TOTAL_MSG_NUMBER_BITSIZE;

    public TpMemoInfo_Status$TpCounters() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_Status$TpCounters(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentMsgNumber = 0;
        this.totalMsgNumber = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_Status$TpCounters tpMemoInfo_Status$TpCounters = (TpMemoInfo_Status$TpCounters)bAPEntity;
        return this.currentMsgNumber == tpMemoInfo_Status$TpCounters.currentMsgNumber && this.totalMsgNumber == tpMemoInfo_Status$TpCounters.totalMsgNumber;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TpCounters:");
        stringBuffer.append("\n - CurrentMsgNumber - ");
        stringBuffer.append(this.currentMsgNumber);
        stringBuffer.append("\n - TotalMsgNumber - ");
        stringBuffer.append(this.totalMsgNumber);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.currentMsgNumber);
        bitStream.pushByte((byte)this.totalMsgNumber);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentMsgNumber = bitStream.popFrontByte();
        this.totalMsgNumber = bitStream.popFrontByte();
    }
}

