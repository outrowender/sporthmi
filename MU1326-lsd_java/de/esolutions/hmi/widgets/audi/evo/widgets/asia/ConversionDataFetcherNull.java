/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;

public class ConversionDataFetcherNull
implements IWordPredictionDataFetcher {
    @Override
    public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
    }

    @Override
    public void requestInitialValidCharacters() {
    }

    @Override
    public void registerConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
    }

    @Override
    public boolean unregisterConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
        return false;
    }

    @Override
    public void touchInputDataChanged(int n, boolean bl, String string, String string2) {
    }

    @Override
    public void setInputMethod(AsianInputMethod asianInputMethod) {
    }

    @Override
    public void candidateSelected(int n, int n2, String string, String string2) {
    }

    @Override
    public void updateWordPredictionContext(String string, String string2, int n) {
    }
}

