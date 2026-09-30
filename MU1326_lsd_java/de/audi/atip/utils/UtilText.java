/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils;

import de.esolutions.fw.util.commons.Buffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class UtilText {
    private UtilText() {
    }

    public static <T> String buildString(T[] TArray) {
        if (TArray.length == 0) {
            return "";
        }
        Buffer buffer = new Buffer(20 * TArray.length);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            String string = TArray[i2] == null ? "_null_" : TArray[i2].toString();
            buffer.append(string);
        }
        return buffer.toString();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0 || UtilText.hasStringOnlyWhitespaces(string);
    }

    public static boolean hasStringOnlyWhitespaces(String string) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }
}

