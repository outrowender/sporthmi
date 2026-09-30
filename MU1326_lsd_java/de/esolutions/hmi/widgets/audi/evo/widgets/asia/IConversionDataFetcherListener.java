/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import java.util.List;

public interface IConversionDataFetcherListener {
    public void onConversionAvailableChange(String var1, List var2);

    public void onNextValidCharactersChange(String var1, String var2, String var3);
}

