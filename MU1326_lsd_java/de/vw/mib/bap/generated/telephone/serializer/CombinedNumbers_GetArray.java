/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CombinedNumbers_GetArray
implements BAPGetArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE = 4;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE = 0;
    public static final int ASG_ID_INSTRUMENT_CLUSTER = 1;
    public static final int ASG_ID_HEAD_UP_DISPLAY = 2;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS = 9;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_ASGS = 10;
    public int taid;
    private static final int TAID_BITSIZE = 4;
    private ArrayHeader arrayHeader = new ArrayHeader();

    public int getAsgId() {
        return this.asg_Id & 7;
    }

    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    public int getTransactionId() {
        return this.taid;
    }

    public void setTransactionId(int n) {
        this.taid = n;
    }

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public CombinedNumbers_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public CombinedNumbers_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CombinedNumbers_GetArray combinedNumbers_GetArray = (CombinedNumbers_GetArray)bAPEntity;
        return this.asg_Id == combinedNumbers_GetArray.asg_Id && this.taid == combinedNumbers_GetArray.taid && this.arrayHeader.equalTo(combinedNumbers_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CombinedNumbers_GetArray:");
        stringBuffer.append("\n - ASG_ID: ");
        switch (this.asg_Id) {
            case 0: {
                stringBuffer.append("0x0 (default ASG (any ASG, spontaneous FSG message))");
                break;
            }
            case 1: {
                stringBuffer.append("0x1 (instrument cluster)");
                break;
            }
            case 2: {
                stringBuffer.append("0x2 (head-up display)");
                break;
            }
            case 9: {
                stringBuffer.append("0x9 (instrument cluster, to be evaluated by all ASGs)");
                break;
            }
            case 10: {
                stringBuffer.append("0xA (head-up display, to be evaluated by all ASGs)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        return n += this.arrayHeader.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        this.arrayHeader.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 49;
    }

    public int getFunctionId() {
        return CombinedNumbers_GetArray.functionId();
    }
}

