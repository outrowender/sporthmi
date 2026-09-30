/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherNull;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;

public interface IWordPredictionDataFetcher
extends IConversionDataFetcher {
    public static final IWordPredictionDataFetcher NULL = new ConversionDataFetcherNull();

    public void candidateSelected(int var1, int var2, String var3, String var4);

    public void updateWordPredictionContext(String var1, String var2, int var3);
}

