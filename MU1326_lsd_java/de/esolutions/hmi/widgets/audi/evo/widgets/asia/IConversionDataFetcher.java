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

    public void requestConversions(String var1, char var2, int var3, int var4, boolean var5);

    public void requestInitialValidCharacters();

    public void registerConversionFetcherListener(IConversionDataFetcherListener var1);

    public boolean unregisterConversionFetcherListener(IConversionDataFetcherListener var1);

    public void setInputMethod(AsianInputMethod var1);
}

