/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd.benchmark;

public final class Text {
    public static StringBuffer fillWithSpace(StringBuffer stringBuffer, int n) {
        while (stringBuffer.length() < n) {
            stringBuffer.append(' ');
        }
        return stringBuffer;
    }

    public static StringBuffer appendFixedNumber(StringBuffer stringBuffer, long l, int n) {
        String string = String.valueOf(l);
        for (int i2 = n - string.length(); i2 > 0; --i2) {
            stringBuffer.append(' ');
        }
        return stringBuffer.append(string);
    }
}

