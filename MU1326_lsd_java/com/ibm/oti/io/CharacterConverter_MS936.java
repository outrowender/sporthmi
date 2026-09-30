/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter_GBK;
import com.ibm.oti.util.BinarySearch;

class CharacterConverter_MS936
extends CharacterConverter_GBK {
    CharacterConverter_MS936() {
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
            String string;
            int n5;
            if ((n5 = byArray[n++] & 0xFF) < 128) {
                cArray[n2++] = (char)n5;
                continue;
            }
            int n6 = byArray[n++] & 0xFF;
            if (n5 < 129 || n5 > 254 || n6 < 64 || n6 > 254 || n6 == 127) {
                cArray[n2++] = 65533;
                continue;
            }
            if (n6 >= 127) {
                --n6;
            }
            n6 -= 64;
            if (n5 >= 241) {
                string = CharacterConverter_GBK.GBK_2;
                n5 -= 241;
            } else {
                string = CharacterConverter_GBK.GBK;
                n5 -= 129;
            }
            cArray[n2++] = (n6 += n5 * 190) == 7491 ? 8853 : (n6 < CharacterConverter_GBK.byteMapLength && (n4 = string.charAt(n6)) != 0 ? n4 : 65533);
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
        String string = null;
        byte[] byArray = new byte[n3];
        int n5 = n;
        while (n5 < n2) {
            char c3 = cArray[n5];
            if (c3 < '\u0080') {
                byArray[n4++] = (byte)c3;
            } else {
                int n6;
                if (c3 <= '\u9fa5') {
                    if (c3 == '\u2295') {
                        c3 = '\u2641';
                    } else if (c3 == '\u2641') {
                        c3 = '\u2295';
                    }
                    string = CharacterConverter_GBK.GBKValues;
                    n6 = c3 >= '\u4e00' ? 847 + (c3 - 19968) : BinarySearch.binarySearch(CharacterConverter_GBK.GBKKeys, c3);
                } else if (c3 < '\ue000') {
                    n6 = -1;
                } else if (c3 <= '\ue864') {
                    string = CharacterConverter_GBK.GBKValues2;
                    n6 = c3 - 57344;
                } else {
                    string = CharacterConverter_GBK.GBKValues3;
                    n6 = BinarySearch.binarySearch(CharacterConverter_GBK.GBKKeys2, c3);
                }
                if (n6 == -1) {
                    byArray[n4++] = 63;
                } else {
                    char c4 = string.charAt(n6);
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

