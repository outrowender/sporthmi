/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class CCJoin_Result
implements ResultMethod {
    public int ccjoin_Result;
    private static final int CC_JOIN_RESULT_BITSIZE = 8;
    public static final int CC_JOIN_RESULT_SUCCESSFUL = 0;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL = 1;
    public static final int CC_JOIN_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int CC_JOIN_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK = 6;
    public static final int CC_JOIN_RESULT_NOT_SUCCESSFUL_MAXIMUM_NUMBER_OF_MEMBERS_OF_CONFERENCE_REACHED = 7;

    public int getResultCode() {
        return this.ccjoin_Result;
    }

    public CCJoin_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public CCJoin_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccjoin_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CCJoin_Result cCJoin_Result = (CCJoin_Result)bAPEntity;
        return this.ccjoin_Result == cCJoin_Result.ccjoin_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CCJoin_Result:");
        stringBuffer.append("\n - CCJoin_Result: ");
        switch (this.ccjoin_Result) {
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
                stringBuffer.append("0x06 (not successful - not supported by network)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (not successful - maximum number of members of conference reached)");
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
        bitStream.pushByte((byte)this.ccjoin_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.ccjoin_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 40;
    }

    public int getFunctionId() {
        return CCJoin_Result.functionId();
    }
}

