/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ResumeCall_Result
implements ResultMethod {
    public int resumeCall_Result;
    private static final int RESUME_CALL_RESULT_BITSIZE = 8;
    public static final int RESUME_CALL_RESULT_SUCCESSFUL = 0;
    public static final int RESUME_CALL_RESULT_NOT_SUCCESSFUL = 1;
    public static final int RESUME_CALL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int RESUME_CALL_RESULT_ABORT_NOT_SUCCESSFUL = 3;

    public int getResultCode() {
        return this.resumeCall_Result;
    }

    public ResumeCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ResumeCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.resumeCall_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ResumeCall_Result resumeCall_Result = (ResumeCall_Result)bAPEntity;
        return this.resumeCall_Result == resumeCall_Result.resumeCall_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ResumeCall_Result:");
        stringBuffer.append("\n - ResumeCall_Result: ");
        switch (this.resumeCall_Result) {
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
        bitStream.pushByte((byte)this.resumeCall_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.resumeCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 32;
    }

    public int getFunctionId() {
        return ResumeCall_Result.functionId();
    }
}

