/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public final class FunctionIDs {
    private static final SimpleIntObjectMap FUNCTION_IDS = new SimpleIntObjectMap();

    public static String getDescription(int n, int n2) {
        IFunctionIDs iFunctionIDs = (IFunctionIDs)FUNCTION_IDS.get(n);
        if (iFunctionIDs == null) {
            return String.valueOf(n2);
        }
        return iFunctionIDs.getDescription(n2);
    }

    public static void registerFunctionIDs(int n, IFunctionIDs iFunctionIDs) {
        FUNCTION_IDS.add(n, iFunctionIDs);
    }
}

