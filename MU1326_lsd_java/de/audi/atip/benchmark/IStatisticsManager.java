/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.IAnimationStatistics;
import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.IKZBStatistics;
import de.audi.atip.benchmark.IScreenStatistics;

public interface IStatisticsManager {
    public static final boolean INSTRUMENTATION_ENABLED = Boolean.getBoolean("EnableInstrumentation");
    public static final boolean INSTRUMENT_RES_LOADING_ON_DEMAND = Boolean.getBoolean("OnDemandResLoadingStats");
    public static final int MASK_SCREEN_STATISTICS = 1;
    public static final int MASK_ANIMATION_STATISTICS = 2;
    public static final int MASK_RESOURCE_LOADER_STATISTICS = 4;
    public static final int MASK_IMAGE_LOADER_STATISTICS = 8;
    public static final int MASK_ALL_STATISTICS = 15;

    public void stopGathering(String var1);

    public void startGathering(int var1);

    public IScreenStatistics getScreenStatistics();

    public IAnimationStatistics getAnimationStatistics();

    public IKZBStatistics getResourceLoaderStatistics();

    public IImageLoaderStatistics getImageLoaderStatistics();
}

