/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MPSwap_Result
implements ResultMethod {
    public int mpswap_Result;
    private static final int MP_SWAP_RESULT_BITSIZE;
    public static final int MP_SWAP_RESULT_SUCCESSFUL;
    public static final int MP_SWAP_RESULT_NOT_SUCCESSFUL;
    public static final int MP_SWAP_RESULT_ABORT_SUCCESSFUL;
    public static final int MP_SWAP_RESULT_ABORT_NOT_SUCCESSFULL;

    @Override
    public int getResultCode() {
        return this.mpswap_Result;
    }

    public MPSwap_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MPSwap_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mpswap_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MPSwap_Result mPSwap_Result = (MPSwap_Result)bAPEntity;
        return this.mpswap_Result == mPSwap_Result.mpswap_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MPSwap_Result:");
        stringBuffer.append("\n - MPSwap_Result: ");
        switch (this.mpswap_Result) {
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
                stringBuffer.append("0x03 (abort not successfull)");
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
        bitStream.pushByte((byte)this.mpswap_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mpswap_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 36;
    }

    @Override
    public int getFunctionId() {
        return MPSwap_Result.functionId();
    }
}

