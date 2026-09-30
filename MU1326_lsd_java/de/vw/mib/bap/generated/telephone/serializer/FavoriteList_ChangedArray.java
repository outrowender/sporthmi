/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.FavoriteList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class FavoriteList_ChangedArray
implements BAPChangedArray {
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(60);
    private static final int MAX_DATA_ELEMENTS = 60;

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
        return new FavoriteList_Data(this.getArrayHeader());
    }

    public FavoriteList_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public FavoriteList_ChangedArray(BitStream bitStream) {
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
        FavoriteList_ChangedArray favoriteList_ChangedArray = (FavoriteList_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(favoriteList_ChangedArray.arrayHeader) && this.data.equalTo(favoriteList_ChangedArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FavoriteList_ChangedArray:");
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
                this.data.add(new FavoriteList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 60;
    }

    public int getFunctionId() {
        return FavoriteList_ChangedArray.functionId();
    }
}

