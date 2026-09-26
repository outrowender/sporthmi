/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsENI
implements IFunctionIDs {
    private static final String DESCRIPTION_GET_ALL;
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_CONTROL;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_DESTINATIONS_LIST;
    private static final String DESCRIPTION_DESTINATION_LIST_AS_GCAPACITY;
    private static final String DESCRIPTION_TRIGGER_REMOTE_PROCESS;
    private static final String DESCRIPTION_REMOTE_PROCESS_COMMANDS;
    private static final String DESCRIPTION_REMOTE_PROCESS_STATE;
    private static final String DESCRIPTION_USER_LIST;
    private static final String DESCRIPTION_SERVICE_LIST;
    private static final String DESCRIPTION_ACTIVE_MONITORINGS;
    private static final String DESCRIPTION_PRIVACY_SETUP;
    private static final String DESCRIPTION_ALERT_LIST;
    private static final String DESCRIPTION_MOBILE_DEVICE_KEY_COUNT;
    private static final String DESCRIPTION_VTAN_DATA_ENCRYPTED;
    private static final String DESCRIPTION_ONLINE_UPDATE_STATE_DEPRECATED;
    private static final String DESCRIPTION_CONNECTION_STATE;
    private static final String DESCRIPTION_CHALLENGE_DATA;
    private static final String DESCRIPTION_FO_D_LIST;
    private static final String DESCRIPTION_FO_D_STATE;
    private static final String DESCRIPTION_ACTIVE_TRIP;
    private static final String DESCRIPTION_OLB_SETTINGS;
    private static final String DESCRIPTION_OLB_TRIP_LIST;
    private static final String DESCRIPTION_CURRENT_ONLINE_UPDATE_STATE;
    private static final String DESCRIPTION_ONLINE_UPDATE_LIST;
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
                return "0x10 (DESTINATIONS_LIST)";
            }
            case 17: {
                return "0x11 (DESTINATION_LIST_AS_GCAPACITY)";
            }
            case 18: {
                return "0x12 (TRIGGER_REMOTE_PROCESS)";
            }
            case 19: {
                return "0x13 (REMOTE_PROCESS_COMMANDS)";
            }
            case 20: {
                return "0x14 (REMOTE_PROCESS_STATE)";
            }
            case 21: {
                return "0x15 (USER_LIST)";
            }
            case 22: {
                return "0x16 (SERVICE_LIST)";
            }
            case 23: {
                return "0x17 (ACTIVE_MONITORINGS)";
            }
            case 24: {
                return "0x18 (PRIVACY_SETUP)";
            }
            case 25: {
                return "0x19 (ALERT_LIST)";
            }
            case 26: {
                return "0x1a (MOBILE_DEVICE_KEY_COUNT)";
            }
            case 27: {
                return "0x1b (VTAN_DATA_ENCRYPTED)";
            }
            case 28: {
                return "0x1c (ONLINE_UPDATE_STATE_DEPRECATED)";
            }
            case 29: {
                return "0x1d (CONNECTION_STATE)";
            }
            case 30: {
                return "0x1e (CHALLENGE_DATA)";
            }
            case 31: {
                return "0x1f (FO_D_LIST)";
            }
            case 32: {
                return "0x20 (FO_D_STATE)";
            }
            case 33: {
                return "0x21 (ACTIVE_TRIP)";
            }
            case 34: {
                return "0x22 (OLB_SETTINGS)";
            }
            case 35: {
                return "0x23 (OLB_TRIP_LIST)";
            }
            case 36: {
                return "0x24 (CURRENT_ONLINE_UPDATE_STATE)";
            }
            case 37: {
                return "0x25 (ONLINE_UPDATE_LIST)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

