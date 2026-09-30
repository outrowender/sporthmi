/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Heartbeat_Status
implements StatusProperty {
    public int heartbeatTime;
    private static final int HEARTBEAT_TIME_BITSIZE = 8;

    public Heartbeat_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Heartbeat_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.heartbeatTime = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        Heartbeat_Status heartbeat_Status = (Heartbeat_Status)bAPEntity;
        return this.heartbeatTime == heartbeat_Status.heartbeatTime;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Heartbeat_Status:");
        stringBuffer.append("\n - HeartbeatTime - ");
        stringBuffer.append(this.heartbeatTime);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.heartbeatTime);
    }

    public void deserialize(BitStream bitStream) {
        this.heartbeatTime = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 4;
    }

    public int getFunctionId() {
        return Heartbeat_Status.functionId();
    }
}

