/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class VTANAuthData_StartResult
implements StartResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU = 2;
    public static final int ASG_ID_HEAD_UNIT = 1;
    public static final int ASG_ID_DEFAULT_ASG = 0;
    public final BAPString challenge = new BAPString(9);
    private static final int MAX_CHALLENGE_LENGTH = 9;

    public VTANAuthData_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public VTANAuthData_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
    }

    public void reset() {
        this.internalReset();
        this.challenge.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VTANAuthData_StartResult vTANAuthData_StartResult = (VTANAuthData_StartResult)bAPEntity;
        return this.asg_Id == vTANAuthData_StartResult.asg_Id && this.challenge.equalTo(vTANAuthData_StartResult.challenge);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VTANAuthData_StartResult");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - challenge:").append(this.challenge.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        this.challenge.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.challenge.deserialize(bitStream);
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return VTANAuthData_StartResult.functionId();
    }
}

