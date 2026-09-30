/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_Result
implements ResultMethod {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public int dialNumber_Result;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK = 5;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID = 4;
    public static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL = 1;
    public static final int DIAL_NUMBER_RESULT_SUCCESSFUL = 0;

    public DialNumber_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.dialNumber_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_Result dialNumber_Result = (DialNumber_Result)bAPEntity;
        return this.asg_Id == dialNumber_Result.asg_Id && this.dialNumber_Result == dialNumber_Result.dialNumber_Result;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.dialNumber_Result;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialNumber_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - dialNumber_Result:").append(this.dialNumber_Result);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        bitStream.pushByte((byte)this.dialNumber_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.dialNumber_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 30;
    }

    public int getFunctionId() {
        return DialNumber_Result.functionId();
    }
}

