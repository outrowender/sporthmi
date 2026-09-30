/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FoDState_Status
implements StatusProperty {
    public int foDstate;
    public static final int FO_DSTATE_FO_D_ERROR_DETAILS_IN_EXCEPTION_STATE_0X30_0X4F = 12;
    public static final int FO_DSTATE_REPAIR_SUCCESSFUL = 11;
    public static final int FO_DSTATE_SEARCHING_FOR_NETWORK = 10;
    public static final int FO_DSTATE_ACTIVATION_FAILED_DETAILS_IN_EXCEPTION_STATE_0X01_0X2F = 9;
    public static final int FO_DSTATE_ACTIVATION_SUCCESSFUL_CLAMP_CHANGE_REQUIRED = 8;
    public static final int FO_DSTATE_ACTIVATION_SUCCESSFUL = 7;
    public static final int FO_DSTATE_ACTIVATION_IN_PROGRESS = 6;
    public static final int FO_DSTATE_CHECK_PRECONDITIONS = 5;
    public static final int FO_DSTATE_REQUEST_IN_PROGRESS_RESPONSE_PENDING = 4;
    public static final int FO_DSTATE_CONNECTING_TO_SERVER = 3;
    public static final int FO_DSTATE_NEW_FSC_AVAILABLE_USER_AUTHORIZATION_PENDING = 2;
    public static final int FO_DSTATE_NEW_FSC_AVAILABLE_DOWNLOAD_CONFIRMATION_PENDING = 1;
    public static final int FO_DSTATE_NO_INFORMATION_DEFAULT = 0;
    public int exceptionState;
    public static final int EXCEPTION_STATE_ERROR_FRESHNESS_COUNTER = 50;
    public static final int EXCEPTION_STATE_BAD_FRESHNESS_COUNTER_ONLINE_CONNECTION_REQUIRED_WITHIN_X_DAYS_SEE_ADDITIONAL_DATA = 49;
    public static final int EXCEPTION_STATE_GENERAL_FO_D_ERROR = 48;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_DENIED = 12;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_FUNCTION_DEFECT = 11;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_CLAMP15_TURNED_OFF = 10;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_FAILED_RETRY_IN_NEXT_CLAMP_CYCLE = 9;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_INSTALLATION_FAILED = 8;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_TIMEOUT = 7;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_MISC_BACKEND_ERROR = 6;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_SERVICE_UNAVAILABLE = 5;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_AUTHENTICATION_ERROR = 4;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_VERIFIED_ACCOUNT_FOUND = 3;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_NETWORK_CONNECTION = 2;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL = 1;
    public static final int EXCEPTION_STATE_NO_ERROR_EXCEPTION = 0;
    public int additionalData;
    public static final int ADDITIONAL_DATA_MIN = 0;
    public int activationProgress;
    public static final int ACTIVATION_PROGRESS_MIN = 0;

    public FoDState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FoDState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.foDstate = 0;
        this.exceptionState = 0;
        this.additionalData = 0;
        this.activationProgress = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FoDState_Status foDState_Status = (FoDState_Status)bAPEntity;
        return this.foDstate == foDState_Status.foDstate && this.exceptionState == foDState_Status.exceptionState && this.additionalData == foDState_Status.additionalData && this.activationProgress == foDState_Status.activationProgress;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FoDState_Status");
        stringBuffer.append("\n - foDstate:" + this.foDstate);
        stringBuffer.append("\n - exceptionState:" + this.exceptionState);
        stringBuffer.append("\n - additionalData:" + this.additionalData);
        stringBuffer.append("\n - activationProgress:" + this.activationProgress);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.foDstate);
        bitStream.pushByte((byte)this.exceptionState);
        bitStream.pushByte((byte)this.additionalData);
        bitStream.pushByte((byte)this.activationProgress);
    }

    public void deserialize(BitStream bitStream) {
        this.foDstate = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
        this.additionalData = bitStream.popFrontByte();
        this.activationProgress = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 32;
    }

    public int getFunctionId() {
        return FoDState_Status.functionId();
    }
}

