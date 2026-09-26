/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.CharacterConverterFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.HiraganaConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ICharacterConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.PinYinFreeTextConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.StrokeFreeTextConverter;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.converter.ZhuYinFreeTextConverter;

public final class CharacterConverterFactory {
    public static final ICharacterConverter NULL_CHARACTER_CONVERTER = CharacterConverterFactory.createNullCharacterConverter();
    private static ICharacterConverter pinyinConverter = null;
    private static ICharacterConverter strokeConverter = null;
    private static ICharacterConverter zhuyinConverter = null;
    private static ICharacterConverter hiraganaConverter = null;

    private static synchronized ICharacterConverter getPinyinConverter() {
        if (pinyinConverter == null) {
            pinyinConverter = new CharacterConverter(new PinYinFreeTextConverter());
        }
        return pinyinConverter;
    }

    private static synchronized ICharacterConverter getStrokeConverter() {
        if (strokeConverter == null) {
            strokeConverter = new CharacterConverter(new StrokeFreeTextConverter());
        }
        return strokeConverter;
    }

    private static synchronized ICharacterConverter getZhuyinConverter() {
        if (zhuyinConverter == null) {
            zhuyinConverter = new CharacterConverter(new ZhuYinFreeTextConverter());
        }
        return zhuyinConverter;
    }

    private static synchronized ICharacterConverter getHiraganaConverter() {
        if (hiraganaConverter == null) {
            boolean bl = AbstractWidget.getRegionCode() == 3;
            boolean bl2 = AbstractWidget.isVariantStd();
            hiraganaConverter = bl && !bl2 ? new HiraganaConverter() : NULL_CHARACTER_CONVERTER;
        }
        return hiraganaConverter;
    }

    public static ICharacterConverter createConverter(AsianInputMethod asianInputMethod) {
        if (asianInputMethod == AsianInputMethod.HIRAGANA) {
            return CharacterConverterFactory.getHiraganaConverter();
        }
        if (asianInputMethod == AsianInputMethod.PINYIN) {
            return CharacterConverterFactory.getPinyinConverter();
        }
        if (asianInputMethod == AsianInputMethod.STROKE) {
            return CharacterConverterFactory.getStrokeConverter();
        }
        if (asianInputMethod == AsianInputMethod.ZHUYIN) {
            return CharacterConverterFactory.getZhuyinConverter();
        }
        return NULL_CHARACTER_CONVERTER;
    }

    private static ICharacterConverter createNullCharacterConverter() {
        return new CharacterConverterFactory$1();
    }
}

