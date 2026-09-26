/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import java.util.Arrays;
import java.util.List;

public final class SpellerController$SpellerButtonType {
    private static final SpellerController$SpellerButtonType[] SPELLER_BUTTON_TYPES = new SpellerController$SpellerButtonType[]{new SpellerController$SpellerButtonType("SPACE"), new SpellerController$SpellerButtonType("DELETE"), new SpellerController$SpellerButtonType("OK"), new SpellerController$SpellerButtonType("CLOSE"), new SpellerController$SpellerButtonType("SHIFT"), new SpellerController$SpellerButtonType("LEFT"), new SpellerController$SpellerButtonType("RIGHT"), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER", 0, HMIImageConstantsSystem.mib2_speller_dummybutton, HMIImageConstantsSystem.mib2_speller_dummybutton), new SpellerController$SpellerButtonType("TOGGLE_LATIN_TO_PINYIN", 3, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin_big), new SpellerController$SpellerButtonType("TOGGLE_LATIN_TO_STROKE", 4, HMIImageConstantsSystem.mib2_speller_button_latin2stroke, HMIImageConstantsSystem.mib2_speller_button_latin2pinyin_big), new SpellerController$SpellerButtonType("TOGGLE_PINYIN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin_big), new SpellerController$SpellerButtonType("TOGGLE_STROKE_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_stroke2latin, HMIImageConstantsSystem.mib2_speller_button_pinyin2latin_big), new SpellerController$SpellerButtonType("TOGGLE_LATIN_TO_TAIWAN", 5, HMIImageConstantsSystem.mib2_speller_button_latin2tw, HMIImageConstantsSystem.mib2_speller_button_latin2tw_big), new SpellerController$SpellerButtonType("TOGGLE_TAIWAN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_tw2latin, HMIImageConstantsSystem.mib2_speller_button_tw2latin_big), new SpellerController$SpellerButtonType("TOGGLE_LATIN_TO_JAPAN", 6, HMIImageConstantsSystem.mib2_speller_button_latin2jp, HMIImageConstantsSystem.mib2_speller_button_latin2jp_big), new SpellerController$SpellerButtonType("TOGGLE_JAPAN_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_jp2latin, HMIImageConstantsSystem.mib2_speller_button_jp2latin_big), new SpellerController$SpellerButtonType("TOGGLE_LATIN_TO_KOREA", 7, HMIImageConstantsSystem.mib2_speller_button_latin2kr, HMIImageConstantsSystem.mib2_speller_button_latin2kr_big), new SpellerController$SpellerButtonType("TOGGLE_KOREA_TO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_kr2latin, HMIImageConstantsSystem.mib2_speller_button_kr2latin_big), new SpellerController$SpellerButtonType("JP_TONE_LOWER_CASE_TOGGLE", -1, HMIImageConstantsSystem.mib2_speller_button_jp_ToneLowerCase, HMIImageConstantsSystem.mib2_speller_button_jp_ToneLowerCase_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_JAMO_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_en_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_JAMO_KOREA", 7, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_kr, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_jamo_kr_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_KANJI_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_en_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_KANJI_JAPAN", 6, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_jp, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_kanji_jp_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_PINYIN_PINYIN", 3, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_cn, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_cn_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_PINYIN_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_pinyin_en_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_STROKE_STROKE", 4, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_cn, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_cn_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_STROKE_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_stroke_en_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_ZHUYIN_LATIN", 0, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_en, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_en_big), new SpellerController$SpellerButtonType("TOGGLE_TO_SPELLER_ZHUYIN_ZHUYIN", 5, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_tw, HMIImageConstantsSystem.mib2_speller_button_toggle2speller_zhuyin_tw_big), new SpellerController$SpellerButtonType("NEWLINE", -1, HMIImageConstantsSystem.mib2_phone_return_button, HMIImageConstantsSystem.mib2_phone_return_button_magnifier), new SpellerController$SpellerButtonType("SMILEY_SMILING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_smiling, HMIImageConstantsSystem.mib2_speller_button_smiley_smiling_big), new SpellerController$SpellerButtonType("SMILEY_LAUGHING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_laughing, HMIImageConstantsSystem.mib2_speller_button_smiley_laughing_big), new SpellerController$SpellerButtonType("SMILEY_WINKING", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_winking, HMIImageConstantsSystem.mib2_speller_button_smiley_winking_big), new SpellerController$SpellerButtonType("SMILEY_DISAPPOINTED", -1, HMIImageConstantsSystem.mib2_speller_button_smiley_disappointed, HMIImageConstantsSystem.mib2_speller_button_smiley_disappointed_big), new SpellerController$SpellerButtonType("ASIA_ACCEPT_TRUFFLE_SUGGESTION", -1, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled, HMIImageConstantsSystem.mib2_speller_button_truffles_enabled_big)};
    private static final List SPELLER_BUTTON_TYPES_AS_LIST = Arrays.asList(SPELLER_BUTTON_TYPES);
    public static final SpellerController$SpellerButtonType NULL = new SpellerController$SpellerButtonType("NONE");
    public static final SpellerController$SpellerButtonType SPACE = SPELLER_BUTTON_TYPES[0];
    public static final SpellerController$SpellerButtonType DELETE = SPELLER_BUTTON_TYPES[1];
    public static final SpellerController$SpellerButtonType OK = SPELLER_BUTTON_TYPES[2];
    public static final SpellerController$SpellerButtonType CLOSE = SPELLER_BUTTON_TYPES[3];
    public static final SpellerController$SpellerButtonType SHIFT = SPELLER_BUTTON_TYPES[4];
    public static final SpellerController$SpellerButtonType LEFT = SPELLER_BUTTON_TYPES[5];
    public static final SpellerController$SpellerButtonType RIGHT = SPELLER_BUTTON_TYPES[6];
    public static final SpellerController$SpellerButtonType TOGGLE_HWR_TO_SPELLER = SPELLER_BUTTON_TYPES[7];
    public static final SpellerController$SpellerButtonType TOGGLE_LATIN_TO_PINYIN = SPELLER_BUTTON_TYPES[8];
    public static final SpellerController$SpellerButtonType TOGGLE_LATIN_TO_STROKE = SPELLER_BUTTON_TYPES[9];
    public static final SpellerController$SpellerButtonType TOGGLE_PINYIN_TO_LATIN = SPELLER_BUTTON_TYPES[10];
    public static final SpellerController$SpellerButtonType TOGGLE_STROKE_TO_LATIN = SPELLER_BUTTON_TYPES[11];
    public static final SpellerController$SpellerButtonType TOGGLE_LATIN_TO_TAIWAN = SPELLER_BUTTON_TYPES[12];
    public static final SpellerController$SpellerButtonType TOGGLE_TAIWAN_TO_LATIN = SPELLER_BUTTON_TYPES[13];
    public static final SpellerController$SpellerButtonType TOGGLE_LATIN_TO_JAPAN = SPELLER_BUTTON_TYPES[14];
    public static final SpellerController$SpellerButtonType TOGGLE_JAPAN_TO_LATIN = SPELLER_BUTTON_TYPES[15];
    public static final SpellerController$SpellerButtonType TOGGLE_LATIN_TO_KOREA = SPELLER_BUTTON_TYPES[16];
    public static final SpellerController$SpellerButtonType TOGGLE_KOREA_TO_LATIN = SPELLER_BUTTON_TYPES[17];
    public static final SpellerController$SpellerButtonType JP_TONE_LOWER_CASE_TOGGLE = SPELLER_BUTTON_TYPES[18];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_JAMO_LATIN = SPELLER_BUTTON_TYPES[19];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_JAMO_KOREA = SPELLER_BUTTON_TYPES[20];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_KANJI_LATIN = SPELLER_BUTTON_TYPES[21];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_KANJI_JAPAN = SPELLER_BUTTON_TYPES[22];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_PINYIN_PINYIN = SPELLER_BUTTON_TYPES[23];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_PINYIN_LATIN = SPELLER_BUTTON_TYPES[24];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_STROKE_STROKE = SPELLER_BUTTON_TYPES[25];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_STROKE_LATIN = SPELLER_BUTTON_TYPES[26];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_ZHUYIN_LATIN = SPELLER_BUTTON_TYPES[27];
    public static final SpellerController$SpellerButtonType TOGGLE_TO_SPELLER_ZHUYIN_ZHUYIN = SPELLER_BUTTON_TYPES[28];
    public static final SpellerController$SpellerButtonType NEWLINE = SPELLER_BUTTON_TYPES[29];
    public static final SpellerController$SpellerButtonType SMILEY_SMILING = SPELLER_BUTTON_TYPES[30];
    public static final SpellerController$SpellerButtonType SMILEY_LAUGHING = SPELLER_BUTTON_TYPES[31];
    public static final SpellerController$SpellerButtonType SMILEY_WINKING = SPELLER_BUTTON_TYPES[32];
    public static final SpellerController$SpellerButtonType SMILEY_DISAPPOINTED = SPELLER_BUTTON_TYPES[33];
    public static final SpellerController$SpellerButtonType ASIA_ACCEPT_TRUFFLE_SUGGESTION = SPELLER_BUTTON_TYPES[34];
    private final String name;
    private final int toggleCharsetIndex;
    private final int bitmapIndex;
    private final int highlightedBitmapIndex;

    private SpellerController$SpellerButtonType(String string) {
        this(string, -1, -1, -1);
    }

    private SpellerController$SpellerButtonType(String string, int n, int n2, int n3) {
        this.name = string;
        this.toggleCharsetIndex = n;
        this.bitmapIndex = n2;
        this.highlightedBitmapIndex = n3;
    }

    public static SpellerController$SpellerButtonType getSpellerButtonType(int n) {
        if (n >= 0 && n < SPELLER_BUTTON_TYPES.length) {
            return SPELLER_BUTTON_TYPES[n];
        }
        return NULL;
    }

    public boolean isCharsetToggleButton() {
        return this.toggleCharsetIndex != -1;
    }

    public int getTargetToggleCharset() {
        return this.toggleCharsetIndex;
    }

    public int getBitmapIndex() {
        return this.bitmapIndex;
    }

    public int getHighlightedBitmapIndex() {
        return this.highlightedBitmapIndex;
    }

    public String getName() {
        return this.name;
    }

    public int getEnumValue() {
        return SPELLER_BUTTON_TYPES_AS_LIST.indexOf(this);
    }

    public String toString() {
        return this.name;
    }
}

