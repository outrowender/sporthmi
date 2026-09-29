/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface ITelDSIResponseListener {
    public static final int DSI_ERROR;
    public static final int INTERNAL_ERROR;
    public static final int INTERNAL_COMMAND_ERROR;
    public static final int INTERNAL_COMMAND_NOP;
    public static final int INTERNAL_DIAL_NUMBER_INVALID_STRING;
    public static final int INTERNAL_DIAL_NUMBER_NOT_POSSIBLE;
    public static final int INTERNAL_DIAL_NUMBER_NOT_POSSIBLE_OPERATOR_CALL_ACTIVE;
    public static final int RESULT_OK;
    public static final int RESULT_ABORTED;
    public static final int RESULT_ERROR_NOSUP_PHONE;
    public static final int RESULT_ERROR_NOSUP_NW;
    public static final int RESULT_ERROR_UNSPECIFIED;
    public static final int RESULT_ERROR_CODE_WRONG;
    public static final int RESULT_ERROR_SERV_BUSY;
    public static final int RESULT_ERROR_NOT_ALLOWED;
    public static final int RESULT_ERROR_SIM_FAILURE;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT;
    public static final int RESULT_ERROR_STRING_TOO_LONG;
    public static final int RESULT_ERROR_NO_NW_REPLY;
    public static final int RESULT_ERROR_NO_NW_ACCESS;
    public static final int RESULT_ERROR_INVALID_CALL_ID;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED;
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED;

    default public void responseAbortNetworkRegistration(int n, int n2) {
    }

    default public void responseAbortNetworkSearch(int n, int n2) {
    }

    default public void responseAcceptCall(int n, int n2) {
    }

    default public void responseCallForward(CFResponseData[] cFResponseDataArray, int n, int n2) {
    }

    default public void responseCallWaiting(int n, int n2, int n3, int n4) {
    }

    default public void responseChangeSIMCode(int n, int n2, int n3) {
    }

    default public void responseCLIR(int n, int n2, int n3, int n4) {
    }

    default public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
    }

    default public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct, int n2) {
    }

    default public void responseHangupCall(int n, int n2) {
    }

    default public void responseJoinCalls(int n, int n2) {
    }

    default public void responseNetworkRegistration(int n, int n2) {
    }

    default public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n, int n2) {
    }

    default public void responseRestoreFactorySettings(int n, int n2) {
    }

    default public void responseSendDTMF(int n, int n2) {
    }

    default public void responseServiceCodeAbort(int n, int n2) {
    }

    default public void responseSetAutomaticEmergencyCallActive(int n, int n2) {
    }

    default public void responseSetAutomaticPinEntryActive(int n, int n2) {
    }

    default public void responseSetAutomaticRedialActive(int n, int n2) {
    }

    default public void responseSetCDMAThreeWayCallingSetting(int n, int n2) {
    }

    default public void responseSetESIMActive(int n, int n2) {
    }

    default public void responseSetHandsFreeMode(int n, int n2) {
    }

    default public void responseSetMailboxContent(int n, int n2) {
    }

    default public void responseSetMICMuteState(int n, int n2) {
    }

    default public void responseSetNADMode(int n, int n2, int n3) {
    }

    default public void responseSetOptimizationMode(int n, int n2, int n3) {
    }

    default public void responseSetPhoneReminderSetting(int n, int n2) {
    }

    default public void responseSetPhoneRingtone(int n, int n2) {
    }

    default public void responseSetPrivacyMode(int n, int n2) {
    }

    default public void responseSIMPINRequired(int n, int n2) {
    }

    default public void responseSplitCall(int n, int n2) {
    }

    default public void responseSwapCalls(int n, int n2) {
    }

    default public void responseTelPower(int n, int n2) {
    }

    default public void responseUnlockOtherSIM(int n, int n2) {
    }

    default public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
    }

    default public void responseChangeTopology(int n, int n2) {
    }

    default public void responseSetSIMAliases(int n, int n2) {
    }

    default public void responseCheckSIMPINCode(int n, int n2) {
    }

    default public void responseRemoveOtherSIM(int n, int n2) {
    }
}

