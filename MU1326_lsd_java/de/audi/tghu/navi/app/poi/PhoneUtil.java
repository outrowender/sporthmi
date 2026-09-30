/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.util.Util;

public class PhoneUtil {
    private static final int ACCESS_CODE = 0;
    private static final int AREA_CODE = 1;
    private static final int LOCAL_NUMBER = 2;
    private static final int MAX = 3;
    private static final int PARENTHESIS_MAX = 4;
    private static final String COUNTRY_ABBREVIATION_HAWAII = "HI";
    private static final String COUNTRY_ABBREVIATION_CANADA = "CDN";
    private static final String COUNTRY_ABBREVIATION_MEXICO = "MEX";
    private static final String COUNTRY_ABBREVIATION_PUERTORICO = "PR";
    private static final String COUNTRY_ABBREVIATION_USA = "USA";
    private static final String COUNTRY_ABBREVIATION_VIRGINISLANDS = "VI";
    private static final String ACCESS_CODE_MEXICO = "52";
    private static final String ACCESS_CODE_USA = "1";
    private static final String ACCESS_CODE_MEX_TO_USA = "001";
    private static final String ACCESS_CODE_USA_TO_MEX = "011 52";
    private static final String SPACE = " ";
    private static StringBuffer tmpStringBuffer = new StringBuffer();
    private static String[] phoneNumberParts = new String[3];
    private static int[] parenthesisIndices = new int[4];

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String formatPhonenumber(String string) {
        if (Util.isEmpty(string)) {
            return string;
        }
        String string2 = string;
        StringBuffer stringBuffer = tmpStringBuffer;
        synchronized (stringBuffer) {
            boolean bl = PhoneUtil.splitPhonenumber(string, phoneNumberParts);
            if (bl) {
                if (!Util.isHURegionNAR()) {
                    PhoneUtil.clearTmpStringBuffer();
                    if (phoneNumberParts[0] != null) {
                        tmpStringBuffer.append('+').append(phoneNumberParts[0]).append(SPACE);
                    }
                    if (phoneNumberParts[1] != null) {
                        tmpStringBuffer.append('(').append(phoneNumberParts[1]).append(')').append(SPACE);
                    }
                    if (phoneNumberParts[2] != null) {
                        tmpStringBuffer.append(phoneNumberParts[2]);
                    }
                    string2 = tmpStringBuffer.toString();
                } else {
                    string2 = PhoneUtil.formatPhonenumberNAR();
                }
            }
        }
        return string2;
    }

    private static String formatPhonenumberNAR() {
        PhoneUtil.clearTmpStringBuffer();
        String string = Vehicle.getInstance().getCountryAbbreviation();
        if (PhoneUtil.isSimilarUSA(string)) {
            if (ACCESS_CODE_MEXICO.equalsIgnoreCase(phoneNumberParts[0])) {
                tmpStringBuffer.append(ACCESS_CODE_USA_TO_MEX).append(SPACE);
            } else if (ACCESS_CODE_USA.equalsIgnoreCase(phoneNumberParts[0])) {
                tmpStringBuffer.append(ACCESS_CODE_USA).append(SPACE);
            } else {
                tmpStringBuffer.append(phoneNumberParts[0]).append(SPACE);
            }
        } else if (COUNTRY_ABBREVIATION_MEXICO.equalsIgnoreCase(string)) {
            if (!ACCESS_CODE_MEXICO.equalsIgnoreCase(phoneNumberParts[0])) {
                if (ACCESS_CODE_USA.equalsIgnoreCase(phoneNumberParts[0])) {
                    tmpStringBuffer.append(ACCESS_CODE_MEX_TO_USA).append(SPACE);
                } else {
                    tmpStringBuffer.append(phoneNumberParts[0]).append(SPACE);
                }
            }
        } else {
            tmpStringBuffer.append(phoneNumberParts[0]).append(SPACE);
        }
        if (phoneNumberParts[1] != null) {
            tmpStringBuffer.append('(').append(phoneNumberParts[1]).append(')').append(SPACE);
        }
        if (phoneNumberParts[2] != null) {
            int n = phoneNumberParts[2].length();
            if (n > 4) {
                int n2 = n - 4;
                tmpStringBuffer.append(phoneNumberParts[2].substring(0, n2)).append('-').append(phoneNumberParts[2].substring(n2, n));
            } else {
                tmpStringBuffer.append(phoneNumberParts[2]);
            }
        }
        return tmpStringBuffer.toString();
    }

