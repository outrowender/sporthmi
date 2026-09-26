/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.phone.data.CallStartTime;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallInfo;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallState;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPhoneMobileBatteryLevel;
import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup;

public interface CombiBAPServicePhone
extends CombiBAPService {
    public static final int MOBILE_SERVICE_SUPPORT_ACTIVE_USER;
    public static final int MOBILE_SERVICE_SUPPORT_REGISTER_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_LOCK_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_NETWORK_PROVIDER;
    public static final int MOBILE_SERVICE_SUPPORT_SIGNAL_QUALITY;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_INFO;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_DURATION_SYNC;
    public static final int MOBILE_SERVICE_SUPPORT_DISCONNECT_REASON;
    public static final int MOBILE_SERVICE_SUPPORT_DIAL_NUMBER;
    public static final int MOBILE_SERVICE_SUPPORT_DIAL_SERVICE;
    public static final int MOBILE_SERVICE_SUPPORT_CONFIRM_EMERGENCY_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_HANGUP_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_ACCEPT_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_HOLD;
    public static final int MOBILE_SERVICE_SUPPORT_RESUME_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_HANDSFREE_ON_OFF;
    public static final int MOBILE_SERVICE_SUPPORT_MICRO_MUTE_ON_OFF;
    public static final int MOBILE_SERVICE_SUPPORT_MP_RELEASE_ACTIVE_CALL_ACCEPT_WAITING_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_MP_SWAP;
    public static final int MOBILE_SERVICE_SUPPORT_MP_CALL_HOLD_ACCEPT_WAITING_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_MP_RELEASE_ALL_CALLS_ACCEPT_WAITING_CALL;
    public static final int MOBILE_SERVICE_SUPPORT_MP_SET_WAITING_CALL_ON_HOLD;
    public static final int MOBILE_SERVICE_SUPPORT_CC_JOIN;
    public static final int MOBILE_SERVICE_SUPPORT_CC_SPLIT;
    public static final int MOBILE_SERVICE_SUPPORT_KEYPAD;
    public static final int MOBILE_SERVICE_SUPPORT_MOBILE_BATTERY_LEVEL;
    public static final int MOBILE_SERVICE_SUPPORT_DATA_CONNECTION_INDICATION;
    public static final int MOBILE_SERVICE_SUPPORT_MISSED_CALL_INDICATION;
    public static final int MOBILE_SERVICE_SUPPORT_MISSED_CALLS;
    public static final int MOBILE_SERVICE_SUPPORT_RECEIVED_CALLS;
    public static final int MOBILE_SERVICE_SUPPORT_DIALED_NUMBERS;
    public static final int MOBILE_SERVICE_SUPPORT_COMBINED_NUMBERS;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_STACK_DELETE_ALL;
    public static final int MOBILE_SERVICE_SUPPORT_PB_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_PHONEBOOK;
    public static final int MOBILE_SERVICE_SUPPORT_PB_SPELLER;
    public static final int MOBILE_SERVICE_SUPPORT_GET_NEXT_LIST_POS;
    public static final int MOBILE_SERVICE_SUPPORT_SMS_STATE;
    public static final int MOBILE_SERVICE_SUPPORT_RINGTONE_MUTE_ON_OFF;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_REDIAL;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_REDIAL_EXTENDED_INFO;
    public static final int MOBILE_SERVICE_SUPPORT_SUPPORTED_SERVICE_NUMBERS;
    public static final int MOBILE_SERVICE_SUPPORT_FAVORITE_LIST;
    public static final int MOBILE_SERVICE_SUPPORT_MAX;
    public static final int BATTERY_LEVEL_UNKNOWN_DEVICE_NOT_CONNECTED;
    public static final int BATTERY_LEVEL_UNKNOWN_LEVEL_NOT_RECEIVED;
    public static final int CALL_DURATION_NOT_AVAILABLE;

    default public void updateFsgSetup(FsgSetup fsgSetup) {
    }

    default public void updateFSGOperationState(int n, boolean bl, boolean bl2) {
    }

    default public void updateMobileServiceSupport(boolean[] blArray) {
    }

    default public void updateRegisterState(int n, int n2, int n3) {
    }

    default public void updateLockState(int n) {
    }

    default public void updateNetworkProvider(int n, String string, int n2, String string2) {
    }

    default public void updateSignalQuality(int n) {
    }

    default public void updateCallStates(CombiBAPCallState[] combiBAPCallStateArray, boolean bl) {
    }

    default public void updateCallInfo(CombiBAPCallInfo[] combiBAPCallInfoArray) {
    }

    default public void updateCallDurations(CallStartTime[] callStartTimeArray) {
    }

    default public void updateDisconnectReason(int n) {
    }

    default public void dialNumberResult(int n) {
    }

    default public void dialNumberFromAdbEntryResult(int n) {
    }

    default public void dialServiceResult(int n) {
    }

    default public void confirmEmergencyCallResult(int n) {
    }

    default public void hangupCallResult(int n) {
    }

    default public void acceptCallResult(int n) {
    }

    default public void callHoldResult(int n) {
    }

    default public void resumeCallResult(int n) {
    }

    default public void updateMicMuteState(boolean bl) {
    }

    default public void releaseActiveCallAcceptWaitingCallResult(int n) {
    }

    default public void swapCallsResult(int n) {
    }

    default public void callHoldAcceptWaitingCallResult(int n) {
    }

    default public void releaseAllCallsAcceptWaitingCallResult(int n) {
    }

    default public void setWaitingCallOnHoldResult(int n) {
    }

    default public void joinCallsResult(int n) {
    }

    default public void splitCallResult(int n) {
    }

    default public void updateMobileBatteryLevel(CombiBAPhoneMobileBatteryLevel combiBAPhoneMobileBatteryLevel) {
    }

    default public void updateMissedCallIndication(int n, int n2) {
    }

    default public void updateMissedCalls(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
    }

    default public void updateReceivedCalls(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
    }

    default public void updateDialedNumbers(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
    }

    default public void updateCombinedNumbers(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
    }

    default public void updateRingToneMuteState(boolean bl) {
    }

    default public void updateAutomaticRedialActive(boolean bl) {
    }

    default public void updateAutomaticRedialExtendedInfo(int n, String string, String string2, int n2) {
    }

    default public void updateSupportedServiceNumbers(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void updateFavoriteList(CombiBAPFavoriteNumberEntry[] combiBAPFavoriteNumberEntryArray) {
    }
}

