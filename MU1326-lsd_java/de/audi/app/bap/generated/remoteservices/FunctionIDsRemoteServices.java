/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.remoteservices;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsRemoteServices
implements IFunctionIDs {
    private static final String DESCRIPTION_GET_ALL;
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_CONTROL;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_START_ENGINE_CHALLENGE;
    private static final String DESCRIPTION_START_ENGINE_AUTHENTICATION;
    private static final String DESCRIPTION_START_ENGINE_SIGNATURE;
    private static final String DESCRIPTION_MOB_DEV_KEY_CHALLENGE;
    private static final String DESCRIPTION_MOB_DEV_KEY_AUTH;
    private static final String DESCRIPTION_MOB_DEV_KEY_COMMAND;
    private static final String DESCRIPTION_MOB_DEV_KEY_ACTIVE_KEY;
    private static final String DESCRIPTION_MOB_DEV_KEY_SETUP;
    private static final String DESCRIPTION_VTAN_AUTH_DATA;
    private static final String DESCRIPTION_VTAN_DECRYPTION;
    private static final String DESCRIPTION_MOB_DEV_KEY_CONTROL;
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
                return "0x10 (START_ENGINE_CHALLENGE)";
            }
            case 17: {
                return "0x11 (START_ENGINE_AUTHENTICATION)";
            }
            case 18: {
                return "0x12 (START_ENGINE_SIGNATURE)";
            }
            case 19: {
                return "0x13 (MOB_DEV_KEY_CHALLENGE)";
            }
            case 20: {
                return "0x14 (MOB_DEV_KEY_AUTH)";
            }
            case 21: {
                return "0x15 (MOB_DEV_KEY_COMMAND)";
            }
            case 22: {
                return "0x16 (MOB_DEV_KEY_ACTIVE_KEY)";
            }
            case 23: {
                return "0x17 (MOB_DEV_KEY_SETUP)";
            }
            case 24: {
                return "0x18 (VTAN_AUTH_DATA)";
            }
            case 25: {
                return "0x19 (VTAN_DECRYPTION)";
            }
            case 26: {
                return "0x1a (MOB_DEV_KEY_CONTROL)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

