/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE = 4;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE = 0;
    public static final int ASG_ID_INSTRUMENT_CLUSTER = 1;
    public static final int ASG_ID_HEAD_UP_DISPLAY = 2;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2 = 3;
    public int taid;
    private static final int TAID_BITSIZE = 4;
    public int elementType;
    private static final int ELEMENT_TYPE_BITSIZE = 8;
    public static final int ELEMENT_TYPE_ENSEMBLES = 0;
    public static final int ELEMENT_TYPE_PRIMARY_SERVICES_ONLY = 1;
    public static final int ELEMENT_TYPE_SECONDARY_AND_PRIMARY_SERVICES = 2;
    public static final int ELEMENT_TYPE_FLAT_LIST = 3;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_AND_SECONDARY_SERVICES = 4;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_SERVICES_ONLY = 5;
    public int parent_Id;
    private static final int PARENT_ID_BITSIZE = 16;
    public int totalNumListElements;
    private static final int TOTAL_NUM_LIST_ELEMENTS_BITSIZE = 16;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(65535);
    private static final int MAX_DATA_ELEMENTS = 65535;

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

    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    public BAPArrayData getArrayData() {
        return this.data;
    }

    public BAPArrayElement createArrayElement() {
        return new ReceptionList_Data(this.getArrayHeader());
    }

    public ReceptionList_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.elementType = 0;
        this.parent_Id = 0;
        this.totalNumListElements = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_StatusArray receptionList_StatusArray = (ReceptionList_StatusArray)bAPEntity;
        return this.asg_Id == receptionList_StatusArray.asg_Id && this.taid == receptionList_StatusArray.taid && this.elementType == receptionList_StatusArray.elementType && this.parent_Id == receptionList_StatusArray.parent_Id && this.totalNumListElements == receptionList_StatusArray.totalNumListElements && this.arrayHeader.equalTo(receptionList_StatusArray.arrayHeader) && this.data.equalTo(receptionList_StatusArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionList_StatusArray:");
        stringBuffer.append("\n - ASG_ID: ");
        switch (this.asg_Id) {
            case 0: {
                stringBuffer.append("0x0 (default ASG (any ASG, spontaenous FSG message))");
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
            case 3: {
                stringBuffer.append("0x3 (operating unit rear (DF4.2))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - ElementType: ");
        switch (this.elementType) {
            case 0: {
                stringBuffer.append("0x00 (ensembles)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (primary services only)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (secondary and primary services)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (flat list (ensembles, primary services and secondary services))");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (flat list (primary and secondary services))");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (flat list (primary services only))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Parent_ID - ");
        stringBuffer.append(this.parent_Id);
        stringBuffer.append("\n - TotalNumListElements - ");
        stringBuffer.append(this.totalNumListElements);
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        n += 16;
        n += 16;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.elementType);
        bitStream.pushShort((short)this.parent_Id);
        bitStream.pushShort((short)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.elementType = bitStream.popFrontByte();
        this.parent_Id = bitStream.popFrontShort();
        this.totalNumListElements = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new ReceptionList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 23;
    }

    public int getFunctionId() {
        return ReceptionList_StatusArray.functionId();
    }
}

