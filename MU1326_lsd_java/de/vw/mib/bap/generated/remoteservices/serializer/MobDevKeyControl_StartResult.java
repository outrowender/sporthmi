/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeyControl_StartResult
implements StartResultMethod {
    public int asg_Id;
    public static final int ASG_ID_C_GW_OCU;
    public static final int ASG_ID_HEAD_UNIT;
    public static final int ASG_ID_DEFAULT_ASG;
    public int commandType;
    public static final int COMMAND_TYPE_DISABLE_SMARTCARD;
    public static final int COMMAND_TYPE_ENABLE_SMARTCARD;

    public MobDevKeyControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeyControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.commandType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeyControl_StartResult mobDevKeyControl_StartResult = (MobDevKeyControl_StartResult)bAPEntity;
        return this.asg_Id == mobDevKeyControl_StartResult.asg_Id && this.commandType == mobDevKeyControl_StartResult.commandType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeyControl_StartResult");
        stringBuffer.append("\n - asg_Id:").append(this.asg_Id);
        stringBuffer.append("\n - commandType:").append(this.commandType);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.asg_Id);
        bitStream.pushByte((byte)this.commandType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asg_Id = bitStream.popFrontByte();
        this.commandType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return MobDevKeyControl_StartResult.functionId();
    }
}

