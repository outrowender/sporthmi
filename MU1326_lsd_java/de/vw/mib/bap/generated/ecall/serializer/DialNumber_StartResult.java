/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_StartResult
implements StartResultMethod {
    public int asg_Id;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public final BAPString telNumber = new BAPString(41);
    private static final int MAX_TELNUMBER_LENGTH = 41;

    public DialNumber_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
    }

    public void reset() {
        this.internalReset();
        this.telNumber.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_StartResult dialNumber_StartResult = (DialNumber_StartResult)bAPEntity;
        return this.asg_Id == dialNumber_StartResult.asg_Id && this.telNumber.equalTo(dialNumber_StartResult.telNumber);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialNumber_StartResult");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - telNumber:").append(this.telNumber.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        this.telNumber.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.telNumber.deserialize(bitStream);
    }

    public static int functionId() {
        return 30;
    }

    public int getFunctionId() {
        return DialNumber_StartResult.functionId();
    }
}

