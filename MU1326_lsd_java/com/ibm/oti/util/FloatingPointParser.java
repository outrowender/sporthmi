/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

public final class FloatingPointParser {
    private static native double parseDblImpl(String var0, int var1);

    private static native float parseFltImpl(String var0, int var1);

    private static StringExponentPair initialParse(String string, int n) {
        boolean bl = false;
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if ((c2 == 'D' || c2 == 'd' || c2 == 'F' || c2 == 'f') && --n == 0) {
            throw new NumberFormatException(string);
        }
        int n4 = Math.max(string.indexOf(69), string.indexOf(101));
        if (n4 > -1) {
            if (n4 + 1 == n) {
                throw new NumberFormatException(string);
            }
            n2 = string.charAt(n4 + 1) == '+' ? Integer.parseInt(string.substring(n4 + 2, n)) : Integer.parseInt(string.substring(n4 + 1, n));
        } else {
            n4 = n;
        }
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        c2 = string.charAt(n3);
        if (c2 == '-') {
            ++n3;
            --n;
            bl = true;
        } else if (c2 == '+') {
            ++n3;
            --n;
        }
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        int n5 = string.indexOf(46);
        if (n5 > -1) {
            n2 -= n4 - n5 - 1;
            string = String.valueOf(string.substring(n3, n5)) + string.substring(n5 + 1, n4);
        } else {
            string = string.substring(n3, n4);
        }
        n = string.length();
        if (n == 0) {
            throw new NumberFormatException();
        }
        n4 = n;
        while (n4 > 1 && string.charAt(n4 - 1) == '0') {
            --n4;
        }
        n3 = 0;
        while (n3 < n4 - 1 && string.charAt(n3) == '0') {
            ++n3;
        }
        if (n4 != n || n3 != 0) {
            n2 += n - n4;
            string = string.substring(n3, n4);
        }
        return new StringExponentPair(string, n2, bl);
    }

    private static double parseDblName(String string, int n) {
        if (n != 3 && n != 4 && n != 8 && n != 9) {
            throw new NumberFormatException();
        }
        boolean bl = false;
        int n2 = 0;
        switch (string.charAt(0)) {
            case '-': {
                bl = true;
            }
            case '+': {
                n2 = 1;
            }
        }
        if (string.regionMatches(false, n2, "Infinity", 0, 8)) {
            return bl ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (string.regionMatches(false, n2, "NaN", 0, 3)) {
            return Double.NaN;
        }
        throw new NumberFormatException();
    }

    private static float parseFltName(String string, int n) {
        if (n != 3 && n != 4 && n != 8 && n != 9) {
            throw new NumberFormatException();
        }
        boolean bl = false;
        int n2 = 0;
        switch (string.charAt(0)) {
            case '-': {
                bl = true;
            }
            case '+': {
                n2 = 1;
            }
        }
        if (string.regionMatches(false, n2, "Infinity", 0, 8)) {
            return bl ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (string.regionMatches(false, n2, "NaN", 0, 3)) {
            return Float.NaN;
        }
        throw new NumberFormatException();
    }

    public static double parseDouble(String string) {
        int n = (string = string.trim()).length();
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if (c2 == 'y' || c2 == 'N') {
            return FloatingPointParser.parseDblName(string, n);
        }
        StringExponentPair stringExponentPair = FloatingPointParser.initialParse(string, n);
        double d2 = FloatingPointParser.parseDblImpl(stringExponentPair.s, stringExponentPair.e);
        if (stringExponentPair.negative) {
            d2 = -d2;
        }
        return d2;
    }

    public static float parseFloat(String string) {
        int n = (string = string.trim()).length();
        if (n == 0) {
            throw new NumberFormatException(string);
        }
        char c2 = string.charAt(n - 1);
        if (c2 == 'y' || c2 == 'N') {
            return FloatingPointParser.parseFltName(string, n);
        }
        StringExponentPair stringExponentPair = FloatingPointParser.initialParse(string, n);
        float f2 = FloatingPointParser.parseFltImpl(stringExponentPair.s, stringExponentPair.e);
        if (stringExponentPair.negative) {
            f2 = -f2;
        }
        return f2;
    }

    private static final class StringExponentPair {
        String s;
        int e;
        boolean negative;

        StringExponentPair(String string, int n, boolean bl) {
            this.s = string;
            this.e = n;
            this.negative = bl;
        }
    }
}

