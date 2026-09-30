/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.ecall;

import de.audi.app.bap.utils.IErrorCodes;
import de.esolutions.fw.util.commons.Buffer;

public final class ErrorCodesEcall
implements IErrorCodes {
    private static final String DESCRIPTION_APP_ERR_DATA_INVALID = "0x83 (APP_ERR_DATA_INVALID)";
    private static final String DESCRIPTION_APP_ERR_NOT_REGISTERED_EMERGENCY_CALL_ONLY = "0x8b (APP_ERR_NOT_REGISTERED_EMERGENCY_CALL_ONLY)";
    private static final String DESCRIPTION_APP_ERR_NO_INCOMING_WAITING_CALL = "0x97 (APP_ERR_NO_INCOMING_WAITING_CALL)";
    private static final String DESCRIPTION_APP_ERR_NO_CALL_RELATED_TO_CALL_ID = "0x94 (APP_ERR_NO_CALL_RELATED_TO_CALL_ID)";
    private static final String DESCRIPTION_NO_ERROR = "0x0 (NO_ERROR)";
    private static final String DESCRIPTION_APP_ERR_METHOD_ABORTED = "0x50 (APP_ERR_METHOD_ABORTED)";
    private static final String DESCRIPTION_APP_ERR_ACTIVE_CALL_PRESENT_DIALING = "0x90 (APP_ERR_ACTIVE_CALL_PRESENT_DIALING)";
    private static final String DESCRIPTION_APP_ERR_NO_ACTIVE_CALL = "0x95 (APP_ERR_NO_ACTIVE_CALL)";
    private static final String DESCRIPTION_APP_ERR_NO_REDIALNUMBER = "0x8f (APP_ERR_NO_REDIALNUMBER)";
    private static final String DESCRIPTION_APP_ERR_NO_CALL_ON_HOLD = "0x96 (APP_ERR_NO_CALL_ON_HOLD)";
    private static final String DESCRIPTION_APP_ERR_NO_NETWORK = "0x89 (APP_ERR_NO_NETWORK)";
    private static final String ERROR_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 131: {
                return DESCRIPTION_APP_ERR_DATA_INVALID;
            }
            case 139: {
                return DESCRIPTION_APP_ERR_NOT_REGISTERED_EMERGENCY_CALL_ONLY;
            }
            case 151: {
                return DESCRIPTION_APP_ERR_NO_INCOMING_WAITING_CALL;
            }
            case 148: {
                return DESCRIPTION_APP_ERR_NO_CALL_RELATED_TO_CALL_ID;
            }
            case 0: {
                return DESCRIPTION_NO_ERROR;
            }
            case 80: {
                return DESCRIPTION_APP_ERR_METHOD_ABORTED;
            }
            case 144: {
                return DESCRIPTION_APP_ERR_ACTIVE_CALL_PRESENT_DIALING;
            }
            case 149: {
                return DESCRIPTION_APP_ERR_NO_ACTIVE_CALL;
            }
            case 143: {
                return DESCRIPTION_APP_ERR_NO_REDIALNUMBER;
            }
            case 150: {
                return DESCRIPTION_APP_ERR_NO_CALL_ON_HOLD;
            }
            case 137: {
                return DESCRIPTION_APP_ERR_NO_NETWORK;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(ERROR_ID_UNKNOWN);
        return buffer.toString();
    }
}

