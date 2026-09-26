/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_Data;
import de.vw.mib.bap.stream.BitStream;

public final class DisasterWarning_ChangedArray
implements BAPChangedArray {
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new DisasterWarning_Data(this.getArrayHeader());
    }

    public DisasterWarning_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public DisasterWarning_ChangedArray(BitStream bitStream) {
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
        DisasterWarning_ChangedArray disasterWarning_ChangedArray = (DisasterWarning_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(disasterWarning_ChangedArray.arrayHeader) && this.data.equalTo(disasterWarning_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DisasterWarning_ChangedArray");
        stringBuffer.append("\n - arrayHeader:").append(this.arrayHeader.toString());
        stringBuffer.append("\n - data:").append(this.data.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.arrayHeader.deserialize(bitStream);
        this.arrayHeader.evaluateRecordAddressPosForChangedArray();
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new DisasterWarning_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return DisasterWarning_ChangedArray.functionId();
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
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }
}

