/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

import de.esolutions.fw.util.commons.Buffer;

public class WordPredictionUseCase {
    public static final WordPredictionUseCase SPELLER_CONNECTED = new WordPredictionUseCase("[SPELLER CONNECTED]", false);
    public static final WordPredictionUseCase SPELLER_DISCONNECTED = new WordPredictionUseCase("[SPELLER DISCONNECTED]", false);
    public static final WordPredictionUseCase CONVERTED_ALL_CHARACTERS_INTERNALLY = new WordPredictionUseCase("[CONVERTED ALL CHARACTERS INTERNALLY]", true);
    public static final WordPredictionUseCase UNCONVERTED_TEXT_CHANGED = new WordPredictionUseCase("[UNCONVERTED TEXT CHANGED]", true);
    public static final WordPredictionUseCase START_CONTEXT_BASED_PREDICTION = new WordPredictionUseCase("[START CONTEXT BASED PREDICTION]", true);
    public static final WordPredictionUseCase SELECTED_CANDIDATE = new WordPredictionUseCase("[SELECTED CANDIDATE]", true);
    public static final WordPredictionUseCase GET_CANDIDATES = new WordPredictionUseCase("[GET CANDIDATES]", true);
    public static final WordPredictionUseCase ADD_TO_USER_PREFERENCE = new WordPredictionUseCase("[ADD TO USER PREFERENCE]", false);
    public static final WordPredictionUseCase GET_CONVERSION_AND_SPELLING_IMMEDIATELY = new WordPredictionUseCase("[GET CONVERSION AND SPELLING IMMEDIATELY]", true);
    public static final WordPredictionUseCase NULL = new WordPredictionUseCase("NULL", false);
    private final String name;
    private final boolean sendsUpdateValueResponse;

    private WordPredictionUseCase(String string, boolean bl) {
        this.name = string;
        this.sendsUpdateValueResponse = bl;
    }

    public String getName() {
        return this.name;
    }

    public boolean sendsUpdateValueResponse() {
        return this.sendsUpdateValueResponse;
    }

    public String toString() {
        return new Buffer("WordPredictionUseCase [").append(this.name).append(']').toString();
    }
}

