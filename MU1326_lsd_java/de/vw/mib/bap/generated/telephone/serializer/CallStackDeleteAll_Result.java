/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CallStackDeleteAll_Result
implements ResultMethod {
    public int callStackDeleteAll_Result;
    private static final int CALL_STACK_DELETE_ALL_RESULT_BITSIZE;
    public static final int CALL_STACK_DELETE_ALL_RESULT_SUCCESSFUL;
    public static final int CALL_STACK_DELETE_ALL_RESULT_NOT_SUCCESSFUL;
    public static final int CALL_STACK_DELETE_ALL_RESULT_ABORT_SUCCESSFUL;
    public static final int CALL_STACK_DELETE_ALL_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.callStackDeleteAll_Result;
    }

    public CallStackDeleteAll_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CallStackDeleteAll_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callStackDeleteAll_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallStackDeleteAll_Result callStackDeleteAll_Result = (CallStackDeleteAll_Result)bAPEntity;
        return this.callStackDeleteAll_Result == callStackDeleteAll_Result.callStackDeleteAll_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallStackDeleteAll_Result:");
        stringBuffer.append("\n - CallStackDeleteAll_Result: ");
        switch (this.callStackDeleteAll_Result) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
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
        bitStream.pushByte((byte)this.callStackDeleteAll_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.callStackDeleteAll_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 50;
    }

    @Override
    public int getFunctionId() {
        return CallStackDeleteAll_Result.functionId();
    }
}

