/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

public interface KbdService {
    public static final int RECOGNIZERMODE_OFF;
    public static final int RECOGNIZERMODE_MIB2_VIRTUAL_KEYS;
    public static final int RECOGNIZERMODE_MIB2_GESTURES;
    public static final int RECOGNIZERMODE_MIB2_CHAR_RECOGNITION;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_TEL;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_ZIP;
    public static final int RECOGNIZERMODE_VW_NUMBER_FIRST_HOUSE_NUM;
    public static final int RECOGNIZERMODE_VW_LETTER_FIRST;
    public static final int RECOGNIZERMODE_VW_FREETEXT;
    public static final int RECOGNIZER_LANGCODE_UNKNOWN;
    public static final int RECOGNIZER_LANGCODE_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_CYRILLIC_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_ARABIC;
    public static final int RECOGNIZER_LANGCODE_ARABIC_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_ARABIC_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_CHINESE;
    public static final int RECOGNIZER_LANGCODE_CHINESE_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_CHINESE_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_JAPANESE;
    public static final int RECOGNIZER_LANGCODE_JAPANESE_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_JAPANESE_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_KOREAN;
    public static final int RECOGNIZER_LANGCODE_KOREAN_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_KOREAN_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_TAIWANESE_LATIN_EXTENDED;
    public static final int RECOGNIZER_LANGCODE_HONGKONG;
    public static final int RECOGNIZER_LANGCODE_HONGKONG_LATIN_COMMON;
    public static final int RECOGNIZER_LANGCODE_HONGKONG_LATIN_EXTENDED;
    public static final int KBDTYPE_UNKONWN;
    public static final int KBDTYPE_AU_LOW_TONE_CAR;
    public static final int KBDTYPE_AU_LOW_NAV_TEL;
    public static final int KBDTYPE_AU_LOW_PLUS_TONE_CAR;
    public static final int KBDTYPE_AU_LOW_PLUS_NAV_TEL;
    public static final int KBDTYPE_AU_TOUCHWHEEL;
    public static final int KBDTYPE_AU_ALLINTOUCH;
    public static final int KBDTYPE_AU_RS232;
    public static final int KBDTYPE_AU_AB3;
    public static final int KBDTYPE_VW_ABT_LOW;
    public static final int KBDTYPE_VW_ABT_HIGH;
    public static final int RECOGNIZER_TIMEOUT_ASIA_SHORT;
    public static final int RECOGNIZER_TIMEOUT_ASIA_MEDIUM;
    public static final int RECOGNIZER_TIMEOUT_ASIA_LONG;
    public static final int GENERICSETTING_HOR_ACTIVE;
    public static final int GENERICSETTING_TP_DRIVE_MODE;

    default public KbdService getKbdService() {
    }

    default public int getCurrentKeyboardType() {
    }

    default public boolean isTouchKeypanel() {
    }

    default public boolean isPanelWithJoystick() {
    }

    default public void synchronizeSettings(KbdService kbdService) {
    }

    default public void setHKIlluminationExclusive(int n) {
    }

    default public void setHKIlluminationOff() {
    }

    default public void setAdditionHKIllumination(int n, boolean bl) {
    }

    default public void setSKIlluminationExclusive(int n) {
    }

    default public void setSKIlluminationOff() {
    }

    default public boolean setRecognizerMode(int n) {
    }

    default public int getRecognizerMode() {
    }

    default public void setRecognizerLanguage(String string, int n) {
    }

    default public void setTouchSensitiveArea(int n, int n2, int n3, int n4) {
    }

    default public void setIgnoreNextMutePressButtonFlag() {
    }

    default public void setRecognitionTimeoutAsia(int n) {
    }

    default public void setGenericSetting(int n, int n2) {
    }

    default public int getGenericSettingPresetLayout() {
    }

    default public void clearRecognizer() {
    }
}

