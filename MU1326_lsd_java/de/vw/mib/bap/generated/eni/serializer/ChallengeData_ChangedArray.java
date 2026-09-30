/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.ChallengeData_Data;
import de.vw.mib.bap.stream.BitStream;

public final class ChallengeData_ChangedArray
implements BAPChangedArray {
    public int authorizationType;
    public static final int AUTHORIZATION_TYPE_SPIN_CHALLENGE = 1;
    public static final int AUTHORIZATION_TYPE_UNKNOWN_DEFAULT = 0;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS = 255;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    public BAPArrayElement createArrayElement() {
        return new ChallengeData_Data(this.getArrayHeader());
    }

    public ChallengeData_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ChallengeData_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.authorizationType = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ChallengeData_ChangedArray challengeData_ChangedArray = (ChallengeData_ChangedArray)bAPEntity;
        return this.authorizationType == challengeData_ChangedArray.authorizationType && this.arrayHeader.equalTo(challengeData_ChangedArray.arrayHeader) && this.data.equalTo(challengeData_ChangedArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChallengeData_ChangedArray");
        stringBuffer.append("\n - authorizationType:" + this.authorizationType);
        stringBuffer.append("\n - arrayHeader:" + this.arrayHeader.toString());
        stringBuffer.append("\n - data:" + this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.authorizationType);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.authorizationType = bitStream.popFrontByte();
        this.arrayHeader.deserialize(bitStream);
        this.arrayHeader.evaluateRecordAddressPosForChangedArray();
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new ChallengeData_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 30;
    }

    public int getFunctionId() {
        return ChallengeData_ChangedArray.functionId();
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

