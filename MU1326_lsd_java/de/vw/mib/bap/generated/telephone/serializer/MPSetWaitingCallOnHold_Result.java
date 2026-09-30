/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPSetWaitingCallOnHold_Result
implements ResultMethod {
    public int mpswcoh_Result;
    private static final int MPSWCOH_RESULT_BITSIZE = 8;
    public static final int MPSWCOH_RESULT_SUCCESSFUL = 0;
    public static final int MPSWCOH_RESULT_NOT_SUCCESSFUL = 1;
    public static final int MPSWCOH_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int MPSWCOH_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int MPSWCOH_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK = 4;

    public int getResultCode() {
        return this.mpswcoh_Result;
    }

    public MPSetWaitingCallOnHold_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPSetWaitingCallOnHold_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpswcoh_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = (MPSetWaitingCallOnHold_Result)bAPEntity;
        return this.mpswcoh_Result == mPSetWaitingCallOnHold_Result.mpswcoh_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MPSetWaitingCallOnHold_Result:");
        stringBuffer.append("\n - MPSWCOH_Result: ");
        switch (this.mpswcoh_Result) {
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
            case 4: {
                stringBuffer.append("0x04 (not successful - not supported by network)");
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
        bitStream.pushByte((byte)this.mpswcoh_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.mpswcoh_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 39;
    }

    public int getFunctionId() {
        return MPSetWaitingCallOnHold_Result.functionId();
    }
}

