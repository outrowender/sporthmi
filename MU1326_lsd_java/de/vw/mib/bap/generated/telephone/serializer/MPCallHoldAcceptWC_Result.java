/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPCallHoldAcceptWC_Result
implements ResultMethod {
    public int mpchawc_Result;
    private static final int MPCHAWC_RESULT_BITSIZE;
    public static final int MPCHAWC_RESULT_SUCCESSFUL;
    public static final int MPCHAWC_RESULT_NOT_SUCCESSFUL;
    public static final int MPCHAWC_RESULT_ABORT_SUCCESSFUL;
    public static final int MPCHAWC_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.mpchawc_Result;
    }

    public MPCallHoldAcceptWC_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPCallHoldAcceptWC_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpchawc_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MPCallHoldAcceptWC_Result mPCallHoldAcceptWC_Result = (MPCallHoldAcceptWC_Result)bAPEntity;
        return this.mpchawc_Result == mPCallHoldAcceptWC_Result.mpchawc_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MPCallHoldAcceptWC_Result:");
        stringBuffer.append("\n - MPCHAWC_Result: ");
        switch (this.mpchawc_Result) {
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
        bitStream.pushByte((byte)this.mpchawc_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mpchawc_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 37;
    }

    @Override
    public int getFunctionId() {
        return MPCallHoldAcceptWC_Result.functionId();
    }
}

