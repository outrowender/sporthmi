/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_Result
implements ResultMethod {
    public int hangupCall_Result;
    public static final int HANGUP_CALL_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int HANGUP_CALL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int HANGUP_CALL_RESULT_NOT_SUCCESSFUL = 1;
    public static final int HANGUP_CALL_RESULT_SUCCESSFUL = 0;

    public HangupCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public HangupCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.hangupCall_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_Result hangupCall_Result = (HangupCall_Result)bAPEntity;
        return this.hangupCall_Result == hangupCall_Result.hangupCall_Result;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.hangupCall_Result;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HangupCall_Result");
        stringBuffer.append("\n - hangupCall_Result:").append(this.hangupCall_Result);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.hangupCall_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.hangupCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return HangupCall_Result.functionId();
    }
}

