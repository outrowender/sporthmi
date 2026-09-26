/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.esolutions.fw.util.commons.Buffer;

public final class Strings {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static String removeFirstAndLastChar(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() <= 2) {
            return "";
        }
        return string.substring(1, string.length() - 1);
    }

    public static String removeNonNumericChars(String string) {
        if (string == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (!Character.isDigit(c2)) continue;
            buffer.append(c2);
        }
        return buffer.toString();
    }

    public static boolean isValidNumber(String string) {
        if (string == null || string.length() < 2) {
            return false;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isDigit(c2) || i2 == 0 && c2 == '+' || c2 == ' ') continue;
            return false;
        }
        return true;
    }

    public static String trimForSingleLineDisplay(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() == 0) {
            return "";
        }
        return string.trim();
    }
}

