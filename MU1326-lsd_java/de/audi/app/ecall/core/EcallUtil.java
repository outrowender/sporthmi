/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class EcallUtil {
    public static final String STREET_CITY_SEPARATOR;
    public static final String NEW_LINE;
    private static final Map CLAZZ_MAP;

    public static void logStructFieldForDbg(LogChannel logChannel, Class clazz, int n) {
        if (logChannel.isDebug()) {
            String string = EcallUtil.getFieldNameByValue(logChannel, clazz, n);
            logChannel.log(-2137614336, "EcallUtil#logStructFieldForDbg(): structClazz %1, fieldName %2", (Object)clazz, (Object)string);
        }
    }

    private static synchronized String getFieldNameByValue(LogChannel logChannel, Class clazz, int n) {
        if (CLAZZ_MAP.get(clazz) == null) {
            EcallUtil.initFieldValueMapNameForClass(clazz, logChannel);
        }
        return (String)((SimpleIntObjectMap)CLAZZ_MAP.get(clazz)).get(n);
    }

    private static void initFieldValueMapNameForClass(Class clazz, LogChannel logChannel) {
        Field[] fieldArray = clazz.getFields();
        SimpleIntObjectMap simpleIntObjectMap = new SimpleIntObjectMap(fieldArray.length);
        try {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                int n = Integer.parseInt(fieldArray[i2].get(null).toString());
                String string = fieldArray[i2].getName();
                simpleIntObjectMap.add(n, string);
            }
            CLAZZ_MAP.put(clazz, simpleIntObjectMap);
        }
        catch (IllegalAccessException illegalAccessException) {
            logChannel.log(-1601830656, illegalAccessException.toString());
        }
        catch (NumberFormatException numberFormatException) {
            logChannel.log(-1601830656, numberFormatException.toString());
        }
    }

    public static boolean isStateValidForScreenActivation(boolean[] blArray, int n) {
        return blArray.length > n && blArray[n];
    }

    public static boolean isStringNullOrEmpty(String string) {
        return !EcallUtil.isStringNotNullOrEmpty(string);
    }

    public static boolean isArrayNotEmpty(Object[] objectArray) {
        return objectArray != null && objectArray.length > 0;
    }

    public static boolean isStringNotNullOrEmpty(String string) {
        return string != null && string.length() > 0;
    }

    static {
        CLAZZ_MAP = new HashMap();
    }
}

