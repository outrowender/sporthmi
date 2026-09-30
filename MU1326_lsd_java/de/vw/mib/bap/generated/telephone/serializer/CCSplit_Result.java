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
    private static final int CC_SPLIT_RESULT_BITSIZE = 8;
    public static final int CC_SPLIT_RESULT_SUCCESSFUL = 0;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL = 1;
    public static final int CC_SPLIT_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int CC_SPLIT_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_ADDITIONAL_CALL_ALREADY_PRESENT = 6;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK = 7;
    public static final int CC_SPLIT_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE = 8;

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

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CCSplit_Result cCSplit_Result = (CCSplit_Result)bAPEntity;
        return this.ccsplit_Result == cCSplit_Result.ccsplit_Result;
    }

    private void customInitialization() {
    }

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

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.ccsplit_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.ccsplit_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 41;
    }

    public int getFunctionId() {
        return CCSplit_Result.functionId();
    }
}

