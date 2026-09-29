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
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG;
    public int dialNumber_Result;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID;
    public static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_SUCCESSFUL;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_Result dialNumber_Result = (DialNumber_Result)bAPEntity;
        return this.asg_Id == dialNumber_Result.asg_Id && this.dialNumber_Result == dialNumber_Result.dialNumber_Result;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.dialNumber_Result;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialNumber_Result");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - dialNumber_Result:").append(this.dialNumber_Result);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        bitStream.pushByte((byte)this.dialNumber_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.dialNumber_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 30;
    }

    @Override
    public int getFunctionId() {
        return DialNumber_Result.functionId();
    }
}

