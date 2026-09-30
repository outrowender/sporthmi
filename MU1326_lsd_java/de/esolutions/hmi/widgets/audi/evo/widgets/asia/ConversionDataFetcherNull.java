/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;

public class ConversionDataFetcherNull
implements IWordPredictionDataFetcher {
    public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
    }

    public void requestInitialValidCharacters() {
    }

    public void registerConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
    }

    public boolean unregisterConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
        return false;
    }

    public void touchInputDataChanged(int n, boolean bl, String string, String string2) {
    }

    public void setInputMethod(AsianInputMethod asianInputMethod) {
    }

    public void candidateSelected(int n, int n2, String string, String string2) {
    }

    public void updateWordPredictionContext(String string, String string2, int n) {
    }
}

