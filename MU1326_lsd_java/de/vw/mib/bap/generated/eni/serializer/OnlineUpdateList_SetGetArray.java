/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateList_SetGetArray
implements BAPSetGetArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS = 9;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE = 0;
    private static final int ASG_ID_BITSIZE = 4;
    public int taid;
    public static final int TAID_MIN = 0;
    private static final int TAID_BITSIZE = 4;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS = 255;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    public BAPArrayElement createArrayElement() {
        return new OnlineUpdateList_Data(this.getArrayHeader());
    }

    public OnlineUpdateList_SetGetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateList_SetGetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateList_SetGetArray onlineUpdateList_SetGetArray = (OnlineUpdateList_SetGetArray)bAPEntity;
        return this.asg_Id == onlineUpdateList_SetGetArray.asg_Id && this.taid == onlineUpdateList_SetGetArray.taid && this.arrayHeader.equalTo(onlineUpdateList_SetGetArray.arrayHeader) && this.data.equalTo(onlineUpdateList_SetGetArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateList_SetGetArray");
        stringBuffer.append("\n - asg_Id:" + this.asg_Id);
        stringBuffer.append("\n - taid:" + this.taid);
        stringBuffer.append("\n - arrayHeader:" + this.arrayHeader.toString());
        stringBuffer.append("\n - data:" + this.data.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new OnlineUpdateList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 37;
    }

    public int getFunctionId() {
        return OnlineUpdateList_SetGetArray.functionId();
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

    public int getTransactionId() {
        return this.taid;
    }

    public void setTransactionId(int n) {
        this.taid = n;
    }

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
}

