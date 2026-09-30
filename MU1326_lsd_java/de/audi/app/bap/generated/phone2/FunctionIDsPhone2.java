/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsPhone2
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_MOBILE_SERVICE_SUPPORT = "0x10 (MOBILE_SERVICE_SUPPORT)";
    private static final String DESCRIPTION_REGISTER_STATE2 = "0x11 (REGISTER_STATE2)";
    private static final String DESCRIPTION_LOCK_STATE2 = "0x12 (LOCK_STATE2)";
    private static final String DESCRIPTION_NETWORK_PROVIDER2 = "0x13 (NETWORK_PROVIDER2)";
    private static final String DESCRIPTION_SIGNAL_QUALITY2 = "0x14 (SIGNAL_QUALITY2)";
    private static final String DESCRIPTION_DATA_CONNECTION_INDICATION2 = "0x15 (DATA_CONNECTION_INDICATION2)";
    private static final String DESCRIPTION_EMAIL_STATE = "0x16 (EMAIL_STATE)";
    private static final String DESCRIPTION_PHONE_MODULE_STATE = "0x17 (PHONE_MODULE_STATE)";
    private static final String DESCRIPTION_CONNECTION_STATE = "0x18 (CONNECTION_STATE)";
    private static final String DESCRIPTION_AUTOMATIC_CALL_FORWARDING = "0x19 (AUTOMATIC_CALL_FORWARDING)";
    private static final String DESCRIPTION_PHONEBOOK_DOWNLOAD_PROGRESS = "0x1a (PHONEBOOK_DOWNLOAD_PROGRESS)";
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
                return DESCRIPTION_REGISTER_STATE2;
            }
            case 18: {
                return DESCRIPTION_LOCK_STATE2;
            }
            case 19: {
                return DESCRIPTION_NETWORK_PROVIDER2;
            }
            case 20: {
                return DESCRIPTION_SIGNAL_QUALITY2;
            }
            case 21: {
                return DESCRIPTION_DATA_CONNECTION_INDICATION2;
            }
            case 22: {
                return DESCRIPTION_EMAIL_STATE;
            }
            case 23: {
                return DESCRIPTION_PHONE_MODULE_STATE;
            }
            case 24: {
                return DESCRIPTION_CONNECTION_STATE;
            }
            case 25: {
                return DESCRIPTION_AUTOMATIC_CALL_FORWARDING;
            }
            case 26: {
                return DESCRIPTION_PHONEBOOK_DOWNLOAD_PROGRESS;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

