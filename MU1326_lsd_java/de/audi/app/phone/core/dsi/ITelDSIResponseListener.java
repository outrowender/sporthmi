/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface ITelDSIResponseListener {
    public static final int DSI_ERROR = 0;
    public static final int INTERNAL_ERROR = 65536;
    public static final int INTERNAL_COMMAND_ERROR = 65537;
    public static final int INTERNAL_COMMAND_NOP = 65538;
    public static final int INTERNAL_DIAL_NUMBER_INVALID_STRING = 65539;
    public static final int INTERNAL_DIAL_NUMBER_NOT_POSSIBLE = 65540;
    public static final int INTERNAL_DIAL_NUMBER_NOT_POSSIBLE_OPERATOR_CALL_ACTIVE = 65541;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_NOSUP_PHONE = 2;
    public static final int RESULT_ERROR_NOSUP_NW = 3;
    public static final int RESULT_ERROR_UNSPECIFIED = 4;
    public static final int RESULT_ERROR_CODE_WRONG = 5;
    public static final int RESULT_ERROR_SERV_BUSY = 6;
    public static final int RESULT_ERROR_NOT_ALLOWED = 7;
    public static final int RESULT_ERROR_SIM_FAILURE = 8;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT = 9;
    public static final int RESULT_ERROR_STRING_TOO_LONG = 11;
    public static final int RESULT_ERROR_NO_NW_REPLY = 12;
    public static final int RESULT_ERROR_NO_NW_ACCESS = 13;
    public static final int RESULT_ERROR_INVALID_CALL_ID = 14;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED = 15;
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED = 16;

    public void responseAbortNetworkRegistration(int var1, int var2);

    public void responseAbortNetworkSearch(int var1, int var2);

    public void responseAcceptCall(int var1, int var2);

    public void responseCallForward(CFResponseData[] var1, int var2, int var3);

    public void responseCallWaiting(int var1, int var2, int var3, int var4);

    public void responseChangeSIMCode(int var1, int var2, int var3);

    public void responseCLIR(int var1, int var2, int var3, int var4);

    public void responseDialNumber(int var1, int var2, SuppServiceResponseStruct var3, int var4);

    public void responseDialOperator(int var1, SuppServiceResponseStruct var2, int var3);

    public void responseHangupCall(int var1, int var2);

    public void responseJoinCalls(int var1, int var2);

    public void responseNetworkRegistration(int var1, int var2);

    public void responseNetworkSearch(NetworkProvider[] var1, int var2, int var3);

    public void responseRestoreFactorySettings(int var1, int var2);

    public void responseSendDTMF(int var1, int var2);

    public void responseServiceCodeAbort(int var1, int var2);

    public void responseSetAutomaticEmergencyCallActive(int var1, int var2);

    public void responseSetAutomaticPinEntryActive(int var1, int var2);

    public void responseSetAutomaticRedialActive(int var1, int var2);

    public void responseSetCDMAThreeWayCallingSetting(int var1, int var2);

    public void responseSetESIMActive(int var1, int var2);

    public void responseSetHandsFreeMode(int var1, int var2);

    public void responseSetMailboxContent(int var1, int var2);

    public void responseSetMICMuteState(int var1, int var2);

    public void responseSetNADMode(int var1, int var2, int var3);

    public void responseSetOptimizationMode(int var1, int var2, int var3);

    public void responseSetPhoneReminderSetting(int var1, int var2);

    public void responseSetPhoneRingtone(int var1, int var2);

    public void responseSetPrivacyMode(int var1, int var2);

    public void responseSIMPINRequired(int var1, int var2);

    public void responseSplitCall(int var1, int var2);

    public void responseSwapCalls(int var1, int var2);

    public void responseTelPower(int var1, int var2);

    public void responseUnlockOtherSIM(int var1, int var2);

    public void responseUnlockSIM(int var1, int var2, LockStateStruct var3);

    public void responseChangeTopology(int var1, int var2);

    public void responseSetSIMAliases(int var1, int var2);

    public void responseCheckSIMPINCode(int var1, int var2);

    public void responseRemoveOtherSIM(int var1, int var2);
}

