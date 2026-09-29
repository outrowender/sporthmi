/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod$2;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod$3;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ICharacterConversionPolicy;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverterFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;

public final class AsianInputMethod {
    private static final String NUMBERS_AND_SYMBOLS;
    public static final int TEXT_CONST_EVO_SPELLER_INPUT_METHOD_NULL;
    private static final ICharacterConversionPolicy CONVERSION_POLICY_NULL;
    private static final ICharacterConversionPolicy CONVERSION_POLICY_CONVERT;
    private static final ICharacterConversionPolicy CONVERSION_POLICY_DELETE;
    public static final AsianInputMethod NO_CONVERSION;
    public static final AsianInputMethod PINYIN;
    public static final AsianInputMethod STROKE;
    public static final AsianInputMethod ZHUYIN;
    public static final AsianInputMethod HIRAGANA;
    public static final AsianInputMethod JAMO;
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
            if ("0123456789,.\u3002?!\u3001\"\u2018\u2019:;()+-*/=_\u00a5$\u20ac&@#%<>\u300a\u300b[]{}~".indexOf(string.charAt(i2)) == -1) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name;
    }

    static /* synthetic */ boolean access$000(String string) {
        return AsianInputMethod.containsNumberOrSpecialSymbol(string);
    }

    static {
        CONVERSION_POLICY_NULL = new AsianInputMethod$1();
        CONVERSION_POLICY_CONVERT = new AsianInputMethod$2();
        CONVERSION_POLICY_DELETE = new AsianInputMethod$3();
        NO_CONVERSION = new AsianInputMethod("NoConversion", CONVERSION_POLICY_NULL, -1);
        PINYIN = new AsianInputMethod("Pinyin", CONVERSION_POLICY_CONVERT, 2900);
        STROKE = new AsianInputMethod("Stroke", CONVERSION_POLICY_DELETE, 2901);
        ZHUYIN = new AsianInputMethod("Zhuyin", CONVERSION_POLICY_CONVERT, 2902);
        HIRAGANA = new AsianInputMethod("Hiragana", CONVERSION_POLICY_CONVERT, 2903);
        JAMO = new AsianInputMethod("Jamo", CONVERSION_POLICY_CONVERT, 3252);
    }
}

