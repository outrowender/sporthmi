/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.esolutions.fw.util.commons.Buffer;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class TTSStringUtil {
    private static final String[][] SPECIAL_CHARS_ARRAY = new String[][]{{"quot", "34"}, {"amp", "38"}, {"lt", "60"}, {"gt", "62"}, {"apos", "39"}};
    private static final String[] REMOVE_CHARS_ARRAY = new String[]{"42"};
    public static final String PHONEME_ALPHABET_DEFAULT = "x-NAVTEQ-sampa_de-DE";
    public static final String PHONEME_ALPHABET_ASIA_JAPAN = "x-StarRec-EnrichedKana";
    public static final String PHONEME_ALPHABET_ASIA_CHINA = "x-SVOX-pinyin_zh-CN";
    public static final String DSI_STRING_ENCODING = "UTF-8";
    public static final int DSI_STRING_MAX_BYTE_LENGTH = Short.MAX_VALUE;

    public static String escapeXml(String string) {
        StringBuffer stringBuffer = new StringBuffer(string.length() * 2);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            String string2 = TTSStringUtil.replaceChar(c2);
            if (string2 == null) {
                if (TTSStringUtil.removeChar(c2)) {
                    stringBuffer.append(" ");
                    continue;
                }
                stringBuffer.append(c2);
                continue;
            }
            stringBuffer.append('&');
            stringBuffer.append(string2);
            stringBuffer.append(';');
        }
        return stringBuffer.toString();
    }

    public static String escapeJava(String string) {
        return TTSStringUtil.escapeJavaStyleString(string, false);
    }

    private static String escapeJavaStyleString(String string, boolean bl) {
        if (string == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(string.length() * 2);
            TTSStringUtil.escapeJavaStyleString(stringWriter, string, bl);
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    private static void escapeJavaStyleString(Writer writer, String string, boolean bl) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (string == null) {
            return;
        }
        int n = string.length();
        block12: for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 > '\u0fff') {
                writer.write("\\u" + TTSStringUtil.hex(c2));
                continue;
            }
            if (c2 > '\u00ff') {
                writer.write("\\u0" + TTSStringUtil.hex(c2));
                continue;
            }
            if (c2 > '\u007f') {
                writer.write("\\u00" + TTSStringUtil.hex(c2));
                continue;
            }
            if (c2 < ' ') {
                switch (c2) {
                    case '\b': {
                        writer.write(92);
                        writer.write(98);
                        break;
                    }
                    case '\n': {
                        writer.write(92);
                        writer.write(110);
                        break;
                    }
                    case '\t': {
                        writer.write(92);
                        writer.write(116);
                        break;
                    }
                    case '\f': {
                        writer.write(92);
                        writer.write(102);
                        break;
                    }
                    case '\r': {
                        writer.write(92);
                        writer.write(114);
                        break;
                    }
                    default: {
                        if (c2 > '\u000f') {
                            writer.write("\\u00" + TTSStringUtil.hex(c2));
                            break;
                        }
                        writer.write("\\u000" + TTSStringUtil.hex(c2));
                        break;
                    }
                }
                continue;
            }
            switch (c2) {
                case '\'': {
                    if (bl) {
                        writer.write(92);
                    }
                    writer.write(39);
                    continue block12;
                }
                case '\"': {
                    writer.write(92);
                    writer.write(34);
                    continue block12;
                }
                case '\\': {
                    writer.write(92);
                    writer.write(92);
                    continue block12;
                }
                default: {
                    writer.write(c2);
                }
            }
        }
    }

    private static String hex(char c2) {
        return Integer.toHexString(c2).toUpperCase();
    }

    private static String replaceChar(char c2) {
        for (int i2 = 0; i2 < SPECIAL_CHARS_ARRAY.length; ++i2) {
            if (Integer.parseInt(SPECIAL_CHARS_ARRAY[i2][1]) != c2) continue;
            return SPECIAL_CHARS_ARRAY[i2][0];
        }
        return null;
    }

    private static boolean removeChar(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return false;
        }
        if (c2 < ' ' || '\u0080' <= c2 && c2 <= '\u009f') {
            return true;
        }
        for (int i2 = 0; i2 < REMOVE_CHARS_ARRAY.length; ++i2) {
            if (Integer.parseInt(REMOVE_CHARS_ARRAY[i2]) != c2) continue;
            return true;
        }
        return false;
    }

    public static String buildPhonemeString(String string, String string2, String string3) {
        String string4;
        Buffer buffer = new Buffer(200);
        buffer.append("<phoneme alphabet=\"");
        buffer.append(TTSStringUtil.getPhonemeAlphabetRegion(string2));
        buffer.append("\" ph=\"");
        String string5 = TTSStringUtil.escapeJava(string);
        if (string5 != null && (string4 = TTSStringUtil.escapeXml(string5)) != null) {
            buffer.append(string4);
        }
        buffer.append("\">");
        buffer.append(string3);
        buffer.append("</phoneme>");
        return buffer.toString();
    }

    private static String getPhonemeAlphabetRegion(String string) {
        if (string != null) {
            return string;
        }
        return PHONEME_ALPHABET_DEFAULT;
    }

    public static byte[] getBytesDsiEncoding(String string) throws UnsupportedEncodingException {
        byte[] byArray = null;
        if (string != null) {
            byArray = string.getBytes(DSI_STRING_ENCODING);
        }
        return byArray;
    }

    public static String getStringDsiEncoding(byte[] byArray, int n, int n2) throws UnsupportedEncodingException {
        String string = null;
        if (byArray != null) {
            string = new String(byArray, n, n2, DSI_STRING_ENCODING);
        }
        return string;
    }

    public static boolean isDsiMaxByteLengthCompliant(String string) throws UnsupportedEncodingException {
        boolean bl = true;
        if (string != null) {
            bl = TTSStringUtil.getBytesDsiEncoding(string).length <= Short.MAX_VALUE;
        }
        return bl;
    }
}

