/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.eni.serializer.UserList_UserLoginState;
import de.vw.mib.bap.stream.BitStream;

public final class UserList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_USER_NAME_USER_TYPE;
    public static final int RECORD_ADDRESS_USER_NAME_USER_LOGIN_STATE_USER_TYPE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public UserList_UserLoginState userLoginState;
    public static final int USER_TYPE_MAIN_USER;
    public static final int USER_TYPE_SUB_USER;
    public static final int USER_TYPE_FLEET_USER_DF3_6;
    public int userType;
    private static final int MAX_USERNAME_LENGTH;
    public final BAPString userName;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public UserList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.userLoginState = new UserList_UserLoginState();
        this.userName = new BAPString(242);
        this.internalReset();
        this.customInitialization();
    }

    public UserList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.userType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.userLoginState.reset();
        this.userName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        UserList_Data userList_Data = (UserList_Data)bAPEntity;
        return this.arrayHeader.equalTo(userList_Data.arrayHeader) && this.pos == userList_Data.pos && this.userLoginState.equalTo(userList_Data.userLoginState) && this.userType == userList_Data.userType && this.userName.equalTo(userList_Data.userName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserList_Data");
        stringBuffer.append(new StringBuffer().append("\n - pos:").append(this.pos).toString());
        stringBuffer.append(new StringBuffer().append("\n - userLoginState:").append(this.userLoginState.toString()).toString());
        stringBuffer.append(new StringBuffer().append("\n - userType:").append(this.userType).toString());
        stringBuffer.append(new StringBuffer().append("\n - userName:").append(this.userName.toString()).toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.userName.serialize(bitStream);
                this.userLoginState.serialize(bitStream);
                bitStream.pushByte((byte)this.userType);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.userName.serialize(bitStream);
                bitStream.pushByte((byte)this.userType);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.userName.deserialize(bitStream);
                this.userLoginState.deserialize(bitStream);
                this.userType = bitStream.popFrontByte();
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.userName.deserialize(bitStream);
                this.userType = bitStream.popFrontByte();
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

