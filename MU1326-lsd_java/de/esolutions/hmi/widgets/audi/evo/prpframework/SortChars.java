/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import java.lang.reflect.Field;
import java.util.Arrays;

public class SortChars {
    private static final String SPACE;
    private static final String CARRIAGE_RETURN;
    private static final String LATIN_ORI;
    private static final String LATIN;
    private static final String LATIN_EXTENDED;
    private static final String CONTROL;
    private static final String CYRILLIC;
    private static final String ARABIC_ORI;
    private static final String ARABIC;
    public static final String NUMBERS;
    private static final String NUMBERS_AND_TOUCH_SYMBOLS;
    private static final String NUMBERS_AND_TOUCH_SYMBOLS_PASSWORD;
    private static final String DIACRITC_CZ;
    private static final String DIACRITC_FR;
    private static final String DIACRITC_DE;
    private static final String DIACRITC_IT;
    private static final String DIACRITC_NL;
    private static final String DIACRITC_NO;
    private static final String DIACRITC_PL;
    private static final String DIACRITC_PO;
    private static final String DIACRITC_ES;
    private static final String DIACRITC_RU;
    private static final String DIACRITC_SE;
    private static final String DIACRITC_TR;
    private static final String DIACRITC_HU;
    private static final String DIACRITC_AR_ORI;
    private static final String DIACRITC_AR;
    private static final String LATIN_COMPLETE_ORI;
    private static final String LATIN_COMPLETE;
    private static final String CYRILLIC_COMPLETE_ORI;
    private static final String CYRILLIC_COMPLETE;
    private static final String ARABIC_COMPLETE_ORI;
    private static final String ARABIC_COMPLETE;
    private static final String PIN;
    private static final String SPECIAL_CHARS_FREETEXT_GENERAL;
    private static final String SPECIAL_CHARS_FREETEXT_WLAN;
    private static final String SPECIAL_CHARS_SEARCHTEXT_GENERAL_ORI;
    private static final String SPECIAL_CHARS_SEARCHTEXT_GENERAL;
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI_ORI;
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI;
    private static final String SPECIAL_CHARS_SEARCHTEXT_SMS_EMAIL;
    private static final String SPECIAL_CHARS_SEARCHTEXT_FAVORITES_AND_ADB;
    private static final String SPECIAL_CHARS_SEARCHTEXT_PHONE_ORI;
    private static final String SPECIAL_CHARS_SEARCHTEXT_PHONE;
    private static final String SPECIAL_CHARS_PHONE_NUMBER_INPUT_ORI;
    private static final String SPECIAL_CHARS_PHONE_NUMBER_INPUT;
    private static final String SPECIAL_CHARS_MESSAGING_MULTILINE_ORI;
    private static final String SPECIAL_CHARS_MESSAGING_MULTILINE;
    private static final String SPECIAL_CHARS_MESSAGING_EMAIL_RECIPIENT;
    private static final String SPECIAL_CHARS_MESSAGING_SMS_RECIPIENT_ORI;
    private static final String SPECIAL_CHARS_MESSAGING_SMS_RECIPIENT;
    private static final String BLACKLIST_SEARCHINPUT_START_OF_WORD_ORI;
    private static final String BLACKLIST_SEARCHINPUT_START_OF_WORD;
    private static final String BLACKLIST_SEARCHINPUT_START_OF_TEXT_ORI;
    private static final String BLACKLIST_SEARCHINPUT_START_OF_TEXT;
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_WORD_ORI;
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_WORD;
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT_ORI;
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT;
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD;
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT_ORI;
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT;
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD_ORI;
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD;
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT_ORI;
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT;
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_WORD;
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT_ORI;
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT;
    private static final String BLACKLIST_PASSWORD_START_OF_WORD;
    private static final String BLACKLIST_PASSWORD_START_OF_TEXT;
    private static final String BLACKLIST_FREETEXT_START_OF_WORD_ORI;
    private static final String BLACKLIST_FREETEXT_START_OF_WORD;
    private static final String BLACKLIST_FREETEXT_START_OF_TEXT_ORI;
    private static final String BLACKLIST_FREETEXT_START_OF_TEXT;
    private static final String BLACKLIST_MESSAGING_START_OF_WORD_ORI;
    private static final String BLACKLIST_MESSAGING_START_OF_WORD;
    private static final String BLACKLIST_MESSAGING_START_OF_TEXT_ORI;
    private static final String BLACKLIST_MESSAGING_START_OF_TEXT;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD_ORI;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT_ORI;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD_ORI;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT_ORI;
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT;
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars;
    static /* synthetic */ Class class$java$lang$String;

    public static void main(String[] stringArray) {
        Class clazz = class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars == null ? (class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars = SortChars.class$("de.esolutions.hmi.widgets.audi.evo.prpframework.SortChars")) : class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars;
        Field[] fieldArray = clazz.getDeclaredFields();
        int n = 0;
        if (null != fieldArray && fieldArray.length > 0) {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                Field field = fieldArray[i2];
                field.setAccessible(true);
                if (field.getType() != (class$java$lang$String == null ? SortChars.class$("java.lang.String") : class$java$lang$String)) continue;
                try {
                    String string = (String)field.get(clazz);
                    char[] cArray = string.toCharArray();
                    Arrays.sort(cArray);
                    String string2 = new String(cArray);
                    if (string.equals(string2)) continue;
                    ++n;
                    char[] cArray2 = string2.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i3 = 0; i3 < cArray2.length; ++i3) {
                        char c2 = cArray2[i3];
                        if (c2 < '\u007f' && !Character.isSpaceChar(c2) && c2 != '\b' && c2 != '\r' && c2 != '@') {
                            stringBuffer.append(c2);
                            stringBuffer2.append(c2);
                            continue;
                        }
                        String string3 = String.valueOf(c2);
                        stringBuffer.append(SortChars.bytesToHexString(string3.getBytes()));
                    }
                    String string4 = stringBuffer.toString();
                    System.out.println(new StringBuffer().append(field.getName()).append("->").append(string4).toString());
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
        System.out.println(new StringBuffer().append("total different list: ").append(n).toString());
    }

    public static final String bytesToHexString(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer(byArray.length);
        stringBuffer.insert(0, '0');
        stringBuffer.insert(0, '0');
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            String string = Integer.toHexString(0xFF & byArray[i2]);
            if (string.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(string.toUpperCase());
        }
        return new StringBuffer().append("\\u").append(stringBuffer.toString().subSequence(stringBuffer.length() - 4, stringBuffer.length())).toString();
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

