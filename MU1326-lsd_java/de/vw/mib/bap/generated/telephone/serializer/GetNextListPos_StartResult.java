/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_StartResult
implements StartResultMethod {
    public int currentPos;
    private static final int CURRENT_POS_BITSIZE;
    public int offset;
    private static final int OFFSET_BITSIZE;
    public int listType;
    private static final int LIST_TYPE_BITSIZE;
    public static final int LIST_TYPE_PHONE_BOOK;
    public static final int LIST_TYPE_COMBINED_NUMBERS_DF4_3;
    public static final int LIST_TYPE_FAVORITE_LIST_DF4_3;

    public GetNextListPos_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public GetNextListPos_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.currentPos = 0;
        this.offset = 0;
        this.listType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GetNextListPos_StartResult getNextListPos_StartResult = (GetNextListPos_StartResult)bAPEntity;
        return this.currentPos == getNextListPos_StartResult.currentPos && this.offset == getNextListPos_StartResult.offset && this.listType == getNextListPos_StartResult.listType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("GetNextListPos_StartResult:");
        stringBuffer.append("\n - currentPos - ");
        stringBuffer.append(this.currentPos);
        stringBuffer.append("\n - Offset - ");
        stringBuffer.append(this.offset);
        stringBuffer.append("\n - ListType: ");
        switch (this.listType) {
            case 0: {
                stringBuffer.append("0x00 (phone book)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (combined numbers (DF4.3))");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (favorite list (DF4.3))");
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
        n += 16;
        n += 16;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.currentPos);
        bitStream.pushShort((short)this.offset);
        bitStream.pushByte((byte)this.listType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.currentPos = bitStream.popFrontShort();
        this.offset = bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 54;
    }

    @Override
    public int getFunctionId() {
        return GetNextListPos_StartResult.functionId();
    }
}

