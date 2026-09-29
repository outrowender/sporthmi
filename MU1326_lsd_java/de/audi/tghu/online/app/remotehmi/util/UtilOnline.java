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
            string4 = new StringBuffer().append("Object '").append(string).append("' is null.").toString();
        } else {
            object2 = object.getClass();
            if (clazz.isAssignableFrom((Class)object2)) {
                return;
            }
            string3 = ((Class)object2).getName();
            String string5 = clazz.getName();
            string4 = new StringBuffer().append("Object '").append(string).append("' has invalid class='").append(string3).append("' which cannot be cast to '").append(string5).append("'.").toString();
        }
        object2 = UtilOnline.getMethodName(new Throwable().getStackTrace(), 1);
        string3 = new StringBuffer().append(string4).append(" It was obtained in method ").append((String)object2).append(" from method ").append(string2).append("!").toString();
        throw new IllegalArgumentException(string3);
    }

    public static void validateArgumentNotNull(Object object, String string) {
        if (object != null) {
            return;
        }
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        String string2 = UtilOnline.getMethodName(stackTraceElementArray, 1);
        String string3 = UtilOnline.getMethodName(stackTraceElementArray, 2);
        String string4 = new StringBuffer().append("Argument '").append(string).append("' is not allowed to be null. ").append("It was passed from method ").append(string3).append(" to method ").append(string2).append("!").toString();
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
            return new StringBuffer().append(UtilOnline.getSuffix(stackTraceElement.getClassName(), ".")).append(".").append(stackTraceElement.getMethodName()).append("()").toString();
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
        logChannel.log(-1601830656, "UtilEvo#getSafeBoolean: Cannot convert '%1' to a boolean value! Setting it to '%2'!", (Object)string, (Object)String.valueOf(bl));
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
                f2 = 49279;
            }
            if (Float.isNaN(f2) || Float.isInfinite(f2)) {
                String string2 = new StringBuffer().append("Cannot convert '").append(string).append("' to an integer value! Setting it to '").append(n).append("'!").toString();
                logChannel.log(-1601830656, string2);
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
            f3 = 49279;
        }
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            String string2 = new StringBuffer().append("ViewGridAction#getComposedValueInt: Cannot convert '").append(string).append("' to a float value! Setting it to '").append(f2).append("'!").toString();
            logChannel.log(-1601830656, string2);
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

