/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.util.Msg;
import java.lang.reflect.Array;

public final class Utility {
    static final char ESCAPE = '\ua5a5';
    static final byte ESCAPE_BYTE = -91;
    static final char[] HEX_DIGIT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static Object resizeArray(int n, Object object, int n2, int n3) {
        Class clazz = object.getClass().getComponentType();
        Object object2 = Array.newInstance(clazz, n);
        System.arraycopy(object, n2, object2, 0, n3);
        return object2;
    }

    public static final boolean arrayEquals(Object[] objectArray, Object object) {
        if (objectArray == null) {
            return object == null;
        }
        if (!(object instanceof Object[])) {
            return false;
        }
        Object[] objectArray2 = (Object[])object;
        return objectArray.length == objectArray2.length && Utility.arrayRegionMatches(objectArray, 0, objectArray2, 0, objectArray.length);
    }

    public static final boolean arrayEquals(int[] nArray, Object object) {
        if (nArray == null) {
            return object == null;
        }
        if (!(object instanceof int[])) {
            return false;
        }
        int[] nArray2 = (int[])object;
        return nArray.length == nArray2.length && Utility.arrayRegionMatches(nArray, 0, nArray2, 0, nArray.length);
    }

    public static final boolean arrayEquals(double[] dArray, Object object) {
        if (dArray == null) {
            return object == null;
        }
        if (!(object instanceof double[])) {
            return false;
        }
        double[] dArray2 = (double[])object;
        return dArray.length == dArray2.length && Utility.arrayRegionMatches(dArray, 0, dArray2, 0, dArray.length);
    }

    public static final boolean arrayEquals(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        if (object instanceof Object[]) {
            return Utility.arrayEquals((Object[])object, object2);
        }
        if (object instanceof int[]) {
            return Utility.arrayEquals((int[])object, object2);
        }
        if (object instanceof double[]) {
            return Utility.arrayEquals((int[])object, object2);
        }
        return object.equals(object2);
    }

    public static final boolean arrayRegionMatches(Object[] objectArray, int n, Object[] objectArray2, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n2 - n;
        int n6 = n;
        while (n6 < n4) {
            if (!Utility.arrayEquals(objectArray[n6], objectArray2[n6 + n5])) {
                return false;
            }
            ++n6;
        }
        return true;
    }

    public static final boolean arrayRegionMatches(int[] nArray, int n, int[] nArray2, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n2 - n;
        int n6 = n;
        while (n6 < n4) {
            if (nArray[n6] != nArray2[n6 + n5]) {
                return false;
            }
            ++n6;
        }
        return true;
    }

    public static final boolean arrayRegionMatches(double[] dArray, int n, double[] dArray2, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n2 - n;
        int n6 = n;
        while (n6 < n4) {
            if (dArray[n6] != dArray2[n6 + n5]) {
                return false;
            }
            ++n6;
        }
        return true;
    }

