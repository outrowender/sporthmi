/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class TriggerRemoteProcess_Result
implements ResultMethod {
    public int triggerResult;
    public static final int TRIGGER_RESULT_NOT_SUCCESSFUL_COMMAND_TYPE_NOT_SUPPORTED = 5;
    public static final int TRIGGER_RESULT_NOT_SUCCESSFUL = 1;
    public static final int TRIGGER_RESULT_SUCCESSFUL = 0;

    public TriggerRemoteProcess_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public TriggerRemoteProcess_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.triggerResult = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        TriggerRemoteProcess_Result triggerRemoteProcess_Result = (TriggerRemoteProcess_Result)bAPEntity;
        return this.triggerResult == triggerRemoteProcess_Result.triggerResult;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.triggerResult;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TriggerRemoteProcess_Result");
        stringBuffer.append("\n - triggerResult:" + this.triggerResult);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.triggerResult);
    }

    public void deserialize(BitStream bitStream) {
        this.triggerResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return TriggerRemoteProcess_Result.functionId();
    }
}

