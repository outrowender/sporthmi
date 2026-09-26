/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_ChangedArray
implements BAPChangedArray {
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
    private BAPArrayData data = new BAPArrayData(-65536);
    private static final int MAX_DATA_ELEMENTS;

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
        return new ReceptionList_Data(this.getArrayHeader());
    }

    public ReceptionList_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.elementType = 0;
        this.parent_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_ChangedArray receptionList_ChangedArray = (ReceptionList_ChangedArray)bAPEntity;
        return this.elementType == receptionList_ChangedArray.elementType && this.parent_Id == receptionList_ChangedArray.parent_Id && this.arrayHeader.equalTo(receptionList_ChangedArray.arrayHeader) && this.data.equalTo(receptionList_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReceptionList_ChangedArray:");
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
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 16;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.elementType);
        bitStream.pushShort((short)this.parent_Id);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.elementType = bitStream.popFrontByte();
        this.parent_Id = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        this.arrayHeader.setRecordAddress(this.arrayHeader.getRecordAddress(), 15);
        if (this.arrayHeader.dataElementsExists()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new ReceptionList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return ReceptionList_ChangedArray.functionId();
    }
}

