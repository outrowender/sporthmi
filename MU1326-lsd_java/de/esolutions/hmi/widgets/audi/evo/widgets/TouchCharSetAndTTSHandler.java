/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMITerminal;
import de.audi.atip.hmi.ITTSHandler;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.i18n.Language;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$CharsetListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$StaticUserCharsetMode;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$UserCharsetMode;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;

public class TouchCharSetAndTTSHandler {
    protected static final String TTS_TONE_NEGATIVE;
    public static final int CS_LATIN;
    public static final int CS_CYRILLIC;
    public static final int CS_ARABIC;
    public static final int CS_PINYIN;
    public static final int CS_STROKE;
    public static final int CS_ZHUYIN;
    public static final int CS_HIRAGANA;
    public static final int CS_JAMO;
    public static final int LANGUAGE_INDICATOR_NO_ICON;
    public static final int LANGUAGE_INDICATOR_LATIN;
    public static final int LANGUAGE_INDICATOR_CYRILIC;
    public static final int LANGUAGE_INDICATOR_ARABIC;
    private String ttsTextDelete = "l\u00f6schen";
    private HMITerminal terminal;
    private final TouchCharSetAndTTSHandler$UserCharsetMode userCharsetMode;
    private final Language currentSystemLanguage;
    private long ttsDeleteTimestamp = -1L;

    public TouchCharSetAndTTSHandler(HMITerminal hMITerminal) {
        this(hMITerminal, false);
    }

    public TouchCharSetAndTTSHandler(HMITerminal hMITerminal, boolean bl) {
        this(hMITerminal, AbstractWidget.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI"), TouchCharSetAndTTSHandler$StaticUserCharsetMode.access$000(), bl);
    }

    protected TouchCharSetAndTTSHandler(HMITerminal hMITerminal, Language language, TouchCharSetAndTTSHandler$UserCharsetMode touchCharSetAndTTSHandler$UserCharsetMode, boolean bl) {
        this.terminal = hMITerminal;
        this.ttsTextDelete = AbstractWidget.hmiService.getText(871);
        this.userCharsetMode = touchCharSetAndTTSHandler$UserCharsetMode;
        this.currentSystemLanguage = language;
        this.setInitialCharset(bl);
    }

    private void setInitialCharset(boolean bl) {
        if (!bl && this.currentSystemLanguage.equals(this.userCharsetMode.getStoredSystemLanguage())) {
            this.setCharSet(this.userCharsetMode.getCharset());
        } else {
            this.setCharSet(TouchCharSetAndTTSHandler.getDefaultCharSetFromLanguage(this.currentSystemLanguage.getLanguageIndex()));
        }
    }

    public void setCharSet(int n) {
        this.userCharsetMode.setStoredSystemLanguage(this.currentSystemLanguage);
        this.userCharsetMode.setCharset(n);
        this.updateRecognizerLanguage();
    }

    public void addCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
        this.userCharsetMode.addCharsetListener(touchCharSetAndTTSHandler$CharsetListener);
    }

    public void removeCharsetListener(TouchCharSetAndTTSHandler$CharsetListener touchCharSetAndTTSHandler$CharsetListener) {
        this.userCharsetMode.removeCharsetListener(touchCharSetAndTTSHandler$CharsetListener);
    }

    private void ttsOutput(String string, String string2, String string3, int n) {
        this.ttsOutput(string, string2, string3, n, false);
    }

    private void ttsOutput(String string, String string2, String string3, int n, boolean bl) {
        ITTSHandler iTTSHandler = this.terminal.getTTSHandler();
        if (iTTSHandler != null && !StringUtilities.isNullOrEmpty(string)) {
            iTTSHandler.speak(0, "", string2, string, string3, bl, n);
        }
    }

    public void speak(String string) {
        if (string.length() == 1) {
            this.speakChar(string);
        } else {
            this.speakString(string);
        }
    }

    public void speakChar(String string) {
        this.ttsOutput(string, null, null, 1);
    }

    private void speakString(String string) {
        this.ttsOutput(string, null, null, 0);
    }

