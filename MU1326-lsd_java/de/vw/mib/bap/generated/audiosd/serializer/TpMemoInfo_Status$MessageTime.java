/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_Status$MessageTime
implements BAPEntity {
    public int hour;
    private static final int HOUR_BITSIZE;
    public int minute;
    private static final int MINUTE_BITSIZE;

    public TpMemoInfo_Status$MessageTime() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_Status$MessageTime(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.hour = 0;
        this.minute = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_Status$MessageTime tpMemoInfo_Status$MessageTime = (TpMemoInfo_Status$MessageTime)bAPEntity;
        return this.hour == tpMemoInfo_Status$MessageTime.hour && this.minute == tpMemoInfo_Status$MessageTime.minute;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MessageTime:");
        stringBuffer.append("\n - Hour - ");
        stringBuffer.append(this.hour);
        stringBuffer.append("\n - Minute - ");
        stringBuffer.append(this.minute);
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
        bitStream.pushByte((byte)this.hour);
        bitStream.pushByte((byte)this.minute);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.hour = bitStream.popFrontByte();
        this.minute = bitStream.popFrontByte();
    }
}

