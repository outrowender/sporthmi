/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.mfl;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsMFL
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_SETUP = "0xe (FSG_SETUP)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_INSTRUMENT_CLUSTER_FUNCTIONS = "0x10 (INSTRUMENT_CLUSTER_FUNCTIONS)";
    private static final String DESCRIPTION_KEY_CONFIGURATION = "0x11 (KEY_CONFIGURATION)";
    private static final String DESCRIPTION_KEY_ACTION = "0x12 (KEY_ACTION)";
    private static final String DESCRIPTION_PU_CONTENT = "0x13 (PU_CONTENT)";
    private static final String DESCRIPTION_PU_ACTION = "0x14 (PU_ACTION)";
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
                return DESCRIPTION_INSTRUMENT_CLUSTER_FUNCTIONS;
            }
            case 17: {
                return DESCRIPTION_KEY_CONFIGURATION;
            }
            case 18: {
                return DESCRIPTION_KEY_ACTION;
            }
            case 19: {
                return DESCRIPTION_PU_CONTENT;
            }
            case 20: {
                return DESCRIPTION_PU_ACTION;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

