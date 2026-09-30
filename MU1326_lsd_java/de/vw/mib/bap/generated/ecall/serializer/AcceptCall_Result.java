/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class AcceptCall_Result
implements ResultMethod {
    public int acceptCall_Result;
    public static final int ACCEPT_CALL_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int ACCEPT_CALL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int ACCEPT_CALL_RESULT_NOT_SUCCESSFUL = 1;
    public static final int ACCEPT_CALL_RESULT_SUCCESSFUL = 0;

    public AcceptCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public AcceptCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.acceptCall_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        AcceptCall_Result acceptCall_Result = (AcceptCall_Result)bAPEntity;
        return this.acceptCall_Result == acceptCall_Result.acceptCall_Result;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.acceptCall_Result;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AcceptCall_Result");
        stringBuffer.append("\n - acceptCall_Result:").append(this.acceptCall_Result);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.acceptCall_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.acceptCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 19;
    }

    public int getFunctionId() {
        return AcceptCall_Result.functionId();
    }
}

