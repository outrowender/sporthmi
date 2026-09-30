/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessState_Status
implements StatusProperty {
    public int commandType;
    public static final int COMMAND_TYPE_ONLINE_LOGBOOK_TRIP_CONTROL_DF3_6 = 28;
    public static final int COMMAND_TYPE_CONFIRM_FO_D_DEACTIVATION_DF3_6 = 27;
    public static final int COMMAND_TYPE_CONFIRM_FO_D_ACTIVATION_DF3_6 = 26;
    public static final int COMMAND_TYPE_SUBMIT_CHANGES_TO_BACKEND_DF3_6 = 25;
    public static final int COMMAND_TYPE_CONFIRM_WITHDRAWN_UPDATE_DF3_6 = 24;
    public static final int COMMAND_TYPE_SIGN_UP_AS_MY_AUDI_VW_CAR_NET_VW_FLEET_USER_PAIRING_CODE_DF3_6 = 23;
    public static final int COMMAND_TYPE_SIGN_UP_AS_MY_AUDI_VW_CAR_NET_VW_FLEET_USER_PASSWORD_DF3_6 = 22;
    public static final int COMMAND_TYPE_CONFIRM_UPDATE_ERROR_DF3_6 = 21;
    public static final int COMMAND_TYPE_CONFIRM_ECU_UPDATE_FINISHED_SUCCESSFULLY_DF3_6 = 20;
    public static final int COMMAND_TYPE_GET_CHALLENGE_DF3_6 = 19;
    public static final int COMMAND_TYPE_DEACTIVATE_ACTIVATE_PRIVACY_MODE_DF3_5 = 18;
    public static final int COMMAND_TYPE_DEACTIVATE_ACTIVATE_RADIO_MODULE_DF3_5 = 17;
    public static final int COMMAND_TYPE_REQUEST_NEW_LANGUAGE_DF3_4 = 16;
    public static final int COMMAND_TYPE_POSTPONE_ECU_UPDATE_DF3_4 = 15;
    public static final int COMMAND_TYPE_REJECT_ECU_UPDATE_DF3_4 = 14;
    public static final int COMMAND_TYPE_CONFIRM_ECU_UPDATE_DF3_4 = 13;
    public static final int COMMAND_TYPE_AUTHENTICATE_MAIN_USER_S_PIN_DF3_4 = 12;
    public static final int COMMAND_TYPE_POSTPONE_ONLINE_UPDATE_DOWNLOAD_DF3_4 = 11;
    public static final int COMMAND_TYPE_REJECT_ONLINE_UPDATE_DOWNLOAD_DF3_4 = 10;
    public static final int COMMAND_TYPE_CONFIRM_ONLINE_UPDATE_DOWNLOAD_DF3_4 = 9;
    public static final int COMMAND_TYPE_GET_V_TAN_DF3_4 = 8;
    public static final int COMMAND_TYPE_GET_MOBILE_DEVICE_KEY_COUNT_DF3_4 = 7;
    public static final int COMMAND_TYPE_CONFIRM_SERVICE_EXPIRY_WARNING = 5;
    public static final int COMMAND_TYPE_PAIR_MAIN_USER_VEHICLE_PIN = 4;
    public static final int COMMAND_TYPE_PAIR_MAIN_USER_PAIRING_CODE = 3;
    public static final int COMMAND_TYPE_REMOTE_DELETE_USER_LIST = 2;
    public static final int COMMAND_TYPE_REMOTE_UPDATE_USER_LIST = 1;
    public static final int COMMAND_TYPE_NO_ACTIVITY_DEAFULT_VALUE = 0;
    public int processState;
    public static final int PROCESS_STATE_DATA_AVAILABLE_IN_FSG_DF3_4 = 10;
    public static final int PROCESS_STATE_TERMINATED_BY_USER = 9;
    public static final int PROCESS_STATE_DATA_TRANSMISSION = 8;
    public static final int PROCESS_STATE_WAITING_FOR_AUTHENTICATION = 7;
    public static final int PROCESS_STATE_CONNECTING_TO_SERVER = 6;
    public static final int PROCESS_STATE_SEARCHING_FOR_NETWORK = 5;
    public static final int PROCESS_STATE_REQUEST_FAILED_DETAILS_IN_EXCEPTION_STATE = 4;
    public static final int PROCESS_STATE_REQUEST_SUCCESSFUL = 3;
    public static final int PROCESS_STATE_REQUEST_IN_PROGRESS_RESPONSE_PENDING = 2;
    public static final int PROCESS_STATE_NO_REQUEST_ACTIVE_DEFAULT_DURING_NORMAL_OPERATION = 1;
    public static final int PROCESS_STATE_NO_INFORMATION_DEFAULT_DURING_STARTUP = 0;
    public int exceptionState;
    public static final int EXCEPTION_STATE_SPIN_TEMPORARY_LOCKED_FOR_DURATION_SEE_ADDITIONAL_DATA_DF3_6 = 28;
    public static final int EXCEPTION_STATE_VTAN_EXPIRED_DF3_4 = 27;
    public static final int EXCEPTION_STATE_VTAN_NOT_AVAILABLE_DF3_4 = 26;
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
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_PARAMETER_MISMATCH_PARM1_3_FAULTY = 8;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL_USED_CODE_TYPE_NOT_SUPPORTED_BY_BACK_END = 7;
    public static final int EXCEPTION_STATE_NOT_SUCCESSFUL = 1;
    public static final int EXCEPTION_STATE_NO_ERROR_EXCEPTION = 0;
    public int additionalData;
    public static final int ADDITIONAL_DATA_MIN = 0;

    public RemoteProcessState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.commandType = 0;
        this.processState = 0;
        this.exceptionState = 0;
        this.additionalData = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessState_Status remoteProcessState_Status = (RemoteProcessState_Status)bAPEntity;
        return this.commandType == remoteProcessState_Status.commandType && this.processState == remoteProcessState_Status.processState && this.exceptionState == remoteProcessState_Status.exceptionState && this.additionalData == remoteProcessState_Status.additionalData;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RemoteProcessState_Status");
        stringBuffer.append("\n - commandType:" + this.commandType);
        stringBuffer.append("\n - processState:" + this.processState);
        stringBuffer.append("\n - exceptionState:" + this.exceptionState);
        stringBuffer.append("\n - additionalData:" + this.additionalData);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.commandType);
        bitStream.pushByte((byte)this.processState);
        bitStream.pushByte((byte)this.exceptionState);
        bitStream.pushByte((byte)this.additionalData);
    }

    public void deserialize(BitStream bitStream) {
        this.commandType = bitStream.popFrontByte();
        this.processState = bitStream.popFrontByte();
        this.exceptionState = bitStream.popFrontByte();
        this.additionalData = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    public int getFunctionId() {
        return RemoteProcessState_Status.functionId();
    }
}

