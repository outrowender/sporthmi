/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.NullWordPredictionAccess;

public interface IWordPredictionAccess {
    public static final IWordPredictionAccess NULL = new NullWordPredictionAccess();

    default public void spellerConnected(int n, String[] stringArray) {
    }

    default public void convertedAllCharactersInternally() {
    }

    default public void spellerDisconnected() {
    }

    default public void unconvertedTextChanged(String string, String string2, int n) {
    }

    default public void startContextBasedPrediction(String string, String string2, int n) {
    }

    default public void selectedCandidate(String string, int n, String string2, int n2) {
    }

    default public void getCandidates(int n) {
    }

    default public void addToUserPreference(String string, String string2) {
    }

    default public void getConversionAndSpellingImmediately(String string, int n) {
    }
}

