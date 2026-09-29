/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoInfo_Status$MessageTime;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoInfo_Status$TpCounters;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoInfo_Status
implements StatusProperty {
    public final TpMemoInfo_Status$TpCounters tpCounters = new TpMemoInfo_Status$TpCounters();
    public final TpMemoInfo_Status$MessageTime messageTime = new TpMemoInfo_Status$MessageTime();
    public final BAPString stationName = new BAPString(49);
    private static final int MAX_STATION_NAME_LENGTH;

    public TpMemoInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.tpCounters.reset();
        this.messageTime.reset();
        this.stationName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoInfo_Status tpMemoInfo_Status = (TpMemoInfo_Status)bAPEntity;
        return this.tpCounters.equalTo(tpMemoInfo_Status.tpCounters) && this.messageTime.equalTo(tpMemoInfo_Status.messageTime) && this.stationName.equalTo(tpMemoInfo_Status.stationName);
    }

    private void customInitialization() {
        this.stationName.setLimitingLengthByCharacters();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TpMemoInfo_Status:");
        stringBuffer.append("\n - TpCounters - ");
        stringBuffer.append(this.tpCounters.toString());
        stringBuffer.append("\n - MessageTime - ");
        stringBuffer.append(this.messageTime.toString());
        stringBuffer.append("\n - StationName - ");
        stringBuffer.append(this.stationName.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.tpCounters.bitSize();
        n += this.messageTime.bitSize();
        return n += this.stationName.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.tpCounters.serialize(bitStream);
        this.messageTime.serialize(bitStream);
        this.stationName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.tpCounters.deserialize(bitStream);
        this.messageTime.deserialize(bitStream);
        this.stationName.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return TpMemoInfo_Status.functionId();
    }
}

