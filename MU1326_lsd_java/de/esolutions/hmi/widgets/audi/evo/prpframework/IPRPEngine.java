/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import java.util.List;

public interface IPRPEngine {
    public static final int MIN_CHAR_SIZE_RULE = 1;
    public static final int I_L_BOOSTING_RULE = 2;
    public static final int SPACE_DASH_BOOSTING_RULE = 3;
    public static final int LETTER_OVER_SPECIALCHAR_BOOSTING_RULE = 4;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE = 5;
    public static final int FIRST_CHAR_NUMBER_LETTER_BOOSTING_RULE = 6;
    public static final int SMART_DELETE_RULE = 7;
    public static final int MIN_CONFIDENCE_RULE = 8;
    public static final int SPEECH_FILTER = 9;
    public static final int CONTEXT_FILTER_RULE = 10;
    public static final int START_OF_TEXT_FILTER = 11;
    public static final int START_OF_WORD_FILTER = 12;
    public static final int CASE_BALANCING_RULE = 13;
    public static final int CHARSET_BOOSTING = 14;
    public static final int TO_UPPERCASE_FOR_CASE_AMBIGUOUS_SYMBOLS_RULE = 15;
    public static final int HWR_ENGINE_PATCHES = 16;
    public static final int PHONE_FIRST_SYMBOL_RULE = 17;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE_INTELLICALL = 18;
    public static final int DASH_UNDERLINE_BOOSTING = 19;
    public static final int DIACRITIC_BOOSTING = 31;
    public static final int MIN_STROKE_LENGTH_NOTREACH = 32;
    public static final int ARABIA_BACKSPACE_RULE = 33;
    public static final int BACKSPACE_TOP_CANDIDATE_RULE = 34;
    public static final int CONTEXT_FILTER_RULE_PHONENUMBER = 35;
    public static final int FIRST_CHAR_NUMBER_LETTER_BOOSTING_RULE_MULTILINE = 100;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE_MULTILINE = 101;
    public static final int PUNCTUATION_MARK_ENFORCEMENT_RULE = 102;
    public static final int LOWER_UPPER_CASE_ENFORCEMENT_RULE = 103;
    public static final int PLUS_T_RULE = 104;
    public static final int O_O_ZERO_RULE = 105;
    public static final int MIN_CHARSIZE_RULE = 20;
    public static final int SPACE_DASH_CNBIGONE_BOOSTING_RULE = 21;
    public static final int CASE_BALANCING_CNTW_RULE = 24;
    public static final int WEIRD_RADICAL_RULE = 26;
    public static final int SINGLE_CHAR_FILTER_RULE_BACKSPACE = 27;
    public static final int SINGLE_CHAR_FILTER_RULE_SPACE = 28;
    public static final int UPPER_LOWER_CASE_HANDLING_RULE = 29;
    public static final int SIMPLIFIED_TRADITIONAL_MAPPING = 30;
    public static final int MATCHSPELLER_CASEINSENSITIVE_CHAR_RULE = 98;
    public static final int MATCHSPELLER_AMBIGUOUS_BOOSTTING = 99;
    public static final int MODE_ONLY_USE_CONTEXT_FILTER_RULE = 18193;

    public void process(String var1, int[] var2, boolean var3);

    public void process(String var1, int[] var2, String var3, boolean var4);

    public String getResult();

    public String dumpResult();

    public void characterEntered(char var1);

    public String getSpeechTopMatch();

    public List getExecutedRuleset();
}

