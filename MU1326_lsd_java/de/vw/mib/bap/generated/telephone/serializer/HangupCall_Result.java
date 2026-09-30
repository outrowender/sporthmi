/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_Result
implements ResultMethod {
    public int hangupCall_Result;
    private static final int HANGUP_CALL_RESULT_BITSIZE = 8;
    public static final int HANGUP_CALL_RESULT_SUCCESSFUL = 0;
    public static final int HANGUP_CALL_RESULT_NOT_SUCCESSFUL = 1;
    public static final int HANGUP_CALL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int HANGUP_CALL_RESULT_ABORT_NOT_SUCCESSFUL = 3;

    public int getResultCode() {
        return this.hangupCall_Result;
    }

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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HangupCall_Result:");
        stringBuffer.append("\n - HangupCall_Result: ");
        switch (this.hangupCall_Result) {
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

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.hangupCall_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.hangupCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    public int getFunctionId() {
        return HangupCall_Result.functionId();
    }
}

