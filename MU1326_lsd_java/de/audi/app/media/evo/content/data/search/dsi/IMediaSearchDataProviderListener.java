/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

public interface IMediaSearchDataProviderListener {
    public void registerProviderSourceResult(boolean var1, int var2);

    public void activateProviderSource(int var1);

    public void invalidateAllDataResult(boolean var1, int var2);

    public void provideData(int var1, int var2, int var3);

    public void storeDataSetsResult(boolean var1, int var2);

    public void deleteDataSetResult(boolean var1, int var2, long var3);

    public void asyncException(int var1, String var2, int var3);
}

