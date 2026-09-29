/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_ChangedArray
implements BAPChangedArray {
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(1500);
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
        return new Phonebook_Data(this.getArrayHeader());
    }

    public Phonebook_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_ChangedArray phonebook_ChangedArray = (Phonebook_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(phonebook_ChangedArray.arrayHeader) && this.data.equalTo(phonebook_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Phonebook_ChangedArray:");
        stringBuffer.append("\n - ArrayHeader - ");
        stringBuffer.append(this.arrayHeader.toString());
        stringBuffer.append("\n - Data:");
        stringBuffer.append(this.data.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.arrayHeader.bitSize();
        return n += this.data.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        this.arrayHeader.setRecordAddress(this.arrayHeader.getRecordAddress(), 15);
        if (this.arrayHeader.dataElementsExists()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new Phonebook_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 52;
    }

    @Override
    public int getFunctionId() {
        return Phonebook_ChangedArray.functionId();
    }
}

