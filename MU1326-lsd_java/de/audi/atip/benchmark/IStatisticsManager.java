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
    public static final int MASK_SCREEN_STATISTICS;
    public static final int MASK_ANIMATION_STATISTICS;
    public static final int MASK_RESOURCE_LOADER_STATISTICS;
    public static final int MASK_IMAGE_LOADER_STATISTICS;
    public static final int MASK_ALL_STATISTICS;

    default public void stopGathering(String string) {
    }

    default public void startGathering(int n) {
    }

    default public IScreenStatistics getScreenStatistics() {
    }

    default public IAnimationStatistics getAnimationStatistics() {
    }

    default public IKZBStatistics getResourceLoaderStatistics() {
    }

    default public IImageLoaderStatistics getImageLoaderStatistics() {
    }
}

