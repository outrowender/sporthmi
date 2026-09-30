/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.eni.serializer.CurrentOnlineUpdateState_CurrentPreconditionStates;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentOnlineUpdateState_Status
implements StatusProperty {
    public int updateState;
    public static final int UPDATE_STATE_UPDATE_WITHDRAWN_PROCESS_CANCELLED_CONFIRMATION_REQUIRED_DF3_6 = 25;
    public static final int UPDATE_STATE_ECU_UPDATE_CONFIRMATION_FAILED_DETAILS_IN_EXCEPTION_STATE_DF3_5 = 24;
    public static final int UPDATE_STATE_CONNECTING_TO_SERVER_DF3_5 = 23;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_USER_AUTHORIZATION_PENDING_DF3_5 = 22;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_NEW_LANGUAGE_DF3_5 = 21;
    public static final int UPDATE_STATE_LANGUAGE_REQUEST_IN_PROGRESS_DF3_5 = 20;
    public static final int UPDATE_STATE_UPDATE_WITHDRAWN_PROCESS_CANCELED = 19;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_APPROVED = 18;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_FAILED_DETAILS_IN_EXCEPTION_STATE = 17;
    public static final int UPDATE_STATE_USER_AUTHORIZATION_PENDING = 16;
    public static final int UPDATE_STATE_ECU_UPDATE_FINISHED_SUCCESSFULLY = 15;
    public static final int UPDATE_STATE_ECU_UPDATE_FAILED_DETAILS_IN_EXCEPTION_STATE = 14;
    public static final int UPDATE_STATE_ECU_UPDATE_IN_PROGRESS = 13;
    public static final int UPDATE_STATE_ECU_UPDATE_CONFIRMED = 12;
    public static final int UPDATE_STATE_ECU_UPDATE_POSTPONED = 11;
    public static final int UPDATE_STATE_ECU_UPDATE_REJECTED = 10;
    public static final int UPDATE_STATE_DOWNLOAD_FINISHED_ECU_UPDATE_CONFIRMATION_PENDING = 9;
    public static final int UPDATE_STATE_DOWNLOAD_TERMINATED_BY_ERROR_DETAILS_IN_EXCEPTION_STATE = 8;
    public static final int UPDATE_STATE_DOWNLOAD_FINISHED_SUCCESSFULLY = 7;
    public static final int UPDATE_STATE_ONLINE_UPDATE_CONFIRMED_DOWNLOAD_IN_PROGRESS = 6;
    public static final int UPDATE_STATE_ONLINE_UPDATE_CONFIRMED_DOWNLOAD_PENDING = 5;
    public static final int UPDATE_STATE_ONLINE_UPDATE_POSTPONED = 4;
    public static final int UPDATE_STATE_ONLINE_UPDATE_REJECTED = 3;
    public static final int UPDATE_STATE_ONLINE_UPDATE_AVAILABLE_DOWNLOAD_CONFIRMATION_PENDING = 2;
    public static final int UPDATE_STATE_NO_UPDATE_ACTIVE_DEFAULT_DURING_NORMAL_OPERATION = 1;
    public static final int UPDATE_STATE_NO_INFORMATION_DEFAULT_DURING_STARTUP = 0;
    public final BAPString currentUpdateId = new BAPString(21);
    private static final int MAX_CURRENTUPDATEID_LENGTH = 21;
    public CurrentOnlineUpdateState_CurrentPreconditionStates currentPreconditionStates = new CurrentOnlineUpdateState_CurrentPreconditionStates();
    public final BAPString startTime = new BAPString(18);
    private static final int MAX_STARTTIME_LENGTH = 18;
    public int updateProgress;
    public static final int UPDATE_PROGRESS_MIN = 0;
    public int exceptionState;
    public static final int EXCEPTION_STATE_FATAL_UPDATE_FAILURE_CONFIRMATION_REQUIRED_DF3_6 = 28;
    public static final int EXCEPTION_STATE_UPDATE_FAILURE_CONFIRMATION_REQUIRED_DF3_6 = 27;
    public static final int EXCEPTION_STATE_ECU_UPDATE_PRECONDITION_NOT_FULFILLED_DF3_5 = 26;
    public static final int EXCEPTION_STATE_WRONG_PIN_9_REMAINING = 25;
    public static final int EXCEPTION_STATE_WRONG_PIN_8_REMAINING = 24;
    public static final int EXCEPTION_STATE_WRONG_PIN_7_REMAINING = 23;
    public static final int EXCEPTION_STATE_WRONG_PIN_6_REMAINING = 22;
    public static final int EXCEPTION_STATE_WRONG_PIN_5_REMAINING = 21;
    public static final int EXCEPTION_STATE_WRONG_PIN_4_REMAINING = 20;
    public static final int EXCEPTION_STATE_WRONG_PIN_3_REMAINING = 19;
    public static final int EXCEPTION_STATE_WRONG_PIN_2_REMAINING = 18;
    public static final int EXCEPTION_STATE_WRONG_PIN_1_REMAINING = 17;
    public static final int EXCEPTION_STATE_WRONG_PIN_0_REMAINING = 16;
    public static final int EXCEPTION_STATE_WRONG_PIN_GENERAL = 15;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_TIMEOUT = 14;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_MISC_BACKEND_ERROR = 13;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_SERVICE_UNAVAILABLE = 12;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_BACKEND_AUTHENTICATION_ERROR = 11;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_VERIFIED_ACCOUNT_FOUND = 10;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_NO_NETWORK_CONNECTION = 9;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_PARAMETER_MISMATCH = 8;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_USED_CODE_TYPE_NOT_SUPPORTED_BY_BACK_END = 7;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL = 1;
    public static final int EXCEPTION_STATE_NO_ERROR_EXCEPTION = 0;
    public int extension1;
    public static final int EXTENSION1_MIN = 0;
    public int extension2;
    public static final int EXTENSION2_MIN = 0;

    public CurrentOnlineUpdateState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentOnlineUpdateState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.updateState = 0;
        this.updateProgress = 0;
        this.exceptionState = 0;
        this.extension1 = 0;
        this.extension2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.currentUpdateId.reset();
        this.currentPreconditionStates.reset();
        this.startTime.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status = (CurrentOnlineUpdateState_Status)bAPEntity;
        return this.updateState == currentOnlineUpdateState_Status.updateState && this.currentUpdateId.equalTo(currentOnlineUpdateState_Status.currentUpdateId) && this.currentPreconditionStates.equalTo(currentOnlineUpdateState_Status.currentPreconditionStates) && this.startTime.equalTo(currentOnlineUpdateState_Status.startTime) && this.updateProgress == currentOnlineUpdateState_Status.updateProgress && this.exceptionState == currentOnlineUpdateState_Status.exceptionState && this.extension1 == currentOnlineUpdateState_Status.extension1 && this.extension2 == currentOnlineUpdateState_Status.extension2;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CurrentOnlineUpdateState_Status");
        stringBuffer.append("\n - updateState:" + this.updateState);
        stringBuffer.append("\n - currentUpdateId:" + this.currentUpdateId.toString());
        stringBuffer.append("\n - currentPreconditionStates:" + this.currentPreconditionStates.toString());
        stringBuffer.append("\n - startTime:" + this.startTime.toString());
        stringBuffer.append("\n - updateProgress:" + this.updateProgress);
        stringBuffer.append("\n - exceptionState:" + this.exceptionState);
        stringBuffer.append("\n - extension1:" + this.extension1);
        stringBuffer.append("\n - extension2:" + this.extension2);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.updateState);
        this.currentUpdateId.serialize(bitStream);
        this.currentPreconditionStates.serialize(bitStream);
        this.startTime.serialize(bitStream);
        bitStream.pushByte((byte)this.updateProgress);
        bitStream.pushByte((byte)this.exceptionState);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
    }

    public void deserialize(BitStream bitStream) {
        this.updateState = bitStream.popFrontByte();
        this.currentUpdateId.deserialize(bitStream);
        this.currentPreconditionStates.deserialize(bitStream);
        this.startTime.deserialize(bitStream);
        this.updateProgress = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 36;
    }

    public int getFunctionId() {
        return CurrentOnlineUpdateState_Status.functionId();
    }
}