    public void speakCharWithNegativeTone(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            this.ttsNegativeTone();
        } else {
            this.ttsOutput(string, null, "<audio src=\"TouchpadToneNegative.wav\"/>", 1);
        }
    }

    private void ttsNegativeTone() {
        ITTSHandler iTTSHandler = this.terminal.getTTSHandler();
        iTTSHandler.speak(0, "", null, null, "<audio src=\"TouchpadToneNegative.wav\"/>", false, 1);
    }

    public void sayDelete() {
        long l = AbstractWidget.framework.getMonotonicTime();
        if (this.ttsDeleteTimestamp == -1L || l - this.ttsDeleteTimestamp > 0) {
            this.ttsDeleteTimestamp = l;
            this.ttsOutput(this.ttsTextDelete, null, null, 0, false);
        }
    }

    public boolean trySpeakFullMatchWithPhonemes(MatchspellerModelGUI matchspellerModelGUI) {
        boolean bl = matchspellerModelGUI.isFullMatch();
        String string = matchspellerModelGUI.getPhonemeText();
        String string2 = matchspellerModelGUI.getText();
        String string3 = matchspellerModelGUI.getPhonemeAlphabet();
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchCharSetAndTTSHandler#trySpeakFullMatchWithPhonemes fullmatch=%1, phonemeText=%2, enteredCharsString=%3", bl, (Object)string, (Object)string2);
        if (!bl || string == null && string2 == null) {
            return false;
        }
        if (!StringUtilities.isNullOrEmpty(string) && !StringUtilities.isNullOrEmpty(string3)) {
            int n = string.indexOf(95);
            if (n != -1 && n < string.length() && n < 5) {
                Buffer buffer = new Buffer(string);
                buffer.insert(n, '-');
                string = buffer.toString();
            }
        } else {
            if (!StringUtilities.isNullOrEmpty(string2)) {
                this.terminal.getTTSHandler().speak(0, string, string3, string2, null, false, 0);
                return true;
            }
            return false;
        }
        this.terminal.getTTSHandler().speak(0, string, string3, string2, null, false, 2);
        return true;
    }

    private static int getDefaultCharSetFromLanguage(int n) {
        switch (n) {
            case 26: {
                return 2;
            }
            case 7: 
            case 32: {
                return 1;
            }
            case 14: {
                return 3;
            }
            case 23: {
                return 4;
            }
            case 24: {
                return 5;
            }
            case 12: {
                return 6;
            }
            case 16: {
                return 7;
            }
        }
        return 0;
    }

    public int getSystemDefaultLanguage() {
        return TouchCharSetAndTTSHandler.getDefaultCharSetFromLanguage(this.currentSystemLanguage.getLanguageIndex());
    }

    private void updateRecognizerLanguage() {
        String string;
        int n;
        if (AbstractWidget.isAsia()) {
            int n2 = this.currentSystemLanguage.getLanguageIndex();
            switch (n2) {
                case 14: {
                    n = 10;
                    string = "zh_CN";
                    break;
                }
                case 23: {
                    n = 22;
                    string = "zh_HK";
                    break;
                }
                case 15: {
                    n = 10;
                    string = "en_CN";
                    break;
                }
                case 24: {
                    n = 19;
                    string = "zh_TW";
                    break;
                }
                case 25: {
                    n = 19;
                    string = "en_TW";
                    break;
                }
                case 12: {
                    n = 13;
                    string = "ja_JP";
                    break;
                }
                case 13: {
                    n = 13;
                    string = "en_JP";
                    break;
                }
                case 16: {
                    n = 16;
                    string = "ko_KR";
                    break;
                }
                case 17: {
                    n = 16;
                    string = "en_KR";
                    break;
                }
                default: {
                    n = 10;
                    string = "en_GB";
                    break;
                }
            }
        } else {
            switch (this.userCharsetMode.getCharset()) {
                case 1: {
                    n = 4;
                    string = "ru_RU";
                    break;
                }
                case 2: {
                    n = 7;
                    string = "ar_SA";
                    break;
                }
                default: {
                    n = 2;
                    if (TouchCharSetAndTTSHandler.getDefaultCharSetFromLanguage(this.currentSystemLanguage.getLanguageIndex()) == 0) {
                        string = this.currentSystemLanguage.getLanguageCode();
                        break;
                    }
                    string = "en_GB";
                    IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchCharSetAndTTSHandler#setRecognizerLanguage fall back to %1", (Object)string);
                }
            }
        }
        IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchCharSetAndTTSHandler#setRecognizerLanguage new recognizerLanguage: language: %1, langCode: %2", (Object)string, (long)n);
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            this.terminal.getKbdService().setRecognizerLanguage(string, n);
        }
    }

    public final int getCharSet() {
        return this.userCharsetMode.getCharset();
    }

    public int getInternalLanguage() {
        int n = this.userCharsetMode.getCharset();
        int n2 = this.currentSystemLanguage.getLanguageIndex();
        switch (n) {
            case 1: {
                return 7;
            }
            case 2: {
                return 26;
            }
            case 3: {
                return 14;
            }
            case 4: {
                return 23;
            }
            case 5: {
                return 24;
            }
            case 6: {
                return 12;
            }
            case 7: {
                return 16;
            }
            case 0: {
                if (TouchCharSetAndTTSHandler.getDefaultCharSetFromLanguage(n2) == 0) {
                    return n2;
                }
                switch (n2) {
                    case 14: 
                    case 23: {
                        return 15;
                    }
                    case 24: {
                        return 25;
                    }
                    case 12: {
                        return 13;
                    }
                    case 16: {
                        return 17;
                    }
                }
                return 1;
            }
        }
        IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharSetAndTTSHandler#getInternalLanguage: unknown character set %1", (long)n);
        return n2;
    }

    public AsianInputMethod getAsianInputMethodForInternalLanguage() {
        switch (this.userCharsetMode.getCharset()) {
            case 3: {
                return AsianInputMethod.PINYIN;
            }
            case 4: {
                return AsianInputMethod.STROKE;
            }
            case 5: {
                return AsianInputMethod.ZHUYIN;
            }
            case 6: {
                return AsianInputMethod.HIRAGANA;
            }
            case 7: {
                return AsianInputMethod.JAMO;
            }
        }
        return AsianInputMethod.NO_CONVERSION;
    }

    public int getFocusPropertyForCurrentCharset() {
        if (this.userCharsetMode.getCharset() == 0) {
            return 1993280504;
        }
        if (this.userCharsetMode.getCharset() == 1) {
            return 890195297;
        }
        if (this.userCharsetMode.getCharset() == 2) {
            return 411154709;
        }
        return -1;
    }

    public int getLanguageIndicatorIconIndex() {
        int n = 0;
        if (!TouchCharSetAndTTSHandler.isAsianLanguageIndex(this.currentSystemLanguage.getLanguageIndex()) && TouchCharSetAndTTSHandler.getDefaultCharSetFromLanguage(this.currentSystemLanguage.getLanguageIndex()) != this.userCharsetMode.getCharset()) {
            switch (this.userCharsetMode.getCharset()) {
                case 0: {
                    n = 1;
                    break;
                }
                case 1: {
                    n = 2;
                    break;
                }
                case 2: {
                    n = 3;
                    break;
                }
                default: {
                    n = 0;
                }
            }
        }
        return n;
    }

    private static boolean isAsianLanguageIndex(int n) {
        return n == 14 || n == 23 || n == 24 || n == 12 || n == 16 || n == 15 || n == 13 || n == 17 || n == 25;
    }

    public SpellerController$SpellerButtonType getAsianToggleSpellerButtonType() {
        int n = this.currentSystemLanguage.getLanguageIndex();
        int n2 = this.userCharsetMode.getCharset();
        switch (n2) {
            case 3: {
                if (14 != n && 15 != n) break;
                return SpellerController$SpellerButtonType.TOGGLE_PINYIN_TO_LATIN;
            }
            case 4: {
                if (23 != n) break;
                return SpellerController$SpellerButtonType.TOGGLE_STROKE_TO_LATIN;
            }
            case 6: {
                if (12 != n && 13 != n) break;
                return SpellerController$SpellerButtonType.TOGGLE_JAPAN_TO_LATIN;
            }
            case 5: {
                if (24 != n && 25 != n) break;
                return SpellerController$SpellerButtonType.TOGGLE_TAIWAN_TO_LATIN;
            }
            case 7: {
                if (16 != n && 17 != n) break;
                return SpellerController$SpellerButtonType.TOGGLE_KOREA_TO_LATIN;
            }
            case 0: {
                switch (n) {
                    case 14: 
                    case 15: {
                        return SpellerController$SpellerButtonType.TOGGLE_LATIN_TO_PINYIN;
                    }
                    case 23: {
                        return SpellerController$SpellerButtonType.TOGGLE_LATIN_TO_STROKE;
                    }
                    case 12: 
                    case 13: {
                        return SpellerController$SpellerButtonType.TOGGLE_LATIN_TO_JAPAN;
                    }
                    case 24: 
                    case 25: {
                        return SpellerController$SpellerButtonType.TOGGLE_LATIN_TO_TAIWAN;
                    }
                    case 16: 
                    case 17: {
                        return SpellerController$SpellerButtonType.TOGGLE_LATIN_TO_KOREA;
                    }
                }
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharSetAndTTSHandler#getAsianToggleSpellerButtonType: unknown language index %1", (long)n);
                return SpellerController$SpellerButtonType.NULL;
            }
            default: {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharSetAndTTSHandler#getAsianToggleSpellerButtonType: unknown character set %1", (long)n2);
                return SpellerController$SpellerButtonType.NULL;
            }
        }
        return SpellerController$SpellerButtonType.NULL;
    }

    public SpellerController$SpellerButtonType getAsianToggleToSpellerButtonType() {
        int n = this.currentSystemLanguage.getLanguageIndex();
        int n2 = this.userCharsetMode.getCharset();
        switch (n2) {
            case 3: {
                return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_PINYIN_PINYIN;
            }
            case 4: {
                return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_STROKE_STROKE;
            }
            case 6: {
                return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_KANJI_JAPAN;
            }
            case 5: {
                return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_ZHUYIN_ZHUYIN;
            }
            case 7: {
                return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_JAMO_KOREA;
            }
            case 0: {
                switch (n) {
                    case 14: 
                    case 15: {
                        return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_PINYIN_LATIN;
                    }
                    case 23: {
                        return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_STROKE_LATIN;
                    }
                    case 12: 
                    case 13: {
                        return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_KANJI_LATIN;
                    }
                    case 24: 
                    case 25: {
                        return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_ZHUYIN_LATIN;
                    }
                    case 16: 
                    case 17: {
                        return SpellerController$SpellerButtonType.TOGGLE_TO_SPELLER_JAMO_LATIN;
                    }
                }
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharSetAndTTSHandler#getAsianToggleSpellerButtonType: unknown language index %1", (long)n);
                return SpellerController$SpellerButtonType.NULL;
            }
        }
        IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharSetAndTTSHandler#getAsianToggleToSpellerButtonType: unknown character set %1", (long)n2);
        return SpellerController$SpellerButtonType.NULL;
    }

    public boolean isTraditionalChineseSystemLanguage() {
        return this.isSystemLanguageChineseHongkong() || this.isSystemLanguageChineseTaiwan();
    }

    public boolean isEnglishSystemLanguage() {
        int n = this.currentSystemLanguage.getLanguageIndex();
        return n == 15 || n == 1 || n == 13 || n == 17 || n == 8 || n == 25 || n == 9;
    }

    public boolean isSystemLanguageChineseSimplified() {
        return this.currentSystemLanguage.getLanguageIndex() == 14;
    }

    public boolean isSystemLanguageChineseHongkong() {
        return this.currentSystemLanguage.getLanguageIndex() == 23;
    }

    public boolean isSystemLanguageChineseTaiwan() {
        return this.currentSystemLanguage.getLanguageIndex() == 24;
    }

    public boolean isSystemLanguageJapanese() {
        return this.currentSystemLanguage.getLanguageIndex() == 12;
    }

    public boolean isSystemLanguageKorean() {
        return this.currentSystemLanguage.getLanguageIndex() == 16;
    }

    public int getSystemLanguage() {
        return this.currentSystemLanguage.getLanguageIndex();
    }

    public int convertMatchspellerInputMode(int n) {
        int n2 = this.currentSystemLanguage.getLanguageIndex();
        if (this.isEnglishSystemLanguage() || n2 == 12) {
            return 0;
        }
        return n;
    }

    public boolean isAsiaLocalInput() {
        AsianInputMethod asianInputMethod = this.getAsianInputMethodForInternalLanguage();
        return asianInputMethod == AsianInputMethod.PINYIN || asianInputMethod == AsianInputMethod.HIRAGANA || asianInputMethod == AsianInputMethod.JAMO || asianInputMethod == AsianInputMethod.STROKE || asianInputMethod == AsianInputMethod.ZHUYIN;
    }
}

