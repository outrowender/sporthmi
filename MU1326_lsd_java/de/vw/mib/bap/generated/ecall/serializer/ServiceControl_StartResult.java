/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceControl_StartResult
implements StartResultMethod {
    public int serviceType;
    public static final int SERVICE_TYPE_ALL_SERVICES = 255;
    public static final int SERVICE_TYPE_TEST_MODE_DF3_4 = 6;
    public static final int SERVICE_TYPE_MEC = 5;
    public static final int SERVICE_TYPE_ACN = 4;
    public static final int SERVICE_TYPE_INFO_CALL = 3;
    public static final int SERVICE_TYPE_USM = 2;
    public static final int SERVICE_TYPE_SERVICE_BREAKDOWN_CALL = 1;
    public static final int SERVICE_TYPE_DEFAULT_IN_CASE_OF_CANCLE_ABORT = 0;
    public int controlCode;
    public static final int CONTROL_CODE_TRIGGER_SERVICE_BY_ASG_DF3_3 = 3;
    public static final int CONTROL_CODE_TERMINATE_IF_NOT_PENDING_ANYMORE = 2;
    public static final int CONTROL_CODE_DENY_IN_CASE_OF_CONFIRMATION_PENDING = 1;
    public static final int CONTROL_CODE_CONFIRM = 0;

    public ServiceControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
        this.controlCode = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceControl_StartResult serviceControl_StartResult = (ServiceControl_StartResult)bAPEntity;
        return this.serviceType == serviceControl_StartResult.serviceType && this.controlCode == serviceControl_StartResult.controlCode;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceControl_StartResult");
        stringBuffer.append("\n - serviceType:").append(this.serviceType);
        stringBuffer.append("\n - controlCode:").append(this.controlCode);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.serviceType);
        bitStream.pushByte((byte)this.controlCode);
    }

    public void deserialize(BitStream bitStream) {
        this.serviceType = bitStream.popFrontByte();
        this.controlCode = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return ServiceControl_StartResult.functionId();
    }
}

