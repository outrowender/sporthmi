/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.esolutions.fw.util.commons.Buffer;

public class Util {
    private static Boolean booleanTrue = Boolean.TRUE;
    private static Boolean booleanFalse = Boolean.FALSE;
    private static final Integer[] cachedIntegers = Util.createCachedIntegers();
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

    public static Boolean createBoolean(boolean bl) {
        return bl ? booleanTrue : booleanFalse;
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

    public static boolean equals(int[] nArray, int[] nArray2) {
        boolean bl = false;
        if (nArray == nArray2) {
            bl = true;
        } else if (nArray == null || nArray2 == null) {
            bl = false;
        } else if (nArray.length != nArray2.length) {
            bl = false;
        } else {
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                if (nArray[i2] == nArray2[i2]) continue;
                bl = false;
                break;
            }
        }
        return bl;
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

    public static String arrayToString(boolean[] blArray) {
        if (blArray == null) {
            return "null";
        }
        int n = blArray.length;
        Buffer buffer = new Buffer(2 + n * 6);
        buffer.append('[');
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 != 0) {
                buffer.append(',');
            }
            buffer.append(blArray[i2]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    public static String getClassName(Object object) {
        Class clazz;
        int n;
        String string = null;
        if (object != null && (n = (string = (clazz = object.getClass()).getName()).lastIndexOf(46)) != -1) {
            return string.substring(n + 1);
        }
        return string;
    }

    public static String getObjectName(Object object) {
        Buffer buffer = new Buffer();
        if (object != null) {
            buffer.append(Util.getClassName(object));
            buffer.append("@");
            buffer.append(Util.getHexString(object));
        }
        return buffer.toString();
    }

    public static String getHexString(Object object) {
        String string = null;
        if (object != null) {
            string = Integer.toHexString(object.hashCode());
        }
        return string;
    }

    public static float getPercentage(double d2, double d3, double d4) {
        double d5 = d3 - d2;
        double d6 = d4 - d2;
        return (float)(d6 / d5);
    }

    public static int toNextEvenNumber(int n) {
        return n + n % 2;
    }

    public static boolean contains(String string, String string2) {
        if (string == null) {
            return false;
        }
        if (string2 == null) {
            return false;
        }
        if (string.length() == 0) {
            return false;
        }
        if (string.length() < string2.length()) {
            return false;
        }
        char[] cArray = string.toCharArray();
        char[] cArray2 = string2.toCharArray();
        int n = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < cArray.length && n < cArray2.length; ++i2) {
            if (cArray[i2] == cArray2[n]) {
                ++n;
                bl = true;
                continue;
            }
            if (n > 0) {
                i2 -= n;
            }
            n = 0;
            bl = false;
        }
        return bl;
    }
}

