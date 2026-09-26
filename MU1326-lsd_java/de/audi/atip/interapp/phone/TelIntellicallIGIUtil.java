/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.esolutions.fw.util.commons.Buffer;

public class TelIntellicallIGIUtil {
    private static final Buffer NUMBER_VALID;
    public static final String VALID_SPECIAL_SYMBOLS_FOR_NUMBER;
    public static final String VALID_PHONE_NUMBER_SYMBOLS;

    public static boolean isSpecialPhoneCharacter(char c2) {
        return c2 >= '0' && c2 <= '9' || c2 == '+' || c2 == '*' || c2 == '#';
    }

    public static String getValidPhoneNumber(String string) {
        if (string != null && string.length() > 0) {
            char[] cArray = string.toCharArray();
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                char c2;
                if (i2 == 0) {
                    c2 = cArray[i2];
                    if ("O".equalsIgnoreCase(String.valueOf(c2))) {
                        c2 = '0';
                        buffer.append(c2);
                        continue;
                    }
                    if (!TelIntellicallIGIUtil.isSpecialPhoneCharacter(c2)) break;
                    buffer.append(c2);
                    continue;
                }
                if (i2 == 1) {
                    c2 = cArray[i2];
                    if ("O".equalsIgnoreCase(String.valueOf(c2))) {
                        c2 = '0';
                        buffer.append(c2);
                        continue;
                    }
                    if (c2 >= '0' && c2 <= '9' || c2 == '*' || c2 == '#') {
                        buffer.append(c2);
                        continue;
                    }
                    buffer.clear();
                    break;
                }
                c2 = cArray[i2];
                if (c2 >= '0' && c2 <= '9' || c2 >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z' || c2 == '*' || c2 == '#' || c2 == ' ' || c2 == '-') {
                    buffer.append(c2);
                    continue;
                }
                buffer.clear();
                break;
            }
            if (buffer.length() > 0) {
                return buffer.toString();
            }
            return null;
        }
        return null;
    }

    static {
        int n;
        NUMBER_VALID = new Buffer();
        for (n = 97; n <= 122; n = (char)(n + '\u0001')) {
            NUMBER_VALID.append((char)n);
        }
        for (n = 65; n <= 90; n = (char)(n + '\u0001')) {
            NUMBER_VALID.append((char)n);
        }
        for (n = 0; n <= 9; ++n) {
            NUMBER_VALID.append(n);
        }
        NUMBER_VALID.append("+*#");
        VALID_PHONE_NUMBER_SYMBOLS = NUMBER_VALID.toString();
    }
}

