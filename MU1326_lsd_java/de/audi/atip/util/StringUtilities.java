/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.util.StringUtilities$1;
import de.audi.atip.util.StringUtilities$2;
import de.audi.atip.util.StringUtilities$Accessor;
import de.esolutions.fw.util.commons.Buffer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class StringUtilities {
    private StringUtilities() {
    }

    public static void formatMessage(Buffer buffer, String string, StringUtilities$Accessor accessor) {
        StringUtilities.formatMessage(buffer, string, accessor, null);
    }

    public static void formatMessage(Buffer buffer, String string, StringUtilities$Accessor stringUtilities$Accessor, String string2) {
        int n = 0;
        int n2 = 0;
        if (stringUtilities$Accessor == null) {
            buffer.append(string);
        } else {
            while (n >= 0 && (n = string.indexOf(37, n2)) >= 0) {
                buffer.append(string.substring(n2, n));
                if (string2 != null) {
                    buffer.append(string2);
                }
                n2 = n + 2;
                if (n + 1 == string.length()) {
                    buffer.append('%');
                    --n2;
                    break;
                }
                char c2 = string.charAt(n + 1);
                int n3 = c2 - 49;
                if (n3 >= 0 && n3 < stringUtilities$Accessor.getLength()) {
                    stringUtilities$Accessor.appendArg(buffer, n3, n);
                    continue;
                }
                if (c2 == '%') {
                    buffer.append('%');
                    continue;
                }
                buffer.append('%');
                --n2;
            }
            buffer.append(string.substring(n2));
        }
    }

    public static void formatMessage(Buffer buffer, String string, String[] stringArray) {
        StringUtilities.formatMessage(buffer, string, stringArray, null);
    }

    public static void formatMessage(Buffer buffer, String string, String[] stringArray, String string2) {
        StringUtilities.formatMessage(buffer, string, new StringUtilities$1(stringArray), string2);
    }

    public static void formatMessage(Buffer buffer, String string, int[] nArray) {
        StringUtilities.formatMessage(buffer, string, new StringUtilities$2(nArray));
    }

    public static String formatMessage(String string, String[] stringArray) {
        return StringUtilities.formatMessage(string, stringArray, null);
    }

    public static String formatMessage(String string, String[] stringArray, String string2) {
        Buffer buffer = new Buffer();
        StringUtilities.formatMessage(buffer, string, stringArray, string2);
        return buffer.toString();
    }

    public static String formatMessage(String string, int[] nArray) {
        Buffer buffer = new Buffer();
        StringUtilities.formatMessage(buffer, string, nArray);
        return buffer.toString();
    }

    public static String cutStringAt(String string, int n) {
        if (string == null || n <= 0) {
            return "";
        }
        if (string.length() > n) {
            return string.substring(0, n);
        }
        return string;
    }

    public static List split(String string, char c2) {
        int n;
        if (string == null || string.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(10);
        int n2 = 0;
        int n3 = string.length();
        while (n2 < n3 && (n = string.indexOf(c2, n2)) != -1) {
            arrayList.add(string.substring(n2, n));
            n2 = n + 1;
        }
        arrayList.add(string.substring(n2));
        return arrayList;
    }

    public static String concatStringArray(List list, String string) {
        if (list == null || list.size() == 0) {
            return "";
        }
        return StringUtilities.concatStringArray(list, 0, list.size(), string);
    }

    public static String concatStringArray(List list, int n, int n2, String string) {
        int n3;
        int n4 = n3 = list == null ? 0 : list.size();
        if (n3 == 0) {
            return "";
        }
        if (string == null) {
            string = "";
        }
        if (n >= n3 || n < 0 || n2 > n3 || n2 < n) {
            throw new IllegalArgumentException(new StringBuffer().append("Array Index out of Bounds size: ").append(list.size()).append(" start: ").append(n).append(" endIndex[excluded] ").append(n2).toString());
        }
        Buffer buffer = new Buffer();
        String string2 = "";
        ListIterator listIterator = list.listIterator(n);
        while (listIterator.nextIndex() < n2) {
            buffer.append(string2).append((String)listIterator.next());
            string2 = string;
        }
        return buffer.toString();
    }

    public static String getStringBetween(String string, String string2, String string3, boolean bl) {
        int n;
        int n2 = n = string == null ? 0 : string.length();
        if (n == 0) {
            return "";
        }
        int n3 = string.indexOf(string2);
        if (n3 == -1 || n3 == n - 1) {
            return "";
        }
        int n4 = bl ? string.lastIndexOf(string3) : string.indexOf(string3, n3 + 1);
        if (n4 <= n3 + 1 || n3 == -1 || n4 == -1) {
            return "";
        }
        return string.substring(n3 + 1, n4);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String getStringNotNull(String string) {
        return string == null ? "" : string;
    }

    public static boolean equals(String string, String string2) {
        return string == null ? string2 == null : string.equals(string2);
    }

    public static String getParameterValue(String string, String string2) {
        String string3;
        if (string == null || string.length() == 0) {
            return null;
        }
        int n = string.indexOf(63);
        if (n == -1 || n + 1 == string.length()) {
            return null;
        }
        String string4 = string.substring(n + 1);
        if ((n = string4.indexOf(string3 = string2.concat("="))) == -1) {
            return null;
        }
        if ((n += string3.length()) > string4.length()) {
            return "";
        }
        String string5 = string4.substring(n);
        n = string5.indexOf(38);
        try {
            string5 = URLDecoder.decode(n >= 0 ? string5.substring(0, n) : string5, System.getProperty("file.encoding"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string5 = null;
        }
        return string5;
    }

    public static final String[] split(String string, String string2) {
        if (string == null) {
            return null;
        }
        int n = (string = string.trim()).length();
        if (n == 0 || string2 == null) {
            return new String[]{string};
        }
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        int n3 = 0;
        while ((n3 = string.indexOf(string2, n2)) != -1) {
            arrayList.add(string.substring(n2, n3));
            n2 = n3 + string2.length();
        }
        if (n2 <= n) {
            arrayList.add(string.substring(n2));
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public static String trimEnd(String string) {
        int n;
        if (!string.endsWith(" ")) {
            return string;
        }
        for (n = string.length() - 1; n > 0 && string.charAt(n - 1) == ' '; --n) {
        }
        return string.substring(0, n);
    }
}

