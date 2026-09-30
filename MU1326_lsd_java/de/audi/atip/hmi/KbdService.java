/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

public interface KbdService {
    public static final int RECOGNIZERMODE_OFF = 0;
    public static final int RECOGNIZERMODE_MIB2_VIRTUAL_KEYS = 24;
    public static final int RECOGNIZERMODE_MIB2_GESTURES = 25;
    public static final int RECOGNIZERMODE_MIB2_CHAR_RECOGNITION = 26;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST = 19;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_TEL = 20;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_ZIP = 21;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_HOUSE_NUM = 22;
    public static final int RECOGNIZERMODE_VW_LETTER_FIRST = 23;
    public static final int RECOGNIZERMODE_VW_FREETEXT = 12;
    public static final int RECOGNIZER_LANGCODE_UNKNOWN = 0;
    public static final int RECOGNIZER_LANGCODE_LATIN_COMMON = 1;
    public static final int RECOGNIZER_LANGCODE_LATIN_EXTENDED = 2;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC = 3;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC_LATIN_COMMON = 4;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC_LATIN_EXTENDED = 5;
    public static final int RECOGNIZER_LANGCODE_ARABIC = 6;
    public static final int RECOGNIZER_LANGCODE_ARABIC_LATIN_COMMON = 7;
    public static final int RECOGNIZER_LANGCODE_ARABIC_LATIN_EXTENDED = 8;
    public static final int RECOGNIZER_LANGCODE_CHINESE = 9;
    public static final int RECOGNIZER_LANGCODE_CHINESE_LATIN_COMMON = 10;
    public static final int RECOGNIZER_LANGCODE_CHINESE_LATIN_EXTENDED = 11;
    public static final int RECOGNIZER_LANGCODE_JAPANESE = 12;
    public static final int RECOGNIZER_LANGCODE_JAPANESE_LATIN_COMMON = 13;
    public static final int RECOGNIZER_LANGCODE_JAPANESE_LATIN_EXTENDED = 14;
    public static final int RECOGNIZER_LANGCODE_KOREAN = 15;
    public static final int RECOGNIZER_LANGCODE_KOREAN_LATIN_COMMON = 16;
    public static final int RECOGNIZER_LANGCODE_KOREAN_LATIN_EXTENDED = 17;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE = 18;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE_LATIN_COMMON = 19;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE_LATIN_EXTENDED = 20;
    public static final int RECOGNIZER_LANGCODE_HONGKONG = 21;
    public static final int RECOGNIZER_LANGCODE_HONGKONG_LATIN_COMMON = 22;
    public static final int RECOGNIZER_LANGCODE_HONGKONG_LATIN_EXTENDED = 23;
    public static final int KBDTYPE_UNKONWN = 0;
    public static final int KBDTYPE_AU_LOW_TONE_CAR = 1;
    public static final int KBDTYPE_AU_LOW_NAV_TEL = 2;
    public static final int KBDTYPE_AU_LOW_PLUS_TONE_CAR = 3;
    public static final int KBDTYPE_AU_LOW_PLUS_NAV_TEL = 4;
    public static final int KBDTYPE_AU_TOUCHWHEEL = 5;
    public static final int KBDTYPE_AU_ALLINTOUCH = 6;
    public static final int KBDTYPE_AU_RS232 = 14;
    public static final int KBDTYPE_AU_AB3 = 15;
    public static final int KBDTYPE_VW_ABT_LOW = 16;
    public static final int KBDTYPE_VW_ABT_HIGH = 17;
    public static final int RECOGNIZER_TIMEOUT_ASIA_SHORT = 500;
    public static final int RECOGNIZER_TIMEOUT_ASIA_MEDIUM = 750;
    public static final int RECOGNIZER_TIMEOUT_ASIA_LONG = 1000;
    public static final int GENERICSETTING_HOR_ACTIVE = 192;
    public static final int GENERICSETTING_TP_DRIVE_MODE = 249;

    public KbdService getKbdService();

    public int getCurrentKeyboardType();

    public boolean isTouchKeypanel();

    public boolean isPanelWithJoystick();

    public void synchronizeSettings(KbdService var1);

    public void setHKIlluminationExclusive(int var1);

    public void setHKIlluminationOff();

    public void setAdditionHKIllumination(int var1, boolean var2);

    public void setSKIlluminationExclusive(int var1);

    public void setSKIlluminationOff();

    public boolean setRecognizerMode(int var1);

    public int getRecognizerMode();

    public void setRecognizerLanguage(String var1, int var2);

    public void setTouchSensitiveArea(int var1, int var2, int var3, int var4);

    public void setIgnoreNextMutePressButtonFlag();

    public void setRecognitionTimeoutAsia(int var1);

    public void setGenericSetting(int var1, int var2);

    public int getGenericSettingPresetLayout();

    public void clearRecognizer();
}

