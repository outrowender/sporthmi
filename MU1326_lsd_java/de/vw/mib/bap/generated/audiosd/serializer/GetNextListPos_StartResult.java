/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class GetNextListPos_StartResult
implements StartResultMethod {
    public int currentPos;
    private static final int CURRENT_POS_BITSIZE = 16;
    public int offset;
    private static final int OFFSET_BITSIZE = 16;
    public int listType;
    private static final int LIST_TYPE_BITSIZE = 8;
    public static final int LIST_TYPE_RECEPTION_LIST = 0;
    public static final int LIST_TYPE_TP_MEMO_LIST = 1;
    public static final int LIST_TYPE_SOURCE_LIST = 2;
    public static final int LIST_TYPE_RADIO_TV_PRESET_LIST = 3;
    public static final int LIST_TYPE_MEDIA_BROWSER = 4;
    public static final int LIST_TYPE_COMMON_LIST_DF4_1 = 5;

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

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        GetNextListPos_StartResult getNextListPos_StartResult = (GetNextListPos_StartResult)bAPEntity;
        return this.currentPos == getNextListPos_StartResult.currentPos && this.offset == getNextListPos_StartResult.offset && this.listType == getNextListPos_StartResult.listType;
    }

    private void customInitialization() {
    }

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
                stringBuffer.append("0x00 (ReceptionList)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (TpMemoList)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (SourceList)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (RadioTV_PresetList)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (MediaBrowser)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (CommonList (DF4.1))");
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
        n += 16;
        n += 16;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.currentPos);
        bitStream.pushShort((short)this.offset);
        bitStream.pushByte((byte)this.listType);
    }

    public void deserialize(BitStream bitStream) {
        this.currentPos = bitStream.popFrontShort();
        this.offset = (short)bitStream.popFrontShort();
        this.listType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 44;
    }

    public int getFunctionId() {
        return GetNextListPos_StartResult.functionId();
    }
}

