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
    public static final int ASG_ID_C_GW_OCU;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG;
    public final BAPString vtanauthenticationData = new BAPString(46);
    private static final int MAX_VTANAUTHENTICATIONDATA_LENGTH;
    public int resultCode;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_INPUT_DATA_VALIDATION_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_CLAMP_15_NOT_ACTIVE;
    public static final int RESULT_CODE_ABORT_NOT_SUCCESSFUL;
    public static final int RESULT_CODE_ABORT_SUCCESSFUL;
    public static final int RESULT_CODE_NOT_SUCCESSFUL;
    public static final int RESULT_CODE_SUCCESSFUL;

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

    @Override
    public void reset() {
        this.internalReset();
        this.vtanauthenticationData.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        VTANAuthData_Result vTANAuthData_Result = (VTANAuthData_Result)bAPEntity;
        return this.asg_Id == vTANAuthData_Result.asg_Id && this.vtanauthenticationData.equalTo(vTANAuthData_Result.vtanauthenticationData) && this.resultCode == vTANAuthData_Result.resultCode;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.resultCode;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANAuthData_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - vtanauthenticationData:").append(this.vtanauthenticationData.toString());
        stringBuffer.append("\n - resultCode:").append(this.resultCode);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        this.vtanauthenticationData.serialize(bitStream);
        bitStream.pushByte((byte)this.resultCode);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.vtanauthenticationData.deserialize(bitStream);
        this.resultCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return VTANAuthData_Result.functionId();
    }
}

