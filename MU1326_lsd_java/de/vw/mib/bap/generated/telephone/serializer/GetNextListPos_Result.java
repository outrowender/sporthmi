/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_Result
implements ResultMethod {
    public int getNextListPos_Result;
    private static final int GET_NEXT_LIST_POS_RESULT_BITSIZE;
    public static final int GET_NEXT_LIST_POS_RESULT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_NOT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_ABORT_SUCCESSFUL;
    public static final int GET_NEXT_LIST_POS_RESULT_ABORT_NOT_SUCCESSFUL;
    public int currentPos;
    private static final int CURRENT_POS_BITSIZE;
    public int nextPos;
    private static final int NEXT_POS_BITSIZE;
    public int absoluteListPos;
    private static final int ABSOLUTE_LIST_POS_BITSIZE;

    @Override
    public int getResultCode() {
        return this.getNextListPos_Result;
    }

    public GetNextListPos_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public GetNextListPos_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.getNextListPos_Result = 0;
        this.currentPos = 0;
        this.nextPos = 0;
        this.absoluteListPos = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GetNextListPos_Result getNextListPos_Result = (GetNextListPos_Result)bAPEntity;
        return this.getNextListPos_Result == getNextListPos_Result.getNextListPos_Result && this.currentPos == getNextListPos_Result.currentPos && this.nextPos == getNextListPos_Result.nextPos && this.absoluteListPos == getNextListPos_Result.absoluteListPos;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GetNextListPos_Result:");
        stringBuffer.append("\n - GetNextListPos_Result: ");
        switch (this.getNextListPos_Result) {
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
        stringBuffer.append("\n - currentPos - ");
        stringBuffer.append(this.currentPos);
        stringBuffer.append("\n - nextPos - ");
        stringBuffer.append(this.nextPos);
        stringBuffer.append("\n - absoluteListPos - ");
        stringBuffer.append(this.absoluteListPos);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        n += 16;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.getNextListPos_Result);
        bitStream.pushShort((short)this.currentPos);
        bitStream.pushShort((short)this.nextPos);
        bitStream.pushShort((short)this.absoluteListPos);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.getNextListPos_Result = bitStream.popFrontByte();
        this.currentPos = bitStream.popFrontShort();
        this.nextPos = bitStream.popFrontShort();
        this.absoluteListPos = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 54;
    }

    @Override
    public int getFunctionId() {
        return GetNextListPos_Result.functionId();
    }
}

