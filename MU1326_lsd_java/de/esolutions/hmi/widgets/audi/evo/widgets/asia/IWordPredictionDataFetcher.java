/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherNull;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;

public interface IWordPredictionDataFetcher
extends IConversionDataFetcher {
    public static final IWordPredictionDataFetcher NULL = new ConversionDataFetcherNull();

    default public void candidateSelected(int n, int n2, String string, String string2) {
    }

    default public void updateWordPredictionContext(String string, String string2, int n) {
    }
}

