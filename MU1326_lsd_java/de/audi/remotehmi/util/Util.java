/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.esolutions.fw.util.commons.Buffer;
import java.io.File;

public class Util {
    private static final Integer[] cachedIntegers = Util.createCachedIntegers();
    private static volatile int APPLICATION_ID = 1000001;
    private static final Long[] cachedLongs = Util.createCachedLongs();

    private static Integer[] createCachedIntegers() {
        Integer[] integerArray = new Integer[256];
        for (int i2 = 0; i2 < integerArray.length; ++i2) {
            integerArray[i2] = new Integer(i2 - 127);
        }
        return integerArray;
    }

    private static Long[] createCachedLongs() {
        Long[] longArray = new Long[256];
        for (int i2 = 0; i2 < longArray.length; ++i2) {
            longArray[i2] = new Long(i2 - 127);
        }
        return longArray;
    }

    private Util() {
    }

    public static Integer createInteger(int n) {
        if (n >= -127 && n <= 128) {
            return cachedIntegers[n + 127];
        }
        return new Integer(n);
    }

    public static Long createLong(long l) {
        if (l >= -127L && l <= 128L) {
            return cachedLongs[(int)l + 127];
        }
        return new Long(l);
    }

    public static boolean equals(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object == null || object2 == null) {
            return false;
        }
        return object.equals(object2);
    }

    public static String arrayToString(int[] nArray) {
        if (nArray == null) {
            return "null";
        }
        int n = nArray.length;
        Buffer buffer = new Buffer(2 + n * 4);
        buffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 != 0) {
                buffer.append(',');
            }
            buffer.append(nArray[i2]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static String arrayToString(float[] fArray) {
        if (fArray == null) {
            return "null";
        }
        int n = fArray.length;
        Buffer buffer = new Buffer(2 + n * 10);
        buffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 != 0) {
                buffer.append(',');
            }
            buffer.append(fArray[i2]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static int generateInteger(String string) {
        return APPLICATION_ID++;
    }

    public static String useFileLocationOrEmptyIfNotExist(String string) {
        String string2 = string != null && new File(string).exists() ? string : "";
        return string2;
    }
}

