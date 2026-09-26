/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IImageLoaderStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME;

    default public void imageLoadStart() {
    }

    default public void imageLoadEnd(String string, boolean bl) {
    }

    default public void textureCreateStart() {
    }

    default public void textureCreateEnd(String string, boolean bl, boolean bl2) {
    }
}

