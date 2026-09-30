/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.BinarySearch;
import java.io.ByteArrayOutputStream;

class CharacterConverter_EUC_JP
extends CharacterConverter {
    static String jis208 = "";
    static String jis212 = "";
    static String keys = "";
    static String values = "";

    CharacterConverter_EUC_JP() {
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
                if (n5 == 142 || n5 >= 160) {
                    if (n >= n3) break;
                    ++n;
                } else if (n5 == 143) {
                    if (n + 1 >= n3) break;
                    n += 2;
                }
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
            if (n5 == 142) {
                if ((n5 = byArray[n++] & 0xFF) >= 161 && n5 <= 223) {
                    cArray[n2++] = (char)(65216 + n5);
                    continue;
                }
                cArray[n2++] = 65533;
                continue;
            }
            if (n5 == 143) {
                cArray[n2++] = (n5 = byArray[n++] & 0xFF) >= 161 && n5 <= 254 && (n4 = byArray[n] & 0xFF) >= 161 && n4 <= 254 ? jis212.charAt((n5 - 161) * 94 + n4 - 161) : (char)65533;
                ++n;
                continue;
            }
            if (n5 >= 161 && n5 <= 254) {
                if ((n4 = byArray[n++] & 0xFF) >= 161 && n4 <= 254) {
                    cArray[n2++] = jis208.charAt((n5 - 161) * 94 + n4 - 161);
                    continue;
                }
                cArray[n2++] = 65533;
                continue;
            }
            if (n5 >= 160) {
                ++n;
            }
            cArray[n2++] = 65533;
        }
        return n;
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n2 += n);
        int n3 = n;
        while (n3 < n2) {
            char c2 = cArray[n3];
            if (c2 < '\u0080') {
                byteArrayOutputStream.write(c2);
            } else {
                int n4 = BinarySearch.binarySearch(keys, c2);
                if (n4 == -1) {
                    byteArrayOutputStream.write(63);
                } else {
                    char c3 = values.charAt(n4);
                    byte by = (byte)(c3 >> 8);
                    if (by < 0) {
                        byteArrayOutputStream.write(by);
                    } else if (by != 0) {
                        byteArrayOutputStream.write(143);
                        byteArrayOutputStream.write(128 + by);
                    }
                    byteArrayOutputStream.write(c3);
                }
            }
            ++n3;
        }
        return byteArrayOutputStream.toByteArray();
    }
}

