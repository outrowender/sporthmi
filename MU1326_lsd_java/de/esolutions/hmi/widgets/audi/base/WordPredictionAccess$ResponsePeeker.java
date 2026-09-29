/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.wordprediction.IWordPredictionResponseListener;
import de.esolutions.hmi.widgets.audi.base.WordPredictionAccess$1;

final class WordPredictionAccess$ResponsePeeker
implements IWordPredictionResponseListener {
    String spelling = "NOT EMPTY";
    String autoConvertedChars = "";

    private WordPredictionAccess$ResponsePeeker() {
    }

    boolean isEmptySpellingUpdate() {
        return "".equals(this.spelling);
    }

    boolean hasAutoConvertedCharacters() {
        return !"".equals(this.autoConvertedChars);
    }

    void reset() {
        this.spelling = "NOT EMPTY";
        this.autoConvertedChars = "";
    }

    @Override
    public void updateSpelling(String string) {
        this.spelling = string;
    }

    @Override
    public void updateCandidates(String[] stringArray) {
    }

    @Override
    public void updateAutoConvertedCharacters(String string) {
        this.autoConvertedChars = string;
    }

    @Override
    public void handleError(String string) {
    }

    /* synthetic */ WordPredictionAccess$ResponsePeeker(WordPredictionAccess$1 wordPredictionAccess$1) {
        this();
    }
}

