/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyControl_Result
implements ResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG;
    public int resultCode;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_WITH_PHYSICAL_OR_MOBILE_DEVICE_KEY_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_WITH_SMARTCARD_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_WITH_MOBILE_DEVICE_KEY_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_WITH_PHYSICAL_KEY_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_FAILED;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_CLAMP_15_NOT_ACTIVE;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_COMMAND_TYPE_NOT_SUPPORTED;
    public static final int RESULT_CODE_ABORT_NOT_SUCCESSFUL;
    public static final int RESULT_CODE_ABORT_SUCCESSFUL;
    public static final int RESULT_CODE_NOT_SUCCESSFUL;
    public static final int RESULT_CODE_SUCCESSFUL;

    public MobDevKeyControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyControl_Result(BitStream bitStream) {
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
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyControl_Result mobDevKeyControl_Result = (MobDevKeyControl_Result)bAPEntity;
        return this.asg_Id == mobDevKeyControl_Result.asg_Id && this.resultCode == mobDevKeyControl_Result.resultCode;
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
        stringBuffer.append("MobDevKeyControl_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
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
        bitStream.pushByte((byte)this.resultCode);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.resultCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return MobDevKeyControl_Result.functionId();
    }
}

