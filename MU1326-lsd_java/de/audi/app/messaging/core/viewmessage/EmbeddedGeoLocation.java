/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.esolutions.fw.util.commons.Buffer;

public class EmbeddedGeoLocation {
    public static final int LONGITUDE;
    public static final int LATITUDE;
    public static final int DESCRIPTION;
    private static final char CLOSE_TAG;
    private static final char DELIMITER;
    private static final char QUOTE;
    private static final String FIRST_TOKEN;
    private static final String SECOND_TOKEN;
    private static final String GEO_TAG;

    public static String[] extract(String string) {
        String string2 = EmbeddedGeoLocation.getStartTag();
        String string3 = EmbeddedGeoLocation.getEndTag();
        boolean bl = false;
        int n = 0;
        int n2 = 0;
        if (string2.length() == 0 || string3.length() == 0) {
            bl = true;
        } else {
            n = string.indexOf(string2);
            n2 = string.indexOf(string3);
            if (n == -1 || n2 == -1) {
                bl = true;
            }
        }
        if (bl) {
            return new String[0];
        }
        n += EmbeddedGeoLocation.getStartTag().length();
        String[] stringArray = new String[3];
        Buffer buffer = new Buffer();
        while (n < string.length() && string.charAt(n) != ',') {
            buffer.append(string.charAt(n));
            ++n;
        }
        stringArray[0] = buffer.toString().trim();
        buffer.clear();
        ++n;
        while (n < string.length() && string.charAt(n) != '\"') {
            buffer.append(string.charAt(n));
            ++n;
        }
        stringArray[1] = buffer.toString().trim();
        buffer.clear();
        while (n < string.length() && string.charAt(n) != '>') {
            ++n;
        }
        if (n >= string.length()) {
            return new String[0];
        }
        stringArray[2] = string.substring(n, n2).trim();
        return stringArray;
    }

    public static String build(String string, String string2, String string3) {
        Buffer buffer = new Buffer();
        buffer.append(EmbeddedGeoLocation.getStartTag());
        buffer.append(string);
        buffer.append(',');
        buffer.append(string2);
        buffer.append('\"');
        buffer.append('>');
        buffer.append(string3);
        buffer.append(EmbeddedGeoLocation.getEndTag());
        return buffer.toString();
    }

    private static String getStartTag() {
        int n = "<geo pos=\"%1\">%2</geo>".indexOf("%1");
        return n == -1 ? "" : "<geo pos=\"%1\">%2</geo>".substring(0, n);
    }

    private static String getEndTag() {
        int n = "<geo pos=\"%1\">%2</geo>".indexOf("%2") + "%2".length();
        return n == -1 ? "" : "<geo pos=\"%1\">%2</geo>".substring(n, "<geo pos=\"%1\">%2</geo>".length());
    }
}