    public static final boolean objectEquals(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    public static final String arrayToRLEString(short[] sArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char)(sArray.length >> 16));
        stringBuffer.append((char)sArray.length);
        short s = sArray[0];
        int n = 1;
        int n2 = 1;
        while (n2 < sArray.length) {
            short s2 = sArray[n2];
            if (s2 == s && n < 65535) {
                ++n;
            } else {
                Utility.encodeRun(stringBuffer, s, n);
                s = s2;
                n = 1;
            }
            ++n2;
        }
        Utility.encodeRun(stringBuffer, s, n);
        return stringBuffer.toString();
    }

    public static final String arrayToRLEString(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char)(byArray.length >> 16));
        stringBuffer.append((char)byArray.length);
        byte by = byArray[0];
        int n = 1;
        byte[] byArray2 = new byte[2];
        int n2 = 1;
        while (n2 < byArray.length) {
            byte by2 = byArray[n2];
            if (by2 == by && n < 255) {
                ++n;
            } else {
                Utility.encodeRun(stringBuffer, by, n, byArray2);
                by = by2;
                n = 1;
            }
            ++n2;
        }
        Utility.encodeRun(stringBuffer, by, n, byArray2);
        if (byArray2[0] != 0) {
            Utility.appendEncodedByte(stringBuffer, (byte)0, byArray2);
        }
        return stringBuffer.toString();
    }

    public static final String arrayToRLEString(char[] cArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char)(cArray.length >> 16));
        stringBuffer.append((char)cArray.length);
        char c2 = cArray[0];
        int n = 1;
        int n2 = 1;
        while (n2 < cArray.length) {
            char c3 = cArray[n2];
            if (c3 == c2 && n < 65535) {
                ++n;
            } else {
                Utility.encodeRun(stringBuffer, (short)c2, n);
                c2 = c3;
                n = 1;
            }
            ++n2;
        }
        Utility.encodeRun(stringBuffer, (short)c2, n);
        return stringBuffer.toString();
    }

    public static final String arrayToRLEString(int[] nArray) {
        StringBuffer stringBuffer = new StringBuffer();
        Utility.appendInt(stringBuffer, nArray.length);
        int n = nArray[0];
        int n2 = 1;
        int n3 = 1;
        while (n3 < nArray.length) {
            int n4 = nArray[n3];
            if (n4 == n && n2 < 65535) {
                ++n2;
            } else {
                Utility.encodeRun(stringBuffer, n, n2);
                n = n4;
                n2 = 1;
            }
            ++n3;
        }
        Utility.encodeRun(stringBuffer, n, n2);
        return stringBuffer.toString();
    }

    private static final void encodeRun(StringBuffer stringBuffer, short s, int n) {
        if (n < 4) {
            int n2 = 0;
            while (n2 < n) {
                if (s == 42405) {
                    stringBuffer.append('\ua5a5');
                }
                stringBuffer.append((char)s);
                ++n2;
            }
        } else {
            if (n == 42405) {
                if (s == 42405) {
                    stringBuffer.append('\ua5a5');
                }
                stringBuffer.append((char)s);
                --n;
            }
            stringBuffer.append('\ua5a5');
            stringBuffer.append((char)n);
            stringBuffer.append((char)s);
        }
    }

    private static final void encodeRun(StringBuffer stringBuffer, byte by, int n, byte[] byArray) {
        if (n < 4) {
            int n2 = 0;
            while (n2 < n) {
                if (by == -91) {
                    Utility.appendEncodedByte(stringBuffer, (byte)-91, byArray);
                }
                Utility.appendEncodedByte(stringBuffer, by, byArray);
                ++n2;
            }
        } else {
            if (n == -91) {
                if (by == -91) {
                    Utility.appendEncodedByte(stringBuffer, (byte)-91, byArray);
                }
                Utility.appendEncodedByte(stringBuffer, by, byArray);
                --n;
            }
            Utility.appendEncodedByte(stringBuffer, (byte)-91, byArray);
            Utility.appendEncodedByte(stringBuffer, (byte)n, byArray);
            Utility.appendEncodedByte(stringBuffer, by, byArray);
        }
    }

    private static final void encodeRun(StringBuffer stringBuffer, int n, int n2) {
        if (n2 < 4) {
            int n3 = 0;
            while (n3 < n2) {
                if (n == 42405) {
                    Utility.appendInt(stringBuffer, n);
                }
                Utility.appendInt(stringBuffer, n);
                ++n3;
            }
        } else {
            if (n2 == 42405) {
                if (n == 42405) {
                    Utility.appendInt(stringBuffer, 42405);
                }
                Utility.appendInt(stringBuffer, n);
                --n2;
            }
            Utility.appendInt(stringBuffer, 42405);
            Utility.appendInt(stringBuffer, n2);
            Utility.appendInt(stringBuffer, n);
        }
    }

    private static final void appendInt(StringBuffer stringBuffer, int n) {
        stringBuffer.append((char)(n >>> 16));
        stringBuffer.append((char)(n & 0xFFFF));
    }

    private static final void appendEncodedByte(StringBuffer stringBuffer, byte by, byte[] byArray) {
        if (byArray[0] != 0) {
            char c2 = (char)(byArray[1] << 8 | by & 0xFF);
            stringBuffer.append(c2);
            byArray[0] = 0;
        } else {
            byArray[0] = 1;
            byArray[1] = by;
        }
    }

    public static final short[] RLEStringToShortArray(String string) {
        int n = string.charAt(0) << 16 | string.charAt(1);
        short[] sArray = new short[n];
        int n2 = 0;
        int n3 = 2;
        while (n3 < string.length()) {
            int n4 = string.charAt(n3);
            if (n4 == 42405) {
                if ((n4 = string.charAt(++n3)) == 42405) {
                    sArray[n2++] = (short)n4;
                } else {
                    int n5 = n4;
                    short s = (short)string.charAt(++n3);
                    int n6 = 0;
                    while (n6 < n5) {
                        sArray[n2++] = s;
                        ++n6;
                    }
                }
            } else {
                sArray[n2++] = (short)n4;
            }
            ++n3;
        }
        if (n2 != n) {
            throw new InternalError(Msg.getString("K033a"));
        }
        return sArray;
    }

    public static final byte[] RLEStringToByteArray(String string) {
        int n = string.charAt(0) << 16 | string.charAt(1);
        byte[] byArray = new byte[n];
        boolean bl = true;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 2;
        int n6 = 0;
        while (n6 < n) {
            int n7;
            if (bl) {
                n2 = string.charAt(n5++);
                n7 = (byte)(n2 >> 8);
                bl = false;
            } else {
                n7 = n2 & 0xFF;
                bl = true;
            }
            switch (n3) {
                case 0: {
                    if (n7 == -91) {
                        n3 = 1;
                        break;
                    }
                    byArray[n6++] = n7;
                    break;
                }
                case 1: {
                    if (n7 == -91) {
                        byArray[n6++] = -91;
                        n3 = 0;
                        break;
                    }
                    n4 = n7;
                    if (n4 < 0) {
                        n4 += 256;
                    }
                    n3 = 2;
                    break;
                }
                case 2: {
                    int n8 = 0;
                    while (n8 < n4) {
                        byArray[n6++] = n7;
                        ++n8;
                    }
                    n3 = 0;
                }
            }
        }
        if (n3 != 0) {
            throw new InternalError(Msg.getString("K033a"));
        }
        if (n5 != string.length()) {
            throw new InternalError(Msg.getString("K0ab2"));
        }
        return byArray;
    }

    public static final char[] RLEStringToCharArray(String string) {
        int n = string.charAt(0) << 16 | string.charAt(1);
        char[] cArray = new char[n];
        int n2 = 0;
        int n3 = 2;
        while (n3 < string.length()) {
            int n4 = string.charAt(n3);
            if (n4 == 42405) {
                if ((n4 = string.charAt(++n3)) == 42405) {
                    cArray[n2++] = n4;
                } else {
                    int n5 = n4;
                    char c2 = string.charAt(++n3);
                    int n6 = 0;
                    while (n6 < n5) {
                        cArray[n2++] = c2;
                        ++n6;
                    }
                }
            } else {
                cArray[n2++] = n4;
            }
            ++n3;
        }
        if (n2 != n) {
            throw new InternalError(Msg.getString("K033a"));
        }
        return cArray;
    }

    public static final int[] RLEStringToIntArray(String string) {
        int n = Utility.getInt(string, 0);
        int[] nArray = new int[n];
        int n2 = 0;
        int n3 = 1;
        int n4 = string.length() / 2;
        while (n2 < n && n3 < n4) {
            int n5;
            if ((n5 = Utility.getInt(string, n3++)) == 42405) {
                if ((n5 = Utility.getInt(string, n3++)) == 42405) {
                    nArray[n2++] = n5;
                    continue;
                }
                int n6 = n5;
                int n7 = Utility.getInt(string, n3++);
                int n8 = 0;
                while (n8 < n6) {
                    nArray[n2++] = n7;
                    ++n8;
                }
                continue;
            }
            nArray[n2++] = n5;
        }
        if (n2 != n || n3 != n4) {
            throw new InternalError(Msg.getString("K033a"));
        }
        return nArray;
    }

    public static final String hex(char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        return Utility.hex(c2, stringBuffer).toString();
    }

    public static final StringBuffer hex(String string, StringBuffer stringBuffer) {
        if (string != null && stringBuffer != null) {
            int n = string.length();
            int n2 = 0;
            Utility.hex(string.charAt(n2), stringBuffer);
            while (n2 < n) {
                stringBuffer.append(',');
                Utility.hex(string.charAt(n2++), stringBuffer);
            }
        }
        return stringBuffer;
    }

    public static final String hex(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        Utility.hex(string, stringBuffer);
        return stringBuffer.toString();
    }

    public static final String hex(StringBuffer stringBuffer) {
        return Utility.hex(stringBuffer.toString());
    }

    public static final StringBuffer hex(char c2, StringBuffer stringBuffer) {
        int n = 12;
        while (n >= 0) {
            stringBuffer.append(HEX_DIGIT[(byte)(c2 >> n & 0xF)]);
            n -= 4;
        }
        return stringBuffer;
    }

    static final int getInt(String string, int n) {
        return string.charAt(2 * n) << 16 | string.charAt(2 * n + 1);
    }
}

