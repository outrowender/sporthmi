/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.eni;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsENI
implements IFunctionIDs {
    private static final String DESCRIPTION_GET_ALL = "0x1 (GET_ALL)";
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_CONTROL = "0xd (FSG_CONTROL)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_DESTINATIONS_LIST = "0x10 (DESTINATIONS_LIST)";
    private static final String DESCRIPTION_DESTINATION_LIST_AS_GCAPACITY = "0x11 (DESTINATION_LIST_AS_GCAPACITY)";
    private static final String DESCRIPTION_TRIGGER_REMOTE_PROCESS = "0x12 (TRIGGER_REMOTE_PROCESS)";
    private static final String DESCRIPTION_REMOTE_PROCESS_COMMANDS = "0x13 (REMOTE_PROCESS_COMMANDS)";
    private static final String DESCRIPTION_REMOTE_PROCESS_STATE = "0x14 (REMOTE_PROCESS_STATE)";
    private static final String DESCRIPTION_USER_LIST = "0x15 (USER_LIST)";
    private static final String DESCRIPTION_SERVICE_LIST = "0x16 (SERVICE_LIST)";
    private static final String DESCRIPTION_ACTIVE_MONITORINGS = "0x17 (ACTIVE_MONITORINGS)";
    private static final String DESCRIPTION_PRIVACY_SETUP = "0x18 (PRIVACY_SETUP)";
    private static final String DESCRIPTION_ALERT_LIST = "0x19 (ALERT_LIST)";
    private static final String DESCRIPTION_MOBILE_DEVICE_KEY_COUNT = "0x1a (MOBILE_DEVICE_KEY_COUNT)";
    private static final String DESCRIPTION_VTAN_DATA_ENCRYPTED = "0x1b (VTAN_DATA_ENCRYPTED)";
    private static final String DESCRIPTION_ONLINE_UPDATE_STATE_DEPRECATED = "0x1c (ONLINE_UPDATE_STATE_DEPRECATED)";
    private static final String DESCRIPTION_CONNECTION_STATE = "0x1d (CONNECTION_STATE)";
    private static final String DESCRIPTION_CHALLENGE_DATA = "0x1e (CHALLENGE_DATA)";
    private static final String DESCRIPTION_FO_D_LIST = "0x1f (FO_D_LIST)";
    private static final String DESCRIPTION_FO_D_STATE = "0x20 (FO_D_STATE)";
    private static final String DESCRIPTION_ACTIVE_TRIP = "0x21 (ACTIVE_TRIP)";
    private static final String DESCRIPTION_OLB_SETTINGS = "0x22 (OLB_SETTINGS)";
    private static final String DESCRIPTION_OLB_TRIP_LIST = "0x23 (OLB_TRIP_LIST)";
    private static final String DESCRIPTION_CURRENT_ONLINE_UPDATE_STATE = "0x24 (CURRENT_ONLINE_UPDATE_STATE)";
    private static final String DESCRIPTION_ONLINE_UPDATE_LIST = "0x25 (ONLINE_UPDATE_LIST)";
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
                return DESCRIPTION_DESTINATIONS_LIST;
            }
            case 17: {
                return DESCRIPTION_DESTINATION_LIST_AS_GCAPACITY;
            }
            case 18: {
                return DESCRIPTION_TRIGGER_REMOTE_PROCESS;
            }
            case 19: {
                return DESCRIPTION_REMOTE_PROCESS_COMMANDS;
            }
            case 20: {
                return DESCRIPTION_REMOTE_PROCESS_STATE;
            }
            case 21: {
                return DESCRIPTION_USER_LIST;
            }
            case 22: {
                return DESCRIPTION_SERVICE_LIST;
            }
            case 23: {
                return DESCRIPTION_ACTIVE_MONITORINGS;
            }
            case 24: {
                return DESCRIPTION_PRIVACY_SETUP;
            }
            case 25: {
                return DESCRIPTION_ALERT_LIST;
            }
            case 26: {
                return DESCRIPTION_MOBILE_DEVICE_KEY_COUNT;
            }
            case 27: {
                return DESCRIPTION_VTAN_DATA_ENCRYPTED;
            }
            case 28: {
                return DESCRIPTION_ONLINE_UPDATE_STATE_DEPRECATED;
            }
            case 29: {
                return DESCRIPTION_CONNECTION_STATE;
            }
            case 30: {
                return DESCRIPTION_CHALLENGE_DATA;
            }
            case 31: {
                return DESCRIPTION_FO_D_LIST;
            }
            case 32: {
                return DESCRIPTION_FO_D_STATE;
            }
            case 33: {
                return DESCRIPTION_ACTIVE_TRIP;
            }
            case 34: {
                return DESCRIPTION_OLB_SETTINGS;
            }
            case 35: {
                return DESCRIPTION_OLB_TRIP_LIST;
            }
            case 36: {
                return DESCRIPTION_CURRENT_ONLINE_UPDATE_STATE;
            }
            case 37: {
                return DESCRIPTION_ONLINE_UPDATE_LIST;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