    private static boolean isSimilarUSA(String string) {
        return COUNTRY_ABBREVIATION_USA.equalsIgnoreCase(string) || COUNTRY_ABBREVIATION_CANADA.equalsIgnoreCase(string) || COUNTRY_ABBREVIATION_VIRGINISLANDS.equalsIgnoreCase(string) || COUNTRY_ABBREVIATION_HAWAII.equalsIgnoreCase(string) || COUNTRY_ABBREVIATION_PUERTORICO.equalsIgnoreCase(string);
    }

    private static boolean splitPhonenumber(String string, String[] stringArray) {
        int n;
        int n2;
        boolean bl;
        for (bl = false; bl < stringArray.length; bl += 1) {
            stringArray[bl] = null;
        }
        bl = true;
        boolean bl2 = false;
        int n3 = 0;
        int n4 = string.length();
        for (n2 = 0; n3 < 4 && n2 < n4; ++n2) {
            n = string.charAt(n2);
            if (n == 40) {
                if (bl2) {
                    bl = false;
                    break;
                }
                bl2 = true;
                PhoneUtil.parenthesisIndices[n3++] = n2;
                continue;
            }
            if (n != 41) continue;
            if (!bl2) {
                bl = false;
                break;
            }
            bl2 = false;
            PhoneUtil.parenthesisIndices[n3++] = n2;
        }
        boolean bl3 = bl = n3 > 0 && n3 % 2 == 0;
        if (bl) {
            if (n3 >= 2) {
                stringArray[0] = string.substring(parenthesisIndices[0] + 1, parenthesisIndices[1]);
            }
            if (n3 == 4) {
                stringArray[1] = string.substring(parenthesisIndices[2] + 1, parenthesisIndices[3]);
            }
            n2 = n3 == 0 ? 0 : parenthesisIndices[n3 - 1] + 1;
            stringArray[2] = string.substring(n2, n4);
            for (n = 0; n < stringArray.length; ++n) {
                stringArray[n] = PhoneUtil.removeNonDigits(stringArray[n]);
            }
        }
        return bl;
    }

    private static String removeNonDigits(String string) {
        String string2 = null;
        if (string != null) {
            PhoneUtil.clearTmpStringBuffer();
            int n = string.length();
            for (int i2 = 0; i2 < n; ++i2) {
                char c2 = string.charAt(i2);
                if (!Character.isDigit(c2)) continue;
                tmpStringBuffer.append(c2);
            }
            string2 = tmpStringBuffer.toString();
        }
        return string2;
    }

    private static void clearTmpStringBuffer() {
        tmpStringBuffer.delete(0, tmpStringBuffer.length());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String makePhonenumberDialable(NavigationEnv navigationEnv, String string) {
        String string2 = string;
        if (string != null) {
            StringBuffer stringBuffer = tmpStringBuffer;
            synchronized (stringBuffer) {
                tmpStringBuffer.delete(0, tmpStringBuffer.length());
                int n = string.length();
                for (int i2 = 0; i2 < n; ++i2) {
                    char c2 = string.charAt(i2);
                    if (c2 == ' ' || c2 == '(' || c2 == ')' || c2 == '-') continue;
                    tmpStringBuffer.append(c2);
                }
                string2 = tmpStringBuffer.toString();
            }
        } else {
            navigationEnv.getLogChannel().log(10000, "PhoneUtil#makePhonenumberDialable() - given phone number is null! ");
        }
        return string2;
    }
}

