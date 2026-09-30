/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.util;

import de.audi.atip.log.LogChannel;

public class UtilOnline {
    public static void validateObject(Object object, Class clazz, String string, String string2) {
        String string3;
        Object object2;
        String string4;
        if (clazz == null) {
            throw new IllegalArgumentException("Given expected class name is null!");
        }
        if (object == null) {
            string4 = "Object '" + string + "' is null.";
        } else {
            object2 = object.getClass();
            if (clazz.isAssignableFrom((Class)object2)) {
                return;
            }
            string3 = ((Class)object2).getName();
            String string5 = clazz.getName();
            string4 = "Object '" + string + "' has invalid class='" + string3 + "' which cannot be cast to '" + string5 + "'.";
        }
        object2 = UtilOnline.getMethodName(new Throwable().getStackTrace(), 1);
        string3 = string4 + " It was obtained in method " + (String)object2 + " from method " + string2 + "!";
        throw new IllegalArgumentException(string3);
    }

    public static void validateArgumentNotNull(Object object, String string) {
        if (object != null) {
            return;
        }
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        String string2 = UtilOnline.getMethodName(stackTraceElementArray, 1);
        String string3 = UtilOnline.getMethodName(stackTraceElementArray, 2);
        String string4 = "Argument '" + string + "' is not allowed to be null. " + "It was passed from method " + string3 + " to method " + string2 + "!";
        throw new IllegalArgumentException(string4);
    }

    public static String getSuffix(String string, String string2) {
        if (string == null) {
            return "";
        }
        if (string2 == null) {
            return string;
        }
        int n = string.lastIndexOf(string2);
        if (n == -1) {
            return string;
        }
        return string.substring(n + string2.length());
    }

    public static String getMethodName(StackTraceElement[] stackTraceElementArray, int n) {
        StackTraceElement stackTraceElement;
        if (stackTraceElementArray != null && stackTraceElementArray.length >= n && (stackTraceElement = stackTraceElementArray[n]) != null) {
            return UtilOnline.getSuffix(stackTraceElement.getClassName(), ".") + "." + stackTraceElement.getMethodName() + "()";
        }
        return "UNKNOWN";
    }

    public static boolean getSafeBoolean(LogChannel logChannel, String string, boolean bl) {
        if (string == null) {
            return bl;
        }
        if (string.equals(String.valueOf(!bl))) {
            return !bl;
        }
        if (string.equals(String.valueOf(bl))) {
            return bl;
        }
        if ("0".equals(string)) {
            return false;
        }
        if ("1".equals(string)) {
            return true;
        }
        logChannel.log(100000, "UtilEvo#getSafeBoolean: Cannot convert '%1' to a boolean value! Setting it to '%2'!", (Object)string, (Object)String.valueOf(bl));
        return bl;
    }

    public static String getSafeString(String string, String string2) {
        if (string == null) {
            return string2;
        }
        String string3 = string.trim();
        return string3.length() == 0 ? string2 : string3;
    }

    public static int getSafeInt(LogChannel logChannel, String string, int n) {
        if (string == null) {
            return n;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            float f2;
            try {
                f2 = Float.parseFloat(string);
            }
            catch (NumberFormatException numberFormatException2) {
                f2 = Float.NaN;
            }
            if (Float.isNaN(f2) || Float.isInfinite(f2)) {
                String string2 = "Cannot convert '" + string + "' to an integer value! Setting it to '" + n + "'!";
                logChannel.log(100000, string2);
                return n;
            }
            return Math.round(f2);
        }
    }

    public static float getSafeFloat(LogChannel logChannel, String string, float f2) {
        float f3;
        if (string == null) {
            return f2;
        }
        try {
            f3 = Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            f3 = Float.NaN;
        }
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            String string2 = "ViewGridAction#getComposedValueInt: Cannot convert '" + string + "' to a float value! Setting it to '" + f2 + "'!";
            logChannel.log(100000, string2);
            return f2;
        }
        return f3;
    }

    public static boolean areEqual(Object object, Object object2) {
        if (object == null && object2 == null) {
            return true;
        }
        return object != null && object2 != null && object.equals(object2);
    }
}

