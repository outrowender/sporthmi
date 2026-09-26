/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.mfl;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsMFL
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG;
    private static final String DESCRIPTION_FUNCTION_LIST;
    private static final String DESCRIPTION_FSG_SETUP;
    private static final String DESCRIPTION_FSG_OPERATION_STATE;
    private static final String DESCRIPTION_INSTRUMENT_CLUSTER_FUNCTIONS;
    private static final String DESCRIPTION_KEY_CONFIGURATION;
    private static final String DESCRIPTION_KEY_ACTION;
    private static final String DESCRIPTION_PU_CONTENT;
    private static final String DESCRIPTION_PU_ACTION;
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
                return "0x10 (INSTRUMENT_CLUSTER_FUNCTIONS)";
            }
            case 17: {
                return "0x11 (KEY_CONFIGURATION)";
            }
            case 18: {
                return "0x12 (KEY_ACTION)";
            }
            case 19: {
                return "0x13 (PU_CONTENT)";
            }
            case 20: {
                return "0x14 (PU_ACTION)";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(" (UNKNOWN)");
        return buffer.toString();
    }
}

