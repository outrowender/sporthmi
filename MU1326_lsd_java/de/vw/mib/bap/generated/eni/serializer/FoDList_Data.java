/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.FoDList_FunctionProperties;
import de.vw.mib.bap.stream.BitStream;

public final class FoDList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_FS_ID_ACTIVATION_STATE_FUNCTION_PROPERTIES_VALIDITY_TYPE_START_VALIDITY_STOP_VALIDITY = 1;
    public static final int RECORD_ADDRESS_FS_ID_ACTIVATION_STATE = 2;
    public static final int RECORD_ADDRESS_POS = 15;
    public static final int POS_MIN = 0;
    public int pos;
    public static final int FS_ID_MIN = 1;
    public int fs_Id;
    public static final int ACTIVATION_STATE_ACTIVATED = 0;
    public static final int ACTIVATION_STATE_ACTIVATION_PENDING = 1;
    public static final int ACTIVATION_STATE_ACTIVATED_BUT_LICENSE_EXPIRES_SOON_SEE_VALIDITY_TYPE_START_VALIDITY_STOP_VALIDITY = 2;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_BUT_STAYS_ACTIVATED_UNTIL_NEXT_CLAMP_CHANGE = 3;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_CONFIRMATION_REQUIRED = 4;
    public static final int ACTIVATION_STATE_LICENSE_EXPIRED_AND_DEACTIVATED = 5;
    public static final int ACTIVATION_STATE_NOT_ACTIVATED = 6;
    public static final int ACTIVATION_STATE_DEFECTIVE = 7;
    public static final int ACTIVATION_STATE_BLOCKED = 8;
    public int activationState;
    public FoDList_FunctionProperties functionProperties;
    public static final int VALIDITY_TYPE_UNLIMITED = 0;
    public static final int VALIDITY_TYPE_TIME_LIMITED_FROM_TO_ = 16;
    public static final int VALIDITY_TYPE_TIME_LIMITED_FROM_ = 17;
    public static final int VALIDITY_TYPE_TIME_LIMITED_TO_ = 18;
    public static final int VALIDITY_TYPE_TIME_LIMITED_IN_SECONDS_FROM_ACTIVATION = 19;
    public static final int VALIDITY_TYPE_OPERATING_TIME_FROM_TO_ = 32;
    public static final int VALIDITY_TYPE_OPERATING_TIME_FROM_ = 33;
    public static final int VALIDITY_TYPE_OPERATING_TIME_TO_ = 34;
    public static final int VALIDITY_TYPE_OPERATING_TIME_IN_SECONDS_FROM_ACTIVATION = 35;
    public static final int VALIDITY_TYPE_MILEAGE_FROM_TO_ = 48;
    public static final int VALIDITY_TYPE_MILEAGE_FROM_ = 49;
    public static final int VALIDITY_TYPE_MILEAGE_TO_ = 50;
    public static final int VALIDITY_TYPE_KILOMETERS_FROM_ACTIVATION = 51;
    public int validityType;
    public static final int START_VALIDITY_MIN = 0;
    public int startValidity;
    public static final int STOP_VALIDITY_MIN = 0;
    public int stopValidity;

    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public FoDList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.functionProperties = new FoDList_FunctionProperties();
        this.internalReset();
        this.customInitialization();
    }

    public FoDList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.fs_Id = 1;
        this.activationState = 0;
        this.validityType = 0;
        this.startValidity = 0;
        this.stopValidity = 0;
    }

    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.functionProperties.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FoDList_Data foDList_Data = (FoDList_Data)bAPEntity;
        return this.arrayHeader.equalTo(foDList_Data.arrayHeader) && this.pos == foDList_Data.pos && this.fs_Id == foDList_Data.fs_Id && this.activationState == foDList_Data.activationState && this.functionProperties.equalTo(foDList_Data.functionProperties) && this.validityType == foDList_Data.validityType && this.startValidity == foDList_Data.startValidity && this.stopValidity == foDList_Data.stopValidity;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FoDList_Data");
        stringBuffer.append("\n - pos:" + this.pos);
        stringBuffer.append("\n - fs_Id:" + this.fs_Id);
        stringBuffer.append("\n - activationState:" + this.activationState);
        stringBuffer.append("\n - functionProperties:" + this.functionProperties.toString());
        stringBuffer.append("\n - validityType:" + this.validityType);
        stringBuffer.append("\n - startValidity:" + this.startValidity);
        stringBuffer.append("\n - stopValidity:" + this.stopValidity);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.fs_Id);
                bitStream.pushByte((byte)this.activationState);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushInt(this.fs_Id);
                bitStream.pushByte((byte)this.activationState);
                this.functionProperties.serialize(bitStream);
                bitStream.pushByte((byte)this.validityType);
                bitStream.pushInt(this.startValidity);
                bitStream.pushInt(this.stopValidity);
                break;
            }
        }
    }

    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fs_Id = bitStream.popFrontInt();
                this.activationState = bitStream.popFrontByte();
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.fs_Id = bitStream.popFrontInt();
                this.activationState = bitStream.popFrontByte();
                this.functionProperties.deserialize(bitStream);
                this.validityType = bitStream.popFrontByte();
                this.startValidity = bitStream.popFrontInt();
                this.stopValidity = bitStream.popFrontInt();
                break;
            }
        }
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public int getPos() {
        return this.pos;
    }
}

