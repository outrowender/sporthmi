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
    public static final int MOBILE_SERVICE_SUPPORT_ACTIVE_USER = 0;
    public static final int MOBILE_SERVICE_SUPPORT_REGISTER_STATE = 1;
    public static final int MOBILE_SERVICE_SUPPORT_LOCK_STATE = 2;
    public static final int MOBILE_SERVICE_SUPPORT_NETWORK_PROVIDER = 3;
    public static final int MOBILE_SERVICE_SUPPORT_SIGNAL_QUALITY = 4;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_STATE = 5;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_INFO = 6;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_DURATION_SYNC = 7;
    public static final int MOBILE_SERVICE_SUPPORT_DISCONNECT_REASON = 8;
    public static final int MOBILE_SERVICE_SUPPORT_DIAL_NUMBER = 9;
    public static final int MOBILE_SERVICE_SUPPORT_DIAL_SERVICE = 10;
    public static final int MOBILE_SERVICE_SUPPORT_CONFIRM_EMERGENCY_CALL = 11;
    public static final int MOBILE_SERVICE_SUPPORT_HANGUP_CALL = 12;
    public static final int MOBILE_SERVICE_SUPPORT_ACCEPT_CALL = 13;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_HOLD = 14;
    public static final int MOBILE_SERVICE_SUPPORT_RESUME_CALL = 15;
    public static final int MOBILE_SERVICE_SUPPORT_HANDSFREE_ON_OFF = 16;
    public static final int MOBILE_SERVICE_SUPPORT_MICRO_MUTE_ON_OFF = 17;
    public static final int MOBILE_SERVICE_SUPPORT_MP_RELEASE_ACTIVE_CALL_ACCEPT_WAITING_CALL = 18;
    public static final int MOBILE_SERVICE_SUPPORT_MP_SWAP = 19;
    public static final int MOBILE_SERVICE_SUPPORT_MP_CALL_HOLD_ACCEPT_WAITING_CALL = 20;
    public static final int MOBILE_SERVICE_SUPPORT_MP_RELEASE_ALL_CALLS_ACCEPT_WAITING_CALL = 21;
    public static final int MOBILE_SERVICE_SUPPORT_MP_SET_WAITING_CALL_ON_HOLD = 22;
    public static final int MOBILE_SERVICE_SUPPORT_CC_JOIN = 23;
    public static final int MOBILE_SERVICE_SUPPORT_CC_SPLIT = 24;
    public static final int MOBILE_SERVICE_SUPPORT_KEYPAD = 25;
    public static final int MOBILE_SERVICE_SUPPORT_MOBILE_BATTERY_LEVEL = 26;
    public static final int MOBILE_SERVICE_SUPPORT_DATA_CONNECTION_INDICATION = 27;
    public static final int MOBILE_SERVICE_SUPPORT_MISSED_CALL_INDICATION = 28;
    public static final int MOBILE_SERVICE_SUPPORT_MISSED_CALLS = 29;
    public static final int MOBILE_SERVICE_SUPPORT_RECEIVED_CALLS = 30;
    public static final int MOBILE_SERVICE_SUPPORT_DIALED_NUMBERS = 31;
    public static final int MOBILE_SERVICE_SUPPORT_COMBINED_NUMBERS = 32;
    public static final int MOBILE_SERVICE_SUPPORT_CALL_STACK_DELETE_ALL = 33;
    public static final int MOBILE_SERVICE_SUPPORT_PB_STATE = 34;
    public static final int MOBILE_SERVICE_SUPPORT_PHONEBOOK = 35;
    public static final int MOBILE_SERVICE_SUPPORT_PB_SPELLER = 36;
    public static final int MOBILE_SERVICE_SUPPORT_GET_NEXT_LIST_POS = 37;
    public static final int MOBILE_SERVICE_SUPPORT_SMS_STATE = 38;
    public static final int MOBILE_SERVICE_SUPPORT_RINGTONE_MUTE_ON_OFF = 39;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_REDIAL = 40;
    public static final int MOBILE_SERVICE_SUPPORT_AUTOMATIC_REDIAL_EXTENDED_INFO = 41;
    public static final int MOBILE_SERVICE_SUPPORT_SUPPORTED_SERVICE_NUMBERS = 42;
    public static final int MOBILE_SERVICE_SUPPORT_FAVORITE_LIST = 43;
    public static final int MOBILE_SERVICE_SUPPORT_MAX = 44;
    public static final int BATTERY_LEVEL_UNKNOWN_DEVICE_NOT_CONNECTED = 255;
    public static final int BATTERY_LEVEL_UNKNOWN_LEVEL_NOT_RECEIVED = 254;
    public static final int CALL_DURATION_NOT_AVAILABLE = 65535;

    public void updateFsgSetup(FsgSetup var1);

    public void updateFSGOperationState(int var1, boolean var2, boolean var3);

    public void updateMobileServiceSupport(boolean[] var1);

    public void updateRegisterState(int var1, int var2, int var3);

    public void updateLockState(int var1);

    public void updateNetworkProvider(int var1, String var2, int var3, String var4);

    public void updateSignalQuality(int var1);

    public void updateCallStates(CombiBAPCallState[] var1, boolean var2);

    public void updateCallInfo(CombiBAPCallInfo[] var1);

    public void updateCallDurations(CallStartTime[] var1);

    public void updateDisconnectReason(int var1);

    public void dialNumberResult(int var1);

    public void dialNumberFromAdbEntryResult(int var1);

    public void dialServiceResult(int var1);

    public void confirmEmergencyCallResult(int var1);

    public void hangupCallResult(int var1);

    public void acceptCallResult(int var1);

    public void callHoldResult(int var1);

    public void resumeCallResult(int var1);

    public void updateMicMuteState(boolean var1);

    public void releaseActiveCallAcceptWaitingCallResult(int var1);

    public void swapCallsResult(int var1);

    public void callHoldAcceptWaitingCallResult(int var1);

    public void releaseAllCallsAcceptWaitingCallResult(int var1);

    public void setWaitingCallOnHoldResult(int var1);

    public void joinCallsResult(int var1);

    public void splitCallResult(int var1);

    public void updateMobileBatteryLevel(CombiBAPhoneMobileBatteryLevel var1);

    public void updateMissedCallIndication(int var1, int var2);

    public void updateMissedCalls(CombiBAPCallStackEntry[] var1);

    public void updateReceivedCalls(CombiBAPCallStackEntry[] var1);

    public void updateDialedNumbers(CombiBAPCallStackEntry[] var1);

    public void updateCombinedNumbers(CombiBAPCallStackEntry[] var1);

    public void updateRingToneMuteState(boolean var1);

    public void updateAutomaticRedialActive(boolean var1);

    public void updateAutomaticRedialExtendedInfo(int var1, String var2, String var3, int var4);

    public void updateSupportedServiceNumbers(boolean var1, boolean var2, boolean var3, boolean var4);

    public void updateFavoriteList(CombiBAPFavoriteNumberEntry[] var1);
}

