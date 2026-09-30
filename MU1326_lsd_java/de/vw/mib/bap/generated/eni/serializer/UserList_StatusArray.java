/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.UserList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class UserList_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS = 9;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE = 0;
    private static final int ASG_ID_BITSIZE = 4;
    public int taid;
    public static final int TAID_MIN = 0;
    private static final int TAID_BITSIZE = 4;
    public int totalNumListElements;
    public static final int TOTAL_NUM_LIST_ELEMENTS_MIN = 0;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS = 255;
    public BAPArrayData data = new BAPArrayData(255, this.arrayHeader);

    public BAPArrayElement createArrayElement() {
        return new UserList_Data(this.getArrayHeader());
    }

    public UserList_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public UserList_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.totalNumListElements = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        UserList_StatusArray userList_StatusArray = (UserList_StatusArray)bAPEntity;
        return this.asg_Id == userList_StatusArray.asg_Id && this.taid == userList_StatusArray.taid && this.totalNumListElements == userList_StatusArray.totalNumListElements && this.arrayHeader.equalTo(userList_StatusArray.arrayHeader) && this.data.equalTo(userList_StatusArray.data);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserList_StatusArray");
        stringBuffer.append("\n - asg_Id:" + this.asg_Id);
        stringBuffer.append("\n - taid:" + this.taid);
        stringBuffer.append("\n - totalNumListElements:" + this.totalNumListElements);
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
        bitStream.pushByte((byte)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.totalNumListElements = bitStream.popFrontByte();
        this.arrayHeader.deserialize(bitStream);
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new UserList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return UserList_StatusArray.functionId();
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

    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }
}

