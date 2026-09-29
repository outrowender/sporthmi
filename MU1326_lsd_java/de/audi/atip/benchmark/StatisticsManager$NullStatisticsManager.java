/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.AnimationStatistics;
import de.audi.atip.benchmark.IAnimationStatistics;
import de.audi.atip.benchmark.IImageLoaderStatistics;
import de.audi.atip.benchmark.IKZBStatistics;
import de.audi.atip.benchmark.IScreenStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.KZBStatistics;
import de.audi.atip.benchmark.ScreenStatistics;
import de.audi.atip.benchmark.StatisticsManager$1;

final class StatisticsManager$NullStatisticsManager
implements IStatisticsManager {
    private StatisticsManager$NullStatisticsManager() {
    }

    @Override
    public void stopGathering(String string) {
    }

    @Override
    public void startGathering(int n) {
    }

    @Override
    public IScreenStatistics getScreenStatistics() {
        return ScreenStatistics.NULL_OBJECT;
    }

    @Override
    public IAnimationStatistics getAnimationStatistics() {
        return AnimationStatistics.NULL_OBJECT;
    }

    @Override
    public IKZBStatistics getResourceLoaderStatistics() {
        return KZBStatistics.NULL_OBJECT;
    }

    @Override
    public IImageLoaderStatistics getImageLoaderStatistics() {
        return null;
    }

    /* synthetic */ StatisticsManager$NullStatisticsManager(StatisticsManager$1 statisticsManager$1) {
        this();
    }
}

