/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class UserList_GetArray
implements BAPGetArray {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT_TO_BE_EVALUATED_BY_ALL_ASGS = 9;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTANEOUS_FSG_MESSAGE = 0;
    private static final int ASG_ID_BITSIZE = 4;
    public int taid;
    public static final int TAID_MIN = 0;
    private static final int TAID_BITSIZE = 4;
    public ArrayHeader arrayHeader = new ArrayHeader();

    public UserList_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public UserList_GetArray(BitStream bitStream) {
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
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        UserList_GetArray userList_GetArray = (UserList_GetArray)bAPEntity;
        return this.asg_Id == userList_GetArray.asg_Id && this.taid == userList_GetArray.taid && this.arrayHeader.equalTo(userList_GetArray.arrayHeader);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserList_GetArray");
        stringBuffer.append("\n - asg_Id:" + this.asg_Id);
        stringBuffer.append("\n - taid:" + this.taid);
        stringBuffer.append("\n - arrayHeader:" + this.arrayHeader.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        this.arrayHeader.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontBits(4);
        this.taid = bitStream.popFrontBits(4);
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 21;
    }

    public int getFunctionId() {
        return UserList_GetArray.functionId();
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

