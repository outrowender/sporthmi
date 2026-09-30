/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class HeartBeat_Status
implements StatusProperty {
    public int heartBeatTime;
    public static final int HEART_BEAT_TIME_MIN = 0;

    public HeartBeat_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public HeartBeat_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.heartBeatTime = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        HeartBeat_Status heartBeat_Status = (HeartBeat_Status)bAPEntity;
        return this.heartBeatTime == heartBeat_Status.heartBeatTime;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HeartBeat_Status");
        stringBuffer.append("\n - heartBeatTime:" + this.heartBeatTime);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.heartBeatTime);
    }

    public void deserialize(BitStream bitStream) {
        this.heartBeatTime = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 4;
    }

    public int getFunctionId() {
        return HeartBeat_Status.functionId();
    }
}

