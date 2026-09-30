/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.ServiceState_DataTransmissionState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceState_Status
implements StatusProperty {
    public int serviceType;
    public static final int SERVICE_TYPE_MEC_LEGAL_DF3_7 = 8;
    public static final int SERVICE_TYPE_ACN_LEGAL_DF3_7 = 7;
    public static final int SERVICE_TYPE_TEST_MODE_DF3_4 = 6;
    public static final int SERVICE_TYPE_MEC = 5;
    public static final int SERVICE_TYPE_ACN = 4;
    public static final int SERVICE_TYPE_INFO_CALL = 3;
    public static final int SERVICE_TYPE_USM = 2;
    public static final int SERVICE_TYPE_SERVICE_BREAKDOWN_CALL = 1;
    public static final int SERVICE_TYPE_IDLE = 0;
    public int serviceState;
    public static final int SERVICE_STATE_VOICE_CALL_PRESENT_SENDING_DATA_DF3_7 = 22;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_DUE_TO_NETWORK_ERROR_DF3_6 = 21;
    public static final int SERVICE_STATE_SERVICE_DISABLED_BY_DRIVER_DF3_5 = 20;
    public static final int SERVICE_STATE_REDIAL_FAILED_CALLBACK_PENDING_DF3_4 = 19;
    public static final int SERVICE_STATE_CALL_SETUP_FAILED_REDIAL_PENDING_DF3_4 = 18;
    public static final int SERVICE_STATE_VOICE_CALL_TERMINATED_DF3_4 = 17;
    public static final int SERVICE_STATE_TEST_MODE_ACTIVE_DF3_4 = 16;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_TIMEOUT_DF3_4 = 15;
    public static final int SERVICE_STATE_SERVICE_NOT_STARTED_DENIED_BY_USER = 14;
    public static final int SERVICE_STATE_SERVICE_NOT_LICENSED = 13;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_WITH_BY_ERROR = 12;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_WITH_BY_ERROR_WAITING_FOR_DATA_RECEIVED_CONFIRMATION = 11;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_REGULARLY = 10;
    public static final int SERVICE_STATE_SERVICE_TERMINATED_BY_USER = 9;
    public static final int SERVICE_STATE_SENDING_DATA_VIA_INBAND_MODEM = 8;
    public static final int SERVICE_STATE_VOICE_CALL_TERMINATED_REDIAL_PENDING = 7;
    public static final int SERVICE_STATE_VOICE_CALL_PRESENT = 6;
    public static final int SERVICE_STATE_VOICE_CALL_PENDING = 5;
    public static final int SERVICE_STATE_DISCONNECTING_FROM_SERVER = 4;
    public static final int SERVICE_STATE_SENDING_DATA_VIA_IP_CONNECTION = 3;
    public static final int SERVICE_STATE_CONNECTING_TO_SERVER = 2;
    public static final int SERVICE_STATE_COLLECTING_DATA = 1;
    public static final int SERVICE_STATE_IDLE = 0;
    public ServiceState_DataTransmissionState dataTransmissionState = new ServiceState_DataTransmissionState();
    public int extension_1;
    public static final int EXTENSION_1_MIN = 0;
    public int extension_2;
    public static final int EXTENSION_2_MIN = 0;
    public int extension_3;
    public static final int EXTENSION_3_MIN = 0;

    public ServiceState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceType = 0;
        this.serviceState = 0;
        this.extension_1 = 0;
        this.extension_2 = 0;
        this.extension_3 = 0;
    }

    public void reset() {
        this.internalReset();
        this.dataTransmissionState.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ServiceState_Status serviceState_Status = (ServiceState_Status)bAPEntity;
        return this.serviceType == serviceState_Status.serviceType && this.serviceState == serviceState_Status.serviceState && this.dataTransmissionState.equalTo(serviceState_Status.dataTransmissionState) && this.extension_1 == serviceState_Status.extension_1 && this.extension_2 == serviceState_Status.extension_2 && this.extension_3 == serviceState_Status.extension_3;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ServiceState_Status");
        stringBuffer.append("\n - serviceType:").append(this.serviceType);
        stringBuffer.append("\n - serviceState:").append(this.serviceState);
        stringBuffer.append("\n - dataTransmissionState:").append(this.dataTransmissionState.toString());
        stringBuffer.append("\n - extension_1:").append(this.extension_1);
        stringBuffer.append("\n - extension_2:").append(this.extension_2);
        stringBuffer.append("\n - extension_3:").append(this.extension_3);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.serviceType);
        bitStream.pushByte((byte)this.serviceState);
        this.dataTransmissionState.serialize(bitStream);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
        bitStream.pushByte((byte)this.extension_3);
    }

    public void deserialize(BitStream bitStream) {
        this.serviceType = bitStream.popFrontByte();
        this.serviceState = bitStream.popFrontByte();
        this.dataTransmissionState.deserialize(bitStream);
        this.extension_1 = bitStream.popFrontByte();
        this.extension_2 = bitStream.popFrontByte();
        this.extension_3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return ServiceState_Status.functionId();
    }
}

