/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_DownloadSize;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdateDomain;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdateInfo;
import de.vw.mib.bap.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdatePreconditions;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_Status
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
    public final BAPString updateId = new BAPString(21);
    private static final int MAX_UPDATEID_LENGTH = 21;
    public OnlineUpdateState_Deprecated_UpdateDomain updateDomain = new OnlineUpdateState_Deprecated_UpdateDomain();
    public OnlineUpdateState_Deprecated_UpdateInfo updateInfo = new OnlineUpdateState_Deprecated_UpdateInfo();
    public OnlineUpdateState_Deprecated_DownloadSize downloadSize = new OnlineUpdateState_Deprecated_DownloadSize();
    public OnlineUpdateState_Deprecated_UpdatePreconditions updatePreconditions = new OnlineUpdateState_Deprecated_UpdatePreconditions();
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

    public OnlineUpdateState_Deprecated_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.updateState = 0;
        this.updateProgress = 0;
        this.exceptionState = 0;
    }

    public void reset() {
        this.internalReset();
        this.updateId.reset();
        this.updateDomain.reset();
        this.updateInfo.reset();
        this.downloadSize.reset();
        this.updatePreconditions.reset();
        this.startTime.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_Status onlineUpdateState_Deprecated_Status = (OnlineUpdateState_Deprecated_Status)bAPEntity;
        return this.updateState == onlineUpdateState_Deprecated_Status.updateState && this.updateId.equalTo(onlineUpdateState_Deprecated_Status.updateId) && this.updateDomain.equalTo(onlineUpdateState_Deprecated_Status.updateDomain) && this.updateInfo.equalTo(onlineUpdateState_Deprecated_Status.updateInfo) && this.downloadSize.equalTo(onlineUpdateState_Deprecated_Status.downloadSize) && this.updatePreconditions.equalTo(onlineUpdateState_Deprecated_Status.updatePreconditions) && this.startTime.equalTo(onlineUpdateState_Deprecated_Status.startTime) && this.updateProgress == onlineUpdateState_Deprecated_Status.updateProgress && this.exceptionState == onlineUpdateState_Deprecated_Status.exceptionState;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OnlineUpdateState_Deprecated_Status");
        stringBuffer.append("\n - updateState:" + this.updateState);
        stringBuffer.append("\n - updateId:" + this.updateId.toString());
        stringBuffer.append("\n - updateDomain:" + this.updateDomain.toString());
        stringBuffer.append("\n - updateInfo:" + this.updateInfo.toString());
        stringBuffer.append("\n - downloadSize:" + this.downloadSize.toString());
        stringBuffer.append("\n - updatePreconditions:" + this.updatePreconditions.toString());
        stringBuffer.append("\n - startTime:" + this.startTime.toString());
        stringBuffer.append("\n - updateProgress:" + this.updateProgress);
        stringBuffer.append("\n - exceptionState:" + this.exceptionState);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.updateState);
        this.updateId.serialize(bitStream);
        this.updateDomain.serialize(bitStream);
        this.updateInfo.serialize(bitStream);
        this.downloadSize.serialize(bitStream);
        this.updatePreconditions.serialize(bitStream);
        this.startTime.serialize(bitStream);
        bitStream.pushByte((byte)this.updateProgress);
        bitStream.pushByte((byte)this.exceptionState);
    }

    public void deserialize(BitStream bitStream) {
        this.updateState = bitStream.popFrontByte();
        this.updateId.deserialize(bitStream);
        this.updateDomain.deserialize(bitStream);
        this.updateInfo.deserialize(bitStream);
        this.downloadSize.deserialize(bitStream);
        this.updatePreconditions.deserialize(bitStream);
        this.startTime.deserialize(bitStream);
        this.updateProgress = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    public int getFunctionId() {
        return OnlineUpdateState_Deprecated_Status.functionId();
    }
}

