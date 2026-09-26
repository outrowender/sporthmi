/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

public interface IMediaSearchDataProviderListener {
    default public void registerProviderSourceResult(boolean bl, int n) {
    }

    default public void activateProviderSource(int n) {
    }

    default public void invalidateAllDataResult(boolean bl, int n) {
    }

    default public void provideData(int n, int n2, int n3) {
    }

    default public void storeDataSetsResult(boolean bl, int n) {
    }

    default public void deleteDataSetResult(boolean bl, int n, long l) {
    }

    default public void asyncException(int n, String string, int n2) {
    }
}

