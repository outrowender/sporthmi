/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class VTANDecryption_Result
implements ResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU = 2;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public int vtantype;
    public static final int VTANTYPE_MOBILE_DEVICE_KEY = 1;
    public static final int VTANTYPE_INIT_UNKNOWN = 0;
    public final BAPString vtan = new BAPString(31);
    private static final int MAX_VTAN_LENGTH = 31;
    public final BAPString param1 = new BAPString(243);
    private static final int MAX_PARAM1_LENGTH = 243;
    public final BAPString param2 = new BAPString(243);
    private static final int MAX_PARAM2_LENGTH = 243;
    public int resultCode;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_DECRYPTION_TIMED_OUT = 8;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_CHALLENGE_TIMED_OUT = 7;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_INPUT_DATA_VALIDATION_FAILED = 6;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_AUTHENTICATION_FAILED = 5;
    public static final int RESULT_CODE_NOT_SUCCESSFUL_CLAMP_15_NOT_ACTIVE = 4;
    public static final int RESULT_CODE_ABORT_NOT_SUCCESSFUL = 3;
    public static final int RESULT_CODE_ABORT_SUCCESSFUL = 2;
    public static final int RESULT_CODE_NOT_SUCCESSFUL = 1;
    public static final int RESULT_CODE_SUCCESSFUL = 0;

    public VTANDecryption_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public VTANDecryption_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.vtantype = 0;
        this.resultCode = 0;
    }

    public void reset() {
        this.internalReset();
        this.vtan.reset();
        this.param1.reset();
        this.param2.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VTANDecryption_Result vTANDecryption_Result = (VTANDecryption_Result)bAPEntity;
        return this.asg_Id == vTANDecryption_Result.asg_Id && this.vtantype == vTANDecryption_Result.vtantype && this.vtan.equalTo(vTANDecryption_Result.vtan) && this.param1.equalTo(vTANDecryption_Result.param1) && this.param2.equalTo(vTANDecryption_Result.param2) && this.resultCode == vTANDecryption_Result.resultCode;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANDecryption_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - vtantype:").append(this.vtantype);
        stringBuffer.append("\n - vtan:").append(this.vtan.toString());
        stringBuffer.append("\n - param1:").append(this.param1.toString());
        stringBuffer.append("\n - param2:").append(this.param2.toString());
        stringBuffer.append("\n - resultCode:").append(this.resultCode);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        bitStream.pushByte((byte)this.vtantype);
        this.vtan.serialize(bitStream);
        this.param1.serialize(bitStream);
        this.param2.serialize(bitStream);
        bitStream.pushByte((byte)this.resultCode);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.vtantype = bitStream.popFrontByte();
        this.vtan.deserialize(bitStream);
        this.param1.deserialize(bitStream);
        this.param2.deserialize(bitStream);
        this.resultCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return VTANDecryption_Result.functionId();
    }
}

