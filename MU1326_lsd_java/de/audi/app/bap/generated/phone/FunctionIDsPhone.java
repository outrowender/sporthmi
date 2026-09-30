/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsPhone
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_MOBILE_SERVICE_SUPPORT = "0x10 (MOBILE_SERVICE_SUPPORT)";
    private static final String DESCRIPTION_ACTIVE_USER = "0x11 (ACTIVE_USER)";
    private static final String DESCRIPTION_REGISTER_STATE = "0x12 (REGISTER_STATE)";
    private static final String DESCRIPTION_LOCK_STATE = "0x13 (LOCK_STATE)";
    private static final String DESCRIPTION_NETWORK_PROVIDER = "0x14 (NETWORK_PROVIDER)";
    private static final String DESCRIPTION_SIGNAL_QUALITY = "0x15 (SIGNAL_QUALITY)";
    private static final String DESCRIPTION_CALL_STATE = "0x16 (CALL_STATE)";
    private static final String DESCRIPTION_CALL_INFO = "0x17 (CALL_INFO)";
    private static final String DESCRIPTION_CALL_DURATION_SYNC = "0x18 (CALL_DURATION_SYNC)";
    private static final String DESCRIPTION_DISCONNECT_REASON = "0x19 (DISCONNECT_REASON)";
    private static final String DESCRIPTION_DIAL_NUMBER = "0x1a (DIAL_NUMBER)";
    private static final String DESCRIPTION_DIAL_SERVICE = "0x1b (DIAL_SERVICE)";
    private static final String DESCRIPTION_CONFIRM_EMERGENCY_CALL = "0x1c (CONFIRM_EMERGENCY_CALL)";
    private static final String DESCRIPTION_HANGUP_CALL = "0x1d (HANGUP_CALL)";
    private static final String DESCRIPTION_ACCEPT_CALL = "0x1e (ACCEPT_CALL)";
    private static final String DESCRIPTION_CALL_HOLD = "0x1f (CALL_HOLD)";
    private static final String DESCRIPTION_RESUME_CALL = "0x20 (RESUME_CALL)";
    private static final String DESCRIPTION_HANDS_FREE_ON_OFF = "0x21 (HANDS_FREE_ON_OFF)";
    private static final String DESCRIPTION_MICRO_MUTE_ON_OFF = "0x22 (MICRO_MUTE_ON_OFF)";
    private static final String DESCRIPTION_MP_REL_ACTIVE_CALL_ACCEPT_WC = "0x23 (MP_REL_ACTIVE_CALL_ACCEPT_WC)";
    private static final String DESCRIPTION_MP_SWAP = "0x24 (MP_SWAP)";
    private static final String DESCRIPTION_MP_CALL_HOLD_ACCEPT_WC = "0x25 (MP_CALL_HOLD_ACCEPT_WC)";
    private static final String DESCRIPTION_MP_REL_ALL_CALLS_ACCEPT_WC = "0x26 (MP_REL_ALL_CALLS_ACCEPT_WC)";
    private static final String DESCRIPTION_MP_SET_WAITING_CALL_ON_HOLD = "0x27 (MP_SET_WAITING_CALL_ON_HOLD)";
    private static final String DESCRIPTION_CC_JOIN = "0x28 (CC_JOIN)";
    private static final String DESCRIPTION_CC_SPLIT = "0x29 (CC_SPLIT)";
    private static final String DESCRIPTION_KEYPAD = "0x2a (KEYPAD)";
    private static final String DESCRIPTION_MOBILE_BATTERY_LEVEL = "0x2b (MOBILE_BATTERY_LEVEL)";
    private static final String DESCRIPTION_DATA_CONNECTION_INDICATION = "0x2c (DATA_CONNECTION_INDICATION)";
    private static final String DESCRIPTION_MISSED_CALL_INDICATION = "0x2d (MISSED_CALL_INDICATION)";
    private static final String DESCRIPTION_MISSED_CALLS = "0x2e (MISSED_CALLS)";
    private static final String DESCRIPTION_RECEIVED_CALLS = "0x2f (RECEIVED_CALLS)";
    private static final String DESCRIPTION_DIALED_NUMBERS = "0x30 (DIALED_NUMBERS)";
    private static final String DESCRIPTION_COMBINED_NUMBERS = "0x31 (COMBINED_NUMBERS)";
    private static final String DESCRIPTION_CALL_STACK_DELETE_ALL = "0x32 (CALL_STACK_DELETE_ALL)";
    private static final String DESCRIPTION_PB_STATE = "0x33 (PB_STATE)";
    private static final String DESCRIPTION_PHONEBOOK = "0x34 (PHONEBOOK)";
    private static final String DESCRIPTION_PB_SPELLER = "0x35 (PB_SPELLER)";
    private static final String DESCRIPTION_GET_NEXT_LIST_POS = "0x36 (GET_NEXT_LIST_POS)";
    private static final String DESCRIPTION_SMS_STATE = "0x37 (SMS_STATE)";
    private static final String DESCRIPTION_RING_TONE_MUTE_ON_OFF = "0x38 (RING_TONE_MUTE_ON_OFF)";
    private static final String DESCRIPTION_AUTOMATIC_REDIAL = "0x39 (AUTOMATIC_REDIAL)";
    private static final String DESCRIPTION_AUTOMATIC_REDIAL_EXTENDED_INFO = "0x3a (AUTOMATIC_REDIAL_EXTENDED_INFO)";
    private static final String DESCRIPTION_SUPPORTED_SERVICE_NUMBERS = "0x3b (SUPPORTED_SERVICE_NUMBERS)";
    private static final String DESCRIPTION_FAVORITE_LIST = "0x3c (FAVORITE_LIST)";
    private static final String FCT_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 2: {
                return DESCRIPTION_BAP_CONFIG;
            }
            case 3: {
                return DESCRIPTION_FUNCTION_LIST;
            }
            case 14: {
                return DESCRIPTION_FSG_SETUP;
            }
            case 15: {
                return DESCRIPTION_FSG_OPERATION_STATE;
            }
            case 16: {
                return DESCRIPTION_MOBILE_SERVICE_SUPPORT;
            }
            case 17: {
                return DESCRIPTION_ACTIVE_USER;
            }
            case 18: {
                return DESCRIPTION_REGISTER_STATE;
            }
            case 19: {
                return DESCRIPTION_LOCK_STATE;
            }
            case 20: {
                return DESCRIPTION_NETWORK_PROVIDER;
            }
            case 21: {
                return DESCRIPTION_SIGNAL_QUALITY;
            }
            case 22: {
                return DESCRIPTION_CALL_STATE;
            }
            case 23: {
                return DESCRIPTION_CALL_INFO;
            }
            case 24: {
                return DESCRIPTION_CALL_DURATION_SYNC;
            }
            case 25: {
                return DESCRIPTION_DISCONNECT_REASON;
            }
            case 26: {
                return DESCRIPTION_DIAL_NUMBER;
            }
            case 27: {
                return DESCRIPTION_DIAL_SERVICE;
            }
            case 28: {
                return DESCRIPTION_CONFIRM_EMERGENCY_CALL;
            }
            case 29: {
                return DESCRIPTION_HANGUP_CALL;
            }
            case 30: {
                return DESCRIPTION_ACCEPT_CALL;
            }
            case 31: {
                return DESCRIPTION_CALL_HOLD;
            }
            case 32: {
                return DESCRIPTION_RESUME_CALL;
            }
            case 33: {
                return DESCRIPTION_HANDS_FREE_ON_OFF;
            }
            case 34: {
                return DESCRIPTION_MICRO_MUTE_ON_OFF;
            }
            case 35: {
                return DESCRIPTION_MP_REL_ACTIVE_CALL_ACCEPT_WC;
            }
            case 36: {
                return DESCRIPTION_MP_SWAP;
            }
            case 37: {
                return DESCRIPTION_MP_CALL_HOLD_ACCEPT_WC;
            }
            case 38: {
                return DESCRIPTION_MP_REL_ALL_CALLS_ACCEPT_WC;
            }
            case 39: {
                return DESCRIPTION_MP_SET_WAITING_CALL_ON_HOLD;
            }
            case 40: {
                return DESCRIPTION_CC_JOIN;
            }
            case 41: {
                return DESCRIPTION_CC_SPLIT;
            }
            case 42: {
                return DESCRIPTION_KEYPAD;
            }
            case 43: {
                return DESCRIPTION_MOBILE_BATTERY_LEVEL;
            }
            case 44: {
                return DESCRIPTION_DATA_CONNECTION_INDICATION;
            }
            case 45: {
                return DESCRIPTION_MISSED_CALL_INDICATION;
            }
            case 46: {
                return DESCRIPTION_MISSED_CALLS;
            }
            case 47: {
                return DESCRIPTION_RECEIVED_CALLS;
            }
            case 48: {
                return DESCRIPTION_DIALED_NUMBERS;
            }
            case 49: {
                return DESCRIPTION_COMBINED_NUMBERS;
            }
            case 50: {
                return DESCRIPTION_CALL_STACK_DELETE_ALL;
            }
            case 51: {
                return DESCRIPTION_PB_STATE;
            }
            case 52: {
                return DESCRIPTION_PHONEBOOK;
            }
            case 53: {
                return DESCRIPTION_PB_SPELLER;
            }
            case 54: {
                return DESCRIPTION_GET_NEXT_LIST_POS;
            }
            case 55: {
                return DESCRIPTION_SMS_STATE;
            }
            case 56: {
                return DESCRIPTION_RING_TONE_MUTE_ON_OFF;
            }
            case 57: {
                return DESCRIPTION_AUTOMATIC_REDIAL;
            }
            case 58: {
                return DESCRIPTION_AUTOMATIC_REDIAL_EXTENDED_INFO;
            }
            case 59: {
                return DESCRIPTION_SUPPORTED_SERVICE_NUMBERS;
            }
            case 60: {
                return DESCRIPTION_FAVORITE_LIST;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

