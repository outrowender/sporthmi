/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.onlinefunctions;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsOnlineFunctions
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_CONTROL = "0xd (FSG_CONTROL)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_TRAFFIC_LIGHT_ONLINE_INFO = "0x10 (TRAFFIC_LIGHT_ONLINE_INFO)";
    private static final String DESCRIPTION_TRAFFIC_LIGHT_ONLINE_SPEED = "0x11 (TRAFFIC_LIGHT_ONLINE_SPEED)";
    private static final String DESCRIPTION_TRAFFIC_LIGHT_ONLINE_TIME = "0x12 (TRAFFIC_LIGHT_ONLINE_TIME)";
    private static final String FCT_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
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
                return DESCRIPTION_TRAFFIC_LIGHT_ONLINE_INFO;
            }
            case 17: {
                return DESCRIPTION_TRAFFIC_LIGHT_ONLINE_SPEED;
            }
            case 18: {
                return DESCRIPTION_TRAFFIC_LIGHT_ONLINE_TIME;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

