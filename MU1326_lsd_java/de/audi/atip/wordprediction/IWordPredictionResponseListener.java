/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

public interface IWordPredictionResponseListener {
    default public void updateCandidates(String[] stringArray) {
    }

    default public void updateSpelling(String string) {
    }

    default public void updateAutoConvertedCharacters(String string) {
    }

    default public void handleError(String string) {
    }
}

