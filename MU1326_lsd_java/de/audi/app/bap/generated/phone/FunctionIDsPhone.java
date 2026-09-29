/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsPhone
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_MOBILE_SERVICE_SUPPORT;
    private static final String DESCRIPTION_ACTIVE_USER;
    private static final String DESCRIPTION_REGISTER_STATE;
    private static final String DESCRIPTION_LOCK_STATE;
    private static final String DESCRIPTION_NETWORK_PROVIDER;
    private static final String DESCRIPTION_SIGNAL_QUALITY;
    private static final String DESCRIPTION_CALL_STATE;
    private static final String DESCRIPTION_CALL_INFO;
    private static final String DESCRIPTION_CALL_DURATION_SYNC;
    private static final String DESCRIPTION_DISCONNECT_REASON;
    private static final String DESCRIPTION_DIAL_NUMBER;
    private static final String DESCRIPTION_DIAL_SERVICE;
    private static final String DESCRIPTION_CONFIRM_EMERGENCY_CALL;
    private static final String DESCRIPTION_HANGUP_CALL;
    private static final String DESCRIPTION_ACCEPT_CALL;
    private static final String DESCRIPTION_CALL_HOLD;
    private static final String DESCRIPTION_RESUME_CALL;
    private static final String DESCRIPTION_HANDS_FREE_ON_OFF;
    private static final String DESCRIPTION_MICRO_MUTE_ON_OFF;
    private static final String DESCRIPTION_MP_REL_ACTIVE_CALL_ACCEPT_WC;
    private static final String DESCRIPTION_MP_SWAP;
    private static final String DESCRIPTION_MP_CALL_HOLD_ACCEPT_WC;
    private static final String DESCRIPTION_MP_REL_ALL_CALLS_ACCEPT_WC;
    private static final String DESCRIPTION_MP_SET_WAITING_CALL_ON_HOLD;
    private static final String DESCRIPTION_CC_JOIN;
    private static final String DESCRIPTION_CC_SPLIT;
    private static final String DESCRIPTION_KEYPAD;
    private static final String DESCRIPTION_MOBILE_BATTERY_LEVEL;
    private static final String DESCRIPTION_DATA_CONNECTION_INDICATION;
    private static final String DESCRIPTION_MISSED_CALL_INDICATION;
    private static final String DESCRIPTION_MISSED_CALLS;
    private static final String DESCRIPTION_RECEIVED_CALLS;
    private static final String DESCRIPTION_DIALED_NUMBERS;
    private static final String DESCRIPTION_COMBINED_NUMBERS;
    private static final String DESCRIPTION_CALL_STACK_DELETE_ALL;
    private static final String DESCRIPTION_PB_STATE;
    private static final String DESCRIPTION_PHONEBOOK;
    private static final String DESCRIPTION_PB_SPELLER;
    private static final String DESCRIPTION_GET_NEXT_LIST_POS;
    private static final String DESCRIPTION_SMS_STATE;
    private static final String DESCRIPTION_RING_TONE_MUTE_ON_OFF;
    private static final String DESCRIPTION_AUTOMATIC_REDIAL;
    private static final String DESCRIPTION_AUTOMATIC_REDIAL_EXTENDED_INFO;
    private static final String DESCRIPTION_SUPPORTED_SERVICE_NUMBERS;
    private static final String DESCRIPTION_FAVORITE_LIST;
    private static final String FCT_ID_UNKNOWN;

    @Override
    public String getDescription(int n) {
        switch (n) {
            case 2: {
                return "0x2 (BAP_CONFIG)";
            }
            case 3: {
                return "0x3 (FUNCTION_LIST)";
            }
            case 14: {
                return "0xe (FSG_SETUP)";
            }
            case 15: {
                return "0xf (FSG_OPERATION_STATE)";
            }
            case 16: {
                return "0x10 (MOBILE_SERVICE_SUPPORT)";
            }
            case 17: {
                return "0x11 (ACTIVE_USER)";
            }
            case 18: {
                return "0x12 (REGISTER_STATE)";
            }
            case 19: {
                return "0x13 (LOCK_STATE)";
            }
            case 20: {
                return "0x14 (NETWORK_PROVIDER)";
            }
            case 21: {
                return "0x15 (SIGNAL_QUALITY)";
            }
            case 22: {
                return "0x16 (CALL_STATE)";
            }
            case 23: {
                return "0x17 (CALL_INFO)";
            }
            case 24: {
                return "0x18 (CALL_DURATION_SYNC)";
            }
            case 25: {
                return "0x19 (DISCONNECT_REASON)";
            }
            case 26: {
                return "0x1a (DIAL_NUMBER)";
            }
            case 27: {
                return "0x1b (DIAL_SERVICE)";
            }
            case 28: {
                return "0x1c (CONFIRM_EMERGENCY_CALL)";
            }
            case 29: {
                return "0x1d (HANGUP_CALL)";
            }
            case 30: {
                return "0x1e (ACCEPT_CALL)";
            }
            case 31: {
                return "0x1f (CALL_HOLD)";
            }
            case 32: {
                return "0x20 (RESUME_CALL)";
            }
            case 33: {
                return "0x21 (HANDS_FREE_ON_OFF)";
            }
            case 34: {
                return "0x22 (MICRO_MUTE_ON_OFF)";
            }
            case 35: {
                return "0x23 (MP_REL_ACTIVE_CALL_ACCEPT_WC)";
            }
            case 36: {
                return "0x24 (MP_SWAP)";
            }
            case 37: {
                return "0x25 (MP_CALL_HOLD_ACCEPT_WC)";
            }
            case 38: {
                return "0x26 (MP_REL_ALL_CALLS_ACCEPT_WC)";
            }
            case 39: {
                return "0x27 (MP_SET_WAITING_CALL_ON_HOLD)";
            }
            case 40: {
                return "0x28 (CC_JOIN)";
            }
            case 41: {
                return "0x29 (CC_SPLIT)";
            }
            case 42: {
                return "0x2a (KEYPAD)";
            }
            case 43: {
                return "0x2b (MOBILE_BATTERY_LEVEL)";
            }
            case 44: {
                return "0x2c (DATA_CONNECTION_INDICATION)";
            }
            case 45: {
                return "0x2d (MISSED_CALL_INDICATION)";
            }
            case 46: {
                return "0x2e (MISSED_CALLS)";
            }
            case 47: {
                return "0x2f (RECEIVED_CALLS)";
            }
            case 48: {
                return "0x30 (DIALED_NUMBERS)";
            }
            case 49: {
                return "0x31 (COMBINED_NUMBERS)";
            }
            case 50: {
                return "0x32 (CALL_STACK_DELETE_ALL)";
            }
            case 51: {
                return "0x33 (PB_STATE)";
            }
            case 52: {
                return "0x34 (PHONEBOOK)";
            }
            case 53: {
                return "0x35 (PB_SPELLER)";
            }
            case 54: {
                return "0x36 (GET_NEXT_LIST_POS)";
            }
            case 55: {
                return "0x37 (SMS_STATE)";
            }
            case 56: {
                return "0x38 (RING_TONE_MUTE_ON_OFF)";
            }
            case 57: {
                return "0x39 (AUTOMATIC_REDIAL)";
            }
            case 58: {
                return "0x3a (AUTOMATIC_REDIAL_EXTENDED_INFO)";
            }
            case 59: {
                return "0x3b (SUPPORTED_SERVICE_NUMBERS)";
            }
            case 60: {
                return "0x3c (FAVORITE_LIST)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

