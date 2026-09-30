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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZhuYinFreeTextConverter
implements IFreetextConverter {
    private static final String zhuYinResourcePath = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/taiwan/");
    public static final int MAX_KANJIS = 3072;
    private static final String DELIMITER = "_";
    private static final int NONE = -1;
    private static HashMap nextValidCharsString = new HashMap(45);
    private static HashMap kanjisString = new HashMap(45);
    private static final char[] possibleKanjis = new char[3072];
    private static int numberOfKanjis = 0;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$widgets$asia$converter$ZhuYinFreeTextConverter;

    ZhuYinFreeTextConverter() {
    }

    public static String getValidZhuYinChars(String string) {
        String string2 = "";
        char c2 = ' ';
        char[] cArray = new char[37];
        int n = 0;
        if (string.length() == 0) {
            String string3 = ZhuYinFreeTextConverter.getCompleteNextValidCharsString('_');
            string3 = string3.toUpperCase();
            string3.getChars(0, string3.length(), cArray, 0);
            n = string3.length();
        } else {
            c2 = string.charAt(0);
            String string4 = ZhuYinFreeTextConverter.getCompleteNextValidCharsString(c2);
            string4 = string4.toUpperCase();
            int n2 = string4.length();
            int n3 = 0;
            string2 = ZhuYinFreeTextConverter.getCurrentDelimiter(string);
            for (int i2 = 0; i2 < n2 && (n3 = string4.indexOf(string2, n3)) != -1; ++i2) {
                char c3 = string4.charAt(n3 += string2.length());
                if (c3 == ':' || ZhuYinFreeTextConverter.charArrayContains(cArray, c3)) continue;
                cArray[n++] = c3;
            }
            if (n == 0) {
                IWidgetLogChannel.spellerLogChannel.log(1000000, "SpellerController#getValidZhuYinChars validCharsBufferIndex is 0 - error while determing valid characters. spelledInCharaters: %1 currentDelimiter: %2", (Object)ZhuYinFreeTextConverter.convertToUnicode(string.toString()), (Object)string2);
            }
            if (IWidgetLogChannel.spellerLogChannel.isDebug()) {
                IWidgetLogChannel.spellerLogChannel.log(10000000, "SpellerControllerTaiwan#getValidZhuYinChars validCharsBuffer: %1", (Object)ZhuYinFreeTextConverter.convertToUnicode(new String(cArray, 0, n)));
            }
        }
        return new String(cArray, 0, n);
    }

    private static String getCurrentDelimiter(String string) {
        int n = string.length();
        if (n > 1) {
            return new StringBuffer().append(DELIMITER).append(string.substring(1, n)).toString();
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
            string = ZhuYinFreeTextConverter.loadZhuYinString(c2, "Follow.zhuyin");
            nextValidCharsString.put(c3, string);
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    public static boolean isValidFullzhuYin(String string) {
        if (string.length() > 0) {
            char c2 = string.charAt(0);
            String string2 = ZhuYinFreeTextConverter.getCompleteNextValidCharsString(c2);
            string2 = string2.toUpperCase();
            int n = string2.length();
            int n2 = 0;
            String string3 = ZhuYinFreeTextConverter.getCurrentDelimiter(string);
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
        if (StringUtilities.isNullOrEmpty(string) || string.length() == 1 && StringUtilities.isNullOrEmpty(ZhuYinFreeTextConverter.getValidZhuYinChars(string))) {
            numberOfKanjis = 0;
            ZhuYinFreeTextConverter.possibleKanjis[0] = '\u0000';
        } else {
            String string2 = ZhuYinFreeTextConverter.getCurrentDelimiter(string);
            char c2 = string.charAt(0);
            Character c3 = new Character(c2);
            String string3 = (String)kanjisString.get(c3);
            if (string3 == null) {
                string3 = ZhuYinFreeTextConverter.loadZhuYinString(c2, ".zhuyin");
                kanjisString.put(c3, string3);
            }
            string2 = string2.toLowerCase();
            int n2 = 0;
            numberOfKanjis = 0;
            String string4 = new StringBuffer().append(string2).append(':').toString();
            if (ZhuYinFreeTextConverter.getCompleteNextValidCharsString(c2).indexOf(string4) >= 0) {
                char c4 = '\u0000';
                while (numberOfKanjis < n) {
                    char c5;
                    if ((n2 = string3.indexOf(string4, n2)) == -1) {
                        ZhuYinFreeTextConverter.possibleKanjis[ZhuYinFreeTextConverter.numberOfKanjis] = '\u0000';
                        break;
                    }
                    n2 = string3.indexOf(58, n2);
                    if ((c5 = string3.charAt(++n2)) == c4) continue;
                    c4 = c5;
                    ZhuYinFreeTextConverter.possibleKanjis[ZhuYinFreeTextConverter.numberOfKanjis++] = c5;
                }
            } else {
                ZhuYinFreeTextConverter.possibleKanjis[0] = '\u0000';
            }
        }
        return possibleKanjis;
    }

    public static int getNumberOfKanjs() {
        return numberOfKanjis;
    }

    protected static ClassLoader getResourceClassLoader() {
        ClassLoader classLoader = (class$de$esolutions$hmi$widgets$audi$evo$widgets$asia$converter$ZhuYinFreeTextConverter == null ? (class$de$esolutions$hmi$widgets$audi$evo$widgets$asia$converter$ZhuYinFreeTextConverter = ZhuYinFreeTextConverter.class$("de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ZhuYinFreeTextConverter")) : class$de$esolutions$hmi$widgets$audi$evo$widgets$asia$converter$ZhuYinFreeTextConverter).getClassLoader();
        return classLoader != null ? classLoader : ClassLoader.getSystemClassLoader();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static String loadZhuYinString(char c2, String string) {
        Object object;
        int n;
        byte[] byArray;
        block62: {
            char c3;
            FilterInputStream filterInputStream = null;
            byArray = null;
            n = 0;
            switch (c2) {
                case '\u3105': {
                    c3 = 'A';
                    break;
                }
                case '\u3106': {
                    c3 = 'B';
                    break;
                }
                case '\u3107': {
                    c3 = 'C';
                    break;
                }
                case '\u3108': {
                    c3 = 'D';
                    break;
                }
                case '\u3109': {
                    c3 = 'E';
                    break;
                }
                case '\u3110': {
                    c3 = 'F';
                    break;
                }
                case '\u310a': {
                    c3 = 'G';
                    break;
                }
                case '\u310b': {
                    c3 = 'H';
                    break;
                }
                case '\u310c': {
                    c3 = 'I';
                    break;
                }
                case '\u310d': {
                    c3 = 'J';
                    break;
                }
                case '\u310e': {
                    c3 = 'K';
                    break;
                }
                case '\u310f': {
                    c3 = 'L';
                    break;
                }
                case '\u3111': {
                    c3 = 'M';
                    break;
                }
                case '\u3112': {
                    c3 = 'N';
                    break;
                }
                case '\u3113': {
                    c3 = 'O';
                    break;
                }
                case '\u3114': {
                    c3 = 'P';
                    break;
                }
                case '\u3115': {
                    c3 = 'Q';
                    break;
                }
                case '\u3116': {
                    c3 = 'R';
                    break;
                }
                case '\u3117': {
                    c3 = 'S';
                    break;
                }
                case '\u3118': {
                    c3 = 'T';
                    break;
                }
                case '\u3119': {
                    c3 = 'U';
                    break;
                }
                case '\u311a': {
                    c3 = 'V';
                    break;
                }
                case '\u311b': {
                    c3 = 'W';
                    break;
                }
                case '\u311c': {
                    c3 = 'X';
                    break;
                }
                case '\u311d': {
                    c3 = 'Y';
                    break;
                }
                case '\u311e': {
                    c3 = 'Z';
                    break;
                }
                case '\u311f': {
                    c3 = '1';
                    break;
                }
                case '\u3120': {
                    c3 = '2';
                    break;
                }
                case '\u3121': {
                    c3 = '3';
                    break;
                }
                case '\u3122': {
                    c3 = '4';
                    break;
                }
                case '\u3123': {
                    c3 = '5';
                    break;
                }
                case '\u3124': {
                    c3 = '6';
                    break;
                }
                case '\u3125': {
                    c3 = '7';
                    break;
                }
                case '\u3126': {
                    c3 = '8';
                    break;
                }
                case '\u3127': {
                    c3 = '9';
                    break;
                }
                case '\u3128': {
                    c3 = '0';
                    break;
                }
                case '\u3129': {
                    c3 = '+';
                    break;
                }
                default: {
                    c3 = c2;
                }
            }
            try {
                object = new File(new Buffer(zhuYinResourcePath).append(c3).append(string).toString());
                if (!((File)object).exists()) {
                    IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerTaiwan#loadzhuYinString file not found: %1", (Object)new StringBuffer().append(zhuYinResourcePath).append(c3).append(string).toString());
                    break block62;
                }
                FileInputStream fileInputStream = new FileInputStream((File)object);
                filterInputStream = new DataInputStream(fileInputStream);
                int n2 = ((DataInputStream)filterInputStream).readInt();
                IWidgetLogChannel.spellerLogChannel.log(10000000, "SpellerControllerTaiwan#loadzhuYinString length of file: %1", (long)n2);
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
                IWidgetLogChannel.spellerLogChannel.log(1000, "SpellerControllerTaiwan#loadzhuYinString file not found - speller not operational - returning dummy character set", (Throwable)fileNotFoundException);
                byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
            }
            catch (IOException iOException) {
                IWidgetLogChannel.spellerLogChannel.log(1000, "SpellerControllerTaiwan#loadzhuYinString io exception occured while reading - speller not operational - returning dummy character set", (Throwable)iOException);
                byArray = new byte[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 43};
            }
            finally {
                try {
                    if (filterInputStream != null) {
                        filterInputStream.close();
                    }
                }
                catch (IOException iOException) {
                    IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerTaiwan#loadzhuYinString trying to close DataInputStream dis: %1", (Object)filterInputStream);
                }
            }
        }
        object = null;
        try {
            if (byArray != null) {
                object = new String(byArray, 0, n, "UTF-8");
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            IWidgetLogChannel.spellerLogChannel.log(10000, "SpellerControllerTaiwan#loadzhuYinString trying to convert read content to String in UTF-8 encoding: %1", (Throwable)unsupportedEncodingException);
        }
        return object;
    }

    public static String convertToUnicode(String string) {
        String string2 = "";
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (i2 > 0) {
                string2 = new StringBuffer().append(string2).append(",").toString();
            }
            string2 = new StringBuffer().append(string2).append(Integer.toHexString(string.charAt(i2))).toString();
        }
        return string2;
    }

    public List getPossibleConversions(String string, int n) {
        ArrayList arrayList = new ArrayList();
        if (!StringUtilities.isNullOrEmpty(string)) {
            arrayList.add(string);
            char[] cArray = ZhuYinFreeTextConverter.getPossibleKanjis(string, n);
            for (int i2 = 0; i2 < n && cArray[i2] != '\u0000'; ++i2) {
                arrayList.add(String.valueOf(cArray[i2]));
            }
        }
        return arrayList;
    }

    public int getNumberOfConversions() {
        return ZhuYinFreeTextConverter.getNumberOfKanjs();
    }

    public String getValidCharacters(String string) {
        return ZhuYinFreeTextConverter.getValidZhuYinChars(string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

