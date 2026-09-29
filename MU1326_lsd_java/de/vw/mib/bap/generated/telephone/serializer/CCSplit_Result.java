/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CCSplit_Result
implements ResultMethod {
    public int ccsplit_Result;
    private static final int CC_SPLIT_RESULT_BITSIZE;
    public static final int CC_SPLIT_RESULT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_ABORT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_ADDITIONAL_CALL_ALREADY_PRESENT;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE;

    @Override
    public int getResultCode() {
        return this.ccsplit_Result;
    }

    public CCSplit_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CCSplit_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccsplit_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CCSplit_Result cCSplit_Result = (CCSplit_Result)bAPEntity;
        return this.ccsplit_Result == cCSplit_Result.ccsplit_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CCSplit_Result:");
        stringBuffer.append("\n - CCSplit_Result: ");
        switch (this.ccsplit_Result) {
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
            case 6: {
                stringBuffer.append("0x06 (not successful - additional call already present)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (not successful - not supported by network)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (not successful - not supported by mobile)");
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
        bitStream.pushByte((byte)this.ccsplit_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.ccsplit_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    @Override
    public int getFunctionId() {
        return CCSplit_Result.functionId();
    }
}

