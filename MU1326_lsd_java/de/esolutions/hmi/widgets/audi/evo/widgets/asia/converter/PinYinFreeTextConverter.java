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

class PinYinFreeTextConverter
implements IFreetextConverter {
    private static final String pinYinResourcePath = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/china/");
    public static final int MAX_KANJIS = 3072;
    private static final String DELIMITER = "_";
    private static final int NONE = -1;
    private static HashMap nextValidCharsString = new HashMap(25);
    private static HashMap kanjisString = new HashMap(25);
    private static final char[] possibleKanjis = new char[3072];
    private static int numberOfKanjis = 0;

    PinYinFreeTextConverter() {
    }

    public static String getValidPinYinChars(String string) {
        String string2 = "";
        char c2 = ' ';
        char[] cArray = new char[25];
        int n = 0;
        if (string.length() == 0) {
            String string3 = PinYinFreeTextConverter.getCompleteNextValidCharsString('_');
            string3 = string3.toUpperCase();
            string3.getChars(0, string3.length(), cArray, 0);
            n = string3.length();
        } else {
            c2 = string.charAt(0);
            String string4 = PinYinFreeTextConverter.getCompleteNextValidCharsString(c2);
            string4 = string4.toUpperCase();
            int n2 = string4.length();
            int n3 = 0;
            string2 = PinYinFreeTextConverter.getCurrentDelimiter(string);
            for (int i2 = 0; i2 < n2 && (n3 = string4.indexOf(string2, n3)) != -1; ++i2) {
                char c3 = string4.charAt(n3 += string2.length());
                if (c3 == ':' || PinYinFreeTextConverter.charArrayContains(cArray, c3)) continue;
                cArray[n++] = c3;
            }
            if (n == 0) {
                IWidgetLogChannel.spellerLogChannel.log(1000000, "PinYinFreeTextConverter#getValidPinYinChars validCharsBufferIndex is 0 - error while determing valid characters. spelledInCharaters: %1 currentDelimiter: %2", (Object)string, (Object)string2);
            }
            if (IWidgetLogChannel.spellerLogChannel.isDebug()) {
                IWidgetLogChannel.spellerLogChannel.log(10000000, "PinYinFreeTextConverter#getValidPinYinChars validCharsBuffer: %1", (Object)new String(cArray, 0, n));
            }
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
            string = PinYinFreeTextConverter.loadPinYinString(c2, "Follow.pinyin");
            nextValidCharsString.put(c3, string);
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    public static boolean isValidFullPinYin(String string) {
        if (string.length() > 0) {
            char c2 = string.charAt(0);
            String string2 = PinYinFreeTextConverter.getCompleteNextValidCharsString(c2);
            string2 = string2.toUpperCase();
            int n = string2.length();
            int n2 = 0;
            String string3 = PinYinFreeTextConverter.getCurrentDelimiter(string);
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
        if (StringUtilities.isNullOrEmpty(string) || string.length() == 1 && StringUtilities.isNullOrEmpty(PinYinFreeTextConverter.getValidPinYinChars(string))) {
            numberOfKanjis = 0;
            PinYinFreeTextConverter.possibleKanjis[0] = '\u0000';
        } else {
            String string2 = PinYinFreeTextConverter.getCurrentDelimiter(string);
            char c2 = string.charAt(0);
            Character c3 = new Character(c2);
            String string3 = (String)kanjisString.get(c3);
            if (string3 == null) {
                string3 = PinYinFreeTextConverter.loadPinYinString(c2, ".pinyin");
                kanjisString.put(c3, string3);
            }
            string2 = string2.toLowerCase();
            int n2 = 0;
            numberOfKanjis = 0;
            String string4 = string2 + ':';
            if (PinYinFreeTextConverter.getCompleteNextValidCharsString(c2).indexOf(string4) >= 0) {
                char c4 = '\u0000';
                while (numberOfKanjis < n) {
                    char c5;
                    if ((n2 = string3.indexOf(string4, n2)) == -1) {
                        PinYinFreeTextConverter.possibleKanjis[PinYinFreeTextConverter.numberOfKanjis] = '\u0000';
                        break;
                    }
                    n2 = string3.indexOf(58, n2);
                    if ((c5 = string3.charAt(++n2)) == c4) continue;
                    c4 = c5;
                    PinYinFreeTextConverter.possibleKanjis[PinYinFreeTextConverter.numberOfKanjis++] = c5;
                }
            } else {
                PinYinFreeTextConverter.possibleKanjis[0] = '\u0000';
            }
        }
        return possibleKanjis;
    }

    public static int getNumberOfKanjs() {
        return numberOfKanjis;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String loadPinYinString(char c2, String string) {
        FilterInputStream filterInputStream = null;
        FileInputStream fileInputStream = null;
        byte[] byArray = null;
        int n = 0;
        try {
            fileInputStream = new FileInputStream(new Buffer(pinYinResourcePath).append(Character.toUpperCase(c2)).append(string).toString());
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
            IWidgetLogChannel.spellerLogChannel.log(1000, "PinYinFreeTextConverter#loadPinYinString file not found - speller not operational - returning dummy character set", (Throwable)fileNotFoundException);
            byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
        }
        catch (IOException iOException) {
            IWidgetLogChannel.spellerLogChannel.log(1000, "PinYinFreeTextConverter#loadPinYinString io exception occured while reading - speller not operational - returning dummy character set", (Throwable)iOException);
            byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
        }
        finally {
            try {
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
            }
            catch (IOException iOException) {
                IWidgetLogChannel.spellerLogChannel.log(10000, "PinYinFreeTextConverter#loadPinYinString trying to close DataInputStream dis: %1", (Object)filterInputStream);
            }
        }
        String string2 = "";
        try {
            if (byArray != null) {
                string2 = new String(byArray, 0, n, "UTF-8");
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "PinYinFreeTextConverter#loadPinYinString trying to convert read content to String in UTF-8 encoding: %1", (Throwable)unsupportedEncodingException);
        }
        return string2;
    }

    public List getPossibleConversions(String string, int n) {
        ArrayList arrayList = new ArrayList();
        if (!StringUtilities.isNullOrEmpty(string)) {
            arrayList.add(string);
            char[] cArray = PinYinFreeTextConverter.getPossibleKanjis(string, n);
            for (int i2 = 0; i2 < n && cArray[i2] != '\u0000'; ++i2) {
                arrayList.add(String.valueOf(cArray[i2]));
            }
        }
        return arrayList;
    }

    public int getNumberOfConversions() {
        return PinYinFreeTextConverter.getNumberOfKanjs();
    }

    public String getValidCharacters(String string) {
        return PinYinFreeTextConverter.getValidPinYinChars(string);
    }
}

