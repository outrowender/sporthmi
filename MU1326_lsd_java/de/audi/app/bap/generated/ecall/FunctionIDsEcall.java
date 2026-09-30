/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.ecall;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsEcall
implements IFunctionIDs {
    private static final String DESCRIPTION_GET_ALL = "0x1 (GET_ALL)";
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_CONTROL = "0xd (FSG_CONTROL)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_AUDIO_STATE = "0x10 (AUDIO_STATE)";
    private static final String DESCRIPTION_CALL_STATE = "0x11 (CALL_STATE)";
    private static final String DESCRIPTION_HANGUP_CALL = "0x12 (HANGUP_CALL)";
    private static final String DESCRIPTION_ACCEPT_CALL = "0x13 (ACCEPT_CALL)";
    private static final String DESCRIPTION_DISCONNECT_REASON = "0x14 (DISCONNECT_REASON)";
    private static final String DESCRIPTION_REGISTER_STATE = "0x15 (REGISTER_STATE)";
    private static final String DESCRIPTION_NETWORK_PROVIDER = "0x16 (NETWORK_PROVIDER)";
    private static final String DESCRIPTION_SIGNAL_QUALITY = "0x17 (SIGNAL_QUALITY)";
    private static final String DESCRIPTION_SERVICE_REQUEST = "0x18 (SERVICE_REQUEST)";
    private static final String DESCRIPTION_SERVICE_CONTROL = "0x19 (SERVICE_CONTROL)";
    private static final String DESCRIPTION_SERVICE_STATE = "0x1a (SERVICE_STATE)";
    private static final String DESCRIPTION_SUPPORTED_SERVICES = "0x1b (SUPPORTED_SERVICES)";
    private static final String DESCRIPTION_FUNCTIONAL_RESTRICTIONS = "0x1c (FUNCTIONAL_RESTRICTIONS)";
    private static final String DESCRIPTION_ALLOWED_EMERGENCY_NUMBERS = "0x1d (ALLOWED_EMERGENCY_NUMBERS)";
    private static final String DESCRIPTION_DIAL_NUMBER = "0x1e (DIAL_NUMBER)";
    private static final String DESCRIPTION_DISASTER_WARNING = "0x1f (DISASTER_WARNING)";
    private static final String FCT_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 1: {
                return DESCRIPTION_GET_ALL;
            }
            case 2: {
                return DESCRIPTION_BAP_CONFIG;
            }
            case 3: {
                return DESCRIPTION_FUNCTION_LIST;
            }
            case 13: {
                return DESCRIPTION_FSG_CONTROL;
            }
            case 14: {
                return DESCRIPTION_FSG_SETUP;
            }
            case 15: {
                return DESCRIPTION_FSG_OPERATION_STATE;
            }
            case 16: {
                return DESCRIPTION_AUDIO_STATE;
            }
            case 17: {
                return DESCRIPTION_CALL_STATE;
            }
            case 18: {
                return DESCRIPTION_HANGUP_CALL;
            }
            case 19: {
                return DESCRIPTION_ACCEPT_CALL;
            }
            case 20: {
                return DESCRIPTION_DISCONNECT_REASON;
            }
            case 21: {
                return DESCRIPTION_REGISTER_STATE;
            }
            case 22: {
                return DESCRIPTION_NETWORK_PROVIDER;
            }
            case 23: {
                return DESCRIPTION_SIGNAL_QUALITY;
            }
            case 24: {
                return DESCRIPTION_SERVICE_REQUEST;
            }
            case 25: {
                return DESCRIPTION_SERVICE_CONTROL;
            }
            case 26: {
                return DESCRIPTION_SERVICE_STATE;
            }
            case 27: {
                return DESCRIPTION_SUPPORTED_SERVICES;
            }
            case 28: {
                return DESCRIPTION_FUNCTIONAL_RESTRICTIONS;
            }
            case 29: {
                return DESCRIPTION_ALLOWED_EMERGENCY_NUMBERS;
            }
            case 30: {
                return DESCRIPTION_DIAL_NUMBER;
            }
            case 31: {
                return DESCRIPTION_DISASTER_WARNING;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

