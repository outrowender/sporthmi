/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.ecall;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsEcall
implements IFunctionIDs {
    private static final String DESCRIPTION_GET_ALL;
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_CONTROL;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_AUDIO_STATE;
    private static final String DESCRIPTION_CALL_STATE;
    private static final String DESCRIPTION_HANGUP_CALL;
    private static final String DESCRIPTION_ACCEPT_CALL;
    private static final String DESCRIPTION_DISCONNECT_REASON;
    private static final String DESCRIPTION_REGISTER_STATE;
    private static final String DESCRIPTION_NETWORK_PROVIDER;
    private static final String DESCRIPTION_SIGNAL_QUALITY;
    private static final String DESCRIPTION_SERVICE_REQUEST;
    private static final String DESCRIPTION_SERVICE_CONTROL;
    private static final String DESCRIPTION_SERVICE_STATE;
    private static final String DESCRIPTION_SUPPORTED_SERVICES;
    private static final String DESCRIPTION_FUNCTIONAL_RESTRICTIONS;
    private static final String DESCRIPTION_ALLOWED_EMERGENCY_NUMBERS;
    private static final String DESCRIPTION_DIAL_NUMBER;
    private static final String DESCRIPTION_DISASTER_WARNING;
    private static final String FCT_ID_UNKNOWN;

    @Override
    public String getDescription(int n) {
        switch (n) {
            case 1: {
                return "0x1 (GET_ALL)";
            }
            case 2: {
                return "0x2 (BAP_CONFIG)";
            }
            case 3: {
                return "0x3 (FUNCTION_LIST)";
            }
            case 13: {
                return "0xd (FSG_CONTROL)";
            }
            case 14: {
                return "0xe (FSG_SETUP)";
            }
            case 15: {
                return "0xf (FSG_OPERATION_STATE)";
            }
            case 16: {
                return "0x10 (AUDIO_STATE)";
            }
            case 17: {
                return "0x11 (CALL_STATE)";
            }
            case 18: {
                return "0x12 (HANGUP_CALL)";
            }
            case 19: {
                return "0x13 (ACCEPT_CALL)";
            }
            case 20: {
                return "0x14 (DISCONNECT_REASON)";
            }
            case 21: {
                return "0x15 (REGISTER_STATE)";
            }
            case 22: {
                return "0x16 (NETWORK_PROVIDER)";
            }
            case 23: {
                return "0x17 (SIGNAL_QUALITY)";
            }
            case 24: {
                return "0x18 (SERVICE_REQUEST)";
            }
            case 25: {
                return "0x19 (SERVICE_CONTROL)";
            }
            case 26: {
                return "0x1a (SERVICE_STATE)";
            }
            case 27: {
                return "0x1b (SUPPORTED_SERVICES)";
            }
            case 28: {
                return "0x1c (FUNCTIONAL_RESTRICTIONS)";
            }
            case 29: {
                return "0x1d (ALLOWED_EMERGENCY_NUMBERS)";
            }
            case 30: {
                return "0x1e (DIAL_NUMBER)";
            }
            case 31: {
                return "0x1f (DISASTER_WARNING)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

