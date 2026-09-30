/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceControl_Result
implements ResultMethod {
    public int controlResult;
    public static final int CONTROL_RESULT_NOT_SUCCESSFUL_NO_SERVICE_PENDING = 4;
    public static final int CONTROL_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int CONTROL_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int CONTROL_RESULT_NOT_SUCCESSFUL = 1;
    public static final int CONTROL_RESULT_SUCCESSFUL = 0;

    public ServiceControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlResult = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceControl_Result serviceControl_Result = (ServiceControl_Result)bAPEntity;
        return this.controlResult == serviceControl_Result.controlResult;
    }

    private void customInitialization() {
    }

    public int getResultCode() {
        return this.controlResult;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceControl_Result");
        stringBuffer.append("\n - controlResult:").append(this.controlResult);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.controlResult);
    }

    public void deserialize(BitStream bitStream) {
        this.controlResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return ServiceControl_Result.functionId();
    }
}

