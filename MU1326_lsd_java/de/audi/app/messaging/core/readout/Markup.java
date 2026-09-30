/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.util.Strings;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import java.io.UnsupportedEncodingException;

final class Markup {
    Markup() {
    }

    static String escapeXml(String string) {
        return TTSStringUtil.escapeXml(string);
    }

    static void appendText(Buffer buffer, String string) {
        buffer.append(Markup.escapeXml(string));
    }

    static void openTag(Buffer buffer, String string, Attribute[] attributeArray) {
        buffer.append('<');
        buffer.append(string);
        if (attributeArray != null) {
            for (int i2 = 0; i2 < attributeArray.length; ++i2) {
                Attribute attribute = attributeArray[i2];
                buffer.append(' ');
                buffer.append(attribute.key);
                buffer.append("=\"");
                buffer.append(attribute.value);
                buffer.append('\"');
            }
        }
        buffer.append('>');
    }

    static void closeTag(Buffer buffer, String string) {
        buffer.append("</");
        buffer.append(string);
        buffer.append('>');
    }

    static String ensureDsiMaxByteLength(String string, String string2) throws IllegalArgumentException, UnsupportedEncodingException {
        byte[] byArray;
        int n;
        String string3 = string;
        if (!Strings.isNullOrEmpty(string) && (n = (byArray = TTSStringUtil.getBytesDsiEncoding(string)).length - Short.MAX_VALUE) > 0) {
            string3 = Markup.removeTextFromNode(string, n, string2);
        }
        return string3;
    }

    private static String removeTextFromNode(String string, int n, String string2) throws IllegalArgumentException, UnsupportedEncodingException {
        int n2;
        if (Strings.isNullOrEmpty(string)) {
            throw new IllegalArgumentException("Illegal text = " + string);
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Illegal removeByteCount = " + n);
        }
        if (Strings.isNullOrEmpty(string2)) {
            throw new IllegalArgumentException("Illegal nodeTagName = " + string2);
        }
        String string3 = '<' + string2;
        String string4 = "</" + string2;
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        n3 = string.indexOf(string3);
        if (n3 > -1 && (n2 = string.indexOf(62, n3)) > -1) {
            n4 = n2 + 1;
        }
        if (n4 > -1) {
            n5 = string.indexOf(string4, n4);
        }
        if (n3 < 0 || n4 < 0 || n5 < 0) {
            throw new IllegalArgumentException("Cannot find target XML node '" + string2 + "', text = " + string);
        }
        String string5 = string.substring(n4, n5);
        byte[] byArray = TTSStringUtil.getBytesDsiEncoding(string5);
        int n6 = byArray.length;
        if (n6 < n) {
            throw new IllegalArgumentException("Cannot remove " + n + " of " + n6 + " bytes, text = " + string);
        }
        String string6 = TTSStringUtil.getStringDsiEncoding(byArray, 0, n6 - n);
        String string7 = Markup.ensureXmlCompliantTail(string6);
        if (Strings.isNullOrEmpty(string7)) {
            throw new IllegalArgumentException("Target XML node is empty after truncation, text = " + string);
        }
        String string8 = string.substring(0, n4);
        String string9 = string.substring(n5);
        Buffer buffer = new Buffer(string.length());
        buffer.append(string8);
        buffer.append(string7);
        buffer.append(string9);
        return buffer.toString();
    }

    private static String ensureXmlCompliantTail(String string) {
        String string2 = string;
        if (!Strings.isNullOrEmpty(string)) {
            char c2;
            for (int i2 = string.length() - 1; i2 >= 0 && (c2 = string.charAt(i2)) != ';'; --i2) {
                if (c2 != '&') continue;
                string2 = string.substring(0, i2);
                break;
            }
        }
        return string2;
    }

    public static class Attribute {
        public final String key;
        public final String value;

        public Attribute(String string, String string2) {
            this.key = string;
            this.value = string2;
        }
    }
}

