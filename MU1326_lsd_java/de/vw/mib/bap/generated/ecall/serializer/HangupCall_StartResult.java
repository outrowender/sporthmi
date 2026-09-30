/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_StartResult
implements StartResultMethod {
    public int callId;
    public static final int CALL_ID_ALL_CALLS = 255;
    public static final int CALL_ID_ALL_ACTIVE_HELD_CALLS = 254;
    public static final int CALL_ID_ALL_HELD_CALLS = 253;
    public static final int CALL_ID_ALL_ACTIVE_CALLS = 252;
    public static final int CALL_ID_CALL6 = 6;
    public static final int CALL_ID_CALL5 = 5;
    public static final int CALL_ID_CALL4 = 4;
    public static final int CALL_ID_CALL3 = 3;
    public static final int CALL_ID_CALL2 = 2;
    public static final int CALL_ID_CALL1 = 1;
    public static final int CALL_ID_CALL0 = 0;

    public HangupCall_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public HangupCall_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callId = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_StartResult hangupCall_StartResult = (HangupCall_StartResult)bAPEntity;
        return this.callId == hangupCall_StartResult.callId;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HangupCall_StartResult");
        stringBuffer.append("\n - callId:").append(this.callId);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.callId);
    }

    public void deserialize(BitStream bitStream) {
        this.callId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return HangupCall_StartResult.functionId();
    }
}

