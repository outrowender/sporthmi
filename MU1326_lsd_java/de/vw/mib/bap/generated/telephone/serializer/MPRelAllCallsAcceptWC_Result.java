/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPRelAllCallsAcceptWC_Result
implements ResultMethod {
    public int mpracawc_Result;
    private static final int MPRACAWC_RESULT_BITSIZE;
    public static final int MPRACAWC_RESULT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_NOT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_ABORT_SUCCESSFUL;
    public static final int MPRACAWC_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.mpracawc_Result;
    }

    public MPRelAllCallsAcceptWC_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPRelAllCallsAcceptWC_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpracawc_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MPRelAllCallsAcceptWC_Result mPRelAllCallsAcceptWC_Result = (MPRelAllCallsAcceptWC_Result)bAPEntity;
        return this.mpracawc_Result == mPRelAllCallsAcceptWC_Result.mpracawc_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MPRelAllCallsAcceptWC_Result:");
        stringBuffer.append("\n - MPRACAWC_Result: ");
        switch (this.mpracawc_Result) {
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
        bitStream.pushByte((byte)this.mpracawc_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mpracawc_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return MPRelAllCallsAcceptWC_Result.functionId();
    }
}

