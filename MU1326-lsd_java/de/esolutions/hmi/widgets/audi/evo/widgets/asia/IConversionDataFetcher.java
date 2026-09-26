/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherNull;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcherListener;

public interface IConversionDataFetcher
extends ITouchInputDataChangeHandler {
    public static final IConversionDataFetcher NULL = new ConversionDataFetcherNull();

    default public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
    }

    default public void requestInitialValidCharacters() {
    }

    default public void registerConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
    }

    default public boolean unregisterConversionFetcherListener(IConversionDataFetcherListener iConversionDataFetcherListener) {
    }

    default public void setInputMethod(AsianInputMethod asianInputMethod) {
    }
}

