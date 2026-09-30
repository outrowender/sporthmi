/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;

public class ConversionDataFetcherWordPrediction
extends AbstractConversionDataFetcher
implements IWordPredictionDataFetcher {
    private final IWordPredictionAccess wordPredictionAccess;

    public ConversionDataFetcherWordPrediction(IWordPredictionAccess iWordPredictionAccess) {
        this.wordPredictionAccess = iWordPredictionAccess;
    }

    public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
        this.wordPredictionAccess.getConversionAndSpellingImmediately(string, n + n2);
    }

    public void touchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (3 == n && bl) {
            this.wordPredictionAccess.unconvertedTextChanged(string2, string, 36);
        }
    }

    public void candidateSelected(int n, int n2, String string, String string2) {
        this.wordPredictionAccess.selectedCandidate(string, n, string2, n2);
    }

    public void updateWordPredictionContext(String string, String string2, int n) {
        this.wordPredictionAccess.startContextBasedPrediction(string, string2, n);
    }
}

