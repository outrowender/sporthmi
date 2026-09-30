/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.IFreetextConverter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrokeFreeTextConverter
implements IFreetextConverter {
    public static final char[] EMPTY_CONVERSIONS = new char[]{'\u0000'};
    private static final String strokeResourcePath = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/china/");
    public static final int MAX_KANJIS = 3072;
    private static final String DELIMITER = "_";
    private static final int NONE = -1;
    private static HashMap nextValidCharsString = new HashMap(5);
    private static HashMap kanjisString = new HashMap(5);
    private static final char[] possibleKanjis = new char[3072];
    private static int numberOfKanjis = 0;

    StrokeFreeTextConverter() {
    }

    public static String getValidStrokeChars(String string) {
        String string2;
        String string3 = "";
        char c2 = ' ';
        char[] cArray = new char[5];
        int n = 0;
        Buffer buffer = StrokeFreeTextConverter.convertSpelledInCharsToInternalFormat(string);
        if (buffer.length() != string.length()) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "StrokeFreeTextConverter#getValidStrokeChars: \"%1\" contained illegal Stroke characters. Returning empty String as next valid Strokes.", (Object)string);
            return "";
        }
        if (string.length() == 0) {
            string2 = StrokeFreeTextConverter.getCompleteNextValidCharsString('_');
            string2 = string2.toUpperCase();
            string2.getChars(0, string2.length(), cArray, 0);
            n = string2.length();
        } else {
            c2 = buffer.charAt(0);
            string2 = StrokeFreeTextConverter.getCompleteNextValidCharsString(c2);
            string2 = string2.toUpperCase();
            int n2 = string2.length();
            int n3 = 0;
            string3 = StrokeFreeTextConverter.getCurrentDelimiter(buffer.toString());
            for (int i2 = 0; i2 < n2 && (n3 = string2.indexOf(string3, n3)) != -1; ++i2) {
                char c3 = string2.charAt(n3 += string3.length());
                if (c3 == ':' || StrokeFreeTextConverter.charArrayContains(cArray, c3)) continue;
                cArray[n++] = c3;
            }
            if (n == 0) {
                IWidgetLogChannel.spellerLogChannel.log(1000000, "SpellerController#getValidStrokeChars validCharsBufferIndex is 0 - error while determing valid characters. spelledInCharaters: %1 currentDelimiter: %2", (Object)string, (Object)string3);
            }
            if (IWidgetLogChannel.spellerLogChannel.isDebug()) {
                IWidgetLogChannel.spellerLogChannel.log(10000000, "SpellerControllerChina#getValidStrokeChars validCharsBuffer: %1", (Object)new String(cArray, 0, n));
            }
        }
        for (int i3 = 0; i3 < cArray.length; ++i3) {
            if (cArray[i3] == '1') {
                cArray[i3] = 19968;
                continue;
            }
            if (cArray[i3] == '2') {
                cArray[i3] = 20008;
                continue;
            }
            if (cArray[i3] == '3') {
                cArray[i3] = 20031;
                continue;
            }
            if (cArray[i3] == '4') {
                cArray[i3] = 20022;
                continue;
            }
            if (cArray[i3] != '5') continue;
            cArray[i3] = 20057;
        }
        return new String(cArray, 0, n);
    }

    private static String getCurrentDelimiter(String string) {
        int n = string.length();
        if (n > 1) {
            return DELIMITER + string.substring(1, n);
        }
        return DELIMITER;
    }

    private static boolean charArrayContains(char[] cArray, char c2) {
        boolean bl = false;
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (cArray[i2] == c2) {
                bl = true;
                break;
            }
            if (cArray[i2] == '\u0000') break;
        }
        return bl;
    }

    private static String getCompleteNextValidCharsString(char c2) {
        Character c3 = new Character(c2);
        String string = (String)nextValidCharsString.get(c3);
        if (string == null) {
            string = StrokeFreeTextConverter.loadStrokeString(c2, "Follow.strokes");
            nextValidCharsString.put(c3, string);
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    public static boolean isValidFullStroke(String string) {
        if (string.length() > 0) {
            char c2 = string.charAt(0);
            String string2 = StrokeFreeTextConverter.getCompleteNextValidCharsString(c2);
            string2 = string2.toUpperCase();
            int n = string2.length();
            int n2 = 0;
            String string3 = StrokeFreeTextConverter.getCurrentDelimiter(string);
            boolean bl = false;
            for (int i2 = 0; i2 < n && (n2 = string2.indexOf(string3, n2)) != -1; ++i2) {
                char c3 = string2.charAt(n2 += string3.length());
                if (c3 != ':') continue;
                bl = true;
                break;
            }
            return bl;
        }
        return false;
    }

    public static char[] getPossibleKanjis(String string, int n) {
        if (string == null || string.length() == 0) {
            numberOfKanjis = 0;
            return EMPTY_CONVERSIONS;
        }
        Buffer buffer = StrokeFreeTextConverter.convertSpelledInCharsToInternalFormat(string);
        if (buffer.length() != string.length()) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "StrokeFreeTextConverter#getPossibleKanjis: \"%1\" contained illegal Stroke characters. Returning 0 possible conversions.", (Object)string);
            numberOfKanjis = 0;
            return EMPTY_CONVERSIONS;
        }
        String string2 = StrokeFreeTextConverter.getCurrentDelimiter(buffer.toString());
        char c2 = buffer.charAt(0);
        Character c3 = new Character(c2);
        String string3 = (String)kanjisString.get(c3);
        if (string3 == null) {
            string3 = StrokeFreeTextConverter.loadStrokeString(c2, ".strokes");
            kanjisString.put(c3, string3);
        }
        string2 = string2.toLowerCase();
        int n2 = 0;
        numberOfKanjis = 0;
        String string4 = string2 + ':';
        if (StrokeFreeTextConverter.getCompleteNextValidCharsString(c2).indexOf(string4) >= 0) {
            char c4 = '\u0000';
            while (numberOfKanjis < n) {
                char c5;
                if ((n2 = string3.indexOf(string4, n2)) == -1) {
                    StrokeFreeTextConverter.possibleKanjis[StrokeFreeTextConverter.numberOfKanjis] = '\u0000';
                    break;
                }
                n2 = string3.indexOf(58, n2);
                if ((c5 = string3.charAt(++n2)) == c4) continue;
                c4 = c5;
                StrokeFreeTextConverter.possibleKanjis[StrokeFreeTextConverter.numberOfKanjis++] = c5;
            }
        } else {
            for (int i2 = 0; i2 < n && possibleKanjis[numberOfKanjis] != '\u0000'; ++i2) {
                StrokeFreeTextConverter.possibleKanjis[StrokeFreeTextConverter.numberOfKanjis] = '\u0000';
            }
        }
        return possibleKanjis;
    }

    private static Buffer convertSpelledInCharsToInternalFormat(String string) {
        Buffer buffer = new Buffer(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == '\u4e00') {
                buffer.append('1');
                continue;
            }
            if (string.charAt(i2) == '\u4e28') {
                buffer.append('2');
                continue;
            }
            if (string.charAt(i2) == '\u4e3f') {
                buffer.append('3');
                continue;
            }
            if (string.charAt(i2) == '\u4e36') {
                buffer.append('4');
                continue;
            }
            if (string.charAt(i2) != '\u4e59') continue;
            buffer.append('5');
        }
        return buffer;
    }

    public static int getNumberOfKanjs() {
        return numberOfKanjis;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String loadStrokeString(char c2, String string) {
        FilterInputStream filterInputStream = null;
        FileInputStream fileInputStream = null;
        byte[] byArray = null;
        int n = 0;
        char c3 = c2;
        String string2 = Integer.toHexString(c3);
        if (!StringUtility.containsCharacter("12345", c2)) {
            if (string2.equalsIgnoreCase("4E00")) {
                c2 = (char)49;
            } else if (string2.equalsIgnoreCase("4E28")) {
                c2 = (char)50;
            } else if (string2.equalsIgnoreCase("4E3F")) {
                c2 = (char)51;
            } else if (string2.equalsIgnoreCase("4E36")) {
                c2 = (char)52;
            } else if (string2.equalsIgnoreCase("4E59")) {
                c2 = (char)53;
            } else {
                IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerChina#loadStrokeString unknown filename: %1", (Object)string2);
            }
        }
        try {
            fileInputStream = new FileInputStream(new Buffer(strokeResourcePath).append(c2).append(string).toString());
            filterInputStream = new DataInputStream(fileInputStream);
            int n2 = ((DataInputStream)filterInputStream).readInt();
            byArray = new byte[n2];
            int n3 = 0;
            int n4 = 0;
            while (n3 != -1) {
                if (n4 >= byArray.length) {
                    break;
                }
                n3 = ((DataInputStream)filterInputStream).read(byArray, n4, byArray.length - n4);
                if (n3 > 0) {
                    n += n3;
                }
                n4 += n3;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            IWidgetLogChannel.spellerLogChannel.log(1000, "SpellerControllerChina#loadStrokeString file not found - speller not operational - returning dummy character set", (Throwable)fileNotFoundException);
            byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
        }
        catch (IOException iOException) {
            IWidgetLogChannel.spellerLogChannel.log(1000, "SpellerControllerChina#loadStrokeString io exception occured while reading - speller not operational - returning dummy character set", (Throwable)iOException);
            byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
            }
            catch (IOException iOException) {
                IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerChina#loadStrokeString trying to close DataInputStream dis: %1", (Object)filterInputStream);
            }
        }
        String string3 = "";
        try {
            if (byArray != null) {
                string3 = new String(byArray, 0, n, "UTF-8");
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerChina#loadStrokeString trying to convert read content to String in UTF-8 encoding: %1", (Throwable)unsupportedEncodingException);
        }
        return string3;
    }

    public List getPossibleConversions(String string, int n) {
        ArrayList arrayList = new ArrayList();
        if (!StringUtilities.isNullOrEmpty(string)) {
            char[] cArray = StrokeFreeTextConverter.getPossibleKanjis(string, n);
            for (int i2 = 0; i2 < n && cArray[i2] != '\u0000'; ++i2) {
                arrayList.add(String.valueOf(cArray[i2]));
            }
        }
        return arrayList;
    }

    public int getNumberOfConversions() {
        return StrokeFreeTextConverter.getNumberOfKanjs();
    }

    public String getValidCharacters(String string) {
        return StrokeFreeTextConverter.getValidStrokeChars(string);
    }
}

