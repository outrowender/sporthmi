/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_Data;
import de.vw.mib.bap.stream.BitStream;

public final class AllowedEmergencyNumbers_ChangedArray
implements BAPChangedArray {
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS = 255;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    public BAPArrayElement createArrayElement() {
        return new AllowedEmergencyNumbers_Data(this.getArrayHeader());
    }

    public AllowedEmergencyNumbers_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public AllowedEmergencyNumbers_ChangedArray(BitStream bitStream) {
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
        AllowedEmergencyNumbers_ChangedArray allowedEmergencyNumbers_ChangedArray = (AllowedEmergencyNumbers_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(allowedEmergencyNumbers_ChangedArray.arrayHeader) && this.data.equalTo(allowedEmergencyNumbers_ChangedArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AllowedEmergencyNumbers_ChangedArray");
        stringBuffer.append("\n - arrayHeader:").append(this.arrayHeader.toString());
        stringBuffer.append("\n - data:").append(this.data.toString());
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
                this.data.add(new AllowedEmergencyNumbers_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 29;
    }

    public int getFunctionId() {
        return AllowedEmergencyNumbers_ChangedArray.functionId();
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

