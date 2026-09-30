/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IStatisticsInfoProvider;

public interface IImageLoaderStatistics
extends IStatisticsInfoProvider {
    public static final String FILE_NAME = "ImageLoaderStatistics.csv";

    public void imageLoadStart();

    public void imageLoadEnd(String var1, boolean var2);

    public void textureCreateStart();

    public void textureCreateEnd(String var1, boolean var2, boolean var3);
}

