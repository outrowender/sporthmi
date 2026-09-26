/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_Data;
import de.vw.mib.bap.stream.BitStream;

public final class CombinedNumbers_SetGetArray
implements BAPSetGetArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_ASGS;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_ASGS;
    public int taid;
    private static final int TAID_BITSIZE;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(180);
    private static final int MAX_DATA_ELEMENTS;

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new CombinedNumbers_Data(this.getArrayHeader());
    }

    public CombinedNumbers_SetGetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public CombinedNumbers_SetGetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CombinedNumbers_SetGetArray combinedNumbers_SetGetArray = (CombinedNumbers_SetGetArray)bAPEntity;
        return this.asg_Id == combinedNumbers_SetGetArray.asg_Id && this.taid == combinedNumbers_SetGetArray.taid && this.arrayHeader.equalTo(combinedNumbers_SetGetArray.arrayHeader) && this.data.equalTo(combinedNumbers_SetGetArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CombinedNumbers_SetGetArray:");
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
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new CombinedNumbers_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 49;
    }

    @Override
    public int getFunctionId() {
        return CombinedNumbers_SetGetArray.functionId();
    }
}

