/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import java.io.UnsupportedEncodingException;

public final class BAPStringUtilities {
    private static final String RAW_ENCODING;

    public static String convertToRawString(byte[] byArray) {
        if (byArray == null) {
            return "";
        }
        try {
            return new String(byArray, "ISO8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return "";
        }
    }
}

