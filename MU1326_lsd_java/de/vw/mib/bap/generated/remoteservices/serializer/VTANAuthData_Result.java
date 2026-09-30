/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class VTANAuthData_Result
implements ResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU = 2;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public final BAPString vtanauthenticationData = new BAPString(46);
    private static final int MAX_VTANAUTHENTICATIONDATA_LENGTH = 46;
    public int resultCode;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_INPUT_DATA_VALIDATION_FAILED = 6;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_FAILED = 5;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_CLAMP_15_NOT_ACTIVE = 4;
    public static final int RESULT_CODE_ABORT_NOT_SUCCESSFUL = 3;
    public static final int RESULT_CODE_ABORT_SUCCESSFUL = 2;
    public static final int RESULT_CODE_NOT_SUCCESSFUL = 1;
    public static final int RESULT_CODE_SUCCESSFUL = 0;

    public VTANAuthData_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public VTANAuthData_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.resultCode = 0;
    }

    public void reset() {
        this.internalReset();
        this.vtanauthenticationData.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VTANAuthData_Result vTANAuthData_Result = (VTANAuthData_Result)bAPEntity;
        return this.asg_Id == vTANAuthData_Result.asg_Id && this.vtanauthenticationData.equalTo(vTANAuthData_Result.vtanauthenticationData) && this.resultCode == vTANAuthData_Result.resultCode;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANAuthData_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - vtanauthenticationData:").append(this.vtanauthenticationData.toString());
        stringBuffer.append("\n - resultCode:").append(this.resultCode);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        this.vtanauthenticationData.serialize(bitStream);
        bitStream.pushByte((byte)this.resultCode);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.vtanauthenticationData.deserialize(bitStream);
        this.resultCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return VTANAuthData_Result.functionId();
    }
}

