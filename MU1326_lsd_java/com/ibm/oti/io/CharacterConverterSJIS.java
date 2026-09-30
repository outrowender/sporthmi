/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.BinarySearch;

abstract class CharacterConverterSJIS
extends CharacterConverter {
    CharacterConverterSJIS() {
    }

    abstract String getByteTable();

    abstract String getCharTableKeys();

    abstract String getCharTableValues();

    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = n + n2;
        int n4 = 0;
        while (n < n3) {
            int n5;
            if ((n5 = byArray[n++] & 0xFF) >= 128 && n5 <= 160 || n5 >= 224) {
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
        String string = this.getByteTable();
        while (n2 < n3) {
            int n4;
            if ((n4 = byArray[n++] & 0xFF) < 128) {
                cArray[n2++] = (char)n4;
                continue;
            }
            if (n4 >= 161 && n4 <= 223) {
                cArray[n2++] = (char)(65216 + n4);
                continue;
            }
            int n5 = byArray[n++] & 0xFF;
            if (n4 == 128 || n4 == 160 || n5 < 64 || n5 > 252 || n5 == 127) {
                cArray[n2++] = 65533;
                continue;
            }
            if ((n5 -= 64) >= 64) {
                --n5;
            }
            if ((n4 -= 129) > 30) {
                n4 -= 64;
            }
            cArray[n2++] = (n5 += n4 * 188) >= string.length() ? 65533 : string.charAt(n5);
        }
        return n;
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = 0;
        n2 += n;
        int n4 = n;
        while (n4 < n2) {
            char c2 = cArray[n4];
            n3 = c2 < '\u0080' || c2 == '\u00a5' || c2 >= '\uff61' && c2 <= '\uff9f' ? ++n3 : (n3 += 2);
            ++n4;
        }
        n4 = 0;
        String string = this.getCharTableKeys();
        String string2 = this.getCharTableValues();
        byte[] byArray = new byte[n3];
        int n5 = n;
        while (n5 < n2) {
            char c3 = cArray[n5];
            if (c3 < '\u0080') {
                byArray[n4++] = (byte)c3;
            } else {
                int n6 = BinarySearch.binarySearch(string, c3);
                if (n6 == -1) {
                    byArray[n4++] = 63;
                } else {
                    char c4 = string2.charAt(n6);
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

