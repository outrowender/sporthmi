/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.apache.commons.jexl.util;

public class Coercion {
    public static Boolean coerceBoolean(Object object) {
        if (object == null) {
            return Boolean.FALSE;
        }
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        if (object instanceof String) {
            return Boolean.valueOf((String)object);
        }
        return null;
    }

    public static Integer coerceInteger(Object object) {
        if (object == null) {
            return new Integer(0);
        }
        if (object instanceof String) {
            if ("".equals(object)) {
                return new Integer(0);
            }
            return Integer.valueOf((String)object);
        }
        if (object instanceof Character) {
            return new Integer(((Character)object).charValue());
        }
        if (object instanceof Boolean) {
            throw new Exception("Boolean->Integer coercion exception");
        }
        if (object instanceof Number) {
            return new Integer(((Number)object).intValue());
        }
        throw new Exception("Integer coercion exception");
    }

    public static Long coerceLong(Object object) {
        if (object == null) {
            return new Long(0L);
        }
        if (object instanceof String) {
            if ("".equals(object)) {
                return new Long(0L);
            }
            return Long.valueOf((String)object);
        }
        if (object instanceof Character) {
            return new Long(((Character)object).charValue());
        }
        if (object instanceof Boolean) {
            throw new Exception("Boolean->Long coercion exception");
        }
        if (object instanceof Number) {
            return new Long(((Number)object).longValue());
        }
        throw new Exception("Long coercion exception");
    }

    public static Double coerceDouble(Object object) {
        if (object == null) {
            return new Double(0.0);
        }
        if (object instanceof String) {
            if ("".equals(object)) {
                return new Double(0.0);
            }
            return new Double((String)object);
        }
        if (object instanceof Character) {
            char c2 = ((Character)object).charValue();
            return new Double(Double.parseDouble((String)String.valueOf((int)c2)));
        }
        if (object instanceof Boolean) {
            throw new Exception("Boolean->Double coercion exception");
        }
        if (object instanceof Double) {
            return (Double)object;
        }
        if (object instanceof Number) {
            return new Double(Double.parseDouble((String)String.valueOf(object)));
        }
        throw new Exception("Double coercion exception");
    }

    public static boolean isFloatingPoint(Object object) {
        return object instanceof Float || object instanceof Double;
    }

    public static boolean isNumberable(Object object) {
        return object instanceof Integer || object instanceof Long || object instanceof Byte || object instanceof Short || object instanceof Character;
    }
}

