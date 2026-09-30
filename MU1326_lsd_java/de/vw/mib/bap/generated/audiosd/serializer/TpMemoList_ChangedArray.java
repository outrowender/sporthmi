/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.audiosd.serializer.TpMemoList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class TpMemoList_ChangedArray
implements BAPChangedArray {
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(255);
    private static final int MAX_DATA_ELEMENTS = 255;

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
        return new TpMemoList_Data(this.getArrayHeader());
    }

    public TpMemoList_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public TpMemoList_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TpMemoList_ChangedArray tpMemoList_ChangedArray = (TpMemoList_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(tpMemoList_ChangedArray.arrayHeader) && this.data.equalTo(tpMemoList_ChangedArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TpMemoList_ChangedArray:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        this.arrayHeader.setRecordAddress(this.arrayHeader.getRecordAddress(), 15);
        if (this.arrayHeader.dataElementsExists()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new TpMemoList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 27;
    }

    public int getFunctionId() {
        return TpMemoList_ChangedArray.functionId();
    }
}

