/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.common.Logger;
import java.util.HashMap;
import java.util.Map;

public class SDSValueEnum {
    public static final Integer TOP_ENTRY_GAP = new Integer(0);
    public static final Integer FOLLOWUP_ENTRY_GAP = new Integer(1);
    private static SDSValueEnum topGapEnum = new SDSValueEnum(TOP_ENTRY_GAP, new Float(0.0f), new Float(1.0f), new String[]{"0.01", "0.001", "-0.01", "-0.001"});
    private static SDSValueEnum followupGapEnum = new SDSValueEnum(FOLLOWUP_ENTRY_GAP, new Float(0.0f), new Float(1.0f), new String[]{"0.01", "0.001", "-0.01", "-0.001"});
    private static Map addValuesMap;
    private static Map minimalMap;
    private static Map maximalMap;

    private SDSValueEnum(Integer n, Float f2, Float f3, String[] stringArray) {
        if (addValuesMap == null) {
            addValuesMap = new HashMap();
        }
        addValuesMap.put(n, stringArray);
        if (minimalMap == null) {
            minimalMap = new HashMap();
        }
        minimalMap.put(n, f2);
        if (maximalMap == null) {
            maximalMap = new HashMap();
        }
        maximalMap.put(n, f3);
    }

    public static synchronized float getAdditionValue(Integer n, int n2) {
        return Float.parseFloat(((String[])addValuesMap.get(n))[n2]);
    }

    public static synchronized int getAdditionValueLength(Integer n) {
        return ((String[])addValuesMap.get(n)).length;
    }

    public static synchronized float addValue(Integer n, int n2, float f2, SDSAdapter sDSAdapter) {
        float f3;
        Float f4 = (Float)minimalMap.get(n);
        Float f5 = (Float)maximalMap.get(n);
        if (f4 == null || f5 == null) {
            return f2;
        }
        try {
            float f6 = Float.parseFloat(((String[])addValuesMap.get(n))[n2]);
            f3 = (float)Math.round((f2 + f6) * 1000.0f) / 1000.0f;
        }
        catch (NumberFormatException numberFormatException) {
            Logger.getMainLog().log(100000, "SDSValueEnum#addValue: NumberFormatException: valueType %1, entryID %2", (Object)n, (long)n2);
            return f2;
        }
        if (f3 <= f4.floatValue()) {
            f3 = f4.floatValue();
        } else if (f3 >= f5.floatValue()) {
            f3 = f5.floatValue();
        }
        SDSValueEnum.setPersistValue(f3, n, sDSAdapter);
        return f3;
    }

    private static void setPersistValue(float f2, Integer n, SDSAdapter sDSAdapter) {
        if (TOP_ENTRY_GAP.equals(n)) {
            sDSAdapter.changeTopEntryThreshold(f2);
        } else if (FOLLOWUP_ENTRY_GAP.equals(n)) {
            sDSAdapter.changeFollowupEntryThreshold(f2);
        }
    }

    public static synchronized float getPersistValue(Integer n, SDSAdapter sDSAdapter) {
        if (TOP_ENTRY_GAP.equals(n)) {
            return sDSAdapter.getTopEntryThreshold();
        }
        if (FOLLOWUP_ENTRY_GAP.equals(n)) {
            return sDSAdapter.getFollowupEntryThreshold();
        }
        return 0.0f;
    }
}

