/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.phone2;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsPhone2
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_MOBILE_SERVICE_SUPPORT;
    private static final String DESCRIPTION_REGISTER_STATE2;
    private static final String DESCRIPTION_LOCK_STATE2;
    private static final String DESCRIPTION_NETWORK_PROVIDER2;
    private static final String DESCRIPTION_SIGNAL_QUALITY2;
    private static final String DESCRIPTION_DATA_CONNECTION_INDICATION2;
    private static final String DESCRIPTION_EMAIL_STATE;
    private static final String DESCRIPTION_PHONE_MODULE_STATE;
    private static final String DESCRIPTION_CONNECTION_STATE;
    private static final String DESCRIPTION_AUTOMATIC_CALL_FORWARDING;
    private static final String DESCRIPTION_PHONEBOOK_DOWNLOAD_PROGRESS;
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
                return "0x11 (REGISTER_STATE2)";
            }
            case 18: {
                return "0x12 (LOCK_STATE2)";
            }
            case 19: {
                return "0x13 (NETWORK_PROVIDER2)";
            }
            case 20: {
                return "0x14 (SIGNAL_QUALITY2)";
            }
            case 21: {
                return "0x15 (DATA_CONNECTION_INDICATION2)";
            }
            case 22: {
                return "0x16 (EMAIL_STATE)";
            }
            case 23: {
                return "0x17 (PHONE_MODULE_STATE)";
            }
            case 24: {
                return "0x18 (CONNECTION_STATE)";
            }
            case 25: {
                return "0x19 (AUTOMATIC_CALL_FORWARDING)";
            }
            case 26: {
                return "0x1a (PHONEBOOK_DOWNLOAD_PROGRESS)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

