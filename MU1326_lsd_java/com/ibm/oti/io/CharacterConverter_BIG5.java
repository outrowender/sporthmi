/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.BinarySearch;

class CharacterConverter_BIG5
extends CharacterConverter {
    private static String Big5 = "";
    private static String Big5Keys = "";
    private static String Big5Values = "";
    private static final int byteMapLength = Big5.length();

    CharacterConverter_BIG5() {
    }

    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = n + n2;
        int n4 = 0;
        while (n < n3) {
            int n5;
            if ((n5 = byArray[n++] & 0xFF) >= 128) {
                if (n >= n3) continue;
                ++n;
                ++n4;
                continue;
            }
            ++n4;
        }
        return n4;
    }

    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        n3 += n2;
        while (n2 < n3) {
            int n4;
            int n5;
            if ((n5 = byArray[n++] & 0xFF) < 128) {
                cArray[n2++] = (char)n5;
                continue;
            }
            int n6 = byArray[n++] & 0xFF;
            if (n5 < 161 || n5 > 249 || n5 == 200 || n6 < 64 || n6 > 254) {
                cArray[n2++] = 65533;
                continue;
            }
            if (n6 > 160) {
                n6 -= 98;
            } else {
                if (n6 >= 127) {
                    cArray[n2++] = 65533;
                    continue;
                }
                n6 -= 64;
            }
            n5 = n5 >= 200 ? (n5 -= 162) : (n5 -= 161);
            cArray[n2++] = (n6 += n5 * 157) < byteMapLength && (n4 = Big5.charAt(n6)) != 0 ? n4 : 65533;
        }
        return n;
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = 0;
        n2 += n;
        int n4 = n;
        while (n4 < n2) {
            char c2 = cArray[n4];
            n3 = c2 < '\u0080' ? ++n3 : (n3 += 2);
            ++n4;
        }
        n4 = 0;
        byte[] byArray = new byte[n3];
        int n5 = n;
        while (n5 < n2) {
            char c3 = cArray[n5];
            if (c3 < '\u0080') {
                byArray[n4++] = (byte)c3;
            } else {
                int n6 = BinarySearch.binarySearch(Big5Keys, c3);
                if (n6 == -1) {
                    byArray[n4++] = 63;
                } else {
                    char c4 = Big5Values.charAt(n6);
                    byte by = (byte)(c4 >> 8);
                    if (by != 0) {
                        byArray[n4++] = by;
                    }
                    byArray[n4++] = (byte)c4;
                }
            }
            ++n5;
        }
        if (n4 < byArray.length) {
            byte[] byArray2 = new byte[n4];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n4);
            byArray = byArray2;
        }
        return byArray;
    }
}

