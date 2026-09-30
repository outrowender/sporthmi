/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.OLBTripList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class OLBTripList_ChangedArray
implements BAPChangedArray {
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS = 255;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    public BAPArrayElement createArrayElement() {
        return new OLBTripList_Data(this.getArrayHeader());
    }

    public OLBTripList_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBTripList_ChangedArray(BitStream bitStream) {
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
        OLBTripList_ChangedArray oLBTripList_ChangedArray = (OLBTripList_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(oLBTripList_ChangedArray.arrayHeader) && this.data.equalTo(oLBTripList_ChangedArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OLBTripList_ChangedArray");
        stringBuffer.append("\n - arrayHeader:" + this.arrayHeader.toString());
        stringBuffer.append("\n - data:" + this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.arrayHeader.deserialize(bitStream);
        this.arrayHeader.evaluateRecordAddressPosForChangedArray();
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new OLBTripList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 35;
    }

    public int getFunctionId() {
        return OLBTripList_ChangedArray.functionId();
    }

    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    public BAPArrayData getArrayData() {
        return this.data;
    }

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }
}

