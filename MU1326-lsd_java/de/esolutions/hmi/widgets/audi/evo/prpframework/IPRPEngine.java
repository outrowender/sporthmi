/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import java.util.List;

public interface IPRPEngine {
    public static final int MIN_CHAR_SIZE_RULE;
    public static final int I_L_BOOSTING_RULE;
    public static final int SPACE_DASH_BOOSTING_RULE;
    public static final int LETTER_OVER_SPECIALCHAR_BOOSTING_RULE;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE;
    public static final int FIRST_CHAR_NUMBER_LETTER_BOOSTING_RULE;
    public static final int SMART_DELETE_RULE;
    public static final int MIN_CONFIDENCE_RULE;
    public static final int SPEECH_FILTER;
    public static final int CONTEXT_FILTER_RULE;
    public static final int START_OF_TEXT_FILTER;
    public static final int START_OF_WORD_FILTER;
    public static final int CASE_BALANCING_RULE;
    public static final int CHARSET_BOOSTING;
    public static final int TO_UPPERCASE_FOR_CASE_AMBIGUOUS_SYMBOLS_RULE;
    public static final int HWR_ENGINE_PATCHES;
    public static final int PHONE_FIRST_SYMBOL_RULE;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE_INTELLICALL;
    public static final int DASH_UNDERLINE_BOOSTING;
    public static final int DIACRITIC_BOOSTING;
    public static final int MIN_STROKE_LENGTH_NOTREACH;
    public static final int ARABIA_BACKSPACE_RULE;
    public static final int BACKSPACE_TOP_CANDIDATE_RULE;
    public static final int CONTEXT_FILTER_RULE_PHONENUMBER;
    public static final int FIRST_CHAR_NUMBER_LETTER_BOOSTING_RULE_MULTILINE;
    public static final int NUMBER_LETTER_ALTERNATION_BOOSTING_RULE_MULTILINE;
    public static final int PUNCTUATION_MARK_ENFORCEMENT_RULE;
    public static final int LOWER_UPPER_CASE_ENFORCEMENT_RULE;
    public static final int PLUS_T_RULE;
    public static final int O_O_ZERO_RULE;
    public static final int MIN_CHARSIZE_RULE;
    public static final int SPACE_DASH_CNBIGONE_BOOSTING_RULE;
    public static final int CASE_BALANCING_CNTW_RULE;
    public static final int WEIRD_RADICAL_RULE;
    public static final int SINGLE_CHAR_FILTER_RULE_BACKSPACE;
    public static final int SINGLE_CHAR_FILTER_RULE_SPACE;
    public static final int UPPER_LOWER_CASE_HANDLING_RULE;
    public static final int SIMPLIFIED_TRADITIONAL_MAPPING;
    public static final int MATCHSPELLER_CASEINSENSITIVE_CHAR_RULE;
    public static final int MATCHSPELLER_AMBIGUOUS_BOOSTTING;
    public static final int MODE_ONLY_USE_CONTEXT_FILTER_RULE;

    default public void process(String string, int[] nArray, boolean bl) {
    }

    default public void process(String string, int[] nArray, String string2, boolean bl) {
    }

    default public String getResult() {
    }

    default public String dumpResult() {
    }

    default public void characterEntered(char c2) {
    }

    default public String getSpeechTopMatch() {
    }

    default public List getExecutedRuleset() {
    }
}

