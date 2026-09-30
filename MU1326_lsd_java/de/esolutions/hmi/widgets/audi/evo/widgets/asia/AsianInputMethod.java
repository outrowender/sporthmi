/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverterFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;

public final class AsianInputMethod {
    private static final String NUMBERS_AND_SYMBOLS = "0123456789,.\u3002?!\u3001\"\u2018\u2019:;()+-*/=_\u00a5$\u20ac&@#%<>\u300a\u300b[]{}~";
    public static final int TEXT_CONST_EVO_SPELLER_INPUT_METHOD_NULL = -1;
    private static final ICharacterConversionPolicy CONVERSION_POLICY_NULL = new ICharacterConversionPolicy(){

        public boolean doesLongPressTriggerConversion() {
            return false;
        }

        public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
        }

        public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
        }

        public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
        }

        public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
        }

        public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
            return false;
        }

        public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
        }
    };
    private static final ICharacterConversionPolicy CONVERSION_POLICY_CONVERT = new ICharacterConversionPolicy(){

        public boolean doesLongPressTriggerConversion() {
            return true;
        }

        public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
            String string = iTouchInputDataAsia.getPredictionContextWithLastInputWord("", false);
            iTouchInputDataAsia.getWordPredictionAccess().startContextBasedPrediction(string, "", 20);
        }

        public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
            if (AsianInputMethod.containsNumberOrSpecialSymbol(string)) {
                iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
                iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
                return false;
            }
            return true;
        }

        public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.convertUnconvertedCharactersToRegularCharacters();
        }
    };
    private static final ICharacterConversionPolicy CONVERSION_POLICY_DELETE = new ICharacterConversionPolicy(){

        public boolean doesLongPressTriggerConversion() {
            return false;
        }

        public void willChangeInputMethod(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.clearUnconvertedCharacters(true);
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public void spellerClosed(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.clearUnconvertedCharacters(true);
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public void longPressOnCharacterOccured(ITouchInputDataAsia iTouchInputDataAsia) {
        }

        public void enteredHandWrittenMode(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.clearUnconvertedCharacters(true);
            iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
        }

        public boolean characterToBeInserted(ITouchInputDataAsia iTouchInputDataAsia, String string) {
            if ("*(-[[|]]Joker*:)".equals(string)) {
                return true;
            }
            if (AsianInputMethod.containsNumberOrSpecialSymbol(string)) {
                iTouchInputDataAsia.clearUnconvertedCharacters(false);
                iTouchInputDataAsia.getWordPredictionAccess().convertedAllCharactersInternally();
                return false;
            }
            return true;
        }

        public void onWordPredictionServiceRemoved(ITouchInputDataAsia iTouchInputDataAsia) {
            iTouchInputDataAsia.clearUnconvertedCharacters(true);
        }
    };
    public static final AsianInputMethod NO_CONVERSION = new AsianInputMethod("NoConversion", CONVERSION_POLICY_NULL, -1);
    public static final AsianInputMethod PINYIN = new AsianInputMethod("Pinyin", CONVERSION_POLICY_CONVERT, 2900);
    public static final AsianInputMethod STROKE = new AsianInputMethod("Stroke", CONVERSION_POLICY_DELETE, 2901);
    public static final AsianInputMethod ZHUYIN = new AsianInputMethod("Zhuyin", CONVERSION_POLICY_CONVERT, 2902);
    public static final AsianInputMethod HIRAGANA = new AsianInputMethod("Hiragana", CONVERSION_POLICY_CONVERT, 2903);
    public static final AsianInputMethod JAMO = new AsianInputMethod("Jamo", CONVERSION_POLICY_CONVERT, 3252);
    private final ICharacterConversionPolicy characterConversionPolicy;
    private ICharacterConverter converter;
    private final String name;
    private int description = 0;

    private AsianInputMethod(String string, ICharacterConversionPolicy iCharacterConversionPolicy, int n) {
        this.name = string;
        this.characterConversionPolicy = iCharacterConversionPolicy;
        this.description = n;
    }

    public static AsianInputMethod getDefaultInputMethod(int n) {
        switch (n) {
            case 14: {
                return PINYIN;
            }
            case 23: {
                return STROKE;
            }
            case 24: {
                return ZHUYIN;
            }
            case 12: {
                return HIRAGANA;
            }
            case 16: {
                return JAMO;
            }
        }
        return NO_CONVERSION;
    }

    ICharacterConversionPolicy getCharacterConversionPolicy() {
        return this.characterConversionPolicy;
    }

    ICharacterConverter getCharacterConverter() {
        if (this.converter == null) {
            this.converter = CharacterConverterFactory.createConverter(this);
        }
        return this.converter;
    }

    int getInputDescriptionId() {
        return this.description;
    }

    private static boolean containsNumberOrSpecialSymbol(String string) {
        if (string == null) {
            return false;
        }
        if (string.equals(" ")) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (NUMBERS_AND_SYMBOLS.indexOf(string.charAt(i2)) == -1) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name;
    }
}

