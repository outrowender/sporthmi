/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_GetArray
implements BAPGetArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public int taid;
    private static final int TAID_BITSIZE;
    public int elementType;
    private static final int ELEMENT_TYPE_BITSIZE;
    public static final int ELEMENT_TYPE_ENSEMBLES;
    public static final int ELEMENT_TYPE_PRIMARY_SERVICES_ONLY;
    public static final int ELEMENT_TYPE_SECONDARY_AND_PRIMARY_SERVICES;
    public static final int ELEMENT_TYPE_FLAT_LIST;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_AND_SECONDARY_SERVICES;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_SERVICES_ONLY;
    public int parent_Id;
    private static final int PARENT_ID_BITSIZE;
    private ArrayHeader arrayHeader = new ArrayHeader();

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

    public ReceptionList_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.elementType = 0;
        this.parent_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_GetArray receptionList_GetArray = (ReceptionList_GetArray)bAPEntity;
        return this.asg_Id == receptionList_GetArray.asg_Id && this.taid == receptionList_GetArray.taid && this.elementType == receptionList_GetArray.elementType && this.parent_Id == receptionList_GetArray.parent_Id && this.arrayHeader.equalTo(receptionList_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionList_GetArray:");
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
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 4;
        n += 4;
        n += 8;
        n += 16;
        return n += this.arrayHeader.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.elementType);
        bitStream.pushShort((short)this.parent_Id);
        this.arrayHeader.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.elementType = bitStream.popFrontByte();
        this.parent_Id = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return ReceptionList_GetArray.functionId();
    }
}

